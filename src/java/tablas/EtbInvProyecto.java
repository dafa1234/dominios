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
import javax.persistence.Lob;
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
@Table(name = "etb_inv_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvProyecto.findAll", query = "SELECT e FROM EtbInvProyecto e")
    , @NamedQuery(name = "EtbInvProyecto.findByProId", query = "SELECT e FROM EtbInvProyecto e WHERE e.proId = :proId")
    , @NamedQuery(name = "EtbInvProyecto.findByProTitulo", query = "SELECT e FROM EtbInvProyecto e WHERE e.proTitulo = :proTitulo")
    , @NamedQuery(name = "EtbInvProyecto.findByProMante", query = "SELECT e FROM EtbInvProyecto e WHERE e.proMante = :proMante")
    , @NamedQuery(name = "EtbInvProyecto.findByProEstado", query = "SELECT e FROM EtbInvProyecto e WHERE e.proEstado = :proEstado")})
public class EtbInvProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRO_ID")
    private Integer proId;
    @Size(max = 255)
    @Column(name = "PRO_TITULO")
    private String proTitulo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "PRO_DESCRIP")
    private String proDescrip;
    @Size(max = 80)
    @Column(name = "PRO_MANTE")
    private String proMante;
    @Column(name = "PRO_ESTADO")
    private Integer proEstado;

    public EtbInvProyecto() {
    }

    public EtbInvProyecto(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProTitulo() {
        return proTitulo;
    }

    public void setProTitulo(String proTitulo) {
        this.proTitulo = proTitulo;
    }

    public String getProDescrip() {
        return proDescrip;
    }

    public void setProDescrip(String proDescrip) {
        this.proDescrip = proDescrip;
    }

    public String getProMante() {
        return proMante;
    }

    public void setProMante(String proMante) {
        this.proMante = proMante;
    }

    public Integer getProEstado() {
        return proEstado;
    }

    public void setProEstado(Integer proEstado) {
        this.proEstado = proEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvProyecto)) {
            return false;
        }
        EtbInvProyecto other = (EtbInvProyecto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvProyecto[ proId=" + proId + " ]";
    }
    
}
