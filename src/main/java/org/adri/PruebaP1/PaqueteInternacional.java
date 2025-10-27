package org.adri.PruebaP1;

public class PaqueteInternacional extends Paquete {

    private String region;

    public PaqueteInternacional(double peso, double largo, double ancho, double alto,
                                String contenido, String region) {
        super(peso, largo, ancho, alto);

        // Validar peso máximo
        if (peso > 30)
            throw new IllegalArgumentException("El peso máximo para envíos internacionales es 30 kg.");

        // Validar región (acepta minúsculas y mayúsculas)
        if (!esRegionValida(region))
            throw new IllegalArgumentException("Region inválida. Debe ser: LATAM, NORTH_AMERICA, EUROPE, ASIA, OCEANIA");

        this.region = region.trim();
    }

    private boolean esRegionValida(String region) {
        return region != null && (
                region.equalsIgnoreCase("LATAM") ||
                        region.equalsIgnoreCase("NORTH_AMERICA") ||
                        region.equalsIgnoreCase("EUROPE") ||
                        region.equalsIgnoreCase("ASIA") ||
                        region.equalsIgnoreCase("OCEANIA")
        );
    }

    public double calcularCosto() {
        double costo = 10.00 + (2.50 * getPeso());
        String contenido = getContenido();

        // Arancel por tipo de contenido
        if (contenido.equalsIgnoreCase("DOCUMENTOS")) costo += 0;
        else if (contenido.equalsIgnoreCase("ELECTRONICA")) costo += 8;
        else if (contenido.equalsIgnoreCase("TEXTILES")) costo += 4;
        else costo += 6;

        // Recargo por región
        if (region.equalsIgnoreCase("LATAM")) costo += 5;
        else if (region.equalsIgnoreCase("EUROPE") || region.equalsIgnoreCase("NORTH_AMERICA")) costo += 8;
        else costo += 12;

        costo += recargoVolumetrico();
        return costo;
    }

    public String getRegion() {
        return region;
    }
}
