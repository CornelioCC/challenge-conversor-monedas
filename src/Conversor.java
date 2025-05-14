import java.util.Scanner;

public class Conversor {
    public static int exhibirMenu(){
        int seleccion = -1;
        Scanner scan = new Scanner(System.in);
        while (seleccion != 0) {
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
                    9) Peso colombiano =>> Dólar
                    0) Salir
                    
                    *****************************************************
                    
                    Elija una opcion válida: 
                    
                    """);

            try {
                seleccion = Integer.valueOf(scan.nextLine());
                if (seleccion > 9 || seleccion < 0) {
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
}

