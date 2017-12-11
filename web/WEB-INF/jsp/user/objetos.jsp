<%-- 
    Document   : obgetos
    Created on : 29/11/2017, 08:49:43 AM
    Author     : diegfraa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%          Integer noj = (Integer)request.getAttribute("noj");
            %>
<html>
   <%@include file="/WEB-INF/plantilla/head.jsp" %>
<body>
   <%@include file="/WEB-INF/plantilla/header.jsp" %>
    <div class="content-wrapper">
        </br></br>
      
                               <% 
         if(noj==1){
            %>
            <div class="flex-caption">
               <h3>Nueva Central</h3>              
            </div>       
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="central.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input name="central" type="text"  class="form-control" placeholder="Central" required autofocus ><br/><br/>
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
         if(noj==2){
            %>
              <div class="flex-caption">
            <h3>Nuevo Grupo</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Grupo.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="grupo.htm" method="Post">                            
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
         if(noj==3){
            %>
              <div class="flex-caption">
            <h3>Nueva Marca</h3>              
        </div>          
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Marca.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="marca.htm" method="Post">                            
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
         if(noj==4){
            %>
              <div class="flex-caption">
            <h3>Nueva plataforma</h3>              
        </div>           
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Plataforma.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="plataforma.htm" method="Post">                            
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
         if(noj==5){
            %>
              <div class="flex-caption">
            <h3>Nuevo Rol Servidor</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Rolserv.htm"/>">volver</a> 
                    
                </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="rolserv.htm" method="Post">                            
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
         if(noj==6){
            %>
        <div class="flex-caption">
            <h3>Nuevo Sistema Operativo</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Sisopera.htm"/>">volver</a>                
            </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="sisopera.htm" method="Post">                            
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
             <%
    }
         if(noj==7){
            %>
        <div class="flex-caption">
            <h3>Nuevo Estado</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Sisopera.htm"/>">volver</a>                
            </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="estado.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                                <input   name="nest" type="text" id="inputEmail" class="form-control" placeholder="Estado" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
         if(noj==8){
            %>
        <div class="flex-caption">
            <h3>Nuevo Salon o DataCenter</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Sisopera.htm"/>">volver</a>                
            </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="salon.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                             <select name="scen" class="form-control">
                                                    <option value="">central</option>
                                                    <c:forEach var="f" items="${requestScope.listaCentral}">
                                                        <option value="${f.cenIdCentral}">${f.cenNombre}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="nsal" type="text" id="inputEmail" class="form-control" placeholder="Nombre Salon" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
         if(noj==9){
            %>
        <div class="flex-caption">
            <h3>Nuevo modelo</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/modelo.htm"/>">volver</a>                
            </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="modelo.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                             <select name="nmar" class="form-control">
                                                    <option value="">marca</option>
                                                    <c:forEach var="f" items="${requestScope.listaMarca}">
                                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="nmod" type="text" id="inputEmail" class="form-control" placeholder="Nombre modelo" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
         if(noj==10){
            %>
        <div class="flex-caption">
            <h3>Nuevo Cliente</h3>              
        </div>             
            <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Cliente.htm"/>">volver</a>                
            </div>
            <center>
                           <!-- Begin # Login Form -->
                        <form  action="cliente.htm" method="Post">                            
                            <div id="div-login-msg">                                                              
                                <table>
                                        <tr>
                                            <td> 
                                            <input   name="ncli" type="text" id="inputEmail" class="form-control" placeholder="Nombre Cliente" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                            </td>
                                            <td> 
                                                <input   name="ccli" type="text" id="inputEmail" class="form-control" placeholder="Contacto Cliente" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
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
