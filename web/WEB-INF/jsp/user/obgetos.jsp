<%-- 
    Document   : obgetos
    Created on : 29/11/2017, 08:49:43 AM
    Author     : diegfraa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <%@include file="/WEB-INF/plantilla/head.jsp" %>
<body>
   <%@include file="/WEB-INF/plantilla/header.jsp" %>
    <div class="content-wrapper">
        </br></br>
      
                               <%
            Integer s = (Integer)request.getAttribute("s");
    
         if(s!=null){
            %>
             <div class="flex-caption">
            <h3>Nueva Central</h3>              
        </div>
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="central" type="text" id="inputEmail" class="form-control" placeholder="Central" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                    
                                        </tr>
                       
                                </table>
                            </div>
                               
                                    <div>
                                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                                    </div>
                              
                        </form>
                           <!-- End # DIV Form -->                   
                </center>
                                               <%
    
         if(s!=null){
            %>
              <div class="flex-caption">
            <h3>Nuevo Grupo</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="ngrupo" type="text" id="inputEmail" class="form-control" placeholder="Nombre Grupo" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="tgrupo" type="text" id="inputEmail" class="form-control" placeholder="Tipo Grupo" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                        </tr>
                       
                                </table>
                            </div>
                               
                                    <div>
                                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                                    </div>
                              
                        </form>
                           <!-- End # DIV Form -->                   
                </center>
                                                               <%
    
         if(s!=null){
            %>
              <div class="flex-caption">
            <h3>Nueva Marca</h3>              
        </div>          
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="nmarca" type="text" id="inputEmail" class="form-control" placeholder="Nombre Marca" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="usoporte" type="text" id="inputEmail" class="form-control" placeholder="Url Soporte" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="tsoporte" type="text" id="inputEmail" class="form-control" placeholder="Telefono Soporte" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="minterventor" type="text" id="inputEmail" class="form-control" placeholder="Marca Interventor" autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>                                        
                                        </tr>
                       
                                </table>
                            </div>
                               
                                    <div>
                                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                                    </div>
                              
                        </form>
                           <!-- End # DIV Form -->                   
                </center>
                                                               <%
    
         if(s!=null){
            %>
              <div class="flex-caption">
            <h3>Nueva plataforma</h3>              
        </div>           
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="nplataforma" type="text" id="inputEmail" class="form-control" placeholder="nombre Plataforma" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="aplataforma" type="text" id="inputEmail" class="form-control" placeholder="Administrador Plataforma" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                        </tr>
                       
                                </table>
                            </div>
                               
                                    <div>
                                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                                    </div>
                              
                        </form>
                           <!-- End # DIV Form -->                   
                </center>
                                                               <%
    
         if(s!=null){
            %>
              <div class="flex-caption">
            <h3>Nuevo Rol Servidor</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="nrol" type="text" id="inputEmail" class="form-control" placeholder="Nombre Rol Servidor" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                           
                                        </tr>
                       
                                </table>
                            </div>
                               
                                    <div>
                                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                                    </div>
                              
                        </form>
                           <!-- End # DIV Form -->                   
                </center>
                                                                                  <%
    
         if(s!=null){
            %>
              <div class="flex-caption">
            <h3>Nuevo Sistema Operativo</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="sisdis" type="text" id="inputEmail" class="form-control" placeholder="Sistema Distribucion" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="nsis" type="text" id="inputEmail" class="form-control" placeholder="Nombre Sistema" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                        </tr>
                       
                                </table>
                            </div>
                               
                                    <div>
                                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                                    </div>
                              
                        </form>
                           <!-- End # DIV Form -->                   
                </center>
            <%}
else{
            %>
              <div class="flex-caption">
            <h3>tabla de servidores</h3>              
        </div>
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/aserver.htm"/>">agregar</a> 
                    
                </div>
            <div class="card mb-3">
                <div class="card-header">
                  <i class="fa fa-table"></i> Data Table servidores</div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">            
                        <thead>
                         <tr>
                            <th>TblServSerial</th>
                            <th>TblServHostName</th>
                            <th>TblMarcaMarca</th>
                            <th>TblModeloModelo</th>
                            <th>TblClienteNombre</th>
                            <th>TblSoNombre</th>
                            <th>TblGrupoNombre</th>
                            <th>TblEstadoEstado</th>
                         </tr>
                        </thead>
                        <tfoot>
                         <tr>
                            <th>TblServSerial</th>
                            <th>TblServHostName</th>
                            <th>TblMarcaMarca</th>
                            <th>TblModeloModelo</th>
                            <th>TblClienteNombre</th>
                            <th>TblSoNombre</th>
                            <th>TblGrupoNombre</th>
                            <th>TblEstadoEstado</th>
                         </tr>
                        </tfoot>
                        <tbody>        
                         <c:forEach var="f" items="${requestScope.listaServer}">
                         <tr>
                                <td>${f.serSerial}</td>
                                <td>${f.serHostname}</td>
                                <td>${f.marIdMarca.marNomMarca}</td>
                                <td>${f.modIdModelo}</td>
                                <td>${f.cenIdCentral}</td>
                                <td>${f.sisIdSisOperativo.sisNombre}</td>
                                <td>${f.gruIdGrupo.gruNomGrupo}</td>
                                <td>${f.estIdEstado.estEstado}</td>              
                         </tr>
                         </c:forEach>               
                        </tbody>
                    </table>
                  </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
            <!-- fin de tabla-->                   
            <!-- Begin # DIV Form -->
 <%}%>
    </div>       
   <%@include file="/WEB-INF/plantilla/foter.jsp" %>
</body>
</html>
