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
                <div class=" panel-heading"><h2>crear cronograma</h2></div>
                <!-- Begin # DIV Form -->
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/cronograma.htm"/>">volver</a> 
                </div>     

                <!-- Begin # DIV Form -->
                <div id="div-forms" >

                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="crono.htm" method="Post">
                        <div class="row">
                            <div class="col-md-4">

                                <label class="control-label">proyecto</label>
                                <select name="proyecto" class="form-control" v>
                                    <option value="">proyecto</option>
                                    <c:forEach var="f" items="${requestScope.ListaProyecto}">
                                        <option value="${f.proId}">${f.proTitulo}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">servidor</label>
                                <select name="servidor" class="form-control" required>
                                    <option value="">servidor</option>
                                    <c:forEach var="f" items="${requestScope.listaFonos}">
                                        <option value="${f.serServer}">${f.serHostname}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">fecha inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicial" ><br/><br/>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label">fecha proxima</label>
                                <input  name="fprox" type="text" id="Fecha_Prox" class="form-control" placeholder="fecha proxima" ><br/><br/>
                                <label class="control-label">fecha fin</label>
                                <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha fin" ><br/><br/>
                                <label class="control-label">estado</label>
                                <select name="estini" class="form-control" required>
                                    <option value="">estado inicial</option>
                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                        <option value="${f.estmId}">${f.estmEstado}</option>
                                    </c:forEach>

                                </select><br/><br/>
                            </div> 
                            <div class="col-md-4">
                                <label class="control-label">ejecuta</label>
                                <input   name="ejecuta" type="text" id="inputEmail" class="form-control" placeholder="ejecuta"  required><br/><br/>
                                <label class="control-label">cambio</label>
                                <textarea   name="cambio" type="text" id="inputEmail" class="form-control" placeholder="cambio"  required></textarea><br/><br/>
                                <label class="control-label">observacion</label>
                                <textarea   name="observacion" type="text" id="inputEmail" class="form-control" placeholder="observacion"  ></textarea><br/><br/>
                            </div>
                        </div>
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
                if (m == 2) {%>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>cronograma mto</h2></div>  
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-3">
                        <div class="box-bottom">
                            <a  role="button" href="<c:url value="/newcrono.htm"/>">agregar</a> 
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
                        <i class="fa fa-table"></i> Data Table cronograma</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                                <thead>
                                    <TR>
                                        <th>ID</th>
                                        <th>SERIAL</th>
                                        <th>PROYECTO</th>
                                        <th>FECHA INICIO</th>
                                        <th>FECHA PROX</th>
                                        <th>FECHA FIN</th>
                                        <th>FECHA COMBIO FIN</th>
                                        <th>EJECUTA</th>
                                        <th>ESTADO</th>
                                        <th>OBSERVACION</th>
                                        <th>modificar</th>
                                    </tr>
                                </thead>

                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>SERIAL</th>
                                        <th>PROYECTO</th>
                                        <th>FECHA INICIO</th>
                                        <th>FECHA PROX</th>
                                        <th>FECHA FIN</th>
                                        <th>FECHA COMBIO FIN</th>
                                        <th>EJECUTA</th>
                                        <th>ESTADO</th>
                                        <th>OBSERVACION</th>
                                        <th>modificar</th>
                                    </tr>
                                </tfoot>
                                <tbody>        
                                    <c:forEach var="f" items="${requestScope.listaCrono}">
                                        <tr>
                                            <td>${f.croId}</td>
                                            <td>${f.croSerial.serHostname}</td>
                                            <td>${f.croProyecto.proTitulo}</td>
                                            <td>${f.croFechaIni}</td>
                                            <td>${f.croFechaProx}</td>
                                            <td>${f.croFechaFin}</td>
                                            <td>${f.croCambioFin}</td>
                                            <td>${f.croEjecuta}</td>
                                            <td>${f.croEstado.estmEstado}</td>
                                            <td>${f.croObservacion}</td>
                                            <td>
                                                <form id="forminicio" action="cronogramamod.htm" method="Post">
                                                    <input  name="idcron" type="hidden" value="${f.croId}">

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
                if (m == 3) {%>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>reporte cronograma mto</h2></div>  
             
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/cronograma.htm"/>">volver</a> 
                </div>
                <table>
                    <tr>
                        <td><input type="button" class="btn btn-success btn-lg "  id="btnExport" value="Descargar a Excel "/></td>
                    </tr>
                </table>
                <div id="cronog" class="card mb-3">
                    <div class="card-header">
                        <h3><i class="fa fa-table"></i>${titulo}</h3> </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">             
                                <thead>
                                    <TR>
                                        <th>ID</th>
                                        <th>SERIAL</th>
                                        <th>PROYECTO</th>
                                        <th>FECHA INICIO</th>
                                        <th>FECHA PROX</th>
                                        <th>FECHA FIN</th>
                                        <th>FECHA COMBIO FIN</th>
                                        <th>EJECUTA</th>
                                        <th>ESTADO</th>
                                        <th>OBSERVACION</th>
                                    </tr>
                                </thead>             

                                <tbody>        
                                    <c:forEach var="f" items="${requestScope.listreporte}">
                                        <tr>
                                            <td>${f.croId}</td>
                                            <td>${f.croSerial.serHostname}</td>
                                            <td>${f.croProyecto.proTitulo}</td>
                                            <td>${f.croFechaIni}</td>
                                            <td>${f.croFechaProx}</td>
                                            <td>${f.croFechaFin}</td>
                                            <td>${f.croCambioFin}</td>
                                            <td>${f.croEjecuta}</td>
                                            <td>${f.croEstado.estmEstado}</td>
                                            <td>${f.croObservacion}</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
                <script>
                    $("#btnExport").click(function (e) {
                        window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#cronog').html() + name));
                        e.preventDefault();
                    });
                </script>
            </div>

            <%}
                if (m == 4) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar cronograma</h2></div>
                <!-- Begin # DIV Form -->
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/cronograma.htm"/>">volver</a> 
                </div>     

                <!-- Begin # DIV Form -->
                <div id="div-forms" >

                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="modcrono.htm" method="Post">

                        <div class="row">
                            <div class="col-md-4">
                                <label class="control-label">tarea cambio</label> 
                                <input   name="tareacambio" type="text" id="inputEmail" class="form-control" placeholder="tarea cambio"  required><br/><br/>
                            </div>
                            <div class="col-md-4"></div>
                            <div class="col-md-4"></div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">

                                <input  name="idcro" type="hidden"  value="${requestScope.crono.croId}" class="form-control" placeholder="fecha fin" required>
                                <label class="control-label">proyecto</label>
                                <select name="proyecto" class="form-control" v>
                                    <option value="${requestScope.crono.croProyecto.proId}">${requestScope.crono.croProyecto.proTitulo}</option>
                                    <c:forEach var="f" items="${requestScope.ListaProyecto}">
                                        <option value="${f.proId}">${f.proTitulo}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">servidor</label>
                                <select name="servidor" class="form-control" required>
                                    <option value="${requestScope.crono.croSerial.serServer}">${requestScope.crono.croSerial.serHostname}</option>
                                    <c:forEach var="f" items="${requestScope.listaFonos}">
                                        <option value="${f.serServer}">${f.serHostname}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">fecha inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" value="${requestScope.crono.croFechaIni}" class="form-control" placeholder="fecha inicial" required><br/><br/>
                            </div> 
                            <div class="col-md-4">
                                <label class="control-label">fecha proxima</label>
                                <input  name="fprox" type="text" id="Fecha_Prox" value="${requestScope.crono.croFechaProx}" class="form-control" placeholder="fecha proxima" required><br/><br/>
                                <label class="control-label">fecha fin</label>
                                <input  name="ffin" type="text" id="Fecha_Fin" value="${requestScope.crono.croFechaFin}" class="form-control" placeholder="fecha fin" required><br/><br/>
                                <label class="control-label">estado</label>
                                <select name="estini" class="form-control" required>
                                    <option value="${requestScope.crono.croEstado.estmId}">${requestScope.crono.croEstado.estmEstado}</option>
                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                        <option value="${f.estmId}">${f.estmEstado}</option>
                                    </c:forEach>
                                </select><br/><br/>
                            </div> 
                            <div class="col-md-4">
                                <label class="control-label">ejecuta</label>
                                <input   name="ejecuta" type="text" id="inputEmail" value="${requestScope.crono.croEjecuta}" class="form-control" placeholder="ejecuta"  required><br/><br/>
                                <label class="control-label">cambio</label>
                                <textarea   name="cambio" type="text" id="inputEmail" value="${requestScope.crono.croCambioFin}"  class="form-control" placeholder="cambio"  required>${requestScope.crono.croCambioFin}</textarea><br/><br/>
                                <label class="control-label">abservacion</label>
                                <textarea   name="observacion" type="text" id="inputEmail" value="${requestScope.crono.croObservacion}"  class="form-control" placeholder="observacion"  >${requestScope.crono.croObservacion}</textarea><br/><br/>
                            </div> 
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
                                    <input type="hidden"  name="F" value="3">
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