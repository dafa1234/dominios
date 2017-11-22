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
@Table(name = "etb_inv_tipo_agente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvTipoAgente.findAll", query = "SELECT e FROM EtbInvTipoAgente e")
    , @NamedQuery(name = "EtbInvTipoAgente.findByAgeId", query = "SELECT e FROM EtbInvTipoAgente e WHERE e.ageId = :ageId")
    , @NamedQuery(name = "EtbInvTipoAgente.findByAgeTipo", query = "SELECT e FROM EtbInvTipoAgente e WHERE e.ageTipo = :ageTipo")
    , @NamedQuery(name = "EtbInvTipoAgente.findByAgeSerial", query = "SELECT e FROM EtbInvTipoAgente e WHERE e.ageSerial = :ageSerial")
    , @NamedQuery(name = "EtbInvTipoAgente.findByAgeObserv", query = "SELECT e FROM EtbInvTipoAgente e WHERE e.ageObserv = :ageObserv")})
public class EtbInvTipoAgente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AGE_ID")
    private Integer ageId;
    @Column(name = "AGE_TIPO")
    private Integer ageTipo;
    @Size(max = 255)
    @Column(name = "AGE_SERIAL")
    private String ageSerial;
    @Size(max = 255)
    @Column(name = "AGE_OBSERV")
    private String ageObserv;

    public EtbInvTipoAgente() {
    }

    public EtbInvTipoAgente(Integer ageId) {
        this.ageId = ageId;
    }

    public Integer getAgeId() {
        return ageId;
    }

    public void setAgeId(Integer ageId) {
        this.ageId = ageId;
    }

    public Integer getAgeTipo() {
        return ageTipo;
    }

    public void setAgeTipo(Integer ageTipo) {
        this.ageTipo = ageTipo;
    }

    public String getAgeSerial() {
        return ageSerial;
    }

    public void setAgeSerial(String ageSerial) {
        this.ageSerial = ageSerial;
    }

    public String getAgeObserv() {
        return ageObserv;
    }

    public void setAgeObserv(String ageObserv) {
        this.ageObserv = ageObserv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ageId != null ? ageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvTipoAgente)) {
            return false;
        }
        EtbInvTipoAgente other = (EtbInvTipoAgente) object;
        if ((this.ageId == null && other.ageId != null) || (this.ageId != null && !this.ageId.equals(other.ageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvTipoAgente[ ageId=" + ageId + " ]";
    }
    
}
