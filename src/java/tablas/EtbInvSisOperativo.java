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
@Table(name = "etb_inv_sis_operativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvSisOperativo.findAll", query = "SELECT e FROM EtbInvSisOperativo e")
    , @NamedQuery(name = "EtbInvSisOperativo.findBySisIdSisOperativo", query = "SELECT e FROM EtbInvSisOperativo e WHERE e.sisIdSisOperativo = :sisIdSisOperativo")
    , @NamedQuery(name = "EtbInvSisOperativo.findBySisDistribucion", query = "SELECT e FROM EtbInvSisOperativo e WHERE e.sisDistribucion = :sisDistribucion")
    , @NamedQuery(name = "EtbInvSisOperativo.findBySisNombre", query = "SELECT e FROM EtbInvSisOperativo e WHERE e.sisNombre = :sisNombre")})
public class EtbInvSisOperativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SIS_ID_SIS_OPERATIVO")
    private Integer sisIdSisOperativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIS_DISTRIBUCION")
    private int sisDistribucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "SIS_NOMBRE")
    private String sisNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sisIdSisOperativo")
    private Collection<EtbInvServidor> etbInvServidorCollection;

    public EtbInvSisOperativo() {
    }

    public EtbInvSisOperativo(Integer sisIdSisOperativo) {
        this.sisIdSisOperativo = sisIdSisOperativo;
    }

    public EtbInvSisOperativo(Integer sisIdSisOperativo, int sisDistribucion, String sisNombre) {
        this.sisIdSisOperativo = sisIdSisOperativo;
        this.sisDistribucion = sisDistribucion;
        this.sisNombre = sisNombre;
    }

    public Integer getSisIdSisOperativo() {
        return sisIdSisOperativo;
    }

    public void setSisIdSisOperativo(Integer sisIdSisOperativo) {
        this.sisIdSisOperativo = sisIdSisOperativo;
    }

    public int getSisDistribucion() {
        return sisDistribucion;
    }

    public void setSisDistribucion(int sisDistribucion) {
        this.sisDistribucion = sisDistribucion;
    }

    public String getSisNombre() {
        return sisNombre;
    }

    public void setSisNombre(String sisNombre) {
        this.sisNombre = sisNombre;
    }

    @XmlTransient
    public Collection<EtbInvServidor> getEtbInvServidorCollection() {
        return etbInvServidorCollection;
    }

    public void setEtbInvServidorCollection(Collection<EtbInvServidor> etbInvServidorCollection) {
        this.etbInvServidorCollection = etbInvServidorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisIdSisOperativo != null ? sisIdSisOperativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvSisOperativo)) {
            return false;
        }
        EtbInvSisOperativo other = (EtbInvSisOperativo) object;
        if ((this.sisIdSisOperativo == null && other.sisIdSisOperativo != null) || (this.sisIdSisOperativo != null && !this.sisIdSisOperativo.equals(other.sisIdSisOperativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvSisOperativo[ sisIdSisOperativo=" + sisIdSisOperativo + " ]";
    }
    
}
