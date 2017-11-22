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
@Table(name = "etb_inv_detalle_aseg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvDetalleAseg.findAll", query = "SELECT e FROM EtbInvDetalleAseg e")
    , @NamedQuery(name = "EtbInvDetalleAseg.findByDetaId", query = "SELECT e FROM EtbInvDetalleAseg e WHERE e.detaId = :detaId")
    , @NamedQuery(name = "EtbInvDetalleAseg.findByDetaItemId", query = "SELECT e FROM EtbInvDetalleAseg e WHERE e.detaItemId = :detaItemId")
    , @NamedQuery(name = "EtbInvDetalleAseg.findByDetaEstado", query = "SELECT e FROM EtbInvDetalleAseg e WHERE e.detaEstado = :detaEstado")
    , @NamedQuery(name = "EtbInvDetalleAseg.findByDetaObserv", query = "SELECT e FROM EtbInvDetalleAseg e WHERE e.detaObserv = :detaObserv")
    , @NamedQuery(name = "EtbInvDetalleAseg.findByDetaServ", query = "SELECT e FROM EtbInvDetalleAseg e WHERE e.detaServ = :detaServ")})
public class EtbInvDetalleAseg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DETA_ID")
    private Integer detaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DETA_ITEM_ID")
    private String detaItemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DETA_ESTADO")
    private String detaEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "DETA_OBSERV")
    private String detaObserv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DETA_SERV")
    private String detaServ;

    public EtbInvDetalleAseg() {
    }

    public EtbInvDetalleAseg(Integer detaId) {
        this.detaId = detaId;
    }

    public EtbInvDetalleAseg(Integer detaId, String detaItemId, String detaEstado, String detaObserv, String detaServ) {
        this.detaId = detaId;
        this.detaItemId = detaItemId;
        this.detaEstado = detaEstado;
        this.detaObserv = detaObserv;
        this.detaServ = detaServ;
    }

    public Integer getDetaId() {
        return detaId;
    }

    public void setDetaId(Integer detaId) {
        this.detaId = detaId;
    }

    public String getDetaItemId() {
        return detaItemId;
    }

    public void setDetaItemId(String detaItemId) {
        this.detaItemId = detaItemId;
    }

    public String getDetaEstado() {
        return detaEstado;
    }

    public void setDetaEstado(String detaEstado) {
        this.detaEstado = detaEstado;
    }

    public String getDetaObserv() {
        return detaObserv;
    }

    public void setDetaObserv(String detaObserv) {
        this.detaObserv = detaObserv;
    }

    public String getDetaServ() {
        return detaServ;
    }

    public void setDetaServ(String detaServ) {
        this.detaServ = detaServ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detaId != null ? detaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvDetalleAseg)) {
            return false;
        }
        EtbInvDetalleAseg other = (EtbInvDetalleAseg) object;
        if ((this.detaId == null && other.detaId != null) || (this.detaId != null && !this.detaId.equals(other.detaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvDetalleAseg[ detaId=" + detaId + " ]";
    }
    
}
