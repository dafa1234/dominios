/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diegfraa
 */
@Entity
@Table(name = "etb_inv_servidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtbInvServidor.findAll", query = "SELECT e FROM EtbInvServidor e")
    , @NamedQuery(name = "EtbInvServidor.findBySerServer", query = "SELECT e FROM EtbInvServidor e WHERE e.serServer = :serServer")
    , @NamedQuery(name = "EtbInvServidor.findBySerSerial", query = "SELECT e FROM EtbInvServidor e WHERE e.serSerial = :serSerial")
    , @NamedQuery(name = "EtbInvServidor.findBySerHostname", query = "SELECT e FROM EtbInvServidor e WHERE e.serHostname = :serHostname")
    , @NamedQuery(name = "EtbInvServidor.findBySerConexion", query = "SELECT e FROM EtbInvServidor e WHERE e.serConexion = :serConexion")
    , @NamedQuery(name = "EtbInvServidor.findBySerRack", query = "SELECT e FROM EtbInvServidor e WHERE e.serRack = :serRack")
    , @NamedQuery(name = "EtbInvServidor.findBySerUnidad", query = "SELECT e FROM EtbInvServidor e WHERE e.serUnidad = :serUnidad")
    , @NamedQuery(name = "EtbInvServidor.findBySerProyecto", query = "SELECT e FROM EtbInvServidor e WHERE e.serProyecto = :serProyecto")
    , @NamedQuery(name = "EtbInvServidor.findBySerFIngreso", query = "SELECT e FROM EtbInvServidor e WHERE e.serFIngreso = :serFIngreso")
    , @NamedQuery(name = "EtbInvServidor.findBySerTIngreso", query = "SELECT e FROM EtbInvServidor e WHERE e.serTIngreso = :serTIngreso")
    , @NamedQuery(name = "EtbInvServidor.findBySerNoProcFisico", query = "SELECT e FROM EtbInvServidor e WHERE e.serNoProcFisico = :serNoProcFisico")
    , @NamedQuery(name = "EtbInvServidor.findBySerAdCompartida", query = "SELECT e FROM EtbInvServidor e WHERE e.serAdCompartida = :serAdCompartida")
    , @NamedQuery(name = "EtbInvServidor.findBySerTareaAdCompartida", query = "SELECT e FROM EtbInvServidor e WHERE e.serTareaAdCompartida = :serTareaAdCompartida")
    , @NamedQuery(name = "EtbInvServidor.findBySerAdministrado", query = "SELECT e FROM EtbInvServidor e WHERE e.serAdministrado = :serAdministrado")
    , @NamedQuery(name = "EtbInvServidor.findBySerCores", query = "SELECT e FROM EtbInvServidor e WHERE e.serCores = :serCores")
    , @NamedQuery(name = "EtbInvServidor.findByServMem", query = "SELECT e FROM EtbInvServidor e WHERE e.servMem = :servMem")
    , @NamedQuery(name = "EtbInvServidor.findByServDiscoC", query = "SELECT e FROM EtbInvServidor e WHERE e.servDiscoC = :servDiscoC")})
