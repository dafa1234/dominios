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
@Table(name = "etb_inv_tipo_cont")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvTipoCont.findAll", query = "SELECT e FROM EtbInvTipoCont e")
    , @NamedQuery(name = "EtbInvTipoCont.findByTopcId", query = "SELECT e FROM EtbInvTipoCont e WHERE e.topcId = :topcId")
    , @NamedQuery(name = "EtbInvTipoCont.findByTipcDescrip", query = "SELECT e FROM EtbInvTipoCont e WHERE e.tipcDescrip = :tipcDescrip")})
public class EtbInvTipoCont implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TOPC_ID")
    private Integer topcId;
    @Size(max = 255)
    @Column(name = "TIPC_DESCRIP")
    private String tipcDescrip;

    public EtbInvTipoCont() {
    }

    public EtbInvTipoCont(Integer topcId) {
        this.topcId = topcId;
    }

    public Integer getTopcId() {
        return topcId;
    }

    public void setTopcId(Integer topcId) {
        this.topcId = topcId;
    }

    public String getTipcDescrip() {
        return tipcDescrip;
    }

    public void setTipcDescrip(String tipcDescrip) {
        this.tipcDescrip = tipcDescrip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (topcId != null ? topcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvTipoCont)) {
            return false;
        }
        EtbInvTipoCont other = (EtbInvTipoCont) object;
        if ((this.topcId == null && other.topcId != null) || (this.topcId != null && !this.topcId.equals(other.topcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvTipoCont[ topcId=" + topcId + " ]";
    }
    
}
