/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.out;
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
import tablas.EtbInvActividad;
import tablas.EtbInvAseguramiento;
import tablas.EtbInvCambioTabla;
import tablas.EtbInvCasosProv;
import tablas.EtbInvDireccionamiento;
import tablas.EtbInvEstadoCasos;
import tablas.EtbInvMarca;
import tablas.EtbInvRuta;
import tablas.EtbInvServidor;
import tablas.EtbInvTablaDominios;
import tablas.EtbInvTip;
import tablas.EtbInvTipoActividad;
import tablas.EtbInvUsuEstado;
import tablas.EtbInvUsuServ;
import tablas.EtbInvUsuarioAp;

/**
 *
 * @author diegfraa
 */
@Controller

public class crearaseguramiento {

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

    //ASEGURAMIENTO servidor
    @RequestMapping("aseguramiento.htm")
    public String nuev(@RequestParam("idservase") int idservo, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 2;
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }

    @RequestMapping("aseg.htm")
    public String createaseguram(
            @RequestParam("servidor") int aseServido,
            @RequestParam("eje") String aseEjecuta,
            @RequestParam("tarea") String aseTarea,
            @RequestParam("plantilla") File plantillas,
            @RequestParam("plantillan") String plantillan,
            @RequestParam("fini") String aseFecha,
            Model model) throws ServicioException, FileNotFoundException, IOException {
        int aseplantilla = 1;
        int m = 3;

        System.out.println("controlador.crearaseguramiento.createaseguram(1)" +plantillas);
      
        
        String ruta = "\\NetBeansProjects\\Pruebas\\dominios_1.2\\web\\plantillas\\"+plantillas;
        FileOutputStream fos = new FileOutputStream(ruta);

        File origen = new File(plantillan);
        File destino = new File(ruta);
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino);
        byte[] buf = new byte[1024];
        int len;

        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    
        model.addAttribute("m", m);
        EtbInvServidor aseServidor = new EtbInvServidor(aseServido);
        dao.crease(Fecha, aseTarea, aseServidor, aseEjecuta, aseFecha, aseplantilla);
        return "user/servers";

    }

    @RequestMapping("asegseerv.htm")
    public String aseguramiento(
            @RequestParam("serv") int serv,
            Model model) throws ServicioException {
        int m = 0;
        model.addAttribute("m", m);
        model.addAttribute("serv", serv);
        return "user/cosasservidor";

    }

    @RequestMapping("asergmod.htm")
    public String aseguramientomod(
            @RequestParam("serv") int serv,
            Model model) throws ServicioException {
        int m = 6;
        EtbInvAseguramiento aseguramiento = dao.aseguramiento(serv);
        model.addAttribute("m", m);
        model.addAttribute("aseg", aseguramiento);
        return "user/cosasservidor";

    }

    @RequestMapping("asegmod.htm")
    public String modificaraseguram(
            @RequestParam("idasegu") int idasegu,
            @RequestParam("fini") String fini,
            @RequestParam("plantilla") String plantilla,
            @RequestParam("tareacambio") String tareacambio,
            Model model) throws ServicioException {
        EtbInvTablaDominios tabladominios = new EtbInvTablaDominios(3);
        EtbInvAseguramiento aseguramiento = dao.aseguramiento(idasegu);
        int aseplantilla = 1;
        int m = 3;
        String cam_tab_descripcion_SM = "1";
        String cam_tab_solicitante_SM = "1";
        int usuarioetb1 = (int) request.getSession().getAttribute("idusuap");
        EtbInvUsuarioAp usuarioetb = new EtbInvUsuarioAp(usuarioetb1);
        dao.llenarbitacora(tabladominios, idasegu, usuarioetb, FechaH, tareacambio, cam_tab_descripcion_SM, cam_tab_solicitante_SM);

        EtbInvCambioTabla camt = dao.idcambiotabla(tabladominios, idasegu, usuarioetb, tareacambio);
        //    int cambbit = camt.getCamtabID();
        EtbInvCambioTabla CamIdtabla = new EtbInvCambioTabla(camt.getCamtabID());

        if (!aseguramiento.getAseFecha().equals(fini)) {
            String CamColumna = "ASE_FECHA";
            String CamNawValor = fini;
            String CamValorIni = aseguramiento.getAseFecha();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aseguramiento.getAsePlantilla() != aseplantilla) {
            String CamColumna = "ase_plantilla";
            String CamNawValor = "" + aseplantilla;
            String CamValorIni = "" + aseguramiento.getAsePlantilla();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        model.addAttribute("m", m);
        EtbInvServidor aseServidor = new EtbInvServidor(aseguramiento.getAseServidor().getSerServer());
        dao.modiase(idasegu, aseguramiento.getFCreacion(), aseguramiento.getAseTarea(), aseServidor, aseguramiento.getAseEjecuta(), fini, aseplantilla);
        return "user/servers";

    }

    //usuario servior
    @RequestMapping("usuarioservidor2.htm")
    public String usupo(@RequestParam("tdserv") Integer email7, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 5;
        EtbInvServidor email = new EtbInvServidor(email7);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        List<EtbInvUsuServ> Listaususerv = dao.Listaususervre(email);
        List<EtbInvUsuEstado> Listausuest = dao.Listausuest();
        model.addAttribute("Listaserver", Listaserver);
        model.addAttribute("Listaususerv", Listaususerv);
        model.addAttribute("Listausuest", Listausuest);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }

    //direccionamiento servidor
    @RequestMapping("direccionamiento.htm")
    public String direccionamiento(@RequestParam("serv") int serv, @RequestParam("servname") String servname, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        List<EtbInvTip> Listatipoip = dao.Listatipoip();
        int m = 1;
        model.addAttribute("Listatipoip", Listatipoip);
        model.addAttribute("servipname", servname);
        model.addAttribute("servip", serv);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }

    @RequestMapping("direccionamientoagregar.htm")
    public String direccionamientoingresar(
            @RequestParam("dirIp") String dirIp,
            @RequestParam("dirVlan") String dirVlan,
            @RequestParam("dirSwitch") String dirSwitch,
            @RequestParam("dirPuerto") String dirPuerto,
            @RequestParam("idSer1") int idSer1,
            @RequestParam("dirTipo1") int dirTipo1, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 0;
        EtbInvServidor idSer = new EtbInvServidor(idSer1);
        EtbInvTip dirTipo = new EtbInvTip(dirTipo1);
        dao.direccionamiento(dirIp, dirVlan, dirSwitch, dirPuerto, idSer, dirTipo);
        model.addAttribute("m", m);
        return "user/servers";
    }

    //direccionamiento servidor
    @RequestMapping("direccionamientomod.htm")
    public String direccionamientomod(@RequestParam("serv") int IdIp, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvDireccionamiento dic = dao.ipmod(IdIp);
        List<EtbInvTip> Listatipoip = dao.Listatipoip();
        int m = 3;
        model.addAttribute("Listatipoip", Listatipoip);
        model.addAttribute("servip", dic);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }

    //modificaer direccionamiento 
    @RequestMapping("direccionamientomodificar.htm")
    public String direccionamientomodificar(
            @RequestParam("tareacambio") String tareacambio,
            @RequestParam("iddirIp") int iddirIp,
            @RequestParam("idSer1") int idSer1,
            @RequestParam("dirIp") String dirIp,
            @RequestParam("dirVlan") String dirVlan,
            @RequestParam("dirSwitch") String dirSwitch,
            @RequestParam("dirPuerto") String dirPuerto,
            @RequestParam("dirTipo1") int dirTipo1, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }

        EtbInvTablaDominios tabladominios = new EtbInvTablaDominios(9);
        EtbInvDireccionamiento dic = dao.ipmod(iddirIp);
        String cam_tab_descripcion_SM = "1";
        String cam_tab_solicitante_SM = "1";
        int usuarioetb1 = (int) request.getSession().getAttribute("idusuap");
        EtbInvUsuarioAp usuarioetb = new EtbInvUsuarioAp(usuarioetb1);
        dao.llenarbitacora(tabladominios, iddirIp, usuarioetb, FechaH, tareacambio, cam_tab_descripcion_SM, cam_tab_solicitante_SM);

        EtbInvCambioTabla camt = dao.idcambiotabla(tabladominios, iddirIp, usuarioetb, tareacambio);
        //    int cambbit = camt.getCamtabID();
        EtbInvCambioTabla CamIdtabla = new EtbInvCambioTabla(camt.getCamtabID());

        if (!dic.getDirIp().equals(dirIp)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = dirIp;
            String CamValorIni = dic.getDirIp();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!dic.getDirVlan().equals(dirVlan)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = dirVlan;
            String CamValorIni = dic.getDirVlan();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!dic.getDirSwitch().equals(dirSwitch)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = dirSwitch;
            String CamValorIni = dic.getDirSwitch();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!dic.getDirPuerto().equals(dirPuerto)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = dirPuerto;
            String CamValorIni = dic.getDirPuerto();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (dic.getDirTipo().getTipIdIp() != dirTipo1) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = "" + dic.getDirTipo().getTipIdIp();
            String CamValorIni = "" + dirTipo1;
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        int m = 0;
        EtbInvServidor idSer = new EtbInvServidor(idSer1);
        EtbInvTip dirTipo = new EtbInvTip(dirTipo1);
        dao.direccionamientoedite(iddirIp, dirIp, dirVlan, dirSwitch, dirPuerto, idSer, dirTipo);
        model.addAttribute("m", m);
        return "user/servers";
    }

    //ruta servidor
    @RequestMapping("rutas.htm")
    public String rutas(@RequestParam("serv") int serv, @RequestParam("servname") String servname, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        List<EtbInvTip> Listatipoip = dao.Listatipoip();
        int m = 4;
        model.addAttribute("Listatipoip", Listatipoip);
        model.addAttribute("servipname", servname);
        model.addAttribute("servip", serv);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }

    @RequestMapping("rutaagregar.htm")
    public String rutasagregar(@RequestParam("idSer1") int idSer1, @RequestParam("rutaser") String rutaser, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvServidor idSer = new EtbInvServidor(idSer1);

        dao.agragarrutas(FechaH, rutaser, idSer);

        int m = 4;

        model.addAttribute("m", m);
        return "user/cosasservidor";
    }
    //mod servidor

    @RequestMapping("rutamod.htm")
    public String rutasmod(@RequestParam("serv") int serv,
            Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvRuta rutas = dao.rutas(serv);
        int m = 5;
        model.addAttribute("rutas", rutas);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }
    //modificar ruta servidor

    @RequestMapping("rutadificar.htm")
    public String rutasmod(@RequestParam("rutasId") int rutasId,
            @RequestParam("rutaIdser") int rutaIdser,
            @RequestParam("rutaF") String rutaF,
            @RequestParam("tareacambio") String tareacambio,
            @RequestParam("rutaser") String rutaser, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvTablaDominios tabladominios = new EtbInvTablaDominios(25);
        EtbInvRuta rutas = dao.rutas(rutasId);
        String cam_tab_descripcion_SM = "1";
        String cam_tab_solicitante_SM = "1";
        int usuarioetb1 = (int) request.getSession().getAttribute("idusuap");
        EtbInvServidor idSer = new EtbInvServidor(rutaIdser);
        EtbInvUsuarioAp usuarioetb = new EtbInvUsuarioAp(usuarioetb1);
        dao.llenarbitacora(tabladominios, rutasId, usuarioetb, FechaH, tareacambio, cam_tab_descripcion_SM, cam_tab_solicitante_SM);
        EtbInvCambioTabla camt = dao.idcambiotabla(tabladominios, rutasId, usuarioetb, tareacambio);
        EtbInvCambioTabla CamIdtabla = new EtbInvCambioTabla(camt.getCamtabID());
        if (!rutas.getRutRuta().equals(rutaser)) {
            String CamColumna = "RUT_RUTA";
            String CamNawValor = rutaser;
            String CamValorIni = rutas.getRutRuta();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        dao.editarrutas(rutasId, FechaH, rutaser, idSer);
        int m = 5;
        model.addAttribute("rutas", rutas);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }

    @RequestMapping("newcasosserv.htm")
    public String newcasosserv(@RequestParam("casosserv") int casosserv, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 7;
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("casosserv", casosserv);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }

    @RequestMapping("casosmod.htm")
    public String newcasosserv1(@RequestParam("caspId") int casosserv, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 8;
        EtbInvCasosProv cas = dao.casosprove(casosserv);
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("cas", cas);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }

    @RequestMapping("modificarcasos.htm")
    public String modificarcasos(@RequestParam("proveedor") int proveedor,
            @RequestParam("idcasos") int idcasos,
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
        int m = 8;

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

        if (!cas.getCaspProv().getMarIdMarca().equals(proveedor)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = "" + proveedor;
            String CamValorIni = "" + cas.getCaspProv().getMarIdMarca();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspFechaApe().equals(fini)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = "" + fini;
            String CamValorIni = "" + cas.getCaspFechaApe();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspFechaCie().equals(fcie)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = "" + fcie;
            String CamValorIni = "" + cas.getCaspFechaCie();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspEstado().getEstcId().equals(estini)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = "" + estini;
            String CamValorIni = "" + cas.getCaspEstado().getEstcId();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspNumero().equals(numcas)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = "" + numcas;
            String CamValorIni = "" + cas.getCaspNumero();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!cas.getCaspIm().equals(im)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor = "" + im;
            String CamValorIni = "" + cas.getCaspIm();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        EtbInvServidor servi = new EtbInvServidor(cas.getCaspServ().getSerServer());
        EtbInvEstadoCasos estini1 = new EtbInvEstadoCasos(estini);
        EtbInvMarca proveedor1 = new EtbInvMarca(proveedor);
        dao.modificarcasproveedor(proveedor1, idcasos, fini, fcie, estini1, numcas, im, cas.getFCreacion(), servi);
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("cas", cas);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }

    //nueva actividad del servidor
    @RequestMapping("newactivser.htm")
    public String newactivser(@RequestParam("servd") int servd, Model model) {
        List<EtbInvTipoActividad> Listatipoactiv = dao.Listatipoactiv();
        model.addAttribute("Listatipoactiv", Listatipoactiv);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvServidor aa = dao.readid(servd);
        int m = 9;
        model.addAttribute("m", m);
        model.addAttribute("serv", aa);
        return "user/cosasservidor";
    }

    @RequestMapping("modactivser.htm")
    public String modactivser(@RequestParam("idact") int idact, Model model) {
        List<EtbInvTipoActividad> Listatipoactiv = dao.Listatipoactiv();
        model.addAttribute("Listatipoactiv", Listatipoactiv);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvActividad aa = dao.activida(idact);
        int m = 10;
        model.addAttribute("m", m);
        model.addAttribute("acti", aa);
        return "user/cosasservidor";
    }

    @RequestMapping("/modact.htm")
    public String create(
            @RequestParam("serv") int actServ,
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
        EtbInvServidor serv1 = new EtbInvServidor(aa.getActServ().getSerServer());

        int m = 2;
        model.addAttribute("m", m);
        dao.modificaractiv(aa.getActId(), aa.getFCreacion(), serv1, actEjecuta, actTarea, actDescripcion, actSolicita, actTipo, actFechaFin, actFechaIni);
        List<EtbInvActividad> ListaActividad = dao.ListaActividad();
        model.addAttribute("listaActividad", ListaActividad);
        return "user/actividades";

    }

    /// modificar usuario
    @RequestMapping("modususer.htm")
    public String modususer(@RequestParam("servd") int actServ, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
        }
        int m = 11;

        EtbInvServidor aa = dao.readid(actServ);
        model.addAttribute("m", m);
        model.addAttribute("actServ", aa);
        return "user/cosasservidor";
    }

    @RequestMapping("modusuarios.htm")
    public String modusuarios(@RequestParam("id") Integer email, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvUsuServ a = dao.buscarususerv(email);
        List<EtbInvUsuEstado> Listausuest = dao.Listausuest();
        int m = 12;
        model.addAttribute("usuer", a);
        model.addAttribute("Listausuest", Listausuest);
        model.addAttribute("m", m);

        return "user/cosasservidor";
    }

    @RequestMapping("modiusuario.htm")
    public String modiusuario(@RequestParam("login") String ususLogin,
            @RequestParam("nombre") String nombre,
            @RequestParam("tareacambio") String tareacambio,
            @RequestParam("estado") int estado,
            @RequestParam("administrado") int admin,
            @RequestParam("servid") int email, Model model) {

        int m = 0;
        model.addAttribute("m", m);
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

        EtbInvServidor ususidServ = new EtbInvServidor(a.getIdSerServidor().getSerServer());
        dao.update(a.getFCreacion(), email, ususEstado, ususLogin, nombre, admin, ususidServ);
        dao.crearcambioususerv(Fecha, ususLogin, tareacambio, ususEstado);

        model.addAttribute("Listaususerv", a);
        return null;
    }

    private byte[] texto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
