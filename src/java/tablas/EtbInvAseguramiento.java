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
@Table(name = "etb_inv_aseguramiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvAseguramiento.findAll", query = "SELECT e FROM EtbInvAseguramiento e")
    , @NamedQuery(name = "EtbInvAseguramiento.findByAseId", query = "SELECT e FROM EtbInvAseguramiento e WHERE e.aseId = :aseId")
    , @NamedQuery(name = "EtbInvAseguramiento.findByAseFecha", query = "SELECT e FROM EtbInvAseguramiento e WHERE e.aseFecha = :aseFecha")
    , @NamedQuery(name = "EtbInvAseguramiento.findByAseTarea", query = "SELECT e FROM EtbInvAseguramiento e WHERE e.aseTarea = :aseTarea")
    , @NamedQuery(name = "EtbInvAseguramiento.findByAseEjecuta", query = "SELECT e FROM EtbInvAseguramiento e WHERE e.aseEjecuta = :aseEjecuta")})
public class EtbInvAseguramiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ASE_ID")
    private Integer aseId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ASE_FECHA")
    private String aseFecha;
    @Size(max = 255)
    @Column(name = "ASE_TAREA")
    private String aseTarea;
    @Size(max = 255)
    @Column(name = "ASE_EJECUTA")
    private String aseEjecuta;
    @JoinColumn(name = "ASE_SERVIDOR", referencedColumnName = "ser_server")
    @ManyToOne
    private EtbInvServidor aseServidor;

    public EtbInvAseguramiento() {
    }

    public EtbInvAseguramiento(Integer aseId) {
        this.aseId = aseId;
    }

    public EtbInvAseguramiento(Integer aseId, String aseFecha) {
        this.aseId = aseId;
        this.aseFecha = aseFecha;
    }
    public EtbInvAseguramiento(String aseTarea, EtbInvServidor aseServidor, String aseEjecuta,String aseFecha) {
        this.aseFecha = aseFecha;
        this.aseTarea = aseTarea;
        this.aseServidor = aseServidor;
        this.aseEjecuta = aseEjecuta;
    }

    public Integer getAseId() {
        return aseId;
    }

    public void setAseId(Integer aseId) {
        this.aseId = aseId;
    }

    public String getAseFecha() {
        return aseFecha;
    }

    public void setAseFecha(String aseFecha) {
        this.aseFecha = aseFecha;
    }

    public String getAseTarea() {
        return aseTarea;
    }

    public void setAseTarea(String aseTarea) {
        this.aseTarea = aseTarea;
    }

    public String getAseEjecuta() {
        return aseEjecuta;
    }

    public void setAseEjecuta(String aseEjecuta) {
        this.aseEjecuta = aseEjecuta;
    }

    public EtbInvServidor getAseServidor() {
        return aseServidor;
    }

    public void setAseServidor(EtbInvServidor aseServidor) {
        this.aseServidor = aseServidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aseId != null ? aseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvAseguramiento)) {
            return false;
        }
        EtbInvAseguramiento other = (EtbInvAseguramiento) object;
        if ((this.aseId == null && other.aseId != null) || (this.aseId != null && !this.aseId.equals(other.aseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvAseguramiento[ aseId=" + aseId + " ]";
    }
    
}
