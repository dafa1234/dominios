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
@Table(name = "etb_inv_estado_casos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvEstadoCasos.findAll", query = "SELECT e FROM EtbInvEstadoCasos e")
    , @NamedQuery(name = "EtbInvEstadoCasos.findByEstcId", query = "SELECT e FROM EtbInvEstadoCasos e WHERE e.estcId = :estcId")
    , @NamedQuery(name = "EtbInvEstadoCasos.findByEstcEstado", query = "SELECT e FROM EtbInvEstadoCasos e WHERE e.estcEstado = :estcEstado")})
public class EtbInvEstadoCasos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTC_ID")
    private Integer estcId;
    @Size(max = 255)
    @Column(name = "ESTC_ESTADO")
    private String estcEstado;
    @OneToMany(mappedBy = "caspEstado")
    private Collection<EtbInvCasosProv> etbInvCasosProvCollection;

    public EtbInvEstadoCasos() {
    }

    public EtbInvEstadoCasos(Integer estcId) {
        this.estcId = estcId;
    }

    public Integer getEstcId() {
        return estcId;
    }

    public void setEstcId(Integer estcId) {
        this.estcId = estcId;
    }

    public String getEstcEstado() {
        return estcEstado;
    }

    public void setEstcEstado(String estcEstado) {
        this.estcEstado = estcEstado;
    }

    @XmlTransient
    public Collection<EtbInvCasosProv> getEtbInvCasosProvCollection() {
        return etbInvCasosProvCollection;
    }

    public void setEtbInvCasosProvCollection(Collection<EtbInvCasosProv> etbInvCasosProvCollection) {
        this.etbInvCasosProvCollection = etbInvCasosProvCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estcId != null ? estcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvEstadoCasos)) {
            return false;
        }
        EtbInvEstadoCasos other = (EtbInvEstadoCasos) object;
        if ((this.estcId == null && other.estcId != null) || (this.estcId != null && !this.estcId.equals(other.estcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvEstadoCasos[ estcId=" + estcId + " ]";
    }
    
}
