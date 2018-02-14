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
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvEstadoMto;
import tablas.EtbInvMarca;
import tablas.EtbInvProyecto;
import tablas.EtbInvServidor;
import tablas.EtbInvTipoCont;

/**
 *
 * @author diegfraa
 */
@Controller

public class crearcronograma {

    @Autowired
    private iniciosecion dao;
    @Autowired
    private HttpServletRequest request;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String mostrarAlumno() {
//        return "index";
//    }

//    @RequestMapping(method = RequestMethod.POST)
    @RequestMapping("/crono.htm")
    public String createcronograma(
            @RequestParam("proyecto") Integer croProyect,
            @RequestParam("servidor") String croSerial,
            @RequestParam("fini") String croFechaIni,
            @RequestParam("estini") Integer croEstad,
            @RequestParam("ejecuta") String croEjecuta,
            @RequestParam("cambio") String croCambioFin,
            Model model) throws ServicioException {
        Calendar fechaActual = Calendar.getInstance();
        String Fecha = String.format("%04d-%02d-%02d",
                fechaActual.get(Calendar.YEAR),
                fechaActual.get(Calendar.MONTH) + 1,
                fechaActual.get(Calendar.DAY_OF_MONTH));
        EtbInvProyecto croProyecto = new EtbInvProyecto(croProyect);
        EtbInvEstadoMto croEstado = new EtbInvEstadoMto(croEstad);
        dao.creacrono(Fecha, croProyecto, croFechaIni, croSerial, croEjecuta, croCambioFin, croEstado);
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvCronogramaMto> ListaCrono = dao.ListaCrono();
        model.addAttribute("listaCrono", ListaCrono);
        return "user/cronograma";

    }
    //CRONOGRAMA

    @RequestMapping("cronograma.htm")
    public String cro(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvCronogramaMto> ListaCrono = dao.ListaCrono();
        model.addAttribute("listaCrono", ListaCrono);
        return "user/cronograma";
    }

    @RequestMapping("newcrono.htm")
    public String newcrono(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 1;
        List<EtbInvProyecto> ListaProyecto = dao.ListaProyecto();
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        List<EtbInvEstadoMto> Listaestamto = dao.Listaestamto();
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvTipoCont> Listacont = dao.Listacont();
        model.addAttribute("ListaProyecto", ListaProyecto);
        model.addAttribute("listaFonos", Listaserver);
        model.addAttribute("listaEstado", Listaestamto);
        model.addAttribute("listamarcas", ListaMarca);
        model.addAttribute("listacont", Listacont);
        model.addAttribute("m", m);
        return "user/cronograma";
    }

    @RequestMapping("newaseg.htm")
    public String newaseg(Model model) {
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        model.addAttribute("listaServer", Listaserver);
        int m = 1;
        model.addAttribute("m", m);
        return "user/aseguramiento";
    }

}
