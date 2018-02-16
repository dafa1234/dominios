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
import tablas.EtbInvCambioTabla;
import tablas.EtbInvCasosProv;
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvEstadoMto;
import tablas.EtbInvMarca;
import tablas.EtbInvProyecto;
import tablas.EtbInvServidor;
import tablas.EtbInvTablaDominios;
import tablas.EtbInvTipoCont;
import tablas.EtbInvUsuarioAp;

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
     Calendar fechaActualH = Calendar.getInstance();
 String FechaH = String.format("%04d-%02d-%02d %02d:%02d:%02d",
            fechaActualH.get(Calendar.YEAR),
            fechaActualH.get(Calendar.MONTH) + 1,
            fechaActualH.get(Calendar.DAY_OF_MONTH),
            fechaActualH.get(Calendar.HOUR),
            fechaActualH.get(Calendar.MINUTE),
            fechaActualH.get(Calendar.SECOND));
    @RequestMapping("/crono.htm")
    public String createcronograma(
            @RequestParam("proyecto") Integer croProyect,
            @RequestParam("servidor") int croSerial,
            @RequestParam("fini") String croFechaIni,
            @RequestParam("estini") Integer croEstad,
            @RequestParam("ejecuta") String croEjecuta,
            @RequestParam("cambio") String croCambioFin,
            @RequestParam("fprox") String fprox,
            @RequestParam("ffin") String ffin,
            @RequestParam("observacion") String observacion,
            Model model) throws ServicioException {
        Calendar fechaActual = Calendar.getInstance();
        String Fecha = String.format("%04d-%02d-%02d",
                fechaActual.get(Calendar.YEAR),
                fechaActual.get(Calendar.MONTH) + 1,
                fechaActual.get(Calendar.DAY_OF_MONTH));
        EtbInvProyecto croProyecto = new EtbInvProyecto(croProyect);
        EtbInvEstadoMto croEstado = new EtbInvEstadoMto(croEstad);
        EtbInvServidor croSerial1 = new EtbInvServidor(croSerial);
        dao.creacrono(Fecha, croProyecto, croFechaIni, croSerial1, croEjecuta, croCambioFin, croEstado,fprox,ffin,observacion);
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
    
    
    ///modificar cronograma
        @RequestMapping("modcrono.htm")
    public String modificarcronograma(
            @RequestParam("proyecto") Integer croProyect,
            @RequestParam("servidor") int croSerial,
            @RequestParam("fini") String croFechaIni,
            @RequestParam("estini") Integer croEstad,
            @RequestParam("ejecuta") String croEjecuta,
            @RequestParam("cambio") String croCambioFin,
            @RequestParam("fprox") String fprox,
            @RequestParam("ffin") String ffin,
            @RequestParam("observacion") String observacion,
            @RequestParam("idcro") int idcro,
            @RequestParam("tareacambio") String tareacambio,
            Model model) throws ServicioException {
       
       
          EtbInvTablaDominios tabladominios = new EtbInvTablaDominios(8);
        EtbInvCronogramaMto cronograma = dao.cronograma(idcro);
        String cam_tab_descripcion_SM = "1";
        String cam_tab_solicitante_SM = "1";
        int usuarioetb1 = (int) request.getSession().getAttribute("idusuap");
        EtbInvUsuarioAp usuarioetb = new EtbInvUsuarioAp(usuarioetb1);
        dao.llenarbitacora(tabladominios, idcro, usuarioetb, FechaH, tareacambio, cam_tab_descripcion_SM, cam_tab_solicitante_SM);

        EtbInvCambioTabla camt = dao.idcambiotabla(tabladominios, idcro, usuarioetb, tareacambio);
        //    int cambbit = camt.getCamtabID();
        EtbInvCambioTabla CamIdtabla = new EtbInvCambioTabla(camt.getCamtabID());

        if (!cronograma.getCroProyecto().getProId().equals(croProyect)) {
            String CamColumna = "CRO_PROYECTO";
            String CamNawValor = "" + croProyect;
            String CamValorIni = "" + cronograma.getCroProyecto().getProId();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cronograma.getCroSerial().getSerServer().equals(croSerial)) {
            String CamColumna = "CRO_SERIAL";
            String CamNawValor = "" + croSerial;
            String CamValorIni = "" + cronograma.getCroSerial().getSerServer();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cronograma.getCroFechaIni().equals(croFechaIni)) {
            String CamColumna = "CRO_FECHA_INI";
            String CamNawValor = "" + croFechaIni;
            String CamValorIni = "" + cronograma.getCroFechaIni();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cronograma.getCroEstado().getEstmId().equals(croEstad)) {
            String CamColumna = "CRO_ESTADO";
            String CamNawValor = "" + croEstad;
            String CamValorIni = "" + cronograma.getCroEstado().getEstmId();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cronograma.getCroEjecuta().equals(croEjecuta)) {
            String CamColumna = "CRO_EJECUTA";
            String CamNawValor = "" + croEjecuta;
            String CamValorIni = "" + cronograma.getCroEjecuta();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cronograma.getCroCambioFin().equals(croCambioFin)) {
            String CamColumna = "CRO_CAMBIO_FIN";
            String CamNawValor = "" + croCambioFin;
            String CamValorIni = "" + cronograma.getCroCambioFin();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cronograma.getCroFechaProx().equals(fprox)) {
            String CamColumna = "CRO_FECHA_PROX";
            String CamNawValor = "" + fprox;
            String CamValorIni = "" + cronograma.getCroFechaProx();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cronograma.getCroFechaFin().equals(ffin)) {
            String CamColumna = "CRO_FECHA_FIN";
            String CamNawValor = "" + ffin;
            String CamValorIni = "" + cronograma.getCroFechaFin();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
                if (!cronograma.getCroObservacion().equals(observacion)) {
            String CamColumna = "CRO_OBSERVACION";
            String CamNawValor = "" + observacion;
            String CamValorIni = "" + cronograma.getCroObservacion();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        EtbInvProyecto croProyecto = new EtbInvProyecto(croProyect);
        EtbInvEstadoMto croEstado = new EtbInvEstadoMto(croEstad);
         EtbInvServidor croSerial1 = new EtbInvServidor(croSerial);
        dao.modificarcrono(idcro,cronograma.getFCreacion(), croProyecto, croFechaIni, croSerial1, croEjecuta, croCambioFin, croEstado,fprox,ffin,observacion);
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvCronogramaMto> ListaCrono = dao.ListaCrono();
        model.addAttribute("listaCrono", ListaCrono);
        return "user/cronograma";

    }
    //CRONOGRAMA

    @RequestMapping("cronogramamod.htm")
    public String cromod( @RequestParam("idcron") Integer idcron,Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 4;  List<EtbInvProyecto> ListaProyecto = dao.ListaProyecto();
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
        EtbInvCronogramaMto cronograma = dao.cronograma(idcron);
        model.addAttribute("crono", cronograma);
        return "user/cronograma";
    }

}
