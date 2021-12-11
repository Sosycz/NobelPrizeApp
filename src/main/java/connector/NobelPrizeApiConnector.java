package connector;

import org.json.JSONObject;
import prizecomponents.Laureate;
import prizecomponents.Prize;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class NobelPrizeApiConnector {
    private static final String URL = "http://api.nobelprize.org/2.0/";

    public List<Laureate> getLaureate(String name) {
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

                laureate.setDateOfDeath(((JSONObject) s).getJSONObject("death").
                        getString("date"));

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

//    public List<Laureate> getLaureatesFromYear(int year) {
//
//    }

}
