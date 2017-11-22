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
@Table(name = "etb_inv_plantilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvPlantilla.findAll", query = "SELECT e FROM EtbInvPlantilla e")
    , @NamedQuery(name = "EtbInvPlantilla.findByPlanId", query = "SELECT e FROM EtbInvPlantilla e WHERE e.planId = :planId")
    , @NamedQuery(name = "EtbInvPlantilla.findByPlanNombre", query = "SELECT e FROM EtbInvPlantilla e WHERE e.planNombre = :planNombre")})
public class EtbInvPlantilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAN_ID")
    private Integer planId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PLAN_NOMBRE")
    private String planNombre;

    public EtbInvPlantilla() {
    }

    public EtbInvPlantilla(Integer planId) {
        this.planId = planId;
    }

    public EtbInvPlantilla(Integer planId, String planNombre) {
        this.planId = planId;
        this.planNombre = planNombre;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanNombre() {
        return planNombre;
    }

    public void setPlanNombre(String planNombre) {
        this.planNombre = planNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planId != null ? planId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvPlantilla)) {
            return false;
        }
        EtbInvPlantilla other = (EtbInvPlantilla) object;
        if ((this.planId == null && other.planId != null) || (this.planId != null && !this.planId.equals(other.planId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvPlantilla[ planId=" + planId + " ]";
    }
    
}
