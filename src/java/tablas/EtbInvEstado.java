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
@Table(name = "etb_inv_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvEstado.findAll", query = "SELECT e FROM EtbInvEstado e")
    , @NamedQuery(name = "EtbInvEstado.findByEstIdEstado", query = "SELECT e FROM EtbInvEstado e WHERE e.estIdEstado = :estIdEstado")
    , @NamedQuery(name = "EtbInvEstado.findByEstEstado", query = "SELECT e FROM EtbInvEstado e WHERE e.estEstado = :estEstado")})
public class EtbInvEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EST_ID_ESTADO")
    private Integer estIdEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "EST_ESTADO")
    private String estEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estIdEstado")
    private Collection<EtbInvServidor> etbInvServidorCollection;

    public EtbInvEstado() {
    }

    public EtbInvEstado(Integer estIdEstado) {
        this.estIdEstado = estIdEstado;
    }

    public EtbInvEstado(Integer estIdEstado, String estEstado) {
        this.estIdEstado = estIdEstado;
        this.estEstado = estEstado;
    }

    public Integer getEstIdEstado() {
        return estIdEstado;
    }

    public void setEstIdEstado(Integer estIdEstado) {
        this.estIdEstado = estIdEstado;
    }

    public String getEstEstado() {
        return estEstado;
    }

    public void setEstEstado(String estEstado) {
        this.estEstado = estEstado;
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
        hash += (estIdEstado != null ? estIdEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvEstado)) {
            return false;
        }
        EtbInvEstado other = (EtbInvEstado) object;
        if ((this.estIdEstado == null && other.estIdEstado != null) || (this.estIdEstado != null && !this.estIdEstado.equals(other.estIdEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvEstado[ estIdEstado=" + estIdEstado + " ]";
    }
    
}
