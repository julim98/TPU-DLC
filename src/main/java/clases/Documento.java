package clases;


import java.util.Date;

public class Documento {

    private int idDocumento;
    private String nombre;
    private String path;
    private Date fechaHoraActualizacion;


    public Documento(String nombre, String path, Date fechaHoraActualizacion) {
        this(nombre.hashCode(), nombre, path, fechaHoraActualizacion);
    }

    public Documento(int idDocumento, String nombre, String path, Date fechaHoraActualizacion) {
        this.idDocumento = idDocumento;
        this.nombre = nombre;
        this.path = path;
        this.fechaHoraActualizacion = fechaHoraActualizacion;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
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

    public Date getFechaHoraActualizacion() {
        return fechaHoraActualizacion;
    }

    public void setFechaHoraActualizacion(Date fechaHoraActualizacion) {
        this.fechaHoraActualizacion = fechaHoraActualizacion;
    }

    @Override
    public String toString() {
        return "nombre: '" + nombre + '\'' +
                ", path: '" + path;
    }
}
