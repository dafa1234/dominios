<%-- 
    Document   : obgetos
    Created on : 29/11/2017, 08:49:43 AM
    Author     : diegfraa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/plantilla/head.jsp" %>
    <body>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
        <div class="content-wrapper">
            </br></br>

            <div class="flex-caption">
                <h3>Nueva Central</h3>              
            </div>       
            <center>


                <!--
                    Object algo = (Object)request.getAttribute("algo");
                    String algoString = algo.getClass().toString();
                      <algoString%>
                %-->
                <!-- Begin # Login Form -->


                ${requestScope.algo}
                <form  action="proce1.htm" method="Post">                            
                    <div id="div-login-msg">                                                              
                        <table>
                            <tr>
                                <td> 
                                    <input name="rutas" type="text"  class="form-control" placeholder="Central" required autofocus ><br/><br/>
                                </td>
                            </tr>                      

                        </table>
                    </div>                               
                    <div>
                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                    </div>                             
                </form>
                <!-- End # DIV Form -->                   
            </center>

        </div>       
        <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>
