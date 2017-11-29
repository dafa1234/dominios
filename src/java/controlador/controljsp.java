/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
      @Autowired
    private HttpServletRequest request;  
          
   //ACTIVIDADES
       @RequestMapping("actividades.htm")
    public ModelAndView news(Model model){
      
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/actividades");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        List<EtbInvActividad> ListaActividad  = dao.ListaActividad();                  
          model.addAttribute("listaActividad", ListaActividad);                 
        return maw;
    }
           @RequestMapping("newactiv.htm")
    public ModelAndView newactiv(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/actividades");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
           String m = "2";   
      model.addAttribute("m", m);  
        return maw;
    }
    
    
    //CRONOGRAMA
         @RequestMapping("cronograma.htm")
    public ModelAndView cro(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/cronograma");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        List<EtbInvCronogramaMto> ListaCrono  = dao.ListaCrono();           
          model.addAttribute("listaCrono", ListaCrono); 
       
        return maw;
    }
            @RequestMapping("newcrono.htm")
    public ModelAndView newcrono(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/cronograma");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
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
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        List<EtbInvAseguramiento> ListaAsegu  = dao.ListaAsegu();    
          model.addAttribute("listaAsegu", ListaAsegu);                
        return maw;
    }
          @RequestMapping("newaseg.htm")
    public ModelAndView newaseg(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/aseguramiento");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
           String m = "2";   
      model.addAttribute("m", m);  
        return maw;
    }
    
    
    //CONTRATOS
      @RequestMapping("contratos.htm")
    public ModelAndView con(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/contratos");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        List<EtbInvContrato> ListaContra  = dao.ListaContra();   
          model.addAttribute("listaContra", ListaContra);           
        
        return maw;
    }
      @RequestMapping("newcont.htm")
    public ModelAndView newcont(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/contratos");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
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
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        List<EtbInvServidor> Listaserver  = dao.Listaserver();           
          model.addAttribute("Listaserver", Listaserver);                
        return maw;
    }
    //central
     @RequestMapping("nCentral.htm")
    public ModelAndView nCentral (Model model){
        ModelAndView maw= new ModelAndView();
        int c = 1;
        model.addAttribute("c",c );
        maw.setViewName("objetos");             
        return maw;
    }
    @RequestMapping("Central.htm")
    public ModelAndView Central (@RequestParam("central") String Central,Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("objetos");
        dao.newcentral(Central);              
        return maw;
    }
    //grupo
     @RequestMapping("nGrupo.htm")
    public ModelAndView nGrupo (Model model){
        ModelAndView maw= new ModelAndView();
        int g = 2;
        model.addAttribute("g",g );
        maw.setViewName("objetos");             
        return maw;
    }
     @RequestMapping("Grupo.htm")
    public ModelAndView Grupo (@RequestParam("ngrupo") String Ngrupo,@RequestParam("tgrupo") String Tgrupo,Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("objetos");
        dao.newgrupo(Ngrupo,Tgrupo);              
        return maw;
    }
    //marca
      @RequestMapping("nMarca.htm")
    public ModelAndView nmarca (Model model){
        ModelAndView maw= new ModelAndView();
        int m = 3;
        model.addAttribute("m",m );
        maw.setViewName("objetos");
        return maw;
    }
     @RequestMapping("Marca.htm")
    public ModelAndView marca (@RequestParam("nmarca") String nmarca,@RequestParam("usoporte") String usoporte,
                               @RequestParam("tsoporte") String tsoporte,@RequestParam("minterventor") String minterventor,Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("objetos");
        dao.newmarca(nmarca,usoporte,tsoporte,minterventor);               
        return maw;
    }
    //plataforma
      @RequestMapping("nPlataforma.htm")
    public ModelAndView nplataforma (Model model){
        ModelAndView maw= new ModelAndView();
        int p = 4;
        model.addAttribute("p",p );
        maw.setViewName("objetos");           
        return maw;
    }
     @RequestMapping("Plataforma.htm")
    public ModelAndView plataforma (@RequestParam("nplataforma") String nplataforma,@RequestParam("aplataforma") int aplataforma,Model model)
    {
        ModelAndView maw= new ModelAndView();
        maw.setViewName("objetos");
        dao.newplataforma(nplataforma,aplataforma);           
        return maw;
    }
    //rolserv
     @RequestMapping("nRolserv.htm")
    public ModelAndView nrolserv (Model model){
        ModelAndView maw= new ModelAndView();
        int r = 5;
        model.addAttribute("r",r );
        maw.setViewName("objetos");           
        return maw;
    }
     @RequestMapping("Rolserv.htm")
    public ModelAndView rolserv (@RequestParam("nrol") String nrol,Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("objetos");
        dao.newrol(nrol);             
        return maw;
    }
    //sisoper
     @RequestMapping("nSisopera.htm")
    public ModelAndView nsisoper (Model model){ 
        ModelAndView maw= new ModelAndView();
        int s = 6;
        model.addAttribute("s",s );
        maw.setViewName("objetos");            
        return maw;
    }
     @RequestMapping("Sisopera.htm")
    public ModelAndView sisoper (@RequestParam("sisdid") int sisdis,@RequestParam("nsis") String nsis,Model model){ 
        ModelAndView maw= new ModelAndView();
        maw.setViewName("objetos");
        dao.newsisoperativo(sisdis,nsis);              
        return maw;
    }

    //ADMINISTRADOR
           @RequestMapping("fono.htm")
    public ModelAndView fon(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("fono");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        List<EtbInvServidor> Listaserver  = dao.Listaserver();           
          model.addAttribute("Listaserver", Listaserver);  
        return maw;
    }
    
    
    //USUARIOS SERVIDOR
        @RequestMapping("usuarioservidor.htm")
    public ModelAndView usu(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/usuarioservidor");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
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
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
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
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
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
              Calendar fechaActual = Calendar.getInstance();
            String Fecha = String.format("%04d-%02d-%02d",
              fechaActual.get(Calendar.YEAR),
              fechaActual.get(Calendar.MONTH)+1,
              fechaActual.get(Calendar.DAY_OF_MONTH));
         dao.update(email,ususEstado,ususLogin,nombre,servidor,admin);
         dao.crearcambioususerv(Fecha,ususLogin,tCambio,ususEstado);
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/usuarioservidor");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
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
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        return maw;
    }
    
    
    //CERRAR SESION
           @RequestMapping("cerrarsesion.htm")
    public ModelAndView cer(){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("cerrarsesion");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        return maw;
    }
    
    
    //MODIFICAR USUARIOS
           @RequestMapping("modificarusuario.htm")
    public ModelAndView mouser(Model model) throws UnknownHostException{
         
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/modificarusuario");
        String id = (String)request.getSession().getAttribute("name");
        String usuetb = (String)request.getSession().getAttribute("usuetb");
        int per = (int)request.getSession().getAttribute("ID");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
         
        if (per!=1) {
            InetAddress inetAddress = InetAddress.getLocalHost();
                            String ip = inetAddress.getHostAddress();
                            String url = request.getRequestURL().toString();
                            String acc="acceso proivido para el usuario"+usuetb+".";
                             Calendar fechaActual = Calendar.getInstance();
            String Fecha = String.format("%04d-%02d-%02d",
              fechaActual.get(Calendar.YEAR),
              fechaActual.get(Calendar.MONTH)+1,
              fechaActual.get(Calendar.DAY_OF_MONTH));
    
                            dao.ACCPROI(Fecha,usuetb, ip, url,acc);
                        model.addAttribute("errorr", acc);    
             maw.setViewName("error");   
                return maw;
            }
        return maw;
    }
    
    
    //CASOS PROVEEDOR
           @RequestMapping("casosproveedor.htm")
    public ModelAndView casosproveedor(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/casosproveedor");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        List<EtbInvCasosProv> Listaproveedor  = dao.Listaproveedor();
        model.addAttribute("Listaproveedor", Listaproveedor);       
        return maw;
    }
            @RequestMapping("newcasos.htm")
    public ModelAndView newcasos(Model model){
        ModelAndView maw= new ModelAndView();
        maw.setViewName("user/casosproveedor");
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
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
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
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
         String id = (String)request.getSession().getAttribute("name");
        if (id==null) {
             maw.setViewName("index");   
                return maw;
            } 
        return maw;
    }

}
