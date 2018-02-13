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
import javax.persistence.Lob;
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
@Table(name = "etb_inv_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvActividad.findAll", query = "SELECT e FROM EtbInvActividad e")
    , @NamedQuery(name = "EtbInvActividad.findByActId", query = "SELECT e FROM EtbInvActividad e WHERE e.actId = :actId")
    , @NamedQuery(name = "EtbInvActividad.findByActServ", query = "SELECT e FROM EtbInvActividad e WHERE e.actServ = :actServ")
    , @NamedQuery(name = "EtbInvActividad.findByActEjecuta", query = "SELECT e FROM EtbInvActividad e WHERE e.actEjecuta = :actEjecuta")
    , @NamedQuery(name = "EtbInvActividad.findByActFechaIni", query = "SELECT e FROM EtbInvActividad e WHERE e.actFechaIni = :actFechaIni")
    , @NamedQuery(name = "EtbInvActividad.findByActTarea", query = "SELECT e FROM EtbInvActividad e WHERE e.actTarea = :actTarea")
    , @NamedQuery(name = "EtbInvActividad.findByActFechaFin", query = "SELECT e FROM EtbInvActividad e WHERE e.actFechaFin = :actFechaFin")
    , @NamedQuery(name = "EtbInvActividad.findByActSolicita", query = "SELECT e FROM EtbInvActividad e WHERE e.actSolicita = :actSolicita")
    , @NamedQuery(name = "EtbInvActividad.findByFCreacion", query = "SELECT e FROM EtbInvActividad e WHERE e.fCreacion = :fCreacion")})
public class EtbInvActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACT_ID")
    private Integer actId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ACT_SERV")
    private String actServ;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ACT_EJECUTA")
    private String actEjecuta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ACT_FECHA_INI")
    private String actFechaIni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ACT_TAREA")
    private String actTarea;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "ACT_DESCRIPCION")
    private String actDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ACT_FECHA_FIN")
    private String actFechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ACT_SOLICITA")
    private String actSolicita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "F_Creacion")
    private String fCreacion;
    @JoinColumn(name = "ACT_TIPO", referencedColumnName = "TIPA_ID")
    @ManyToOne
    private EtbInvTipoActividad actTipo;
    @JoinColumn(name = "ACT_SERV1", referencedColumnName = "ser_server")
    @ManyToOne(optional = false)
    private EtbInvServidor actServ1;

    public EtbInvActividad() {
    }

    public EtbInvActividad(Integer actId) {
        this.actId = actId;
    }

    public EtbInvActividad(Integer actId, String actServ, String actEjecuta, String actFechaIni, String actTarea, String actDescripcion, String actFechaFin, String actSolicita, String fCreacion) {
        this.actId = actId;
        this.actServ = actServ;
        this.actEjecuta = actEjecuta;
        this.actFechaIni = actFechaIni;
        this.actTarea = actTarea;
        this.actDescripcion = actDescripcion;
        this.actFechaFin = actFechaFin;
        this.actSolicita = actSolicita;
        this.fCreacion = fCreacion;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public String getActServ() {
        return actServ;
    }

    public void setActServ(String actServ) {
        this.actServ = actServ;
    }

    public String getActEjecuta() {
        return actEjecuta;
    }

    public void setActEjecuta(String actEjecuta) {
        this.actEjecuta = actEjecuta;
    }

    public String getActFechaIni() {
        return actFechaIni;
    }

    public void setActFechaIni(String actFechaIni) {
        this.actFechaIni = actFechaIni;
    }

    public String getActTarea() {
        return actTarea;
    }

    public void setActTarea(String actTarea) {
        this.actTarea = actTarea;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public String getActFechaFin() {
        return actFechaFin;
    }

    public void setActFechaFin(String actFechaFin) {
        this.actFechaFin = actFechaFin;
    }

    public String getActSolicita() {
        return actSolicita;
    }

    public void setActSolicita(String actSolicita) {
        this.actSolicita = actSolicita;
    }

    public String getFCreacion() {
        return fCreacion;
    }

    public void setFCreacion(String fCreacion) {
        this.fCreacion = fCreacion;
    }

    public EtbInvTipoActividad getActTipo() {
        return actTipo;
    }

    public void setActTipo(EtbInvTipoActividad actTipo) {
        this.actTipo = actTipo;
    }

    public EtbInvServidor getActServ1() {
        return actServ1;
    }

    public void setActServ1(EtbInvServidor actServ1) {
        this.actServ1 = actServ1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvActividad)) {
            return false;
        }
        EtbInvActividad other = (EtbInvActividad) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvActividad[ actId=" + actId + " ]";
    }
    
}
