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
@Table(name = "etb_inv_service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvService.findAll", query = "SELECT e FROM EtbInvService e")
    , @NamedQuery(name = "EtbInvService.findByServiId", query = "SELECT e FROM EtbInvService e WHERE e.serviId = :serviId")
    , @NamedQuery(name = "EtbInvService.findByServiTipo", query = "SELECT e FROM EtbInvService e WHERE e.serviTipo = :serviTipo")
    , @NamedQuery(name = "EtbInvService.findByServiRuta", query = "SELECT e FROM EtbInvService e WHERE e.serviRuta = :serviRuta")
    , @NamedQuery(name = "EtbInvService.findByServiSerial", query = "SELECT e FROM EtbInvService e WHERE e.serviSerial = :serviSerial")
    , @NamedQuery(name = "EtbInvService.findByServiDescripcion", query = "SELECT e FROM EtbInvService e WHERE e.serviDescripcion = :serviDescripcion")})
public class EtbInvService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVI_ID")
    private Integer serviId;
    @Column(name = "SERVI_TIPO")
    private Integer serviTipo;
    @Size(max = 255)
    @Column(name = "SERVI_RUTA")
    private String serviRuta;
    @Size(max = 25)
    @Column(name = "SERVI_SERIAL")
    private String serviSerial;
    @Size(max = 255)
    @Column(name = "SERVI_DESCRIPCION")
    private String serviDescripcion;

    public EtbInvService() {
    }

    public EtbInvService(Integer serviId) {
        this.serviId = serviId;
    }

    public Integer getServiId() {
        return serviId;
    }

    public void setServiId(Integer serviId) {
        this.serviId = serviId;
    }

    public Integer getServiTipo() {
        return serviTipo;
    }

    public void setServiTipo(Integer serviTipo) {
        this.serviTipo = serviTipo;
    }

    public String getServiRuta() {
        return serviRuta;
    }

    public void setServiRuta(String serviRuta) {
        this.serviRuta = serviRuta;
    }

    public String getServiSerial() {
        return serviSerial;
    }

    public void setServiSerial(String serviSerial) {
        this.serviSerial = serviSerial;
    }

    public String getServiDescripcion() {
        return serviDescripcion;
    }

    public void setServiDescripcion(String serviDescripcion) {
        this.serviDescripcion = serviDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviId != null ? serviId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvService)) {
            return false;
        }
        EtbInvService other = (EtbInvService) object;
        if ((this.serviId == null && other.serviId != null) || (this.serviId != null && !this.serviId.equals(other.serviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvService[ serviId=" + serviId + " ]";
    }
    
}
