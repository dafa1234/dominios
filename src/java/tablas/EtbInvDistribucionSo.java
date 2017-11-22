/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_distribucion_so")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvDistribucionSo.findAll", query = "SELECT e FROM EtbInvDistribucionSo e")
    , @NamedQuery(name = "EtbInvDistribucionSo.findByDisoId", query = "SELECT e FROM EtbInvDistribucionSo e WHERE e.disoId = :disoId")
    , @NamedQuery(name = "EtbInvDistribucionSo.findByDisoNombre", query = "SELECT e FROM EtbInvDistribucionSo e WHERE e.disoNombre = :disoNombre")})
public class EtbInvDistribucionSo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DISO_ID")
    private Integer disoId;
    @Size(max = 255)
    @Column(name = "DISO_NOMBRE")
    private String disoNombre;

    public EtbInvDistribucionSo() {
    }

    public EtbInvDistribucionSo(Integer disoId) {
        this.disoId = disoId;
    }

    public Integer getDisoId() {
        return disoId;
    }

    public void setDisoId(Integer disoId) {
        this.disoId = disoId;
    }

    public String getDisoNombre() {
        return disoNombre;
    }

    public void setDisoNombre(String disoNombre) {
        this.disoNombre = disoNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disoId != null ? disoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvDistribucionSo)) {
            return false;
        }
        EtbInvDistribucionSo other = (EtbInvDistribucionSo) object;
        if ((this.disoId == null && other.disoId != null) || (this.disoId != null && !this.disoId.equals(other.disoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvDistribucionSo[ disoId=" + disoId + " ]";
    }
    
}
