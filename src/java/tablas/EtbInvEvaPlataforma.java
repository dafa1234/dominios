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
@Table(name = "etb_inv_eva_plataforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvEvaPlataforma.findAll", query = "SELECT e FROM EtbInvEvaPlataforma e")
    , @NamedQuery(name = "EtbInvEvaPlataforma.findByEvapId", query = "SELECT e FROM EtbInvEvaPlataforma e WHERE e.evapId = :evapId")
    , @NamedQuery(name = "EtbInvEvaPlataforma.findByEvapFecha", query = "SELECT e FROM EtbInvEvaPlataforma e WHERE e.evapFecha = :evapFecha")
    , @NamedQuery(name = "EtbInvEvaPlataforma.findByEvapEjecuta", query = "SELECT e FROM EtbInvEvaPlataforma e WHERE e.evapEjecuta = :evapEjecuta")
    , @NamedQuery(name = "EtbInvEvaPlataforma.findByEvapServ", query = "SELECT e FROM EtbInvEvaPlataforma e WHERE e.evapServ = :evapServ")})
public class EtbInvEvaPlataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVAP_ID")
    private Integer evapId;
    @Size(max = 40)
    @Column(name = "EVAP_FECHA")
    private String evapFecha;
    @Size(max = 255)
    @Column(name = "EVAP_EJECUTA")
    private String evapEjecuta;
    @Size(max = 255)
    @Column(name = "EVAP_SERV")
    private String evapServ;

    public EtbInvEvaPlataforma() {
    }

    public EtbInvEvaPlataforma(Integer evapId) {
        this.evapId = evapId;
    }

    public Integer getEvapId() {
        return evapId;
    }

    public void setEvapId(Integer evapId) {
        this.evapId = evapId;
    }

    public String getEvapFecha() {
        return evapFecha;
    }

    public void setEvapFecha(String evapFecha) {
        this.evapFecha = evapFecha;
    }

    public String getEvapEjecuta() {
        return evapEjecuta;
    }

    public void setEvapEjecuta(String evapEjecuta) {
        this.evapEjecuta = evapEjecuta;
    }

    public String getEvapServ() {
        return evapServ;
    }

    public void setEvapServ(String evapServ) {
        this.evapServ = evapServ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evapId != null ? evapId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvEvaPlataforma)) {
            return false;
        }
        EtbInvEvaPlataforma other = (EtbInvEvaPlataforma) object;
        if ((this.evapId == null && other.evapId != null) || (this.evapId != null && !this.evapId.equals(other.evapId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvEvaPlataforma[ evapId=" + evapId + " ]";
    }
    
}
