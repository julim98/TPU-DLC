public class Vocabulario {

    private String palabra;
    private int cantDocumentos;
    private int maxFrecuenciaPalabra;

    public Vocabulario(String palabra, int cantDocumentos, int maxFrecuenciaPalabra) {
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
}
