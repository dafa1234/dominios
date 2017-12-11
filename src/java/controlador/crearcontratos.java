/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.sql.Date;
import java.util.List;
import modelo.ServicioException;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvContrato;
import tablas.EtbInvEstadoCont;
import tablas.EtbInvMarca;
import tablas.EtbInvTipoCont;

/**
 *
 * @author diegfraa
 */
@Controller
@RequestMapping("/contr.htm")
public class crearcontratos {
         @Autowired
    private iniciosecion dao;

    @RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno(){     
        return "index";   
    }
   @RequestMapping(method = RequestMethod.POST)    
   public String create(                   
                      @RequestParam("proveedor") Integer contPro,
                      @RequestParam("ticon") Integer contTip,
                      @RequestParam("fini") String contFechaIni,                   
                      @RequestParam("ffin") String contFechaFin,
                      @RequestParam("nocon") String contNum,
                      @RequestParam("estado") Integer contEstad,
                      @RequestParam("login") String contLogin,
                      @RequestParam("descripcion") String contDescrip
                      , Model model) throws ServicioException{
               EtbInvMarca contProv = new EtbInvMarca(contPro);
               EtbInvTipoCont contTipo = new EtbInvTipoCont(contTip);
               EtbInvEstadoCont contEstado = new EtbInvEstadoCont(contEstad);
               dao.creacont(contProv,contTipo,contFechaIni,contFechaFin,contNum,contEstado,contLogin,contDescrip);   
List<EtbInvContrato> ListaContra  = dao.ListaContra();   
          model.addAttribute("listaContra", ListaContra);
                return "user/contratos";

    }
    
}