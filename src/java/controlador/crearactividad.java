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
import tablas.EtbInvServidor;
import tablas.EtbInvTipoActividad;

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
    //@RequestMapping(method = RequestMethod.GET)
//    public String mostrarAlumno() {
//        return "index";
//    }
    //ACTIVIDADES

    @RequestMapping("actividades.htm")
    public ModelAndView news(Model model) {

        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/actividades");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvActividad> ListaActividad = dao.ListaActividad();
        model.addAttribute("listaActividad", ListaActividad);
        return maw;
    }

    @RequestMapping("newactiv.htm")
    public ModelAndView newactiv(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/actividades");
        List<EtbInvTipoActividad> Listatipoactiv = dao.Listatipoactiv();
        model.addAttribute("Listatipoactiv", Listatipoactiv);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("listaServer", Listaserver);
        int m = 1;
        model.addAttribute("m", m);
        return maw;
    }

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
        dao.creact(Fecha, aa.getSerHostname(),serv1, actEjecuta, actTarea, actDescripcion, actSolicita, actTipo, actFechaFin, actFechaIni);
        List<EtbInvActividad> ListaActividad = dao.ListaActividad();
        model.addAttribute("listaActividad", ListaActividad);
        return "user/actividades";

    }
}
