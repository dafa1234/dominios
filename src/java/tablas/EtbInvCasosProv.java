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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "etb_inv_casos_prov")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvCasosProv.findAll", query = "SELECT e FROM EtbInvCasosProv e")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspId", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspId = :caspId")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspServ", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspServ = :caspServ")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspFechaApe", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspFechaApe = :caspFechaApe")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspFechaCie", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspFechaCie = :caspFechaCie")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspNumero", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspNumero = :caspNumero")
    , @NamedQuery(name = "EtbInvCasosProv.findByCaspIm", query = "SELECT e FROM EtbInvCasosProv e WHERE e.caspIm = :caspIm")
    , @NamedQuery(name = "EtbInvCasosProv.findByFCreacion", query = "SELECT e FROM EtbInvCasosProv e WHERE e.fCreacion = :fCreacion")})
public class EtbInvCasosProv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CASP_ID")
    private Integer caspId;
    @Size(max = 255)
    @Column(name = "CASP_SERV")
    private String caspServ;
    @Size(max = 20)
    @Column(name = "CASP_FECHA_APE")
    private String caspFechaApe;
    @Size(max = 20)
    @Column(name = "CASP_FECHA_CIE")
    private String caspFechaCie;
    @Size(max = 255)
    @Column(name = "CASP_NUMERO")
    private String caspNumero;
    @Size(max = 255)
    @Column(name = "CASP_IM")
    private String caspIm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "F_Creacion")
    private String fCreacion;
    @JoinColumn(name = "CASP_PROV", referencedColumnName = "MAR_ID_MARCA")
    @ManyToOne
    private EtbInvMarca caspProv;
    @JoinColumn(name = "CASP_ESTADO", referencedColumnName = "ESTC_ID")
    @ManyToOne
    private EtbInvEstadoCasos caspEstado;
    @JoinColumn(name = "CASP_SERV1", referencedColumnName = "ser_server")
    @ManyToOne(optional = false)
    private EtbInvServidor caspServ1;

    public EtbInvCasosProv() {
    }

    public EtbInvCasosProv(Integer caspId) {
        this.caspId = caspId;
    }

    public EtbInvCasosProv(Integer caspId, String fCreacion) {
        this.caspId = caspId;
        this.fCreacion = fCreacion;
    }

    public Integer getCaspId() {
        return caspId;
    }

    public void setCaspId(Integer caspId) {
        this.caspId = caspId;
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

    public String getFCreacion() {
        return fCreacion;
    }

    public void setFCreacion(String fCreacion) {
        this.fCreacion = fCreacion;
    }

    public EtbInvMarca getCaspProv() {
        return caspProv;
    }

    public void setCaspProv(EtbInvMarca caspProv) {
        this.caspProv = caspProv;
    }

    public EtbInvEstadoCasos getCaspEstado() {
        return caspEstado;
    }

    public void setCaspEstado(EtbInvEstadoCasos caspEstado) {
        this.caspEstado = caspEstado;
    }

    public EtbInvServidor getCaspServ1() {
        return caspServ1;
    }

    public void setCaspServ1(EtbInvServidor caspServ1) {
        this.caspServ1 = caspServ1;
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
