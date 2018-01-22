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
            <!-- Begin # DIV Form -->
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/contratos.htm"/>">volver</a> 
            </div>
            <center>
                <!-- Begin # DIV Form -->
                <div id="div-forms" >
                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="contr.htm" method="Post">

                        <select name="proveedor" class="form-control" required>
                            <option value="">proveedor</option>
                            <c:forEach var="f" items="${requestScope.listamarcas}">
                                <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                            </c:forEach>
                        </select><br/><br/>                              
                        <select name="ticon" class="form-control" required>
                            <option value="">tipo contrato</option>
                            <c:forEach var="f" items="${requestScope.listacont}">
                                <option value="${f.topcId}">${f.tipcDescrip}</option>
                            </c:forEach>
                        </select><br/><br/>                              
                        <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicial" required><br/><br/>                              
                        <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha fin" required><br/><br/>                              
                        <input  name="nocon" type="text"   id="inputPassword" class="form-control" placeholder="no.contrato" required></br><br/>  
                        <select name="estado" class="form-control" required>
                            <option value="">estado</option>
                            <c:forEach var="f" items="${requestScope.ListaEstado}" >
                                <option value="${f.estcoId}">${f.estcoDescrip}</option>
                            </c:forEach>
                        </select><br/><br/>
                        <input   name="login" type="text" id="inputEmail" class="form-control" placeholder="login"  required><br/><br/>                             
                        <input  name="descripcion" type="text" id="inputPassword" class="form-control" placeholder="descripcion" required><br/><br/>


                        <div>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                        </div>

                    </form>
                    <!-- End # DIV Form -->
                </div>
            </center>


            <%}
    if (m == 2) {%>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/newcont.htm"/>">agregar</a> 
            </div>
            <div class="flex-caption">
                <h3>Bienvenido</h3> 
                <div class="box-bottom">
                    <a  role="button" data-toggle="modal" data-target="#login-modal">REPORTE</a>
                </div>
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
                                    </tr>
                                </c:forEach>               
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>  

            <%}
    if (m == 3) {%>
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
            <%}%>
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
