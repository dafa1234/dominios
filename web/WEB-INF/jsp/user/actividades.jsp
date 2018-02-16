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
       
            <%
                Integer m = (Integer) request.getAttribute("m");

                if (m == 1) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Agregar actividad</h2></div>
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/actividades.htm"/>">volver</a> 
                </div>              
                <!-- Begin # DIV Form -->

                <!-- Begin # Login Form -->
                <form action="act.htm" method="Post">
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <label class="control-label">tipo actividad</label>
                            <select name="tipo" class="form-control" required>
                                <option value="">tipo</option>
                                <c:forEach var="f" items="${requestScope.Listatipoactiv}">
                                    <option value="${f.tipaId}">${f.tipaNombre}</option>
                                </c:forEach>
                            </select><br/><br/>
                            <label class="control-label">servidor actividad</label>
                            <select name="serv" class="form-control" required>
                                <option value="">servidor</option>
                                <c:forEach var="f" items="${requestScope.listaServer}">
                                    <option value="${f.serServer}">${f.serHostname}</option>
                                </c:forEach>
                            </select><br/><br/>
                            <label class="control-label">ejecuta actividads</label>
                            <input  name="eje" type="text" id="inputPassword" class="form-control" placeholder="ejecuta" required><br/><br/>
                            <label class="control-label">fecha inicio</label>
                            <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicio" required><br/><br/>
                        </div>
                        <div class="col-md-5">
                            <label class="control-label">tarea actividads</label>
                            <input   name="tarea" type="text" id="inputEmail" class="form-control" placeholder="tarea" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                            <label class="control-label">descripcion actividads</label>
                            <textarea  name="desc" type="text" id="inputPassword" class="form-control" placeholder="descripcion" required></textarea><br/><br/></td>
                            <label class="control-label">fecha fin</label>
                            <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha fin" required><br/><br/></td>
                            <label class="control-label">solicita actividads</label>
                            <input   name="sol" type="text" id="inputEmail" class="form-control" placeholder="solicita" required autofocus class="nav nav-pills nav-stacked"><br/><br/></td>

                        </div>
                    <div class="col-md-1"></div></div>
                    <div class="row">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <div><center>
                                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                            class="btn btn-success btn-lg "  >INGRESAR</button>
                                </center>
                            </div>
                        </div>
                        <div class="col-md-4"></div>
                    </div>


                </form>


            </div>

            <%}
                if (m == 2) {%>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>actividades</div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-3">
                        <div class="box-bottom">
                            <a  role="button" href="<c:url value="/newactiv.htm"/>">agregar</a> 
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
                        <i class="fa fa-table"></i> Actividades abiertas</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>              
                                        <th>ID</th>
                                        <th>ejecuta</th>
                                        <th>TIPO</th>
                                        <th>TAREA</th>
                                        <th>FECHA_INICIO</th>
                                        <th>FECHA_FIN</th>
                                        <th>DESCRIPCION</th>              
                                        <th>servidor</th>
                                        <th>modificar</th> 
                                    </tr>
                                </thead>

                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>ejecuta</th>
                                        <th>TIPO</th>
                                        <th>TAREA</th>
                                        <th>FECHA INICIO</th>
                                        <th>FECHA FIN</th>
                                        <th>DESCRIPCION</th>              
                                        <th>servidor</th>              
                                        <th>modificar</th> 
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
                                            <td>${f.actServ1.serSerial}</td>
                                            <td>
                                                <form id="forminicio" action="modacti.htm" method="Post">
                                                    <input  name="idact" type="hidden" value="${f.actId}">

                                                    <div>
                                                        <button  type="submit" class="button45 button46" title="Presione para ingresar">modificar</button>
                                                    </div>
                                                </form></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>
            </div>
            <%}
                if (m == 3) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>reporte actividades</h2></div>
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
            </div>

            <%
                }
                if (m == 10) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modoificar actividad</div>


                <!-- Begin # Login Form -->
                <form action="modactivi.htm" method="Post">
                    <div class="row">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <label class="control-label">Tarea Cambio:</label> <input   name="tareacambio" type="text" id="inputEmail" class="form-control" placeholder="tarea cambio"  required>
                            <br/><br/></div>
                        <div class="col-md-4"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <label class="control-label">tipo actividad</label>
                            <select name="tipo" class="form-control" required>
                                <option value="${requestScope.acti.actTipo.tipaId}">${requestScope.acti.actTipo.tipaNombre}</option>
                                <c:forEach var="f" items="${requestScope.Listatipoactiv}">
                                    <option value="${f.tipaId}">${f.tipaNombre}</option>
                                </c:forEach>
                            </select><br/><br/>

                            <input   name="serv" type="hidden" id="inputEmail"   required value="${requestScope.acti.actId}" >
                            <label class="control-label">servidor actividad</label>
                            <select name="servdor" class="form-control" required>
                                <option value="${requestScope.acti.actServ1.serServer}">${requestScope.acti.actServ1.serHostname}</option>
                                <c:forEach var="f" items="${requestScope.listaServer}">
                                    <option value="${f.serServer}">${f.serHostname}</option>
                                </c:forEach>
                            </select><br/><br/>
                            <label class="control-label">ejecuta actividad</label>
                            <input  name="eje" type="text" id="inputPassword" value="${requestScope.acti.actEjecuta}" class="form-control" placeholder="ejecuta" required><br/><br/>
                            <label class="control-label">fecha inicio</label>
                            <input  name="fini" type="text" id="Fecha_Inicio" value="${requestScope.acti.actFechaIni}" class="form-control" placeholder="fecha inicio" required><br/><br/>
                        </div>   <div class="col-md-5">
                            <label class="control-label">Tarea actividad</label>
                            <input   name="tarea" type="text" id="inputEmail" value="${requestScope.acti.actTarea}" class="form-control" placeholder="tarea" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                            <label class="control-label">descripcion actividad</label>
                            <textarea  name="desc" type="text" id="inputPassword" value="${requestScope.acti.actDescripcion}" class="form-control" placeholder="descripcion" required>${requestScope.acti.actDescripcion}</textarea><br/><br/></td>
                            <label class="control-label">fecha fin</label>   
                            <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" value="${requestScope.acti.actFechaFin}" placeholder="fecha fin" required><br/><br/></td>
                            <label class="control-label">solicita actividads</label>
                            <input   name="sol" type="text" id="inputEmail" class="form-control" value="${requestScope.acti.actSolicita}" placeholder="solicita" required autofocus class="nav nav-pills nav-stacked"><br/><br/></td>
                        </div>
                        <div class="col-md-1"></div>
                    </div>         
                    <div class="row">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <div><center>
                                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                            class="btn btn-success btn-lg "  >INGRESAR</button>
                                </center>
                            </div>
                        </div>
                        <div class="col-md-4"></div>
                    </div>


                </form>

            </div>
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
