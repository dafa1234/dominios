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
import tablas.EtbInvUsuarioAp;

/**
 *
 * @author diegfraa
 */
@Controller
@RequestMapping("/newuser.htm")
public class crear_usuario {

    @Autowired
    private iniciosecion dao;

    @RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
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
