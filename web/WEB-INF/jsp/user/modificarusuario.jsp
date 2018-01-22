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
            <form action="newuser.htm" method="Post">
                <input name="usu" type="text"  class="form-control" placeholder="usuario etb" required>
                <input name="per" type="text"  class="form-control" placeholder="tipo perfil" required>
                <input name="dom" type="text"  class="form-control" placeholder="tipo dominio" required>
                <div>
                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                </div>
            </form>
            <%if (error != null) {%>
            error <%=error%>
            <%}%>
        </div>
        <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>
