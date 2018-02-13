/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_cambio_tabla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvCambioTabla.findAll", query = "SELECT e FROM EtbInvCambioTabla e")
    , @NamedQuery(name = "EtbInvCambioTabla.findByCamtabID", query = "SELECT e FROM EtbInvCambioTabla e WHERE e.camtabID = :camtabID")
    , @NamedQuery(name = "EtbInvCambioTabla.findByTabIdtabla", query = "SELECT e FROM EtbInvCambioTabla e WHERE e.tabIdtabla = :tabIdtabla")
    , @NamedQuery(name = "EtbInvCambioTabla.findByCamTabFecha", query = "SELECT e FROM EtbInvCambioTabla e WHERE e.camTabFecha = :camTabFecha")
    , @NamedQuery(name = "EtbInvCambioTabla.findByCamtabSM", query = "SELECT e FROM EtbInvCambioTabla e WHERE e.camtabSM = :camtabSM")
    , @NamedQuery(name = "EtbInvCambioTabla.findByCamtabdescripcionSM", query = "SELECT e FROM EtbInvCambioTabla e WHERE e.camtabdescripcionSM = :camtabdescripcionSM")
    , @NamedQuery(name = "EtbInvCambioTabla.findByCamtabsolicitanteSM", query = "SELECT e FROM EtbInvCambioTabla e WHERE e.camtabsolicitanteSM = :camtabsolicitanteSM")})
public class EtbInvCambioTabla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cam_tab_ID")
    private Integer camtabID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tab_idtabla")
    private int tabIdtabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cam_tab_fecha")
    private String camTabFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cam_tab_SM")
    private String camtabSM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cam_tab_descripcion_SM")
    private String camtabdescripcionSM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cam_tab_solicitante_SM")
    private String camtabsolicitanteSM;
    @JoinColumn(name = "tab_id", referencedColumnName = "tab_ID")
    @ManyToOne(optional = false)
    private EtbInvTablaDominios tabId;
    @JoinColumn(name = "usu_etb", referencedColumnName = "USU_ID")
    @ManyToOne(optional = false)
    private EtbInvUsuarioAp usuEtb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detCamIdtabla")
    private Collection<EtbInvDetalleCambioTabla> etbInvDetalleCambioTablaCollection;

    public EtbInvCambioTabla() {
    }

    public EtbInvCambioTabla(Integer camtabID) {
        this.camtabID = camtabID;
    }

    public EtbInvCambioTabla(Integer camtabID, int tabIdtabla, String camTabFecha, String camtabSM, String camtabdescripcionSM, String camtabsolicitanteSM) {
        this.camtabID = camtabID;
        this.tabIdtabla = tabIdtabla;
        this.camTabFecha = camTabFecha;
        this.camtabSM = camtabSM;
        this.camtabdescripcionSM = camtabdescripcionSM;
        this.camtabsolicitanteSM = camtabsolicitanteSM;
    }

    public Integer getCamtabID() {
        return camtabID;
    }

    public void setCamtabID(Integer camtabID) {
        this.camtabID = camtabID;
    }

    public int getTabIdtabla() {
        return tabIdtabla;
    }

    public void setTabIdtabla(int tabIdtabla) {
        this.tabIdtabla = tabIdtabla;
    }

    public String getCamTabFecha() {
        return camTabFecha;
    }

    public void setCamTabFecha(String camTabFecha) {
        this.camTabFecha = camTabFecha;
    }

    public String getCamtabSM() {
        return camtabSM;
    }

    public void setCamtabSM(String camtabSM) {
        this.camtabSM = camtabSM;
    }

    public String getCamtabdescripcionSM() {
        return camtabdescripcionSM;
    }

    public void setCamtabdescripcionSM(String camtabdescripcionSM) {
        this.camtabdescripcionSM = camtabdescripcionSM;
    }

    public String getCamtabsolicitanteSM() {
        return camtabsolicitanteSM;
    }

    public void setCamtabsolicitanteSM(String camtabsolicitanteSM) {
        this.camtabsolicitanteSM = camtabsolicitanteSM;
    }

    public EtbInvTablaDominios getTabId() {
        return tabId;
    }

    public void setTabId(EtbInvTablaDominios tabId) {
        this.tabId = tabId;
    }

    public EtbInvUsuarioAp getUsuEtb() {
        return usuEtb;
    }

    public void setUsuEtb(EtbInvUsuarioAp usuEtb) {
        this.usuEtb = usuEtb;
    }

    @XmlTransient
    public Collection<EtbInvDetalleCambioTabla> getEtbInvDetalleCambioTablaCollection() {
        return etbInvDetalleCambioTablaCollection;
    }

    public void setEtbInvDetalleCambioTablaCollection(Collection<EtbInvDetalleCambioTabla> etbInvDetalleCambioTablaCollection) {
        this.etbInvDetalleCambioTablaCollection = etbInvDetalleCambioTablaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (camtabID != null ? camtabID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvCambioTabla)) {
            return false;
        }
        EtbInvCambioTabla other = (EtbInvCambioTabla) object;
        if ((this.camtabID == null && other.camtabID != null) || (this.camtabID != null && !this.camtabID.equals(other.camtabID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvCambioTabla[ camtabID=" + camtabID + " ]";
    }
    
}
