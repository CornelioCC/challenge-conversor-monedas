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
        String monedaReferencia = "", monedaConversion = "";
        Monedas valorActual = new Monedas(0,0,0,0,0);
        Scanner scan = new Scanner(System.in);
        double cantidad;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!salir) {
            switch(Conversor.exhibirMenu(scan)){

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
                cantidad = -1;
                boolean devolucionValores = true;
                while(cantidad < 0) {
                    System.out.println("Ingrese la cantidad a convertir: ");
                    try {
                        cantidad = Double.valueOf(scan.nextLine());
                        if (cantidad < 0)
                            System.out.println("Cantidad no valida");
                    } catch (Exception e) {
                        System.out.println("No se ha escrito un numero");
                        cantidad = -1;
                    }
                }
                try{
                    valorActual = Conversor.obtenerValorActual(monedaReferencia, gson);
                }catch (Exception e ){
                    monedaConversion = "";
                    devolucionValores = false;
                }
                double resultadoConvertido = 0;
                switch (monedaConversion){
                    case "USD":
                        resultadoConvertido = cantidad * valorActual.usd();
                        break;
                    case "ARS":
                        resultadoConvertido = cantidad * valorActual.ars();
                        break;
                    case "BRL":
                        resultadoConvertido = cantidad * valorActual.brl();
                        break;
                    case "COP":
                        resultadoConvertido = cantidad * valorActual.cop();
                        break;
                    case "BOB":
                        resultadoConvertido = cantidad * valorActual.bob();
                        break;
                    default:
                        System.out.println("No se ha podido encontrar los valores actuales de las monedas");
                }
                if(devolucionValores)
                    System.out.println("El resultado de la conversion es que " + cantidad + " " + monedaReferencia +
                        " es igual a: " + resultadoConvertido + " " + monedaConversion);

            }






        }
    }



}

