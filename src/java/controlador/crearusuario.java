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
import org.springframework.web.servlet.ModelAndView;
import tablas.EtbInvCamusuServ;
import tablas.EtbInvUsuServ;

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
//    @RequestMapping(method = RequestMethod.GET)
//    public String mostrarAlumno() {
//        return "index";
//    }

//    @RequestMapping(method = RequestMethod.POST)
    @RequestMapping("/usuario.htm")
    public String create(@RequestParam("login") String ususLogin,
            @RequestParam("nombre") String ususNombre,
            @RequestParam("tarea") String tCambio,
            @RequestParam("servid") int ususidSer, 
            @RequestParam("administrado") int administrado,Model model) {

        int m = 0;
        model.addAttribute("m", m);
        EtbInvServidor aa = dao.readid(ususidSer);
        String ususServ = aa.getSerSerial();
        EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(1);
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        EtbInvServidor ususidServ = new EtbInvServidor(ususidSer);
        dao.crearususerv(Fecha, ususLogin, ususNombre, ususServ, ususEstadoa, ususidServ,administrado);
        dao.crearcambioususerv(Fecha, ususLogin, tCambio, ususEstado);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        model.addAttribute("Listaususerv", Listaususerv);
        return "user/usuarioservidor";
    }
    //USUARIOS SERVIDOR

    @RequestMapping("usuarioservidor.htm")
    public ModelAndView usu(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 0;
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        List<EtbInvUsuEstado> Listausuest = dao.Listausuest();
        model.addAttribute("Listaserver", Listaserver);
        model.addAttribute("Listaususerv", Listaususerv);
        model.addAttribute("Listausuest", Listausuest);
        model.addAttribute("m", m);
        return maw;
    }

    @RequestMapping("detalle.htm")
    public ModelAndView detalle(@RequestParam("id") Integer email, @RequestParam("usu") String usu, Model model) {

        List<EtbInvCamusuServ> ListaDetalle = dao.ListaDetalle(usu);
        EtbInvUsuServ a = dao.buscarususerv(email);
        int m = 2;
        model.addAttribute("ususLogin", a.getUsusLogin());
        model.addAttribute("ususNombre", a.getUsusNombre());
        model.addAttribute("ususServ", a.getUsusServ());
        model.addAttribute("ususAdm", a.getUsusAdm());
        model.addAttribute("ususEstado", a.getUsusEstado().getEstuEstado());
        model.addAttribute("m", m);
        model.addAttribute("ListaDetalle", ListaDetalle);
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        return maw;
    }

    @RequestMapping("usuarios.htm")
    public ModelAndView usuarios(@RequestParam("id") Integer email, Model model) {

        EtbInvUsuServ a = dao.buscarususerv(email);
        List<EtbInvUsuEstado> Listausuest = dao.Listausuest();
        int m = 4;
        model.addAttribute("email", email);
        model.addAttribute("Listausuest", Listausuest);
        model.addAttribute("getUsuApell", a.getUsusServ());
        model.addAttribute("getUsuCorreo", a.getUsusLogin());
        model.addAttribute("m", m);
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        return maw;
    }

    @RequestMapping("modificar.htm")
    public ModelAndView usuarios3(@RequestParam("id") Integer email,
            @RequestParam("tarea") String tCambio,
            @RequestParam("serv") Integer ususEstad, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(ususEstad);
        EtbInvUsuServ a = dao.buscarususerv(email);
        String ususLogin = a.getUsusLogin();
        String nombre = a.getUsusNombre();
        String servidor = a.getUsusServ();
        Integer admin = a.getUsusAdm();
        EtbInvServidor ususidServ = a.getIdSerServidor();
        String Fechas = a.getFCreacion();
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        model.addAttribute("Listaususerv", Listaususerv);
        dao.update(Fechas, email, ususEstado, ususLogin, nombre, servidor, admin, ususidServ);
        dao.crearcambioususerv(Fecha, ususLogin, tCambio, ususEstado);
        int m = 0;
        model.addAttribute("m", m);
        maw.setViewName("user/usuarioservidor");

        return maw;
    }

    @RequestMapping("usuarioos.htm")
    public ModelAndView usuarios2(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        int m = 1;
        model.addAttribute("Listaserver", Listaserver);
        model.addAttribute("m", m);
        model.addAttribute("Listaususerv", Listaususerv);
        maw.setViewName("user/usuarioservidor");
        return maw;
    }

}
