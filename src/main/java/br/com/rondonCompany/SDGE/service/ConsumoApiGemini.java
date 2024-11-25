package br.com.rondonCompany.SDGE.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApiGemini {
    private static final String API_KEY = "AIzaSyCf51UtIZouFZezE-ll1qPj89pXT__NIoI";
    private static final String ENDPOINT_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";

    public static String obter_texto_prompt(String texto) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            JsonObject requestBody = new JsonObject();
            JsonArray contentsArray = new JsonArray();
            JsonObject partsObject = new JsonObject();
            JsonArray partsArray = new JsonArray();

            String textoComInstrução = texto + " Por favor, responda em português.";
            partsObject.addProperty("text", textoComInstrução);
            partsArray.add(partsObject);

            JsonObject contentObject = new JsonObject();
            contentObject.add("parts", partsArray);
            contentsArray.add(contentObject);

            requestBody.add("contents", contentsArray);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(ENDPOINT_URL + "?key=" + API_KEY))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject responseBody = JsonParser.parseString(response.body()).getAsJsonObject();

            String geminiText = responseBody.getAsJsonArray("candidates")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("content")
                    .getAsJsonArray("parts")
                    .get(0)
                    .getAsJsonObject()
                    .get("text")
                    .getAsString();
            System.out.println(geminiText);
            return geminiText;

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao obter texto de ajuda: " + e.getMessage();
        }
    }
}
