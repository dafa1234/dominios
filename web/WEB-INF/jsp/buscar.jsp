<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<!DOCTYPE html>
<html><%@include file="/WEB-INF/plantilla/head.jsp" %>

<body>
    

    <%@include file="/WEB-INF/plantilla/header.jsp" %>
     <div class="content-wrapper">
       
    <center>
    
 
<br/><br/>
    <h2>informacion general</h2>
    </center>
<br/><br/>
<div class="btn-group">
    <ul class="nav nav-pills" >
      <li role="presentation" ><a href="#">copy </a></li>
      <li role="presentation" ><a href="#">csv</a></li>
      <li role="presentation" ><a href="#">exel </a></li>
      <li role="presentation" ><a href="#">pdf </a></li>
      <li role="presentation" ><a href="#">print</a></li>
    </ul>   
</div>
<div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Tabla de Servidores</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            <thead>
            <tr>
                <th>serial</th>
                <th>host name</th>
                <th>marca</th>
                <th>modelo</th>
                <th>cliente</th>
                <th>sistema operativo</th>
                <th>grupo</th>
                <th>estado</th>
            </tr>
            </thead>
              
            <tfoot>
            <tr>
                <th>serial</th>
                <th>host name</th>
                <th>marca</th>
                <th>modelo</th>
                <th>cliente</th>
                <th>sistema operativo</th>
                <th>grupo</th>
                <th>estado</th>
            </tr>
            </tfoot>
            <tbody>        
            <c:forEach var="f" items="${requestScope.Listaserver}">
            <tr>
                    <td>${f.serSerial}</td>
                    <td>${f.serHostname}</td>
                    <td>${f.marIdMarca.marNomMarca}</td>
                    <td>${f.modIdModelo}</td>
                    <td>${f.cenIdCentral}</td>
                    <td>${f.sisIdSisOperativo.sisNombre}</td>
                    <td>${f.gruIdGrupo.gruNomGrupo}</td>
                    <td>${f.estIdEstado.estEstado}</td>  
            </tr>
            </c:forEach>
               
            </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
     </div>
         <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>
