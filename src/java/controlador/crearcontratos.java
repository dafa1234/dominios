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
import tablas.EtbInvContrato;
import tablas.EtbInvEstadoCont;
import tablas.EtbInvMarca;
import tablas.EtbInvTipoCont;

/**
 *
 * @author diegfraa
 */
@Controller

public class crearcontratos {

    @Autowired
    private iniciosecion dao;
    @Autowired
    private HttpServletRequest request;
//    @RequestMapping(method = RequestMethod.GET)
//    public String mostrarAlumno() {
//        return "index";
//    }

//    @RequestMapping(method = RequestMethod.POST)
    @RequestMapping("/contr.htm")
    public String create(
            @RequestParam("proveedor") Integer contPro,
            @RequestParam("ticon") Integer contTip,
            @RequestParam("fini") String contFechaIni,
            @RequestParam("ffin") String contFechaFin,
            @RequestParam("nocon") String contNum,
            @RequestParam("estado") Integer contEstad,
            @RequestParam("login") String contLogin,
            @RequestParam("descripcion") String contDescrip,
            Model model) throws ServicioException {
        EtbInvMarca contProv = new EtbInvMarca(contPro);
        EtbInvTipoCont contTipo = new EtbInvTipoCont(contTip);
        EtbInvEstadoCont contEstado = new EtbInvEstadoCont(contEstad);
        Calendar fechaActual = Calendar.getInstance();
        String Fecha = String.format("%04d-%02d-%02d",
                fechaActual.get(Calendar.YEAR),
                fechaActual.get(Calendar.MONTH) + 1,
                fechaActual.get(Calendar.DAY_OF_MONTH));
        int m = 2;
        model.addAttribute("m", m);
        dao.creacont(Fecha, contProv, contTipo, contFechaIni, contFechaFin, contNum, contEstado, contLogin, contDescrip);
        List<EtbInvContrato> ListaContra = dao.ListaContra();
        model.addAttribute("listaContra", ListaContra);
        return "user/contratos";

    }
    //CONTRATOS

    @RequestMapping("contratos.htm")
    public String con(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvContrato> ListaContra = dao.ListaContra();
        model.addAttribute("listaContra", ListaContra);
        return "user/contratos";
    }

    @RequestMapping("newcont.htm")
    public String newcont(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 1;
        List<EtbInvEstadoCont> Listaestacont = dao.Listaestacont();
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvTipoCont> Listacont = dao.Listacont();
        model.addAttribute("ListaEstado", Listaestacont);
        model.addAttribute("listamarcas", ListaMarca);
        model.addAttribute("listacont", Listacont);
        model.addAttribute("m", m);
        return "user/contratos";
    }
}
