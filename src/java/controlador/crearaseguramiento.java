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
@RequestMapping("/aseg.htm")
public class crearaseguramiento {
       @Autowired
    private iniciosecion dao;
@RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno(){     
        return "index";   
    }
   @RequestMapping(method = RequestMethod.POST)  
   public String createaseguram(                   
                      @RequestParam("serv") String aseServidor,
                      @RequestParam("eje") String aseEjecuta,
                      @RequestParam("tarea") String aseTarea,                   
                      @RequestParam("serial") String actSolicita,
                      @RequestParam("plantilla") Integer actTipo,
                      @RequestParam("fini") Date aseFecha
                      , Model model ) throws ServicioException{
          

               dao.crease(aseTarea,aseServidor,aseEjecuta,aseFecha);   

                return "user/aseguramiento";

    }
}