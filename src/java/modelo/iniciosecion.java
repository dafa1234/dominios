/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import tablas.EtbInvUsuarioAp;
import tablas.EtbInvActividad;
import tablas.EtbInvServidor;
import org.springframework.transaction.annotation.Transactional;
import tablas.EtbInvAccesoProhibido;
import tablas.EtbInvAdmPlataforma;
import tablas.EtbInvAseguramiento;
import tablas.EtbInvCambioTabla;
import tablas.EtbInvCamusuServ;
import tablas.EtbInvCasosProv;
import tablas.EtbInvCentral;
import tablas.EtbInvCliente;
import tablas.EtbInvContrato;
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvDetalleCambioTabla;
import tablas.EtbInvDireccionamiento;
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
import tablas.EtbInvRuta;
import tablas.EtbInvSalon;
import tablas.EtbInvSisOperativo;
import tablas.EtbInvTablaDominios;
import tablas.EtbInvTip;
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
     @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvRuta rutas(Integer email) throws SecurityException {
        String sql = "select a from EtbInvRuta a where  a.rutId = :email ";

        Query q = em.createQuery(sql);
        q.setParameter("email", email);

        try {
            return (EtbInvRuta) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvAseguramiento aseguramiento(int ususidSer) throws SecurityException {
        String sql = "select aa from EtbInvAseguramiento aa where  aa.aseId = :ususidSer ";

        Query q = em.createQuery(sql);
        q.setParameter("ususidSer", ususidSer);

        try {
            return (EtbInvAseguramiento) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
     @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvCasosProv casosprove(int ususidSer) throws SecurityException {
        String sql = "select aa from EtbInvCasosProv aa where  aa.caspId = :ususidSer ";

        Query q = em.createQuery(sql);
        q.setParameter("ususidSer", ususidSer);

        try {
            return (EtbInvCasosProv) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
      @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvActividad activida(int ususidSer) throws SecurityException {
        String sql = "select aa from EtbInvActividad aa where  aa.actId = :ususidSer ";

        Query q = em.createQuery(sql);
        q.setParameter("ususidSer", ususidSer);

        try {
            return (EtbInvActividad) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
    public List Lisreporte1(String F_Inicio, String F_Fin) {
        String sql = "select na from EtbInvServidor na where na.serFIngreso between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    public List Lisreporte2(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvUsuServ nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    public List Lisreporte3(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvCronogramaMto nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    public List Lisreporte4(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvContrato nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    public List Lisreporte5(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvAseguramiento nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    public List Lisreporte6(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvActividad nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    public List Lisreporte7(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvCasosProv nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    public List<EtbInvServidor> Listaservera(String fechaN, String fechaF) {
        String sql = "Select n from EtbInvServidor n where fecha =:fechaF  :fechaN";
        Query q = em.createQuery(sql);
        q.setParameter("gruIdGrupo", fechaN).setParameter("gruIdGrupo", fechaF);
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

    public EtbInvDireccionamiento ipmod(int IdIP) {
        String sql = "Select n from EtbInvDireccionamiento n where n.dirId= :IdIP";
        Query q = em.createQuery(sql);
        q.setParameter("IdIP", IdIP);
        try {
            return (EtbInvDireccionamiento) q.getSingleResult();
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

    public EtbInvCambioTabla idcambiotabla(EtbInvTablaDominios tabladominios, int idservidor, EtbInvUsuarioAp usuarioetb, String camtabSM) {
        String sql = "Select n  from EtbInvCambioTabla n where n.tabId= :tabId1  and n.tabIdtabla= :tabIdtabla1 and n.usuEtb= :usuEtb1 and n.camtabSM= :camtabSM1";
        Query q = em.createQuery(sql);
        q.setParameter("tabId1", tabladominios);
        q.setParameter("usuEtb1", usuarioetb);
        q.setParameter("tabIdtabla1", idservidor);
        q.setParameter("camtabSM1", camtabSM);
        try {
            return (EtbInvCambioTabla) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<EtbInvServidor> Listaserver() {
        String sql = "Select n from EtbInvServidor n";
        Query q = em.createQuery(sql);
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

    public List<EtbInvUsuServ> Listaususervre(EtbInvServidor email) {
        String sql = "Select n from EtbInvUsuServ n where n.idSerServidor= :email";
        Query q = em.createQuery(sql);
        q.setParameter("email", email);
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

    public List<EtbInvTip> Listatipoip() {
        String sql = "Select n from EtbInvTip n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /////////////////////////////////
    //INSERTAR SERVIDOR
    @Transactional(rollbackFor = {ServicioException.class})
    public void create(int SER_AD_COMPARTIDA, String Fecha, String serSerial, String serHostname, EtbInvMarca marIdMarca, EtbInvModelo modIdModelo, String serConexion, EtbInvCentral cenIdCentral,
            EtbInvSalon salIdSalon, EtbInvCliente cliIdCliente, EtbInvRolServidor rolIdRolServ, EtbInvPlataforma plaIdPlataforma, String serForAdCompartida, int serAdministrado,
            int serCores, String serTIngreso, String serUnidad, String serProyecto, String serRack, Integer serNoProcFisico, EtbInvEstado estIdEstado, EtbInvSisOperativo sisIdSisOperativo,
            EtbInvGrupo gruIdGrupo, Integer servMem, Integer servDiscoC) {
        EtbInvServidor servidor = new EtbInvServidor();
        servidor.setSerFIngreso(Fecha);
        servidor.setSerSerial(serSerial);
        servidor.setSerHostname(serHostname);
        servidor.setMarIdMarca(marIdMarca);
        servidor.setModIdModelo(modIdModelo);
        servidor.setSerConexion(serConexion);
        servidor.setCenIdCentral(cenIdCentral);
        servidor.setSalIdSalon(salIdSalon);
        servidor.setCliIdCliente(cliIdCliente);
        servidor.setRolIdRolServ(rolIdRolServ);
        servidor.setPlaIdPlataforma(plaIdPlataforma);
        servidor.setSerTareaAdCompartida(serForAdCompartida);
        servidor.setSerAdministrado(serAdministrado);
        servidor.setSerCores(serCores);
        servidor.setSerTIngreso(serTIngreso);
        servidor.setSerUnidad(serUnidad);
        servidor.setSerProyecto(serProyecto);
        servidor.setSerRack(serRack);
        servidor.setSerNoProcFisico(serNoProcFisico);
        servidor.setEstIdEstado(estIdEstado);
        servidor.setSisIdSisOperativo(sisIdSisOperativo);
        servidor.setGruIdGrupo(gruIdGrupo);
        servidor.setServMem(servMem);
        servidor.setServDiscoC(servDiscoC);
        servidor.setSerAdCompartida(SER_AD_COMPARTIDA);

        em.persist(servidor);
    }

    //INSERTAR ACTIVIDAD
    @Transactional(rollbackFor = {ServicioException.class})
    public void creact(String Fecha, String serHostname, EtbInvServidor serv1, String actEjecuta, String actTarea, String actDescripcion, String actSolicita, EtbInvTipoActividad actTipo, String actFechaFin, String actFechaIni) {
        EtbInvActividad actividad = new EtbInvActividad();
        actividad.setActDescripcion(actDescripcion);
        actividad.setActEjecuta(actEjecuta);
        actividad.setActFechaFin(actFechaFin);
        actividad.setActFechaIni(actFechaIni);
        actividad.setActServ(serHostname);
        actividad.setActServ1(serv1);
        actividad.setActSolicita(actSolicita);
        actividad.setActTarea(actTarea);
        actividad.setActTipo(actTipo);
        actividad.setFCreacion(Fecha);
        em.persist(actividad);
    }
    //INSERTAR ASEGURAMIENTO

    @Transactional(rollbackFor = {ServicioException.class})
    public void crease(String Fecha, String aseTarea, EtbInvServidor aseServidor, String aseEjecuta, String aseFecha,int aseplantilla) {
        EtbInvAseguramiento aseguramiento = new EtbInvAseguramiento();
        aseguramiento.setAseEjecuta(aseEjecuta);
        aseguramiento.setAseFecha(aseFecha);
        aseguramiento.setAseServidor(aseServidor);
        aseguramiento.setAseTarea(aseTarea);
        aseguramiento.setFCreacion(Fecha);
        aseguramiento.setAsePlantilla(aseplantilla);
        em.persist(aseguramiento);
    }
     //modificar ASEGURAMIENTO

    @Transactional(rollbackFor = {ServicioException.class})
    public void modiase(int idasegu, String fCreacion, String aseTarea, EtbInvServidor aseServidor, String aseEjecuta, String fini,int aseplantilla) {
        EtbInvAseguramiento aseguramiento = new EtbInvAseguramiento();
        aseguramiento.setAseId(idasegu);
        aseguramiento.setAseEjecuta(aseEjecuta);
        aseguramiento.setAseFecha(fini);
        aseguramiento.setAseServidor(aseServidor);
        aseguramiento.setAseTarea(aseTarea);
        aseguramiento.setFCreacion(fCreacion);
        aseguramiento.setAsePlantilla(aseplantilla);
        em.merge(aseguramiento);
    }
    //INSERTAR CONTRATO

    @Transactional(rollbackFor = {ServicioException.class})
    public void creacont(String Fecha, EtbInvMarca contProv, EtbInvTipoCont contTipo, String contFechaIni, String contFechaFin, String contNum, EtbInvEstadoCont contEstado, String contLogin, String contDescrip) {
        EtbInvContrato contrato = new EtbInvContrato();
        contrato.setContDescrip(contDescrip);
        contrato.setContEstado(contEstado);
        contrato.setContFechaFin(contFechaFin);
        contrato.setContFechaIni(contFechaIni);
        contrato.setContLogin(contLogin);
        contrato.setContNum(contNum);
        contrato.setContProv(contProv);
        contrato.setContTipo(contTipo);
        contrato.setFCreacion(Fecha);
        em.persist(contrato);
    }

    //INSERTAR CRONOGRAMA
    @Transactional(rollbackFor = {ServicioException.class})
    public void creacrono(String Fecha, EtbInvProyecto croProyecto, String croFechaIni, String croSerial, String croEjecuta, String croCambioFin, EtbInvEstadoMto croEstado) {
        EtbInvCronogramaMto cronograma = new EtbInvCronogramaMto();
        cronograma.setCroCambioFin(croCambioFin);
        cronograma.setCroEjecuta(croEjecuta);
        cronograma.setCroEstado(croEstado);
        cronograma.setCroFechaIni(croFechaIni);
        cronograma.setCroProyecto(croProyecto);
        cronograma.setCroSerial(croSerial);
        cronograma.setFCreacion(Fecha);
        em.persist(cronograma);
    }

    //INSERTAR CASOSPROVEEDOR
    @Transactional(rollbackFor = {ServicioException.class})
    public void creaproveedor(EtbInvServidor caspserv,String Fecha, EtbInvMarca caspProv, String caspServ, String caspFechaApe, String caspFechaCie, String caspNumero, String caspIm, EtbInvEstadoCasos caspEstado) {
        EtbInvCasosProv casosprove = new EtbInvCasosProv();
        casosprove.setCaspEstado(caspEstado);
        casosprove.setCaspFechaApe(caspFechaApe);
        casosprove.setCaspFechaCie(caspFechaCie);
        casosprove.setCaspIm(caspIm);
        casosprove.setCaspNumero(caspNumero);
        casosprove.setCaspProv(caspProv);
        casosprove.setCaspServ(caspServ);
        casosprove.setFCreacion(Fecha);
        casosprove.setCaspServ1(caspserv);
        em.persist(casosprove);
    }
    //INSERTAR USUARIO SERVIDOR

    @Transactional(rollbackFor = {ServicioException.class})
    public void crearususerv(String Fecha, String ususLogin, String ususNombre, String ususServ, EtbInvUsuEstado ususEstadoa, EtbInvServidor ususidServ,int administrado) {
        EtbInvUsuServ usuarioserv = new EtbInvUsuServ();
        usuarioserv.setUsusAdm(administrado);
        usuarioserv.setFCreacion(Fecha);
        usuarioserv.setIdSerServidor(ususidServ);
        usuarioserv.setUsusEstado(ususEstadoa);
        usuarioserv.setUsusLogin(ususLogin);
        usuarioserv.setUsusNombre(ususNombre);
        usuarioserv.setUsusServ(ususServ);
        em.persist(usuarioserv);
    }
    //llenarbitacora

    @Transactional(rollbackFor = {ServicioException.class})
    public void llenarbitacora(EtbInvTablaDominios tabladominios, int idservidor, EtbInvUsuarioAp usuarioetb, String FechaH, String cam_tab_SM, String cam_tab_descripcion_SM, String cam_tab_solicitante_SM) {
        EtbInvCambioTabla cambiotab = new EtbInvCambioTabla();
        cambiotab.setCamTabFecha(FechaH);
        cambiotab.setCamtabSM(cam_tab_SM);
        cambiotab.setCamtabdescripcionSM(cam_tab_descripcion_SM);
        cambiotab.setCamtabsolicitanteSM(cam_tab_solicitante_SM);
        cambiotab.setTabId(tabladominios);
        cambiotab.setTabIdtabla(idservidor);
        cambiotab.setUsuEtb(usuarioetb);
        em.persist(cambiotab);
    }
    //llenarbitacora

    @Transactional(rollbackFor = {ServicioException.class})
    public void llenarbitacoradetalle(String CamColumna, String CamNawValor, String CamValorIni, EtbInvCambioTabla CamIdtabla) {
        EtbInvDetalleCambioTabla cambiotabdet = new EtbInvDetalleCambioTabla();
        cambiotabdet.setDatCamColumna(CamColumna);
        cambiotabdet.setDetCamNawValor(CamNawValor);
        cambiotabdet.setDetCamValorIni(CamValorIni);
        cambiotabdet.setDetCamIdtabla(CamIdtabla);
        em.persist(cambiotabdet);
    }

    //INSERTAR ACCESO PROJIBIDO
    @Transactional(rollbackFor = {ServicioException.class})
    public void ACCPROI(String Fecha, String usuetb, String ip, String url, String acc) {
        EtbInvAccesoProhibido Acesopro = new EtbInvAccesoProhibido();
        Acesopro.setUsuAccFecha(Fecha);
        Acesopro.setUsuAccIp(ip);
        Acesopro.setUsuAccOperacion(acc);
        Acesopro.setUsuAccUlr(url);
        Acesopro.setUsuAccUsuario(usuetb);
        em.persist(Acesopro);
    }
    //INSERTAR USUARIO SERVIDOR

    @Transactional(rollbackFor = {ServicioException.class})
    public void crearcambioususerv(String Fecha, String ususLogin, String tCambio, EtbInvUsuEstado ususEstado) {
        EtbInvCamusuServ cambiousuario = new EtbInvCamusuServ();
        cambiousuario.setUsuCambio(ususLogin);
        cambiousuario.setUsuFecCambio(Fecha);
        cambiousuario.setUsuTarCambio(tCambio);
        cambiousuario.setUsusEstado(ususEstado);
        em.persist(cambiousuario);
    }
    //INSERTAR USUARIO APLICACION

    @Transactional(rollbackFor = {ServicioException.class})
    public void crearusuarioapp(int per, String nombre_recibido, String apellido_recibido, String Correo_recibido, String estado, int dom, String Codigo_Etb_Recibido, String usuario_recibido, String telefono_recibido, String Empresa_recibido, String Cargo_recibido, String Direccion_Recibido, String Cedula_Recibido, String telefono_ofici_recibido) {
        EtbInvUsuarioAp usuarioapi = new EtbInvUsuarioAp();
        usuarioapi.setUsuApell(apellido_recibido);
        usuarioapi.setUsuCargo(Cargo_recibido);
        usuarioapi.setUsuCedula(Cedula_Recibido);
        usuarioapi.setUsuCodEtb(Codigo_Etb_Recibido);
        usuarioapi.setUsuCorreo(Correo_recibido);
        usuarioapi.setUsuDireccion(Direccion_Recibido);
        usuarioapi.setUsuDominio(dom);
        usuarioapi.setUsuEmpresa(Empresa_recibido);
        usuarioapi.setUsuEstado(estado);
        usuarioapi.setUsuEtb(usuario_recibido);
        usuarioapi.setUsuIdPer(per);
        usuarioapi.setUsuNombre(nombre_recibido);
        usuarioapi.setUsuTelOficina(telefono_ofici_recibido);
        usuarioapi.setUsuTelefono(telefono_recibido);
        em.persist(usuarioapi);
    }

    //actualizar usuario servidor
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvUsuServ update(String Fechas, Integer email, EtbInvUsuEstado ususEstado, String ususLogin, String nombre, String servidor, Integer admin, EtbInvServidor ususidServ) {
        EtbInvUsuServ ususer = new EtbInvUsuServ();
        ususer.setUsusId(email);
        ususer.setFCreacion(Fechas);
        ususer.setUsusAdm(admin);
        ususer.setUsusEstado(ususEstado);
        ususer.setIdSerServidor(ususidServ);
        ususer.setUsusLogin(ususLogin);
        ususer.setUsusNombre(nombre);
        ususer.setUsusServ(servidor);
        return em.merge(ususer);

    }

    //modificar servidor
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvServidor updateservidor(int idservidor, String serialservidor, String hostnameservidor, String conexionservidor, EtbInvMarca marIdMarca, EtbInvModelo modIdModelo, String rackservidor, EtbInvCentral cenIdCentral, EtbInvSalon salIdSalon, EtbInvCliente cliIdCliente, EtbInvRolServidor rolIdRolServ, EtbInvPlataforma plaIdPlataforma, String unidadservidor, String proyectoservidor, String fechaingservidor, String tareaingresoservidor, int Nprocesosservidor, String TareaAdCompartida, int adcompservidor, int admiservidor, EtbInvEstado estIdEstado, EtbInvSisOperativo sisIdSisOperativo, EtbInvGrupo gruIdGrupo, int coresservidor, int memservidor, int discocservidor) {
        EtbInvServidor Mservidor = new EtbInvServidor();
        Mservidor.setSerServer(idservidor);
        Mservidor.setSerSerial(serialservidor);
        Mservidor.setSerHostname(hostnameservidor);
        Mservidor.setSerConexion(conexionservidor);
        Mservidor.setSerRack(rackservidor);
        Mservidor.setSerUnidad(unidadservidor);
        Mservidor.setSerProyecto(proyectoservidor);
        Mservidor.setSerFIngreso(fechaingservidor);
        Mservidor.setSerTIngreso(tareaingresoservidor);
        Mservidor.setSerNoProcFisico(Nprocesosservidor);
        Mservidor.setSerTareaAdCompartida(TareaAdCompartida);
        Mservidor.setSerAdCompartida(adcompservidor);
        Mservidor.setSerAdministrado(admiservidor);
        Mservidor.setSerCores(coresservidor);
        Mservidor.setServMem(memservidor);
        Mservidor.setServDiscoC(discocservidor);
        Mservidor.setSisIdSisOperativo(sisIdSisOperativo);
        Mservidor.setRolIdRolServ(rolIdRolServ);
        Mservidor.setEstIdEstado(estIdEstado);
        Mservidor.setGruIdGrupo(gruIdGrupo);
        Mservidor.setMarIdMarca(marIdMarca);
        Mservidor.setModIdModelo(modIdModelo);
        Mservidor.setCliIdCliente(cliIdCliente);
        Mservidor.setCenIdCentral(cenIdCentral);
        Mservidor.setSalIdSalon(salIdSalon);
        Mservidor.setPlaIdPlataforma(plaIdPlataforma);
        return em.merge(Mservidor);

    }

    //insertar direccionamiento
    @Transactional(rollbackFor = {ServicioException.class})
    public void direccionamiento(String dirDirServ, String dirIp, String dirVlan, String dirSwitch, String dirPuerto, EtbInvServidor idSer, EtbInvTip dirTipo) {
        EtbInvDireccionamiento direccionamiento = new EtbInvDireccionamiento();
        direccionamiento.setDirDirServ(dirDirServ);
        direccionamiento.setDirIp(dirIp);
        direccionamiento.setDirPuerto(dirPuerto);
        direccionamiento.setDirSwitch(dirSwitch);
        direccionamiento.setDirTipo(dirTipo);
        direccionamiento.setDirVlan(dirVlan);
        direccionamiento.setIdSer(idSer);
        em.persist(direccionamiento);
    }
        //insertar direccionamiento
    @Transactional(rollbackFor = {ServicioException.class})
    public void direccionamientoedite(int iddirIp, String dirDirServ, String dirIp, String dirVlan, String dirSwitch, String dirPuerto, EtbInvServidor idSer, EtbInvTip dirTipo) {
        EtbInvDireccionamiento direccionamiento = new EtbInvDireccionamiento();
        direccionamiento.setDirDirServ(dirDirServ);
        direccionamiento.setDirIp(dirIp);
        direccionamiento.setDirPuerto(dirPuerto);
        direccionamiento.setDirSwitch(dirSwitch);
        direccionamiento.setDirTipo(dirTipo);
        direccionamiento.setDirVlan(dirVlan);
        direccionamiento.setIdSer(idSer);
        direccionamiento.setDirId(iddirIp);
        em.merge(direccionamiento);
    }
//insertar rutas
    @Transactional(rollbackFor = {ServicioException.class})
    public void agragarrutas(String FechaH,String rutaser,EtbInvServidor idSer,String idSerna) {
        EtbInvRuta rutas = new EtbInvRuta();
        rutas.setRutFecha(FechaH);
        rutas.setRutRuta(rutaser);
        rutas.setRutSerial(idSerna);
        rutas.setRutSerial1(idSer);
        em.persist(rutas);
    }
    //modificar rutas
    @Transactional(rollbackFor = {ServicioException.class})
    public void editarrutas( int idrutas,String FechaH,String rutaser,EtbInvServidor idSer,String idSerna) {
        EtbInvRuta rutas = new EtbInvRuta();
        rutas.setRutId(idrutas);
        rutas.setRutFecha(FechaH);
        rutas.setRutRuta(rutaser);
        rutas.setRutSerial(idSerna);
        rutas.setRutSerial1(idSer);
        em.merge(rutas);
    }
    //modificar casos proveedor
     @Transactional(rollbackFor = {ServicioException.class})
    public void modificarcasproveedor(EtbInvMarca proveedor1, int idcasos, String fini, String fcie, EtbInvEstadoCasos estini1, String numcas, String im, String fCreacion, String caspServ, EtbInvServidor servi) {
        EtbInvCasosProv casosprove = new EtbInvCasosProv();
        casosprove.setCaspId(idcasos);
        casosprove.setCaspEstado(estini1);
        casosprove.setCaspFechaApe(fini);
        casosprove.setCaspFechaCie(fcie);
        casosprove.setCaspIm(im);
        casosprove.setCaspNumero(numcas);
        casosprove.setCaspProv(proveedor1);
        casosprove.setCaspServ(caspServ);
        casosprove.setFCreacion(fCreacion);
        casosprove.setCaspServ1(servi);
        em.merge(casosprove);
    }
     //modificar ACTIVIDAD
    @Transactional(rollbackFor = {ServicioException.class})
    public void modificaractiv(Integer actId,String Fecha, String serHostname, EtbInvServidor serv1, String actEjecuta, String actTarea, String actDescripcion, String actSolicita, EtbInvTipoActividad actTipo, String actFechaFin, String actFechaIni) {
        EtbInvActividad actividad = new EtbInvActividad();
        actividad.setActId(actId);
        actividad.setActDescripcion(actDescripcion);
        actividad.setActEjecuta(actEjecuta);
        actividad.setActFechaFin(actFechaFin);
        actividad.setActFechaIni(actFechaIni);
        actividad.setActServ(serHostname);
        actividad.setActServ1(serv1);
        actividad.setActSolicita(actSolicita);
        actividad.setActTarea(actTarea);
        actividad.setActTipo(actTipo);
        actividad.setFCreacion(Fecha);
        em.merge(actividad);
    }
    
    //insertar central
    @Transactional(rollbackFor = {ServicioException.class})
    public void newcentral(String Central) {
        EtbInvCentral central = new EtbInvCentral();
        central.setCenNombre(Central);
        em.persist(central);
    }

    //insertar grupo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newgrupo(String Ngrupo, String Tgrupo) {
        EtbInvGrupo grupo = new EtbInvGrupo();
        grupo.setGruNomGrupo(Ngrupo);
        grupo.setGruTipoGrupo(Tgrupo);
        em.persist(grupo);
    }

    //insertar marca
    @Transactional(rollbackFor = {ServicioException.class})
    public void newmarca(String nmarca, String usoporte, String tsoporte, String minterventor) {
        EtbInvMarca marca = new EtbInvMarca();
        marca.setMarInterventor(minterventor);
        marca.setMarNomMarca(nmarca);
        marca.setMarTelSoporte(tsoporte);
        marca.setMarUrlSoporte(usoporte);
        em.persist(marca);
    }

    //insertar plataforma
    @Transactional(rollbackFor = {ServicioException.class})
    public void newplataforma(String nplataforma, EtbInvAdmPlataforma aplataforma) {
        EtbInvPlataforma plataforma = new EtbInvPlataforma();
        plataforma.setPlaAdmPlataforma(aplataforma);
        plataforma.setPlaNomPlataforma(nplataforma);
        em.persist(plataforma);
    }
    //insertar rol

    @Transactional(rollbackFor = {ServicioException.class})
    public void newrol(String nrol) {
        EtbInvRolServidor rolser = new EtbInvRolServidor();
        rolser.setRolNomRolServ(nrol);
        em.persist(rolser);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newsisoperativo(int sisdis, String nsis) {
        EtbInvSisOperativo sisope = new EtbInvSisOperativo();
        sisope.setSisDistribucion(sisdis);
        sisope.setSisNombre(nsis);
        em.persist(sisope);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newestado(String nest) {
        EtbInvEstado estado = new EtbInvEstado();
        estado.setEstEstado(nest);
        em.persist(estado);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newsalon(int scen, String nsal) {
        EtbInvSalon salon = new EtbInvSalon();
        salon.setSalCentral(scen);
        salon.setSalNombre(nsal);
        em.persist(salon);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newmodelo(int nmar, String nmod) {
        EtbInvModelo modelo = new EtbInvModelo();
        modelo.setMarIdMarca(nmar);
        modelo.setModNomModelo(nmod);
        em.persist(modelo);
    }

    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newcliente(String ncli, String ccli) {
        EtbInvCliente cliente = new EtbInvCliente();
        cliente.setCliContacto(ccli);
        cliente.setCliNombre(ncli);
        em.persist(cliente);
    }

 

}
