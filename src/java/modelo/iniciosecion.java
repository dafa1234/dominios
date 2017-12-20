/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import tablas.EtbInvUsuarioAp;
import tablas.EtbInvActividad;
import tablas.EtbInvServidor;
import org.springframework.transaction.annotation.Transactional;
import tablas.EtbInvAccesoProhibido;
import tablas.EtbInvAseguramiento;
import tablas.EtbInvCamusuServ;
import tablas.EtbInvCasosProv;
import tablas.EtbInvCentral;
import tablas.EtbInvCliente;
import tablas.EtbInvContrato;
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvEstado;
import tablas.EtbInvEstadoCasos;
import tablas.EtbInvEstadoCont;
import tablas.EtbInvEstadoMto;
import tablas.EtbInvGrupo;
import tablas.EtbInvMarca;
import tablas.EtbInvModelo;
import tablas.EtbInvPlataforma;
import tablas.EtbInvProyecto;
import tablas.EtbInvRolServidor;
import tablas.EtbInvSalon;
import tablas.EtbInvSisOperativo;
import tablas.EtbInvTipoActividad;
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
    public EtbInvUsuarioAp readByRutJPQL(String email) throws SecurityException {
        String sql = "select a from EtbInvUsuarioAp a where  a.usuEtb = :email ";

        Query q = em.createQuery(sql);
        q.setParameter("email", email);

        try {
            return (EtbInvUsuarioAp) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvServidor readid(int ususidSer) throws SecurityException {
        String sql = "select aa from EtbInvServidor aa where  aa.serServer = :ususidSer ";

        Query q = em.createQuery(sql);
        q.setParameter("ususidSer", ususidSer);

        try {
            return (EtbInvServidor) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvUsuServ buscarususerv(Integer email) throws SecurityException {
        String sql = "select a from EtbInvUsuServ a where  a.ususId = :email ";

        Query q = em.createQuery(sql);
        q.setParameter("email", email);

        try {
            return (EtbInvUsuServ) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List readByRut() {
        EntityManagerFactory en = Persistence.createEntityManagerFactory("dominiosPU");
        EntityManager emt = en.createEntityManager();
        StoredProcedureQuery storedProcedure = emt.createStoredProcedureQuery("consulta");
        //  set parameters
//		storedProcedure.registerStoredProcedureParameter("rutas", Integer.class, ParameterMode.IN);
//                storedProcedure.registerStoredProcedureParameter("sal", String.class, ParameterMode.OUT);
//                 storedProcedure.registerStoredProcedureParameter("SAD1", String.class, ParameterMode.OUT);
//                storedProcedure.setParameter("rutas", 1);
//                storedProcedure.execute();
//                String[] das = new String[2];
//                das[0]=storedProcedure.getOutputParameterValue("sal").toString();
//                das[1]=storedProcedure.getOutputParameterValue("SAD1").toString();
        Query query = emt.createNamedQuery("procedu").setParameter("rutas", 1);

        return query.getResultList();
    }

    public List readByRutJ() {
        EntityManagerFactory en = Persistence.createEntityManagerFactory("dominiosPU");
        EntityManager emt = en.createEntityManager();
        //StoredProcedureQuery storedProcedure = emt.createStoredProcedureQuery("consulta");
        //  set parameters
//		storedProcedure.registerStoredProcedureParameter("rutas", Integer.class, ParameterMode.IN);
//                storedProcedure.registerStoredProcedureParameter("sal", String.class, ParameterMode.OUT);
//                 storedProcedure.registerStoredProcedureParameter("SAD1", String.class, ParameterMode.OUT);
//                storedProcedure.setParameter("rutas", 1);
//                storedProcedure.execute();
//                String[] das = new String[2];
//                das[0]=storedProcedure.getOutputParameterValue("sal").toString();
//                das[1]=storedProcedure.getOutputParameterValue("SAD1").toString();
        Query query = emt.createNamedQuery("procedu").setParameter("rutas", 1);

        return query.getResultList();
    }
    public List Lisreporte1(String F_Inicio,String F_Fin) {
        String sql = "select nn from EtbInvServidor nn where nn.serFIngreso between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }
    public List Lisreporte2(String F_Inicio,String F_Fin) {
        String sql = "select nn from EtbInvUsuServ nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }
    public List Lisreporte3(String F_Inicio,String F_Fin) {
        String sql = "select nn from EtbInvCronogramaMto nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }
    public List Lisreporte4(String F_Inicio,String F_Fin) {
        String sql = "select nn from EtbInvContrato nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }
    public List Lisreporte5(String F_Inicio,String F_Fin) {
        String sql = "select nn from EtbInvAseguramiento nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }
    public List Lisreporte6(String F_Inicio,String F_Fin) {
        String sql = "select nn from EtbInvActividad nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }
    public List Lisreporte7(String F_Inicio,String F_Fin) {
        String sql = "select nn from EtbInvCasosProv nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }
    public EtbInvGrupo readByRut(Integer grup) {
        String sql = "select nn from EtbInvGrupo nn where  nn.gruIdGrupo = :gruIdGrupo";

        Query q = em.createQuery(sql);
        q.setParameter("gruIdGrupo", grup);
        try {
            return (EtbInvGrupo) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<EtbInvMarca> ListaMarca() {

        String sql = "Select n from EtbInvMarca n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvCamusuServ> ListaDetalle(String usu) {

        String sql = "Select n from EtbInvCamusuServ n where n.usuCambio= :gruIdGrupo";

        Query q = em.createQuery(sql);
        q.setParameter("gruIdGrupo", usu);
        return q.getResultList();

    }

    public List<EtbInvServidor> Listaserver() {

        String sql = "Select n from EtbInvServidor n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvServidor> Listaservera(String fechaN, String fechaF) {

        String sql = "Select n from EtbInvServidor n where fecha =:fechaF  :fechaN";
        
        Query q = em.createQuery(sql);
        q.setParameter("gruIdGrupo", fechaN).setParameter( "gruIdGrupo", fechaF);
        return q.getResultList();
    }

    public List<EtbInvEstado> ListaEstado() {

        String sql = "Select n from EtbInvEstado n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvModelo> ListaModelo() {

        String sql = "Select n from EtbInvModelo n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvCliente> ListaCliente() {

        String sql = "Select n from EtbInvCliente n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvSisOperativo> Listasisope() {

        String sql = "Select n from EtbInvSisOperativo n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvGrupo> Listagrupo() {

        String sql = "Select n from EtbInvGrupo n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvCentral> ListaCentral() {

        String sql = "Select n from EtbInvCentral n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvPlataforma> ListaPrataforma() {

        String sql = "Select n from EtbInvPlataforma n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvRolServidor> ListaRolserver() {

        String sql = "Select n from EtbInvRolServidor n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvSalon> ListaSalom() {

        String sql = "Select n from EtbInvSalon n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvActividad> ListaActividad() {

        String sql = "Select n from EtbInvActividad n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvAseguramiento> ListaAsegu() {

        String sql = "Select n from EtbInvAseguramiento n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvContrato> ListaContra() {

        String sql = "Select n from EtbInvContrato n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvCronogramaMto> ListaCrono() {

        String sql = "Select n from EtbInvCronogramaMto n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvProyecto> ListaProyecto() {

        String sql = "Select n from EtbInvProyecto n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvTipoCont> Listacont() {

        String sql = "Select n from EtbInvTipoCont n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvCasosProv> Listaproveedor() {

        String sql = "Select n from EtbInvCasosProv n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    public List<EtbInvUsuServ> Listaususerv(EtbInvUsuEstado ususEstadoa) {

        String sql = "Select n from EtbInvUsuServ n where n.ususEstado= :estado";

        Query q = em.createQuery(sql);
         q.setParameter("estado", ususEstadoa);
        return q.getResultList();
    }

    public List<EtbInvUsuEstado> Listausuest() {

        String sql = "Select n from EtbInvUsuEstado n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }
    public List<EtbInvEstadoCont> Listaestacont() {

        String sql = "Select n from EtbInvEstadoCont n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }
    public List<EtbInvEstadoMto> Listaestamto() {

        String sql = "Select n from EtbInvEstadoMto n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }
    public List<EtbInvEstadoCasos> Listaestacasos() {

        String sql = "Select n from EtbInvEstadoCasos n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }
    public List<EtbInvTipoActividad> Listatipoactiv() {

        String sql = "Select n from EtbInvTipoActividad n";

        Query q = em.createQuery(sql);
        return q.getResultList();
    }
    /////////////////////////////////
    //INSERTAR SERVIDOR
    @Transactional(rollbackFor = {ServicioException.class})
    public void create(String Fecha, String serSerial, String serHostname, EtbInvMarca marIdMarca, EtbInvModelo modIdModelo, String serConexion, EtbInvCentral cenIdCentral, EtbInvSalon salIdSalon, EtbInvCliente cliIdCliente, EtbInvRolServidor rolIdRolServ, EtbInvPlataforma plaIdPlataforma, String serForAdCompartida, String serAdministrado, String serCores, String serTIngreso, String serUnidad, String serProyecto, String serRack, Integer serNoProcFisico, EtbInvEstado estIdEstado, EtbInvSisOperativo sisIdSisOperativo, EtbInvGrupo gruIdGrupo) {
        EtbInvServidor Alumnos = new EtbInvServidor(Fecha, serSerial, serHostname, marIdMarca, modIdModelo, serConexion, cenIdCentral, salIdSalon, cliIdCliente, rolIdRolServ, plaIdPlataforma, serForAdCompartida, serAdministrado, serCores, serTIngreso, serUnidad, serProyecto, serRack, serNoProcFisico, estIdEstado, sisIdSisOperativo, gruIdGrupo);

        em.persist(Alumnos);
    }

    //INSERTAR ACTIVIDAD
    @Transactional(rollbackFor = {ServicioException.class})
    public void creact(String Fecha,String actServ, String actEjecuta, String actTarea, String actDescripcion, String actSolicita, EtbInvTipoActividad actTipo, String actFechaFin, String actFechaIni) {
        EtbInvActividad Alumnos = new EtbInvActividad(Fecha,actServ, actEjecuta, actTarea, actDescripcion, actSolicita, actTipo, actFechaFin, actFechaIni);

        em.persist(Alumnos);
    }
    //INSERTAR ASEGURAMIENTO

    @Transactional(rollbackFor = {ServicioException.class})
    public void crease(String Fecha,String aseTarea, EtbInvServidor aseServidor, String aseEjecuta, String aseFecha) {

        EtbInvAseguramiento Alumnos = new EtbInvAseguramiento(Fecha,aseTarea, aseServidor, aseEjecuta, aseFecha);

        em.persist(Alumnos);
    }
    //INSERTAR CONTRATO

    @Transactional(rollbackFor = {ServicioException.class})
    public void creacont(String Fecha,EtbInvMarca contProv, EtbInvTipoCont contTipo, String contFechaIni, String contFechaFin, String contNum, EtbInvEstadoCont contEstado, String contLogin, String contDescrip) {

        EtbInvContrato Alumnos = new EtbInvContrato(Fecha,contProv, contTipo, contFechaIni, contFechaFin, contNum, contEstado, contLogin, contDescrip);

        em.persist(Alumnos);
    }

    //INSERTAR CRONOGRAMA
    @Transactional(rollbackFor = {ServicioException.class})
    public void creacrono(String Fecha,EtbInvProyecto croProyecto, String croFechaIni, String croSerial, String croEjecuta, String croCambioFin, EtbInvEstadoMto croEstado) {

        EtbInvCronogramaMto Alumnos = new EtbInvCronogramaMto(Fecha,croProyecto, croFechaIni, croSerial, croEjecuta, croCambioFin, croEstado);

        em.persist(Alumnos);
    }

    //INSERTAR CASOSPROVEEDOR
    @Transactional(rollbackFor = {ServicioException.class})
    public void creaproveedor(String Fecha,EtbInvMarca caspProv, String caspServ, String caspFechaApe, String caspFechaCie, String caspNumero, String caspIm, EtbInvEstadoCasos caspEstado) {

        EtbInvCasosProv Alumnos = new EtbInvCasosProv(Fecha,caspProv, caspServ, caspFechaApe, caspFechaCie, caspNumero, caspIm, caspEstado);

        em.persist(Alumnos);
    }
    //INSERTAR USUARIO SERVIDOR

    @Transactional(rollbackFor = {ServicioException.class})
    public void crearususerv(String Fecha,String ususLogin, String ususNombre, String ususServ, EtbInvUsuEstado ususEstadoa, EtbInvServidor ususidServ) {

        EtbInvUsuServ Alumnos = new EtbInvUsuServ(Fecha,ususLogin, ususNombre, ususServ, ususEstadoa, ususidServ);

        em.persist(Alumnos);
    }

    //INSERTAR ACCESO PROJIBIDO
    @Transactional(rollbackFor = {ServicioException.class})
    public void ACCPROI(String Fecha, String usuetb, String ip, String url, String acc) {

        EtbInvAccesoProhibido Alumnos = new EtbInvAccesoProhibido(Fecha, usuetb, ip, url, acc);

        em.persist(Alumnos);
    }
    //INSERTAR USUARIO SERVIDOR

    @Transactional(rollbackFor = {ServicioException.class})
    public void crearcambioususerv(String Fecha, String ususLogin, String tCambio, EtbInvUsuEstado ususEstado) {

        EtbInvCamusuServ Alumnos = new EtbInvCamusuServ(Fecha, ususLogin, tCambio, ususEstado);

        em.persist(Alumnos);
    }
    //INSERTAR USUARIO APLICACION

    @Transactional(rollbackFor = {ServicioException.class})
    public void crearusuarioapp(int per, String nombre_recibido, String apellido_recibido, String Correo_recibido, String estado, int dom, String Codigo_Etb_Recibido, String usuario_recibido, String telefono_recibido, String Empresa_recibido, String Cargo_recibido, String Direccion_Recibido, String Cedula_Recibido, String telefono_ofici_recibido) {

        EtbInvUsuarioAp Alumnos = new EtbInvUsuarioAp(per, nombre_recibido, apellido_recibido, Correo_recibido, estado, dom, Codigo_Etb_Recibido, usuario_recibido, telefono_recibido, Empresa_recibido, Cargo_recibido, Direccion_Recibido, Cedula_Recibido, telefono_ofici_recibido);

        em.persist(Alumnos);
    }

    //actualizar usuario servidor
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvUsuServ update(String Fechas,Integer email, EtbInvUsuEstado ususEstado, String ususLogin, String nombre, String servidor, Integer admin,EtbInvServidor ususidServ) {
        EtbInvUsuServ Alumnos = new EtbInvUsuServ(Fechas,ususEstado, email, ususLogin, nombre, servidor, admin, ususidServ);
        return em.merge(Alumnos);
    }

    //insertar central
    @Transactional(rollbackFor = {ServicioException.class})
    public void newcentral(String Central) {
        EtbInvCentral Alumnos = new EtbInvCentral(Central);
        em.persist(Alumnos);
    }

    //insertar grupo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newgrupo(String Ngrupo, String Tgrupo) {
        EtbInvGrupo Alumnos = new EtbInvGrupo(Ngrupo, Tgrupo);
        em.persist(Alumnos);
    }

    //insertar marca
    @Transactional(rollbackFor = {ServicioException.class})
    public void newmarca(String nmarca, String usoporte, String tsoporte, String minterventor) {
        EtbInvMarca Alumnos = new EtbInvMarca(nmarca, usoporte, tsoporte, minterventor);
        em.persist(Alumnos);
    }

    //insertar plataforma
    @Transactional(rollbackFor = {ServicioException.class})
    public void newplataforma(String nplataforma, int aplataforma) {
        EtbInvPlataforma Alumnos = new EtbInvPlataforma(aplataforma, nplataforma);
        em.persist(Alumnos);
    }
    //insertar rol

    @Transactional(rollbackFor = {ServicioException.class})
    public void newrol(String nrol) {
        EtbInvRolServidor Alumnos = new EtbInvRolServidor(nrol);
        em.persist(Alumnos);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newsisoperativo(int sisdis, String nsis) {
        EtbInvSisOperativo Alumnos = new EtbInvSisOperativo(sisdis, nsis);
        em.persist(Alumnos);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newestado(String nest) {
        EtbInvEstado Alumnos = new EtbInvEstado(nest);
        em.persist(Alumnos);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newsalon(int scen, String nsal) {
        EtbInvSalon Alumnos = new EtbInvSalon(scen, nsal);
        em.persist(Alumnos);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newmodelo(int nmar, String nmod) {
        EtbInvModelo Alumnos = new EtbInvModelo(nmar, nmod);
        em.persist(Alumnos);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newcliente(String ncli, String ccli) {
        EtbInvCliente Alumnos = new EtbInvCliente(ncli, ccli);
        em.persist(Alumnos);
    }
}
