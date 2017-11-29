<%-- 
    Document   : nar
    Created on : 23/10/2017, 02:27:48 PM
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
        <div class="flex-caption">
            <h3>tabla de servidores</h3> 
              
        </div>
                               <%
            String m = (String)request.getAttribute("m");
    
         if(m!=null){
            %>
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
                                                <input   name="serial" type="text" id="inputEmail" class="form-control" placeholder="serial" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td>                              
                                                <select name="marca" class="form-control">
                                                    <option value="">marca</option>
                                                    <c:forEach var="f" items="${requestScope.listaFonos}">
                                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                            <td> 
                                                   <select name="estado" class="form-control">
                                                    <option value="">estado</option>
                                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                                        <option value="${f.estIdEstado}">${f.estEstado}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                        </tr>
                                        <tr> 
                                            
                                            
                                        </tr>
                                        <tr> 
                                            <td>     
                                                   <select name="sisoperativo" class="form-control">
                                                    <option value="">sisoperativo</option>
                                                    <c:forEach var="f" items="${requestScope.listaSis}">
                                                        <option value="${f.sisIdSisOperativo}">${f.sisNombre}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                            <td>
                                                <input   name="hostname" type="text" id="inputEmail" class="form-control" placeholder="hostname" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input  name="modelo" type="text" id="inputPassword" class="form-control" placeholder="modelo" required><br/><br/>
                                            </td>
                                        </tr>
                                        <tr> 
                                            <td>     
                                                <select name="grupo" class="form-control">
                                                    <option value="">grupo</option>
                                                    <c:forEach var="f" items="${requestScope.listaGrupo}">
                                                        <option value="${f.gruIdGrupo}">${f.gruNomGrupo}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                            <td> 
                                                <input  name="prosesos" type="text" id="inputPassword" class="form-control" placeholder="numero de prosesos" required><br/><br/>
                                            </td>
                                             <td> 
                                                <input   name="cores" type="text" id="inputEmail" class="form-control" placeholder="cores" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                        </tr>
                                        <tr> 
                                           
                                           
                                        </tr>
                                        <tr> 
                                            <td>      
                                                <input  name="conexion" type="text" id="inputPassword" class="form-control" placeholder="conexion" required><br/><br/>
                                            </td>
                                            <td>  
                                                   <select name="central" class="form-control">
                                                    <option value="">central</option>
                                                    <c:forEach var="f" items="${requestScope.listaCentral}">
                                                        <option value="${f.cenIdCentral}">${f.cenNombre}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                            <td> 
                                                   <select name="data center o salon" class="form-control">
                                                    <option value="">dc</option>
                                                    <c:forEach var="f" items="${requestScope.listaSalon}">
                                                        <option value="${f.salIdSalon}">${f.salNombre}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                        </tr>
                                        <tr>  
                                            <td> 
                                                <input   name="rack" type="text" id="inputEmail" class="form-control" placeholder="rack" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td>
                                                <input  name="unidad" type="text" id="inputPassword" class="form-control" placeholder="unidad" required><br/><br/>
                                            </td>
                                            <td>  
                                                   <select name="plataforma" class="form-control">
                                                    <option value="">plataforma</option>
                                                    <c:forEach var="f" items="${requestScope.listaPlat}">
                                                        <option value="${f.plaIdPlataforma}">${f.plaNomPlataforma}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                        </tr>
                                        <tr> 
                                          
                                          
                                        </tr>
                                        <tr> 
                                            <td> 
                                                <input  name="proyecto" type="text" id="inputPassword" class="form-control" placeholder="proyecto" required><br/><br/>
                                            </td>
                                            <td>
                                                <input   name="cliente" type="text" id="inputEmail" class="form-control" placeholder="cliente" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input  name="adplataforma" type="text" id="inputPassword" class="form-control" placeholder="adm. plataforma" required><br/><br/>
                                            </td>
                                        </tr>
                                        <tr> 
                                            <td> 
                                                   <select name="rol" class="form-control">
                                                    <option value="">rol</option>
                                                    <c:forEach var="f" items="${requestScope.listaRol}">
                                                        <option value="${f.rolIdRolServ}">${f.rolNomRolServ}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                            <td>
                                                <input  name="addominios" type="text" id="inputPassword" class="form-control" placeholder="adaministrado por el dominio" required><br/><br/>
                                            </td>
                                            <td>  
                                                <input   name="tarea" type="text" id="inputEmail" class="form-control" placeholder="tarea ingreso" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                        </tr>
                                        <tr> 
                                            
                                    
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
