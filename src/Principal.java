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
        String monedaReferencia, monedaConversion;
        Monedas valorActual;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!salir) {
            switch(Conversor.exhibirMenu()){

                case 0:
                    salir = true;
                    break;
                case 1://USD a ARS
                    monedaReferencia = "USD";
                    monedaConversion = "ARS";
                    break;
                case 2://ARS a USD
                    monedaReferencia = "ARS";
                    monedaConversion = "USD";
                    break;
                case 3://USD a BRL
                    monedaReferencia = "USD";
                    monedaConversion = "BRL";
                    break;
                case 4://BRL a USD
                    monedaReferencia = "BRL";
                    monedaConversion = "USD";
                    break;
                case 5:// USD a COP
                    monedaReferencia = "USD";
                    monedaConversion = "COP";
                    break;
                case 6://COP a USD
                    monedaReferencia = "COP";
                    monedaConversion = "USD";
                    break;
                case 7://USD a BOB
                    monedaReferencia = "USD";
                    monedaConversion = "BOB";
                    break;
                case 8://BOB a USD
                    monedaReferencia = "BOB";
                    monedaConversion = "USD";
                    break;

            }
            if(!salir){

            }





        }
    }



}

