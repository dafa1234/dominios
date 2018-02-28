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
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvDireccionamiento;
import tablas.EtbInvEstadoCasos;
import tablas.EtbInvEstadoMto;
import tablas.EtbInvMarca;
import tablas.EtbInvProyecto;
import tablas.EtbInvRuta;
import tablas.EtbInvServidor;
import tablas.EtbInvTablaDominios;
import tablas.EtbInvTip;
import tablas.EtbInvTipoActividad;
import tablas.EtbInvTipoCont;
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
    /**
     *
     * CREAR ASEGURAMIENTO SERVIDOR
     *
     * @param aseServido
     * @param aseEjecuta
     * @param aseTarea
     * @param plantillas
     * @param plantillan
     * @param aseFecha
     * @param model
     * @return
     * @throws ServicioException
     * @throws FileNotFoundException
     * @throws IOException
     */
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
        String ruta = "\\NetBeansProjects\\Pruebas\\dominios_1.2\\web\\plantillas\\" + plantillas;
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
        int m = 8;
        EtbInvServidor aa = dao.readid(aseServido);
        model.addAttribute("servidor", aa);
        model.addAttribute("m", m);
        EtbInvServidor aseServidor = new EtbInvServidor(aseServido);
        dao.crease(Fecha, aseTarea, aseServidor, aseEjecuta, aseFecha, aseplantilla);
        return "user/servers";

    }

    /**
     * este nos dirige al agregar un nuevo
     * aseguramiento del servidor
     * @param serv
     * @param model
     * @return
     * @throws ServicioException
     */
    @RequestMapping("asegseerv.htm")
    public String aseguramiento(
            @RequestParam("serv") int serv,
            Model model) throws ServicioException {
        int m = 0;
        EtbInvServidor aa = dao.readid(serv);
        model.addAttribute("m", m);
        model.addAttribute("serv", aa);
        return "user/cosasservidor";

    }

    /**
     * este nos dirige al modificar el aseguramiento
     * @param serv
     * @param model
     * @return
     * @throws ServicioException
     */
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

    /**
     *modificar aseguramiento
     * @param idasegu
     * @param fini
     * @param plantilla
     * @param tareacambio
     * @param model
     * @return
     * @throws ServicioException
     */
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
        int m = 8;
        EtbInvServidor aa = dao.readid(aseguramiento.getAseServidor().getSerServer());
        model.addAttribute("servidor", aa);
        model.addAttribute("m", m);
        EtbInvServidor aseServidor = new EtbInvServidor(aseguramiento.getAseServidor().getSerServer());
        dao.modiase(idasegu, aseguramiento.getFCreacion(), aseguramiento.getAseTarea(), aseServidor, aseguramiento.getAseEjecuta(), fini, aseplantilla);
        return "user/servers";

    }
    /**
     *este nos dirige a ingresar direccionamiento
     * @param serv
     * @param servname
     * @param model
     * @return
     */
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

    /**
     *aqui agregamos ip o direccionamiento
     * @param dirIp
     * @param dirVlan
     * @param dirSwitch
     * @param dirPuerto
     * @param idSer1
     * @param dirTipo1
     * @param model
     * @return
     */
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
        int m = 8;
        EtbInvServidor aa = dao.readid(idSer1);
        EtbInvServidor idSer = new EtbInvServidor(idSer1);
        EtbInvTip dirTipo = new EtbInvTip(dirTipo1);
        dao.direccionamiento(Fecha, dirIp, dirVlan, dirSwitch, dirPuerto, idSer, dirTipo);
        model.addAttribute("m", m);
        model.addAttribute("servidor", aa);
        return "user/servers";
    }

    /**
     *aqui dirigimos a modificar ip o direccionamiento
     * @param IdIp
     * @param model
     * @return
     */
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

    /**
     *aqui modificamos ip o direccionamiento
     * @param tareacambio
     * @param iddirIp
     * @param idSer1
     * @param dirIp
     * @param dirVlan
     * @param dirSwitch
     * @param dirPuerto
     * @param dirTipo1
     * @param model
     * @return
     */
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
        int m = 8;
        EtbInvServidor aa = dao.readid(idSer1);
        EtbInvServidor idSer = new EtbInvServidor(idSer1);
        EtbInvTip dirTipo = new EtbInvTip(dirTipo1);
        dao.direccionamientoedite(Fecha, iddirIp, dirIp, dirVlan, dirSwitch, dirPuerto, idSer, dirTipo);
        model.addAttribute("m", m);
        model.addAttribute("servidor", aa);
        return "user/servers";
    }

    /**
     * aqui dirigimos a agregar rutas
     * @param serv
     * @param servname
     * @param model
     * @return
     */
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

    /**
     *aqui agregamos rutas
     * @param idSer1
     * @param rutaser
     * @param model
     * @return
     */
    @RequestMapping("rutaagregar.htm")
    public String rutasagregar(@RequestParam("idSer1") int idSer1, @RequestParam("rutaser") String rutaser, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvServidor idSer = new EtbInvServidor(idSer1);
        dao.agragarrutas(FechaH, rutaser, idSer);
        int m = 8;
        EtbInvServidor aa = dao.readid(idSer1);
        model.addAttribute("servidor", aa);
        model.addAttribute("m", m);
        return "user/servers";
    }
    //mod servidor

    /**
     *aqui dirigimos a mopdificar rutas
     * @param serv
     * @param model
     * @return
     */
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

    /**
     *aqui modificamos rutas
     * @param rutasId
     * @param rutaIdser
     * @param rutaF
     * @param tareacambio
     * @param rutaser
     * @param model
     * @return
     */
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
        int m = 8;
        EtbInvServidor aa = dao.readid(rutaIdser);
        model.addAttribute("servidor", aa);
        model.addAttribute("rutas", rutas);
        model.addAttribute("m", m);
        return "user/servers";
    }

    /**
     *aqui dirigimos a agregar casos proveedor
     * @param casosserv
     * @param model
     * @return
     */
    @RequestMapping("newcasosserv.htm")
    public String newcasosserv(@RequestParam("casosserv") int casosserv, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 7;
        EtbInvServidor aa = dao.readid(casosserv);
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("casosserv", aa);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return "user/cosasservidor";
    }
    /**
     * 
     * @param caspPro
     * @param caspServ1
     * @param caspFechaApe
     * @param caspFechaCie
     * @param caspEstad
     * @param caspNumero
     * @param caspIm
     * @param model
     * @return
     * @throws ServicioException 
     */
     @RequestMapping("caprovs.htm")
    public String createss(
            @RequestParam("proveedor") Integer caspPro,
            @RequestParam("servidor") int caspServ1,
            @RequestParam("fini") String caspFechaApe,
            @RequestParam("fcie") String caspFechaCie,
            @RequestParam("estini") Integer caspEstad,
            @RequestParam("numcas") String caspNumero,
            @RequestParam("im") String caspIm,
            Model model) throws ServicioException {
        int m = 8;
        EtbInvServidor a = dao.readid(caspServ1);
        model.addAttribute("servidor", a);
        model.addAttribute("m", m);
        //base de datos
        EtbInvServidor caspserv = new EtbInvServidor(caspServ1);
        EtbInvEstadoCasos caspEstado = new EtbInvEstadoCasos(caspEstad);
        EtbInvMarca caspProv = new EtbInvMarca(caspPro);
        dao.creaproveedor(caspserv,Fecha, caspProv,caspFechaApe, caspFechaCie, caspNumero, caspIm, caspEstado);
        List<EtbInvCasosProv> Listaproveedor = dao.Listaproveedor();
        model.addAttribute("Listaproveedor", Listaproveedor);
        return "user/servers";

    }

    /**
     *aqui dirigimos a modificar casos proveedor
     * @param casosserv
     * @param model
     * @return
     */
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

    /**
     *aqui modificamos  casos proveedor
     * @param proveedor
     * @param idcasos
     * @param fini
     * @param fcie
     * @param estini
     * @param numcas
     * @param im
     * @param tareacambio
     * @param model
     * @return
     */
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

        EtbInvServidor aa = dao.readid(cas.getCaspServ().getSerServer());
        model.addAttribute("servidor", aa);
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
        return "user/servers";
    }

    /**
     *aqui dirige a agregar nueva actividad
     * @param servd
     * @param model
     * @return
     */
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
   @RequestMapping("acts.htm")
    public String creates(
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
        int m = 8;
        EtbInvServidor a = dao.readid(actServ);
        model.addAttribute("servidor", a);
        model.addAttribute("m", m);
        dao.creact(Fecha, serv1, actEjecuta, actTarea, actDescripcion, actSolicita, actTipo, actFechaFin, actFechaIni);
        List<EtbInvActividad> ListaActividad = dao.ListaActividad();
        model.addAttribute("listaActividad", ListaActividad);
        return "user/servers";

    }
    /**
     *aqui dirige a modificar actividad
     * @param idact
     * @param model
     * @return
     */
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

    /**
     * aqui modifica actividad
     * @param actServ
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

        int m = 8;
        EtbInvServidor a = dao.readid(aa.getActServ().getSerServer());
        model.addAttribute("servidor", a);
        model.addAttribute("m", m);
        dao.modificaractiv(aa.getActId(), aa.getFCreacion(), serv1, actEjecuta, actTarea, actDescripcion, actSolicita, actTipo, actFechaFin, actFechaIni);
        List<EtbInvActividad> ListaActividad = dao.ListaActividad();
        model.addAttribute("listaActividad", ListaActividad);
        return "user/servers";

    }

    /**
     *aqui dirige a agregar usuario servidor
     * @param actServ
     * @param model
     * @return
     */
    /// modificar usuario
    @RequestMapping("modususer.htm")
    public String createus(@RequestParam("servd") int actServ, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
        }
        int m = 11;

        EtbInvServidor aa = dao.readid(actServ);
        model.addAttribute("m", m);
        model.addAttribute("actServ", aa);
        return "user/cosasservidor";
    }
    /**
     * aqui crea usuarios servidor
     * @param ususLogin
     * @param ususNombre
     * @param tCambio
     * @param ususidSer
     * @param administrado
     * @param model
     * @return 
     */
    @RequestMapping("usuarioa.htm")
    public String createu(@RequestParam("login") String ususLogin,
            @RequestParam("nombre") String ususNombre,
            @RequestParam("tarea") String tCambio,
            @RequestParam("servid") int ususidSer,
            @RequestParam("administrado") int administrado, Model model) {

        int m = 8;
        model.addAttribute("m", m);
        EtbInvServidor aa = dao.readid(ususidSer);
        EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(1);
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        EtbInvServidor ususidServ = new EtbInvServidor(ususidSer);
        dao.crearususerv(Fecha, ususLogin, ususNombre, ususEstadoa, ususidServ, administrado);
        dao.crearcambioususerv(Fecha, ususLogin, tCambio, ususEstado);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        model.addAttribute("Listaususerv", Listaususerv);       
        model.addAttribute("servidor", aa);
        return "user/servers";
    }

    /**
     *aqui dirige a modificar usuarios servidor
     * @param email
     * @param model
     * @return
     */
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

    /**
     *aqui modifica usuarios
     * @param ususLogin
     * @param nombre
     * @param tareacambio
     * @param estado
     * @param admin
     * @param email
     * @param model
     * @return
     */
    @RequestMapping("modiusuario.htm")
    public String modiusuario(@RequestParam("login") String ususLogin,
            @RequestParam("nombre") String nombre,
            @RequestParam("tareacambio") String tareacambio,
            @RequestParam("estado") int estado,
            @RequestParam("administrado") int admin,
            @RequestParam("servid") int email, Model model) {

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
        int m = 8;
        model.addAttribute("m", m);
        EtbInvServidor aa = dao.readid(a.getIdSerServidor().getSerServer());
        model.addAttribute("servidor", aa);
        model.addAttribute("Listaususerv", a);
        return "user/servers";
    }

    /**
     *aqui agrega cronogramas
     * @param croProyect
     * @param croSerial
     * @param croFechaIni
     * @param croEstad
     * @param croEjecuta
     * @param croCambioFin
     * @param fprox
     * @param ffin
     * @param observacion
     * @param model
     * @return
     * @throws ServicioException
     */
    ///cronograma
    @RequestMapping("crono1.htm")
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
        EtbInvProyecto croProyecto = new EtbInvProyecto(croProyect);
        EtbInvEstadoMto croEstado = new EtbInvEstadoMto(croEstad);
        EtbInvServidor croSerial1 = new EtbInvServidor(croSerial);
        dao.creacrono(Fecha, croProyecto, croFechaIni, croSerial1, croEjecuta, croCambioFin, croEstado, fprox, ffin, observacion);
        int m = 8;
        EtbInvServidor aa = dao.readid(croSerial);
        model.addAttribute("servidor", aa);
        model.addAttribute("m", m);
        List<EtbInvCronogramaMto> ListaCrono = dao.ListaCrono();
        model.addAttribute("listaCrono", ListaCrono);
        return "user/servers";

    }

    /**
     *aqui dirige a agregar cronograma
     * @param actServ
     * @param model
     * @return
     */
    @RequestMapping("newcrono1.htm")
    public String newcrono(@RequestParam("servd") int actServ, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 14;
        EtbInvServidor aa = dao.readid(actServ);

        model.addAttribute("croServ", aa);
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
        return "user/cosasservidor";
    }

    /**
     *aqui dirige a modificar cronograma
     * @param idcron
     * @param model
     * @return
     */
    @RequestMapping("cronogramamod1.htm")
    public String cromod(@RequestParam("idcron") Integer idcron, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 13;
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
        EtbInvCronogramaMto cronograma = dao.cronograma(idcron);
        model.addAttribute("crono", cronograma);
        return "user/cosasservidor";
    }

    /**
     *aqui modifica cronograma
     * @param croProyect
     * @param croSerial
     * @param croFechaIni
     * @param croEstad
     * @param croEjecuta
     * @param croCambioFin
     * @param fprox
     * @param ffin
     * @param observacion
     * @param idcro
     * @param tareacambio
     * @param model
     * @return
     * @throws ServicioException
     */
    @RequestMapping("modcrono1.htm")
    public String modificarcronograma1(
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
        System.out.println("controlador.crearaseguramiento.modificarcronograma()");

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
        if (cronograma.getCroObservacion() == null) {
            if (observacion != null) {
                String CamColumna = "CRO_OBSERVACION";
                String CamNawValor = "" + observacion;
                String CamValorIni = "";
                dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
            }
        } else {
            if (!cronograma.getCroObservacion().equals(observacion)) {
                String CamColumna = "CRO_OBSERVACION";
                String CamNawValor = "" + observacion;
                String CamValorIni = "" + cronograma.getCroObservacion();
                dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
            }
        }
        EtbInvProyecto croProyecto = new EtbInvProyecto(croProyect);
        EtbInvEstadoMto croEstado = new EtbInvEstadoMto(croEstad);
        EtbInvServidor croSerial1 = new EtbInvServidor(croSerial);
        dao.modificarcrono(idcro, cronograma.getFCreacion(), croProyecto, croFechaIni, croSerial1, croEjecuta, croCambioFin, croEstado, fprox, ffin, observacion);
        int m = 8;
        EtbInvServidor aa = dao.readid(croSerial);
        model.addAttribute("servidor", aa);
        model.addAttribute("m", m);
        List<EtbInvCronogramaMto> ListaCrono = dao.ListaCrono();
        model.addAttribute("listaCrono", ListaCrono);
        return "user/servers";

    }

}
