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
import tablas.EtbInvContrato;
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvEstadoCont;
import tablas.EtbInvMarca;
import tablas.EtbInvTablaDominios;
import tablas.EtbInvTipoCont;
import tablas.EtbInvUsuarioAp;

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
 * @param contPro
 * @param contTip
 * @param contFechaIni
 * @param contFechaFin
 * @param contNum
 * @param contEstad
 * @param contLogin
 * @param contDescrip
 * @param model
 * @return
 * @throws ServicioException 
 */   
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
    /**
     * 
     * @param model
     * @return 
     */
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
/**
 * 
 * @param model
 * @return 
 */
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
    /**
     * 
     * @param idcont
     * @param model
     * @return 
     */
    ///modificar contrato
      @RequestMapping("modcont.htm")
    public String modcont( @RequestParam("idcont") Integer idcont,Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 4;
             EtbInvContrato contratos=dao.contratos(idcont);
        List<EtbInvEstadoCont> Listaestacont = dao.Listaestacont();
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvTipoCont> Listacont = dao.Listacont();
        model.addAttribute("ListaEstado", Listaestacont);
        model.addAttribute("listamarcas", ListaMarca);
        model.addAttribute("listacont", Listacont);
        model.addAttribute("cont", contratos);
        model.addAttribute("m", m);
        return "user/contratos";
    }
    /**
     * 
     * @param contPro
     * @param contTip
     * @param contFechaIni
     * @param contFechaFin
     * @param contNum
     * @param contEstad
     * @param contLogin
     * @param contDescrip
     * @param idcont
     * @param tareacambio
     * @param model
     * @return
     * @throws ServicioException 
     */
      @RequestMapping("contramod.htm")
    public String modificarcontrato(
            @RequestParam("proveedor") Integer contPro,
            @RequestParam("ticon") Integer contTip,
            @RequestParam("fini") String contFechaIni,
            @RequestParam("ffin") String contFechaFin,
            @RequestParam("nocon") String contNum,
            @RequestParam("estado") Integer contEstad,
            @RequestParam("login") String contLogin,
            @RequestParam("descripcion") String contDescrip,
            @RequestParam("idcont") int idcont,
            @RequestParam("tareacambio") String tareacambio,
            Model model) throws ServicioException {
        
        
        EtbInvTablaDominios tabladominios = new EtbInvTablaDominios(7);
        EtbInvContrato contratos=dao.contratos(idcont);
        String cam_tab_descripcion_SM = "1";
        String cam_tab_solicitante_SM = "1";
        int usuarioetb1 = (int) request.getSession().getAttribute("idusuap");
        EtbInvUsuarioAp usuarioetb = new EtbInvUsuarioAp(usuarioetb1);
        dao.llenarbitacora(tabladominios, idcont, usuarioetb, FechaH, tareacambio, cam_tab_descripcion_SM, cam_tab_solicitante_SM);

        EtbInvCambioTabla camt = dao.idcambiotabla(tabladominios, idcont, usuarioetb, tareacambio);
        //    int cambbit = camt.getCamtabID();
        EtbInvCambioTabla CamIdtabla = new EtbInvCambioTabla(camt.getCamtabID());

        if (!contratos.getContProv().getMarIdMarca().equals(contPro)) {
            String CamColumna = "CONT_PROV";
            String CamNawValor = "" + contPro;
            String CamValorIni = "" + contratos.getContProv().getMarIdMarca();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!contratos.getContTipo().getTopcId().equals(contTip)) {
            String CamColumna = "CONT_TIPO";
            String CamNawValor = "" + contTip;
            String CamValorIni = "" + contratos.getContTipo().getTopcId();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!contratos.getContFechaIni().equals(contFechaIni)) {
            String CamColumna = "CONT_FECHA_INI";
            String CamNawValor = "" + contFechaIni;
            String CamValorIni = "" + contratos.getContFechaIni();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!contratos.getContFechaFin().equals(contFechaFin)) {
            String CamColumna = "CONT_FECHA_FIN";
            String CamNawValor = "" + contFechaFin;
            String CamValorIni = "" + contratos.getContFechaFin();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!contratos.getContNum().equals(contNum)) {
            String CamColumna = "CONT_NUM";
            String CamNawValor = "" + contNum;
            String CamValorIni = "" + contratos.getContNum();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!contratos.getContLogin().equals(contLogin)) {
            String CamColumna = "CONT_LOGIN";
            String CamNawValor = "" + contLogin;
            String CamValorIni = "" + contratos.getContLogin();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!contratos.getContEstado().getEstcoId().equals(contEstad)) {
            String CamColumna = "CONT_ESTADO";
            String CamNawValor = "" + contEstad;
            String CamValorIni = "" + contratos.getContEstado().getEstcoId();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!contratos.getContDescrip().equals(contDescrip)) {
            String CamColumna = "CONT_DESCRIP";
            String CamNawValor = "" + contDescrip;
            String CamValorIni = "" + contratos.getContDescrip();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        EtbInvMarca contProv = new EtbInvMarca(contPro);
        EtbInvTipoCont contTipo = new EtbInvTipoCont(contTip);
        EtbInvEstadoCont contEstado = new EtbInvEstadoCont(contEstad);
       
        int m = 2;
        
        model.addAttribute("m", m);
        dao.modicont(idcont,contratos.getFCreacion(), contProv, contTipo, contFechaIni, contFechaFin, contNum, contEstado, contLogin, contDescrip);
        List<EtbInvContrato> ListaContra = dao.ListaContra();
        model.addAttribute("listaContra", ListaContra);
        return "user/contratos";

    }
}
