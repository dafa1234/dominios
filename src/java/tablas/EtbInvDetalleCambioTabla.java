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
@Table(name = "etb_inv_detalle_cambio_tabla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvDetalleCambioTabla.findAll", query = "SELECT e FROM EtbInvDetalleCambioTabla e")
    , @NamedQuery(name = "EtbInvDetalleCambioTabla.findByDetcamID", query = "SELECT e FROM EtbInvDetalleCambioTabla e WHERE e.detcamID = :detcamID")
    , @NamedQuery(name = "EtbInvDetalleCambioTabla.findByDatCamColumna", query = "SELECT e FROM EtbInvDetalleCambioTabla e WHERE e.datCamColumna = :datCamColumna")
    , @NamedQuery(name = "EtbInvDetalleCambioTabla.findByDetCamValorIni", query = "SELECT e FROM EtbInvDetalleCambioTabla e WHERE e.detCamValorIni = :detCamValorIni")
    , @NamedQuery(name = "EtbInvDetalleCambioTabla.findByDetCamNawValor", query = "SELECT e FROM EtbInvDetalleCambioTabla e WHERE e.detCamNawValor = :detCamNawValor")})
public class EtbInvDetalleCambioTabla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "det_cam_ID")
    private Integer detcamID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dat_cam_columna")
    private String datCamColumna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "det_cam_valor_ini")
    private String detCamValorIni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "det_cam_naw_valor")
    private String detCamNawValor;
    @JoinColumn(name = "det_cam_idtabla", referencedColumnName = "cam_tab_ID")
    @ManyToOne(optional = false)
    private EtbInvCambioTabla detCamIdtabla;

    public EtbInvDetalleCambioTabla() {
    }

    public EtbInvDetalleCambioTabla(Integer detcamID) {
        this.detcamID = detcamID;
    }

    public EtbInvDetalleCambioTabla(Integer detcamID, String datCamColumna, String detCamValorIni, String detCamNawValor) {
        this.detcamID = detcamID;
        this.datCamColumna = datCamColumna;
        this.detCamValorIni = detCamValorIni;
        this.detCamNawValor = detCamNawValor;
    }

    public Integer getDetcamID() {
        return detcamID;
    }

    public void setDetcamID(Integer detcamID) {
        this.detcamID = detcamID;
    }

    public String getDatCamColumna() {
        return datCamColumna;
    }

    public void setDatCamColumna(String datCamColumna) {
        this.datCamColumna = datCamColumna;
    }

    public String getDetCamValorIni() {
        return detCamValorIni;
    }

    public void setDetCamValorIni(String detCamValorIni) {
        this.detCamValorIni = detCamValorIni;
    }

    public String getDetCamNawValor() {
        return detCamNawValor;
    }

    public void setDetCamNawValor(String detCamNawValor) {
        this.detCamNawValor = detCamNawValor;
    }

    public EtbInvCambioTabla getDetCamIdtabla() {
        return detCamIdtabla;
    }

    public void setDetCamIdtabla(EtbInvCambioTabla detCamIdtabla) {
        this.detCamIdtabla = detCamIdtabla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detcamID != null ? detcamID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvDetalleCambioTabla)) {
            return false;
        }
        EtbInvDetalleCambioTabla other = (EtbInvDetalleCambioTabla) object;
        if ((this.detcamID == null && other.detcamID != null) || (this.detcamID != null && !this.detcamID.equals(other.detcamID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvDetalleCambioTabla[ detcamID=" + detcamID + " ]";
    }
    
}
