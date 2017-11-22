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
@Table(name = "etb_inv_conectividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvConectividad.findAll", query = "SELECT e FROM EtbInvConectividad e")
    , @NamedQuery(name = "EtbInvConectividad.findByConIdConectividad", query = "SELECT e FROM EtbInvConectividad e WHERE e.conIdConectividad = :conIdConectividad")
    , @NamedQuery(name = "EtbInvConectividad.findBySerSerial", query = "SELECT e FROM EtbInvConectividad e WHERE e.serSerial = :serSerial")
    , @NamedQuery(name = "EtbInvConectividad.findByConIp", query = "SELECT e FROM EtbInvConectividad e WHERE e.conIp = :conIp")
    , @NamedQuery(name = "EtbInvConectividad.findByConVlan", query = "SELECT e FROM EtbInvConectividad e WHERE e.conVlan = :conVlan")
    , @NamedQuery(name = "EtbInvConectividad.findByConTipoIp", query = "SELECT e FROM EtbInvConectividad e WHERE e.conTipoIp = :conTipoIp")
    , @NamedQuery(name = "EtbInvConectividad.findByConSwitch", query = "SELECT e FROM EtbInvConectividad e WHERE e.conSwitch = :conSwitch")
    , @NamedQuery(name = "EtbInvConectividad.findByConPuerto", query = "SELECT e FROM EtbInvConectividad e WHERE e.conPuerto = :conPuerto")})
public class EtbInvConectividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CON_ID_CONECTIVIDAD")
    private Integer conIdConectividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SER_SERIAL")
    private String serSerial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CON_IP")
    private String conIp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CON_VLAN")
    private String conVlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CON_TIPO_IP")
    private int conTipoIp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CON_SWITCH")
    private String conSwitch;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CON_PUERTO")
    private String conPuerto;

    public EtbInvConectividad() {
    }

    public EtbInvConectividad(Integer conIdConectividad) {
        this.conIdConectividad = conIdConectividad;
    }

    public EtbInvConectividad(Integer conIdConectividad, String serSerial, String conIp, String conVlan, int conTipoIp, String conSwitch, String conPuerto) {
        this.conIdConectividad = conIdConectividad;
        this.serSerial = serSerial;
        this.conIp = conIp;
        this.conVlan = conVlan;
        this.conTipoIp = conTipoIp;
        this.conSwitch = conSwitch;
        this.conPuerto = conPuerto;
    }

    public Integer getConIdConectividad() {
        return conIdConectividad;
    }

    public void setConIdConectividad(Integer conIdConectividad) {
        this.conIdConectividad = conIdConectividad;
    }

    public String getSerSerial() {
        return serSerial;
    }

    public void setSerSerial(String serSerial) {
        this.serSerial = serSerial;
    }

    public String getConIp() {
        return conIp;
    }

    public void setConIp(String conIp) {
        this.conIp = conIp;
    }

    public String getConVlan() {
        return conVlan;
    }

    public void setConVlan(String conVlan) {
        this.conVlan = conVlan;
    }

    public int getConTipoIp() {
        return conTipoIp;
    }

    public void setConTipoIp(int conTipoIp) {
        this.conTipoIp = conTipoIp;
    }

    public String getConSwitch() {
        return conSwitch;
    }

    public void setConSwitch(String conSwitch) {
        this.conSwitch = conSwitch;
    }

    public String getConPuerto() {
        return conPuerto;
    }

    public void setConPuerto(String conPuerto) {
        this.conPuerto = conPuerto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conIdConectividad != null ? conIdConectividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvConectividad)) {
            return false;
        }
        EtbInvConectividad other = (EtbInvConectividad) object;
        if ((this.conIdConectividad == null && other.conIdConectividad != null) || (this.conIdConectividad != null && !this.conIdConectividad.equals(other.conIdConectividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvConectividad[ conIdConectividad=" + conIdConectividad + " ]";
    }
    
}
