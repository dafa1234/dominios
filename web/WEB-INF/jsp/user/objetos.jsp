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
      
                               <%
            Integer s = (Integer)request.getAttribute("s");
            Integer c = (Integer)request.getAttribute("c");
            Integer m = (Integer)request.getAttribute("m");
            Integer g = (Integer)request.getAttribute("g");
            Integer r = (Integer)request.getAttribute("r");
            Integer p = (Integer)request.getAttribute("p");  
         if(c!=1){
            %>
             <div class="flex-caption">
            <h3>Nueva Central</h3>              
        </div>
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="Central.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="central" type="text" id="inputEmail" class="form-control" placeholder="Central" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
                                               <%
    }
         if(g!=2){
            %>
              <div class="flex-caption">
            <h3>Nuevo Grupo</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Grupo.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="ngrupo" type="text" id="inputEmail" class="form-control" placeholder="Nombre Grupo" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="tgrupo" type="text" id="inputEmail" class="form-control" placeholder="Tipo Grupo" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
                                                               <%
    }
         if(m!=3){
            %>
              <div class="flex-caption">
            <h3>Nueva Marca</h3>              
        </div>          
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Marca.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="nmarca" type="text" id="inputEmail" class="form-control" placeholder="Nombre Marca" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="usoporte" type="text" id="inputEmail" class="form-control" placeholder="Url Soporte" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="tsoporte" type="text" id="inputEmail" class="form-control" placeholder="Telefono Soporte" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="minterventor" type="text" id="inputEmail" class="form-control" placeholder="Marca Interventor" autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
                                                               <%
    }
         if(p!=4){
            %>
              <div class="flex-caption">
            <h3>Nueva plataforma</h3>              
        </div>           
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Plataforma.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="nplataforma" type="text" id="inputEmail" class="form-control" placeholder="nombre Plataforma" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="aplataforma" type="text" id="inputEmail" class="form-control" placeholder="Administrador Plataforma" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
                                                               <%
    }
         if(r!=5){
            %>
              <div class="flex-caption">
            <h3>Nuevo Rol Servidor</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Rolserv.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="nrol" type="text" id="inputEmail" class="form-control" placeholder="Nombre Rol Servidor" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
                                                                                  <%
    }
         if(s!=6){
            %>
        <div class="flex-caption">
            <h3>Nuevo Sistema Operativo</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Sisopera.htm"/>">volver</a>                
            </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="creat.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="sisdis" type="text" id="inputEmail" class="form-control" placeholder="Sistema Distribucion" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="nsis" type="text" id="inputEmail" class="form-control" placeholder="Nombre Sistema" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
            <%}
            %>
 
    </div>       
   <%@include file="/WEB-INF/plantilla/foter.jsp" %>
</body>
</html>
