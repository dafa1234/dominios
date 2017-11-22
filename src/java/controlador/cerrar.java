/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author diegfraa
 */
@Controller

public class cerrar {
    @RequestMapping("/cerrar.htm")
    public String mostrarAlumno(HttpServletRequest request, HttpServletResponse response){
    HttpSession sesionCerrada = request.getSession();
    sesionCerrada.removeAttribute("usuario");
    sesionCerrada.removeAttribute("pass");
    sesionCerrada.removeAttribute("correo");
    sesionCerrada.removeAttribute("passw");
    sesionCerrada.removeAttribute("apell");
    sesionCerrada.removeAttribute("name");
    sesionCerrada.invalidate();
    return "index";
    }
}
