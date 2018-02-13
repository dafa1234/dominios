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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "etb_inv_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvServicio.findAll", query = "SELECT e FROM EtbInvServicio e")
    , @NamedQuery(name = "EtbInvServicio.findBySrvcId", query = "SELECT e FROM EtbInvServicio e WHERE e.srvcId = :srvcId")
    , @NamedQuery(name = "EtbInvServicio.findBySrvcTipoServ", query = "SELECT e FROM EtbInvServicio e WHERE e.srvcTipoServ = :srvcTipoServ")
    , @NamedQuery(name = "EtbInvServicio.findBySrvcSerialServ", query = "SELECT e FROM EtbInvServicio e WHERE e.srvcSerialServ = :srvcSerialServ")})
public class EtbInvServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SRVC_ID")
    private Integer srvcId;
    @Column(name = "SRVC_TIPO_SERV")
    private Integer srvcTipoServ;
    @Lob
    @Size(max = 16777215)
    @Column(name = "SRVC_DESCRIP")
    private String srvcDescrip;
    @Lob
    @Size(max = 16777215)
    @Column(name = "SRVC_RUTA")
    private String srvcRuta;
    @Size(max = 255)
    @Column(name = "SRVC_SERIAL_SERV")
    private String srvcSerialServ;

    public EtbInvServicio() {
    }

    public EtbInvServicio(Integer srvcId) {
        this.srvcId = srvcId;
    }

    public Integer getSrvcId() {
        return srvcId;
    }

    public void setSrvcId(Integer srvcId) {
        this.srvcId = srvcId;
    }

    public Integer getSrvcTipoServ() {
        return srvcTipoServ;
    }

    public void setSrvcTipoServ(Integer srvcTipoServ) {
        this.srvcTipoServ = srvcTipoServ;
    }

    public String getSrvcDescrip() {
        return srvcDescrip;
    }

    public void setSrvcDescrip(String srvcDescrip) {
        this.srvcDescrip = srvcDescrip;
    }

    public String getSrvcRuta() {
        return srvcRuta;
    }

    public void setSrvcRuta(String srvcRuta) {
        this.srvcRuta = srvcRuta;
    }

    public String getSrvcSerialServ() {
        return srvcSerialServ;
    }

    public void setSrvcSerialServ(String srvcSerialServ) {
        this.srvcSerialServ = srvcSerialServ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srvcId != null ? srvcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvServicio)) {
            return false;
        }
        EtbInvServicio other = (EtbInvServicio) object;
        if ((this.srvcId == null && other.srvcId != null) || (this.srvcId != null && !this.srvcId.equals(other.srvcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvServicio[ srvcId=" + srvcId + " ]";
    }
    
}
