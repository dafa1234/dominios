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
@Table(name = "etb_inv_perf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvPerf.findAll", query = "SELECT e FROM EtbInvPerf e")
    , @NamedQuery(name = "EtbInvPerf.findByUsuIdPer", query = "SELECT e FROM EtbInvPerf e WHERE e.usuIdPer = :usuIdPer")
    , @NamedQuery(name = "EtbInvPerf.findByPerPerfil", query = "SELECT e FROM EtbInvPerf e WHERE e.perPerfil = :perPerfil")})
public class EtbInvPerf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USU_ID_PER")
    private Integer usuIdPer;
    @Size(max = 40)
    @Column(name = "PER_PERFIL")
    private String perPerfil;

    public EtbInvPerf() {
    }

    public EtbInvPerf(Integer usuIdPer) {
        this.usuIdPer = usuIdPer;
    }

    public Integer getUsuIdPer() {
        return usuIdPer;
    }

    public void setUsuIdPer(Integer usuIdPer) {
        this.usuIdPer = usuIdPer;
    }

    public String getPerPerfil() {
        return perPerfil;
    }

    public void setPerPerfil(String perPerfil) {
        this.perPerfil = perPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuIdPer != null ? usuIdPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvPerf)) {
            return false;
        }
        EtbInvPerf other = (EtbInvPerf) object;
        if ((this.usuIdPer == null && other.usuIdPer != null) || (this.usuIdPer != null && !this.usuIdPer.equals(other.usuIdPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvPerf[ usuIdPer=" + usuIdPer + " ]";
    }
    
}
