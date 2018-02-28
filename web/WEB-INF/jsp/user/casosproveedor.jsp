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
                <div class=" panel-heading"><h2>crear casos proveedor</div>
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/casosproveedor.htm"/>">volver</a> 
                </div> 

                <!-- Begin # DIV Form -->
                <div id="div-forms" >
                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="caprov.htm" method="Post">      
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-5">
                                <label class="control-label">proveedor</label>
                                <select name="proveedor" class="form-control" required>
                                    <option value="">proveedor</option>
                                    <c:forEach var="f" items="${requestScope.ListaMarca}">
                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">servidor</label>
                                <select name="servidor" class="form-control" required>
                                    <option value="">servidor</option>
                                    <c:forEach var="f" items="${requestScope.listaServer}">
                                        <option value="${f.serServer}">${f.serHostname}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">fecha inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha apertura" required><br/><br/>
                            
                                <label class="control-label">fecha fin</label>
                                <input  name="fcie" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha cierre" required><br/><br/>
                                </div>
                            <div class="col-md-5">
                                <label class="control-label">estado proveedor</label>
                                <select name="estini" class="form-control" required>
                                    <option value="">estado inicial</option>
                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                        <option value="${f.estcId}">${f.estcEstado}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">numero de casos</label>
                                <input   name="numcas" type="text" id="inputEmail" class="form-control" placeholder="numero caso"  required><br/><br/>
                                <label class="control-label">IM</label>
                                <input   name="im" type="text" id="inputEmail" class="form-control" placeholder="im" required ><br/><br/><br/>
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
                if (m == 2) {%>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>casos proveedor</div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-3">
                        <div class="box-bottom">
                            <a  role="button" href="<c:url value="/newcasos.htm"/>">agregar</a> 
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
                        <i class="fa fa-table"></i> Data Table casos proveedor</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">             
                                <thead>
                                    <TR>      
                                        <th>ID</th>
                                        <th>CASOS PROVEEDOR</th>
                                        <th>SERVIDOR</th>
                                        <th>FECHA APERTURA</th>
                                        <th>FECHA CIERRE</th>
                                        <th>NUMERO</th>
                                        <th>IM</th>
                                        <th>ESTADO</th>
                                        <th>modificar </th> 
                                    </tr>
                                </thead>              
                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>CASOS PROVEEDOR</th>
                                        <th>SERVIDOR</th>
                                        <th>FECHA APERTURA</th>
                                        <th>FECHA CIERRE</th>
                                        <th>NUMERO</th>
                                        <th>IM</th>
                                        <th>ESTADO</th>  
                                        <th>modificar </th> 
                                    </tr>
                                </tfoot>
                                <tbody>        
                                    <c:forEach var="f" items="${requestScope.Listaproveedor}">
                                        <tr>
                                            <td>${f.caspId}</td>
                                            <td>${f.caspProv.marNomMarca}</td>
                                            <td>${f.caspServ.serHostname}</td>
                                            <td>${f.caspFechaApe}</td>
                                            <td>${f.caspFechaCie}</td>
                                            <td>${f.caspNumero}</td>
                                            <td>${f.caspIm}</td>
                                            <td>${f.caspEstado.estcEstado}</td>
                                            <td>
                                                <form id="forminicio" action="casosmodifi.htm" method="Post">
                                                    <input  name="caspId" type="hidden" value="${f.caspId}">

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
                <div class=" panel-heading"><h2>reporte casos proveedor</div>
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/casosproveedor.htm"/>">volver</a> 
                </div> 
                <table>
                    <tr>
                        <td><input type="button" class="btn btn-success btn-lg " id="btnExport" value="Descargar a Excel "/></td>
                    </tr>
                </table>
                <div id="casosprov" class="card mb-3">
                    <div class="card-header">
                        <h3><i class="fa fa-table"></i>${titulo}</h3> </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">             
                                <thead>
                                    <TR>      
                                        <th>ID</th>
                                        <th>CASOS PROVEEDOR</th>
                                        <th>SERVIDOR</th>
                                        <th>FECHA APERTURA</th>
                                        <th>FECHA CIERRE</th>
                                        <th>NUMERO</th>
                                        <th>IM</th>
                                        <th>ESTADO</th> 
                                    </tr>
                                </thead>              

                                <tbody>        
                                    <c:forEach var="f" items="${requestScope.listreporte}">
                                        <tr>
                                            <td>${f.caspId}</td>
                                            <td>${f.caspProv.marNomMarca}</td>
                                            <td>${f.caspServ.serSerial}</td>
                                            <td>${f.caspFechaApe}</td>
                                            <td>${f.caspFechaCie}</td>
                                            <td>${f.caspNumero}</td>
                                            <td>${f.caspIm}</td>
                                            <td>${f.caspEstado.estcEstado}</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <script>
                    $("#btnExport").click(function (e) {
                        window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#casosprov').html() + name));
                        e.preventDefault();
                    });
                </script>
            </div>
            <%
                }
                if (m == 7) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar casos proveedor</div>
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/casosproveedor.htm"/>">volver</a> 
                </div> 

                <!-- Begin # DIV Form -->
                <div id="div-forms" >
                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="modificarcasosprove.htm" method="Post">   
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-5">
                                <label class="control-label">proveedor</label>
                                <select name="proveedor" class="form-control" required>
                                    <option value="${requestScope.cas.caspProv.marIdMarca}">${requestScope.cas.caspProv.marNomMarca}</option>
                                    <c:forEach var="f" items="${requestScope.ListaMarca}">
                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                    </c:forEach>
                                </select><br/><br/>


                                <input   name="idcasos" type="hidden" id="inputEmail"   required value="${requestScope.cas.caspId}" >
                                <label class="control-label">servidor</label>
                                <select name="servidor" class="form-control" required>
                                    <option value="${requestScope.cas.caspServ.serServer}">${requestScope.cas.caspServ.serSerial}</option>
                                    <c:forEach var="f" items="${requestScope.listaServer}">
                                        <option value="${f.serServer}">${f.serHostname}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">fecha inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" value="${requestScope.cas.caspFechaApe}" class="form-control" placeholder="fecha apertura" required><br/><br/>
                                <label class="control-label">fecha cierre</label>
                                <input  name="fcie" type="text" id="Fecha_Fin" value="${requestScope.cas.caspFechaCie}" class="form-control" placeholder="fecha cierre" required><br/><br/>
                            </div>
                            <div class="col-md-5">
                                <label class="control-label">estado proveedor</label>
                                <select name="estini" class="form-control" required>
                                    <option value="${requestScope.cas.caspEstado.estcId}">${requestScope.cas.caspEstado.estcEstado}</option>
                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                        <option value="${f.estcId}">${f.estcEstado}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">numero de casos</label>
                                <input   name="numcas" type="text" id="inputEmail" value="${requestScope.cas.caspNumero}" class="form-control" placeholder="numero caso"  required><br/><br/>
                                <label class="control-label">IM</label>
                                <input   name="im" type="text" id="inputEmail" value="${requestScope.cas.caspIm}" class="form-control" placeholder="im" required ><br/><br/>
                                <label class="control-label">tarrea cambio</label>
                                <input   name="tareacambio" type="text" id="inputEmail"  class="form-control" placeholder="tarea caMBIO" required ><br/><br/>
                            </div>
                            <div class="col-md-1">
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
                                    <input type="hidden"  name="F" value="7">
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