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
   <%
         Integer m = (Integer)request.getAttribute("m");
        %>
<body>
   <%@include file="/WEB-INF/plantilla/header.jsp" %>
    <div class="content-wrapper">
        </br></br>
        <div class="flex-caption">
            <h3>tabla de servidores</h3> 
              
        </div>
        <%
         if(m==1){ 
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
                                                <select name="modelo" class="form-control">
                                                    <option value="">modelo</option>
                                                    <c:forEach var="f" items="${requestScope.listaModelo}">
                                                        <option value="${f.modIdModelo}">${f.modNomModelo}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
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
                                                   <select name="dc" class="form-control">
                                                    <option value="">data center o salon</option>
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
                                                <select name="cliente" class="form-control">
                                                    <option value="">cliente</option>
                                                    <c:forEach var="f" items="${requestScope.listaCliente}">
                                                        <option value="${f.cliIdCliente}">${f.cliNombre}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
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
            <%
                }
 if(m==2){%>
        <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
        </div>
        <center>
            <div class="card mb-3">
                <div class="card-header">
                  <i class="fa fa-table"></i>servidor</div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-bordered"  width="100%" cellspacing="0">            
                       
                         <tr>
                            <th>ID :</th>
                            <td>${requestScope.idser}</td>
                            <th>SERIAL :</th>
                            <td>${requestScope.serial}</td>
                            <th>HONTNAME :</th>
                            <td>${requestScope.hostname}</td>
                           
                         <tr/>
                         <tr> 
                            <th>MARCA :</th>
                            <td>${requestScope.marca}</td>
                            <th>MODELO :</th>
                            <td>${requestScope.modelo}</td>
                            <th>SISTEMA OPERATIVO :</th>
                            <td>${requestScope.sisoperativo}</td>
                         </tr>
                         <tr> 
                            <th>CONEXION :</th>
                            <td>${requestScope.conexion}</td>
                            <th>ESTADO :</th>
                            <td>${requestScope.estado}</td>
                            <th>CENTRAL :</th>
                            <td>${requestScope.central}</td>
                          <tr/>
                          <tr>
                            <th>SALON :</th>
                            <td>${requestScope.salon}</td>
                            <th>RACK :</th>
                            <td>${requestScope.rack}</td>
                            <th>UNIDAD :</th>
                            <td>${requestScope.unidad}</td>
                          </tr>
                          <tr>
                            <th>GRUPO  :</th>
                            <td>${requestScope.grupo}</td>
                            <th>CLIENTE :</th>
                            <td>${requestScope.cliente}</td>
                            <th>PROYECTO :</th>
                            <td>${requestScope.proyecto}</td>
                          </tr>
                          <tr>
                            <th>ROL SERVIDOR :</th>
                            <td>${requestScope.rolserv}</td>
                            <th>PLATAFORMA :</th>
                            <td>${requestScope.plataforma}</td>
                            <th>FECHA INGRESO :</th>
                            <td>${requestScope.fingreso}</td>
                          </tr>
                          <tr>
                            <th>TAREA INGRESO :</th>
                            <td>${requestScope.tingreso}</td>
                            <th>No PROCESOS FISICOS :</th>
                            <td>${requestScope.npfisicos}</td>
                            <th>FORMATO AD COMPARTIDA :</th>
                            <td>${requestScope.foradcompartida}</td>
                          </tr>
                          <tr>
                            <th>ADMINISTRACION COMPARTIDA :</th>
                            <td>${requestScope.adcompartida}</td>
                            <th>ADMINISTRADO :</th>
                            <td>${requestScope.administrada}</td>
                            <th>CORES :</th>
                            <td>${requestScope.cores}</td>
                          </tr>
                    </table>
                  </div>
                </div>
                
            </div>
            <div class="card mb-3">
                <div class="card-header">
                  <i class="fa fa-table"></i>descripccion id</div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">            
                        <thead>
                         <tr>
                            
                            <th>ID</th>
                            <th>IP</th>
                            <th>TIPO</th>
                            <th>VLAN</th>
                            <th>SWITCH</th>
                            <th>PUERTO</th>
                            
                         </tr>
                        </thead>
                        <tfoot>
                         <tr>
                            
                            <th>ID</th>
                            <th>IP</th>
                            <th>TIPO</th>
                            <th>VLAN</th>
                            <th>SWITCH</th>
                            <th>PUERTO</th>
                            
                            
                         </tr>
                        </tfoot>
                        <tbody>        
                         <c:forEach var="f" items="${requestScope.direccionamientocoll}">
                         <tr>
                                <td>${f.dirId}</td>
                                <td>${f.dirIp}</td>
                                <td>${f.dirTipo.tipTipoIp}</td>
                                <td>${f.dirVlan}</td>
                                <td>${f.dirSwitch}</td>
                                <td>${f.dirPuerto}</td>
                                              
                         </tr>
                         </c:forEach>               
                        </tbody>
                    </table>
                  </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
        </center>            

        <%
}
if(m==0){
            %>
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/aserver.htm"/>">agregar</a> 
                    
                </div>
                    <div class="flex-caption">
                                  <h3>Bienvenido</h3> 
                                  <div class="box-bottom">
                                      <a  role="button" data-toggle="modal" data-target="#login-modal">REPORTE</a>
                                   </div>
                    </div>
            <div class="card mb-3">
                <div class="card-header">
                  <i class="fa fa-table"></i> Data Table servidores</div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">            
                        <thead>
                         <tr>
                            <th>ID</th>
                            <th>TblServSerial</th>
                            <th>TblServHostName</th>
                            <th>TblMarcaMarca</th>
                            <th>TblModeloModelo</th>
                            <th>TblClienteNombre</th>
                            <th>TblSoNombre</th>
                            <th>TblGrupoNombre</th>
                            <th>TblEstadoEstado</th>
                            <th>detalle</th>
                         </tr>
                        </thead>
                        <tfoot>
                         <tr>
                              <td>ID</td>
                            <th>TblServSerial</th>
                            <th>TblServHostName</th>
                            <th>TblMarcaMarca</th>
                            <th>TblModeloModelo</th>
                            <th>TblClienteNombre</th>
                            <th>TblSoNombre</th>
                            <th>TblGrupoNombre</th>
                            <th>TblEstadoEstado</th>
                            <th>detalle</th>
                         </tr>
                        </tfoot>
                        <tbody>        
                         <c:forEach var="f" items="${requestScope.listaServer}">
                         <tr>
                                <td>${f.serServer}</td>
                                <td>${f.serSerial}</td>
                                <td>${f.serHostname}</td>
                                <td>${f.marIdMarca.marNomMarca}</td>
                                <td>${f.modIdModelo.modNomModelo}</td>
                                <td>${f.cliIdCliente.cliNombre}</td>
                                <td>${f.sisIdSisOperativo.sisNombre}</td>
                                <td>${f.gruIdGrupo.gruNomGrupo}</td>
                                <td>${f.estIdEstado.estEstado}</td>    
                                <td> 
                                     <form id="forminicio" action="TdServ.htm" method="Post">
                                         <input  name="tdserv" type="hidden" value="${f.serServer}">
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
            <!-- fin de tabla-->                   
            <!-- Begin # DIV Form -->
<%
}
if(m==3){
            %>
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
            </div>
            <div class="card mb-3">
                <div class="card-header">
                  <i class="fa fa-table"></i> Data Table servidores</div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">            
                        <thead>
                         <tr>
                            <th>ID</th>
                            <th>TblServSerial</th>
                            <th>TblServHostName</th>
                            <th>TblMarcaMarca</th>
                            <th>TblModeloModelo</th>
                            <th>TblClienteNombre</th>
                            <th>TblSoNombre</th>
                            <th>TblGrupoNombre</th>
                            <th>TblEstadoEstado</th>
                            <td>estIdEstadoestEstado</td>  
                            
                         </tr>
                        </thead>
                        <tfoot>
                         <tr>
                              <td>ID</td>
                            <th>TblServSerial</th>
                            <th>TblServHostName</th>
                            <th>TblMarcaMarca</th>
                            <th>TblModeloModelo</th>
                            <th>TblClienteNombre</th>
                            <th>TblSoNombre</th>
                            <th>TblGrupoNombre</th>
                            <th>TblEstadoEstado</th>
                            <td>estIdEstadoestEstado</td>  
                            
                         </tr>
                        </tfoot>
                        <tbody>        
                         <c:forEach var="f" items="${requestScope.listreporte}">
                         <tr>
                                <td>${f.serServer}</td>
                                <td>${f.serSerial}</td>
                                <td>${f.serHostname}</td>
                                <td>${f.marIdMarca.marNomMarca}</td>
                                <td>${f.modIdModelo.modNomModelo}</td>
                                <td>${f.cliIdCliente.cliNombre}</td>
                                <td>${f.sisIdSisOperativo.sisNombre}</td>
                                <td>${f.gruIdGrupo.gruNomGrupo}</td>
                                <td>${f.estIdEstado.estEstado}</td>  
                                <td>${f.serFIngreso}</td>  
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
<%}
%>
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
<div class="modal-dialog">
    <div class="modal-content" style="background: #20a4cb">
        <div class="modal-header" align="center">
            <span>REPORTE</span>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
            </button>
        </div>
        <!-- Begin # DIV Form -->
        <div id="div-forms" >
            <!-- Begin # Login Form -->
            <form id="forminicio" action="serversreport.htm" method="Post">
                <div class="modal-body" style="background: #20a4cb"> 
                    <div id="div-login-msg">
                        <div  id="icon-login-msg" class="glyphicon glyphicon-user"></div>
                    </div>
                    <input id="login_username" class="form-control" type="text" name="F_Inicio" placeholder="Fecha Inicio" required="" autocomplete="off">
                    <div id="div-login-msg">
                        <div id="icon-login-msg" class="glyphicon glyphicon-minus-sign"></div>
                    </div>
                    <input id="login_password" class="form-control" type="text"  name="F_Fin" placeholder="Fecha Fin" required="">
                    <input type="hidden"  name="F" value="1">
                </div>
                <div class="modal-footer" style="background:#ff5c39">
                    <div>
                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: #ffffff">INGRESAR</button>
                    </div>
                </div>
            </form>
            <!-- End # DIV Form -->
        </div>
    </div>
</div>
</div>
    </div>       
   <%@include file="/WEB-INF/plantilla/foter.jsp" %>
</body>
</html>
