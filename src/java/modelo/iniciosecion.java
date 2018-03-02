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

    /**
     * en readByRutJPQL comsultamos a la tabla EtbInvUsuarioAp para saber si el
     * usuario existe o no, y llamar todos los datos de este usuario.
     *
     * @param usuEtb
     * @return
     * @throws SecurityException
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvUsuarioAp readByRutJPQL(String usuEtb) throws SecurityException {
        //en el  (String sql) creamos una comsulta de tipo sql para consulta en las tablas
        String sql = "select a from EtbInvUsuarioAp a where  a.usuEtb = :usuEtb ";
        //en el (Query q) tomamos el String ya creado y pormedio del (em.createQuery) enviamos la consulta la cualnos devuelbe la 
        //informacion y la guarda en (Query q).
        Query q = em.createQuery(sql);
        //por medio de (q.setParameter) tomamos el (String usuEtb) para poder introdusirlo en la consulta 
        q.setParameter("usuEtb", usuEtb);

        try {
            return (EtbInvUsuarioAp) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        //es igual en todos los public que utilizan el (Query) de (EntityManager)
    }

    /**
     * en readid consultamos la tabla EtbInvServidor para llamar la informacion
     * del servidor segun el id (IdServidor)
     *
     * @param IdServidor
     * @return
     * @throws SecurityException
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvServidor readid(int IdServidor) throws SecurityException {
        String sql = "select aa from EtbInvServidor aa where  aa.serServer = :IdServidor ";

        Query q = em.createQuery(sql);
        q.setParameter("IdServidor", IdServidor);

        try {
            return (EtbInvServidor) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * en buscarususerv consultamos la tabla EtbInvUsuServ para llamar
     * informacion de los usuarios de un servidor por medio del Id
     * (Idususervidor)
     *
     * @param Idususervidor
     * @return
     * @throws SecurityException
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvUsuServ buscarususerv(Integer Idususervidor) throws SecurityException {
        String sql = "select a from EtbInvUsuServ a where  a.ususId = :Idususervidor ";

        Query q = em.createQuery(sql);
        q.setParameter("Idususervidor", Idususervidor);

        try {
            return (EtbInvUsuServ) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * en rutas consultamos la tabla EtbInvRuta para llamar informacion de una
     * ruta por medio del ID (IdRuta)
     *
     * @param IdRuta
     * @return
     * @throws SecurityException
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvRuta rutas(Integer IdRuta) throws SecurityException {
        String sql = "select a from EtbInvRuta a where  a.rutId = :IdRuta ";

        Query q = em.createQuery(sql);
        q.setParameter("IdRuta", IdRuta);

        try {
            return (EtbInvRuta) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * en aseguramiento consultamos la tabla EtbInvAseguramiento para llamar
     * informacion de un aseguramiento por medio del ID (IdAseguramiento)
     *
     * @param IdAseguramiento
     * @return
     * @throws SecurityException
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvAseguramiento aseguramiento(int IdAseguramiento) throws SecurityException {
        String sql = "select aa from EtbInvAseguramiento aa where  aa.aseId = :IdAseguramiento ";

        Query q = em.createQuery(sql);
        q.setParameter("IdAseguramiento", IdAseguramiento);

        try {
            return (EtbInvAseguramiento) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * en casosprove consultamos la tabla EtbInvCasosProv para llamar
     * informacion de un caso por medio del ID (IdAseguramiento)
     *
     * @param IdCasosProveedor
     * @return
     * @throws SecurityException
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvCasosProv casosprove(int IdCasosProveedor) throws SecurityException {
        String sql = "select aa from EtbInvCasosProv aa where  aa.caspId = :IdCasosProveedor ";

        Query q = em.createQuery(sql);
        q.setParameter("IdCasosProveedor", IdCasosProveedor);

        try {
            return (EtbInvCasosProv) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * en activida consultamos la tabla EtbInvActividad para llamar informacion
     * de una actividad por medio del ID (IdActividad)
     *
     * @param IdActividad
     * @return
     * @throws SecurityException
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvActividad activida(int IdActividad) throws SecurityException {
        String sql = "select aa from EtbInvActividad aa where  aa.actId = :IdActividad ";

        Query q = em.createQuery(sql);
        q.setParameter("IdActividad", IdActividad);

        try {
            return (EtbInvActividad) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * en cronograma consultamos la tabla EtbInvCronogramaMto para llamar
     * informacion de un cronograma por medio del ID (IdCronograma)
     *
     * @param IdCronograma
     * @return
     * @throws SecurityException
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvCronogramaMto cronograma(int IdCronograma) throws SecurityException {
        String sql = "select aa from EtbInvCronogramaMto aa where  aa.croId = :IdCronograma ";

        Query q = em.createQuery(sql);
        q.setParameter("IdCronograma", IdCronograma);

        try {
            return (EtbInvCronogramaMto) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * en contratos consultamos la tabla EtbInvContrato para llamar informacion
     * de un contrato por medio del ID (IdContratos)
     *
     * @param IdContratos
     * @return
     * @throws SecurityException
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvContrato contratos(int IdContratos) throws SecurityException {
        String sql = "select aa from EtbInvContrato aa where  aa.contId = :IdContratos ";

        Query q = em.createQuery(sql);
        q.setParameter("IdContratos", IdContratos);

        try {
            return (EtbInvContrato) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * en Lisreporte1 por medio de los (String F_Inicio, String F_Fin)
     * consultamos en la tabla EtbInvServidor las filas creadas entre estas
     * fechas
     *
     * @param F_Inicio
     * @param F_Fin
     * @return
     */
    public List Lisreporte1(String F_Inicio, String F_Fin) {
        String sql = "select na from EtbInvServidor na where na.serFIngreso between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    /**
     * en Lisreporte2 por medio de los (String F_Inicio, String F_Fin)
     * consultamos en la tabla EtbInvUsuServ las filas creadas entre estas
     * fechas
     *
     * @param F_Inicio
     * @param F_Fin
     * @return
     */
    public List Lisreporte2(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvUsuServ nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    /**
     * en Lisreporte3 por medio de los (String F_Inicio, String F_Fin)
     * consultamos en la tabla EtbInvCronogramaMto las filas creadas entre estas
     * fechas
     *
     * @param F_Inicio
     * @param F_Fin
     * @return
     */
    public List Lisreporte3(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvCronogramaMto nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    /**
     * en Lisreporte4 por medio de los (String F_Inicio, String F_Fin)
     * consultamos en la tabla EtbInvContrato las filas creadas entre estas
     * fechas
     *
     * @param F_Inicio
     * @param F_Fin
     * @return
     */
    public List Lisreporte4(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvContrato nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    /**
     * en Lisreporte5 por medio de los (String F_Inicio, String F_Fin)
     * consultamos en la tabla EtbInvAseguramiento las filas creadas entre estas
     * fechas
     *
     * @param F_Inicio
     * @param F_Fin
     * @return
     */
    public List Lisreporte5(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvAseguramiento nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    /**
     * en Lisreporte6 por medio de los (String F_Inicio, String F_Fin)
     * consultamos en la tabla EtbInvActividad las filas creadas entre estas
     * fechas
     *
     * @param F_Inicio
     * @param F_Fin
     * @return
     */
    public List Lisreporte6(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvActividad nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    /**
     * en Lisreporte7 por medio de los (String F_Inicio, String F_Fin)
     * consultamos en la tabla EtbInvCasosProv las filas creadas entre estas
     * fechas
     *
     * @param F_Inicio
     * @param F_Fin
     * @return
     */
    public List Lisreporte7(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvCasosProv nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        return q.getResultList();
    }

    /**
     * en readByRut consultamos la tabla EtbInvGrupo para llamar informacion de
     * un grupo por medio del ID (Idgrup)
     *
     * @param Idgrup
     * @return
     */
    public EtbInvGrupo readByRut(Integer Idgrup) {
        String sql = "select nn from EtbInvGrupo nn where  nn.gruIdGrupo = :Idgrup";
        Query q = em.createQuery(sql);
        q.setParameter("Idgrup", Idgrup);
        try {
            return (EtbInvGrupo) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * en ipmod consultamos la tabla EtbInvDireccionamiento para llamar
     * informacion de una IP por medio del ID (IdIP)
     *
     * @param IdIP
     * @return
     */
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

    /**
     * en ListaDetalle consultamos la tabla EtbInvCamusuServ por medio del
     * (String usuario) para traer la lista de los cambios echos a ese usuario
     *
     * @param usuario
     * @return
     */
    public List<EtbInvCamusuServ> ListaDetalle(String usuario) {
        String sql = "Select n from EtbInvCamusuServ n where n.usuCambio= :usuario";
        Query q = em.createQuery(sql);
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }

    /**
     * en idcambiotabla consultamos la tabla EtbInvCambioTabla por medio de los
     * campos (EtbInvTablaDominios tabladominios, int idservidor,
     * EtbInvUsuarioAp usuarioetb, String camtabSM) para traer la informacion
     *
     * @param tabladominios
     * @param idservidor
     * @param usuarioetb
     * @param camtabSM
     * @return
     */
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

    /**
     * en ListaMarca traemos una lista con toda la informacion de la tabla
     * EtbInvMarca
     *
     * @return
     */
    public List<EtbInvMarca> ListaMarca() {
        String sql = "Select n from EtbInvMarca n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listaserver traemos una lista con toda la informacion de la tabla
     * EtbInvServidor
     *
     * @return
     */
    public List<EtbInvServidor> Listaserver() {
        String sql = "Select n from EtbInvServidor n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaEstado traemos una lista con toda la informacion de la tabla
     * EtbInvEstado
     *
     * @return
     */
    public List<EtbInvEstado> ListaEstado() {
        String sql = "Select n from EtbInvEstado n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaModelo traemos una lista con toda la informacion de la tabla
     * EtbInvModelo
     *
     * @return
     */
    public List<EtbInvModelo> ListaModelo() {
        String sql = "Select n from EtbInvModelo n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaCliente traemos una lista con toda la informacion de la tabla
     * EtbInvCliente
     *
     * @return
     */
    public List<EtbInvCliente> ListaCliente() {
        String sql = "Select n from EtbInvCliente n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listasisope traemos una lista con toda la informacion de la tabla
     * EtbInvSisOperativo
     *
     * @return
     */
    public List<EtbInvSisOperativo> Listasisope() {
        String sql = "Select n from EtbInvSisOperativo n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listagrupo traemos una lista con toda la informacion de la tabla
     * EtbInvGrupo
     *
     * @return
     */
    public List<EtbInvGrupo> Listagrupo() {
        String sql = "Select n from EtbInvGrupo n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaCentral traemos una lista con toda la informacion de la tabla
     * EtbInvCentral
     *
     * @return
     */
    public List<EtbInvCentral> ListaCentral() {
        String sql = "Select n from EtbInvCentral n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaPrataforma traemos una lista con toda la informacion de la tabla
     * EtbInvPlataforma
     *
     * @return
     */
    public List<EtbInvPlataforma> ListaPrataforma() {
        String sql = "Select n from EtbInvPlataforma n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaRolserver traemos una lista con toda la informacion de la tabla
     * EtbInvRolServidor
     *
     * @return
     */
    public List<EtbInvRolServidor> ListaRolserver() {
        String sql = "Select n from EtbInvRolServidor n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaSalom traemos una lista con toda la informacion de la tabla
     * EtbInvSalon
     *
     * @return
     */
    public List<EtbInvSalon> ListaSalom() {
        String sql = "Select n from EtbInvSalon n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaActividad traemos una lista con toda la informacion de la tabla
     * EtbInvActividad
     *
     * @return
     */
    public List<EtbInvActividad> ListaActividad() {
        String sql = "Select n from EtbInvActividad n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaContra traemos una lista con toda la informacion de la tabla
     * EtbInvContrato
     *
     * @return
     */
    public List<EtbInvContrato> ListaContra() {
        String sql = "Select n from EtbInvContrato n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaCrono traemos una lista con toda la informacion de la tabla
     * EtbInvCronogramaMto
     *
     * @return
     */
    public List<EtbInvCronogramaMto> ListaCrono() {
        String sql = "Select n from EtbInvCronogramaMto n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en ListaProyecto traemos una lista con toda la informacion de la tabla
     * EtbInvProyecto
     *
     * @return
     */
    public List<EtbInvProyecto> ListaProyecto() {
        String sql = "Select n from EtbInvProyecto n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listacont traemos una lista con toda la informacion de la tabla
     * EtbInvTipoCont
     *
     * @return
     */
    public List<EtbInvTipoCont> Listacont() {
        String sql = "Select n from EtbInvTipoCont n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listaproveedor traemos una lista con toda la informacion de la tabla
     * EtbInvCasosProv
     *
     * @return
     */
    public List<EtbInvCasosProv> Listaproveedor() {
        String sql = "Select n from EtbInvCasosProv n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listaususerv consultamos la tabla EtbInvUsuServ por medio de
     * estado(EtbInvUsuEstado ususEstadoa) para crear una lista con esta
     * iformacion
     *
     * @param ususEstadoa
     * @return
     */
    public List<EtbInvUsuServ> Listaususerv(EtbInvUsuEstado ususEstadoa) {
        String sql = "Select n from EtbInvUsuServ n where n.ususEstado= :estado";
        Query q = em.createQuery(sql);
        q.setParameter("estado", ususEstadoa);
        return q.getResultList();
    }

    /**
     * en Listaususervre consultamos la tabla EtbInvUsuServ por medio de
     * idservidor(EtbInvServidor idservidor) para crear una lista con esta
     * iformacion
     *
     * @param idservidor
     * @return
     */
    public List<EtbInvUsuServ> Listaususervre(EtbInvServidor idservidor) {
        String sql = "Select n from EtbInvUsuServ n where n.idSerServidor= :idservidor";
        Query q = em.createQuery(sql);
        q.setParameter("idservidor", idservidor);
        return q.getResultList();
    }

    /**
     * en Listausuest traemos una lista con toda la informacion de la tabla
     * EtbInvUsuEstado
     *
     * @return
     */
    public List<EtbInvUsuEstado> Listausuest() {
        String sql = "Select n from EtbInvUsuEstado n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listaestacont traemos una lista con toda la informacion de la tabla
     * EtbInvEstadoCont
     *
     * @return
     */
    public List<EtbInvEstadoCont> Listaestacont() {
        String sql = "Select n from EtbInvEstadoCont n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listaestamto traemos una lista con toda la informacion de la tabla
     * EtbInvEstadoMto
     *
     * @return
     */
    public List<EtbInvEstadoMto> Listaestamto() {
        String sql = "Select n from EtbInvEstadoMto n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listaestacasos traemos una lista con toda la informacion de la tabla
     * EtbInvEstadoCasos
     *
     * @return
     */
    public List<EtbInvEstadoCasos> Listaestacasos() {
        String sql = "Select n from EtbInvEstadoCasos n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listatipoactiv traemos una lista con toda la informacion de la tabla
     * EtbInvTipoActividad
     *
     * @return
     */
    public List<EtbInvTipoActividad> Listatipoactiv() {
        String sql = "Select n from EtbInvTipoActividad n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en Listatipoip traemos una lista con toda la informacion de la tabla
     * EtbInvTip
     *
     * @return
     */
    public List<EtbInvTip> Listatipoip() {
        String sql = "Select n from EtbInvTip n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /**
     * en listaAdmPlataforma traemos una lista con toda la informacion de la
     * tabla EtbInvAdmPlataforma
     *
     * @return
     */
    public List<EtbInvAdmPlataforma> listaAdmPlataforma() {
        String sql = "Select n from EtbInvAdmPlataforma n";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    /////////////////////////////////
    /**
     * en create creamos un nuevo servidor
     *
     * @param SER_AD_COMPARTIDA
     * @param Fecha
     * @param serSerial
     * @param serHostname
     * @param marIdMarca
     * @param modIdModelo
     * @param serConexion
     * @param cenIdCentral
     * @param salIdSalon
     * @param cliIdCliente
     * @param rolIdRolServ
     * @param plaIdPlataforma
     * @param serForAdCompartida
     * @param serAdministrado
     * @param serCores
     * @param serTIngreso
     * @param serUnidad
     * @param serProyecto
     * @param serRack
     * @param serNoProcFisico
     * @param estIdEstado
     * @param sisIdSisOperativo
     * @param gruIdGrupo
     * @param servMem
     * @param servDiscoC
     */
    //INSERTAR SERVIDOR
    @Transactional(rollbackFor = {ServicioException.class})
    public void create(int SER_AD_COMPARTIDA, String Fecha, String serSerial, String serHostname, EtbInvMarca marIdMarca, EtbInvModelo modIdModelo, String serConexion, EtbInvCentral cenIdCentral,
            EtbInvSalon salIdSalon, EtbInvCliente cliIdCliente, EtbInvRolServidor rolIdRolServ, EtbInvPlataforma plaIdPlataforma, String serForAdCompartida, int serAdministrado,
            int serCores, String serTIngreso, String serUnidad, String serProyecto, String serRack, Integer serNoProcFisico, EtbInvEstado estIdEstado, EtbInvSisOperativo sisIdSisOperativo,
            EtbInvGrupo gruIdGrupo, Integer servMem, Integer servDiscoC) {
        // creamos un matris definiendo la tabla en la que vamos a ingresar los datos (EtbInvServidor servidor = new EtbInvServidor();)
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
        //tomamos la matris (servidor) y por medio de (em.persist) creamos el nuevo servidor 
        em.persist(servidor);
        // es igual en todos los public en los que usamos (em.persist) que hace parte  del (EntityManager)
    }

    /**
     * en creact creamos un nueva actividad
     *
     * @param Fecha
     * @param serv1
     * @param actEjecuta
     * @param actTarea
     * @param actDescripcion
     * @param actSolicita
     * @param actTipo
     * @param actFechaFin
     * @param actFechaIni
     */
    //INSERTAR ACTIVIDAD
    @Transactional(rollbackFor = {ServicioException.class})
    public void creact(String Fecha, EtbInvServidor serv1, String actEjecuta, String actTarea, String actDescripcion, String actSolicita, EtbInvTipoActividad actTipo, String actFechaFin, String actFechaIni) {
        EtbInvActividad actividad = new EtbInvActividad();
        actividad.setActDescripcion(actDescripcion);
        actividad.setActEjecuta(actEjecuta);
        actividad.setActFechaFin(actFechaFin);
        actividad.setActFechaIni(actFechaIni);
        actividad.setActServ(serv1);
        actividad.setActSolicita(actSolicita);
        actividad.setActTarea(actTarea);
        actividad.setActTipo(actTipo);
        actividad.setFCreacion(Fecha);
        em.persist(actividad);
    }

    /**
     * en crease creamos un nuevo aseguramiento
     *
     * @param Fecha
     * @param aseTarea
     * @param aseServidor
     * @param aseEjecuta
     * @param aseFecha
     * @param aseplantilla
     */
    //INSERTAR ASEGURAMIENTO
    @Transactional(rollbackFor = {ServicioException.class})
    public void crease(String Fecha, String aseTarea, EtbInvServidor aseServidor, String aseEjecuta, String aseFecha, int aseplantilla) {
        EtbInvAseguramiento aseguramiento = new EtbInvAseguramiento();
        aseguramiento.setAseEjecuta(aseEjecuta);
        aseguramiento.setAseFecha(aseFecha);
        aseguramiento.setAseServidor(aseServidor);
        aseguramiento.setAseTarea(aseTarea);
        aseguramiento.setFCreacion(Fecha);
        aseguramiento.setAsePlantilla(aseplantilla);
        em.persist(aseguramiento);
    }

    /**
     * //modificar ASEGURAMIENTO en modiase modificamos un aseguramiento
     *
     * @param idasegu
     * @param fCreacion
     * @param aseTarea
     * @param aseServidor
     * @param aseEjecuta
     * @param fini
     * @param aseplantilla
     */
    @Transactional(rollbackFor = {ServicioException.class})
    public void modiase(int idasegu, String fCreacion, String aseTarea, EtbInvServidor aseServidor, String aseEjecuta, String fini, int aseplantilla) {
        // creamos un matris definiendo la tabla en la que vamos a editar los datos (EtbInvAseguramiento aseguramiento = new EtbInvAseguramiento();)
        EtbInvAseguramiento aseguramiento = new EtbInvAseguramiento();
        aseguramiento.setAseId(idasegu);
        aseguramiento.setAseEjecuta(aseEjecuta);
        aseguramiento.setAseFecha(fini);
        aseguramiento.setAseServidor(aseServidor);
        aseguramiento.setAseTarea(aseTarea);
        aseguramiento.setFCreacion(fCreacion);
        aseguramiento.setAsePlantilla(aseplantilla);
        //para poder usar (em.merge) debemos llenar todos los datos de la tabla  paara que la editada se haga bien d otra forma van a quedar en blanco
        em.merge(aseguramiento);
        // es igual en todos los public en los que usamos (em.merge) que hace parte  del (EntityManager)
    }

    /**
     * en creacont creamos un nuevo contrato
     *
     * @param Fecha
     * @param contProv
     * @param contTipo
     * @param contFechaIni
     * @param contFechaFin
     * @param contNum
     * @param contEstado
     * @param contLogin
     * @param contDescrip
     */
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

    /**
     * en creacrono creamos un nuevo cronograma
     *
     * @param Fecha
     * @param croProyecto
     * @param croFechaIni
     * @param croSerial
     * @param croEjecuta
     * @param croCambioFin
     * @param croEstado
     * @param fprox
     * @param ffin
     * @param observacion
     */
    //INSERTAR CRONOGRAMA
    @Transactional(rollbackFor = {ServicioException.class})
    public void creacrono(String Fecha, EtbInvProyecto croProyecto, String croFechaIni, EtbInvServidor croSerial, String croEjecuta, String croCambioFin, EtbInvEstadoMto croEstado, String fprox, String ffin, String observacion) {
        EtbInvCronogramaMto cronograma = new EtbInvCronogramaMto();
        cronograma.setCroCambioFin(croCambioFin);
        cronograma.setCroEjecuta(croEjecuta);
        cronograma.setCroEstado(croEstado);
        cronograma.setCroFechaIni(croFechaIni);
        cronograma.setCroProyecto(croProyecto);
        cronograma.setCroSerial(croSerial);
        cronograma.setFCreacion(Fecha);
        cronograma.setCroFechaFin(ffin);
        cronograma.setCroFechaProx(fprox);
        cronograma.setCroObservacion(observacion);
        em.persist(cronograma);
    }

    /**
     * en creaproveedor creamos un nuevo caso de proveedor
     *
     * @param caspserv
     * @param Fecha
     * @param caspProv
     * @param caspFechaApe
     * @param caspFechaCie
     * @param caspNumero
     * @param caspIm
     * @param caspEstado
     */
    //INSERTAR CASOSPROVEEDOR
    @Transactional(rollbackFor = {ServicioException.class})
    public void creaproveedor(EtbInvServidor caspserv, String Fecha, EtbInvMarca caspProv, String caspFechaApe, String caspFechaCie, String caspNumero, String caspIm, EtbInvEstadoCasos caspEstado) {
        EtbInvCasosProv casosprove = new EtbInvCasosProv();
        casosprove.setCaspEstado(caspEstado);
        casosprove.setCaspFechaApe(caspFechaApe);
        casosprove.setCaspFechaCie(caspFechaCie);
        casosprove.setCaspIm(caspIm);
        casosprove.setCaspNumero(caspNumero);
        casosprove.setCaspProv(caspProv);
        casosprove.setFCreacion(Fecha);
        casosprove.setCaspServ(caspserv);
        em.persist(casosprove);
    }

    /**
     * en crearususerv creamos un nuevo usuario de servidor
     *
     * @param Fecha
     * @param ususLogin
     * @param ususNombre
     * @param ususEstadoa
     * @param ususidServ
     * @param administrado
     */
    //INSERTAR USUARIO SERVIDOR
    @Transactional(rollbackFor = {ServicioException.class})
    public void crearususerv(String Fecha, String ususLogin, String ususNombre, EtbInvUsuEstado ususEstadoa, EtbInvServidor ususidServ, int administrado) {
        EtbInvUsuServ usuarioserv = new EtbInvUsuServ();
        usuarioserv.setUsusAdm(administrado);
        usuarioserv.setFCreacion(Fecha);
        usuarioserv.setIdSerServidor(ususidServ);
        usuarioserv.setUsusEstado(ususEstadoa);
        usuarioserv.setUsusLogin(ususLogin);
        usuarioserv.setUsusNombre(ususNombre);
        em.persist(usuarioserv);
    }

    /**
     * en llenarbitacora creamos una nueva bitacora
     *
     * @param tabladominios
     * @param idservidor
     * @param usuarioetb
     * @param FechaH
     * @param cam_tab_SM
     * @param cam_tab_descripcion_SM
     * @param cam_tab_solicitante_SM
     */
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

    /**
     * en llenarbitacoradetalle creamos un nuevo detalle de bitacora
     *
     * @param CamColumna
     * @param CamNawValor
     * @param CamValorIni
     * @param CamIdtabla
     */
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

    /**
     * un ACCPROI registramos un acceso prohibido
     *
     * @param Fecha
     * @param usuetb
     * @param ip
     * @param url
     * @param acc
     */
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

    /**
     * en crearcambioususerv registramo los cambios realisado al usuario de un
     * servidor
     *
     * @param Fecha
     * @param ususLogin
     * @param tCambio
     * @param ususEstado
     */
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

    /**
     * en crearusuarioapp creamos un nuevo usuario para la apricacion
     *
     * @param per
     * @param nombre_recibido
     * @param apellido_recibido
     * @param Correo_recibido
     * @param estado
     * @param dom
     * @param Codigo_Etb_Recibido
     * @param usuario_recibido
     * @param telefono_recibido
     * @param Empresa_recibido
     * @param Cargo_recibido
     * @param Direccion_Recibido
     * @param Cedula_Recibido
     * @param telefono_ofici_recibido
     */
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

    /**
     * en update editamos usuario de servidor
     *
     * @param Fechas
     * @param email
     * @param ususEstado
     * @param ususLogin
     * @param nombre
     * @param admin
     * @param ususidServ
     * @return
     */
    //actualizar usuario servidor
    @Transactional(rollbackFor = {ServicioException.class})
    public EtbInvUsuServ update(String Fechas, Integer email, EtbInvUsuEstado ususEstado, String ususLogin, String nombre, Integer admin, EtbInvServidor ususidServ) {
        EtbInvUsuServ ususer = new EtbInvUsuServ();
        ususer.setUsusId(email);
        ususer.setFCreacion(Fechas);
        ususer.setUsusAdm(admin);
        ususer.setUsusEstado(ususEstado);
        ususer.setIdSerServidor(ususidServ);
        ususer.setUsusLogin(ususLogin);
        ususer.setUsusNombre(nombre);
        return em.merge(ususer);

    }

    /**
     * en updateservidor editamos un servidor
     *
     * @param idservidor
     * @param serialservidor
     * @param hostnameservidor
     * @param conexionservidor
     * @param marIdMarca
     * @param modIdModelo
     * @param rackservidor
     * @param cenIdCentral
     * @param salIdSalon
     * @param cliIdCliente
     * @param rolIdRolServ
     * @param plaIdPlataforma
     * @param unidadservidor
     * @param proyectoservidor
     * @param fechaingservidor
     * @param tareaingresoservidor
     * @param Nprocesosservidor
     * @param TareaAdCompartida
     * @param adcompservidor
     * @param admiservidor
     * @param estIdEstado
     * @param sisIdSisOperativo
     * @param gruIdGrupo
     * @param coresservidor
     * @param memservidor
     * @param discocservidor
     * @return
     */
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

    /**
     * en direccionamiento creamos un nuevo direcionamiento
     *
     * @param Fecha
     * @param dirIp
     * @param dirVlan
     * @param dirSwitch
     * @param dirPuerto
     * @param idSer
     * @param dirTipo
     */
    //insertar direccionamiento
    @Transactional(rollbackFor = {ServicioException.class})
    public void direccionamiento(String Fecha, String dirIp, String dirVlan, String dirSwitch, String dirPuerto, EtbInvServidor idSer, EtbInvTip dirTipo) {
        EtbInvDireccionamiento direccionamiento = new EtbInvDireccionamiento();
        direccionamiento.setDirIp(dirIp);
        direccionamiento.setDirPuerto(dirPuerto);
        direccionamiento.setDirSwitch(dirSwitch);
        direccionamiento.setDirTipo(dirTipo);
        direccionamiento.setDirVlan(dirVlan);
        direccionamiento.setIdSer(idSer);
        direccionamiento.setFcreacion(Fecha);
        em.persist(direccionamiento);
    }

    /**
     * en direccionamientoedite editamos el direccionamiento
     *
     * @param Fecha
     * @param iddirIp
     * @param dirIp
     * @param dirVlan
     * @param dirSwitch
     * @param dirPuerto
     * @param idSer
     * @param dirTipo
     */
    //insertar direccionamiento
    @Transactional(rollbackFor = {ServicioException.class})
    public void direccionamientoedite(String Fecha, int iddirIp, String dirIp, String dirVlan, String dirSwitch, String dirPuerto, EtbInvServidor idSer, EtbInvTip dirTipo) {
        EtbInvDireccionamiento direccionamiento = new EtbInvDireccionamiento();
        direccionamiento.setDirIp(dirIp);
        direccionamiento.setDirPuerto(dirPuerto);
        direccionamiento.setDirSwitch(dirSwitch);
        direccionamiento.setDirTipo(dirTipo);
        direccionamiento.setDirVlan(dirVlan);
        direccionamiento.setIdSer(idSer);
        direccionamiento.setDirId(iddirIp);
        direccionamiento.setFcreacion(Fecha);
        em.merge(direccionamiento);
    }

    /**
     * en agragarrutas agregamos una nueva ruta
     *
     * @param FechaH
     * @param rutaser
     * @param idSer
     */
//insertar rutas
    @Transactional(rollbackFor = {ServicioException.class})
    public void agragarrutas(String FechaH, String rutaser, EtbInvServidor idSer) {
        EtbInvRuta rutas = new EtbInvRuta();
        rutas.setRutFecha(FechaH);
        rutas.setRutRuta(rutaser);
        rutas.setRutSerial(idSer);
        em.persist(rutas);
    }

    /**
     * en editarrutas editamos las rutas
     *
     * @param idrutas
     * @param FechaH
     * @param rutaser
     * @param idSer
     */
    //modificar rutas
    @Transactional(rollbackFor = {ServicioException.class})
    public void editarrutas(int idrutas, String FechaH, String rutaser, EtbInvServidor idSer) {
        EtbInvRuta rutas = new EtbInvRuta();
        rutas.setRutId(idrutas);
        rutas.setRutFecha(FechaH);
        rutas.setRutRuta(rutaser);
        rutas.setRutSerial(idSer);
        em.merge(rutas);
    }

    /**
     * en modificarcasproveedor editamos los casos de proovedor
     *
     * @param proveedor1
     * @param idcasos
     * @param fini
     * @param fcie
     * @param estini1
     * @param numcas
     * @param im
     * @param fCreacion
     * @param servi
     */
    //modificar casos proveedor
    @Transactional(rollbackFor = {ServicioException.class})
    public void modificarcasproveedor(EtbInvMarca proveedor1, int idcasos, String fini, String fcie, EtbInvEstadoCasos estini1, String numcas, String im, String fCreacion, EtbInvServidor servi) {
        EtbInvCasosProv casosprove = new EtbInvCasosProv();
        casosprove.setCaspId(idcasos);
        casosprove.setCaspEstado(estini1);
        casosprove.setCaspFechaApe(fini);
        casosprove.setCaspFechaCie(fcie);
        casosprove.setCaspIm(im);
        casosprove.setCaspNumero(numcas);
        casosprove.setCaspProv(proveedor1);
        casosprove.setFCreacion(fCreacion);
        casosprove.setCaspServ(servi);
        em.merge(casosprove);
    }

    /**
     * en modificaractiv modificamos la actividad
     *
     * @param actId
     * @param Fecha
     * @param serv1
     * @param actEjecuta
     * @param actTarea
     * @param actDescripcion
     * @param actSolicita
     * @param actTipo
     * @param actFechaFin
     * @param actFechaIni
     */
    //modificar ACTIVIDAD
    @Transactional(rollbackFor = {ServicioException.class})
    public void modificaractiv(Integer actId, String Fecha, EtbInvServidor serv1, String actEjecuta, String actTarea, String actDescripcion, String actSolicita, EtbInvTipoActividad actTipo, String actFechaFin, String actFechaIni) {
        EtbInvActividad actividad = new EtbInvActividad();
        actividad.setActId(actId);
        actividad.setActDescripcion(actDescripcion);
        actividad.setActEjecuta(actEjecuta);
        actividad.setActFechaFin(actFechaFin);
        actividad.setActFechaIni(actFechaIni);
        actividad.setActServ(serv1);
        actividad.setActSolicita(actSolicita);
        actividad.setActTarea(actTarea);
        actividad.setActTipo(actTipo);
        actividad.setFCreacion(Fecha);
        em.merge(actividad);
    }

    /**
     * en modificarcrono modificamos los cronogramas
     *
     * @param idcro
     * @param Fecha
     * @param croProyecto
     * @param croFechaIni
     * @param croSerial
     * @param croEjecuta
     * @param croCambioFin
     * @param croEstado
     * @param fprox
     * @param ffin
     * @param observacion
     */
    //modificar CRONOGRAMA
    @Transactional(rollbackFor = {ServicioException.class})
    public void modificarcrono(int idcro, String Fecha, EtbInvProyecto croProyecto, String croFechaIni, EtbInvServidor croSerial, String croEjecuta, String croCambioFin, EtbInvEstadoMto croEstado, String fprox, String ffin, String observacion) {
        EtbInvCronogramaMto cronograma = new EtbInvCronogramaMto();
        cronograma.setCroId(idcro);
        cronograma.setCroCambioFin(croCambioFin);
        cronograma.setCroEjecuta(croEjecuta);
        cronograma.setCroEstado(croEstado);
        cronograma.setCroFechaIni(croFechaIni);
        cronograma.setCroProyecto(croProyecto);
        cronograma.setCroSerial(croSerial);
        cronograma.setFCreacion(Fecha);
        cronograma.setCroFechaFin(ffin);
        cronograma.setCroFechaProx(fprox);
        cronograma.setCroObservacion(observacion);
        em.merge(cronograma);
    }

    /**
     * en modicont modificamos los contratos
     *
     * @param idcont
     * @param Fecha
     * @param contProv
     * @param contTipo
     * @param contFechaIni
     * @param contFechaFin
     * @param contNum
     * @param contEstado
     * @param contLogin
     * @param contDescrip
     */
    //modificar contrato
    @Transactional(rollbackFor = {ServicioException.class})
    public void modicont(int idcont, String Fecha, EtbInvMarca contProv, EtbInvTipoCont contTipo, String contFechaIni, String contFechaFin, String contNum, EtbInvEstadoCont contEstado, String contLogin, String contDescrip) {
        EtbInvContrato contrato = new EtbInvContrato();
        contrato.setContId(idcont);
        contrato.setContDescrip(contDescrip);
        contrato.setContEstado(contEstado);
        contrato.setContFechaFin(contFechaFin);
        contrato.setContFechaIni(contFechaIni);
        contrato.setContLogin(contLogin);
        contrato.setContNum(contNum);
        contrato.setContProv(contProv);
        contrato.setContTipo(contTipo);
        contrato.setFCreacion(Fecha);
        em.merge(contrato);
    }

    /**
     * en newcentral creamos una central
     *
     * @param Central
     */
    //insertar central
    @Transactional(rollbackFor = {ServicioException.class})
    public void newcentral(String Central) {
        EtbInvCentral central = new EtbInvCentral();
        central.setCenNombre(Central);
        em.persist(central);
    }

    /**
     * en newgrupo ingresamos un nuevo grupo
     *
     * @param Ngrupo
     * @param Tgrupo
     */
    //insertar grupo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newgrupo(String Ngrupo, String Tgrupo) {
        EtbInvGrupo grupo = new EtbInvGrupo();
        grupo.setGruNomGrupo(Ngrupo);
        grupo.setGruTipoGrupo(Tgrupo);
        em.persist(grupo);
    }

    /**
     * en newmarca ingresamos una nueva marca
     *
     * @param nmarca
     * @param usoporte
     * @param tsoporte
     * @param minterventor
     */
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

    /**
     * en newplataforma ingresamos una nueva plataforma
     *
     * @param nplataforma
     * @param aplataforma
     */
    //insertar plataforma
    @Transactional(rollbackFor = {ServicioException.class})
    public void newplataforma(String nplataforma, EtbInvAdmPlataforma aplataforma) {
        EtbInvPlataforma plataforma = new EtbInvPlataforma();
        plataforma.setPlaAdmPlataforma(aplataforma);
        plataforma.setPlaNomPlataforma(nplataforma);
        em.persist(plataforma);
    }

    /**
     * en newrol ingresamos un nuevo rol
     *
     * @param nrol
     */
    //insertar rol
    @Transactional(rollbackFor = {ServicioException.class})
    public void newrol(String nrol) {
        EtbInvRolServidor rolser = new EtbInvRolServidor();
        rolser.setRolNomRolServ(nrol);
        em.persist(rolser);
    }

    /**
     * en newsisoperativo ingresamos un nuevo sistema opreativo
     *
     * @param sisdis
     * @param nsis
     */
    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newsisoperativo(int sisdis, String nsis) {
        EtbInvSisOperativo sisope = new EtbInvSisOperativo();
        sisope.setSisDistribucion(sisdis);
        sisope.setSisNombre(nsis);
        em.persist(sisope);
    }

    /**
     * en newestado ingresamos un nuevo estado
     *
     * @param nest
     */
    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newestado(String nest) {
        EtbInvEstado estado = new EtbInvEstado();
        estado.setEstEstado(nest);
        em.persist(estado);
    }

    /**
     * en newsalon ingresamos un nuevo salon
     *
     * @param scen
     * @param nsal
     */
    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newsalon(EtbInvCentral scen, String nsal) {
        EtbInvSalon salon = new EtbInvSalon();
        salon.setSalCentral(scen);
        salon.setSalNombre(nsal);
        em.persist(salon);
    }

    /**
     * en newmodelo ingresamos un nuevo modelo
     *
     * @param nmar
     * @param nmod
     */
    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newmodelo(EtbInvMarca nmar, String nmod) {
        EtbInvModelo modelo = new EtbInvModelo();
        modelo.setMarIdMarca(nmar);
        modelo.setModNomModelo(nmod);
        em.persist(modelo);
    }

    /**
     * en newcliente ingresamos un uevo cliente
     *
     * @param ncli
     * @param ccli
     */
    //insertar sisoperativo
    @Transactional(rollbackFor = {ServicioException.class})
    public void newcliente(String ncli, String ccli) {
        EtbInvCliente cliente = new EtbInvCliente();
        cliente.setCliContacto(ccli);
        cliente.setCliNombre(ncli);
        em.persist(cliente);
    }

    /**
     * en newadminispla ingresamos un nuevo administrador de plataforma
     *
     * @param area
     * @param correo
     * @param nombre
     * @param telefono
     */
    //insertar administrador plataforma
    @Transactional(rollbackFor = {ServicioException.class})
    public void newadminispla(String area, String correo, String nombre, String telefono) {
        EtbInvAdmPlataforma admi = new EtbInvAdmPlataforma();
        admi.setAdmArea(area);
        admi.setAdmCorreo(correo);
        admi.setAdmNombre(nombre);
        admi.setAdmTelefono(telefono);
        em.persist(admi);
    }

}
