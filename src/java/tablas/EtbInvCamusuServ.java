/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_camusu_serv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvCamusuServ.findAll", query = "SELECT e FROM EtbInvCamusuServ e")
    , @NamedQuery(name = "EtbInvCamusuServ.findByUsuCambio", query = "SELECT e FROM EtbInvCamusuServ e WHERE e.usuCambio = :usuCambio")
    , @NamedQuery(name = "EtbInvCamusuServ.findByUsuFecCambio", query = "SELECT e FROM EtbInvCamusuServ e WHERE e.usuFecCambio = :usuFecCambio")
    , @NamedQuery(name = "EtbInvCamusuServ.findByUsuTarCambio", query = "SELECT e FROM EtbInvCamusuServ e WHERE e.usuTarCambio = :usuTarCambio")
    , @NamedQuery(name = "EtbInvCamusuServ.findByUsusId", query = "SELECT e FROM EtbInvCamusuServ e WHERE e.ususId = :ususId")})
public class EtbInvCamusuServ implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 225)
    @Column(name = "usu_cambio")
    private String usuCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_fec_cambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFecCambio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "usu_tar_cambio")
    private String usuTarCambio;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USUS_ID")
    private Integer ususId;
    @JoinColumn(name = "USUS_ESTADO", referencedColumnName = "USUS_ESTADO")
    @ManyToOne(optional = false)
    private EtbInvUsuEstado ususEstado;

    public EtbInvCamusuServ() {
    }

    public EtbInvCamusuServ(Integer ususId) {
        this.ususId = ususId;
    }

    public EtbInvCamusuServ(Integer ususId, Date usuFecCambio, String usuTarCambio) {
        this.ususId = ususId;
        this.usuFecCambio = usuFecCambio;
        this.usuTarCambio = usuTarCambio;
    }
    public EtbInvCamusuServ(String ususLogin, String tCambio, EtbInvUsuEstado ususEstado) {
        this.usuCambio = ususLogin;
        this.usuTarCambio = tCambio;
        this.ususEstado = ususEstado;
    }
    public String getUsuCambio() {
        return usuCambio;
    }

    public void setUsuCambio(String usuCambio) {
        this.usuCambio = usuCambio;
    }

    public Date getUsuFecCambio() {
        return usuFecCambio;
    }

    public void setUsuFecCambio(Date usuFecCambio) {
        this.usuFecCambio = usuFecCambio;
    }

    public String getUsuTarCambio() {
        return usuTarCambio;
    }

    public void setUsuTarCambio(String usuTarCambio) {
        this.usuTarCambio = usuTarCambio;
    }

    public Integer getUsusId() {
        return ususId;
    }

    public void setUsusId(Integer ususId) {
        this.ususId = ususId;
    }

    public EtbInvUsuEstado getUsusEstado() {
        return ususEstado;
    }

    public void setUsusEstado(EtbInvUsuEstado ususEstado) {
        this.ususEstado = ususEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ususId != null ? ususId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvCamusuServ)) {
            return false;
        }
        EtbInvCamusuServ other = (EtbInvCamusuServ) object;
        if ((this.ususId == null && other.ususId != null) || (this.ususId != null && !this.ususId.equals(other.ususId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvCamusuServ[ ususId=" + ususId + " ]";
    }
    
}
