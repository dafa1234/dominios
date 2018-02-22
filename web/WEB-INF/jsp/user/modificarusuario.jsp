<%-- 
    Document   : modificarusuario
    Created on : 7/11/2017, 09:42:58 AM
    Author     : diegfraa
--%>

<%@page import="tablas.EtbInvUsuEstado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/plantilla/head.jsp" %>

    <body>
        <%
                                 String error = (String) request.getAttribute("error");%>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
        <div class="content-wrapper">
            </br></br>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Agregar usuario en la apricacion</h2></div>
            <form action="newuser.htm" method="Post">
                       <div class="row">
                            <div class="col-md-2"></div>
                            <div class="col-md-8">
                <label class="control-label">usuario etb</label>
                <input name="usu" type="text"  class="form-control" placeholder="usuario etb" required>
                <label class="control-label">perfil</label>
                <input name="per" type="text"  class="form-control" placeholder="tipo perfil" required>
               <label class="control-label">dominio</label>
                <input name="dom" type="text"  class="form-control" placeholder="tipo dominio" required>
                 </div>
                            <div class="col-md-2"></div>
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
            <%if (error != null) {%>
            error <%=error%>
            <%}%>
        </div>
        </div>
        <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>
