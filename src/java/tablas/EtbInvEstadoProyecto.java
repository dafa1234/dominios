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
@Table(name = "etb_inv_estado_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvEstadoProyecto.findAll", query = "SELECT e FROM EtbInvEstadoProyecto e")
    , @NamedQuery(name = "EtbInvEstadoProyecto.findByIdProyectoEst", query = "SELECT e FROM EtbInvEstadoProyecto e WHERE e.idProyectoEst = :idProyectoEst")
    , @NamedQuery(name = "EtbInvEstadoProyecto.findByProyectoEstado", query = "SELECT e FROM EtbInvEstadoProyecto e WHERE e.proyectoEstado = :proyectoEstado")})
public class EtbInvEstadoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto_est")
    private Integer idProyectoEst;
    @Size(max = 45)
    @Column(name = "proyecto_estado")
    private String proyectoEstado;

    public EtbInvEstadoProyecto() {
    }

    public EtbInvEstadoProyecto(Integer idProyectoEst) {
        this.idProyectoEst = idProyectoEst;
    }

    public Integer getIdProyectoEst() {
        return idProyectoEst;
    }

    public void setIdProyectoEst(Integer idProyectoEst) {
        this.idProyectoEst = idProyectoEst;
    }

    public String getProyectoEstado() {
        return proyectoEstado;
    }

    public void setProyectoEstado(String proyectoEstado) {
        this.proyectoEstado = proyectoEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyectoEst != null ? idProyectoEst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvEstadoProyecto)) {
            return false;
        }
        EtbInvEstadoProyecto other = (EtbInvEstadoProyecto) object;
        if ((this.idProyectoEst == null && other.idProyectoEst != null) || (this.idProyectoEst != null && !this.idProyectoEst.equals(other.idProyectoEst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvEstadoProyecto[ idProyectoEst=" + idProyectoEst + " ]";
    }
    
}
