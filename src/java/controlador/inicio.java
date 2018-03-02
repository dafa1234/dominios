/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvServidor;
import tablas.EtbInvUsuarioAp;

/**
 *
 * @author diegfraa
 */
@Controller
@RequestMapping("/mostrar.htm")
public class inicio {

    @Autowired
    private iniciosecion dao;
/**
 * 
 * @return 
 */
    @RequestMapping(method = RequestMethod.GET)
    public String mostrarAlumno() {
        return "index";
    }
/**
 * aqui iniciamos sesion
 * @param email
 * @param pass
 * @param model
 * @param request
 * @param response
 * @return 
 */
    @RequestMapping(method = RequestMethod.POST)
    public String mostrarAlumno(
            @RequestParam("email") String email, @RequestParam("pass") String pass,
            Model model, HttpServletRequest request, HttpServletResponse response) {
        if (email.trim().equals("") || pass.trim().equals("")) {
            return "error";
        }

        EtbInvUsuarioAp a = dao.readByRutJPQL(email);

        HttpSession sesion = request.getSession(true);

        if (a == null) {
            sesion.setAttribute("error", "hay espacios bacios");
            return "error";
        }
        Calendar fechaActual = Calendar.getInstance();
        String cadenaFecha = String.format("%04d-%02d-%02d",
                fechaActual.get(Calendar.YEAR),
                fechaActual.get(Calendar.MONTH) + 1,
                fechaActual.get(Calendar.DAY_OF_MONTH));

        //http session
        if (a.getUsuEtb().equals(email)) {
            String parametro_Correo = "mail";
            sesion.setAttribute("usuario", email);
            sesion.setAttribute("correo", a.getUsuCorreo());
            sesion.setAttribute("usuetb", a.getUsuEtb());
            sesion.setAttribute("apell", a.getUsuApell());
            sesion.setAttribute("name", a.getUsuNombre());
            sesion.setAttribute("ID", a.getUsuIdPer());
            sesion.setAttribute("fecha", cadenaFecha);
            sesion.setAttribute("idusuap", a.getUsuId());

            if (findADETB(email) && authADETB(email, pass)) {

                HttpSession objsession = request.getSession();

                String Correo_recibido = (consultarParametroETB(email, parametro_Correo));

                objsession.setAttribute("Correo_recibido", Correo_recibido);

                List<EtbInvServidor> results = dao.Listaserver();

                if (a.getUsuIdPer() > 1) {

                    model.addAttribute("Listaserver", results);
                    return "buscar";
                } else {

                    model.addAttribute("Listaserver", results);
                    return "administrador";
                }
            } else {

                sesion.setAttribute("error2", "no se encontro en la base de datos de la app");
                return "error";
            }
        } else {

            sesion.setAttribute("error3", "no se encontro en la base de datos de etb");
            return "error";
        }
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
