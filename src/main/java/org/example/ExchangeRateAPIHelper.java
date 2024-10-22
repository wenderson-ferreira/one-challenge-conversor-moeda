package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jdi.Value;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateAPIHelper {

    private static final String apiKey = "*******KEY**********";
    private static final String badePath = String.format("https://v6.exchangerate-api.com/v6/%s/pair", apiKey);


    public static void convert(String base, String target, Double amount){
        try{
            // Setting URL
            String urlPath = badePath + "/" + base + "/" + target + "/" + amount;

            URL url = new URL(urlPath);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            Double result = jsonobj.get("conversion_result").getAsDouble();

            String response = String.format("O valor %.4f [%s] corresponde ao valor final de =>>> %.4f [%s]",
                    amount, base, result, target);

            System.out.println(response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
