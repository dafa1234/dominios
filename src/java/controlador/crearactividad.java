/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.util.List;
import modelo.ServicioException;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvActividad;
import tablas.EtbInvTipoActividad;


/**
 *
 * @author diegfraa
 */
@Controller
@RequestMapping("/act.htm")
public class crearactividad {
     @Autowired
    private iniciosecion dao;
   
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno(){     
        return "index";   
    }
   @RequestMapping(method = RequestMethod.POST)    
   public String create(                   
                      @RequestParam("serv") String actServ,
                      @RequestParam("eje") String actEjecuta,
                      @RequestParam("tarea") String actTarea,
                      @RequestParam("desc") String actDescripcion,
                      @RequestParam("sol") String actSolicita,
                      @RequestParam("tipo") Integer actTip,
                      @RequestParam("fini") String actFechaIni,
                      @RequestParam("ffin") String actFechaFin  
                      , Model model ) throws ServicioException{
          
    
            
            //base de datos
     EtbInvTipoActividad actTipo = new EtbInvTipoActividad( actTip);
               
               dao.creact( actServ,  actEjecuta,  actTarea,  actDescripcion,  actSolicita, actTipo,actFechaFin,actFechaIni );   
List<EtbInvActividad> ListaActividad  = dao.ListaActividad();                  
          model.addAttribute("listaActividad", ListaActividad); 
                return "user/actividades";

    }
}
