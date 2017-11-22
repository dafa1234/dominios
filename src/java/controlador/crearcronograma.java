/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.sql.Date;
import modelo.ServicioException;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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
                      @RequestParam("proyecto") Integer croProyecto,
                      @RequestParam("servidor") String croSerial,
                      @RequestParam("fini") Date croFechaIni,                   
                      @RequestParam("estini") Integer croEstado,
                      @RequestParam("ejecuta") String croEjecuta,
                      @RequestParam("cambio") String croCambioFin                     
                      , Model model ) throws ServicioException{

               dao.creacrono(croProyecto,croFechaIni,croSerial,croEjecuta,croCambioFin,croEstado);   
                return "user/cronograma";

    }
    
}