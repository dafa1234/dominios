/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import modelo.ServicioException;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvCambioTabla;
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
import tablas.EtbInvTablaDominios;
import tablas.EtbInvUsuarioAp;

/**
 *
 * @author diegfraa
 */
@Controller

public class crearserver {

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
 * aqui agregamos servidor
 * @param serSerial
 * @param marIdMarc
 * @param estIdEstad
 * @param sisoperativo
 * @param serHostname
 * @param modIdModel
 * @param grupo
 * @param serNoProcFisico
 * @param serCores
 * @param serConexion
 * @param cenIdCentra
 * @param salIdSalo
 * @param serRack
 * @param serUnidad
 * @param plaIdPlataform
 * @param serProyecto
 * @param cliIdClient
 * @param serAdministrado
 * @param rolIdRolSer
 * @param serForAdCompartida
 * @param serTIngreso
 * @param servMem
 * @param servDiscoC
 * @param SER_AD_COMPARTIDA
 * @param model
 * @return
 * @throws ServicioException 
 */
    //para ingresar servidores
    @RequestMapping("/creat.htm")
    public String create(
            @RequestParam("serial") String serSerial,
            @RequestParam("marca") int marIdMarc,
            @RequestParam("estado") int estIdEstad,
            @RequestParam("sisoperativo") int sisoperativo,
            @RequestParam("hostname") String serHostname,
            @RequestParam("modelo") int modIdModel,
            @RequestParam("grupo") int grupo,
            @RequestParam("prosesos") Integer serNoProcFisico,
            @RequestParam("cores") int serCores,
            @RequestParam("conexion") String serConexion,
            @RequestParam("central") int cenIdCentra,
            @RequestParam("dc") int salIdSalo,
            @RequestParam("rack") String serRack,
            @RequestParam("unidad") String serUnidad,
            @RequestParam("plataforma") int plaIdPlataform,
            @RequestParam("proyecto") String serProyecto,
            @RequestParam("cliente") int cliIdClient,
            @RequestParam("adplataforma") int serAdministrado,
            @RequestParam("rol") int rolIdRolSer,
            @RequestParam("addominios") String serForAdCompartida,
            @RequestParam("tarea") String serTIngreso,
            @RequestParam("servMem") int servMem,
            @RequestParam("servDiscoC") int servDiscoC,
            @RequestParam("SER_AD_COMPARTIDA") int SER_AD_COMPARTIDA,
            Model model) throws ServicioException {

        //base de datos
        int m = 0;
        model.addAttribute("m", m);
        EtbInvEstado estIdEstado = new EtbInvEstado(estIdEstad);
        EtbInvSisOperativo sisIdSisOperativo = new EtbInvSisOperativo(sisoperativo);
        EtbInvGrupo gruIdGrupo = new EtbInvGrupo(grupo);
        EtbInvMarca marIdMarca = new EtbInvMarca(marIdMarc);
        EtbInvModelo modIdModelo = new EtbInvModelo(modIdModel);
        EtbInvCliente cliIdCliente = new EtbInvCliente(cliIdClient);
        EtbInvSalon salIdSalon = new EtbInvSalon(salIdSalo);
        EtbInvRolServidor rolIdRolServ = new EtbInvRolServidor(rolIdRolSer);
        EtbInvCentral cenIdCentral = new EtbInvCentral(cenIdCentra);
        EtbInvPlataforma plaIdPlataforma = new EtbInvPlataforma(plaIdPlataform);

        dao.create(SER_AD_COMPARTIDA, Fecha, serSerial, serHostname, marIdMarca, modIdModelo, serConexion, cenIdCentral, salIdSalon, cliIdCliente, rolIdRolServ, plaIdPlataforma, serForAdCompartida, serAdministrado, serCores, serTIngreso, serUnidad, serProyecto, serRack, serNoProcFisico, estIdEstado, sisIdSisOperativo, gruIdGrupo, servMem, servDiscoC);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("listaServer", Listaserver);
        return "user/servers";

    }
    /**
     * aqui dirigimos a lista de servidores
     * @param model
     * @return 
     */
    //SERVIDORES

