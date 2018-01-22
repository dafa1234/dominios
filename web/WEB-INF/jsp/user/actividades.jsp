<%-- 
    Document   : actividadaes
    Created on : 29/09/2017, 10:22:42 AM
    Author     : diegfraa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/plantilla/head.jsp" %>
    <body>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
        <div class="content-wrapper">
            </br></br>

            <div class="flex-caption">
                <h3>tabla de actividades</h3> 



            </div>
            <%
                Integer m = (Integer) request.getAttribute("m");

                if (m == 1) {
            %>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/actividades.htm"/>">volver</a> 
            </div>              
            <!-- Begin # DIV Form -->

            <center>
                <!-- Begin # Login Form -->
                <form action="act.htm" method="Post">

                    <table>
                        <tr>

                            <td>                              
                                <select name="tipo" class="form-control" required>
                                    <option value="">tipo</option>
                                    <c:forEach var="f" items="${requestScope.Listatipoactiv}">
                                        <option value="${f.tipaId}">${f.tipaNombre}</option>
                                    </c:forEach>
                                </select><br/><br/>
                            </td>
                            <td>    
                                <input   name="serv" type="text" id="inputEmail" class="form-control" placeholder="servidor" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input  name="eje" type="text" id="inputPassword" class="form-control" placeholder="ejecuta" required><br/><br/>
                            </td>

                            <td>    
                                <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicio" required><br/><br/>
                            </td>
                        </tr>
                        <tr>
                            <td>       
                                <input   name="tarea" type="text" id="inputEmail" class="form-control" placeholder="tarea" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                            </td>

                            <td>     <input  name="desc" type="text" id="inputPassword" class="form-control" placeholder="descripcion" required><br/><br/></td>
                        </tr>
                        <tr>
                            <td>     <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha fin" required><br/><br/></td>

                            <td>      <input   name="sol" type="text" id="inputEmail" class="form-control" placeholder="solicita" required autofocus class="nav nav-pills nav-stacked"><br/><br/></td>
                        </tr>                             
                    </table>


                    <div>
                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                    </div>


                </form>
            </center>



            <%}
                if (m == 2) {%>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/newactiv.htm"/>">agregar</a> 
            </div>
            <div class="flex-caption">
                <h3>Bienvenido</h3> 
                <div class="box-bottom">
                    <a  role="button" data-toggle="modal" data-target="#login-modal">REPORTE</a>
                </div>                          
            </div>
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i> Actividades abiertas</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>              
                                    <th>ID</th>
                                    <th>HOST</th>
                                    <th>TIPO</th>
                                    <th>TAREA</th>
                                    <th>FECHA_INICIO</th>
                                    <th>FECHA_FIN</th>
                                    <th>DESCRIPCION</th>              

                                </tr>
                            </thead>

                            <tfoot>
                                <tr>
                                    <th>ID</th>
                                    <th>HOST</th>
                                    <th>TIPO</th>
                                    <th>TAREA</th>
                                    <th>FECHA INICIO</th>
                                    <th>FECHA FIN</th>
                                    <th>DESCRIPCION</th>              

                                </tr>
                            </tfoot>
                            <tbody>        
                                <c:forEach var="f" items="${requestScope.listaActividad}">
                                    <tr>
                                        <td>${f.actId}</td>
                                        <td>${f.actEjecuta}</td>
                                        <td>${f.actTipo.tipaNombre}</td>
                                        <td>${f.actTarea}</td>
                                        <td>${f.actFechaIni}</td>
                                        <td>${f.actFechaFin}</td>
                                        <td>${f.actDescripcion}</td>

                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
            <%}
                if (m == 3) {
            %>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/actividades.htm"/>">volver</a> 
            </div>   
            <table>
                <tr>
                    <td><input type="button" id="btnExport" value="Descargar a Excel "/></td>
                </tr>
            </table>
            <div id="activi" class="card mb-3">
                <div class="card-header">
                    <h3><i class="fa fa-table"></i>${titulo}</h3> </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered"  width="100%" cellspacing="0">
                            <thead>
                                <tr>              
                                    <th>ID</th>
                                    <th>HOST</th>
                                    <th>TIPO</th>
                                    <th>TAREA</th>
                                    <th>FECHA_INICIO</th>
                                    <th>FECHA_FIN</th>
                                    <th>DESCRIPCION</th>              

                                </tr>
                            </thead>

                            <tbody>        
                                <c:forEach var="f" items="${requestScope.listreporte}">
                                    <tr>
                                        <td>${f.actId}</td>
                                        <td>${f.actEjecuta}</td>
                                        <td>${f.actTipo.tipaNombre}</td>
                                        <td>${f.actTarea}</td>
                                        <td>${f.actFechaIni}</td>
                                        <td>${f.actFechaFin}</td>
                                        <td>${f.actDescripcion}</td>

                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>      
            </div>
            <script>
                $("#btnExport").click(function (e) {
                    window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#activi').html() + name));
                    e.preventDefault();
                });
            </script>
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
                                    <input type="hidden"  name="F" value="6">
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
