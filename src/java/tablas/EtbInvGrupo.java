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
@Table(name = "etb_inv_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvGrupo.findAll", query = "SELECT e FROM EtbInvGrupo e")
    , @NamedQuery(name = "EtbInvGrupo.findByGruIdGrupo", query = "SELECT e FROM EtbInvGrupo e WHERE e.gruIdGrupo = :gruIdGrupo")
    , @NamedQuery(name = "EtbInvGrupo.findByGruNomGrupo", query = "SELECT e FROM EtbInvGrupo e WHERE e.gruNomGrupo = :gruNomGrupo")
    , @NamedQuery(name = "EtbInvGrupo.findByGruTipoGrupo", query = "SELECT e FROM EtbInvGrupo e WHERE e.gruTipoGrupo = :gruTipoGrupo")})
public class EtbInvGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GRU_ID_GRUPO")
    private Integer gruIdGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "GRU_NOM_GRUPO")
    private String gruNomGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "GRU_TIPO_GRUPO")
    private String gruTipoGrupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gruIdGrupo")
    private Collection<EtbInvServidor> etbInvServidorCollection;

    public EtbInvGrupo() {
    }

    public EtbInvGrupo(Integer gruIdGrupo) {
        this.gruIdGrupo = gruIdGrupo;
    }

    public EtbInvGrupo(Integer gruIdGrupo, String gruNomGrupo, String gruTipoGrupo) {
        this.gruIdGrupo = gruIdGrupo;
        this.gruNomGrupo = gruNomGrupo;
        this.gruTipoGrupo = gruTipoGrupo;
    }
    public EtbInvGrupo(String Ngrupo, String Tgrupo) {
         this.gruNomGrupo = Ngrupo;
        this.gruTipoGrupo = Tgrupo;
    }

    public Integer getGruIdGrupo() {
        return gruIdGrupo;
    }

    public void setGruIdGrupo(Integer gruIdGrupo) {
        this.gruIdGrupo = gruIdGrupo;
    }

    public String getGruNomGrupo() {
        return gruNomGrupo;
    }

    public void setGruNomGrupo(String gruNomGrupo) {
        this.gruNomGrupo = gruNomGrupo;
    }

    public String getGruTipoGrupo() {
        return gruTipoGrupo;
    }

    public void setGruTipoGrupo(String gruTipoGrupo) {
        this.gruTipoGrupo = gruTipoGrupo;
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
        hash += (gruIdGrupo != null ? gruIdGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvGrupo)) {
            return false;
        }
        EtbInvGrupo other = (EtbInvGrupo) object;
        if ((this.gruIdGrupo == null && other.gruIdGrupo != null) || (this.gruIdGrupo != null && !this.gruIdGrupo.equals(other.gruIdGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvGrupo[ gruIdGrupo=" + gruIdGrupo + " ]";
    }
    
}
