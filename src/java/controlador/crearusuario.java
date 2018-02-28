/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Calendar;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvServidor;
import tablas.EtbInvUsuEstado;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import tablas.EtbInvCambioTabla;
import tablas.EtbInvCamusuServ;
import tablas.EtbInvTablaDominios;
import tablas.EtbInvUsuServ;
import tablas.EtbInvUsuarioAp;

/**
 *
 * @author diegfraa
 */
@Controller

public class crearusuario {

    @Autowired
    private iniciosecion dao;
    @Autowired
    private HttpServletRequest request;
    Calendar fechaActual = Calendar.getInstance();
    String Fecha = String.format("%04d-%02d-%02d",
            fechaActual.get(Calendar.YEAR),
            fechaActual.get(Calendar.MONTH) + 1,
            fechaActual.get(Calendar.DAY_OF_MONTH));
 Calendar fechaActualH = Calendar.getInstance();
    String FechaH = String.format("%04d-%02d-%02d %02d:%02d:%02d",
            fechaActualH.get(Calendar.YEAR),
            fechaActualH.get(Calendar.MONTH) + 1,
            fechaActualH.get(Calendar.DAY_OF_MONTH),
            fechaActualH.get(Calendar.HOUR),
            fechaActualH.get(Calendar.MINUTE),
            fechaActualH.get(Calendar.SECOND));
  /**
   * 
   * @param ususLogin
   * @param ususNombre
   * @param tCambio
   * @param ususidSer
   * @param administrado
   * @param model
   * @return 
   */
    @RequestMapping("usuario.htm")
    public String create(@RequestParam("login") String ususLogin,
            @RequestParam("nombre") String ususNombre,
            @RequestParam("tarea") String tCambio,
            @RequestParam("servid") int ususidSer,
            @RequestParam("administrado") int administrado, Model model) {

        int m = 0;
        model.addAttribute("m", m);
        EtbInvServidor aa = dao.readid(ususidSer);
        EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(1);
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        EtbInvServidor ususidServ = new EtbInvServidor(ususidSer);
        dao.crearususerv(Fecha, ususLogin, ususNombre, ususEstadoa, ususidServ, administrado);
        dao.crearcambioususerv(Fecha, ususLogin, tCambio, ususEstado);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        model.addAttribute("Listaususerv", Listaususerv);
        return "user/usuarioservidor";
    }
    /**
     * 
     * @param model
     * @return 
     */
    //USUARIOS SERVIDOR

