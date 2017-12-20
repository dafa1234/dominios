/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.util.Calendar;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvServidor;
import tablas.EtbInvUsuEstado;
import java.util.List;
import tablas.EtbInvUsuServ;


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
                        @RequestParam("servid") int ususidSer,Model model)
   {
         
         int m = 0;
          model.addAttribute("m", m);
         EtbInvServidor aa = dao.readid(ususidSer);
         String ususServ =aa.getSerSerial();
           Calendar fechaActual = Calendar.getInstance();
            String Fecha = String.format("%04d-%02d-%02d",
              fechaActual.get(Calendar.YEAR),
              fechaActual.get(Calendar.MONTH)+1,
              fechaActual.get(Calendar.DAY_OF_MONTH));
     EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(1);
     EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
     EtbInvServidor ususidServ = new EtbInvServidor(ususidSer);
      dao.crearususerv(Fecha,ususLogin,ususNombre,ususServ,ususEstadoa,ususidServ);
      dao.crearcambioususerv(Fecha,ususLogin,tCambio,ususEstado);
       List<EtbInvUsuServ> Listaususerv  = dao.Listaususerv(ususEstadoa);           
          model.addAttribute("Listaususerv", Listaususerv); 
       return "user/usuarioservidor";
   }
    
}
