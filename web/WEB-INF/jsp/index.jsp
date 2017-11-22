<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@include file="/WEB-INF/plantilla/head.jsp" %>
      
        <title>iniciar secion</title>
    </head>

    <body>
         <div class="container"  class="col-lg-5">

       <form  id="forminicio" class="form-signin" action="mostrar.htm" method="post">
  
        <h2 class="form-signin-heading"> <img src="<c:url value="/sps/fonts/ETB.jpg"/>"  width="500" height="250" class="media-right"></h2><br/><br/>
   
        <input   name="email" type="text" id="inputEmail" class="form-control" placeholder="Email address" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
        
        <input  name="pass" type="password" id="inputPassword" class="form-control" placeholder="Password" required><br/><br/>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block"  type="submit">Sign in</button>
       </form>
      
    </div> <!-- /container -->     
    </body>
</html>