    @RequestMapping("servers.htm")
    public String server(Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        int m = 0;
        model.addAttribute("m", m);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("listaServer", Listaserver);
        return "user/servers";
    }
/**
 * aqui dirigimos al formulario de agregar servidores
 * @param model
 * @return 
 */
// formulario agregar servidor
    @RequestMapping("aserver.htm")
    public String agser(Model model) {
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
        model.addAttribute("listaEstado", ListaEstado);
        model.addAttribute("listaSis", Listasisope);
        model.addAttribute("listaGrupo", Listagrupo);
        model.addAttribute("listaCentral", ListaCentral);
        model.addAttribute("listaPlat", ListaPrataforma);
        model.addAttribute("listaRol", ListaRolserver);
        model.addAttribute("listaSalon", ListaSalom);
        model.addAttribute("listaModelo", ListaModelo);
        model.addAttribute("listaCliente", ListaCliente);
        model.addAttribute("m", m);
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        return "user/servers";
    }
/**
 * aqui dirigimos a la lista de detalle de servidor
 * @param ususidSer
 * @param model
 * @return 
 */
    // detalle servidor
    @RequestMapping("TdServ.htm")
    public String tdserver(@RequestParam("tdserv") Integer ususidSer, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        EtbInvServidor aa = dao.readid(ususidSer);
        int m = 8;
        model.addAttribute("m", m);
        model.addAttribute("servidor", aa);
        return "user/servers";

    }
/**
 * aqui dirigimos al formulario de modificar servidor
 * @param ususidSer
 * @param model
 * @return 
 */
    // modificar servidor
    @RequestMapping("modificarservidor.htm")
    public String modificarservidor(@RequestParam("tdserv") Integer ususidSer, Model model) {
        String id = (String) request.getSession().getAttribute("name");
        if (id == null) {
            return "index";
        }
        List<EtbInvEstado> ListaEstado = dao.ListaEstado();
        List<EtbInvSisOperativo> Listasisope = dao.Listasisope();
        List<EtbInvGrupo> Listagrupo = dao.Listagrupo();
        List<EtbInvCentral> ListaCentral = dao.ListaCentral();
        List<EtbInvPlataforma> ListaPrataforma = dao.ListaPrataforma();
        List<EtbInvRolServidor> ListaRolserver = dao.ListaRolserver();
        List<EtbInvSalon> ListaSalom = dao.ListaSalom();
        List<EtbInvCliente> ListaCliente = dao.ListaCliente();
        model.addAttribute("listaEstado", ListaEstado);
        model.addAttribute("listaSis", Listasisope);
        model.addAttribute("listaGrupo", Listagrupo);
        model.addAttribute("listaCentral", ListaCentral);
        model.addAttribute("listaPlat", ListaPrataforma);
        model.addAttribute("listaRol", ListaRolserver);
        model.addAttribute("listaSalon", ListaSalom);
        model.addAttribute("listaCliente", ListaCliente);
        EtbInvServidor aa = dao.readid(ususidSer);
        int m = 2;
        model.addAttribute("m", m);
        model.addAttribute("servidor", aa);
        return "user/cosasservidor";

    }
/**
 * aqui modificamos servidor
 * @param idservidor
 * @param hostnameservidor
 * @param sisopreaservidor
 * @param conexionservidor
 * @param estadoservidor
 * @param centralservidor
 * @param salonservidor
 * @param rackservidor
 * @param unidadservidor
 * @param gruposervidor
 * @param clienteservidor
 * @param proyectoservidor
 * @param rolservidor
 * @param plataformaservidor
 * @param Nprocesosservidor
 * @param adcompservidor
 * @param admiservidor
 * @param coresservidor
 * @param memservidor
 * @param discocservidor
 * @param tareacambio
 * @param model
 * @return
 * @throws ServicioException 
 */
    //modificar servidor
    @RequestMapping("/modificarserv.htm")
    public String create(
            @RequestParam("idservidor") int idservidor,
            @RequestParam("hostnameservidor") String hostnameservidor,
            @RequestParam("sisopreaservidor") int sisopreaservidor,
            @RequestParam("conexionservidor") String conexionservidor,
            @RequestParam("estadoservidor") int estadoservidor,
            @RequestParam("centralservidor") int centralservidor,
            @RequestParam("salonservidor") int salonservidor,
            @RequestParam("rackservidor") String rackservidor,
            @RequestParam("unidadservidor") String unidadservidor,
            @RequestParam("gruposervidor") int gruposervidor,
            @RequestParam("clienteservidor") int clienteservidor,
            @RequestParam("proyectoservidor") String proyectoservidor,
            @RequestParam("rolservidor") int rolservidor,
            @RequestParam("plataformaservidor") int plataformaservidor,
            @RequestParam("Nprocesosservidor") int Nprocesosservidor,
            @RequestParam("adcompservidor") int adcompservidor,
            @RequestParam("admiservidor") int admiservidor,
            @RequestParam("coresservidor") int coresservidor,
            @RequestParam("memservidor") int memservidor,
            @RequestParam("discocservidor") int discocservidor,
            @RequestParam("tareacambio") String tareacambio,
            Model model) throws ServicioException {    
        EtbInvTablaDominios tabladominios = new EtbInvTablaDominios(27);
        String cam_tab_descripcion_SM = "1";
        String cam_tab_solicitante_SM = "1";
        int usuarioetb1 = (int) request.getSession().getAttribute("idusuap");
         EtbInvUsuarioAp usuarioetb = new EtbInvUsuarioAp(usuarioetb1);
        dao.llenarbitacora(tabladominios, idservidor, usuarioetb, FechaH, tareacambio, cam_tab_descripcion_SM, cam_tab_solicitante_SM);
        EtbInvServidor aa = dao.readid(idservidor);
        EtbInvCambioTabla camt = dao.idcambiotabla(tabladominios, idservidor, usuarioetb, tareacambio);
        EtbInvCambioTabla CamIdtabla = new EtbInvCambioTabla(camt.getCamtabID());
     
        String CamNawValor = "";
        String CamValorIni = "";
        if (!aa.getSerHostname().equals(hostnameservidor)) {
            String CamColumna = "SER_HOSTNAME";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getSisIdSisOperativo().getSisIdSisOperativo() != sisopreaservidor) {
            String CamColumna = "SIS_ID_SIS_OPERATIVO";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getSerConexion().equals(conexionservidor)) {
            String CamColumna = "SER_CONEXION";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getEstIdEstado().getEstIdEstado() != estadoservidor) {
            String CamColumna = "EST_ID_ESTADO";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getCenIdCentral().getCenIdCentral() != centralservidor) {
            String CamColumna = "CEN_ID_CENTRAL";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getSalIdSalon().getSalIdSalon() != salonservidor) {
            String CamColumna = "CEN_ID_CENTRAL";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getSerRack().equals(rackservidor)) {
            String CamColumna = "SER_RACK";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getSerUnidad().equals(unidadservidor)) {
            String CamColumna = "SER_UNIDAD";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getGruIdGrupo().getGruIdGrupo() != gruposervidor) {
            String CamColumna = "GRU_ID_GRUPO";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getCliIdCliente().getCliIdCliente() != clienteservidor) {
            String CamColumna = "CLI_ID_CLIENTE";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (!aa.getSerProyecto().equals(proyectoservidor)) {
            String CamColumna = "SER_PROYECTO";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getRolIdRolServ().getRolIdRolServ() != rolservidor) {
            String CamColumna = "ROL_ID_ROL_SERV";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getPlaIdPlataforma().getPlaIdPlataforma() != plataformaservidor) {
            String CamColumna = "PLA_ID_PLATAFORMA";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getSerNoProcFisico() != Nprocesosservidor) {
            String CamColumna = "SER_NO_PROC_FISICO";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getSerAdCompartida() != adcompservidor) {
            String CamColumna = "SER_AD_COMPARTIDA";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getSerAdministrado() != admiservidor) {
            String CamColumna = "SER_ADMINISTRADO";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getSerCores() != coresservidor) {
            String CamColumna = "SER_CORES";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getServMem() != memservidor) {
            String CamColumna = "SERV_MEM";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        if (aa.getServDiscoC() != discocservidor) {
            String CamColumna = "SERV_DISCO_C";

            dao.llenarbitacoradetalle(CamColumna, CamNawValor, CamValorIni, CamIdtabla);
        }
        //base de datos
        int m = 0;
        model.addAttribute("m", m);
        EtbInvEstado estIdEstado = new EtbInvEstado(estadoservidor);
        EtbInvSisOperativo sisIdSisOperativo = new EtbInvSisOperativo(sisopreaservidor);
        EtbInvGrupo gruIdGrupo = new EtbInvGrupo(gruposervidor);
        EtbInvMarca marIdMarc = new EtbInvMarca(aa.getMarIdMarca().getMarIdMarca());
        EtbInvModelo modIdModel = new EtbInvModelo(aa.getModIdModelo().getModIdModelo());
        EtbInvCliente cliIdCliente = new EtbInvCliente(clienteservidor);
        EtbInvSalon salIdSalon = new EtbInvSalon(salonservidor);
        EtbInvRolServidor rolIdRolServ = new EtbInvRolServidor(rolservidor);
        EtbInvCentral cenIdCentral = new EtbInvCentral(centralservidor);
        EtbInvPlataforma plaIdPlataforma = new EtbInvPlataforma(plataformaservidor);

        dao.updateservidor(idservidor, aa.getSerSerial(), hostnameservidor, conexionservidor, marIdMarc, modIdModel, rackservidor, cenIdCentral, salIdSalon, cliIdCliente, rolIdRolServ, plaIdPlataforma, unidadservidor, proyectoservidor,aa.getSerFIngreso() ,aa.getSerTIngreso() , Nprocesosservidor,aa.getSerTareaAdCompartida(), adcompservidor, admiservidor, estIdEstado, sisIdSisOperativo, gruIdGrupo, coresservidor, memservidor, discocservidor);
        List<EtbInvServidor> Listaserver = dao.Listaserver();
        model.addAttribute("listaServer", Listaserver);
        return "user/servers";

    }

}
