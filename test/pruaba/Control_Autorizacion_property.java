/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruaba;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author diegfraa
 */
public class Control_Autorizacion_property {
        public Properties getProperties() {
        try {
            //se crea una instancia a la clase Properties
            Properties propiedades = new Properties();
            //se leen el archivo .properties
            propiedades.load( getClass().getResourceAsStream("Configuration.properties") );
            //si el archivo de propiedades NO esta vacio retornan las propiedes leidas
            if (!propiedades.isEmpty()) {                
                return propiedades;
            } else {//sino  retornara NULL
                return null;
            }
        } catch (IOException ex) {
            System.out.println(ex);
            return null;
        }
   }    
}
