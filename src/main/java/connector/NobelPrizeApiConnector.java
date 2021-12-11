package connector;

import org.json.JSONObject;
import prizecomponents.Laureate;

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
    private static final String URL = "api.nobelprize.org/2.0/";

public List<Laureate> getLaureate(String name) {
    List<Laureate> laureates = new ArrayList<>();
    try {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(URL + "laureates?name=wilhelm"))
                .GET()
                .build();


        HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(httpResponse.body());
        jsonObject.getJSONArray("laureates").forEach(s -> {

            Laureate laureate = new Laureate();

            laureate.setFullName(jsonObject.getJSONObject("fullName").
                    getString("en"));

            laureate.setId(jsonObject.getInt("id"));

            laureate.setDateOfBirth(jsonObject.getJSONObject("birth").
                    getString("date"));

            laureate.setLocation(jsonObject.getJSONObject("birth").
                    getJSONObject("place").getJSONObject("locationString").
                    getString("en"));

            laureate.setDateOfDeath(jsonObject.getJSONObject("death").
                    getString("date"));



            laureates.add(laureate);
        });

        System.out.println(laureates);

    } catch (URISyntaxException | InterruptedException | IOException e) {
        e.printStackTrace();
    }

    return laureate;
}
}
