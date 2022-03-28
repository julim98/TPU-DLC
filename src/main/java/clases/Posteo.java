package clases;

public class Posteo {

    private int frecuencia;
    private double peso;

    public Posteo(int frecuencia, float peso) {
        this.frecuencia = frecuencia;
        this.peso = peso;
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

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void calcularPeso(int N, int n){
        this.peso = ((this.frecuencia * Math.log((double) N/n))/(Math.sqrt(Math.pow(suma(N, n), 2))));
    }

    public double suma(int N, int n){
        return frecuencia * Math.log((double) N/n);
    }
}
