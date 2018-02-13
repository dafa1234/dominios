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
import tablas.EtbInvCasosProv;
import tablas.EtbInvEstadoCasos;
import tablas.EtbInvMarca;
import tablas.EtbInvServidor;

/**
 *
 * @author diegfraa
 */
@Controller

public class crearcasosproveedor {

    @Autowired
    private iniciosecion dao;
    @Autowired
    private HttpServletRequest request;
//    @RequestMapping(method = RequestMethod.GET)
//    public String mostrarAlumno() {
//        return "index";
//    }

//    @RequestMapping(method = RequestMethod.POST)
    @RequestMapping("/caprov.htm")
    public String create(
            @RequestParam("proveedor") Integer caspPro,
            @RequestParam("servidor") String caspServ,
            @RequestParam("servidor") int caspServ1,
            @RequestParam("fini") String caspFechaApe,
            @RequestParam("fcie") String caspFechaCie,
            @RequestParam("estini") Integer caspEstad,
            @RequestParam("numcas") String caspNumero,
            @RequestParam("im") String caspIm,
            Model model) throws ServicioException {
        Calendar fechaActual = Calendar.getInstance();
        String Fecha = String.format("%04d-%02d-%02d",
                fechaActual.get(Calendar.YEAR),
                fechaActual.get(Calendar.MONTH) + 1,
                fechaActual.get(Calendar.DAY_OF_MONTH));
        int m = 2;
        model.addAttribute("m", m);

        //base de datos
        EtbInvServidor caspserv = new EtbInvServidor(caspServ1);
        EtbInvEstadoCasos caspEstado = new EtbInvEstadoCasos(caspEstad);
        EtbInvMarca caspProv = new EtbInvMarca(caspPro);
        dao.creaproveedor(caspserv,Fecha, caspProv, caspServ, caspFechaApe, caspFechaCie, caspNumero, caspIm, caspEstado);
        List<EtbInvCasosProv> Listaproveedor = dao.Listaproveedor();
        model.addAttribute("Listaproveedor", Listaproveedor);
        return "user/casosproveedor";

    }
    //CASOS PROVEEDOR

    @RequestMapping("casosproveedor.htm")
    public ModelAndView casosproveedor(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/casosproveedor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvCasosProv> Listaproveedor = dao.Listaproveedor();
        model.addAttribute("Listaproveedor", Listaproveedor);
        return maw;
    }

    @RequestMapping("newcasos.htm")
    public ModelAndView newcasos(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/casosproveedor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 1;
        List<EtbInvCasosProv> Listaproveedor = dao.Listaproveedor();
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("Listaproveedor", Listaproveedor);
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("listaServer", Listaserver);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return maw;
    }

}
