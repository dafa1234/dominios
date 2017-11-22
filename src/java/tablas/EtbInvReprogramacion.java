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
@Table(name = "etb_inv_reprogramacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvReprogramacion.findAll", query = "SELECT e FROM EtbInvReprogramacion e")
    , @NamedQuery(name = "EtbInvReprogramacion.findByRepId", query = "SELECT e FROM EtbInvReprogramacion e WHERE e.repId = :repId")
    , @NamedQuery(name = "EtbInvReprogramacion.findByRepActividad", query = "SELECT e FROM EtbInvReprogramacion e WHERE e.repActividad = :repActividad")
    , @NamedQuery(name = "EtbInvReprogramacion.findByRepFechaIni", query = "SELECT e FROM EtbInvReprogramacion e WHERE e.repFechaIni = :repFechaIni")
    , @NamedQuery(name = "EtbInvReprogramacion.findByRepFechaReprog", query = "SELECT e FROM EtbInvReprogramacion e WHERE e.repFechaReprog = :repFechaReprog")
    , @NamedQuery(name = "EtbInvReprogramacion.findByRepMotivoReprog", query = "SELECT e FROM EtbInvReprogramacion e WHERE e.repMotivoReprog = :repMotivoReprog")
    , @NamedQuery(name = "EtbInvReprogramacion.findByRepObserv", query = "SELECT e FROM EtbInvReprogramacion e WHERE e.repObserv = :repObserv")})
public class EtbInvReprogramacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REP_ID")
    private Integer repId;
    @Column(name = "REP_ACTIVIDAD")
    private Integer repActividad;
    @Size(max = 30)
    @Column(name = "REP_FECHA_INI")
    private String repFechaIni;
    @Size(max = 30)
    @Column(name = "REP_FECHA_REPROG")
    private String repFechaReprog;
    @Column(name = "REP_MOTIVO_REPROG")
    private Integer repMotivoReprog;
    @Size(max = 255)
    @Column(name = "REP_OBSERV")
    private String repObserv;

    public EtbInvReprogramacion() {
    }

    public EtbInvReprogramacion(Integer repId) {
        this.repId = repId;
    }

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public Integer getRepActividad() {
        return repActividad;
    }

    public void setRepActividad(Integer repActividad) {
        this.repActividad = repActividad;
    }

    public String getRepFechaIni() {
        return repFechaIni;
    }

    public void setRepFechaIni(String repFechaIni) {
        this.repFechaIni = repFechaIni;
    }

    public String getRepFechaReprog() {
        return repFechaReprog;
    }

    public void setRepFechaReprog(String repFechaReprog) {
        this.repFechaReprog = repFechaReprog;
    }

    public Integer getRepMotivoReprog() {
        return repMotivoReprog;
    }

    public void setRepMotivoReprog(Integer repMotivoReprog) {
        this.repMotivoReprog = repMotivoReprog;
    }

    public String getRepObserv() {
        return repObserv;
    }

    public void setRepObserv(String repObserv) {
        this.repObserv = repObserv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repId != null ? repId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvReprogramacion)) {
            return false;
        }
        EtbInvReprogramacion other = (EtbInvReprogramacion) object;
        if ((this.repId == null && other.repId != null) || (this.repId != null && !this.repId.equals(other.repId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvReprogramacion[ repId=" + repId + " ]";
    }
    
}
