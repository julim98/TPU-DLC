package clases;

public class Vocabulario {

    private int id_palabra;
    private String palabra;
    private int cantDocumentos;
    private int maxFrecuenciaPalabra;

    public Vocabulario(Vocabulario voc) {
        this.palabra = voc.getPalabra();
        this.cantDocumentos = voc.getCantDocumentos();
        this.maxFrecuenciaPalabra = voc.getMaxFrecuenciaPalabra();
    }

    public Vocabulario(String palabra) {
        this.palabra = palabra;
        this.cantDocumentos = 1;
        this.maxFrecuenciaPalabra = 1;
    }

    public Vocabulario(int id_palabra, String palabra, int cantDocumentos, int maxFrecuenciaPalabra) {
        this.id_palabra = id_palabra;
        this.palabra = palabra;
        this.cantDocumentos = cantDocumentos;
        this.maxFrecuenciaPalabra = maxFrecuenciaPalabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getCantDocumentos() {
        return cantDocumentos;
    }

    public void setCantDocumentos(int cantDocumentos) {
        this.cantDocumentos = cantDocumentos;
    }

    public int getMaxFrecuenciaPalabra() {
        return maxFrecuenciaPalabra;
    }

    public void setMaxFrecuenciaPalabra(int maxFrecuenciaPalabra) {
        this.maxFrecuenciaPalabra = maxFrecuenciaPalabra;
    }

    public void increaseCantDoc(){
        this.cantDocumentos++;
    }

    public void increaseMaxFrec(){
        this.maxFrecuenciaPalabra++;
    }

    @Override
    public String toString() {
        return  "palabra: '" + palabra + '\'' +
                ", cantDocumentos: " + cantDocumentos +
                ", maxFrecuenciaPalabra: " + maxFrecuenciaPalabra;
    }
}
