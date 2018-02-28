/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.iniciosecion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tablas.EtbInvServidor;
import tablas.EtbInvUsuEstado;
import tablas.EtbInvUsuServ;

/**
 *
 * @author diegfraa
 */
@Controller
public class usuariosmasivos {

    @Autowired
    private iniciosecion dao;
    private HttpServletRequest request;
    Calendar fechaActual = Calendar.getInstance();
    String Fecha = String.format("%04d-%02d-%02d",
            fechaActual.get(Calendar.YEAR),
            fechaActual.get(Calendar.MONTH) + 1,
            fechaActual.get(Calendar.DAY_OF_MONTH));
/**
 * 
 * @param usuariosmultiples
 * @param administrado
 * @param ususidServ1
 * @param model
 * @return 
 */
    @RequestMapping("agragarusuariosmasivos.htm")
    public String nuev23(@RequestParam("usuariosmultiples") String usuariosmultiples,
            @RequestParam("administrado") int administrado,
            @RequestParam("servid") int ususidServ1, Model model) {
        System.out.println(usuariosmultiples);
        
        System.out.println("controlador.usuariosmasivos.nuev()");
        EtbInvUsuEstado ususEstadoa = new EtbInvUsuEstado(3);
        EtbInvServidor ususidServ = new EtbInvServidor(ususidServ1);
        ArrayList Cambio = new ArrayList();
        System.out.println("controlador.usuariosmasivos.nuev()");
        Cambio = ResponseCeldas(usuariosmultiples);
        System.out.println("controlador.usuariosmasivos.nuev(1)");
        System.out.println("Tam|" + Cambio.size());
        
        
        for (Iterator it = Cambio.iterator(); it.hasNext();) {
            String[] tem = (String[]) it.next();
            System.out.println("tem|" + tem.length);
//            ArrayList atributosCrear = new ArrayList();
            //atributosCrear = CargarAtributos(tem);

            String nombre = tem[0];//(String) atributosCrear.get(1);
            String login = tem[1];//(String) atributosCrear.get(0);
            System.out.println("nombre|" + nombre);
            System.out.println("login|" + login);
            System.out.println("controlador.usuariosmasivos.nuev()");
            dao.crearususerv(Fecha, login, nombre, ususEstadoa, ususidServ, administrado);
            System.out.println("controlador.usuariosmasivos.nuev()");
        }
      
        List<EtbInvUsuServ> Listaususerv = dao.Listaususerv(ususEstadoa);
        model.addAttribute("Listaususerv", Listaususerv);
        int m = 0;
        model.addAttribute("m", m);
        return "user/usuarioservidor";
    }

/**
 * 
 * @param usuariosmultiples
 * @return 
 */
    private ArrayList ResponseCeldas(String usuariosmultiples) {
        ArrayList filas = new ArrayList();
        ArrayList celdas = new ArrayList();

        filas = ResponseFilas(usuariosmultiples);

        for (Iterator it = filas.iterator(); it.hasNext();) {
            String tem = (String) it.next();
            String[] ArraySplit = tem.split(";");
            System.out.println("String[]|" + ArraySplit[0] + "ArraySplit[1]|" + ArraySplit[1]);            
            celdas.add(ArraySplit);
        }

        return celdas;
    }
/**
 * 
 * @param usuariosmultiples
 * @return 
 */
    private ArrayList ResponseFilas(String usuariosmultiples) {
        ArrayList arrayList = new ArrayList();
        ArrayList respuesta = new ArrayList();
        arrayList = ResponseArchivo(usuariosmultiples);

        System.out.println("arrayListT|" + arrayList.size());
        
        for (Iterator it = arrayList.iterator(); it.hasNext();) {
            String[] tem = (String[]) it.next();
            System.out.println("String[]" + tem);
            for (int i = 0; i < tem.length; i++) {
                respuesta.add(tem[i]);
                System.out.println("respuesta|" +tem[i]);
            }
        }

        return respuesta;
    }
/**
 * 
 * @param usuariosmultiples
 * @return 
 */
    private ArrayList ResponseArchivo(String usuariosmultiples) {
        ArrayList lista = new ArrayList();

        String[] fila = usuariosmultiples.split("\r\n");
        System.out.println("fila1|" + fila[0]);
        System.out.println("fila2|" + fila[1]);
        System.out.println("fila2|" + fila[2]);
        lista.add(fila);

        return lista;
    }

}
