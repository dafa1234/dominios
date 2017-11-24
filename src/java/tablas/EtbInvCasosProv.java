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
@Table(name = "etb_inv_casos_prov")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvCasosProv.findAll", query = "SELECT e FROM EtbInvCasosProv e")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspId", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspId = :caspId")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspProv", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspProv = :caspProv")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspServ", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspServ = :caspServ")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspFechaApe", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspFechaApe = :caspFechaApe")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspFechaCie", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspFechaCie = :caspFechaCie")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspNumero", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspNumero = :caspNumero")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspIm", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspIm = :caspIm")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspEstado", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspEstado = :caspEstado")})
public class EtbInvCasosProv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CASP_ID")
    private Integer caspId;
    @Column(name = "CASP_PROV")
    private Integer caspProv;
    @Size(max = 255)
    @Column(name = "CASP_SERV")
    private String caspServ;
    @Size(max = 30)
    @Column(name = "CASP_FECHA_APE")
    private String caspFechaApe;
    @Size(max = 30)
    @Column(name = "CASP_FECHA_CIE")
    private String caspFechaCie;
    @Size(max = 255)
    @Column(name = "CASP_NUMERO")
    private String caspNumero;
    @Size(max = 255)
    @Column(name = "CASP_IM")
    private String caspIm;
    @Column(name = "CASP_ESTADO")
    private Integer caspEstado;

    public EtbInvCasosProv() {
    }

    public EtbInvCasosProv(Integer caspId) {
        this.caspId = caspId;
    }

    public Integer getCaspId() {
        return caspId;
    }
    public EtbInvCasosProv(Integer caspProv, String caspServ, String caspFechaApe, String caspFechaCie, String caspNumero, String caspIm, Integer caspEstado) {
         this.caspProv = caspProv;
        this.caspServ = caspServ;
        this.caspFechaApe = caspFechaApe;
        this.caspFechaCie = caspFechaCie;
        this.caspNumero = caspNumero;
        this.caspIm = caspIm;
        this.caspEstado = caspEstado;
   
    }

    public void setCaspId(Integer caspId) {
        this.caspId = caspId;
    }

    public Integer getCaspProv() {
        return caspProv;
    }

    public void setCaspProv(Integer caspProv) {
        this.caspProv = caspProv;
    }

    public String getCaspServ() {
        return caspServ;
    }

    public void setCaspServ(String caspServ) {
        this.caspServ = caspServ;
    }

    public String getCaspFechaApe() {
        return caspFechaApe;
    }

    public void setCaspFechaApe(String caspFechaApe) {
        this.caspFechaApe = caspFechaApe;
    }

    public String getCaspFechaCie() {
        return caspFechaCie;
    }

    public void setCaspFechaCie(String caspFechaCie) {
        this.caspFechaCie = caspFechaCie;
    }

    public String getCaspNumero() {
        return caspNumero;
    }

    public void setCaspNumero(String caspNumero) {
        this.caspNumero = caspNumero;
    }

    public String getCaspIm() {
        return caspIm;
    }

    public void setCaspIm(String caspIm) {
        this.caspIm = caspIm;
    }

    public Integer getCaspEstado() {
        return caspEstado;
    }

    public void setCaspEstado(Integer caspEstado) {
        this.caspEstado = caspEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caspId != null ? caspId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvCasosProv)) {
            return false;
        }
        EtbInvCasosProv other = (EtbInvCasosProv) object;
        if ((this.caspId == null && other.caspId != null) || (this.caspId != null && !this.caspId.equals(other.caspId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvCasosProv[ caspId=" + caspId + " ]";
    }
    
}
