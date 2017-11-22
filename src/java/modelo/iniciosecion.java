/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import tablas.EtbInvUsuarioAp;
import tablas.EtbInvActividad;
import tablas.EtbInvServidor;
import org.springframework.transaction.annotation.Transactional;
import tablas.EtbInvAseguramiento;
import tablas.EtbInvCamusuServ;
import tablas.EtbInvCasosProv;
import tablas.EtbInvCentral;
import tablas.EtbInvContrato;
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvEstado;
import tablas.EtbInvGrupo;
import tablas.EtbInvMarca;
import tablas.EtbInvPlataforma;
import tablas.EtbInvProyecto;
import tablas.EtbInvRolServidor;
import tablas.EtbInvSalon;
import tablas.EtbInvSisOperativo;
import tablas.EtbInvTipoCont;
import tablas.EtbInvUsuEstado;
import tablas.EtbInvUsuServ;

/**
 *
 * @author diegfraa
 */
@Service

public class iniciosecion {
     @PersistenceContext
    private EntityManager em;
     
@Transactional(rollbackFor = {ServicioException.class})
      public EtbInvUsuarioAp readByRutJPQL(String email) throws SecurityException{ 
        String sql="select a from EtbInvUsuarioAp a where  a.usuEtb = :email ";
  
        Query q=em.createQuery(sql);
        q.setParameter("email", email);
      

        try {
            return (EtbInvUsuarioAp)q.getSingleResult();
        } catch (Exception  e) {
            return null;
        }
 
     }
      
@Transactional(rollbackFor = {ServicioException.class})
      public EtbInvUsuServ buscarususerv(Integer email) throws SecurityException{ 
        String sql="select a from EtbInvUsuServ a where  a.ususId = :email ";
  
        Query q=em.createQuery(sql);
        q.setParameter("email", email);
      

        try {
            return (EtbInvUsuServ)q.getSingleResult();
        } catch (Exception  e) {
            return null;
        }
 
     }

     
    public EtbInvGrupo readByRut(Integer grup) {
           String sql="select nn from EtbInvGrupo nn where  nn.gruIdGrupo = :gruIdGrupo";

        Query q=em.createQuery(sql);       
        q.setParameter("gruIdGrupo", grup);
        try {
           return (EtbInvGrupo)q.getSingleResult();
        } catch (Exception  e) {
            return null;
       }
    }
       public List<EtbInvMarca>  ListaMarca() { 
        
        String sql="Select n from EtbInvMarca n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
         
    
       public List<EtbInvCamusuServ> ListaDetalle(String usu) { 
        
        String sql="Select n from EtbInvCamusuServ n where n.usuCambio= :gruIdGrupo";
        
        Query q=em.createQuery(sql);      
        q.setParameter("gruIdGrupo", usu);
        return q.getResultList();
      
    }
     public List<EtbInvServidor>  Listaserver() { 
        
        String sql="Select n from EtbInvServidor n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
       public List<EtbInvEstado>  ListaEstado() { 
        
        String sql="Select n from EtbInvEstado n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }

     public List<EtbInvSisOperativo>  Listasisope() { 
        
        String sql="Select n from EtbInvSisOperativo n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
       public List<EtbInvGrupo>  Listagrupo() { 
        
        String sql="Select n from EtbInvGrupo n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
     public List<EtbInvCentral>  ListaCentral() { 
        
        String sql="Select n from EtbInvCentral n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
       public List<EtbInvPlataforma>  ListaPrataforma() { 
        
        String sql="Select n from EtbInvPlataforma n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
     public List<EtbInvRolServidor>  ListaRolserver() { 
        
        String sql="Select n from EtbInvRolServidor n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
        public List<EtbInvSalon>  ListaSalom() { 
        
        String sql="Select n from EtbInvSalon n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
    public List<EtbInvActividad>  ListaActividad() { 
        
        String sql="Select n from EtbInvActividad n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
        public List<EtbInvAseguramiento>  ListaAsegu() { 
        
        String sql="Select n from EtbInvAseguramiento n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
        public List<EtbInvContrato>  ListaContra() { 
        
        String sql="Select n from EtbInvContrato n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
        public List<EtbInvCronogramaMto>  ListaCrono() { 
        
        String sql="Select n from EtbInvCronogramaMto n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
    public List<EtbInvProyecto>  ListaProyecto() { 
        
        String sql="Select n from EtbInvProyecto n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
     public List<EtbInvTipoCont>  Listacont() { 
        
        String sql="Select n from EtbInvTipoCont n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
      public List<EtbInvCasosProv>  Listaproveedor() { 
        
        String sql="Select n from EtbInvCasosProv n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
      public List<EtbInvUsuServ>  Listaususerv() { 
        
        String sql="Select n from EtbInvUsuServ n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
        public List<EtbInvUsuEstado>  Listausuest() { 
        
        String sql="Select n from EtbInvUsuEstado n";
  
        Query q=em.createQuery(sql);          
        return q.getResultList();
    }
    
 /////////////////////////////////
    
    //INSERTAR SERVIDOR
    
    @Transactional(rollbackFor = {ServicioException.class})
    public void create(String serSerial, String serHostname, EtbInvMarca marIdMarca, int modIdModelo, String serConexion, int cenIdCentral, int salIdSalon, int cliIdCliente, int rolIdRolServ, int plaIdPlataforma, String serForAdCompartida, String serAdministrado, String serCores, String serTIngreso, String serUnidad, String serProyecto,String serRack, Integer serNoProcFisico, EtbInvEstado estIdEstado, EtbInvSisOperativo sisIdSisOperativo, EtbInvGrupo gruIdGrupo) {
        EtbInvServidor Alumnos = new EtbInvServidor(serSerial,serHostname,marIdMarca,modIdModelo,serConexion,cenIdCentral,salIdSalon,cliIdCliente,rolIdRolServ,plaIdPlataforma,serForAdCompartida,serAdministrado,serCores,serTIngreso,serUnidad,serProyecto,serRack,serNoProcFisico,estIdEstado,sisIdSisOperativo,gruIdGrupo);
        
       em.persist(Alumnos);
    }
    //INSERTAR ACTIVIDAD
     @Transactional(rollbackFor = {ServicioException.class})
    public void creact( String actServ, String actEjecuta, String actTarea, String actDescripcion, String actSolicita,Integer actTipo, Date actFechaFin, Date actFechaIni) {
        EtbInvActividad Alumnos = new EtbInvActividad(actServ,actEjecuta,actTarea,  actDescripcion,  actSolicita, actTipo,actFechaFin,actFechaIni);
        
       em.persist(Alumnos);
    }
      //INSERTAR ASEGURAMIENTO
     @Transactional(rollbackFor = {ServicioException.class})
    public void crease(String aseTarea, String aseServidor, String aseEjecuta,Date aseFecha) {
      
        EtbInvAseguramiento Alumnos = new EtbInvAseguramiento(aseTarea,aseServidor,aseEjecuta,aseFecha);
        
       em.persist(Alumnos);
    }
     //INSERTAR CONTRATO
    @Transactional(rollbackFor = {ServicioException.class})
    public void creacont(Integer contProv, Integer contTipo, Date contFechaIni, Date contFechaFin, String contNum, Integer contEstado, String contLogin, String contDescrip) {
        
        EtbInvContrato Alumnos = new EtbInvContrato(contProv,contTipo,contFechaIni,contFechaFin,contNum,contEstado,contLogin,contDescrip); 
     
        em.persist(Alumnos);
    }
    //INSERTAR CRONOGRAMA
      @Transactional(rollbackFor = {ServicioException.class})
    public void creacrono(Integer croProyecto, Date croFechaIni, String croSerial, String croEjecuta,String croCambioFin,Integer croEstado ) {
      
        EtbInvCronogramaMto Alumnos = new EtbInvCronogramaMto( croProyecto, croFechaIni, croSerial, croEjecuta,croCambioFin, croEstado );
        
       em.persist(Alumnos);
    }
    //INSERTAR CASOSPROVEEDOR
      @Transactional(rollbackFor = {ServicioException.class})
    public void creaproveedor(Integer caspProv, String caspServ, String caspFechaApe,String caspFechaCie, String caspNumero,String caspIm,Integer caspEstado) {
      
        EtbInvCasosProv Alumnos = new EtbInvCasosProv(caspProv,caspServ,caspFechaApe,caspFechaCie,caspNumero,caspIm,caspEstado);
        
       em.persist(Alumnos);
    }
      //INSERTAR USUARIO SERVIDOR
      @Transactional(rollbackFor = {ServicioException.class})
    public void crearususerv(String ususLogin, String ususNombre, String ususServ, EtbInvUsuEstado ususEstado) {
      
        EtbInvUsuServ Alumnos = new EtbInvUsuServ(ususLogin,ususNombre,ususServ, ususEstado);
        
       em.persist(Alumnos);
    }
       //INSERTAR USUARIO SERVIDOR
      @Transactional(rollbackFor = {ServicioException.class})
    public void crearcambioususerv(String ususLogin, String tCambio, EtbInvUsuEstado ususEstado) {
      
        EtbInvCamusuServ Alumnos = new EtbInvCamusuServ(ususLogin,tCambio,ususEstado);
        
       em.persist(Alumnos);
    }
         //INSERTAR USUARIO APLICACION
      @Transactional(rollbackFor = {ServicioException.class})
    public void crearusuarioapp(int per,String nombre_recibido, String apellido_recibido, String Correo_recibido,String estado,int dom, String Codigo_Etb_Recibido, String usuario_recibido, String telefono_recibido, String Empresa_recibido, String Cargo_recibido, String Direccion_Recibido, String Cedula_Recibido, String telefono_ofici_recibido) {
      
        EtbInvUsuarioAp Alumnos = new EtbInvUsuarioAp(per,nombre_recibido,apellido_recibido,Correo_recibido,estado,dom,Codigo_Etb_Recibido,usuario_recibido,telefono_recibido,Empresa_recibido,Cargo_recibido,Direccion_Recibido,Cedula_Recibido,telefono_ofici_recibido);
        
       em.persist(Alumnos);
    }

    //actualizar servidor
    
  
    public EtbInvServidor updates(String serSerial, String serHostname, EtbInvMarca marIdMarca, int modIdModelo, String serConexion, int cenIdCentral, int salIdSalon, int cliIdCliente, int rolIdRolServ, int plaIdPlataforma, String serForAdCompartida, String serAdministrado, String serCores, String serTIngreso, String serUnidad, String serProyecto,String serRack, Integer serNoProcFisico, EtbInvEstado estIdEstado, EtbInvSisOperativo sisIdSisOperativo, EtbInvGrupo gruIdGrupo)
    {
        String sql=" update EtbInvServidor set  serSerial=:serSerial,serHostname=:serHostname,marIdMarca=:marIdMarca,modIdModelo=:modIdModelo,serConexion=:serConexion,cenIdCentral=:cenIdCentral,salIdSalon=:salIdSalon,cliIdCliente=:cliIdCliente,rolIdRolServ=:rolIdRolServ,plaIdPlataforma=:plaIdPlataforma,serForAdCompartida=:serForAdCompartida,serAdministrado=:serAdministrado,serCores=:serCores,serTIngreso=:serTIngreso,serUnidad=:serUnidad,serProyecto=:serProyecto,serRack=:serRack,serNoProcFisico=:serNoProcFisico,estIdEstado=:estIdEstado,sisIdSisOperativo=:sisIdSisOperativo,gruIdGrupo=:gruIdGrupo where serSerial=:serSerial";
         Query q=em.createQuery(sql);
         q.setParameter("serSerial", serSerial);
         q.setParameter("serHostname", serHostname);
         q.setParameter("marIdMarca", marIdMarca);
         q.setParameter("modIdModelo", modIdModelo);
         q.setParameter("serConexion", serConexion);
         q.setParameter("serConexion", serConexion);
         q.setParameter("cenIdCentral", cenIdCentral);
         q.setParameter("salIdSalon", salIdSalon);
         q.setParameter("cliIdCliente", cliIdCliente);
         q.setParameter("rolIdRolServ", rolIdRolServ);
         q.setParameter("plaIdPlataforma", plaIdPlataforma);
         q.setParameter("serForAdCompartida", serForAdCompartida);
         q.setParameter("serAdministrado", serAdministrado);
         q.setParameter("serCores", serCores);      
         q.setParameter("serTIngreso", serTIngreso);
         q.setParameter("serUnidad", serUnidad);
         q.setParameter("serProyecto", serProyecto);
         q.setParameter("serRack", serRack);
         q.setParameter("serNoProcFisico", serNoProcFisico);
         q.setParameter("estIdEstado", estIdEstado);
         q.setParameter("sisIdSisOperativo", sisIdSisOperativo);
         q.setParameter("gruIdGrupo", gruIdGrupo);
           try {
           return (EtbInvServidor)q.getSingleResult();
        } catch (Exception  e) {
            return null;
       }
    }
        @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvUsuServ update(Integer email, EtbInvUsuEstado ususEstado, String ususLogin, String nombre, String servidor, Integer admin) {
          EtbInvUsuServ Alumnos = new EtbInvUsuServ(ususEstado,email,ususLogin,nombre,servidor,admin);
      return em.merge(Alumnos);
    }

   

    

   

  

}

  
  