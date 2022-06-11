package percistencia;

import jakarta.persistence.*;

@Entity
@Table(name = "posteo")
@NamedQueries({

        @NamedQuery(name = "Posteo.findAll", query = "select p from Posteo p"),
        @NamedQuery(name = "Posteo.findByIdVocabulario", query = "select p from Posteo p where p.vocabulario.idPalabra = :idPalabra"),
        @NamedQuery(name = "Posteo.updateFrecPalabraByIdVocabularioAndIdDocumento", query = "update Posteo p set p.frecPalabra = :frecPalabra where p.vocabulario.idPalabra = :idPalabra and p.documento.idDocumento = :idDocumento"),
        @NamedQuery(name = "Posteo.updatePesoByIdVocabularioAndIdDocumento", query = "update Posteo p set p.peso = :peso where p.vocabulario.idPalabra = :idPalabra and p.documento.idDocumento = :idDocumento"),
        @NamedQuery(name = "Posteo.updateFrecPalabraAndPesoByIdDocumento", query = "update Posteo p set p.frecPalabra = :frecPalabra, p.peso = :peso where p.documento.idDocumento = :idDocumento"),
        @NamedQuery(name = "Posteo.deleteByIdDocumento", query = "delete from Posteo p where p.documento = :idDocumento"),
        @NamedQuery(name = "Posteo.deleteByIdVocabularioAndIdDocumento", query = "delete from Posteo p where p.vocabulario.idPalabra = :idPalabra and p.documento.idDocumento = :idDocumento"),
        @NamedQuery(name = "Posteo.countByIdVocabulario", query = "select count(p) from Posteo p where p.vocabulario.idPalabra = :idPalabra"),
        @NamedQuery(name = "Posteo.countByIdDocumento", query = "select count(p) from Posteo p where p.documento.idDocumento = :idDocumento")
})
public class Posteo {

    @Id
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "idVocabulario", referencedColumnName = "idPalabra")
    private Vocabulario vocabulario;

    @Id
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "idDocumento", referencedColumnName = "idDocumento")
    private Documento documento;

    @Basic(optional = false)
    @Column(name = "frecPalabra")
    private int frecPalabra;

    @Basic(optional = false)
    @Column(name = "peso")
    private int peso;

    public void insertWithEntityManager(EntityManager em, Posteo posteo){
        em.persist(posteo);
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Vocabulario getVocabulario() {
        return vocabulario;
    }

    public void setVocabulario(Vocabulario vocabulario) {
        this.vocabulario = vocabulario;
    }

    public int getFrecPalabra() {
        return frecPalabra;
    }

    public void setFrecPalabra(int frecPalabra) {
        this.frecPalabra = frecPalabra;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}