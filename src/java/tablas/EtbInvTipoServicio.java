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
@Table(name = "etb_inv_tipo_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvTipoServicio.findAll", query = "SELECT e FROM EtbInvTipoServicio e")
    , @NamedQuery(name = "EtbInvTipoServicio.findByTipservId", query = "SELECT e FROM EtbInvTipoServicio e WHERE e.tipservId = :tipservId")
    , @NamedQuery(name = "EtbInvTipoServicio.findByTipservNombre", query = "SELECT e FROM EtbInvTipoServicio e WHERE e.tipservNombre = :tipservNombre")})
public class EtbInvTipoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPSERV_ID")
    private Integer tipservId;
    @Size(max = 30)
    @Column(name = "TIPSERV_NOMBRE")
    private String tipservNombre;

    public EtbInvTipoServicio() {
    }

    public EtbInvTipoServicio(Integer tipservId) {
        this.tipservId = tipservId;
    }

    public Integer getTipservId() {
        return tipservId;
    }

    public void setTipservId(Integer tipservId) {
        this.tipservId = tipservId;
    }

    public String getTipservNombre() {
        return tipservNombre;
    }

    public void setTipservNombre(String tipservNombre) {
        this.tipservNombre = tipservNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipservId != null ? tipservId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvTipoServicio)) {
            return false;
        }
        EtbInvTipoServicio other = (EtbInvTipoServicio) object;
        if ((this.tipservId == null && other.tipservId != null) || (this.tipservId != null && !this.tipservId.equals(other.tipservId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvTipoServicio[ tipservId=" + tipservId + " ]";
    }
    
}
