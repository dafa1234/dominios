<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <%@include file="/WEB-INF/plantilla/head.jsp" %>
    <body>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
         <div class="content-wrapper">
        </br></br>
         
         <div class="flex-caption">
            <h3>tabla de aseguraminto</h3> 
             <%
            String m = (String)request.getAttribute("m");
    
         if(m!=null){
            %> 
         <div class="box-bottom">
                    <a  role="button" href="<c:url value="/aseguramiento.htm"/>">volver</a> 
                </div>       
                <center>
                  <!-- Begin # DIV Form -->
                  <div id="div-forms" >

                <!-- Begin # Login Form -->
                <form id="forminicio" action="aseg.htm" method="Post">
                    <table>
                        <tr>
                            <td>
                                <select name="serv" class="form-control">
                                    <option value="">servidor</option>
                                    <c:forEach var="f" items="${requestScope.listaServer}">
                                        <option value="${f.serServer}">${f.serSerial}__${f.serHostname}</option>
                                    </c:forEach>
                                </select><br/><br/>
                            </td>

                            <td>  <input   name="tarea" type="text" id="inputEmail" class="form-control" placeholder="TAREA"  ><br/><br/></td>
                    </tr><tr>
                        <td>  <input  name="eje" type="text" id="inputPassword" class="form-control" placeholder="EJECUTA" ><br/><br/></td>
                              
                        <td>  <input  name="fini" type="text"   id="Fecha_Inicio" class="form-control" placeholder="fecha inicio" ></br><br/></td>
         </tr><tr>
            
             <td>    <input   name="plantilla" type="text" id="inputEmail" class="form-control" placeholder="PLANTILLA"  ><br/><br/></td>
         </tr>
                    </table>
                  
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
<%
}else{
%>
          <div class="box-bottom">
                    <a  role="button" href="<c:url value="/newaseg.htm"/>">agregar</a> 
                </div>       
        </div>
         <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Data Table aseguramiento</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
             
            <thead>
            <TR>
                <th>ID</th>
                <th>FECHA</th>
                <th>TAREA</th>
                <th>SERVIDOR</th>
                <th>SERIAL</th>
                <th>EJECUTA</th>
                <th>SIS OPERATIVO</th>          
            </tr>
            </thead>
              
            <tfoot>
            <tr>
                <th>ID</th>
                <th>FECHA</th>
                <th>TAREA</th>
                <th>SERVIDOR</th>
                <th>SERIAL</th>
                <th>EJECUTA</th>
                <th>SIS OPERATIVO</th>          
            </tr>
            </tfoot>
            <tbody>        
            <c:forEach var="f" items="${requestScope.listaAsegu}">
            <tr>
                    <td>${f.aseId}</td>
                    <td>${f.aseFecha}</td>
                    <td>${f.aseTarea}</td>
                    <td>${f.aseServidor.serHostname}</td>
                    <td>${f.aseServidor.serSerial}</td>
                    <td>${f.aseEjecuta}</td>
                    <td>${f.aseServidor.sisIdSisOperativo.sisNombre}</td>
                
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