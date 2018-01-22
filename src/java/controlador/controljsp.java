/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tablas.EtbInvActividad;
import tablas.EtbInvAseguramiento;
import tablas.EtbInvCamusuServ;
import tablas.EtbInvCasosProv;
import tablas.EtbInvCentral;
import tablas.EtbInvCliente;
import tablas.EtbInvContrato;
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvEstado;
import tablas.EtbInvEstadoCasos;
import tablas.EtbInvEstadoCont;
import tablas.EtbInvEstadoMto;
import tablas.EtbInvGrupo;
import tablas.EtbInvMarca;
import tablas.EtbInvModelo;
import tablas.EtbInvPlataforma;
import tablas.EtbInvProyecto;
import tablas.EtbInvRolServidor;
import tablas.EtbInvSalon;
import tablas.EtbInvServidor;
import tablas.EtbInvSisOperativo;
import tablas.EtbInvTipoActividad;
import tablas.EtbInvTipoCont;
import tablas.EtbInvUsuEstado;
import tablas.EtbInvUsuServ;

/**
 *
 * @author diegfraa
 */
@Controller

public class controljsp {

    @Autowired
    private iniciosecion dao;
    @Autowired
    private HttpServletRequest request;
    Calendar fechaActual = Calendar.getInstance();
    String Fecha = String.format("%04d-%02d-%02d",
            fechaActual.get(Calendar.YEAR),
            fechaActual.get(Calendar.MONTH) + 1,
            fechaActual.get(Calendar.DAY_OF_MONTH));
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

    @RequestMapping("pruebas.htm")
    public ModelAndView pruebas(Model model) {

        ModelAndView maw = new ModelAndView();
        maw.setViewName("prueba");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }

        return maw;
    }

    @RequestMapping("prueb.htm")
    public ModelAndView pr(Model model) {

        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/newjsp");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }

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
        int m = 1;
        model.addAttribute("m", m);
        return maw;
    }

    //CRONOGRAMA
    @RequestMapping("cronograma.htm")
    public ModelAndView cro(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cronograma");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvCronogramaMto> ListaCrono = dao.ListaCrono();
        model.addAttribute("listaCrono", ListaCrono);

        return maw;
    }

    @RequestMapping("newcrono.htm")
    public ModelAndView newcrono(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/cronograma");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
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
        return maw;
    }

    //ASEGURAMIENTO
    @RequestMapping("aseguramiento.htm")
    public ModelAndView nuev(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/aseguramiento");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvAseguramiento> ListaAsegu = dao.ListaAsegu();
        model.addAttribute("listaAsegu", ListaAsegu);
        return maw;
    }

    @RequestMapping("newaseg.htm")
    public ModelAndView newaseg(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/aseguramiento");
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        model.addAttribute("listaServer", Listaserver);
        int m = 1;
        model.addAttribute("m", m);
        return maw;
    }

    //CONTRATOS
    @RequestMapping("contratos.htm")
    public ModelAndView con(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/contratos");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 2;
        model.addAttribute("m", m);
        List<EtbInvContrato> ListaContra = dao.ListaContra();
        model.addAttribute("listaContra", ListaContra);

        return maw;
    }

    @RequestMapping("newcont.htm")
    public ModelAndView newcont(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/contratos");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 1;
        List<EtbInvEstadoCont> Listaestacont = dao.Listaestacont();
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvTipoCont> Listacont = dao.Listacont();
        model.addAttribute("ListaEstado", Listaestacont);
        model.addAttribute("listamarcas", ListaMarca);
        model.addAttribute("listacont", Listacont);
        model.addAttribute("m", m);
        return maw;
    }

    //USUARIO AP
    @RequestMapping("buscar.htm")
    public ModelAndView bus(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("buscar");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("Listaserver", Listaserver);
        return maw;
    }

    //central
    @RequestMapping("ncentral.htm")
    public ModelAndView nCentral(Model model) {
        ModelAndView maw = new ModelAndView();
        int noj = 1;
        model.addAttribute("noj", noj);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        return maw;
    }
