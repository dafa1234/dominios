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
@Table(name = "etb_inv_cronograma_mto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvCronogramaMto.findAll", query = "SELECT e FROM EtbInvCronogramaMto e")
    , @NamedQuery(name = "EtbInvCronogramaMto.findByCroId", query = "SELECT e FROM EtbInvCronogramaMto e WHERE e.croId = :croId")
    , @NamedQuery(name = "EtbInvCronogramaMto.findByCroSerial", query = "SELECT e FROM EtbInvCronogramaMto e WHERE e.croSerial = :croSerial")
    , @NamedQuery(name = "EtbInvCronogramaMto.findByCroProyecto", query = "SELECT e FROM EtbInvCronogramaMto e WHERE e.croProyecto = :croProyecto")
    , @NamedQuery(name = "EtbInvCronogramaMto.findByCroFechaIni", query = "SELECT e FROM EtbInvCronogramaMto e WHERE e.croFechaIni = :croFechaIni")
    , @NamedQuery(name = "EtbInvCronogramaMto.findByCroFechaProx", query = "SELECT e FROM EtbInvCronogramaMto e WHERE e.croFechaProx = :croFechaProx")
    , @NamedQuery(name = "EtbInvCronogramaMto.findByCroFechaFin", query = "SELECT e FROM EtbInvCronogramaMto e WHERE e.croFechaFin = :croFechaFin")
    , @NamedQuery(name = "EtbInvCronogramaMto.findByCroCambioFin", query = "SELECT e FROM EtbInvCronogramaMto e WHERE e.croCambioFin = :croCambioFin")
    , @NamedQuery(name = "EtbInvCronogramaMto.findByCroEjecuta", query = "SELECT e FROM EtbInvCronogramaMto e WHERE e.croEjecuta = :croEjecuta")
    , @NamedQuery(name = "EtbInvCronogramaMto.findByCroEstado", query = "SELECT e FROM EtbInvCronogramaMto e WHERE e.croEstado = :croEstado")})
public class EtbInvCronogramaMto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CRO_ID")
    private Integer croId;
    @Size(max = 255)
    @Column(name = "CRO_SERIAL")
    private String croSerial;
    @Column(name = "CRO_PROYECTO")
    private Integer croProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CRO_FECHA_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date croFechaIni;
    @Column(name = "CRO_FECHA_PROX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date croFechaProx;
    @Column(name = "CRO_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date croFechaFin;
    @Size(max = 255)
    @Column(name = "CRO_CAMBIO_FIN")
    private String croCambioFin;
    @Size(max = 255)
    @Column(name = "CRO_EJECUTA")
    private String croEjecuta;
    @Column(name = "CRO_ESTADO")
    private Integer croEstado;
    @Lob
    @Size(max = 16777215)
    @Column(name = "CRO_OBSERVACION")
    private String croObservacion;

    public EtbInvCronogramaMto() {
    }

    public EtbInvCronogramaMto(Integer croId) {
        this.croId = croId;
    }

    public EtbInvCronogramaMto(Integer croId, Date croFechaIni) {
        this.croId = croId;
        this.croFechaIni = croFechaIni;
    }
    public EtbInvCronogramaMto(Integer croProyecto, Date croFechaIni, String croSerial, String croEjecuta,String croCambioFin,Integer croEstado) {
        this.croProyecto = croProyecto;
        this.croFechaIni = croFechaIni;
        this.croSerial = croSerial;
        this.croEjecuta = croEjecuta;
        this.croCambioFin = croCambioFin;
        this.croEstado = croEstado;
    }
    public Integer getCroId() {
        return croId;
    }

    public void setCroId(Integer croId) {
        this.croId = croId;
    }

    public String getCroSerial() {
        return croSerial;
    }

    public void setCroSerial(String croSerial) {
        this.croSerial = croSerial;
    }

    public Integer getCroProyecto() {
        return croProyecto;
    }

    public void setCroProyecto(Integer croProyecto) {
        this.croProyecto = croProyecto;
    }

    public Date getCroFechaIni() {
        return croFechaIni;
    }

    public void setCroFechaIni(Date croFechaIni) {
        this.croFechaIni = croFechaIni;
    }

    public Date getCroFechaProx() {
        return croFechaProx;
    }

    public void setCroFechaProx(Date croFechaProx) {
        this.croFechaProx = croFechaProx;
    }

    public Date getCroFechaFin() {
        return croFechaFin;
    }

    public void setCroFechaFin(Date croFechaFin) {
        this.croFechaFin = croFechaFin;
    }

    public String getCroCambioFin() {
        return croCambioFin;
    }

    public void setCroCambioFin(String croCambioFin) {
        this.croCambioFin = croCambioFin;
    }

    public String getCroEjecuta() {
        return croEjecuta;
    }

    public void setCroEjecuta(String croEjecuta) {
        this.croEjecuta = croEjecuta;
    }

    public Integer getCroEstado() {
        return croEstado;
    }

    public void setCroEstado(Integer croEstado) {
        this.croEstado = croEstado;
    }

    public String getCroObservacion() {
        return croObservacion;
    }

    public void setCroObservacion(String croObservacion) {
        this.croObservacion = croObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (croId != null ? croId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvCronogramaMto)) {
            return false;
        }
        EtbInvCronogramaMto other = (EtbInvCronogramaMto) object;
        if ((this.croId == null && other.croId != null) || (this.croId != null && !this.croId.equals(other.croId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvCronogramaMto[ croId=" + croId + " ]";
    }
    
}
