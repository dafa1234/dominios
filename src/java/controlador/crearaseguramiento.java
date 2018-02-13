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
    public ModelAndView nuev(@RequestParam("idservase") int idservo, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 2;
        EtbInvServidor idserv = new EtbInvServidor(idservo);
        model.addAttribute("m", m);
        //  List<EtbInvAseguramiento> ListaAsegu = dao.ListaAsegu(idserv);
        //  model.addAttribute("listaAsegu", ListaAsegu);
        return maw;
    }

    @RequestMapping("aseg.htm")
    public String createaseguram(
            @RequestParam("servidor") int aseServido,
            @RequestParam("eje") String aseEjecuta,
            @RequestParam("tarea") String aseTarea,
            @RequestParam("plantilla") String actTipo,
            @RequestParam("fini") String aseFecha,
            Model model) throws ServicioException {
        int aseplantilla = 1;
        int m = 3;
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
    public ModelAndView usupo(@RequestParam("tdserv") Integer email7, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
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
        return maw;
    }

    //direccionamiento servidor
    @RequestMapping("direccionamiento.htm")
    public ModelAndView direccionamiento(@RequestParam("serv") int serv, @RequestParam("servname") String servname, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        List<EtbInvTip> Listatipoip = dao.Listatipoip();
        int m = 1;
        model.addAttribute("Listatipoip", Listatipoip);
        model.addAttribute("servipname", servname);
        model.addAttribute("servip", serv);
        model.addAttribute("m", m);
        return maw;
    }

    @RequestMapping("direccionamientoagregar.htm")
    public ModelAndView direccionamientoingresar(@RequestParam("dirDirServ") String dirDirServ,
            @RequestParam("dirIp") String dirIp,
            @RequestParam("dirVlan") String dirVlan,
            @RequestParam("dirSwitch") String dirSwitch,
            @RequestParam("dirPuerto") String dirPuerto,
            @RequestParam("idSer1") int idSer1,
            @RequestParam("dirTipo1") int dirTipo1, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/servers");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 0;
        EtbInvServidor idSer = new EtbInvServidor(idSer1);
        EtbInvTip dirTipo = new EtbInvTip(dirTipo1);
        dao.direccionamiento(dirDirServ, dirIp, dirVlan, dirSwitch, dirPuerto, idSer, dirTipo);
        model.addAttribute("m", m);
        return maw;
    }

    //direccionamiento servidor
    @RequestMapping("direccionamientomod.htm")
    public ModelAndView direccionamientomod(@RequestParam("serv") int IdIp, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvDireccionamiento dic = dao.ipmod(IdIp);
        List<EtbInvTip> Listatipoip = dao.Listatipoip();
        int m = 3;
        model.addAttribute("Listatipoip", Listatipoip);
        model.addAttribute("servip", dic);
        model.addAttribute("m", m);
        return maw;
    }

    //modificaer direccionamiento 
    @RequestMapping("direccionamientomodificar.htm")
    public ModelAndView direccionamientomodificar(
            @RequestParam("tareacambio") String tareacambio,
            @RequestParam("iddirIp") int iddirIp,
            @RequestParam("idSer1") int idSer1,
            @RequestParam("dirDirServ") String dirDirServ,
            @RequestParam("dirIp") String dirIp,
            @RequestParam("dirVlan") String dirVlan,
            @RequestParam("dirSwitch") String dirSwitch,
            @RequestParam("dirPuerto") String dirPuerto,
            @RequestParam("dirTipo1") int dirTipo1, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/servers");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
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
        dao.direccionamientoedite(iddirIp, dirDirServ, dirIp, dirVlan, dirSwitch, dirPuerto, idSer, dirTipo);
        model.addAttribute("m", m);
        return maw;
    }

    //ruta servidor
    @RequestMapping("rutas.htm")
    public ModelAndView rutas(@RequestParam("serv") int serv, @RequestParam("servname") String servname, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        List<EtbInvTip> Listatipoip = dao.Listatipoip();
        int m = 4;
        model.addAttribute("Listatipoip", Listatipoip);
        model.addAttribute("servipname", servname);
        model.addAttribute("servip", serv);
        model.addAttribute("m", m);
        return maw;
    }

    @RequestMapping("rutaagregar.htm")
    public ModelAndView rutasagregar(@RequestParam("idSer1") int idSer1, @RequestParam("rutaser") String rutaser, @RequestParam("idSerna") String idSerna, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvServidor idSer = new EtbInvServidor(idSer1);

        dao.agragarrutas(FechaH, rutaser, idSer, idSerna);

        int m = 4;

        model.addAttribute("m", m);
        return maw;
    }
    //mod servidor

    @RequestMapping("rutamod.htm")
    public ModelAndView rutasmod(@RequestParam("serv") int serv,
            Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvRuta rutas = dao.rutas(serv);
        int m = 5;
        model.addAttribute("rutas", rutas);
        model.addAttribute("m", m);
        return maw;
    }
    //modificar ruta servidor

    @RequestMapping("rutadificar.htm")
    public ModelAndView rutasmod(@RequestParam("rutasId") int rutasId,
            @RequestParam("rutaIdser") int rutaIdser,
            @RequestParam("rutahosser") String rutahosser,
            @RequestParam("rutaF") String rutaF,
            @RequestParam("tareacambio") String tareacambio,
            @RequestParam("rutaser") String rutaser, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
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
        dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);}
        dao.editarrutas(rutasId, FechaH, rutaser, idSer, rutahosser);
        int m = 5;
        model.addAttribute("rutas", rutas);
        model.addAttribute("m", m);
        return maw;
    }

    @RequestMapping("newcasosserv.htm")
    public ModelAndView newcasosserv(@RequestParam("casosserv") int casosserv, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 7;
//        List<EtbInvCasosProv> Listaproveedor = dao.Listaproveedor();
//        model.addAttribute("Listaproveedor", Listaproveedor);

        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("casosserv", casosserv);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return maw;
    }
  @RequestMapping("casosmod.htm")
    public ModelAndView newcasosserv1(@RequestParam("caspId") int casosserv, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 8;
       EtbInvCasosProv cas = dao.casosprove(casosserv);
       

        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("cas", cas);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return maw;
    }
      @RequestMapping("modificarcasos.htm")
    public ModelAndView modificarcasos( @RequestParam("proveedor") int proveedor,
                                        @RequestParam("idcasos") int idcasos,
                                        @RequestParam("fini") String fini,
                                        @RequestParam("fcie") String fcie,
                                        @RequestParam("estini") int estini,
                                        @RequestParam("numcas") String numcas,
                                        @RequestParam("im") String im,
                                        @RequestParam("tareacambio") String tareacambio,
            Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
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
            String CamNawValor =""+ proveedor;
            String CamValorIni =""+ cas.getCaspProv().getMarIdMarca();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
         if (!cas.getCaspFechaApe().equals(fini)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor =""+ fini;
            String CamValorIni =""+ cas.getCaspFechaApe();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
          if (!cas.getCaspFechaCie().equals(fcie)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor =""+ fcie;
            String CamValorIni =""+ cas.getCaspFechaCie();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
           if (!cas.getCaspEstado().getEstcId().equals(estini)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor =""+ estini;
            String CamValorIni =""+ cas.getCaspEstado().getEstcId();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
            if (!cas.getCaspNumero().equals(numcas)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor =""+ numcas;
            String CamValorIni =""+ cas.getCaspNumero();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
             if (!cas.getCaspIm().equals(im)) {
            String CamColumna = "SER_HOSTNAME";
            String CamNawValor =""+ im;
            String CamValorIni =""+ cas.getCaspIm();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
              EtbInvServidor servi = new EtbInvServidor(cas.getCaspServ1().getSerServer());
              EtbInvEstadoCasos estini1 = new EtbInvEstadoCasos(estini);
        EtbInvMarca proveedor1 = new EtbInvMarca(proveedor);
          dao.modificarcasproveedor(proveedor1,idcasos,fini,fcie,estini1,numcas,im ,cas.getFCreacion(),cas.getCaspServ(),servi);
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstadoCasos> Listaestacasos = dao.Listaestacasos();
        model.addAttribute("ListaMarca", ListaMarca);
        model.addAttribute("cas", cas);
        model.addAttribute("listaEstado", Listaestacasos);
        model.addAttribute("m", m);
        return maw;
    }
    
    //nueva actividad del servidor
     @RequestMapping("newactivser.htm")
    public ModelAndView newactivser(@RequestParam("servd") int servd,Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        List<EtbInvTipoActividad> Listatipoactiv = dao.Listatipoactiv();
        model.addAttribute("Listatipoactiv", Listatipoactiv);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvServidor aa = dao.readid(servd);
        int m = 9;
        model.addAttribute("m", m);
        model.addAttribute("serv", aa);
        return maw;
    }
      @RequestMapping("modactivser.htm")
    public ModelAndView modactivser(@RequestParam("idact") int idact,Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cosasservidor");
        List<EtbInvTipoActividad> Listatipoactiv = dao.Listatipoactiv();
        model.addAttribute("Listatipoactiv", Listatipoactiv);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvActividad aa = dao.activida(idact);
        int m = 10;
        model.addAttribute("m", m);
        model.addAttribute("acti", aa);
        return maw;
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
            String CamNawValor =""+ actEjecuta;
            String CamValorIni =""+ aa.getActEjecuta();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActTarea().equals(actTarea)) {
            String CamColumna = "ACT_TAREA";
            String CamNawValor =""+ actTarea;
            String CamValorIni =""+ aa.getActTarea();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActDescripcion().equals(actDescripcion)) {
            String CamColumna = "ACT_DESCRIPCION";
            String CamNawValor =""+ actDescripcion;
            String CamValorIni =""+ aa.getActDescripcion();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActSolicita().equals(actSolicita)) {
            String CamColumna = "ACT_SOLICITA";
            String CamNawValor =""+ actSolicita;
            String CamValorIni =""+ aa.getActEjecuta();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActTipo().getTipaId().equals(actTip)) {
            String CamColumna = "ACT_TIPO";
            String CamNawValor =""+ actTip;
            String CamValorIni =""+ aa.getActTipo().getTipaId();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActFechaIni().equals(actFechaIni)) {
            String CamColumna = "ACT_FECHA_INI";
            String CamNawValor =""+ actFechaIni;
            String CamValorIni =""+ aa.getActFechaIni();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getActFechaFin().equals(actFechaFin)) {
            String CamColumna = "ACT_FECHA_FIN";
            String CamNawValor =""+ actFechaFin;
            String CamValorIni =""+ aa.getActFechaFin();
            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        //base de datos
        
        EtbInvTipoActividad actTipo = new EtbInvTipoActividad(actTip);
        EtbInvServidor serv1 = new EtbInvServidor(aa.getActServ1().getSerServer());
        
        int m = 2;
        model.addAttribute("m", m);
        dao.modificaractiv(aa.getActId(),aa.getFCreacion(), aa.getActServ(),serv1, actEjecuta, actTarea, actDescripcion, actSolicita, actTipo, actFechaFin, actFechaIni);
        List<EtbInvActividad> ListaActividad = dao.ListaActividad();
        model.addAttribute("listaActividad", ListaActividad);
        return "user/actividades";

    }
    
    
    /// modificar usuario
     @RequestMapping("modususer.htm")
    public ModelAndView modususer( @RequestParam("servd") int actServ,Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        int m = 11;
         
         EtbInvServidor aa = dao.readid(actServ);
        model.addAttribute("m", m);
       model.addAttribute("actServ", aa);
        maw.setViewName("user/cosasservidor");
        return maw;
    }
      @RequestMapping("modusuarios.htm")
    public ModelAndView modusuarios(@RequestParam("id") Integer email, Model model) {

        EtbInvUsuServ a = dao.buscarususerv(email);
        List<EtbInvUsuEstado> Listausuest = dao.Listausuest();
        int m = 12;
        model.addAttribute("email", email);
        model.addAttribute("Listausuest", Listausuest);
        model.addAttribute("getUsuApell", a.getUsusServ());
        model.addAttribute("getUsuCorreo", a.getUsusLogin());
        model.addAttribute("m", m);
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        return maw;
    }
    
    @RequestMapping("modiusuario.htm")
    public String create(@RequestParam("login") String ususLogin,
            @RequestParam("nombre") String ususNombre,
            @RequestParam("tarea") String tCambio,
            @RequestParam("servid") int ususidSer,
            @RequestParam("administrado") int administrado,Model model) {

        int m = 0;
        model.addAttribute("m", m);
        EtbInvServidor aa = dao.readid(ususidSer);
        String ususServ = aa.getSerSerial();
        EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(1);
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        EtbInvServidor ususidServ = new EtbInvServidor(ususidSer);
        dao.crearususerv(Fecha, ususLogin, ususNombre, ususServ, ususEstadoa, ususidServ,administrado);
        dao.crearcambioususerv(Fecha, ususLogin, tCambio, ususEstado);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        model.addAttribute("Listaususerv", Listaususerv);
        return "user/usuarioservidor";
    }
    
}
