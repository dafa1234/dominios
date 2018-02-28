/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.ServicioException;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tablas.EtbInvActividad;
import tablas.EtbInvCambioTabla;
import tablas.EtbInvServidor;
import tablas.EtbInvTablaDominios;
import tablas.EtbInvTipoActividad;
import tablas.EtbInvUsuarioAp;

/**
 *
 * @author diegfraa
 */
@Controller

public class crearactividad {

    @Autowired
    private iniciosecion dao;
    @Autowired
    private HttpServletRequest request;
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
 * @param model
 * @return 
 */
    @RequestMapping("actividades.htm")
    public String news(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvActividad> ListaActividad = dao.ListaActividad();
        model.addAttribute("listaActividad", ListaActividad);
        return "user/actividades";
    }
/**
 * 
 * @param model
 * @return 
 */
    @RequestMapping("newactiv.htm")
    public String newactiv(Model model) {
        List<EtbInvTipoActividad> Listatipoactiv = dao.Listatipoactiv();
        model.addAttribute("Listatipoactiv", Listatipoactiv);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("listaServer", Listaserver);
        int m = 1;
        model.addAttribute("m", m);
        return "user/actividades";
    }
/**
 * 
 * @param actServ
 * @param actEjecuta
 * @param actTarea
 * @param actDescripcion
 * @param actSolicita
 * @param actTip
 * @param actFechaIni
 * @param actFechaFin
 * @param model
 * @return
 * @throws ServicioException 
 */
    //@RequestMapping(method = RequestMethod.POST)
    @RequestMapping("/act.htm")
    public String create(
            @RequestParam("serv") int actServ,
            @RequestParam("eje") String actEjecuta,
            @RequestParam("tarea") String actTarea,
            @RequestParam("desc") String actDescripcion,
            @RequestParam("sol") String actSolicita,
            @RequestParam("tipo") Integer actTip,
            @RequestParam("fini") String actFechaIni,
            @RequestParam("ffin") String actFechaFin,
            Model model) throws ServicioException {

        //base de datos
        EtbInvServidor aa = dao.readid(actServ);
        EtbInvTipoActividad actTipo = new EtbInvTipoActividad(actTip);
        EtbInvServidor serv1 = new EtbInvServidor(aa.getSerServer());
        Calendar fechaActual = Calendar.getInstance();
        String Fecha = String.format("%04d-%02d-%02d",
                fechaActual.get(Calendar.YEAR),
                fechaActual.get(Calendar.MONTH) + 1,
                fechaActual.get(Calendar.DAY_OF_MONTH));
        int m = 2;
        model.addAttribute("m", m);
        dao.creact(Fecha, serv1, actEjecuta, actTarea, actDescripcion, actSolicita, actTipo, actFechaFin, actFechaIni);
        List<EtbInvActividad> ListaActividad = dao.ListaActividad();
        model.addAttribute("listaActividad", ListaActividad);
        return "user/actividades";

    }
/**
 * 
 * @param idact
 * @param model
 * @return 
 */
    @RequestMapping("modacti.htm")
    public String modactivser(@RequestParam("idact") int idact, Model model) {
        List<EtbInvTipoActividad> Listatipoactiv = dao.Listatipoactiv();
        model.addAttribute("Listatipoactiv", Listatipoactiv);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("listaServer", Listaserver);
        EtbInvActividad aa = dao.activida(idact);
        int m = 10;
        model.addAttribute("m", m);
        model.addAttribute("acti", aa);
        return "user/actividades";
    }
/**
 * 
 * @param actServ
 * @param servdor
 * @param actEjecuta
 * @param actTarea
 * @param actDescripcion
 * @param actSolicita
 * @param actTip
 * @param actFechaIni
 * @param actFechaFin
 * @param tareacambio
 * @param model
 * @return
 * @throws ServicioException 
 */
    @RequestMapping("modactivi.htm")
    public String create(
            @RequestParam("serv") int actServ,
            @RequestParam("servdor") int servdor,
            @RequestParam("eje") String actEjecuta,
            @RequestParam("tarea") String actTarea,
            @RequestParam("desc") String actDescripcion,
            @RequestParam("sol") String actSolicita,
            @RequestParam("tipo") Integer actTip,
            @RequestParam("fini") String actFechaIni,
            @RequestParam("ffin") String actFechaFin,
            @RequestParam("tareacambio") String tareacambio,
            Model model) throws ServicioException {
        EtbInvTablaDominios tabladominios = new EtbInvTablaDominios(1);
        EtbInvActividad aa = dao.activida(actServ);
        String cam_tab_descripcion_SM = "1";
        String cam_tab_solicitante_SM = "1";
        int usuarioetb1 = (int) request.getSession().getAttribute("idusuap");
        EtbInvUsuarioAp usuarioetb = new EtbInvUsuarioAp(usuarioetb1);
        dao.llenarbitacora(tabladominios, actServ, usuarioetb, FechaH, tareacambio, cam_tab_descripcion_SM, cam_tab_solicitante_SM);

        EtbInvCambioTabla camt = dao.idcambiotabla(tabladominios, actServ, usuarioetb, tareacambio);
        //    int cambbit = camt.getCamtabID();
        EtbInvCambioTabla CamIdtabla = new EtbInvCambioTabla(camt.getCamtabID());
        if (!aa.getActServ().getSerServer().equals(servdor)) {
            String CamColumna = "ACT_SERV1";
            String CamNawValor = "" + servdor;
            String CamValorIni = "" + aa.getActServ().getSerServer();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActEjecuta().equals(actEjecuta)) {
            String CamColumna = "ACT_EJECUTA";
            String CamNawValor = "" + actEjecuta;
            String CamValorIni = "" + aa.getActEjecuta();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActTarea().equals(actTarea)) {
            String CamColumna = "ACT_TAREA";
            String CamNawValor = "" + actTarea;
            String CamValorIni = "" + aa.getActTarea();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActDescripcion().equals(actDescripcion)) {
            String CamColumna = "ACT_DESCRIPCION";
            String CamNawValor = "" + actDescripcion;
            String CamValorIni = "" + aa.getActDescripcion();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActSolicita().equals(actSolicita)) {
            String CamColumna = "ACT_SOLICITA";
            String CamNawValor = "" + actSolicita;
            String CamValorIni = "" + aa.getActEjecuta();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActTipo().getTipaId().equals(actTip)) {
            String CamColumna = "ACT_TIPO";
            String CamNawValor = "" + actTip;
            String CamValorIni = "" + aa.getActTipo().getTipaId();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActFechaIni().equals(actFechaIni)) {
            String CamColumna = "ACT_FECHA_INI";
            String CamNawValor = "" + actFechaIni;
            String CamValorIni = "" + aa.getActFechaIni();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActFechaFin().equals(actFechaFin)) {
            String CamColumna = "ACT_FECHA_FIN";
            String CamNawValor = "" + actFechaFin;
            String CamValorIni = "" + aa.getActFechaFin();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        //base de datos

        EtbInvTipoActividad actTipo = new EtbInvTipoActividad(actTip);
        EtbInvServidor serv1 = new EtbInvServidor(servdor);

        int m = 2;
        model.addAttribute("m", m);
        dao.modificaractiv(aa.getActId(), aa.getFCreacion(), serv1, actEjecuta, actTarea, actDescripcion, actSolicita, actTipo, actFechaFin, actFechaIni);
        List<EtbInvActividad> ListaActividad = dao.ListaActividad();
        model.addAttribute("listaActividad", ListaActividad);
        return "user/actividades";

    }
}
