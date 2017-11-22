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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_usu_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvUsuEstado.findAll", query = "SELECT e FROM EtbInvUsuEstado e")
    , @NamedQuery(name = "EtbInvUsuEstado.findByUsusEstado", query = "SELECT e FROM EtbInvUsuEstado e WHERE e.ususEstado = :ususEstado")
    , @NamedQuery(name = "EtbInvUsuEstado.findByEstuEstado", query = "SELECT e FROM EtbInvUsuEstado e WHERE e.estuEstado = :estuEstado")})
public class EtbInvUsuEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USUS_ESTADO")
    private Integer ususEstado;
    @Size(max = 50)
    @Column(name = "ESTU_ESTADO")
    private String estuEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ususEstado")
    private Collection<EtbInvUsuServ> etbInvUsuServCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ususEstado")
    private Collection<EtbInvCamusuServ> etbInvCamusuServCollection;

    public EtbInvUsuEstado() {
    }

    public EtbInvUsuEstado(Integer ususEstado) {
        this.ususEstado = ususEstado;
    }

    public Integer getUsusEstado() {
        return ususEstado;
    }

    public void setUsusEstado(Integer ususEstado) {
        this.ususEstado = ususEstado;
    }

    public String getEstuEstado() {
        return estuEstado;
    }

    public void setEstuEstado(String estuEstado) {
        this.estuEstado = estuEstado;
    }

    @XmlTransient
    public Collection<EtbInvUsuServ> getEtbInvUsuServCollection() {
        return etbInvUsuServCollection;
    }

    public void setEtbInvUsuServCollection(Collection<EtbInvUsuServ> etbInvUsuServCollection) {
        this.etbInvUsuServCollection = etbInvUsuServCollection;
    }

    @XmlTransient
    public Collection<EtbInvCamusuServ> getEtbInvCamusuServCollection() {
        return etbInvCamusuServCollection;
    }

    public void setEtbInvCamusuServCollection(Collection<EtbInvCamusuServ> etbInvCamusuServCollection) {
        this.etbInvCamusuServCollection = etbInvCamusuServCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ususEstado != null ? ususEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvUsuEstado)) {
            return false;
        }
        EtbInvUsuEstado other = (EtbInvUsuEstado) object;
        if ((this.ususEstado == null && other.ususEstado != null) || (this.ususEstado != null && !this.ususEstado.equals(other.ususEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvUsuEstado[ ususEstado=" + ususEstado + " ]";
    }
    
}
