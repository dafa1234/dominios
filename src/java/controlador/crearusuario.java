/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvUsuEstado;


/**
 *
 * @author diegfraa
 */
@Controller
@RequestMapping("/usuario.htm")
public class crearusuario {
     @Autowired
    private iniciosecion dao;
      @RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno(){     
        return "index";   
    }
     @RequestMapping(method = RequestMethod.POST)    
   public String create(@RequestParam("login") String ususLogin,
                        @RequestParam("nombre") String ususNombre,
                        @RequestParam("tarea") String tCambio,
                        @RequestParam("serv") String ususServ,Model model)
   {
         int ususEstad = 1;
     EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(ususEstad);
      dao.crearususerv(ususLogin,ususNombre,ususServ,ususEstado);
      dao.crearcambioususerv(ususLogin,tCambio,ususEstado);
       return "user/usuarioservidor";
   }
    
}
