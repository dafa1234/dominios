/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tablas.EtbInvActividad;
import tablas.EtbInvAseguramiento;
import tablas.EtbInvCamusuServ;
import tablas.EtbInvCasosProv;
import tablas.EtbInvCentral;
import tablas.EtbInvContrato;
import tablas.EtbInvCronogramaMto;
import tablas.EtbInvEstado;
import tablas.EtbInvGrupo;
import tablas.EtbInvMarca;
import tablas.EtbInvPlataforma;
import tablas.EtbInvProyecto;
import tablas.EtbInvRolServidor;
import tablas.EtbInvSalon;
import tablas.EtbInvServidor;
import tablas.EtbInvSisOperativo;
import tablas.EtbInvTipoCont;
import tablas.EtbInvUsuEstado;
import tablas.EtbInvUsuServ;


/**
 *
 * @author diegfraa
 */
@Controller

public class controljsp {
     @Autowired
    private iniciosecion dao;
   //ACTIVIDADES
       @RequestMapping("actividades.htm")
    public ModelAndView news(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/actividades");
        List<EtbInvActividad> ListaActividad  = dao.ListaActividad();                  
          model.addAttribute("listaActividad", ListaActividad);                 
        return maw;
    }
           @RequestMapping("newactiv.htm")
    public ModelAndView newactiv(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/actividades");
           String m = "2";   
      model.addAttribute("m", m);  
        return maw;
    }
    
    
    //CRONOGRAMA
         @RequestMapping("cronograma.htm")
    public ModelAndView cro(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/cronograma");
        List<EtbInvCronogramaMto> ListaCrono  = dao.ListaCrono();    
       
          model.addAttribute("listaCrono", ListaCrono); 
       
        return maw;
    }
            @RequestMapping("newcrono.htm")
    public ModelAndView newcrono(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/cronograma");
        String m = "2";
        List<EtbInvProyecto> ListaProyecto  = dao.ListaProyecto(); 
        List<EtbInvServidor> Listaserver  = dao.Listaserver(); 
        List<EtbInvEstado> ListaEstado  = dao.ListaEstado();
        List<EtbInvMarca> ListaMarca  = dao.ListaMarca();
        List<EtbInvTipoCont> Listacont  = dao.Listacont();
      model.addAttribute("ListaProyecto", ListaProyecto);
      model.addAttribute("listaFonos", Listaserver);
      model.addAttribute("listaEstado", ListaEstado);
      model.addAttribute("listamarcas", ListaMarca); 
      model.addAttribute("listacont", Listacont);     
      model.addAttribute("m", m);  
        return maw;
    }
    
    
    //ASEGURAMIENTO
      @RequestMapping("aseguramiento.htm")
    public ModelAndView nuev(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/aseguramiento");
        List<EtbInvAseguramiento> ListaAsegu  = dao.ListaAsegu();    
          model.addAttribute("listaAsegu", ListaAsegu);                
        return maw;
    }
          @RequestMapping("newaseg.htm")
    public ModelAndView newaseg(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/aseguramiento");
           String m = "2";   
      model.addAttribute("m", m);  
        return maw;
    }
    
    
    //CONTRATOS
      @RequestMapping("contratos.htm")
    public ModelAndView con(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/contratos");
        List<EtbInvContrato> ListaContra  = dao.ListaContra();
    
          model.addAttribute("listaContra", ListaContra);           
        
        return maw;
    }
      @RequestMapping("newcont.htm")
    public ModelAndView newcont(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/contratos");
        String m = "2";   
        List<EtbInvEstado> ListaEstado  = dao.ListaEstado();
        List<EtbInvMarca> ListaMarca  = dao.ListaMarca();
        List<EtbInvTipoCont> Listacont  = dao.Listacont();
      model.addAttribute("ListaEstado", ListaEstado);
      model.addAttribute("listamarcas", ListaMarca); 
      model.addAttribute("listacont", Listacont);     
      model.addAttribute("m", m);  
        return maw;
    }
    
     
    //USUARIO AP
          @RequestMapping("buscar.htm")
    public ModelAndView bus(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("buscar");
        List<EtbInvServidor> Listaserver  = dao.Listaserver();           
          model.addAttribute("Listaserver", Listaserver);                
        return maw;
    }
    
    
    //ADMINISTRADOR
           @RequestMapping("fono.htm")
    public ModelAndView fon(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("fono");
        List<EtbInvServidor> Listaserver  = dao.Listaserver();           
          model.addAttribute("Listaserver", Listaserver);  
        return maw;
    }
    
    
    //USUARIOS SERVIDOR
        @RequestMapping("usuarioservidor.htm")
    public ModelAndView usu(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        List<EtbInvServidor> Listaserver  = dao.Listaserver();    
        List<EtbInvUsuServ> Listaususerv  = dao.Listaususerv(); 
        List<EtbInvUsuEstado> Listausuest  = dao.Listausuest();
          model.addAttribute("Listaserver", Listaserver);           
          model.addAttribute("Listaususerv", Listaususerv); 
          model.addAttribute("Listausuest", Listausuest); 
        return maw;
    }
           @RequestMapping("detalle.htm")
    public ModelAndView detalle(@RequestParam("id") Integer email,@RequestParam("usu") String usu,Model model){
     
     List<EtbInvCamusuServ> ListaDetalle = dao.ListaDetalle(usu);     
     EtbInvUsuServ a = dao.buscarususerv(email);
     String u = "hola";   
     String m = "2";
        model.addAttribute("ususLogin", a.getUsusLogin()); 
        model.addAttribute("ususNombre", a.getUsusNombre());
        model.addAttribute("ususServ", a.getUsusServ());   
        model.addAttribute("ususAdm", a.getUsusAdm()); 
        model.addAttribute("ususEstado", a.getUsusEstado()); 
        model.addAttribute("u", u); 
        model.addAttribute("m", m);  
        model.addAttribute("ListaDetalle", ListaDetalle); 
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        return maw;
    }
           @RequestMapping("usuarios.htm")
    public ModelAndView usuarios(@RequestParam("id") Integer email,Model model){

        EtbInvUsuServ a = dao.buscarususerv(email);
        List<EtbInvUsuEstado> Listausuest  = dao.Listausuest();                    
        String m = "2";
          model.addAttribute("email", email); 
          model.addAttribute("Listausuest", Listausuest); 
          model.addAttribute("getUsuApell", a.getUsusServ());
          model.addAttribute("getUsuCorreo", a.getUsusLogin());   
          model.addAttribute("m", m);                    
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        return maw;
    }
           @RequestMapping("modificar.htm")
    public ModelAndView usuarios3(@RequestParam("id") Integer email,
                                  @RequestParam("tarea") String tCambio,
                                  @RequestParam("serv") Integer ususEstad,Model model){
           EtbInvUsuEstado ususEstado = new EtbInvUsuEstado(ususEstad);
           EtbInvUsuServ a = dao.buscarususerv(email);
           String ususLogin= a.getUsusLogin();
           String nombre=a.getUsusNombre();
           String servidor=a.getUsusServ();
           Integer admin=a.getUsusAdm();
         dao.update(email,ususEstado,ususLogin,nombre,servidor,admin);
         dao.crearcambioususerv(ususLogin,tCambio,ususEstado);
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        return maw;
    }
           @RequestMapping("usuarioos.htm")
    public ModelAndView usuarios2(Model model){

        List<EtbInvUsuServ> Listaususerv  = dao.Listaususerv(); 
        List<EtbInvServidor> Listaserver  = dao.Listaserver();    
        String j= "3";
         String m= "3";
          model.addAttribute("Listaserver", Listaserver);
          model.addAttribute("j", j);   
          model.addAttribute("m", m);
          model.addAttribute("Listaususerv", Listaususerv); 
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/usuarioservidor");
        return maw;
    }
    
    
    //CERRAR SESION
           @RequestMapping("cerrarsesion.htm")
    public ModelAndView cer(){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("cerrarsesion");
        return maw;
    }
    
    
    //MODIFICAR USUARIOS
           @RequestMapping("modificarusuario.htm")
    public ModelAndView mouser(){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/modificarusuario");
        return maw;
    }
    
    
    //CASOS PROVEEDOR
           @RequestMapping("casosproveedor.htm")
    public ModelAndView casosproveedor(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/casosproveedor");
        List<EtbInvCasosProv> Listaproveedor  = dao.Listaproveedor();
        model.addAttribute("Listaproveedor", Listaproveedor);       
        return maw;
    }
            @RequestMapping("newcasos.htm")
    public ModelAndView newcasos(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/casosproveedor");
        String m = "2";   
        List<EtbInvCasosProv> Listaproveedor  = dao.Listaproveedor();
        List<EtbInvMarca> ListaMarca  = dao.ListaMarca();
        List<EtbInvEstado> ListaEstado  = dao.ListaEstado();
        List<EtbInvServidor> Listaserver  = dao.Listaserver();
           model.addAttribute("Listaproveedor", Listaproveedor);
           model.addAttribute("ListaMarca", ListaMarca);
           model.addAttribute("listaServer", Listaserver);                         
           model.addAttribute("listaEstado", ListaEstado);
           model.addAttribute("m", m);  
           return maw;
    }
    
    
    //SERVIDORES
            @RequestMapping("servers.htm")
    public ModelAndView server(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/servers");            
        List<EtbInvServidor> Listaserver  = dao.Listaserver();                       
          model.addAttribute("listaServer", Listaserver);                          
          return maw;
    }
             @RequestMapping("aserver.htm")
    public ModelAndView agser(Model model){
        ModelAndView maw= new ModelAndView();
          List<EtbInvMarca> ListaMarca  = dao.ListaMarca();
        List<EtbInvServidor> Listaserver  = dao.Listaserver();
        List<EtbInvEstado> ListaEstado  = dao.ListaEstado();
        List<EtbInvSisOperativo> Listasisope  = dao.Listasisope();
        List<EtbInvGrupo> Listagrupo  = dao.Listagrupo();
        List<EtbInvCentral> ListaCentral  = dao.ListaCentral();
        List<EtbInvPlataforma> ListaPrataforma  = dao.ListaPrataforma();
        List<EtbInvRolServidor> ListaRolserver  = dao.ListaRolserver();
        List<EtbInvSalon> ListaSalom  = dao.ListaSalom();
        String m = "2";               
          model.addAttribute("listaFonos", ListaMarca);                                
          model.addAttribute("listaServer", Listaserver);                         
          model.addAttribute("listaEstado", ListaEstado);                         
          model.addAttribute("listaSis", Listasisope);                      
          model.addAttribute("listaGrupo", Listagrupo);                          
          model.addAttribute("listaCentral", ListaCentral);                          
          model.addAttribute("listaPlat", ListaPrataforma);                         
          model.addAttribute("listaRol", ListaRolserver);                         
          model.addAttribute("listaSalon", ListaSalom);         
          model.addAttribute("m", m);  
        maw.setViewName("user/servers");
        return maw;
    }

}
