package org.adri.PruebaP1;

public class Paquete {
    protected double peso; //este sera en KG
    protected double largo; //este sera en CM
    protected double alto; //este sera en CM
    protected double ancho; //este sera en CM
    protected String contenido; //no puede ser vacio o nulo


    //Realizamos el constructor
    public Paquete(double peso, double largo, double alto, double ancho) {
    if (peso < 0.01 || peso > 50.0) {
        //IllegalArgument es para que nos muestre el mensaje cuando no se cumpla la condicion
        //Que se realiza en cada una de las condiciones
        IllegalArgumentException erro = new IllegalArgumentException("Peso invalido");
        throw erro;
    }
    if (largo < 1 || largo > 200) {
        IllegalArgumentException erro = new IllegalArgumentException("Largo fuera de rango");
    }
    if (alto < 1 || alto > 200) {
        IllegalArgumentException erro = new IllegalArgumentException("Alto fuera de rango");
    }
    if (ancho < 1 || ancho > 200) {
        IllegalArgumentException erro = new IllegalArgumentException("Ancho fuera de rango");
    }
    if (contenido == null) {
        IllegalArgumentException erro = new IllegalArgumentException("Contenido !NO! puede ser vacio");
    }
    }

    //Metodos Getter que son publicos para todos los atributos
    public double getPeso() {
        return peso;
    }
    public double getLargo() {
        return largo;
    }
    public double getAlto() {
        return alto;
    }
    public double getAncho() {
        return ancho;
    }
    public String getContenido() {
        return contenido;
    }

    public final double volumenLitros() {
        return (largo * ancho * peso)/1000.0;
    }
    protected double recargoVolumetrico() {
        if (volumenLitros() == 100)
            return 5.0;
        else
            return 0.0;
    }
    public String resumen() {
    return Paquete.class.getName();
    }
}
