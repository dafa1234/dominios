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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "etb_inv_usu_serv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvUsuServ.findAll", query = "SELECT e FROM EtbInvUsuServ e")
    , @NamedQuery(name = "EtbInvUsuServ.findByUsusId", query = "SELECT e FROM EtbInvUsuServ e WHERE e.ususId = :ususId")
    , @NamedQuery(name = "EtbInvUsuServ.findByUsusLogin", query = "SELECT e FROM EtbInvUsuServ e WHERE e.ususLogin = :ususLogin")
    , @NamedQuery(name = "EtbInvUsuServ.findByUsusNombre", query = "SELECT e FROM EtbInvUsuServ e WHERE e.ususNombre = :ususNombre")
    , @NamedQuery(name = "EtbInvUsuServ.findByUsusServ", query = "SELECT e FROM EtbInvUsuServ e WHERE e.ususServ = :ususServ")
    , @NamedQuery(name = "EtbInvUsuServ.findByUsusAdm", query = "SELECT e FROM EtbInvUsuServ e WHERE e.ususAdm = :ususAdm")})
public class EtbInvUsuServ implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USUS_ID")
    private Integer ususId;
    @Size(max = 255)
    @Column(name = "USUS_LOGIN")
    private String ususLogin;
    @Size(max = 255)
    @Column(name = "USUS_NOMBRE")
    private String ususNombre;
    @Size(max = 20)
    @Column(name = "USUS_SERV")
    private String ususServ;
    @Column(name = "USUS_ADM")
    private Integer ususAdm;
    @JoinColumn(name = "USUS_ESTADO", referencedColumnName = "USUS_ESTADO")
    @ManyToOne(optional = false)
    private EtbInvUsuEstado ususEstado;

    public EtbInvUsuServ() {
    }

    public EtbInvUsuServ(Integer ususId) {
        this.ususId = ususId;
    }

    public Integer getUsusId() {
        return ususId;
    }
    public EtbInvUsuServ(String ususLogin, String ususNombre, String ususServ, EtbInvUsuEstado ususEstado) {
        this.ususLogin = ususLogin;
        this.ususNombre = ususNombre;
        this.ususServ = ususServ;
         this.ususEstado = ususEstado;
    }
  

    public EtbInvUsuServ(EtbInvUsuEstado ususEstado, Integer email, String ususLogin, String nombre, String servidor, Integer admin) {
        this.ususId = email;
        this.ususEstado = ususEstado;
         this.ususLogin = ususLogin;
        this.ususNombre = nombre;
         this.ususServ = servidor;
        this.ususAdm = admin;
    }
    public void setUsusId(Integer ususId) {
        this.ususId = ususId;
    }

    public String getUsusLogin() {
        return ususLogin;
    }

    public void setUsusLogin(String ususLogin) {
        this.ususLogin = ususLogin;
    }

    public String getUsusNombre() {
        return ususNombre;
    }

    public void setUsusNombre(String ususNombre) {
        this.ususNombre = ususNombre;
    }

    public String getUsusServ() {
        return ususServ;
    }

    public void setUsusServ(String ususServ) {
        this.ususServ = ususServ;
    }

    public Integer getUsusAdm() {
        return ususAdm;
    }

    public void setUsusAdm(Integer ususAdm) {
        this.ususAdm = ususAdm;
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
        if (!(object instanceof EtbInvUsuServ)) {
            return false;
        }
        EtbInvUsuServ other = (EtbInvUsuServ) object;
        if ((this.ususId == null && other.ususId != null) || (this.ususId != null && !this.ususId.equals(other.ususId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvUsuServ[ ususId=" + ususId + " ]";
    }
    
}