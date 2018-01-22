/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_central")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvCentral.findAll", query = "SELECT e FROM EtbInvCentral e")
    , @NamedQuery(name = "EtbInvCentral.findByCenIdCentral", query = "SELECT e FROM EtbInvCentral e WHERE e.cenIdCentral = :cenIdCentral")
    , @NamedQuery(name = "EtbInvCentral.findByCenNombre", query = "SELECT e FROM EtbInvCentral e WHERE e.cenNombre = :cenNombre")})
public class EtbInvCentral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CEN_ID_CENTRAL")
    private Integer cenIdCentral;
    @Size(max = 25)
    @Column(name = "CEN_NOMBRE")
    private String cenNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cenIdCentral")
    private Collection<EtbInvServidor> etbInvServidorCollection;

    public EtbInvCentral() {
    }

    public EtbInvCentral(Integer cenIdCentral) {
        this.cenIdCentral = cenIdCentral;
    }

    public Integer getCenIdCentral() {
        return cenIdCentral;
    }

    public void setCenIdCentral(Integer cenIdCentral) {
        this.cenIdCentral = cenIdCentral;
    }

    public String getCenNombre() {
        return cenNombre;
    }

    public void setCenNombre(String cenNombre) {
        this.cenNombre = cenNombre;
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
        hash += (cenIdCentral != null ? cenIdCentral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvCentral)) {
            return false;
        }
        EtbInvCentral other = (EtbInvCentral) object;
        if ((this.cenIdCentral == null && other.cenIdCentral != null) || (this.cenIdCentral != null && !this.cenIdCentral.equals(other.cenIdCentral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvCentral[ cenIdCentral=" + cenIdCentral + " ]";
    }
    
}
