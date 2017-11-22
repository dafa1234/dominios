/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvMarca.findAll", query = "SELECT e FROM EtbInvMarca e")
    , @NamedQuery(name = "EtbInvMarca.findByMarIdMarca", query = "SELECT e FROM EtbInvMarca e WHERE e.marIdMarca = :marIdMarca")
    , @NamedQuery(name = "EtbInvMarca.findByMarNomMarca", query = "SELECT e FROM EtbInvMarca e WHERE e.marNomMarca = :marNomMarca")
    , @NamedQuery(name = "EtbInvMarca.findByMarUrlSoporte", query = "SELECT e FROM EtbInvMarca e WHERE e.marUrlSoporte = :marUrlSoporte")
    , @NamedQuery(name = "EtbInvMarca.findByMarTelSoporte", query = "SELECT e FROM EtbInvMarca e WHERE e.marTelSoporte = :marTelSoporte")
    , @NamedQuery(name = "EtbInvMarca.findByMarInterventor", query = "SELECT e FROM EtbInvMarca e WHERE e.marInterventor = :marInterventor")})
public class EtbInvMarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAR_ID_MARCA")
    private Integer marIdMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "MAR_NOM_MARCA")
    private String marNomMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "MAR_URL_SOPORTE")
    private String marUrlSoporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "MAR_TEL_SOPORTE")
    private String marTelSoporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "MAR_INTERVENTOR")
    private String marInterventor;
    @OneToMany(mappedBy = "marIdMarca")
    private Collection<EtbInvServidor> etbInvServidorCollection;

    public EtbInvMarca() {
    }

    public EtbInvMarca(Integer marIdMarca) {
        this.marIdMarca = marIdMarca;
    }

    public EtbInvMarca(Integer marIdMarca, String marNomMarca, String marUrlSoporte, String marTelSoporte, String marInterventor) {
        this.marIdMarca = marIdMarca;
        this.marNomMarca = marNomMarca;
        this.marUrlSoporte = marUrlSoporte;
        this.marTelSoporte = marTelSoporte;
        this.marInterventor = marInterventor;
    }

    public Integer getMarIdMarca() {
        return marIdMarca;
    }

    public void setMarIdMarca(Integer marIdMarca) {
        this.marIdMarca = marIdMarca;
    }

    public String getMarNomMarca() {
        return marNomMarca;
    }

    public void setMarNomMarca(String marNomMarca) {
        this.marNomMarca = marNomMarca;
    }

    public String getMarUrlSoporte() {
        return marUrlSoporte;
    }

    public void setMarUrlSoporte(String marUrlSoporte) {
        this.marUrlSoporte = marUrlSoporte;
    }

    public String getMarTelSoporte() {
        return marTelSoporte;
    }

    public void setMarTelSoporte(String marTelSoporte) {
        this.marTelSoporte = marTelSoporte;
    }

    public String getMarInterventor() {
        return marInterventor;
    }

    public void setMarInterventor(String marInterventor) {
        this.marInterventor = marInterventor;
    }

    @XmlTransient
    public Collection<EtbInvServidor> getEtbInvServidorCollection() {
        return etbInvServidorCollection;
    }

    public void setEtbInvServidorCollection(Collection<EtbInvServidor> etbInvServidorCollection) {
        this.etbInvServidorCollection = etbInvServidorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marIdMarca != null ? marIdMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvMarca)) {
            return false;
        }
        EtbInvMarca other = (EtbInvMarca) object;
        if ((this.marIdMarca == null && other.marIdMarca != null) || (this.marIdMarca != null && !this.marIdMarca.equals(other.marIdMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvMarca[ marIdMarca=" + marIdMarca + " ]";
    }
    
}
