package clases;

public class Posteo {

    private static double denomPeso = 0;
    private Vocabulario palabra;
    private Documento documento;
    private int frecuencia;
    private double peso;

    public Posteo(Vocabulario palabra, Documento documento) {
        this.palabra = palabra;
        this.documento = documento;
        this.frecuencia = 1;
        Posteo.denomPeso += Math.log((double) Documento.cantidadDocumentos / palabra.getCantDocumentos());
        this.peso = 0;
    }

    public Posteo(Vocabulario palabra, Documento documento, int frecuencia) {
        this.palabra = palabra;
        this.documento = documento;
        this.frecuencia = frecuencia;
        Posteo.denomPeso += Math.pow(Math.log((double) Documento.cantidadDocumentos / palabra.getCantDocumentos()), 2);
        this.peso = 0;
    }

    public Vocabulario getPalabra() {
        return palabra;
    }

    public void setPalabra(Vocabulario palabra) {
        this.palabra = palabra;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public static double getDenomPeso() {
        double x = Math.sqrt(denomPeso);
        return x;
    }

    public void calcularPeso(){
        double x = this.frecuencia;
        x *= (Math.log((double) (Documento.cantidadDocumentos / palabra.getCantDocumentos())));
        x /= Math.sqrt(denomPeso);

        this.peso = x;
    }

    public double suma(int N, int n){
        return frecuencia * Math.log((double) N/n);
    }

    @Override
    public String toString() {
        return  "vocabulario: " + palabra.getPalabra() +
                ", documento: " + documento.getNombre() +
                ", frecuencia: " + frecuencia +
                ", peso: " + peso ;
    }
}
