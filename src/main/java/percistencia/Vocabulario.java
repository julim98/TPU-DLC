package percistencia;

import jakarta.persistence.*;

@Entity
@Table(name = "vocabulario")
@NamedQueries({
        @NamedQuery(name = "PVocabulario.findAll", query = "select p from Vocabulario p"),
        @NamedQuery(name = "PVocabulario.findAllByOrderByPalabra", query = "select p from Vocabulario p order by p.palabra"),
        @NamedQuery(name = "PVocabulario.findByIdPalabra", query = "select p from Vocabulario p where p.idPalabra = :idPalabra"),
        @NamedQuery(name = "PVocabulario.findByPalabra", query = "select p from Vocabulario p where p.palabra = :palabra"),
        @NamedQuery(name = "PVocabulario.updateCantDocumentosByIdPalabra", query = "update Vocabulario p set p.cantDocumentos = :cantDocumentos where p.idPalabra = :idPalabra"),
        @NamedQuery(name = "Vocabulario.updateMaxFrecuenciaPalabraByIdPalabra", query = "update Vocabulario v set v.maxFrecuenciaPalabra = :maxFrecuenciaPalabra where v.idPalabra = :idPalabra"),
        @NamedQuery(name = "PVocabulario.updateCantDocumentosAndMaxFrecuenciaPalabraByIdPalabra", query = "update Vocabulario p set p.cantDocumentos = :cantDocumentos, p.maxFrecuenciaPalabra = :maxFrecuenciaPalabra where p.idPalabra = :idPalabra")
})
public class Vocabulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPalabra", nullable = false)
    private Integer idPalabra;

    @Basic(optional = false)
    @Column(name = "palabra")
    private String palabra;

    @Basic(optional = false)
    @Column(name = "cantDocumentos")
    private Integer cantDocumentos;

    @Basic(optional = false)
    @Column(name = "maxFrecuenciaPalabra")
    private Integer maxFrecuenciaPalabra;

    public void insertWithEntityManager(EntityManager em, Vocabulario vocabulario){
        em.persist(vocabulario);
    }

    public Integer getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
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