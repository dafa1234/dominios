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
@Table(name = "etb_inv_acceso_prohibido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvAccesoProhibido.findAll", query = "SELECT e FROM EtbInvAccesoProhibido e")
    , @NamedQuery(name = "EtbInvAccesoProhibido.findByUsuAccId", query = "SELECT e FROM EtbInvAccesoProhibido e WHERE e.usuAccId = :usuAccId")
    , @NamedQuery(name = "EtbInvAccesoProhibido.findByUsuAccUsuario", query = "SELECT e FROM EtbInvAccesoProhibido e WHERE e.usuAccUsuario = :usuAccUsuario")
    , @NamedQuery(name = "EtbInvAccesoProhibido.findByUsuAccUlr", query = "SELECT e FROM EtbInvAccesoProhibido e WHERE e.usuAccUlr = :usuAccUlr")
    , @NamedQuery(name = "EtbInvAccesoProhibido.findByUsuAccOperacion", query = "SELECT e FROM EtbInvAccesoProhibido e WHERE e.usuAccOperacion = :usuAccOperacion")
    , @NamedQuery(name = "EtbInvAccesoProhibido.findByUsuAccFecha", query = "SELECT e FROM EtbInvAccesoProhibido e WHERE e.usuAccFecha = :usuAccFecha")
    , @NamedQuery(name = "EtbInvAccesoProhibido.findByUsuAccIp", query = "SELECT e FROM EtbInvAccesoProhibido e WHERE e.usuAccIp = :usuAccIp")})
public class EtbInvAccesoProhibido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USU_ACC_ID")
    private Integer usuAccId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_ACC_USUARIO")
    private String usuAccUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USU_ACC_ULR")
    private String usuAccUlr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "USU_ACC_OPERACION")
    private String usuAccOperacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_ACC_FECHA")
    private String usuAccFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_ACC_IP")
    private String usuAccIp;

    public EtbInvAccesoProhibido() {
    }

    public EtbInvAccesoProhibido(Integer usuAccId) {
        this.usuAccId = usuAccId;
    }

    public EtbInvAccesoProhibido(Integer usuAccId, String usuAccUsuario, String usuAccUlr, String usuAccOperacion, String usuAccFecha, String usuAccIp) {
        this.usuAccId = usuAccId;
        this.usuAccUsuario = usuAccUsuario;
        this.usuAccUlr = usuAccUlr;
        this.usuAccOperacion = usuAccOperacion;
        this.usuAccFecha = usuAccFecha;
        this.usuAccIp = usuAccIp;
    }

    public Integer getUsuAccId() {
        return usuAccId;
    }

    public void setUsuAccId(Integer usuAccId) {
        this.usuAccId = usuAccId;
    }

    public String getUsuAccUsuario() {
        return usuAccUsuario;
    }

    public void setUsuAccUsuario(String usuAccUsuario) {
        this.usuAccUsuario = usuAccUsuario;
    }

    public String getUsuAccUlr() {
        return usuAccUlr;
    }

    public void setUsuAccUlr(String usuAccUlr) {
        this.usuAccUlr = usuAccUlr;
    }

    public String getUsuAccOperacion() {
        return usuAccOperacion;
    }

    public void setUsuAccOperacion(String usuAccOperacion) {
        this.usuAccOperacion = usuAccOperacion;
    }

    public String getUsuAccFecha() {
        return usuAccFecha;
    }

    public void setUsuAccFecha(String usuAccFecha) {
        this.usuAccFecha = usuAccFecha;
    }

    public String getUsuAccIp() {
        return usuAccIp;
    }

    public void setUsuAccIp(String usuAccIp) {
        this.usuAccIp = usuAccIp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuAccId != null ? usuAccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvAccesoProhibido)) {
            return false;
        }
        EtbInvAccesoProhibido other = (EtbInvAccesoProhibido) object;
        if ((this.usuAccId == null && other.usuAccId != null) || (this.usuAccId != null && !this.usuAccId.equals(other.usuAccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvAccesoProhibido[ usuAccId=" + usuAccId + " ]";
    }
    
}
