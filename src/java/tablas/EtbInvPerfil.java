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
@Table(name = "etb_inv_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvPerfil.findAll", query = "SELECT e FROM EtbInvPerfil e")
    , @NamedQuery(name = "EtbInvPerfil.findByPerId", query = "SELECT e FROM EtbInvPerfil e WHERE e.perId = :perId")
    , @NamedQuery(name = "EtbInvPerfil.findByPerDescripcion", query = "SELECT e FROM EtbInvPerfil e WHERE e.perDescripcion = :perDescripcion")})
public class EtbInvPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PER_DESCRIPCION")
    private String perDescripcion;

    public EtbInvPerfil() {
    }

    public EtbInvPerfil(Integer perId) {
        this.perId = perId;
    }

    public EtbInvPerfil(Integer perId, String perDescripcion) {
        this.perId = perId;
        this.perDescripcion = perDescripcion;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvPerfil)) {
            return false;
        }
        EtbInvPerfil other = (EtbInvPerfil) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvPerfil[ perId=" + perId + " ]";
    }
    
}
