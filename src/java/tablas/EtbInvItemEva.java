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
import javax.persistence.Lob;
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
@Table(name = "etb_inv_item_eva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvItemEva.findAll", query = "SELECT e FROM EtbInvItemEva e")
    , @NamedQuery(name = "EtbInvItemEva.findByItmId", query = "SELECT e FROM EtbInvItemEva e WHERE e.itmId = :itmId")
    , @NamedQuery(name = "EtbInvItemEva.findByItmServ", query = "SELECT e FROM EtbInvItemEva e WHERE e.itmServ = :itmServ")
    , @NamedQuery(name = "EtbInvItemEva.findByItmEstado", query = "SELECT e FROM EtbInvItemEva e WHERE e.itmEstado = :itmEstado")
    , @NamedQuery(name = "EtbInvItemEva.findByItmTipo", query = "SELECT e FROM EtbInvItemEva e WHERE e.itmTipo = :itmTipo")
    , @NamedQuery(name = "EtbInvItemEva.findByItmCriticidad", query = "SELECT e FROM EtbInvItemEva e WHERE e.itmCriticidad = :itmCriticidad")
    , @NamedQuery(name = "EtbInvItemEva.findByItmPlanAccion", query = "SELECT e FROM EtbInvItemEva e WHERE e.itmPlanAccion = :itmPlanAccion")})
public class EtbInvItemEva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ITM_ID")
    private Integer itmId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ITM_SERV")
    private String itmServ;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ESTADO")
    private String itmEstado;
    @Column(name = "ITM_TIPO")
    private Integer itmTipo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "ITM_DESCRIP")
    private String itmDescrip;
    @Lob
    @Size(max = 16777215)
    @Column(name = "ITM_DETALLE")
    private String itmDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITM_CRITICIDAD")
    private int itmCriticidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ITM_PLAN_ACCION")
    private String itmPlanAccion;

    public EtbInvItemEva() {
    }

    public EtbInvItemEva(Integer itmId) {
        this.itmId = itmId;
    }

    public EtbInvItemEva(Integer itmId, String itmServ, String itmEstado, int itmCriticidad, String itmPlanAccion) {
        this.itmId = itmId;
        this.itmServ = itmServ;
        this.itmEstado = itmEstado;
        this.itmCriticidad = itmCriticidad;
        this.itmPlanAccion = itmPlanAccion;
    }

    public Integer getItmId() {
        return itmId;
    }

    public void setItmId(Integer itmId) {
        this.itmId = itmId;
    }

    public String getItmServ() {
        return itmServ;
    }

    public void setItmServ(String itmServ) {
        this.itmServ = itmServ;
    }

    public String getItmEstado() {
        return itmEstado;
    }

    public void setItmEstado(String itmEstado) {
        this.itmEstado = itmEstado;
    }

    public Integer getItmTipo() {
        return itmTipo;
    }

    public void setItmTipo(Integer itmTipo) {
        this.itmTipo = itmTipo;
    }

    public String getItmDescrip() {
        return itmDescrip;
    }

    public void setItmDescrip(String itmDescrip) {
        this.itmDescrip = itmDescrip;
    }

    public String getItmDetalle() {
        return itmDetalle;
    }

    public void setItmDetalle(String itmDetalle) {
        this.itmDetalle = itmDetalle;
    }

    public int getItmCriticidad() {
        return itmCriticidad;
    }

    public void setItmCriticidad(int itmCriticidad) {
        this.itmCriticidad = itmCriticidad;
    }

    public String getItmPlanAccion() {
        return itmPlanAccion;
    }

    public void setItmPlanAccion(String itmPlanAccion) {
        this.itmPlanAccion = itmPlanAccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itmId != null ? itmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvItemEva)) {
            return false;
        }
        EtbInvItemEva other = (EtbInvItemEva) object;
        if ((this.itmId == null && other.itmId != null) || (this.itmId != null && !this.itmId.equals(other.itmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvItemEva[ itmId=" + itmId + " ]";
    }
    
}
