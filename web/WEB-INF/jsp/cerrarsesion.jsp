<%-- 
    Document   : cerrarsesion
    Created on : 2/10/2017, 10:38:55 AM
    Author     : diegfraa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session="true" import="java.util.*"%>
<%
    HttpSession sesionCerrada = request.getSession();
    sesionCerrada.invalidate();
%>
<jsp:forward page="index.jsp"/>
