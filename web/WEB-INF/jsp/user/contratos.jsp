<%-- 
    Document   : contratos
    Created on : 29/09/2017, 10:40:05 AM
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
                <h3>tabla de contratos</h3> 
            </div>
            <%
                Integer m = (Integer) request.getAttribute("m");

                if (m == 1) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>agregar contratos</div>
                <!-- Begin # DIV Form -->
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/contratos.htm"/>">volver</a> 
                </div>

                <!-- Begin # DIV Form -->
                <div id="div-forms" >
                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="contr.htm" method="Post">

                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-5">
                                <label class="control-label">proveedor</label>
                                <select name="proveedor" class="form-control" required>
                                    <option value="">proveedor</option>
                                    <c:forEach var="f" items="${requestScope.listamarcas}">
                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                    </c:forEach>
                                </select><br/><br/>                              
                                <label class="control-label">tipo contrato</label>
                                <select name="ticon" class="form-control" required>
                                    <option value="">tipo contrato</option>
                                    <c:forEach var="f" items="${requestScope.listacont}">
                                        <option value="${f.topcId}">${f.tipcDescrip}</option>
                                    </c:forEach>
                                </select><br/><br/>                              
                                <label class="control-label">fecha inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicial" required><br/><br/> 
                                <label class="control-label">fecha fin</label>
                                <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha fin" required><br/><br/>   
                            </div>
                            <div class="col-md-5">
                                <label class="control-label">numero contrato</label>
                                <input  name="nocon" type="text"   id="inputPassword" class="form-control" placeholder="no.contrato" required></br><br/>  
                                <label class="control-label">estado</label>
                                <select name="estado" class="form-control" required>
                                    <option value="">estado</option>
                                    <c:forEach var="f" items="${requestScope.ListaEstado}" >
                                        <option value="${f.estcoId}">${f.estcoDescrip}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">login</label>
                                <input   name="login" type="text" id="inputEmail" class="form-control" placeholder="login"  required><br/><br/>                             
                                <label class="control-label">descripcion</label>
                                <textarea  name="descripcion" type="text" id="inputPassword" class="form-control" placeholder="descripcion" required></textarea><br/><br/>

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
                    <!-- End # DIV Form -->
                </div>


            </div>

            <%}
                if (m == 2) {%>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>contratos</h2></div>   
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-3">
                        <div class="box-bottom">
                            <a  role="button" href="<c:url value="/newcont.htm"/>">agregar</a> 
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
                        <i class="fa fa-table"></i> Data Table contratos</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">             
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>PROVEDOR</th>
                                        <th>TIPO</th>
                                        <th>FECHA INICIO</th>
                                        <th>FECHA FIN</th>
                                        <th>NUMERO</th>
                                        <th>DESCRIPCION</th>
                                        <th>ESTADO</th>
                                        <th>LOGIN</th>
                                        <th>modificar</th>
                                    </tr>
                                </thead>              
                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>PROVEDOR</th>
                                        <th>TIPO</th>
                                        <th>FECHA INICIO</th>
                                        <th>FECHA FIN</th>
                                        <th>NUMERO</th>
                                        <th>DESCRIPCION</th>
                                        <th>ESTADO</th>
                                        <th>LOGIN</th>
                                        <th>modificar</th>
                                    </tr>
                                </tfoot>
                                <tbody>        
                                    <c:forEach var="f" items="${requestScope.listaContra}">
                                        <tr>
                                            <td>${f.contId}</td>
                                            <td>${f.contProv.marNomMarca}</td>
                                            <td>${f.contTipo.tipcDescrip}</td>
                                            <td>${f.contFechaIni}</td>
                                            <td>${f.contFechaFin}</td>
                                            <td>${f.contNum}</td>
                                            <td>${f.contDescrip}</td>
                                            <td>${f.contEstado.estcoDescrip}</td>
                                            <td>${f.contLogin}</td>    
                                            <td>
                                                <form id="forminicio" action="modcont.htm" method="Post">
                                                    <input  name="idcont" type="hidden" value="${f.contId}">

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
                <div class=" panel-heading"><h2>reporte contrato</h2></div>        
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/contratos.htm"/>">volver</a> 
                </div>
                <table>
                    <tr>
                        <td><input type="button" id="btnExport" value="Descargar a Excel "/></td>
                    </tr>
                </table>
                <div id="contratos" class="card mb-3">
                    <div class="card-header">
                        <h3><i class="fa fa-table"></i>${titulo}</h3> </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">             
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>PROVEDOR</th>
                                        <th>TIPO</th>
                                        <th>FECHA INICIO</th>
                                        <th>FECHA FIN</th>
                                        <th>NUMERO</th>
                                        <th>DESCRIPCION</th>
                                        <th>ESTADO</th>
                                        <th>LOGIN</th>
                                    </tr>
                                </thead>              

                                <tbody>        
                                    <c:forEach var="f" items="${requestScope.listreporte}">
                                        <tr>
                                            <td>${f.contId}</td>
                                            <td>${f.contProv.marNomMarca}</td>
                                            <td>${f.contTipo.tipcDescrip}</td>
                                            <td>${f.contFechaIni}</td>
                                            <td>${f.contFechaFin}</td>
                                            <td>${f.contNum}</td>
                                            <td>${f.contDescrip}</td>
                                            <td>${f.contEstado.estcoDescrip}</td>
                                            <td>${f.contLogin}</td>                                                     
                                        </tr>
                                    </c:forEach>               
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
                <script>
                    $("#btnExport").click(function (e) {
                        window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#contratos').html() + name));
                        e.preventDefault();
                    });
                </script>
            </div>

            <%}
                if (m == 4) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar contrato</h2></div>
                <!-- Begin # DIV Form -->
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/contratos.htm"/>">volver</a> 
                </div>

                <!-- Begin # DIV Form -->
                <div id="div-forms" >
                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="contramod.htm" method="Post">

                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-5">
                                <label class="control-label">proveedor</label>
                                <input  name="idcont" type="hidden"  value="${requestScope.cont.contId}" class="form-control" placeholder="fecha fin" required>
                                <select name="proveedor" class="form-control" required>
                                    <option value="${requestScope.cont.contProv.marIdMarca}">${requestScope.cont.contProv.marNomMarca}</option>cont
                                    <c:forEach var="f" items="${requestScope.listamarcas}">
                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                    </c:forEach>
                                </select><br/><br/> 
                                <label class="control-label">tipo contrato</label>
                                <select name="ticon" class="form-control" required>
                                    <option value="${requestScope.cont.contTipo.topcId}">${requestScope.cont.contTipo.tipcDescrip}</option>
                                    <c:forEach var="f" items="${requestScope.listacont}">
                                        <option value="${f.topcId}">${f.tipcDescrip}</option>
                                    </c:forEach>
                                </select><br/><br/>   
                                <label class="control-label">fecha inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" value="${requestScope.cont.contFechaIni}" class="form-control" placeholder="fecha inicial" required><br/><br/>                              
                                <label class="control-label">fecha fin</label>
                                <input  name="ffin" type="text" id="Fecha_Fin" value="${requestScope.cont.contFechaFin}" class="form-control" placeholder="fecha fin" required><br/><br/>                              
                                <label class="control-label">tarea cambio</label>
                                <input   name="tareacambio" type="text" id="inputEmail" class="form-control" placeholder="tarea cambio"  required><br/><br/>
                            </div><div class="col-md-5">
                                <label class="control-label">numero contrato</label>
                                <input  name="nocon" type="text"   id="inputPassword" value="${requestScope.cont.contNum}" class="form-control" placeholder="no.contrato" required></br><br/>  
                                <label class="control-label">estado contrato</label>
                                <select name="estado" class="form-control" required>
                                    <option value="${requestScope.cont.contEstado.estcoId}">${requestScope.cont.contEstado.estcoDescrip}</option>
                                    <c:forEach var="f" items="${requestScope.ListaEstado}" >
                                        <option value="${f.estcoId}">${f.estcoDescrip}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">login</label>
                                <input   name="login" type="text" id="inputEmail" value="${requestScope.cont.contLogin}" class="form-control" placeholder="login"  required><br/><br/>                             
                                <label class="control-label">descripcion contrato</label>
                                <textarea  name="descripcion" type="text" id="inputPassword" value="${requestScope.cont.contDescrip}" class="form-control" placeholder="descripcion" required>${requestScope.cont.contDescrip}</textarea><br/><br/>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </div>
                            <div class="col-md-1"></div>

                        </div>


                    </form>
                    <!-- End # DIV Form -->
                </div>

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
                                    <input type="hidden"  name="F" value="4">
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
