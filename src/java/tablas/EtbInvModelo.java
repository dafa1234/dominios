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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_modelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvModelo.findAll", query = "SELECT e FROM EtbInvModelo e")
    , @NamedQuery(name = "EtbInvModelo.findByModIdModelo", query = "SELECT e FROM EtbInvModelo e WHERE e.modIdModelo = :modIdModelo")
    , @NamedQuery(name = "EtbInvModelo.findByModNomModelo", query = "SELECT e FROM EtbInvModelo e WHERE e.modNomModelo = :modNomModelo")})
public class EtbInvModelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MOD_ID_MODELO")
    private Integer modIdModelo;
    @Size(max = 25)
    @Column(name = "MOD_NOM_MODELO")
    private String modNomModelo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modIdModelo")
    private Collection<EtbInvServidor> etbInvServidorCollection;
    @JoinColumn(name = "MAR_ID_MARCA", referencedColumnName = "MAR_ID_MARCA")
    @ManyToOne
    private EtbInvMarca marIdMarca;

    public EtbInvModelo() {
    }

    public EtbInvModelo(Integer modIdModelo) {
        this.modIdModelo = modIdModelo;
    }

    public Integer getModIdModelo() {
        return modIdModelo;
    }

    public void setModIdModelo(Integer modIdModelo) {
        this.modIdModelo = modIdModelo;
    }

    public String getModNomModelo() {
        return modNomModelo;
    }

    public void setModNomModelo(String modNomModelo) {
        this.modNomModelo = modNomModelo;
    }

    @XmlTransient
    public Collection<EtbInvServidor> getEtbInvServidorCollection() {
        return etbInvServidorCollection;
    }

    public void setEtbInvServidorCollection(Collection<EtbInvServidor> etbInvServidorCollection) {
        this.etbInvServidorCollection = etbInvServidorCollection;
    }

    public EtbInvMarca getMarIdMarca() {
        return marIdMarca;
    }

    public void setMarIdMarca(EtbInvMarca marIdMarca) {
        this.marIdMarca = marIdMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modIdModelo != null ? modIdModelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvModelo)) {
            return false;
        }
        EtbInvModelo other = (EtbInvModelo) object;
        if ((this.modIdModelo == null && other.modIdModelo != null) || (this.modIdModelo != null && !this.modIdModelo.equals(other.modIdModelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvModelo[ modIdModelo=" + modIdModelo + " ]";
    }
    
}
