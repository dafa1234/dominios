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
import javax.persistence.Id;
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
@Table(name = "etb_inv_tabla_dominios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvTablaDominios.findAll", query = "SELECT e FROM EtbInvTablaDominios e")
    , @NamedQuery(name = "EtbInvTablaDominios.findByTabID", query = "SELECT e FROM EtbInvTablaDominios e WHERE e.tabID = :tabID")
    , @NamedQuery(name = "EtbInvTablaDominios.findByTabNombre", query = "SELECT e FROM EtbInvTablaDominios e WHERE e.tabNombre = :tabNombre")})
public class EtbInvTablaDominios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tab_ID")
    private Integer tabID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tab_nombre")
    private String tabNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tabId")
    private Collection<EtbInvCambioTabla> etbInvCambioTablaCollection;

    public EtbInvTablaDominios() {
    }

    public EtbInvTablaDominios(Integer tabID) {
        this.tabID = tabID;
    }

    public EtbInvTablaDominios(Integer tabID, String tabNombre) {
        this.tabID = tabID;
        this.tabNombre = tabNombre;
    }

    public Integer getTabID() {
        return tabID;
    }

    public void setTabID(Integer tabID) {
        this.tabID = tabID;
    }

    public String getTabNombre() {
        return tabNombre;
    }

    public void setTabNombre(String tabNombre) {
        this.tabNombre = tabNombre;
    }

    @XmlTransient
    public Collection<EtbInvCambioTabla> getEtbInvCambioTablaCollection() {
        return etbInvCambioTablaCollection;
    }

    public void setEtbInvCambioTablaCollection(Collection<EtbInvCambioTabla> etbInvCambioTablaCollection) {
        this.etbInvCambioTablaCollection = etbInvCambioTablaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tabID != null ? tabID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvTablaDominios)) {
            return false;
        }
        EtbInvTablaDominios other = (EtbInvTablaDominios) object;
        if ((this.tabID == null && other.tabID != null) || (this.tabID != null && !this.tabID.equals(other.tabID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvTablaDominios[ tabID=" + tabID + " ]";
    }
    
}
