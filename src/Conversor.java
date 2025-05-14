import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Conversor {
    public static int exhibirMenu(Scanner scan){
        int seleccion = -1;
        while (!(seleccion >= 0 && seleccion <= 8)) {
            System.out.println("""
                    *****************************************************
                    Sea bienvenido/a al Conversor de Moneda =]
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Dólar =>> Peso boliviano
                    8) Peso boliviano =>> Dólar
                    0) Salir
                    
                    *****************************************************
                    
                    Elija una opcion válida: 
                    
                    """);

            try {
                seleccion = Integer.valueOf(scan.nextLine());
                if (seleccion > 8 || seleccion < 0) {
                    System.out.println("Opcion no valida");
                    seleccion = -1;
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida");
                seleccion = -1;
            }
        }
        return seleccion;
    }
    public static Monedas obtenerValorActual(String monedaElegida, Gson traductorJson){

        String direccion = "https://v6.exchangerate-api.com/v6/45e0bffdd499c250b1c92642/latest/ARS" + monedaElegida;

        Monedas valoresActuales = new Monedas(1,1,1,1,1);

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonEntero = response.body();
            Map<String, String> stringMapCompleto = traductorJson.fromJson(jsonEntero, Map.class);
            String jsonMonedas = String.valueOf(stringMapCompleto.values().toArray()[stringMapCompleto.size() - 1]);
            valoresActuales = traductorJson.fromJson(jsonMonedas, Monedas.class);


        } catch (IllegalArgumentException e) {
            System.out.println("Error en la URI, verifique la dirección.");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return valoresActuales;
    }
}

