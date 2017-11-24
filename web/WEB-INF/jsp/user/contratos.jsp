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
            String m = (String)request.getAttribute("m");
    
         if(m!=null){
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
                                                                    
                              <select name="proveedor" class="form-control">
                                                    <option value="">proveedor</option>
                                                    <c:forEach var="f" items="${requestScope.listamarcas}">
                                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                                    </c:forEach>
                              </select><br/><br/>                              
                              <select name="ticon" class="form-control">
                                        <option value="">tipo contrato</option>
                                        <c:forEach var="f" items="${requestScope.listacont}">
                                            <option value="${f.topcId}">${f.tipcDescrip}</option>
                                        </c:forEach>
                              </select><br/><br/>                              
                              <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicial" ><br/><br/>                              
                              <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha fin" ><br/><br/>                              
                              <input  name="nocon" type="text"   id="inputPassword" class="form-control" placeholder="no.contrato" ></br><br/>  
                              <select name="estado" class="form-control">
                                        <option value="">estado</option>
                                        <c:forEach var="f" items="${requestScope.ListaEstado}">
                                            <option value="${f.estIdEstado}">${f.estEstado}</option>
                                        </c:forEach>
                              </select><br/><br/>
                              <input   name="login" type="text" id="inputEmail" class="form-control" placeholder="login"  ><br/><br/>                             
                              <input  name="descripcion" type="text" id="inputPassword" class="form-control" placeholder="descripcion" ><br/><br/>
                   
                  
                        <div>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                        </div>
                  
                </form>
                      <!-- End # DIV Form -->
                  </div>
                </center>
          
     
<%}else{%>
<div class="box-bottom">
                    <a  role="button" href="<c:url value="/newcont.htm"/>">agregar</a> 
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
                    <td>${f.contProv}</td>
                    <td>${f.contTipo}</td>
                    <td>${f.contFechaIni}</td>
                    <td>${f.contFechaFin}</td>
                    <td>${f.contNum}</td>
                    <td>${f.contDescrip}</td>
                    <td>${f.contEstado}</td>
                    <td>${f.contLogin}</td>                                                     
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
