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
@Table(name = "etb_inv_tipo_reprog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvTipoReprog.findAll", query = "SELECT e FROM EtbInvTipoReprog e")
    , @NamedQuery(name = "EtbInvTipoReprog.findByTrepId", query = "SELECT e FROM EtbInvTipoReprog e WHERE e.trepId = :trepId")
    , @NamedQuery(name = "EtbInvTipoReprog.findByTrepTipo", query = "SELECT e FROM EtbInvTipoReprog e WHERE e.trepTipo = :trepTipo")})
public class EtbInvTipoReprog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TREP_ID")
    private Integer trepId;
    @Size(max = 255)
    @Column(name = "TREP_TIPO")
    private String trepTipo;

    public EtbInvTipoReprog() {
    }

    public EtbInvTipoReprog(Integer trepId) {
        this.trepId = trepId;
    }

    public Integer getTrepId() {
        return trepId;
    }

    public void setTrepId(Integer trepId) {
        this.trepId = trepId;
    }

    public String getTrepTipo() {
        return trepTipo;
    }

    public void setTrepTipo(String trepTipo) {
        this.trepTipo = trepTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trepId != null ? trepId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvTipoReprog)) {
            return false;
        }
        EtbInvTipoReprog other = (EtbInvTipoReprog) object;
        if ((this.trepId == null && other.trepId != null) || (this.trepId != null && !this.trepId.equals(other.trepId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvTipoReprog[ trepId=" + trepId + " ]";
    }
    
}
