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
import javax.persistence.Lob;
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
@Table(name = "etb_inv_contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvContrato.findAll", query = "SELECT e FROM EtbInvContrato e")
    , @NamedQuery(name = "EtbInvContrato.findByContId", query = "SELECT e FROM EtbInvContrato e WHERE e.contId = :contId")
    , @NamedQuery(name = "EtbInvContrato.findByContProv", query = "SELECT e FROM EtbInvContrato e WHERE e.contProv = :contProv")
    , @NamedQuery(name = "EtbInvContrato.findByContTipo", query = "SELECT e FROM EtbInvContrato e WHERE e.contTipo = :contTipo")
    , @NamedQuery(name = "EtbInvContrato.findByContFechaIni", query = "SELECT e FROM EtbInvContrato e WHERE e.contFechaIni = :contFechaIni")
    , @NamedQuery(name = "EtbInvContrato.findByContFechaFin", query = "SELECT e FROM EtbInvContrato e WHERE e.contFechaFin = :contFechaFin")
    , @NamedQuery(name = "EtbInvContrato.findByContNum", query = "SELECT e FROM EtbInvContrato e WHERE e.contNum = :contNum")
    , @NamedQuery(name = "EtbInvContrato.findByContEstado", query = "SELECT e FROM EtbInvContrato e WHERE e.contEstado = :contEstado")
    , @NamedQuery(name = "EtbInvContrato.findByContLogin", query = "SELECT e FROM EtbInvContrato e WHERE e.contLogin = :contLogin")})
public class EtbInvContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONT_ID")
    private Integer contId;
    @Column(name = "CONT_PROV")
    private Integer contProv;
    @Column(name = "CONT_TIPO")
    private Integer contTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contFechaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONT_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contFechaFin;
    @Size(max = 255)
    @Column(name = "CONT_NUM")
    private String contNum;
    @Lob
    @Size(max = 16777215)
    @Column(name = "CONT_DESCRIP")
    private String contDescrip;
    @Column(name = "CONT_ESTADO")
    private Integer contEstado;
    @Size(max = 255)
    @Column(name = "CONT_LOGIN")
    private String contLogin;

    public EtbInvContrato() {
    }

    public EtbInvContrato(Integer contId) {
        this.contId = contId;
    }

    public EtbInvContrato(Integer contId, Date contFechaIni, Date contFechaFin) {
        this.contId = contId;
        this.contFechaIni = contFechaIni;
        this.contFechaFin = contFechaFin;
    }
    public EtbInvContrato(Integer contProv, Integer contTipo, Date contFechaIni, Date contFechaFin, String contNum, Integer contEstado, String contLogin, String contDescrip) {
        
        this.contProv = contProv;
        this.contTipo = contTipo;
        this.contFechaIni = contFechaIni;
        this.contFechaFin = contFechaFin;
        this.contNum = contNum;
        this.contDescrip = contDescrip;
        this.contEstado = contEstado;
        this.contLogin = contLogin;
        
    }
    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }

    public Integer getContProv() {
        return contProv;
    }

    public void setContProv(Integer contProv) {
        this.contProv = contProv;
    }

    public Integer getContTipo() {
        return contTipo;
    }

    public void setContTipo(Integer contTipo) {
        this.contTipo = contTipo;
    }

    public Date getContFechaIni() {
        return contFechaIni;
    }

    public void setContFechaIni(Date contFechaIni) {
        this.contFechaIni = contFechaIni;
    }

    public Date getContFechaFin() {
        return contFechaFin;
    }

    public void setContFechaFin(Date contFechaFin) {
        this.contFechaFin = contFechaFin;
    }

    public String getContNum() {
        return contNum;
    }

    public void setContNum(String contNum) {
        this.contNum = contNum;
    }

    public String getContDescrip() {
        return contDescrip;
    }

    public void setContDescrip(String contDescrip) {
        this.contDescrip = contDescrip;
    }

    public Integer getContEstado() {
        return contEstado;
    }

    public void setContEstado(Integer contEstado) {
        this.contEstado = contEstado;
    }

    public String getContLogin() {
        return contLogin;
    }

    public void setContLogin(String contLogin) {
        this.contLogin = contLogin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contId != null ? contId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvContrato)) {
            return false;
        }
        EtbInvContrato other = (EtbInvContrato) object;
        if ((this.contId == null && other.contId != null) || (this.contId != null && !this.contId.equals(other.contId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvContrato[ contId=" + contId + " ]";
    }
    
}
