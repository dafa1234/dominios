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
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvEstadoMto;
import tablas.EtbInvProyecto;


/**
 *
 * @author diegfraa
 */
@Controller
@RequestMapping("/crono.htm")
public class crearcronograma {
          @Autowired
    private iniciosecion dao;
@RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno(){     
        return "index";   
    }
   @RequestMapping(method = RequestMethod.POST)  
   public String createcronograma(                   
                      @RequestParam("proyecto") Integer croProyect,
                      @RequestParam("servidor") String croSerial,
                      @RequestParam("fini") String croFechaIni,                   
                      @RequestParam("estini") Integer croEstad,
                      @RequestParam("ejecuta") String croEjecuta,
                      @RequestParam("cambio") String croCambioFin                     
                      , Model model ) throws ServicioException{
               EtbInvProyecto croProyecto = new EtbInvProyecto(croProyect);
               EtbInvEstadoMto croEstado = new EtbInvEstadoMto(croEstad);
               dao.creacrono(croProyecto,croFechaIni,croSerial,croEjecuta,croCambioFin,croEstado);   
               
               List<EtbInvCronogramaMto> ListaCrono  = dao.ListaCrono();           
          model.addAttribute("listaCrono", ListaCrono); 
                return "user/cronograma";

    }
    
}