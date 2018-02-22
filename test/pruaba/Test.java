/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruaba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author diegfraa
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    String ruta = "\\NetBeansProjects\\Pruebas\\dominios_1.2\\web\\plantillas\\Doc6.docx";
    FileOutputStream fos=new FileOutputStream(ruta);
    
    File origen = new File("E:\\data\\D\\info\\Downloads\\cosas\\LA1_Identities_production_(week 2).docx");
        File destino = new File(ruta);
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino);
        byte[] buf = new byte[1024];
        int len;

        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
    
//     public static void main(String[] args) {
// 
//        try(FileOutputStream fos=new FileOutputStream("D:\\fichero_bin.ddr")){
// 
//            String texto="Esto es una prueba para ficheros binariosssss";
// 
//            //Copiamos el texto en un array de bytes
//            byte codigos[]=texto.getBytes();
// 
//            fos.write(codigos);
// 
//        }catch(IOException e){
// 
//        }
// 
//    }
//     public static void main1(String[] args) {
// 
//       try(FileInputStream fis=new FileInputStream("E:\\NetBeansProjects\\Pruebas\\dominios_1.2\\web\\plantillas\\fichero_bin23.xlsx")){
// 
//            int valor=fis.read();
//            while(valor!=-1){
//                System.out.print((char)valor);
//                valor=fis.read();
//            }
// 
//        }catch(IOException e){
// 
//        }
// 
//    }
//       FileInputStream file_factory = plantillas.getAbsoluteFile() ;
// 
//        /*ServletFileUpload esta clase convierte los input file a FileItem*/
//        ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
//        /*sacando los FileItem del ServletFileUpload en una lista */
//        List items = servlet_up.parseRequest(request);
// 
//        for(int i=0;i<items.size();i++){
//            /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
//            FileItem item = (FileItem) items.get(i);
//            /*item.isFormField() false=input file; true=text field*/
//            if (! item.isFormField()){
//                /*cual sera la ruta al archivo en el servidor*/
//                File archivo_server = new File("c:/subidos/"+item.getName());
//                /*y lo escribimos en el servido*/
//                item.write(archivo_server);
//                out.print("Nombre --> " + item.getName() );
//                out.print("<br> Tipo --> " + item.getContentType());
//                out.print("<br> tamaño --> " + (item.getSize()/1240)+ "KB");
//                out.print("<br>");
//            }
////        }
  /*FileItemFactory es una interfaz para crear FileItem*/
      
//         try(FileOutputStream fos=new FileOutputStream("E:\\NetBeansProjects\\Pruebas\\dominios_1.2\\web\\plantillas\\"+plantillas)){
//          
//             byte[] plant= plantilla.getBytes(aseTarea);
//          
//            fos.write(plant);
// 
//        }catch(IOException e){}
}
