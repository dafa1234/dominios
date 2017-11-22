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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_item_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvItemEvaluacion.findAll", query = "SELECT e FROM EtbInvItemEvaluacion e")
    , @NamedQuery(name = "EtbInvItemEvaluacion.findByIteId", query = "SELECT e FROM EtbInvItemEvaluacion e WHERE e.iteId = :iteId")
    , @NamedQuery(name = "EtbInvItemEvaluacion.findByIteItemId", query = "SELECT e FROM EtbInvItemEvaluacion e WHERE e.iteItemId = :iteItemId")
    , @NamedQuery(name = "EtbInvItemEvaluacion.findByIteServ", query = "SELECT e FROM EtbInvItemEvaluacion e WHERE e.iteServ = :iteServ")
    , @NamedQuery(name = "EtbInvItemEvaluacion.findByIteEstado", query = "SELECT e FROM EtbInvItemEvaluacion e WHERE e.iteEstado = :iteEstado")
    , @NamedQuery(name = "EtbInvItemEvaluacion.findByIteCriticidad", query = "SELECT e FROM EtbInvItemEvaluacion e WHERE e.iteCriticidad = :iteCriticidad")
    , @NamedQuery(name = "EtbInvItemEvaluacion.findByItePlanAccion", query = "SELECT e FROM EtbInvItemEvaluacion e WHERE e.itePlanAccion = :itePlanAccion")})
public class EtbInvItemEvaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ITE_ID")
    private Integer iteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITE_ITEM_ID")
    private int iteItemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ITE_SERV")
    private String iteServ;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ITE_ESTADO")
    private String iteEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITE_CRITICIDAD")
    private int iteCriticidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ITE_PLAN_ACCION")
    private String itePlanAccion;

    public EtbInvItemEvaluacion() {
    }

    public EtbInvItemEvaluacion(Integer iteId) {
        this.iteId = iteId;
    }

    public EtbInvItemEvaluacion(Integer iteId, int iteItemId, String iteServ, String iteEstado, int iteCriticidad, String itePlanAccion) {
        this.iteId = iteId;
        this.iteItemId = iteItemId;
        this.iteServ = iteServ;
        this.iteEstado = iteEstado;
        this.iteCriticidad = iteCriticidad;
        this.itePlanAccion = itePlanAccion;
    }

    public Integer getIteId() {
        return iteId;
    }

    public void setIteId(Integer iteId) {
        this.iteId = iteId;
    }

    public int getIteItemId() {
        return iteItemId;
    }

    public void setIteItemId(int iteItemId) {
        this.iteItemId = iteItemId;
    }

    public String getIteServ() {
        return iteServ;
    }

    public void setIteServ(String iteServ) {
        this.iteServ = iteServ;
    }

    public String getIteEstado() {
        return iteEstado;
    }

    public void setIteEstado(String iteEstado) {
        this.iteEstado = iteEstado;
    }

    public int getIteCriticidad() {
        return iteCriticidad;
    }

    public void setIteCriticidad(int iteCriticidad) {
        this.iteCriticidad = iteCriticidad;
    }

    public String getItePlanAccion() {
        return itePlanAccion;
    }

    public void setItePlanAccion(String itePlanAccion) {
        this.itePlanAccion = itePlanAccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iteId != null ? iteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvItemEvaluacion)) {
            return false;
        }
        EtbInvItemEvaluacion other = (EtbInvItemEvaluacion) object;
        if ((this.iteId == null && other.iteId != null) || (this.iteId != null && !this.iteId.equals(other.iteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvItemEvaluacion[ iteId=" + iteId + " ]";
    }
    
}
