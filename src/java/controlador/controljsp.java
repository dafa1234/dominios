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
// utilizando el private conectamos con la clase iniciosecion 
    @Autowired
    private iniciosecion dao;
    @Autowired
    private HttpServletRequest request;
    Calendar fechaActual = Calendar.getInstance();
    String Fecha = String.format("%04d-%02d-%02d",
            fechaActual.get(Calendar.YEAR),
            fechaActual.get(Calendar.MONTH) + 1,
            fechaActual.get(Calendar.DAY_OF_MONTH));
/**
 * este es un controlador de pruebas
 * @param model
 * @return 
 */
    @RequestMapping("pruebas.htm")
    public String pruebas(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }

        return "prueba";
    }
/**
 * este es un controlador de pruebas
 * @param model
 * @return 
 */
    @RequestMapping("prueb.htm")
    public String pr(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }

        return "user/newjsp";

    }
/**
 * en bus nos direciona al inicio de usuario
 * @param model
 * @return 
 */
    //USUARIO AP
    @RequestMapping("buscar.htm")
    public String bus(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        //por medio del ( dao.Listaserver()) nos devuelbe la lista de los servidore
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        //utilizando (List<EtbInvServidor> Listaserver) y enviamos la informacion ppor medio (model.addAttribute)
        model.addAttribute("Listaserver", Listaserver);
        return "buscar";
    }
/**
 * nCentral nos direciona al formulario para crear una nueva central
 * @param model
 * @return 
 */
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
    /**
     * en Central se ingresa la nueva Central
     * @param Central
     * @param model
     * @return 
     */
//central

    @RequestMapping("central.htm")
    public String Central(@RequestParam("central") String Central, Model model) {
        int noj = 1;
        model.addAttribute("noj", noj);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        //por medio de (dao.newcentral(Central)) ingresamos una nueva central
        dao.newcentral(Central);
        List<EtbInvCentral> ListaCentral = dao.ListaCentral();
        model.addAttribute("listaCentral", ListaCentral);
        return "user/objetos";
    }
/**
 * nGrupo nos direciona al formulario para crear una nueva grupo
 * @param model
 * @return 
 */
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
/**
 * en Grupo se ingresa la nueva Grupo
 * @param Ngrupo
 * @param Tgrupo
 * @param model
 * @return 
 */
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
/**
 * nmarca nos direciona al formulario para crear una nueva marca
 * @param model
 * @return 
 */
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
/**
 * en marca se ingresa la nueva marca
 * @param nmarca
 * @param usoporte
 * @param tsoporte
 * @param minterventor
 * @param model
 * @return 
 */
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
/**
 * nplataforma nos direciona al formulario para crear una nueva plataforma
 * @param model
 * @return 
 */
    //plataforma
    @RequestMapping("nplataforma.htm")
    public String nplataforma(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 4;
        List<EtbInvAdmPlataforma> listaAdmPlataforma = dao.listaAdmPlataforma();
        model.addAttribute("listaAdmPlataforma", listaAdmPlataforma);
        List<EtbInvPlataforma> ListaPrataforma = dao.ListaPrataforma();
        model.addAttribute("listaPlat", ListaPrataforma);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }
/**
 * en plataforma se ingresa la nueva plataforma
 * @param nplataforma
 * @param aplataforma1
 * @param model
 * @return 
 */
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
/**
 * nrolserv nos direciona al formulario para crear un nuevo rol de servidor
 * @param model
 * @return 
 */
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
/**
 * en rolserv se ingresa la nueva rol
 * @param nrol
 * @param model
 * @return 
 */
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
/**
 * nsisopera nos direciona al formulario para crear un nuevo sistema operativo
 * @param model
 * @return 
 */
    
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
/**
 * en sisoper se ingresa la nueva sistema operativo
 * @param sisdis
 * @param nsis
 * @param model
 * @return 
 */
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
    /**
     * nestado nos direciona al formulario para crear un nuevo estado
     * @param model
     * @return 
     */
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
/**
 * en estado se ingresa la nueva estado
 * @param nest
 * @param model
 * @return 
 */
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
    /**
     * nsalon nos direciona al formulario para crear un nuevo salon
     * @param model
     * @return 
     */
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
/**
 * en salon se ingresa la nueva salon
 * @param scen1
 * @param nsal
 * @param model
 * @return 
 */
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
/**
 * nmodelo nos direciona al formulario para crear un nuevo modelo
 * @param model
 * @return 
 */
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
/**
 * en modelo se ingresa la nueva modelo
 * @param nmar1
 * @param nmod
 * @param model
 * @return 
 */
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
/**
 * ncliente nos direciona al formulario para crear un nuev cliente
 * @param model
 * @return 
 */
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
/**
 * en cliente se ingresa la nueva cliente
 * @param ncli
 * @param ccli
 * @param model
 * @return 
 */
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
    /**
     * nadminiplataforma nos direciona al formulario para crear un nuevo administrador de plataforma
     * @param model
     * @return 
     */
     //administrador plataforma
    @RequestMapping("nadminiplataforma.htm")
    public String nadminiplataforma(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 11;
        List<EtbInvAdmPlataforma> listaAdmPlataforma = dao.listaAdmPlataforma();
        model.addAttribute("listaAdmi", listaAdmPlataforma);
        model.addAttribute("noj", noj);
        return "user/objetos";
    }
/**
 * en administradorpla se ingresa la nueva administrador plataforma
 * @param nombre
 * @param telefono
 * @param area
 * @param correo
 * @param model
 * @return 
 */
    @RequestMapping("administradorpla.htm")
    public String administradorpla(@RequestParam("nombre") String nombre, @RequestParam("telefono") String telefono,
                                   @RequestParam("area") String area,@RequestParam("correo") String correo,Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int noj = 11;
        model.addAttribute("noj", noj);
        dao.newadminispla(area,  correo, nombre,  telefono);
         List<EtbInvAdmPlataforma> listaAdmPlataforma = dao.listaAdmPlataforma();
        model.addAttribute("listaAdmi", listaAdmPlataforma);
        return "user/objetos";
    }
/**
 * administrador nos direcciona al inicio de administrador
 * @param model
 * @return 
 */
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
/**
 * cerrarsesion nos direcciona al jsp de cerrar sesion
 * @return 
 */
    //CERRAR SESION
    @RequestMapping("cerrarsesion.htm")
    public String cerrarsesion() {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        return "cerrarsesion";
    }
/**
 * en serverreport nos envia al iniciosecion.java para buscar en las diferentes tablas
 * segun la informacion de los parametros y crear los reportes sesgun la tabla y la fecha
 * @param F_Inicio
 * @param F_Fin
 * @param F
 * @param model
 * @return
 * @throws FileNotFoundException
 * @throws IOException
 * @throws SQLException 
 */
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
        // en este if segun la informacion que traiga (@RequestParam("F") int F) entrara a uno de los prosesos
        //y este creara el reporte segun la tabla y las fecha estabresidas
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
