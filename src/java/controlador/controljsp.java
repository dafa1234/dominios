/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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
import tablas.EtbInvAdmPlataforma;
import tablas.EtbInvCentral;
import tablas.EtbInvCliente;
import tablas.EtbInvEstado;
import tablas.EtbInvGrupo;
import tablas.EtbInvMarca;
import tablas.EtbInvModelo;
import tablas.EtbInvPlataforma;
import tablas.EtbInvRolServidor;
import tablas.EtbInvSalon;
import tablas.EtbInvServidor;
import tablas.EtbInvSisOperativo;

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

    @RequestMapping("pruebas.htm")
    public ModelAndView pruebas(Model model) {

        ModelAndView maw = new ModelAndView();
        maw.setViewName("prueba");
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        int ususidSer = 1;
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
        model.addAttribute("listaEstado", ListaEstado);
        model.addAttribute("listaSis", Listasisope);
        model.addAttribute("listaGrupo", Listagrupo);
        model.addAttribute("listaCentral", ListaCentral);
        model.addAttribute("listaPlat", ListaPrataforma);
        model.addAttribute("listaRol", ListaRolserver);
        model.addAttribute("listaSalon", ListaSalom);
        model.addAttribute("listaModelo", ListaModelo);
        model.addAttribute("listaCliente", ListaCliente);

        EtbInvServidor aa = dao.readid(ususidSer);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("Listaserver", Listaserver);

        model.addAttribute("idser", aa.getSerServer());
        model.addAttribute("serial", aa.getSerSerial());
        model.addAttribute("hostname", aa.getSerHostname());
        model.addAttribute("marca", aa.getMarIdMarca());
        model.addAttribute("modelo", aa.getModIdModelo());
        model.addAttribute("sisoperativo", aa.getSisIdSisOperativo());
        model.addAttribute("conexion", aa.getSerConexion());
        model.addAttribute("estado", aa.getEstIdEstado());
        model.addAttribute("central", aa.getCenIdCentral());
        model.addAttribute("salon", aa.getSalIdSalon());
        model.addAttribute("rack", aa.getSerRack());
        model.addAttribute("unidad", aa.getSerUnidad());
        model.addAttribute("grupo", aa.getGruIdGrupo());
        model.addAttribute("cliente", aa.getCliIdCliente());
        model.addAttribute("proyecto", aa.getSerProyecto());
        model.addAttribute("rolserv", aa.getRolIdRolServ());
        model.addAttribute("plataforma", aa.getPlaIdPlataforma());
        model.addAttribute("fingreso", aa.getSerFIngreso());
        model.addAttribute("tingreso", aa.getSerTIngreso());
        model.addAttribute("npfisicos", aa.getSerNoProcFisico());
        model.addAttribute("foradcompartida", aa.getSerTareaAdCompartida());
        model.addAttribute("adcompartida", aa.getSerAdCompartida());
        model.addAttribute("administrada", aa.getSerAdministrado());
        model.addAttribute("cores", aa.getSerCores());
        model.addAttribute("mem", aa.getServMem());
        model.addAttribute("discoC", aa.getServDiscoC());
        return maw;
    }

    @RequestMapping("prueb.htm")
    public ModelAndView pr(Model model) {
 ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
int ususidSer =1;
        maw.setViewName("user/newjsp");
        EtbInvServidor aa = dao.readid(ususidSer);
        int m = 8;
        model.addAttribute("m", m);
        model.addAttribute("servidor", aa);
        model.addAttribute("direccionamientocoll", aa.getEtbInvDireccionamientoCollection());
        model.addAttribute("aseguramientocoll", aa.getEtbInvAseguramientoCollection());
        model.addAttribute("usuarioservidorcoll", aa.getEtbInvUsuServCollection());
        model.addAttribute("actividadservidorcoll", aa.getEtbInvActividadCollection());
        model.addAttribute("rutaservidorcoll", aa.getEtbInvRutaCollection());
        model.addAttribute("casosprovservidorcoll", aa.getEtbInvCasosProvCollection());
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
    public ModelAndView plataforma(@RequestParam("nplataforma") String nplataforma, @RequestParam("aplataforma") int aplataforma1, Model model) {
        ModelAndView maw = new ModelAndView();
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            maw.setViewName("index");
            return maw;
        }
        maw.setViewName("user/objetos");
        int noj = 4;
        model.addAttribute("noj", noj);
        EtbInvAdmPlataforma aplataforma = new EtbInvAdmPlataforma(aplataforma1);
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
            model.addAttribute("titulo", "Reporte Servidor entre Fechas " + F_Inicio + " y " + F_Fin);
        }
        if (F == 2) {
            maw.setViewName("user/usuarioservidor");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte2(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Usuario Servidor entre Fechas " + F_Inicio + " y " + F_Fin);
        }
        if (F == 3) {
            maw.setViewName("user/cronograma");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte3(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Cronograma entre Fechas " + F_Inicio + " y " + F_Fin);
        }
        if (F == 4) {
            maw.setViewName("user/contratos");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte4(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Cntratos entre Fechas " + F_Inicio + " y " + F_Fin);
        }
        if (F == 5) {
            maw.setViewName("user/aseguramiento");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte5(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Aseguramiento entre Fechas " + F_Inicio + " y " + F_Fin);
        }
        if (F == 6) {
            maw.setViewName("user/actividades");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte6(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte Actividades entre Fechas " + F_Inicio + " y " + F_Fin);
        }
        if (F == 7) {
            maw.setViewName("user/casosproveedor");
            model.addAttribute("m", m);
            List nn = dao.Lisreporte7(F_Inicio, F_Fin);
            model.addAttribute("listreporte", nn);
            model.addAttribute("titulo", "Reporte casos proveedor entre Fechas " + F_Inicio + " y " + F_Fin);
        }
        return maw;
    }

}
