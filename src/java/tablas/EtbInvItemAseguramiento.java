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
@Table(name = "etb_inv_item_aseguramiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvItemAseguramiento.findAll", query = "SELECT e FROM EtbInvItemAseguramiento e")
    , @NamedQuery(name = "EtbInvItemAseguramiento.findByItaId", query = "SELECT e FROM EtbInvItemAseguramiento e WHERE e.itaId = :itaId")
    , @NamedQuery(name = "EtbInvItemAseguramiento.findByItaDescrip", query = "SELECT e FROM EtbInvItemAseguramiento e WHERE e.itaDescrip = :itaDescrip")
    , @NamedQuery(name = "EtbInvItemAseguramiento.findByItaSo", query = "SELECT e FROM EtbInvItemAseguramiento e WHERE e.itaSo = :itaSo")
    , @NamedQuery(name = "EtbInvItemAseguramiento.findByItaNombre", query = "SELECT e FROM EtbInvItemAseguramiento e WHERE e.itaNombre = :itaNombre")
    , @NamedQuery(name = "EtbInvItemAseguramiento.findByItaActividad", query = "SELECT e FROM EtbInvItemAseguramiento e WHERE e.itaActividad = :itaActividad")})
public class EtbInvItemAseguramiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITA_ID")
    private Integer itaId;
    @Size(max = 255)
    @Column(name = "ITA_DESCRIP")
    private String itaDescrip;
    @Size(max = 255)
    @Column(name = "ITA_SO")
    private String itaSo;
    @Size(max = 255)
    @Column(name = "ITA_NOMBRE")
    private String itaNombre;
    @Size(max = 255)
    @Column(name = "ITA_ACTIVIDAD")
    private String itaActividad;

    public EtbInvItemAseguramiento() {
    }

    public EtbInvItemAseguramiento(Integer itaId) {
        this.itaId = itaId;
    }

    public Integer getItaId() {
        return itaId;
    }

    public void setItaId(Integer itaId) {
        this.itaId = itaId;
    }

    public String getItaDescrip() {
        return itaDescrip;
    }

    public void setItaDescrip(String itaDescrip) {
        this.itaDescrip = itaDescrip;
    }

    public String getItaSo() {
        return itaSo;
    }

    public void setItaSo(String itaSo) {
        this.itaSo = itaSo;
    }

    public String getItaNombre() {
        return itaNombre;
    }

    public void setItaNombre(String itaNombre) {
        this.itaNombre = itaNombre;
    }

    public String getItaActividad() {
        return itaActividad;
    }

    public void setItaActividad(String itaActividad) {
        this.itaActividad = itaActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itaId != null ? itaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvItemAseguramiento)) {
            return false;
        }
        EtbInvItemAseguramiento other = (EtbInvItemAseguramiento) object;
        if ((this.itaId == null && other.itaId != null) || (this.itaId != null && !this.itaId.equals(other.itaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvItemAseguramiento[ itaId=" + itaId + " ]";
    }
    
}
