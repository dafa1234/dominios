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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_direccionamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvDireccionamiento.findAll", query = "SELECT e FROM EtbInvDireccionamiento e")
    , @NamedQuery(name = "EtbInvDireccionamiento.findByDirId", query = "SELECT e FROM EtbInvDireccionamiento e WHERE e.dirId = :dirId")
    , @NamedQuery(name = "EtbInvDireccionamiento.findByDirIp", query = "SELECT e FROM EtbInvDireccionamiento e WHERE e.dirIp = :dirIp")
    , @NamedQuery(name = "EtbInvDireccionamiento.findByDirVlan", query = "SELECT e FROM EtbInvDireccionamiento e WHERE e.dirVlan = :dirVlan")
    , @NamedQuery(name = "EtbInvDireccionamiento.findByDirSwitch", query = "SELECT e FROM EtbInvDireccionamiento e WHERE e.dirSwitch = :dirSwitch")
    , @NamedQuery(name = "EtbInvDireccionamiento.findByDirPuerto", query = "SELECT e FROM EtbInvDireccionamiento e WHERE e.dirPuerto = :dirPuerto")
    , @NamedQuery(name = "EtbInvDireccionamiento.findByFcreacion", query = "SELECT e FROM EtbInvDireccionamiento e WHERE e.fcreacion = :fcreacion")})
public class EtbInvDireccionamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DIR_ID")
    private Integer dirId;
    @Size(max = 255)
    @Column(name = "DIR_IP")
    private String dirIp;
    @Size(max = 255)
    @Column(name = "DIR_VLAN")
    private String dirVlan;
    @Size(max = 255)
    @Column(name = "DIR_SWITCH")
    private String dirSwitch;
    @Size(max = 255)
    @Column(name = "DIR_PUERTO")
    private String dirPuerto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "F_creacion")
    private String fcreacion;
    @JoinColumn(name = "DIR_TIPO", referencedColumnName = "TIP_ID_IP")
    @ManyToOne
    private EtbInvTip dirTipo;
    @JoinColumn(name = "ID_SER", referencedColumnName = "ser_server")
    @ManyToOne(optional = false)
    private EtbInvServidor idSer;

    public EtbInvDireccionamiento() {
    }

    public EtbInvDireccionamiento(Integer dirId) {
        this.dirId = dirId;
    }

    public EtbInvDireccionamiento(Integer dirId, String fcreacion) {
        this.dirId = dirId;
        this.fcreacion = fcreacion;
    }

    public Integer getDirId() {
        return dirId;
    }

    public void setDirId(Integer dirId) {
        this.dirId = dirId;
    }

    public String getDirIp() {
        return dirIp;
    }

    public void setDirIp(String dirIp) {
        this.dirIp = dirIp;
    }

    public String getDirVlan() {
        return dirVlan;
    }

    public void setDirVlan(String dirVlan) {
        this.dirVlan = dirVlan;
    }

    public String getDirSwitch() {
        return dirSwitch;
    }

    public void setDirSwitch(String dirSwitch) {
        this.dirSwitch = dirSwitch;
    }

    public String getDirPuerto() {
        return dirPuerto;
    }

    public void setDirPuerto(String dirPuerto) {
        this.dirPuerto = dirPuerto;
    }

    public String getFcreacion() {
        return fcreacion;
    }

    public void setFcreacion(String fcreacion) {
        this.fcreacion = fcreacion;
    }

    public EtbInvTip getDirTipo() {
        return dirTipo;
    }

    public void setDirTipo(EtbInvTip dirTipo) {
        this.dirTipo = dirTipo;
    }

    public EtbInvServidor getIdSer() {
        return idSer;
    }

    public void setIdSer(EtbInvServidor idSer) {
        this.idSer = idSer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dirId != null ? dirId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvDireccionamiento)) {
            return false;
        }
        EtbInvDireccionamiento other = (EtbInvDireccionamiento) object;
        if ((this.dirId == null && other.dirId != null) || (this.dirId != null && !this.dirId.equals(other.dirId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvDireccionamiento[ dirId=" + dirId + " ]";
    }
    
}
