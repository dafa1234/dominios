/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "etb_inv_adm_plataforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvAdmPlataforma.findAll", query = "SELECT e FROM EtbInvAdmPlataforma e")
    , @NamedQuery(name = "EtbInvAdmPlataforma.findByAdmId", query = "SELECT e FROM EtbInvAdmPlataforma e WHERE e.admId = :admId")
    , @NamedQuery(name = "EtbInvAdmPlataforma.findByAdmNombre", query = "SELECT e FROM EtbInvAdmPlataforma e WHERE e.admNombre = :admNombre")
    , @NamedQuery(name = "EtbInvAdmPlataforma.findByAdmTelefono", query = "SELECT e FROM EtbInvAdmPlataforma e WHERE e.admTelefono = :admTelefono")
    , @NamedQuery(name = "EtbInvAdmPlataforma.findByAdmArea", query = "SELECT e FROM EtbInvAdmPlataforma e WHERE e.admArea = :admArea")
    , @NamedQuery(name = "EtbInvAdmPlataforma.findByAdmCorreo", query = "SELECT e FROM EtbInvAdmPlataforma e WHERE e.admCorreo = :admCorreo")})
public class EtbInvAdmPlataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADM_ID")
    private Integer admId;
    @Size(max = 255)
    @Column(name = "ADM_NOMBRE")
    private String admNombre;
    @Size(max = 255)
    @Column(name = "ADM_TELEFONO")
    private String admTelefono;
    @Size(max = 255)
    @Column(name = "ADM_AREA")
    private String admArea;
    @Size(max = 255)
    @Column(name = "ADM_CORREO")
    private String admCorreo;
    @OneToMany(mappedBy = "plaAdmPlataforma")
    private Collection<EtbInvPlataforma> etbInvPlataformaCollection;

    public EtbInvAdmPlataforma() {
    }

    public EtbInvAdmPlataforma(Integer admId) {
        this.admId = admId;
    }

    public Integer getAdmId() {
        return admId;
    }

    public void setAdmId(Integer admId) {
        this.admId = admId;
    }

    public String getAdmNombre() {
        return admNombre;
    }

    public void setAdmNombre(String admNombre) {
        this.admNombre = admNombre;
    }

    public String getAdmTelefono() {
        return admTelefono;
    }

    public void setAdmTelefono(String admTelefono) {
        this.admTelefono = admTelefono;
    }

    public String getAdmArea() {
        return admArea;
    }

    public void setAdmArea(String admArea) {
        this.admArea = admArea;
    }

    public String getAdmCorreo() {
        return admCorreo;
    }

    public void setAdmCorreo(String admCorreo) {
        this.admCorreo = admCorreo;
    }

    @XmlTransient
    public Collection<EtbInvPlataforma> getEtbInvPlataformaCollection() {
        return etbInvPlataformaCollection;
    }

    public void setEtbInvPlataformaCollection(Collection<EtbInvPlataforma> etbInvPlataformaCollection) {
        this.etbInvPlataformaCollection = etbInvPlataformaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admId != null ? admId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvAdmPlataforma)) {
            return false;
        }
        EtbInvAdmPlataforma other = (EtbInvAdmPlataforma) object;
        if ((this.admId == null && other.admId != null) || (this.admId != null && !this.admId.equals(other.admId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvAdmPlataforma[ admId=" + admId + " ]";
    }
    
}
