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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_dominio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvDominio.findAll", query = "SELECT e FROM EtbInvDominio e")
    , @NamedQuery(name = "EtbInvDominio.findByIdDominio", query = "SELECT e FROM EtbInvDominio e WHERE e.idDominio = :idDominio")
    , @NamedQuery(name = "EtbInvDominio.findByDomId", query = "SELECT e FROM EtbInvDominio e WHERE e.domId = :domId")
    , @NamedQuery(name = "EtbInvDominio.findByDomDominio", query = "SELECT e FROM EtbInvDominio e WHERE e.domDominio = :domDominio")})
public class EtbInvDominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dominio")
    private Integer idDominio;
    @Column(name = "DOM_ID")
    private Integer domId;
    @Size(max = 40)
    @Column(name = "DOM_DOMINIO")
    private String domDominio;

    public EtbInvDominio() {
    }

    public EtbInvDominio(Integer idDominio) {
        this.idDominio = idDominio;
    }

    public Integer getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(Integer idDominio) {
        this.idDominio = idDominio;
    }

    public Integer getDomId() {
        return domId;
    }

    public void setDomId(Integer domId) {
        this.domId = domId;
    }

    public String getDomDominio() {
        return domDominio;
    }

    public void setDomDominio(String domDominio) {
        this.domDominio = domDominio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDominio != null ? idDominio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvDominio)) {
            return false;
        }
        EtbInvDominio other = (EtbInvDominio) object;
        if ((this.idDominio == null && other.idDominio != null) || (this.idDominio != null && !this.idDominio.equals(other.idDominio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvDominio[ idDominio=" + idDominio + " ]";
    }
    
}
