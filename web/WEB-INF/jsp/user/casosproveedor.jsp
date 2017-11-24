<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/plantilla/head.jsp" %>
<body>
<%@include file="/WEB-INF/plantilla/header.jsp" %>
<div class="content-wrapper">
        </br></br>
        <div class="flex-caption">
                <h3>tabla de casos proveedor</h3> 
   
            </div>
                                           <%
            String m = (String)request.getAttribute("m");
    
         if(m!=null){
            %>     
 <div class="box-bottom">
                    <a  role="button" href="<c:url value="/casosproveedor.htm"/>">volver</a> 
                </div> 
    
                <center>
                  <!-- Begin # DIV Form -->
                  <div id="div-forms" >

                <!-- Begin # Login Form -->
                <form id="forminicio" action="caprov.htm" method="Post">
                   
                      
                              
                              <select name="proveedor" class="form-control">
                                        <option value="">proveedor</option>
                                        <c:forEach var="f" items="${requestScope.ListaMarca}">
                                            <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                        </c:forEach>
                              </select><br/><br/>
                              
                              <select name="servidor" class="form-control">
                                        <option value="">servidor</option>
                                        <c:forEach var="f" items="${requestScope.listaServer}">
                                            <option value="${f.serSerial}">${f.serHostname}</option>
                                        </c:forEach>
                              </select><br/><br/>
                              <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha apertura" ><br/><br/>
                              
                              <input  name="fcie" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha cierre" ><br/><br/>
                              
                              <select name="estini" class="form-control">
                                        <option value="">estado inicial</option>
                                        <c:forEach var="f" items="${requestScope.listaEstado}">
                                            <option value="${f.estIdEstado}">${f.estEstado}</option>
                                        </c:forEach>
                              </select><br/><br/>
                              <input   name="numcas" type="text" id="inputEmail" class="form-control" placeholder="numero caso"  ><br/><br/>

                              <input   name="im" type="text" id="inputEmail" class="form-control" placeholder="im"  ><br/><br/>

                    </div>
                  
                        <div>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                        </div>

                    
                </form>


                      <!-- End # DIV Form -->

                  </div>
                </center>
              </div>

          </div>
      </div>
<%}else{%>
 <div class="box-bottom">
                    <a  role="button" href="<c:url value="/newcasos.htm"/>">agregar</a> 
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
            </tr>
            </tfoot>
            <tbody>        
            <c:forEach var="f" items="${requestScope.Listaproveedor}">
            <tr>
                    <td>${f.caspId}</td>
                    <td>${f.caspProv}</td>
                    <td>${f.caspServ}</td>
                    <td>${f.caspFechaApe}</td>
                    <td>${f.caspFechaCie}</td>
                    <td>${f.caspNumero}</td>
                    <td>${f.caspIm}</td>
                    <td>${f.caspEstado}</td>
                   
                  
                
            </tr>
            </c:forEach>
               
            </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
        

<%}%>
</div>
         <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>