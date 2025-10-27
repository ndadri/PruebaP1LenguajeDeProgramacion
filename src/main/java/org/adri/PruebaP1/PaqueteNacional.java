package org.adri.PruebaP1;

public class PaqueteNacional extends Paquete{
    private String zona;
// creamos un constructor para que traiga los atributos de "paquete"
    public PaqueteNacional(double peso, double largo, double alto, double ancho, String Contenido, String Zona) {
        super(peso, largo, alto, ancho);

        this.zona = Zona;

        //realizamos la condicion para que solo se pueda ingresar por teclado lo pedido
        if (!(zona.equals("COSTA") ||
                zona.equals("SIERRA") ||
                zona.equals("ORIENTE") ||
                zona.equals("GALAPAGOS"))) {
            throw new IllegalArgumentException("Zona inválida. Debe ser: COSTA, SIERRA, ORIENTE o GALAPAGOS");
        }
        this.contenido = Contenido;
    }

    public double calcularCosto() {
        double costo = 3.00 + (1.20 * getPeso());

        if (zona.equals("ORIENTE")) {
            costo += 2.00;
        } else if (zona.equals("GALAPAGOS")) {
            costo += 6.00;
        }

        costo += recargoVolumetrico();
        return costo;
    }
    public String getZona() {
        return zona;
    }
}
