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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_estado_cont")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvEstadoCont.findAll", query = "SELECT e FROM EtbInvEstadoCont e")
    , @NamedQuery(name = "EtbInvEstadoCont.findByEstcoId", query = "SELECT e FROM EtbInvEstadoCont e WHERE e.estcoId = :estcoId")
    , @NamedQuery(name = "EtbInvEstadoCont.findByEstcoDescrip", query = "SELECT e FROM EtbInvEstadoCont e WHERE e.estcoDescrip = :estcoDescrip")})
public class EtbInvEstadoCont implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTCO_ID")
    private Integer estcoId;
    @Size(max = 255)
    @Column(name = "ESTCO_DESCRIP")
    private String estcoDescrip;
    @OneToMany(mappedBy = "contEstado")
    private Collection<EtbInvContrato> etbInvContratoCollection;

    public EtbInvEstadoCont() {
    }

    public EtbInvEstadoCont(Integer estcoId) {
        this.estcoId = estcoId;
    }

    public Integer getEstcoId() {
        return estcoId;
    }

    public void setEstcoId(Integer estcoId) {
        this.estcoId = estcoId;
    }

    public String getEstcoDescrip() {
        return estcoDescrip;
    }

    public void setEstcoDescrip(String estcoDescrip) {
        this.estcoDescrip = estcoDescrip;
    }

    @XmlTransient
    public Collection<EtbInvContrato> getEtbInvContratoCollection() {
        return etbInvContratoCollection;
    }

    public void setEtbInvContratoCollection(Collection<EtbInvContrato> etbInvContratoCollection) {
        this.etbInvContratoCollection = etbInvContratoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estcoId != null ? estcoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvEstadoCont)) {
            return false;
        }
        EtbInvEstadoCont other = (EtbInvEstadoCont) object;
        if ((this.estcoId == null && other.estcoId != null) || (this.estcoId != null && !this.estcoId.equals(other.estcoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvEstadoCont[ estcoId=" + estcoId + " ]";
    }
    
}
