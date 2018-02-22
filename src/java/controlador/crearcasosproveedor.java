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
import tablas.EtbInvEstadoCasos;
import tablas.EtbInvMarca;
import tablas.EtbInvServidor;
import tablas.EtbInvTablaDominios;
import tablas.EtbInvUsuarioAp;

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
      Calendar fechaActualH = Calendar.getInstance();
 String FechaH = String.format("%04d-%02d-%02d %02d:%02d:%02d",
            fechaActualH.get(Calendar.YEAR),
            fechaActualH.get(Calendar.MONTH) + 1,
            fechaActualH.get(Calendar.DAY_OF_MONTH),
            fechaActualH.get(Calendar.HOUR),
            fechaActualH.get(Calendar.MINUTE),
            fechaActualH.get(Calendar.SECOND));
    @RequestMapping("/caprov.htm")
    public String create(
            @RequestParam("proveedor") Integer caspPro,
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
        dao.creaproveedor(caspserv,Fecha, caspProv,caspFechaApe, caspFechaCie, caspNumero, caspIm, caspEstado);
        List<EtbInvCasosProv> Listaproveedor = dao.Listaproveedor();
        model.addAttribute("Listaproveedor", Listaproveedor);
        return "user/casosproveedor";

    }
    //CASOS PROVEEDOR

    @RequestMapping("casosproveedor.htm")
    public String casosproveedor(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvCasosProv> Listaproveedor = dao.Listaproveedor();
        model.addAttribute("Listaproveedor", Listaproveedor);
        return "user/casosproveedor";
    }

    @RequestMapping("newcasos.htm")
    public String newcasos(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
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
        return "user/casosproveedor";
    }
    //modificar casos proveedor
       @RequestMapping("casosmodifi.htm")
    public String modcasosprov(@RequestParam("caspId") int casosserv, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 7;
        EtbInvCasosProv cas = dao.casosprove(casosserv);
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("listaServer", Listaserver);
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("cas", cas);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return "user/casosproveedor";
    }
  @RequestMapping("modificarcasosprove.htm")
    public String modificarcasos(@RequestParam("proveedor") int proveedor,
            @RequestParam("idcasos") int idcasos,
            @RequestParam("servidor") int servidor,
            @RequestParam("fini") String fini,
            @RequestParam("fcie") String fcie,
            @RequestParam("estini") int estini,
            @RequestParam("numcas") String numcas,
            @RequestParam("im") String im,
            @RequestParam("tareacambio") String tareacambio,
            Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        
        int m = 7;

        EtbInvTablaDominios tabladominios = new EtbInvTablaDominios(4);
        EtbInvCasosProv cas = dao.casosprove(idcasos);
        String cam_tab_descripcion_SM = "1";
        String cam_tab_solicitante_SM = "1";
        int usuarioetb1 = (int) request.getSession().getAttribute("idusuap");
        EtbInvUsuarioAp usuarioetb = new EtbInvUsuarioAp(usuarioetb1);
        dao.llenarbitacora(tabladominios, idcasos, usuarioetb, FechaH, tareacambio, cam_tab_descripcion_SM, cam_tab_solicitante_SM);

        EtbInvCambioTabla camt = dao.idcambiotabla(tabladominios, idcasos, usuarioetb, tareacambio);
        //    int cambbit = camt.getCamtabID();
        EtbInvCambioTabla CamIdtabla = new EtbInvCambioTabla(camt.getCamtabID());

        if (!cas.getCaspServ().getSerServer().equals(servidor)) {
            String CamColumna = "CASP_SERV1";
            String CamNawValor = "" + servidor;
            String CamValorIni = "" + cas.getCaspServ().getSerServer();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspProv().getMarIdMarca().equals(proveedor)) {
            String CamColumna = "CASP_PROV";
            String CamNawValor = "" + proveedor;
            String CamValorIni = "" + cas.getCaspProv().getMarIdMarca();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspFechaApe().equals(fini)) {
            String CamColumna = "CASP_FECHA_APE";
            String CamNawValor = "" + fini;
            String CamValorIni = "" + cas.getCaspFechaApe();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspFechaCie().equals(fcie)) {
            String CamColumna = "CASP_FECHA_CIE";
            String CamNawValor = "" + fcie;
            String CamValorIni = "" + cas.getCaspFechaCie();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspEstado().getEstcId().equals(estini)) {
            String CamColumna = "CASP_ESTADO";
            String CamNawValor = "" + estini;
            String CamValorIni = "" + cas.getCaspEstado().getEstcId();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspNumero().equals(numcas)) {
            String CamColumna = "CASP_NUMERO";
            String CamNawValor = "" + numcas;
            String CamValorIni = "" + cas.getCaspNumero();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspIm().equals(im)) {
            String CamColumna = "CASP_IM";
            String CamNawValor = "" + im;
            String CamValorIni = "" + cas.getCaspIm();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        EtbInvServidor servi = new EtbInvServidor(servidor);
        EtbInvEstadoCasos estini1 = new EtbInvEstadoCasos(estini);
        EtbInvMarca proveedor1 = new EtbInvMarca(proveedor);
        dao.modificarcasproveedor(proveedor1, idcasos, fini, fcie, estini1, numcas, im, cas.getFCreacion(), servi);
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("cas", cas);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return "user/casosproveedor";
    }
}