//central
    @RequestMapping("central.htm")
    public ModelAndView Central(@RequestParam("central") String Central, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/objetos");
        int noj = 1;
        model.addAttribute("noj", noj);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        dao.newcentral(Central);
        return maw;
    }

    //grupo
    @RequestMapping("ngrupo.htm")
    public ModelAndView nGrupo(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int noj = 2;
        model.addAttribute("noj", noj);
        maw.setViewName("user/objetos");
        return maw;
    }

    @RequestMapping("grupo.htm")
    public ModelAndView Grupo(@RequestParam("ngrupo") String Ngrupo, @RequestParam("tgrupo") String Tgrupo, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 2;
        model.addAttribute("noj", noj);
        dao.newgrupo(Ngrupo, Tgrupo);
        return maw;
    }

    //marca
    @RequestMapping("nmarca.htm")
    public ModelAndView nmarca(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int noj = 3;
        model.addAttribute("noj", noj);
        maw.setViewName("user/objetos");
        return maw;
    }

    @RequestMapping("marca.htm")
    public ModelAndView marca(@RequestParam("nmarca") String nmarca, @RequestParam("usoporte") String usoporte,
            @RequestParam("tsoporte") String tsoporte, @RequestParam("minterventor") String minterventor, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 3;
        model.addAttribute("noj", noj);
        dao.newmarca(nmarca, usoporte, tsoporte, minterventor);
        return maw;
    }

    //plataforma
    @RequestMapping("nplataforma.htm")
    public ModelAndView nplataforma(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int noj = 4;
        model.addAttribute("noj", noj);
        maw.setViewName("user/objetos");
        return maw;
    }

    @RequestMapping("plataforma.htm")
    public ModelAndView plataforma(@RequestParam("nplataforma") String nplataforma, @RequestParam("aplataforma") int aplataforma, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 4;
        model.addAttribute("noj", noj);
        dao.newplataforma(nplataforma, aplataforma);
        return maw;
    }

    //rolserv
    @RequestMapping("nrolserv.htm")
    public ModelAndView nrolserv(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int noj = 5;
        model.addAttribute("noj", noj);
        maw.setViewName("user/objetos");
        return maw;
    }

    @RequestMapping("rolserv.htm")
    public ModelAndView rolserv(@RequestParam("nrol") String nrol, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 5;
        model.addAttribute("noj", noj);
        dao.newrol(nrol);
        return maw;
    }

    //sisoper
    @RequestMapping("nsisopera.htm")
    public ModelAndView nsisoper(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int noj = 6;
        model.addAttribute("noj", noj);
        maw.setViewName("user/objetos");
        return maw;
    }

    @RequestMapping("sisopera.htm")
    public ModelAndView sisoper(@RequestParam("sisdis") int sisdis, @RequestParam("nsis") String nsis, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 6;
        model.addAttribute("noj", noj);
        dao.newsisoperativo(sisdis, nsis);
        return maw;
    }
    //estado

    @RequestMapping("nestado.htm")
    public ModelAndView nestado(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int noj = 7;
        model.addAttribute("noj", noj);
        maw.setViewName("user/objetos");
        return maw;
    }

    @RequestMapping("estado.htm")
    public ModelAndView estado(@RequestParam("nest") String nest, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 7;
        model.addAttribute("noj", noj);
        dao.newestado(nest);
        return maw;
    }
    //salon

    @RequestMapping("nsalon.htm")
    public ModelAndView nsalon(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int noj = 8;
        List<EtbInvCentral> ListaCentral = dao.ListaCentral();
        model.addAttribute("noj", noj);
        model.addAttribute("listaCentral", ListaCentral);
        maw.setViewName("user/objetos");
        return maw;
    }

    @RequestMapping("salon.htm")
    public ModelAndView salon(@RequestParam("scen") int scen, @RequestParam("nsal") String nsal, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 8;
        model.addAttribute("noj", noj);
        dao.newsalon(scen, nsal);
        return maw;
    }

    //modelo
    @RequestMapping("nmodelo.htm")
    public ModelAndView nmodelo(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int noj = 9;
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        model.addAttribute("noj", noj);
        model.addAttribute("listaMarca", ListaMarca);
        maw.setViewName("user/objetos");
        return maw;
    }

    @RequestMapping("modelo.htm")
    public ModelAndView modelo(@RequestParam("nmar") int nmar, @RequestParam("nmod") String nmod, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 9;
        model.addAttribute("noj", noj);
        dao.newmodelo(nmar, nmod);
        return maw;
    }

    //cliente
    @RequestMapping("ncliente.htm")
    public ModelAndView ncliente(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int noj = 10;
        model.addAttribute("noj", noj);
        maw.setViewName("user/objetos");
        return maw;
    }

    @RequestMapping("cliente.htm")
    public ModelAndView cliente(@RequestParam("ncli") String ncli, @RequestParam("ccli") String ccli, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 10;
        model.addAttribute("noj", noj);
        dao.newcliente(ncli, ccli);
        return maw;
    }

    //ADMINISTRADOR
    @RequestMapping("fono.htm")
    public ModelAndView fon(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fono");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("Listaserver", Listaserver);
        return maw;
    }

    //USUARIOS SERVIDOR
    @RequestMapping("usuarioservidor.htm")
    public ModelAndView usu(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 0;
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        List<EtbInvUsuEstado> Listausuest = dao.Listausuest();
        model.addAttribute("Listaserver", Listaserver);
        model.addAttribute("Listaususerv", Listaususerv);
        model.addAttribute("Listausuest", Listausuest);
        model.addAttribute("m", m);
        return maw;
    }

    @RequestMapping("detalle.htm")
    public ModelAndView detalle(@RequestParam("id") Integer email, @RequestParam("usu") String usu, Model model) {

        List<EtbInvCamusuServ> ListaDetalle = dao.ListaDetalle(usu);
        EtbInvUsuServ a = dao.buscarususerv(email);
        int m = 2;
        model.addAttribute("ususLogin", a.getUsusLogin());
        model.addAttribute("ususNombre", a.getUsusNombre());
        model.addAttribute("ususServ", a.getUsusServ());
        model.addAttribute("ususAdm", a.getUsusAdm());
        model.addAttribute("ususEstado", a.getUsusEstado().getEstuEstado());
        model.addAttribute("m", m);
        model.addAttribute("ListaDetalle", ListaDetalle);
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        return maw;
    }

    @RequestMapping("usuarios.htm")
    public ModelAndView usuarios(@RequestParam("id") Integer email, Model model) {

        EtbInvUsuServ a = dao.buscarususerv(email);
        List<EtbInvUsuEstado> Listausuest = dao.Listausuest();
        int m = 4;
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

    @RequestMapping("modificar.htm")
    public ModelAndView usuarios3(@RequestParam("id") Integer email,
            @RequestParam("tarea") String tCambio,
            @RequestParam("serv") Integer ususEstad, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(ususEstad);
        EtbInvUsuServ a = dao.buscarususerv(email);
        String ususLogin = a.getUsusLogin();
        String nombre = a.getUsusNombre();
        String servidor = a.getUsusServ();
        Integer admin = a.getUsusAdm();
        EtbInvServidor ususidServ = a.getIdSerServidor();
        String Fechas = a.getFCreacion();
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        model.addAttribute("Listaususerv", Listaususerv);
        dao.update(Fechas, email, ususEstado, ususLogin, nombre, servidor, admin, ususidServ);
        dao.crearcambioususerv(Fecha, ususLogin, tCambio, ususEstado);
        int m = 0;
        model.addAttribute("m", m);
        maw.setViewName("user/usuarioservidor");

        return maw;
    }

    @RequestMapping("usuarioos.htm")
    public ModelAndView usuarios2(Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        int m = 1;
        model.addAttribute("Listaserver", Listaserver);
        model.addAttribute("m", m);
        model.addAttribute("Listaususerv", Listaususerv);
        maw.setViewName("user/usuarioservidor");
        return maw;
    }

    //CERRAR SESION
    @RequestMapping("cerrarsesion.htm")
    public ModelAndView cer() {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("cerrarsesion");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        return maw;
    }

    //MODIFICAR USUARIOS
    @RequestMapping("modificarusuario.htm")
    public ModelAndView mouser(Model model) throws UnknownHostException {

        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/modificarusuario");
        String id = (String) request.getSession().getAttribute("name");
        String usuetb = (String) request.getSession().getAttribute("usuetb");
        int per = (int) request.getSession().getAttribute("ID");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }

        if (per != 1) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ip = inetAddress.getHostAddress();
            String url = request.getRequestURL().toString();
            String acc = "acceso proivido para el usuario" + usuetb + ".";
            dao.ACCPROI(Fecha, usuetb, ip, url, acc);
            model.addAttribute("errorr", acc);
            maw.setViewName("error");
            return maw;
        }
        return maw;
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

    //SERVIDORES
    @RequestMapping("servers.htm")
    public ModelAndView server(Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/servers");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 0;
        model.addAttribute("m", m);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("listaServer", Listaserver);
        return maw;
    }

    @RequestMapping("TdServ.htm")
    public ModelAndView tdserver(@RequestParam("tdserv") Integer ususidSer, Model model) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("user/servers");
        EtbInvServidor aa = dao.readid(ususidSer);
        int m = 2;
        model.addAttribute("m", m);
        model.addAttribute("idser", aa.getSerServer());
        model.addAttribute("serial", aa.getSerSerial());
        model.addAttribute("hostname", aa.getSerHostname());
        model.addAttribute("marca", aa.getMarIdMarca().getMarNomMarca());
        model.addAttribute("modelo", aa.getModIdModelo().getModNomModelo());
        model.addAttribute("sisoperativo", aa.getSisIdSisOperativo().getSisNombre());
        model.addAttribute("conexion", aa.getSerConexion());
        model.addAttribute("estado", aa.getEstIdEstado().getEstEstado());
        model.addAttribute("central", aa.getCenIdCentral().getCenNombre());
        model.addAttribute("salon", aa.getSalIdSalon().getSalNombre());
        model.addAttribute("rack", aa.getSerRack());
        model.addAttribute("unidad", aa.getSerUnidad());
        model.addAttribute("grupo", aa.getGruIdGrupo().getGruNomGrupo());
        model.addAttribute("cliente", aa.getCliIdCliente().getCliNombre());
        model.addAttribute("proyecto", aa.getSerProyecto());
        model.addAttribute("rolserv", aa.getRolIdRolServ().getRolNomRolServ());
        model.addAttribute("plataforma", aa.getPlaIdPlataforma().getPlaNomPlataforma());
        model.addAttribute("fingreso", aa.getSerFIngreso());
        model.addAttribute("tingreso", aa.getSerTIngreso());
        model.addAttribute("npfisicos", aa.getSerNoProcFisico());
        model.addAttribute("foradcompartida", aa.getSerForAdCompartida());
        model.addAttribute("adcompartida", aa.getSerAdCompartida());
        model.addAttribute("administrada", aa.getSerAdministrado());
        model.addAttribute("cores", aa.getSerCores());
        model.addAttribute("direccionamientocoll", aa.getEtbInvDireccionamientoCollection());
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        return maw;

    }

    @RequestMapping("aserver.htm")
    public ModelAndView agser(Model model) {
        ModelAndView maw = new ModelAndView();
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        int m = 1;
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvEstado> ListaEstado = dao.ListaEstado();
        List<EtbInvSisOperativo> Listasisope = dao.Listasisope();
        List<EtbInvGrupo> Listagrupo = dao.Listagrupo();
        List<EtbInvCentral> ListaCentral = dao.ListaCentral();
        List<EtbInvPlataforma> ListaPrataforma = dao.ListaPrataforma();
        List<EtbInvRolServidor> ListaRolserver = dao.ListaRolserver();
        List<EtbInvSalon> ListaSalom = dao.ListaSalom();
        List<EtbInvModelo> ListaModelo = dao.ListaModelo();
        List<EtbInvCliente> ListaCliente = dao.ListaCliente();
        model.addAttribute("listaFonos", ListaMarca);
        model.addAttribute("listaServer", Listaserver);
        model.addAttribute("listaEstado", ListaEstado);
        model.addAttribute("listaSis", Listasisope);
        model.addAttribute("listaGrupo", Listagrupo);
        model.addAttribute("listaCentral", ListaCentral);
        model.addAttribute("listaPlat", ListaPrataforma);
        model.addAttribute("listaRol", ListaRolserver);
        model.addAttribute("listaSalon", ListaSalom);
        model.addAttribute("listaModelo", ListaModelo);
        model.addAttribute("listaCliente", ListaCliente);
        model.addAttribute("listaServer", Listaserver);
        model.addAttribute("m", m);
        maw.setViewName("user/servers");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        return maw;
    }
    //reporte

    @RequestMapping("serversreport.htm")
    public ModelAndView serverreport(@RequestParam("F_Inicio") String F_Inicio, @RequestParam("F_Fin") String F_Fin, @RequestParam("F") int F, Model model) throws FileNotFoundException, IOException, SQLException {
        ModelAndView maw = new ModelAndView();

        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int m = 3;
        if (F == 1) {
            maw.setViewName("user/servers");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte1(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Servidor entre Fechas "+F_Inicio+" y "+F_Fin);
        }
        if (F == 2) {
            maw.setViewName("user/usuarioservidor");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte2(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Usuario Servidor entre Fechas "+F_Inicio+" y "+F_Fin);
        }
        if (F == 3) {
            maw.setViewName("user/cronograma");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte3(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Cronograma entre Fechas "+F_Inicio+" y "+F_Fin);
        }
        if (F == 4) {
            maw.setViewName("user/contratos");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte4(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Cntratos entre Fechas "+F_Inicio+" y "+F_Fin);
        }
        if (F == 5) {
            maw.setViewName("user/aseguramiento");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte5(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Aseguramiento entre Fechas "+F_Inicio+" y "+F_Fin);
        }
        if (F == 6) {
            maw.setViewName("user/actividades");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte6(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Actividades entre Fechas "+F_Inicio+" y "+F_Fin);
        }
        if (F == 7) {
            maw.setViewName("user/casosproveedor");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte7(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte casos proveedor entre Fechas "+F_Inicio+" y "+F_Fin);
        }
        return maw;
    }

}
