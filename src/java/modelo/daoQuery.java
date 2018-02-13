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
import org.springframework.transaction.annotation.Transactional;
import tablas.EtbInvActividad;
import tablas.EtbInvCambioTabla;
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
import tablas.EtbInvServidor;
import tablas.EtbInvSisOperativo;
import tablas.EtbInvTablaDominios;
import tablas.EtbInvTip;
import tablas.EtbInvTipoActividad;
import tablas.EtbInvTipoCont;
import tablas.EtbInvUsuEstado;
import tablas.EtbInvUsuServ;
import tablas.EtbInvUsuarioAp;

/**
 *
 * @author diegfraa
 */
public class daoQuery {

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

    public List Lisreporte1(String F_Inicio, String F_Fin) {
        String sql = "select na from EtbInvServidor na where na.serFIngreso between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }

    public List Lisreporte2(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvUsuServ nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }

    public List Lisreporte3(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvCronogramaMto nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }

    public List Lisreporte4(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvContrato nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }

    public List Lisreporte5(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvAseguramiento nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }

    public List Lisreporte6(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvActividad nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
        return q.getResultList();
    }

    public List Lisreporte7(String F_Inicio, String F_Fin) {
        String sql = "select nn from EtbInvCasosProv nn where nn.fCreacion between :F_Inicio and :F_Fin";
        Query q = em.createQuery(sql);
        q.setParameter("F_Inicio", F_Inicio);
        q.setParameter("F_Fin", F_Fin);
        //q.setParameter("tabla", tabla);,String tabla
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
}
