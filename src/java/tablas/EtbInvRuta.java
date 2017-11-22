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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvRuta.findAll", query = "SELECT e FROM EtbInvRuta e")
    , @NamedQuery(name = "EtbInvRuta.findByRutId", query = "SELECT e FROM EtbInvRuta e WHERE e.rutId = :rutId")
    , @NamedQuery(name = "EtbInvRuta.findByRutSerial", query = "SELECT e FROM EtbInvRuta e WHERE e.rutSerial = :rutSerial")
    , @NamedQuery(name = "EtbInvRuta.findByRutRuta", query = "SELECT e FROM EtbInvRuta e WHERE e.rutRuta = :rutRuta")
    , @NamedQuery(name = "EtbInvRuta.findByRutFecha", query = "SELECT e FROM EtbInvRuta e WHERE e.rutFecha = :rutFecha")})
public class EtbInvRuta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RUT_ID")
    private Integer rutId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RUT_SERIAL")
    private String rutSerial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8000)
    @Column(name = "RUT_RUTA")
    private String rutRuta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RUT_FECHA")
    private String rutFecha;

    public EtbInvRuta() {
    }

    public EtbInvRuta(Integer rutId) {
        this.rutId = rutId;
    }

    public EtbInvRuta(Integer rutId, String rutSerial, String rutRuta, String rutFecha) {
        this.rutId = rutId;
        this.rutSerial = rutSerial;
        this.rutRuta = rutRuta;
        this.rutFecha = rutFecha;
    }

    public Integer getRutId() {
        return rutId;
    }

    public void setRutId(Integer rutId) {
        this.rutId = rutId;
    }

    public String getRutSerial() {
        return rutSerial;
    }

    public void setRutSerial(String rutSerial) {
        this.rutSerial = rutSerial;
    }

    public String getRutRuta() {
        return rutRuta;
    }

    public void setRutRuta(String rutRuta) {
        this.rutRuta = rutRuta;
    }

    public String getRutFecha() {
        return rutFecha;
    }

    public void setRutFecha(String rutFecha) {
        this.rutFecha = rutFecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutId != null ? rutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvRuta)) {
            return false;
        }
        EtbInvRuta other = (EtbInvRuta) object;
        if ((this.rutId == null && other.rutId != null) || (this.rutId != null && !this.rutId.equals(other.rutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvRuta[ rutId=" + rutId + " ]";
    }
    
}
