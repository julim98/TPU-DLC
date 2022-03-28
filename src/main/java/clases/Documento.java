package clases;

public class Documento {

    private String path;
    private String nombre;


    public Documento(String path, String nombre) {
        this.path = path;
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  "path: '" + path + '\'' +
                ", nombre: '" + nombre + '\'';
    }
}
