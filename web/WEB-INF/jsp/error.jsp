
<%
  String error = (String)request.getSession().getAttribute("error");
  String error2 = (String)request.getSession().getAttribute("error2");
  String error3 = (String)request.getSession().getAttribute("error3");
  String errorr = (String)request.getAttribute("errorr");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><%@include file="/WEB-INF/plantilla/head.jsp" %>
    <head>
    
    </head>
    <body>
        <h1>Error! <%=error%> <%=error2%> <%=error3%> <%=errorr%></h1>
        
        <div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    Dropdown
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="#">Action</a></li>
    <li><a href="#">Another action</a></li>
    <li><a href="#">Something else here</a></li>
    <li role="separator" class="divider"></li>
    <li><a href="#">Separated link</a></li>
  </ul>
</div>
              <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>
