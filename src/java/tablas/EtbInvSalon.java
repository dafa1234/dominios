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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "etb_inv_salon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvSalon.findAll", query = "SELECT e FROM EtbInvSalon e")
    , @NamedQuery(name = "EtbInvSalon.findBySalIdSalon", query = "SELECT e FROM EtbInvSalon e WHERE e.salIdSalon = :salIdSalon")
    , @NamedQuery(name = "EtbInvSalon.findBySalNombre", query = "SELECT e FROM EtbInvSalon e WHERE e.salNombre = :salNombre")})
public class EtbInvSalon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SAL_ID_SALON")
    private Integer salIdSalon;
    @Size(max = 25)
    @Column(name = "SAL_NOMBRE")
    private String salNombre;
    @JoinColumn(name = "SAL_CENTRAL", referencedColumnName = "CEN_ID_CENTRAL")
    @ManyToOne
    private EtbInvCentral salCentral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salIdSalon")
    private Collection<EtbInvServidor> etbInvServidorCollection;

    public EtbInvSalon() {
    }

    public EtbInvSalon(Integer salIdSalon) {
        this.salIdSalon = salIdSalon;
    }

    public Integer getSalIdSalon() {
        return salIdSalon;
    }

    public void setSalIdSalon(Integer salIdSalon) {
        this.salIdSalon = salIdSalon;
    }

    public String getSalNombre() {
        return salNombre;
    }

    public void setSalNombre(String salNombre) {
        this.salNombre = salNombre;
    }

    public EtbInvCentral getSalCentral() {
        return salCentral;
    }

    public void setSalCentral(EtbInvCentral salCentral) {
        this.salCentral = salCentral;
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
        hash += (salIdSalon != null ? salIdSalon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvSalon)) {
            return false;
        }
        EtbInvSalon other = (EtbInvSalon) object;
        if ((this.salIdSalon == null && other.salIdSalon != null) || (this.salIdSalon != null && !this.salIdSalon.equals(other.salIdSalon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvSalon[ salIdSalon=" + salIdSalon + " ]";
    }
    
}
