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
@Table(name = "etb_inv_estado_mto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvEstadoMto.findAll", query = "SELECT e FROM EtbInvEstadoMto e")
    , @NamedQuery(name = "EtbInvEstadoMto.findByEstmId", query = "SELECT e FROM EtbInvEstadoMto e WHERE e.estmId = :estmId")
    , @NamedQuery(name = "EtbInvEstadoMto.findByEstmEstado", query = "SELECT e FROM EtbInvEstadoMto e WHERE e.estmEstado = :estmEstado")})
public class EtbInvEstadoMto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTM_ID")
    private Integer estmId;
    @Size(max = 255)
    @Column(name = "ESTM_ESTADO")
    private String estmEstado;
    @OneToMany(mappedBy = "croEstado")
    private Collection<EtbInvCronogramaMto> etbInvCronogramaMtoCollection;

    public EtbInvEstadoMto() {
    }

    public EtbInvEstadoMto(Integer estmId) {
        this.estmId = estmId;
    }

    public Integer getEstmId() {
        return estmId;
    }

    public void setEstmId(Integer estmId) {
        this.estmId = estmId;
    }

    public String getEstmEstado() {
        return estmEstado;
    }

    public void setEstmEstado(String estmEstado) {
        this.estmEstado = estmEstado;
    }

    @XmlTransient
    public Collection<EtbInvCronogramaMto> getEtbInvCronogramaMtoCollection() {
        return etbInvCronogramaMtoCollection;
    }

    public void setEtbInvCronogramaMtoCollection(Collection<EtbInvCronogramaMto> etbInvCronogramaMtoCollection) {
        this.etbInvCronogramaMtoCollection = etbInvCronogramaMtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estmId != null ? estmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvEstadoMto)) {
            return false;
        }
        EtbInvEstadoMto other = (EtbInvEstadoMto) object;
        if ((this.estmId == null && other.estmId != null) || (this.estmId != null && !this.estmId.equals(other.estmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvEstadoMto[ estmId=" + estmId + " ]";
    }
    
}
