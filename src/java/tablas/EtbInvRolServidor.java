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
@Table(name = "etb_inv_rol_servidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvRolServidor.findAll", query = "SELECT e FROM EtbInvRolServidor e")
    , @NamedQuery(name = "EtbInvRolServidor.findByRolIdRolServ", query = "SELECT e FROM EtbInvRolServidor e WHERE e.rolIdRolServ = :rolIdRolServ")
    , @NamedQuery(name = "EtbInvRolServidor.findByRolNomRolServ", query = "SELECT e FROM EtbInvRolServidor e WHERE e.rolNomRolServ = :rolNomRolServ")})
public class EtbInvRolServidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ROL_ID_ROL_SERV")
    private Integer rolIdRolServ;
    @Size(max = 25)
    @Column(name = "ROL_NOM_ROL_SERV")
    private String rolNomRolServ;

    public EtbInvRolServidor() {
    }

    public EtbInvRolServidor(Integer rolIdRolServ) {
        this.rolIdRolServ = rolIdRolServ;
    }
    public EtbInvRolServidor(String nrol) {
        this.rolNomRolServ = nrol;
    }
    public Integer getRolIdRolServ() {
        return rolIdRolServ;
    }

    public void setRolIdRolServ(Integer rolIdRolServ) {
        this.rolIdRolServ = rolIdRolServ;
    }

    public String getRolNomRolServ() {
        return rolNomRolServ;
    }

    public void setRolNomRolServ(String rolNomRolServ) {
        this.rolNomRolServ = rolNomRolServ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolIdRolServ != null ? rolIdRolServ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvRolServidor)) {
            return false;
        }
        EtbInvRolServidor other = (EtbInvRolServidor) object;
        if ((this.rolIdRolServ == null && other.rolIdRolServ != null) || (this.rolIdRolServ != null && !this.rolIdRolServ.equals(other.rolIdRolServ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvRolServidor[ rolIdRolServ=" + rolIdRolServ + " ]";
    }
    
}
