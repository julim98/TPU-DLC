package clases;

public class Posteo {

    private Vocabulario palabra;
    private Documento documento;
    private int frecuencia;
    private double peso;

    public Posteo(Vocabulario palabra, Documento documento) {
        this.palabra = palabra;
        this.documento = documento;
        this.frecuencia = 1;
        this.peso = 0;
    }

    public Posteo(Vocabulario palabra, Documento documento, int frecuencia) {
        this.palabra = palabra;
        this.documento = documento;
        this.frecuencia = frecuencia;
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

    public void calcularPeso(int N, int n){

        this.peso = ((this.frecuencia * Math.log((double) N/n))/(Math.sqrt(Math.pow(suma(N, n), 2))));
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
