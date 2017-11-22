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
@Table(name = "etb_inv_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvCliente.findAll", query = "SELECT e FROM EtbInvCliente e")
    , @NamedQuery(name = "EtbInvCliente.findByCliIdCliente", query = "SELECT e FROM EtbInvCliente e WHERE e.cliIdCliente = :cliIdCliente")
    , @NamedQuery(name = "EtbInvCliente.findByCliNombre", query = "SELECT e FROM EtbInvCliente e WHERE e.cliNombre = :cliNombre")
    , @NamedQuery(name = "EtbInvCliente.findByCliContacto", query = "SELECT e FROM EtbInvCliente e WHERE e.cliContacto = :cliContacto")})
public class EtbInvCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLI_ID_CLIENTE")
    private Integer cliIdCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CLI_NOMBRE")
    private String cliNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CLI_CONTACTO")
    private String cliContacto;

    public EtbInvCliente() {
    }

    public EtbInvCliente(Integer cliIdCliente) {
        this.cliIdCliente = cliIdCliente;
    }

    public EtbInvCliente(Integer cliIdCliente, String cliNombre, String cliContacto) {
        this.cliIdCliente = cliIdCliente;
        this.cliNombre = cliNombre;
        this.cliContacto = cliContacto;
    }

    public Integer getCliIdCliente() {
        return cliIdCliente;
    }

    public void setCliIdCliente(Integer cliIdCliente) {
        this.cliIdCliente = cliIdCliente;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliContacto() {
        return cliContacto;
    }

    public void setCliContacto(String cliContacto) {
        this.cliContacto = cliContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliIdCliente != null ? cliIdCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvCliente)) {
            return false;
        }
        EtbInvCliente other = (EtbInvCliente) object;
        if ((this.cliIdCliente == null && other.cliIdCliente != null) || (this.cliIdCliente != null && !this.cliIdCliente.equals(other.cliIdCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvCliente[ cliIdCliente=" + cliIdCliente + " ]";
    }
    
}
