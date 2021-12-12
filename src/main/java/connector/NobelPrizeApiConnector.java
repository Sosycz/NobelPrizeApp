package connector;

import jdk.jfr.Category;
import org.json.JSONArray;
import org.json.JSONObject;
import prizecomponents.Laureate;
import prizecomponents.Prize;
import prizecomponents.PrizeCategory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NobelPrizeApiConnector {
    private static final String URL = "http://api.nobelprize.org/2.0/";

    public List<Laureate> getLaureate(String name) {
        name = name.replaceAll(" ", "%20");
        List<Laureate> laureates = new ArrayList<>();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "laureates?name=" + name))
                    .GET()
                    .build();


            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonObject = new JSONObject(httpResponse.body());
            jsonObject.getJSONArray("laureates").forEach(s -> {

                Laureate laureate = new Laureate();

                laureate.setFullName(((JSONObject) s).getJSONObject("fullName").
                        getString("en"));

                laureate.setId(Integer.parseInt(((JSONObject) s).
                        getString("id")));


                laureate.setDateOfBirth(((JSONObject) s).
                        getJSONObject("birth").
                        getString("date"));

                laureate.setLocation(((JSONObject) s).
                        getJSONObject("birth").
                        getJSONObject("place").
                        getJSONObject("locationString").
                        getString("en"));
                if(((JSONObject) s).has("death")) {
                    laureate.setDateOfDeath(((JSONObject) s).getJSONObject("death").
                            getString("date"));
                }

                 ((JSONObject) s).getJSONArray("nobelPrizes").forEach(p -> {
                    Prize prize = new Prize();

                    prize.setCategory(((JSONObject) p).getJSONObject("category").
                            getString("en"));

                    prize.setDateAwarded(((JSONObject) p).getString("awardYear"));

                    prize.setPrizeMotivation(((JSONObject) p).getJSONObject("motivation").getString("en"));

                    prize.setPrizeAmountObtained(((JSONObject) p).getBigDecimal("prizeAmount"));

                    prize.setPrizeAmountAdjusted(((JSONObject) p).getBigDecimal("prizeAmountAdjusted"));
                    laureate.getPrizeList().add(prize);

                });


                laureates.add(laureate);
            });

            System.out.println(laureates);

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return laureates;
    }

    public List<Laureate> getLaureatesFromYear(int year) {

        List<Laureate> laureates = new ArrayList<>();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "laureates?nobelPrizeYear=" + year))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonObject = new JSONObject(httpResponse.body());
            NobelPrizeApiConnector nobelPrizeApiConnector = new NobelPrizeApiConnector();

            jsonObject.getJSONArray("laureates").forEach(l -> {
                String name = ((JSONObject) l).getJSONObject("fullName").getString("en");

                laureates.addAll(nobelPrizeApiConnector.getLaureate(name));
            });


        } catch (URISyntaxException | IOException |InterruptedException e) {
            e.printStackTrace();
        }


    return laureates;
    }
    public List<Laureate> getLaureatesFromYear(int year, PrizeCategory category) {

        List<Laureate> laureates = new ArrayList<>();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "nobelPrize/" + category.toString().toLowerCase() + "/" + year))
                    .GET()
                    .build();
            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONArray jsonArray = new JSONArray(httpResponse.body());
            NobelPrizeApiConnector nobelPrizeApiConnector = new NobelPrizeApiConnector();
            int i = 0;
            jsonArray.forEach(l -> {
                ((JSONObject) l).getJSONArray("laureates").forEach(laureate-> {

                    String name = ((JSONObject)laureate).getJSONObject("knownName")
                                    .getString("en");
                    laureates.addAll(nobelPrizeApiConnector.getLaureate(name));
                });
            });


        } catch (URISyntaxException | IOException |InterruptedException e) {
            e.printStackTrace();
        }


        return laureates;
    }

}
