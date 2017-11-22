<%@page import="tablas.EtbInvUsuEstado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <%@include file="/WEB-INF/plantilla/head.jsp" %>
    <body>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
         <div class="content-wrapper">
             </br></br>
             

     <%
         String ususLogin = (String)request.getAttribute("ususLogin");
         String ususNombre = (String)request.getAttribute("ususNombre");
         String ususServ = (String)request.getAttribute("ususServ");
         Integer ususAdm = (Integer)request.getAttribute("ususAdm");
         EtbInvUsuEstado ususEstado = (EtbInvUsuEstado)request.getAttribute("ususEstado");
         String getUsuApell = (String)request.getAttribute("getUsuApell");
         String getUsuCorreo = (String)request.getAttribute("getUsuCorreo");
         Integer email = (Integer)request.getAttribute("email");
         String m = (String)request.getAttribute("m");
         String j = (String)request.getAttribute("j");
         String u = (String)request.getAttribute("u");
    
         if(m!=null){
       if(j!=null){
          
     %>
     <h2>Agregar nuevo usuario servidor</h2>
     <div class="box-bottom">
                 <a  role="button" href="<c:url value="/usuarioservidor.htm"/>">volver</a>
              </div>
     <form id="forminicio" action="usuario.htm" method="Post">
         
                     <table class="table table-bordered" id="ataTable" width="100%" cellspacing="0">            
                        
                         <tr>
                           
                            <th>login</th>
                            <th>nombre</th>
                            <th>tarea</th>
                            <th>servidor</th>
                            
                            
                         </tr>

                         <tr>
                             <td> <input  name="login" type="text"  id="inputPassword" class="form-control" placeholder="login" >  </td>
                             <td> <input  name="nombre" type="text"  id="inputPassword" class="form-control" placeholder="nombre usuario" >  </td>
                             <td> <input  name="tarea" type="text"  id="inputPassword" class="form-control" placeholder="tarea" >  </td>                            
                             <td>   
                                    <select name="serv" class="form-control">
                                                    <option value="">${getUsuDominio}</option>
                                                    <c:forEach var="f" items="${requestScope.Listaserver}">
                                                        <option value="${f.serSerial}">${f.serSerial}   -    ${f.serHostname}</option>
                                                    </c:forEach>
                                    </select>
                             </td> 
                             
                         </tr>

                    </table> 
                    
                        <div>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">estado</button>
                        </div>
                    
     </form>   

     <%   }
if(getUsuApell!=null){%>
<h2>modificar usuarios servidor</h2>
<div class="box-bottom">
                 <a  role="button" href="<c:url value="/usuarioservidor.htm"/>">volver</a>
              </div>
<form id="forminicio" action="modificar.htm" method="Post">
                                                     <div class="modal-body" >  
                                                         
                                                         <span>usuario</span>:
                                                         <label ><%= getUsuCorreo%></label><br/><br/>
                                                         <span>serial</span>:
                                                         <label ><%= getUsuApell%></label><br/><br/>
                                                         
                                                         <input  name="id" type="hidden" value="<%= email%>" >
                                                         <span>tarea</span>
                                                         <input  name="tarea" type="text" id="inputPassword" class="form-control" placeholder="ingrese tarea" ><br/><br/>
                                                         <span>estado</span>
                                                          <select name="serv" class="form-control">
                                                                                     <option value=""></option>
                                                                                     <c:forEach var="f" items="${requestScope.Listausuest}">
                                                                                         <option value="${f.ususEstado}">${f.estuEstado}</option>
                                                                                     </c:forEach>
                                                                     </select><br/><br/>
                                                     </div>
                                                     <div class="modal-footer" >
                                                         <div>
                                                             <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">aceptar</button>
                                                         </div>
                                                     </div>
                                                 </form>  
 <%     
}if(u!=null){%>
<h2>detalles de usuarios de servidor</h2>
<div class="box-bottom">
                 <a  role="button" href="<c:url value="/usuarioservidor.htm"/>">volver</a>
              </div>
<div class="card mb-3">
<table class="table table-bordered"  width="100%" cellspacing="0">
    <tr> 
        <td><span>usuario</span>:</td> 
        <td><label ><%= ususLogin%></label><br/><br/></td>
        </tr>
    <tr>
        <td><span>nombre</span>:</td>
        <td><label ><%= ususNombre%></label><br/><br/></td>
    </tr>         
                                       
    <tr>
        <td><span>estado</span>:</td>
        <td><label ><%= ususEstado%></label><br/><br/></td>
    </tr>
                            
    <tr>
        <td><span>admin</span>:</td>
        <td><label ><%= ususAdm%></label><br/><br/></td>
     </tr>
                                              
    <tr>
        <td><span>serial</span>:</td>
        <td><label ><%= ususServ%></label><br/><br/></td>
    </tr> 
                                             
                           
                            
                            
</table>
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">            
                        <thead>
                         <tr>
                            <th>fecha</th>
                            <th>tarea</th>
                            <th>estado </th>
                       
                         </tr>
                        </thead>
                      
                        <tbody>        
                        
                         <c:forEach var="f" items="${requestScope.ListaDetalle}">
                         <tr>
                                <td>${f.usuFecCambio}</td>
                                <td>${f.usuTarCambio}</td>
                                <td>${f.ususEstado.estuEstado}</td>
                           
                         </tr>
                         </c:forEach>  
                        
                        </tbody>
                    </table>  
</div>                      
     <%}
}else{
     %>

     <h2>lista de usuarios de servidores</h2>
     <div class="box-bottom">
                 <a  role="button" href="<c:url value="/usuarioos.htm"/>">agregar</a>
              </div>
   
     
      <div class="card mb-3">
                <div class="card-header">
                  <i class="fa fa-table"></i> Data Table usuario</div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">            
                        <thead>
                         <tr>
                            <th>usuario id</th>
                            <th>usuario login</th>
                            <th>usuario nombre</th>
                            <th>usuario estado</th>                        
                            <th>usuario servidor</th>
                            <th>usuario admin</th>
                            <th>modificar</th>
                            <th>detalle</th>
                         </tr>
                        </thead>
                        <tfoot>
                         <tr>
                            <th>usuario id</th>
                            <th>usuario login</th>
                            <th>usuario nombre</th>
                            <th>usuario estado</th>                         
                            <th>usuario servidor</th>
                            <th>usuario admin</th>
                            <th>modificar</th>
                            <th>detalle</th>
                         </tr>
                        </tfoot>
                        <tbody>        
                        
                         <c:forEach var="f" items="${requestScope.Listaususerv}">
                         <tr>
                            
                                <td>${f.ususId}</td>
                                <td>${f.ususLogin}</td>
                                <td>${f.ususNombre}</td>
                                <td>${f.ususEstado.estuEstado}</td>
                                <td>${f.ususServ}</td>
                                <td>${f.ususAdm}</td>
                                <td> 
                                     <form id="forminicio" action="usuarios.htm" method="Post">
                                         <input  name="id" type="hidden" value="${f.ususId}">
                                        <div>
                                          <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">modificar</button>
                                        </div>
                                     </form>
                                  
                                </td>
                                <td> 
                                   <form id="forminicio" action="detalle.htm" method="Post">
                                          <input  name="id" type="hidden" value="${f.ususId}">
                                          <input  name="usu" type="hidden" value="${f.ususLogin}">
                                        <div>
                                           <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">detalle</button>
                                        </div>
                                   </form>
                                  
                                </td>
                         </tr>
                         </c:forEach>  
                        
                        </tbody>
                    </table>
                  </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
     
     
       <%
   }
%>

         </div>
         <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>




























