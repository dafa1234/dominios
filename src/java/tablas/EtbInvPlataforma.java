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
@Table(name = "etb_inv_plataforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvPlataforma.findAll", query = "SELECT e FROM EtbInvPlataforma e")
    , @NamedQuery(name = "EtbInvPlataforma.findByPlaIdPlataforma", query = "SELECT e FROM EtbInvPlataforma e WHERE e.plaIdPlataforma = :plaIdPlataforma")
    , @NamedQuery(name = "EtbInvPlataforma.findByPlaNomPlataforma", query = "SELECT e FROM EtbInvPlataforma e WHERE e.plaNomPlataforma = :plaNomPlataforma")
    , @NamedQuery(name = "EtbInvPlataforma.findByPlaAdmPlataforma", query = "SELECT e FROM EtbInvPlataforma e WHERE e.plaAdmPlataforma = :plaAdmPlataforma")})
public class EtbInvPlataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLA_ID_PLATAFORMA")
    private Integer plaIdPlataforma;
    @Size(max = 25)
    @Column(name = "PLA_NOM_PLATAFORMA")
    private String plaNomPlataforma;
    @Column(name = "PLA_ADM_PLATAFORMA")
    private Integer plaAdmPlataforma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plaIdPlataforma")
    private Collection<EtbInvServidor> etbInvServidorCollection;

    public EtbInvPlataforma() {
    }

    public EtbInvPlataforma(Integer plaIdPlataforma) {
        this.plaIdPlataforma = plaIdPlataforma;
    }

    public Integer getPlaIdPlataforma() {
        return plaIdPlataforma;
    }

    public void setPlaIdPlataforma(Integer plaIdPlataforma) {
        this.plaIdPlataforma = plaIdPlataforma;
    }

    public String getPlaNomPlataforma() {
        return plaNomPlataforma;
    }

    public void setPlaNomPlataforma(String plaNomPlataforma) {
        this.plaNomPlataforma = plaNomPlataforma;
    }

    public Integer getPlaAdmPlataforma() {
        return plaAdmPlataforma;
    }

    public void setPlaAdmPlataforma(Integer plaAdmPlataforma) {
        this.plaAdmPlataforma = plaAdmPlataforma;
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
        hash += (plaIdPlataforma != null ? plaIdPlataforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvPlataforma)) {
            return false;
        }
        EtbInvPlataforma other = (EtbInvPlataforma) object;
        if ((this.plaIdPlataforma == null && other.plaIdPlataforma != null) || (this.plaIdPlataforma != null && !this.plaIdPlataforma.equals(other.plaIdPlataforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvPlataforma[ plaIdPlataforma=" + plaIdPlataforma + " ]";
    }
    
}
