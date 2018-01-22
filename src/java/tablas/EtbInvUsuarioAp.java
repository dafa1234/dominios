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
@Table(name = "etb_inv_usuario_ap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvUsuarioAp.findAll", query = "SELECT e FROM EtbInvUsuarioAp e")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuId", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuId = :usuId")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuNombre", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuNombre = :usuNombre")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuApell", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuApell = :usuApell")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuIdPer", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuIdPer = :usuIdPer")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuCorreo", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuCorreo = :usuCorreo")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuEtb", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuEtb = :usuEtb")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuEstado", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuEstado = :usuEstado")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuDominio", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuDominio = :usuDominio")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuCodEtb", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuCodEtb = :usuCodEtb")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuTelefono", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuTelefono = :usuTelefono")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuEmpresa", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuEmpresa = :usuEmpresa")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuCargo", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuCargo = :usuCargo")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuDireccion", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuDireccion = :usuDireccion")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuCedula", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuCedula = :usuCedula")
    , @NamedQuery(name = "EtbInvUsuarioAp.findByUsuTelOficina", query = "SELECT e FROM EtbInvUsuarioAp e WHERE e.usuTelOficina = :usuTelOficina")})
public class EtbInvUsuarioAp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USU_ID")
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_NOMBRE")
    private String usuNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_APELL")
    private String usuApell;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID_PER")
    private int usuIdPer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_CORREO")
    private String usuCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_ETB")
    private String usuEtb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USU_ESTADO")
    private String usuEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_DOMINIO")
    private int usuDominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_COD_ETB")
    private String usuCodEtb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_TELEFONO")
    private String usuTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "USU_EMPRESA")
    private String usuEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_CARGO")
    private String usuCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_DIRECCION")
    private String usuDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_CEDULA")
    private String usuCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USU_TEL_OFICINA")
    private String usuTelOficina;

    public EtbInvUsuarioAp() {
    }

    public EtbInvUsuarioAp(Integer usuId) {
        this.usuId = usuId;
    }

    public EtbInvUsuarioAp(Integer usuId, String usuNombre, String usuApell, int usuIdPer, String usuCorreo, String usuEtb, String usuEstado, int usuDominio, String usuCodEtb, String usuTelefono, String usuEmpresa, String usuCargo, String usuDireccion, String usuCedula, String usuTelOficina) {
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuApell = usuApell;
        this.usuIdPer = usuIdPer;
        this.usuCorreo = usuCorreo;
        this.usuEtb = usuEtb;
        this.usuEstado = usuEstado;
        this.usuDominio = usuDominio;
        this.usuCodEtb = usuCodEtb;
        this.usuTelefono = usuTelefono;
        this.usuEmpresa = usuEmpresa;
        this.usuCargo = usuCargo;
        this.usuDireccion = usuDireccion;
        this.usuCedula = usuCedula;
        this.usuTelOficina = usuTelOficina;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApell() {
        return usuApell;
    }

    public void setUsuApell(String usuApell) {
        this.usuApell = usuApell;
    }

    public int getUsuIdPer() {
        return usuIdPer;
    }

    public void setUsuIdPer(int usuIdPer) {
        this.usuIdPer = usuIdPer;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuEtb() {
        return usuEtb;
    }

    public void setUsuEtb(String usuEtb) {
        this.usuEtb = usuEtb;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    public int getUsuDominio() {
        return usuDominio;
    }

    public void setUsuDominio(int usuDominio) {
        this.usuDominio = usuDominio;
    }

    public String getUsuCodEtb() {
        return usuCodEtb;
    }

    public void setUsuCodEtb(String usuCodEtb) {
        this.usuCodEtb = usuCodEtb;
    }

    public String getUsuTelefono() {
        return usuTelefono;
    }

    public void setUsuTelefono(String usuTelefono) {
        this.usuTelefono = usuTelefono;
    }

    public String getUsuEmpresa() {
        return usuEmpresa;
    }

    public void setUsuEmpresa(String usuEmpresa) {
        this.usuEmpresa = usuEmpresa;
    }

    public String getUsuCargo() {
        return usuCargo;
    }

    public void setUsuCargo(String usuCargo) {
        this.usuCargo = usuCargo;
    }

    public String getUsuDireccion() {
        return usuDireccion;
    }

    public void setUsuDireccion(String usuDireccion) {
        this.usuDireccion = usuDireccion;
    }

    public String getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(String usuCedula) {
        this.usuCedula = usuCedula;
    }

    public String getUsuTelOficina() {
        return usuTelOficina;
    }

    public void setUsuTelOficina(String usuTelOficina) {
        this.usuTelOficina = usuTelOficina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvUsuarioAp)) {
            return false;
        }
        EtbInvUsuarioAp other = (EtbInvUsuarioAp) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvUsuarioAp[ usuId=" + usuId + " ]";
    }
    
}
