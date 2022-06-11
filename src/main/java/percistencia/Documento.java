package percistencia;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "documento")
@NamedQueries({
        @NamedQuery(name = "PDocumento.findAll", query = "select p from Documento p"),
        @NamedQuery(name = "PDocumento.findByNombre", query = "select p from Documento p where p.nombre = :nombre"),
        @NamedQuery(name = "PDocumento.findAllByOrderByNombreAsc", query = "select p from Documento p order by p.nombre"),
        @NamedQuery(name = "Documento.updateFechaHoraActualizacionByIdDocumento", query = "update Documento d set d.fechaHoraActualizacion = :fechaHoraActualizacion where d.idDocumento = :idDocumento")
})
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocumento", nullable = false)
    private Integer idDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "path")
    private String path;

    @Basic(optional = false)
    @Column(name = "fechaHoraActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaHoraActualizacion;

    public void insertWithEntityManager(EntityManager em, Documento documento){
        em.persist(documento);
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
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
}