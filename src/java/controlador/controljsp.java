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
    public String pruebas(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }

        return "prueba";
    }

    @RequestMapping("prueb.htm")
    public String pr(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }

        return "user/newjsp";

    }

    //USUARIO AP
    @RequestMapping("buscar.htm")
    public String bus(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("Listaserver", Listaserver);
        return "buscar";
    }

    //central
    @RequestMapping("ncentral.htm")
    public String nCentral(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 1;
        List<EtbInvCentral> ListaCentral = dao.ListaCentral();
        model.addAttribute("listaCentral", ListaCentral);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }
//central

    @RequestMapping("central.htm")
    public String Central(@RequestParam("central") String Central, Model model) {
        int noj = 1;
        model.addAttribute("noj", noj);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        dao.newcentral(Central);
        List<EtbInvCentral> ListaCentral = dao.ListaCentral();
        model.addAttribute("listaCentral", ListaCentral);
        return "user/objetos";
    }

    //grupo
    @RequestMapping("ngrupo.htm")
    public String nGrupo(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 2;
        List<EtbInvGrupo> Listagrupo = dao.Listagrupo();
        model.addAttribute("listaGrupo", Listagrupo);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }

    @RequestMapping("grupo.htm")
    public String Grupo(@RequestParam("ngrupo") String Ngrupo, @RequestParam("tgrupo") String Tgrupo, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 2;
        model.addAttribute("noj", noj);
        dao.newgrupo(Ngrupo, Tgrupo);
        List<EtbInvGrupo> Listagrupo = dao.Listagrupo();
        model.addAttribute("listaGrupo", Listagrupo);
        return "user/objetos";
    }

    //marca
    @RequestMapping("nmarca.htm")
    public String nmarca(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 3;
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        model.addAttribute("listaFonos", ListaMarca);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }

    @RequestMapping("marca.htm")
    public String marca(@RequestParam("nmarca") String nmarca, @RequestParam("usoporte") String usoporte,
            @RequestParam("tsoporte") String tsoporte, @RequestParam("minterventor") String minterventor, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 3;
        model.addAttribute("noj", noj);
        dao.newmarca(nmarca, usoporte, tsoporte, minterventor);
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        model.addAttribute("listaFonos", ListaMarca);
        return "user/objetos";
    }

    //plataforma
    @RequestMapping("nplataforma.htm")
    public String nplataforma(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 4;
        List<EtbInvPlataforma> ListaPrataforma = dao.ListaPrataforma();
        model.addAttribute("listaPlat", ListaPrataforma);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }

    @RequestMapping("plataforma.htm")
    public String plataforma(@RequestParam("nplataforma") String nplataforma, @RequestParam("aplataforma") int aplataforma1, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 4;
        model.addAttribute("noj", noj);
        EtbInvAdmPlataforma aplataforma = new EtbInvAdmPlataforma(aplataforma1);
        dao.newplataforma(nplataforma, aplataforma);
        List<EtbInvPlataforma> ListaPrataforma = dao.ListaPrataforma();
        model.addAttribute("listaPlat", ListaPrataforma);
        return "user/objetos";
    }

    //rolserv
    @RequestMapping("nrolserv.htm")
    public String nuevorolserv(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 5;
        List<EtbInvRolServidor> ListaRolserver = dao.ListaRolserver();
        model.addAttribute("listaRol", ListaRolserver);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }

    @RequestMapping("rolserv.htm")
    public String rolserv(@RequestParam("nrol") String nrol, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 5;
        model.addAttribute("noj", noj);
        dao.newrol(nrol);
        List<EtbInvRolServidor> ListaRolserver = dao.ListaRolserver();
        model.addAttribute("listaRol", ListaRolserver);
        return "user/objetos";
    }

    //sisoper
    @RequestMapping("nsisopera.htm")
    public String nsisoper(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 6;
        List<EtbInvSisOperativo> Listasisope = dao.Listasisope();
        model.addAttribute("listaSis", Listasisope);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }

    @RequestMapping("sisopera.htm")
    public String sisoper(@RequestParam("sisdis") int sisdis, @RequestParam("nsis") String nsis, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 6;
        model.addAttribute("noj", noj);
        dao.newsisoperativo(sisdis, nsis);
        List<EtbInvSisOperativo> Listasisope = dao.Listasisope();
        model.addAttribute("listaSis", Listasisope);
        return "user/objetos";
    }
    //estado

    @RequestMapping("nestado.htm")
    public String nestado(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 7;
        List<EtbInvEstado> ListaEstado = dao.ListaEstado();
        model.addAttribute("listaEstado", ListaEstado);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }

    @RequestMapping("estado.htm")
    public String estado(@RequestParam("nest") String nest, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 7;
        model.addAttribute("noj", noj);
        dao.newestado(nest);
        List<EtbInvEstado> ListaEstado = dao.ListaEstado();
        model.addAttribute("listaEstado", ListaEstado);
        return "user/objetos";
    }
    //salon

    @RequestMapping("nsalon.htm")
    public String nsalon(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 8;
        List<EtbInvSalon> ListaSalom = dao.ListaSalom();
        model.addAttribute("listaSalon", ListaSalom);
        List<EtbInvCentral> ListaCentral = dao.ListaCentral();
        model.addAttribute("noj", noj);
        model.addAttribute("listaCentral", ListaCentral);
        return "user/objetos";
    }

    @RequestMapping("salon.htm")
    public String salon(@RequestParam("scen") int scen1, @RequestParam("nsal") String nsal, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 8;
        EtbInvCentral scen = new EtbInvCentral(scen1);
        List<EtbInvSalon> ListaSalom = dao.ListaSalom();
        model.addAttribute("listaSalon", ListaSalom);
        List<EtbInvCentral> ListaCentral = dao.ListaCentral();
        model.addAttribute("noj", noj);
        model.addAttribute("listaCentral", ListaCentral);
        dao.newsalon(scen, nsal);
        return "user/objetos";
    }

    //modelo
    @RequestMapping("nmodelo.htm")
    public String nmodelo(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 9;
        List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvModelo> ListaModelo = dao.ListaModelo();
        model.addAttribute("noj", noj);
        model.addAttribute("listaModelo", ListaModelo);
        model.addAttribute("listaMarca", ListaMarca);
        return "user/objetos";
    }

    @RequestMapping("modelo.htm")
    public String modelo(@RequestParam("nmar") int nmar1, @RequestParam("nmod") String nmod, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 9;
        EtbInvMarca nmar = new EtbInvMarca(nmar1);
       List<EtbInvMarca> ListaMarca = dao.ListaMarca();
        List<EtbInvModelo> ListaModelo = dao.ListaModelo();
        model.addAttribute("noj", noj);
        model.addAttribute("listaModelo", ListaModelo);
        model.addAttribute("listaMarca", ListaMarca);
        dao.newmodelo(nmar, nmod);
        return "user/objetos";
    }

    //cliente
    @RequestMapping("ncliente.htm")
    public String ncliente(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 10;
        List<EtbInvCliente> ListaCliente = dao.ListaCliente();
        model.addAttribute("listaCliente", ListaCliente);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }

    @RequestMapping("cliente.htm")
    public String cliente(@RequestParam("ncli") String ncli, @RequestParam("ccli") String ccli, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 10;
        model.addAttribute("noj", noj);
        dao.newcliente(ncli, ccli);
        List<EtbInvCliente> ListaCliente = dao.ListaCliente();
        model.addAttribute("listaCliente", ListaCliente);
        return "user/objetos";
    }

    //ADMINISTRADOR
    @RequestMapping("fono.htm")
    public String administrador(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("Listaserver", Listaserver);
        return "administrador";
    }

    //CERRAR SESION
    @RequestMapping("cerrarsesion.htm")
    public String cerrarsesion() {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        return "cerrarsesion";
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
