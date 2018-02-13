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
@Table(name = "etb_inv_gestor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvGestor.findAll", query = "SELECT e FROM EtbInvGestor e")
    , @NamedQuery(name = "EtbInvGestor.findByGesIdGestor", query = "SELECT e FROM EtbInvGestor e WHERE e.gesIdGestor = :gesIdGestor")
    , @NamedQuery(name = "EtbInvGestor.findByGesTipoGest", query = "SELECT e FROM EtbInvGestor e WHERE e.gesTipoGest = :gesTipoGest")})
public class EtbInvGestor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GES_ID_GESTOR")
    private Integer gesIdGestor;
    @Size(max = 255)
    @Column(name = "GES_TIPO_GEST")
    private String gesTipoGest;

    public EtbInvGestor() {
    }

    public EtbInvGestor(Integer gesIdGestor) {
        this.gesIdGestor = gesIdGestor;
    }

    public Integer getGesIdGestor() {
        return gesIdGestor;
    }

    public void setGesIdGestor(Integer gesIdGestor) {
        this.gesIdGestor = gesIdGestor;
    }

    public String getGesTipoGest() {
        return gesTipoGest;
    }

    public void setGesTipoGest(String gesTipoGest) {
        this.gesTipoGest = gesTipoGest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gesIdGestor != null ? gesIdGestor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvGestor)) {
            return false;
        }
        EtbInvGestor other = (EtbInvGestor) object;
        if ((this.gesIdGestor == null && other.gesIdGestor != null) || (this.gesIdGestor != null && !this.gesIdGestor.equals(other.gesIdGestor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvGestor[ gesIdGestor=" + gesIdGestor + " ]";
    }
    
}
