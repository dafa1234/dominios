/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvUsuarioAp;

/**
 *
 * @author diegfraa
 */
@Controller
public class crear_usuario {

    @Autowired
    private iniciosecion dao;
     @Autowired
    private HttpServletRequest request;
    Calendar fechaActual = Calendar.getInstance();
    String Fecha = String.format("%04d-%02d-%02d",
            fechaActual.get(Calendar.YEAR),
            fechaActual.get(Calendar.MONTH) + 1,
            fechaActual.get(Calendar.DAY_OF_MONTH));
//    @RequestMapping(method = RequestMethod.GET)
//    public String mostrarAlumno() {
//        return "index";
//    }

   // @RequestMapping(method = RequestMethod.POST)
    @RequestMapping("/newuser.htm")
    public String create(
            @RequestParam("usu") String email,
            @RequestParam("per") int per,
            @RequestParam("dom") int dom, Model model) {
        EtbInvUsuarioAp a = dao.readByRutJPQL(email);
        if (a != null) {
            String error = "el usuario ya existe";
            model.addAttribute("error", error);
            return "user/modificarusuario";
        }
        String estado = "activo";
        String parametro_Nombre = "GivenName";
        String parametro_Apelldio = "sn";
        String parametro_Correo = "mail";
        String parametro_Cod_Etb = "employeeNumber";
        String parametro_usuario = "cn";
        String parametro_Telefono = "mobile";
        String parametro_Empresa = "Company";
        String parametro_Cargo = "title";
        String parametro_Direccion_Laboral = "street";
        String parametro_Cedula = "workforceid";
        String parametro_Telefono_Oficina = "telephonenumber";
        String nombre_recibido = (consultarParametroETB(email, parametro_Nombre));
        String apellido_recibido = (consultarParametroETB(email, parametro_Apelldio));
        String Correo_recibido = (consultarParametroETB(email, parametro_Correo));
        String Codigo_Etb_Recibido = (consultarParametroETB(email, parametro_Cod_Etb));
        String usuario_recibido = (consultarParametroETB(email, parametro_usuario));
        String telefono_recibido = (consultarParametroETB(email, parametro_Telefono));
        String Empresa_recibido = (consultarParametroETB(email, parametro_Empresa));
        String Cargo_recibido = (consultarParametroETB(email, parametro_Cargo));
        String Direccion_Recibido = (consultarParametroETB(email, parametro_Direccion_Laboral));
        String Cedula_Recibido = (consultarParametroETB(email, parametro_Cedula));
        String telefono_ofici_recibido = (consultarParametroETB(email, parametro_Telefono_Oficina));
        dao.crearusuarioapp(per, nombre_recibido, apellido_recibido, Correo_recibido, estado, dom, Codigo_Etb_Recibido, usuario_recibido, telefono_recibido, Empresa_recibido, Cargo_recibido, Direccion_Recibido, Cedula_Recibido, telefono_ofici_recibido);
        return "user/modificarusuario";

    }
   //MODIFICAR USUARIOS
    @RequestMapping("modificarusuario.htm")
    public String mouser(Model model) throws UnknownHostException {
        String id = (String) request.getSession().getAttribute("name");
        String usuetb = (String) request.getSession().getAttribute("usuetb");
        int per = (int) request.getSession().getAttribute("ID");
        if (id == null) {
            return "index";
        }
        if (per != 1) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ip = inetAddress.getHostAddress();
            String url = request.getRequestURL().toString();
            String acc = "acceso proivido para el usuario" + usuetb + ".";
            dao.ACCPROI(Fecha, usuetb, ip, url, acc);
            model.addAttribute("errorr", acc);
            return "error";
        }
        return "user/modificarusuario";
    }

    private static boolean findADETB(java.lang.String username) {
        co.net.etb.autenticar.Consulta service = new co.net.etb.autenticar.Consulta();
        co.net.etb.autenticar.ConsultaSoap port = service.getConsultaSoap();
        return port.findADETB(username);
    }

    private static String consultarParametroETB(java.lang.String login, java.lang.String parametro) {
        co.net.etb.autenticar.Consulta service = new co.net.etb.autenticar.Consulta();
        co.net.etb.autenticar.ConsultaSoap port = service.getConsultaSoap();
        return port.consultarParametroETB(login, parametro);
    }

    private static boolean authADETB(java.lang.String username, java.lang.String pwd) {
        co.net.etb.autenticar.Consulta service = new co.net.etb.autenticar.Consulta();
        co.net.etb.autenticar.ConsultaSoap port = service.getConsultaSoap();
        return port.authADETB(username, pwd);
    }
}
