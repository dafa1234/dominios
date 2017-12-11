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
@Table(name = "etb_inv_tip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvTip.findAll", query = "SELECT e FROM EtbInvTip e")
    , @NamedQuery(name = "EtbInvTip.findByTipIdIp", query = "SELECT e FROM EtbInvTip e WHERE e.tipIdIp = :tipIdIp")
    , @NamedQuery(name = "EtbInvTip.findByTipTipoIp", query = "SELECT e FROM EtbInvTip e WHERE e.tipTipoIp = :tipTipoIp")})
public class EtbInvTip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIP_ID_IP")
    private Integer tipIdIp;
    @Size(max = 25)
    @Column(name = "TIP_TIPO_IP")
    private String tipTipoIp;
    @OneToMany(mappedBy = "dirTipo")
    private Collection<EtbInvDireccionamiento> etbInvDireccionamientoCollection;

    public EtbInvTip() {
    }

    public EtbInvTip(Integer tipIdIp) {
        this.tipIdIp = tipIdIp;
    }

    public Integer getTipIdIp() {
        return tipIdIp;
    }

    public void setTipIdIp(Integer tipIdIp) {
        this.tipIdIp = tipIdIp;
    }

    public String getTipTipoIp() {
        return tipTipoIp;
    }

    public void setTipTipoIp(String tipTipoIp) {
        this.tipTipoIp = tipTipoIp;
    }

    @XmlTransient
    public Collection<EtbInvDireccionamiento> getEtbInvDireccionamientoCollection() {
        return etbInvDireccionamientoCollection;
    }

    public void setEtbInvDireccionamientoCollection(Collection<EtbInvDireccionamiento> etbInvDireccionamientoCollection) {
        this.etbInvDireccionamientoCollection = etbInvDireccionamientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipIdIp != null ? tipIdIp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvTip)) {
            return false;
        }
        EtbInvTip other = (EtbInvTip) object;
        if ((this.tipIdIp == null && other.tipIdIp != null) || (this.tipIdIp != null && !this.tipIdIp.equals(other.tipIdIp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvTip[ tipIdIp=" + tipIdIp + " ]";
    }
    
}
