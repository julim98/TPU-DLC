package clases;

public class Documento {

    private String nombre;
    private String path;


    public Documento(String nombre, String path) {
        this.path = path;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public String toString() {
        return "nombre: '" + nombre + '\'' +
                ", path: '" + path;
    }
}
