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
@RequestMapping("/caprov.htm")
public class crearcasosproveedor {
     @Autowired
    private iniciosecion dao;
   
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno(){     
        return "index";   
    }
   @RequestMapping(method = RequestMethod.POST)    
   public String create(                   
                      @RequestParam("proveedor") Integer caspProv,
                      @RequestParam("servidor") String caspServ,
                      @RequestParam("fini") String caspFechaApe,
                      @RequestParam("fcie") String caspFechaCie,
                      @RequestParam("estini") Integer caspEstado,
                      @RequestParam("numcas") String caspNumero,
                      @RequestParam("im") String caspIm                     
                      , Model model ) throws ServicioException{
          
    
            
            //base de datos
    
               
               dao.creaproveedor(caspProv,caspServ,caspFechaApe,caspFechaCie,caspNumero,caspIm,caspEstado);   

                return "user/casosproveedor";

    }
}