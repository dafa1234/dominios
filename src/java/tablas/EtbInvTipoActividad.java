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
@Table(name = "etb_inv_tipo_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvTipoActividad.findAll", query = "SELECT e FROM EtbInvTipoActividad e")
    , @NamedQuery(name = "EtbInvTipoActividad.findByTipaId", query = "SELECT e FROM EtbInvTipoActividad e WHERE e.tipaId = :tipaId")
    , @NamedQuery(name = "EtbInvTipoActividad.findByTipaNombre", query = "SELECT e FROM EtbInvTipoActividad e WHERE e.tipaNombre = :tipaNombre")})
public class EtbInvTipoActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPA_ID")
    private Integer tipaId;
    @Size(max = 255)
    @Column(name = "TIPA_NOMBRE")
    private String tipaNombre;
    @OneToMany(mappedBy = "actTipo")
    private Collection<EtbInvActividad> etbInvActividadCollection;

    public EtbInvTipoActividad() {
    }

    public EtbInvTipoActividad(Integer tipaId) {
        this.tipaId = tipaId;
    }

    public Integer getTipaId() {
        return tipaId;
    }

    public void setTipaId(Integer tipaId) {
        this.tipaId = tipaId;
    }

    public String getTipaNombre() {
        return tipaNombre;
    }

    public void setTipaNombre(String tipaNombre) {
        this.tipaNombre = tipaNombre;
    }

    @XmlTransient
    public Collection<EtbInvActividad> getEtbInvActividadCollection() {
        return etbInvActividadCollection;
    }

    public void setEtbInvActividadCollection(Collection<EtbInvActividad> etbInvActividadCollection) {
        this.etbInvActividadCollection = etbInvActividadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipaId != null ? tipaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvTipoActividad)) {
            return false;
        }
        EtbInvTipoActividad other = (EtbInvTipoActividad) object;
        if ((this.tipaId == null && other.tipaId != null) || (this.tipaId != null && !this.tipaId.equals(other.tipaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvTipoActividad[ tipaId=" + tipaId + " ]";
    }
    
}
