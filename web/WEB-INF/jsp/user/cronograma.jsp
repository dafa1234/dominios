<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <%@include file="/WEB-INF/plantilla/head.jsp" %>
    <body>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
            <div class="content-wrapper">
       
        </br></br>
    
            <h3>Cronograma MTO</h3> 
        
    <%
            Integer m = (Integer)request.getAttribute("m");
    
         if(m==1){
    %>
         
<!-- Begin # DIV Form -->
 <div class="box-bottom">
                    <a  role="button" href="<c:url value="/cronograma.htm"/>">volver</a> 
                </div>     

                  <!-- Begin # DIV Form -->
                  <div id="div-forms" >

                <!-- Begin # Login Form -->
                <form id="forminicio" action="crono.htm" method="Post">
                  
                      
                              
                              <select name="proyecto" class="form-control">
                                        <option value="">proyecto</option>
                                        <c:forEach var="f" items="${requestScope.ListaProyecto}">
                                            <option value="${f.proId}">${f.proTitulo}</option>
                                        </c:forEach>
                              </select><br/><br/>
                              
                              <select name="servidor" class="form-control">
                                        <option value="">servidor</option>
                                        <c:forEach var="f" items="${requestScope.listaFonos}">
                                            <option value="${f.serSerial}">${f.serHostname}</option>
                                        </c:forEach>
                              </select><br/><br/>
                              <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicial" ><br/><br/>
                              
                              <select name="estini" class="form-control">
                                        <option value="">estado inicial</option>
                                        <c:forEach var="f" items="${requestScope.listaEstado}">
                                            <option value="${f.estmId}">${f.estmEstado}</option>
                                        </c:forEach>
                              </select><br/><br/>
                              <input   name="ejecuta" type="text" id="inputEmail" class="form-control" placeholder="ejecuta"  ><br/><br/>

                              <input   name="cambio" type="text" id="inputEmail" class="form-control" placeholder="cambio"  ><br/><br/>

                    </div>
                   
                        <div>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                        </div>

                  
                </form>

              

       

<%}if(m==2){%>
     <div class="box-bottom">
                    <a  role="button" href="<c:url value="/newcrono.htm"/>">agregar</a> 
     </div>
     <div class="flex-caption">
        <h3>Bienvenido</h3> 
        <div class="box-bottom">
            <a  role="button" data-toggle="modal" data-target="#login-modal">REPORTE</a>
        </div>
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
            </tr>
            </tfoot>
            <tbody>        
            <c:forEach var="f" items="${requestScope.listaCrono}">
            <tr>
                    <td>${f.croId}</td>
                    <td>${f.croSerial}</td>
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
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
    
<%}if(m==3){%>
<h3>REPORTE</h3>
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/cronograma.htm"/>">volver</a> 
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
            </tr>
            </tfoot>
            <tbody>        
            <c:forEach var="f" items="${requestScope.listaCrono}">
            <tr>
                    <td>${f.croId}</td>
                    <td>${f.croSerial}</td>
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
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
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