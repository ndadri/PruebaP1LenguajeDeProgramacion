package org.adri.PruebaP1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("PAQUETERÍA ANDINA S.A.");

            // 1️⃣ Paquete Nacional
            Paquete p1 = new PaqueteNacional(5.5, 30, 20, 10, "Libros", "SIERRA");

            // 2️⃣ Paquete Nacional hacia GALÁPAGOS
            Paquete p2 = new PaqueteNacional(2.0, 50, 40, 20, "Ropa", "GALAPAGOS");

            // 3️⃣ Paquete Internacional hacia EUROPE
            Paquete p3 = new PaqueteInternacional(10.0, 40, 40, 40, "Electronica", "EUROPE");

            // Mostrar resúmenes (Polimorfismo)
            System.out.println("\nRESÚMENES");
            System.out.println(p1.resumen());
            System.out.println(p2.resumen());
            System.out.println(p3.resumen());

            // 4️⃣ Intentar crear paquete de 35 kg (debe fallar)
            try {
                System.out.println("\nIntentando crear paquete internacional de 35 kg...");
                Paquete p4 = new PaqueteInternacional(35, 30, 30, 30, "Textiles", "LATAM");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }


        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }

        sc.close();
    }
}