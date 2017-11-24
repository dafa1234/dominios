/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import java.util.Calendar;
import modelo.ServicioException;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvEstado;
import tablas.EtbInvGrupo;
import tablas.EtbInvMarca;
import tablas.EtbInvServidor;
import tablas.EtbInvSisOperativo;
/**
 *
 * @author diegfraa
 */    
@Controller
@RequestMapping("/creat.htm")
public class crearserver {

    
    @Autowired
    private iniciosecion dao;
   
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno(){     
        return "index";   
    }
   @RequestMapping(method = RequestMethod.POST)    
   public String create(
                      @RequestParam("serial") String serSerial,
                      @RequestParam("marca") int marIdMarc,
                      @RequestParam("estado") int estIdEstad,
                      @RequestParam("sisoperativo") int sisoperativo,
                      @RequestParam("hostname") String serHostname,
                      @RequestParam("modelo") int modIdModelo ,
                      @RequestParam("grupo") int grupo,
                      @RequestParam("prosesos") Integer serNoProcFisico,
                      @RequestParam("cores") String serCores ,
                      @RequestParam("conexion") String serConexion,
                      @RequestParam("central") int cenIdCentral,
                      @RequestParam("dc") int salIdSalon,
                      @RequestParam("rack") String serRack,
                      @RequestParam("unidad") String serUnidad,
                      @RequestParam("plataforma") int plaIdPlataforma,
                      @RequestParam("proyecto") String serProyecto,
                      @RequestParam("cliente") int cliIdCliente,
                      @RequestParam("adplataforma") String serAdministrado,
                      @RequestParam("rol") int rolIdRolServ,
                      @RequestParam("addominios") String serForAdCompartida,
                      @RequestParam("tarea") String serTIngreso                
                      , Model model ) throws ServicioException{
          
           Calendar fechaActual = Calendar.getInstance();
            String Fecha = String.format("%04d-%02d-%02d",
              fechaActual.get(Calendar.YEAR),
              fechaActual.get(Calendar.MONTH)+1,
              fechaActual.get(Calendar.DAY_OF_MONTH));
            
            //base de datos
             
               EtbInvEstado estIdEstado = new EtbInvEstado( estIdEstad);
               EtbInvSisOperativo sisIdSisOperativo = new EtbInvSisOperativo(sisoperativo);
               EtbInvGrupo gruIdGrupo = new EtbInvGrupo(grupo);
               EtbInvMarca marIdMarca = new EtbInvMarca(marIdMarc);           
               dao.create(Fecha,serSerial,serHostname,marIdMarca,modIdModelo,serConexion,cenIdCentral,salIdSalon,cliIdCliente,rolIdRolServ,plaIdPlataforma,serForAdCompartida,serAdministrado,serCores,serTIngreso,serUnidad,serProyecto,serRack,serNoProcFisico,estIdEstado,sisIdSisOperativo,gruIdGrupo);   
 List<EtbInvServidor> Listaserver  = dao.Listaserver();                       
          model.addAttribute("listaServer", Listaserver);   
                return "user/servers";

    }
}
