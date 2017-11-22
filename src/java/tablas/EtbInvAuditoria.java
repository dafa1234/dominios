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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvAuditoria.findAll", query = "SELECT e FROM EtbInvAuditoria e")
    , @NamedQuery(name = "EtbInvAuditoria.findByAudId", query = "SELECT e FROM EtbInvAuditoria e WHERE e.audId = :audId")
    , @NamedQuery(name = "EtbInvAuditoria.findByAudFecha", query = "SELECT e FROM EtbInvAuditoria e WHERE e.audFecha = :audFecha")
    , @NamedQuery(name = "EtbInvAuditoria.findByAudUsu", query = "SELECT e FROM EtbInvAuditoria e WHERE e.audUsu = :audUsu")
    , @NamedQuery(name = "EtbInvAuditoria.findByAudAcc", query = "SELECT e FROM EtbInvAuditoria e WHERE e.audAcc = :audAcc")})
public class EtbInvAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AUD_ID")
    private Integer audId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "AUD_FECHA")
    private String audFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "AUD_USU")
    private String audUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "AUD_ACC")
    private String audAcc;

    public EtbInvAuditoria() {
    }

    public EtbInvAuditoria(Integer audId) {
        this.audId = audId;
    }

    public EtbInvAuditoria(Integer audId, String audFecha, String audUsu, String audAcc) {
        this.audId = audId;
        this.audFecha = audFecha;
        this.audUsu = audUsu;
        this.audAcc = audAcc;
    }

    public Integer getAudId() {
        return audId;
    }

    public void setAudId(Integer audId) {
        this.audId = audId;
    }

    public String getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(String audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudUsu() {
        return audUsu;
    }

    public void setAudUsu(String audUsu) {
        this.audUsu = audUsu;
    }

    public String getAudAcc() {
        return audAcc;
    }

    public void setAudAcc(String audAcc) {
        this.audAcc = audAcc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (audId != null ? audId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvAuditoria)) {
            return false;
        }
        EtbInvAuditoria other = (EtbInvAuditoria) object;
        if ((this.audId == null && other.audId != null) || (this.audId != null && !this.audId.equals(other.audId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvAuditoria[ audId=" + audId + " ]";
    }
    
}
