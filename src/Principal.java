import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        boolean salir = false;

        while(salir) {
            switch(Conversor.exhibirMenu()){



            }


            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();
            String moneda = "";
            String direccion = "https://v6.exchangerate-api.com/v6/45e0bffdd499c250b1c92642/latest/ARS" + moneda;

            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String jsonEntero = response.body();
                Map<String, String> stringMapCompleto = gson.fromJson(jsonEntero, Map.class);
                String jsonMonedas = String.valueOf(stringMapCompleto.values().toArray()[stringMapCompleto.size() - 1]);
                Monedas valoresActuales = gson.fromJson(jsonMonedas, Monedas.class);
                System.out.println(valoresActuales);


            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}