    @RequestMapping("usuarioservidor.htm")
    public String usu(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 0;
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        model.addAttribute("Listaususerv", Listaususerv);
        model.addAttribute("m", m);
        return "user/usuarioservidor";
    }
/**
 * 
 * @param email
 * @param usu
 * @param model
 * @return 
 */
    @RequestMapping("detalle.htm")
    public String detalle(@RequestParam("id") Integer email, @RequestParam("usu") String usu, Model model) {

        List<EtbInvCamusuServ> ListaDetalle = dao.ListaDetalle(usu);
        EtbInvUsuServ a = dao.buscarususerv(email);
        int m = 2;
        model.addAttribute("usuario", a);
       
        model.addAttribute("m", m);
        model.addAttribute("ListaDetalle", ListaDetalle);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        return "user/usuarioservidor";
    }
/**
 * 
 * @param email
 * @param model
 * @return 
 */
    @RequestMapping("usuarios.htm")
    public String usuarios(@RequestParam("id") Integer email, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvUsuServ a = dao.buscarususerv(email);
        List<EtbInvUsuEstado> Listausuest = dao.Listausuest();
         List<EtbInvServidor> Listaserver = dao.Listaserver();
        int m = 5;
        model.addAttribute("Listaserver", Listaserver);
        model.addAttribute("email", email);
        model.addAttribute("Listausuest", Listausuest);
        model.addAttribute("getUsuCorreo", a.getUsusLogin());
        model.addAttribute("m", m);
        model.addAttribute("usuer", a);
        return "user/usuarioservidor";
    }
/**
 * 
 * @param email
 * @param tCambio
 * @param ususEstad
 * @param model
 * @return 
 */
    @RequestMapping("modificar.htm")
    public String usuarios3(@RequestParam("id") Integer email,
            @RequestParam("tarea") String tCambio,
            @RequestParam("serv") Integer ususEstad, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(ususEstad);
        EtbInvUsuServ a = dao.buscarususerv(email);
        String ususLogin = a.getUsusLogin();
        String nombre = a.getUsusNombre();
        Integer admin = a.getUsusAdm();
        EtbInvServidor ususidServ = a.getIdSerServidor();
        String Fechas = a.getFCreacion();
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
       
        model.addAttribute("Listaususerv", Listaususerv);
        
        
        dao.update(Fechas, email, ususEstado, ususLogin, nombre, admin, ususidServ);
        dao.crearcambioususerv(Fecha, ususLogin, tCambio, ususEstado);
        int m = 0;
        model.addAttribute("m", m);
        return "user/usuarioservidor";
    }
/**
 * 
 * @param model
 * @return 
 */
    @RequestMapping("usuarioos.htm")
    public String usuarios2(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        
        int m = 1;
        model.addAttribute("Listaserver", Listaserver);
        model.addAttribute("m", m);
        model.addAttribute("Listaususerv", Listaususerv);
        return "user/usuarioservidor";
    }
    /**
     * 
     * @param model
     * @return 
     */
     @RequestMapping("usuariosmas.htm")
    public String usuariosmas(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        
        int m = 6;
        model.addAttribute("Listaserver", Listaserver);
        model.addAttribute("m", m);
        model.addAttribute("Listaususerv", Listaususerv);
        return "user/usuarioservidor";
    }
    /**
     * 
     * @param ususLogin
     * @param nombre
     * @param tareacambio
     * @param estado
     * @param admin
     * @param email
     * @param servid1
     * @param model
     * @return 
     */
    @RequestMapping("modiusuario1.htm")
    public String modiusuario(@RequestParam("login") String ususLogin,
            @RequestParam("nombre") String nombre,
            @RequestParam("tareacambio") String tareacambio,
            @RequestParam("estado") int estado,
            @RequestParam("administrado") int admin,
            @RequestParam("servid") int email,
            @RequestParam("servid1") int servid1,Model model) {

        int m = 0;
      
        EtbInvUsuServ a = dao.buscarususerv(email);
        EtbInvTablaDominios tabladominios = new EtbInvTablaDominios(39);

        String cam_tab_descripcion_SM = "1";
        String cam_tab_solicitante_SM = "1";
        int usuarioetb1 = (int) request.getSession().getAttribute("idusuap");
        EtbInvUsuarioAp usuarioetb = new EtbInvUsuarioAp(usuarioetb1);
        dao.llenarbitacora(tabladominios, email, usuarioetb, FechaH, tareacambio, cam_tab_descripcion_SM, cam_tab_solicitante_SM);

        EtbInvCambioTabla camt = dao.idcambiotabla(tabladominios, email, usuarioetb, tareacambio);
        //    int cambbit = camt.getCamtabID();
        EtbInvCambioTabla CamIdtabla = new EtbInvCambioTabla(camt.getCamtabID());
if (!a.getIdSerServidor().getSerServer().equals(servid1)) {
            String CamColumna = "USUS_LOGIN";
            String CamNawValor = "" + servid1;
            String CamValorIni = "" + a.getIdSerServidor().getSerServer();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!a.getUsusLogin().equals(ususLogin)) {
            String CamColumna = "USUS_LOGIN";
            String CamNawValor = "" + ususLogin;
            String CamValorIni = "" + a.getUsusLogin();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!a.getUsusNombre().equals(nombre)) {
            String CamColumna = "USUS_LOGIN";
            String CamNawValor = "" + nombre;
            String CamValorIni = "" + a.getUsusNombre();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!a.getUsusEstado().getUsusEstado().equals(estado)) {
            String CamColumna = "USUS_LOGIN";
            String CamNawValor = "" + estado;
            String CamValorIni = "" + a.getUsusEstado().getUsusEstado();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!a.getUsusAdm().equals(admin)) {
            String CamColumna = "USUS_LOGIN";
            String CamNawValor = "" + admin;
            String CamValorIni = "" + a.getUsusAdm();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(estado);

        EtbInvServidor ususidServ = new EtbInvServidor(servid1);
        dao.update(a.getFCreacion(), email, ususEstado, ususLogin, nombre, admin, ususidServ);
        dao.crearcambioususerv(Fecha, ususLogin, tareacambio, ususEstado);
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        model.addAttribute("Listaususerv", Listaususerv);
     
        model.addAttribute("m", m);
        return "user/usuarioservidor";
    }
}
