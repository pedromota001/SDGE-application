package br.com.rondonCompany.SDGE.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApiGemini {
    private static final String API_KEY = System.getenv("GOOGLE_API_KEY");
    private static final String ENDPOINT_URL = "https://generativelanguage.googleapis.com/v1beta2/models/text-bison-001:generateText";

    public static String obterTraducao(String texto) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("prompt", texto);
            requestBody.addProperty("temperature", 0.7);
            requestBody.addProperty("maxOutputTokens", 1000);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(ENDPOINT_URL + "?key=" + API_KEY))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject responseBody = JsonParser.parseString(response.body()).getAsJsonObject();
            String gemini_texto = responseBody.getAsJsonArray("candidates")
                    .get(0)
                    .getAsJsonObject()
                    .get("output")
                    .getAsString();
            return gemini_texto;

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao obter tradução: " + e.getMessage();
        }
    }
}
