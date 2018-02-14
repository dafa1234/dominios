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
                Integer m = (Integer) request.getAttribute("m");
                if (m == 1) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Editar Servidor</div> 
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
                        <td> <input  name="login" type="text"  id="inputPassword" class="form-control" placeholder="login" required>  </td>
                        <td> <input  name="nombre" type="text"  id="inputPassword" class="form-control" placeholder="nombre usuario" required>  </td>
                        <td> <input  name="tarea" type="text"  id="inputPassword" class="form-control" placeholder="tarea" required>  </td>                            
                        <td> <select name="administrado" class="form-control" required>
                                    <option value="">Administracion </option>
                                    <option value="1">SI</option> 
                                    <option value="0">NO</option>                                                  
                                </select>  </td> 
                        <td>   
                            <select name="servid" class="form-control" required>
                                <option value="">servidor</option>
                                <c:forEach var="f" items="${requestScope.Listaserver}">
                                    <option value="${f.serServer}">${f.serSerial}   -    ${f.serHostname}</option>
                                </c:forEach>
                            </select>
                        </td>                            
                    </tr>
                </table>                     
                <div>
                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">ingresar</button>
                </div>                    
            </form>   
            </div>
            <%   }
                if (m == 4) {%>
           <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Editar Servidor</div> 
                <h2>modificar usuarios servidor</h2>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/usuarioservidor.htm"/>">volver</a>
            </div>
            <form id="forminicio" action="modificar.htm" method="Post">
                <div class="modal-body" >  

                    <span>usuario</span>:
                    <label >${ getUsuCorreo}</label><br/><br/>
                    <span>serial</span>:
                    <label >${ getUsuApell}</label><br/><br/>

                    <input  name="id" type="hidden" value="${ email}" >
                    <span>tarea</span>
                    <input  name="tarea" type="text" id="inputPassword" class="form-control" placeholder="ingrese tarea" required><br/><br/>
                    <span>estado</span>
                    <select name="serv" class="form-control" required>
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
           </div>
            <%
                }
                if (m == 2) {
            %>
          <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Editar Servidor</div> 
            <h2>detalles de usuarios de servidor</h2>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/usuarioservidor.htm"/>">volver</a>
            </div>
            <div class="card mb-3">
                <table class="table table-bordered"  width="100%" cellspacing="0">
                    <tr> 
                        <th><span>usuario</span>:</th> 
                        <td><label >${ ususLogin}</label><br/><br/></td>
                    </tr>
                    <tr>
                        <th><span>nombre</span>:</th>
                        <td><label >${ ususNombre}</label><br/><br/></td>
                    </tr>         

                    <tr>
                        <th><span>estado</span>:</th>
                        <td><label >${ ususEstado}</label><br/><br/></td>
                    </tr>

                    <tr>
                        <th><span>admin</span>:</th>
                        <td><label >${ ususAdm}</label><br/><br/></td>
                    </tr>

                    <tr>
                        <th><span>serial</span>:</th>
                        <td><label >${ ususServ}</label><br/><br/></td>
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
          </div>
            <%
                }
                if (m == 3) {%>
         <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Editar Servidor</div> 
                <h2>lista de usuarios de servidores</h2>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/usuarioservidor.htm"/>">volver</a>
            </div>
            <table>
                <tr>
                    <td><input type="button" id="btnExport" value="Descargar a Excel "/></td>
                </tr>
            </table>
            <div id="usuarioservidor" class="card mb-3">
                <div class="card-header">
                           <h3><i class="fa fa-table"></i>${titulo}</h3> </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">            
                            <thead>
                                <tr>
                                    <th>usuario id</th>
                                    <th>usuario login</th>
                                    <th>usuario nombre</th>
                                    <th>usuario estado</th>                        
                                    <th>usuario hostname</th>
                                 
                                    <th>usuario admin</th>
                                </tr>
                            </thead>

                            <tbody>        

                                <c:forEach var="f" items="${requestScope.listreporte}">
                                    <tr>                            
                                        <td>${f.ususId}</td>
                                        <td>${f.ususLogin}</td>
                                        <td>${f.ususNombre}</td>
                                        <td>${f.ususEstado.estuEstado}</td>
                                        <td>${f.idSerServidor.serHostname}</td>
                                    
                                        <td>${f.ususAdm}</td>
                                    </tr>
                                </c:forEach>  

                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            <script>
                $("#btnExport").click(function (e) {
                    window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#usuarioservidor').html() + name));
                    e.preventDefault();
                });
            </script>
         </div>
            <%}
                if (m == 0) {
            %>
          <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Editar Servidor</div> 
            <h2>lista de usuarios de servidores</h2>
                  <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-3">
                       <div class="box-bottom">
                <a  role="button" href="<c:url value="/usuarioos.htm"/>">agregar</a>
            </div>
                    </div>
                    <div class="col-md-3">
                        <div class="flex-caption">
                         <div class="box-bottom">
                    <a  role="button" data-toggle="modal" data-target="#login-modal">REPORTE</a>
                </div>
                        </div>
                    </div>
                    <div class="col-md-3"></div>
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
                                    <th>usuario hostname</th>
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
                                    <th>usuario hostname</th>                              
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
                                        <td>${f.idSerServidor.serHostname}</td>
                                        
                                        <td>${f.ususAdm}</td>
                                        <td> 
                                            <form id="forminicio" action="usuarios.htm" method="Post">
                                                <input  name="id" type="hidden" value="${f.ususId}">
                                                <div>
                                                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="button45 button46">modificar</button>
                                                </div>
                                            </form>

                                        </td>
                                        <td> 
                                            <form id="forminicio" action="detalle.htm" method="Post">
                                                <input  name="id" type="hidden" value="${f.ususId}">
                                                <input  name="usu" type="hidden" value="${f.ususLogin}">
                                                <div>
                                                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar"class="button45 button46">detalle</button>
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
          </div>
                     <%
                }
                if (m == 5) {
            %>          
<div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar nuevo usuario servidor</h2></div>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/modiusuario.htm"/>">volver</a>
            </div>
            <form id="forminicio" action="modiusuario.htm" method="Post">
                <table class="table table-bordered" id="ataTable" width="100%" cellspacing="0">            
                    <tr>                           
                        <th>login</th>
                        <th>nombre</th>
                        <th>estado</th>
                        <th>aministrado</th> 
                        <th>servidor</th>  
                        <th>tarea cambio</th>
                    </tr>
                    <tr>
                        <td> <input  name="login" type="text" value="${requestScope.usuer.ususLogin}" id="inputPassword" class="form-control" placeholder="login" required>  </td>
                        <td> <input  name="nombre" type="text" value="${requestScope.usuer.ususNombre}" id="inputPassword" class="form-control" placeholder="nombre usuario" required>  </td>
                        <td> 
                          <select name="estado" class="form-control" required>
                                    <option value="${requestScope.usuer.ususEstado.ususEstado}">${requestScope.usuer.ususEstado.estuEstado}</option>
                                    <c:forEach var="f" items="${requestScope.Listausuest}">
                                        <option value="${f.ususEstado}">${f.estuEstado}</option>
                                    </c:forEach>
                                </select><br/><br/>
                        </td>   
                        <td> <select name="administrado" class="form-control" required>
                                <option value="${requestScope.usuer.ususAdm}">${requestScope.usuer.ususAdm} </option>
                                <option value="1">SI</option> 
                                <option value="0">NO</option>                                                  
                            </select>  </td> 
                        <td>   
                              <input  name="servid" type="hidden" value="${requestScope.usuer.ususId}"  id="inputPassword" class="form-control" placeholder="tarea" required>
                            <select name="servid1" class="form-control" required>
                                <option value="${requestScope.usuer.idSerServidor.serServer}">${requestScope.usuer.idSerServidor.serSerial}</option>
                                <c:forEach var="f" items="${requestScope.Listaserver}">
                                    <option value="${f.serServer}">${f.serSerial}   -    ${f.serHostname}</option>
                                </c:forEach>
                            </select>
                        
                           
                        </td>   
                         <td> <input  name="tareacambio" type="text" id="inputPassword" class="form-control" placeholder="tarea cambio" required>  </td>
                    </tr>
                </table>                     
                <div>
                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">ingresar</button>
                </div>                    
            </form>   
</div>
            <%
                }
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
                                    <input type="hidden"  name="F" value="2">
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