public class EtbInvServidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ser_server")
    private Integer serServer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SER_SERIAL")
    private String serSerial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SER_HOSTNAME")
    private String serHostname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SER_CONEXION")
    private String serConexion;
    @Size(max = 30)
    @Column(name = "SER_RACK")
    private String serRack;
    @Size(max = 30)
    @Column(name = "SER_UNIDAD")
    private String serUnidad;
    @Size(max = 50)
    @Column(name = "SER_PROYECTO")
    private String serProyecto;
    @Size(max = 30)
    @Column(name = "SER_F_INGRESO")
    private String serFIngreso;
    @Size(max = 30)
    @Column(name = "SER_T_INGRESO")
    private String serTIngreso;
    @Column(name = "SER_NO_PROC_FISICO")
    private Integer serNoProcFisico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SER_AD_COMPARTIDA")
    private int serAdCompartida;
    @Size(max = 30)
    @Column(name = "SER_TAREA_AD_COMPARTIDA")
    private String serTareaAdCompartida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SER_ADMINISTRADO")
    private int serAdministrado;
    @Column(name = "SER_CORES")
    private Integer serCores;
    @Column(name = "SERV_MEM")
    private Integer servMem;
    @Column(name = "SERV_DISCO_C")
    private Integer servDiscoC;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSer")
    private Collection<EtbInvDireccionamiento> etbInvDireccionamientoCollection;
    @OneToMany(mappedBy = "aseServidor")
    private Collection<EtbInvAseguramiento> etbInvAseguramientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actServ1")
    private Collection<EtbInvActividad> etbInvActividadCollection;
    @JoinColumn(name = "SIS_ID_SIS_OPERATIVO", referencedColumnName = "SIS_ID_SIS_OPERATIVO")
    @ManyToOne(optional = false)
    private EtbInvSisOperativo sisIdSisOperativo;
    @JoinColumn(name = "ROL_ID_ROL_SERV", referencedColumnName = "ROL_ID_ROL_SERV")
    @ManyToOne(optional = false)
    private EtbInvRolServidor rolIdRolServ;
    @JoinColumn(name = "EST_ID_ESTADO", referencedColumnName = "EST_ID_ESTADO")
    @ManyToOne(optional = false)
    private EtbInvEstado estIdEstado;
    @JoinColumn(name = "GRU_ID_GRUPO", referencedColumnName = "GRU_ID_GRUPO")
    @ManyToOne(optional = false)
    private EtbInvGrupo gruIdGrupo;
    @JoinColumn(name = "MAR_ID_MARCA", referencedColumnName = "MAR_ID_MARCA")
    @ManyToOne
    private EtbInvMarca marIdMarca;
    @JoinColumn(name = "MOD_ID_MODELO", referencedColumnName = "MOD_ID_MODELO")
    @ManyToOne(optional = false)
    private EtbInvModelo modIdModelo;
    @JoinColumn(name = "CLI_ID_CLIENTE", referencedColumnName = "CLI_ID_CLIENTE")
    @ManyToOne(optional = false)
    private EtbInvCliente cliIdCliente;
    @JoinColumn(name = "CEN_ID_CENTRAL", referencedColumnName = "CEN_ID_CENTRAL")
    @ManyToOne(optional = false)
    private EtbInvCentral cenIdCentral;
    @JoinColumn(name = "SAL_ID_SALON", referencedColumnName = "SAL_ID_SALON")
    @ManyToOne(optional = false)
    private EtbInvSalon salIdSalon;
    @JoinColumn(name = "PLA_ID_PLATAFORMA", referencedColumnName = "PLA_ID_PLATAFORMA")
    @ManyToOne(optional = false)
    private EtbInvPlataforma plaIdPlataforma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caspServ1")
    private Collection<EtbInvCasosProv> etbInvCasosProvCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutSerial1")
    private Collection<EtbInvRuta> etbInvRutaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSerServidor")
    private Collection<EtbInvUsuServ> etbInvUsuServCollection;

    public EtbInvServidor() {
    }

    public EtbInvServidor(Integer serServer) {
        this.serServer = serServer;
    }

    public EtbInvServidor(Integer serServer, String serSerial, String serHostname, String serConexion, int serAdCompartida, int serAdministrado) {
        this.serServer = serServer;
        this.serSerial = serSerial;
        this.serHostname = serHostname;
        this.serConexion = serConexion;
        this.serAdCompartida = serAdCompartida;
        this.serAdministrado = serAdministrado;
    }

    public Integer getSerServer() {
        return serServer;
    }

    public void setSerServer(Integer serServer) {
        this.serServer = serServer;
    }

    public String getSerSerial() {
        return serSerial;
    }

    public void setSerSerial(String serSerial) {
        this.serSerial = serSerial;
    }

    public String getSerHostname() {
        return serHostname;
    }

    public void setSerHostname(String serHostname) {
        this.serHostname = serHostname;
    }

    public String getSerConexion() {
        return serConexion;
    }

    public void setSerConexion(String serConexion) {
        this.serConexion = serConexion;
    }

    public String getSerRack() {
        return serRack;
    }

    public void setSerRack(String serRack) {
        this.serRack = serRack;
    }

    public String getSerUnidad() {
        return serUnidad;
    }

    public void setSerUnidad(String serUnidad) {
        this.serUnidad = serUnidad;
    }

    public String getSerProyecto() {
        return serProyecto;
    }

    public void setSerProyecto(String serProyecto) {
        this.serProyecto = serProyecto;
    }

    public String getSerFIngreso() {
        return serFIngreso;
    }

    public void setSerFIngreso(String serFIngreso) {
        this.serFIngreso = serFIngreso;
    }

    public String getSerTIngreso() {
        return serTIngreso;
    }

    public void setSerTIngreso(String serTIngreso) {
        this.serTIngreso = serTIngreso;
    }

    public Integer getSerNoProcFisico() {
        return serNoProcFisico;
    }

    public void setSerNoProcFisico(Integer serNoProcFisico) {
        this.serNoProcFisico = serNoProcFisico;
    }

    public int getSerAdCompartida() {
        return serAdCompartida;
    }

    public void setSerAdCompartida(int serAdCompartida) {
        this.serAdCompartida = serAdCompartida;
    }

    public String getSerTareaAdCompartida() {
        return serTareaAdCompartida;
    }

    public void setSerTareaAdCompartida(String serTareaAdCompartida) {
        this.serTareaAdCompartida = serTareaAdCompartida;
    }

    public int getSerAdministrado() {
        return serAdministrado;
    }

    public void setSerAdministrado(int serAdministrado) {
        this.serAdministrado = serAdministrado;
    }

    public Integer getSerCores() {
        return serCores;
    }

    public void setSerCores(Integer serCores) {
        this.serCores = serCores;
    }

    public Integer getServMem() {
        return servMem;
    }

    public void setServMem(Integer servMem) {
        this.servMem = servMem;
    }

    public Integer getServDiscoC() {
        return servDiscoC;
    }

    public void setServDiscoC(Integer servDiscoC) {
        this.servDiscoC = servDiscoC;
    }

    @XmlTransient
    public Collection<EtbInvDireccionamiento> getEtbInvDireccionamientoCollection() {
        return etbInvDireccionamientoCollection;
    }

    public void setEtbInvDireccionamientoCollection(Collection<EtbInvDireccionamiento> etbInvDireccionamientoCollection) {
        this.etbInvDireccionamientoCollection = etbInvDireccionamientoCollection;
    }

    @XmlTransient
    public Collection<EtbInvAseguramiento> getEtbInvAseguramientoCollection() {
        return etbInvAseguramientoCollection;
    }

    public void setEtbInvAseguramientoCollection(Collection<EtbInvAseguramiento> etbInvAseguramientoCollection) {
        this.etbInvAseguramientoCollection = etbInvAseguramientoCollection;
    }

    @XmlTransient
    public Collection<EtbInvActividad> getEtbInvActividadCollection() {
        return etbInvActividadCollection;
    }

    public void setEtbInvActividadCollection(Collection<EtbInvActividad> etbInvActividadCollection) {
        this.etbInvActividadCollection = etbInvActividadCollection;
    }

    public EtbInvSisOperativo getSisIdSisOperativo() {
        return sisIdSisOperativo;
    }

    public void setSisIdSisOperativo(EtbInvSisOperativo sisIdSisOperativo) {
        this.sisIdSisOperativo = sisIdSisOperativo;
    }

    public EtbInvRolServidor getRolIdRolServ() {
        return rolIdRolServ;
    }

    public void setRolIdRolServ(EtbInvRolServidor rolIdRolServ) {
        this.rolIdRolServ = rolIdRolServ;
    }

    public EtbInvEstado getEstIdEstado() {
        return estIdEstado;
    }

    public void setEstIdEstado(EtbInvEstado estIdEstado) {
        this.estIdEstado = estIdEstado;
    }

    public EtbInvGrupo getGruIdGrupo() {
        return gruIdGrupo;
    }

    public void setGruIdGrupo(EtbInvGrupo gruIdGrupo) {
        this.gruIdGrupo = gruIdGrupo;
    }

    public EtbInvMarca getMarIdMarca() {
        return marIdMarca;
    }

    public void setMarIdMarca(EtbInvMarca marIdMarca) {
        this.marIdMarca = marIdMarca;
    }

    public EtbInvModelo getModIdModelo() {
        return modIdModelo;
    }

    public void setModIdModelo(EtbInvModelo modIdModelo) {
        this.modIdModelo = modIdModelo;
    }

    public EtbInvCliente getCliIdCliente() {
        return cliIdCliente;
    }

    public void setCliIdCliente(EtbInvCliente cliIdCliente) {
        this.cliIdCliente = cliIdCliente;
    }

    public EtbInvCentral getCenIdCentral() {
        return cenIdCentral;
    }

    public void setCenIdCentral(EtbInvCentral cenIdCentral) {
        this.cenIdCentral = cenIdCentral;
    }

    public EtbInvSalon getSalIdSalon() {
        return salIdSalon;
    }

    public void setSalIdSalon(EtbInvSalon salIdSalon) {
        this.salIdSalon = salIdSalon;
    }

    public EtbInvPlataforma getPlaIdPlataforma() {
        return plaIdPlataforma;
    }

    public void setPlaIdPlataforma(EtbInvPlataforma plaIdPlataforma) {
        this.plaIdPlataforma = plaIdPlataforma;
    }

    @XmlTransient
    public Collection<EtbInvCasosProv> getEtbInvCasosProvCollection() {
        return etbInvCasosProvCollection;
    }

    public void setEtbInvCasosProvCollection(Collection<EtbInvCasosProv> etbInvCasosProvCollection) {
        this.etbInvCasosProvCollection = etbInvCasosProvCollection;
    }

    @XmlTransient
    public Collection<EtbInvRuta> getEtbInvRutaCollection() {
        return etbInvRutaCollection;
    }

    public void setEtbInvRutaCollection(Collection<EtbInvRuta> etbInvRutaCollection) {
        this.etbInvRutaCollection = etbInvRutaCollection;
    }

    @XmlTransient
    public Collection<EtbInvUsuServ> getEtbInvUsuServCollection() {
        return etbInvUsuServCollection;
    }

    public void setEtbInvUsuServCollection(Collection<EtbInvUsuServ> etbInvUsuServCollection) {
        this.etbInvUsuServCollection = etbInvUsuServCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serServer != null ? serServer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtbInvServidor)) {
            return false;
        }
        EtbInvServidor other = (EtbInvServidor) object;
        if ((this.serServer == null && other.serServer != null) || (this.serServer != null && !this.serServer.equals(other.serServer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.EtbInvServidor[ serServer=" + serServer + " ]";
    }
    
}
