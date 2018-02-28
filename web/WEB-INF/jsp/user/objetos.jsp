<%-- 
    Document   : obgetos
    Created on : 29/11/2017, 08:49:43 AM
    Author     : diegfraa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%          Integer noj = (Integer) request.getAttribute("noj");
%>
<html>
    <%@include file="/WEB-INF/plantilla/head.jsp" %>
    <body>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
        <div class="content-wrapper">
            </br></br>

            <%
                if (noj == 1) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h3>Nueva Central</h3></div> 


                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="col-md-5">
                        <div class="card-body">
                            <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                <thead>
                                    <tr>
                                        <th>                                        
                                            Central
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="f" items="${requestScope.listaCentral}">
                                        <tr>
                                            <td> ╝ ${f.cenNombre}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div></div>
                    <div class="col-md-5">                           
                        <form  action="central.htm" method="Post">                            
                            <br/>
                            <input name="central" type="text"  class="form-control" placeholder="Central" required autofocus ><br/><br/>

                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                    class="btn btn-success btn-lg "  >INGRESAR</button>
                        </form>
                    </div>
                    <div class="col-md-1"></div>
                </div>
                <!-- Begin # Login Form -->

                <!-- End # DIV Form -->                   

            </div>
            <%
                }
                if (noj == 2) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h3>Nuevo Grupo</h3> </div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Grupo.htm"/>">volver</a> 

                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                Grupo nombre
                                            </th>
                                            <th>                                        
                                                Grupo tipo
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaGrupo}">
                                            <tr>
                                                <td> ╝ ${f.gruNomGrupo}</td>
                                                <td> ╝ ${f.gruTipoGrupo}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="grupo.htm" method="Post">                            
                                <br/>
                                <input   name="ngrupo" type="text" id="inputEmail" class="form-control" placeholder="Nombre Grupo" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                <input   name="tgrupo" type="text" id="inputEmail" class="form-control" placeholder="Tipo Grupo" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%
                }
                if (noj == 3) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h3>Nueva Marca</h3></div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Marca.htm"/>">volver</a> 

                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                marca nombre
                                            </th>
                                            <th>                                        
                                                marca intterbentor
                                            </th>
                                            <th>                                        
                                                telefono soporte
                                            </th>
                                            <th>                                        
                                                url soporte
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaFonos}">
                                            <tr>
                                                <td> ╝ ${f.marNomMarca}</td>
                                                <td> ╝ ${f.marInterventor}</td>
                                                <td> ╝ ${f.marTelSoporte}</td>
                                                <td> ╝ ${f.marUrlSoporte}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="marca.htm" method="Post">                            
                                <br/>
                                <input   name="nmarca" type="text" id="inputEmail" class="form-control" placeholder="Nombre Marca" required autofocus class="nav nav-pills nav-stacked"><br/><br/>

                                <input   name="usoporte" type="text" id="inputEmail" class="form-control" placeholder="Url Soporte" required autofocus class="nav nav-pills nav-stacked"><br/><br/>

                                <input   name="tsoporte" type="text" id="inputEmail" class="form-control" placeholder="Telefono Soporte" required autofocus class="nav nav-pills nav-stacked"><br/><br/>

                                <input   name="minterventor" type="text" id="inputEmail" class="form-control" placeholder="Marca Interventor" autofocus class="nav nav-pills nav-stacked"><br/><br/>

                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <!-- Begin # Login Form -->

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%
                }
                if (noj == 4) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h3>Nueva plataforma</h3></div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Plataforma.htm"/>">volver</a> 

                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                plataforma nombre
                                            </th>
                                            <th>                                        
                                                plataforma administrador
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaPlat}">
                                            <tr>
                                                <td> ╝ ${f.plaNomPlataforma}</td>
                                                <td> ╝ ${f.plaAdmPlataforma.admNombre}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="plataforma.htm" method="Post">                            
                                <br/>
                                <input   name="nplataforma" type="text" id="inputEmail" class="form-control" placeholder="nombre Plataforma" required autofocus class="nav nav-pills nav-stacked"><br/><br/>

                                <select name="aplataforma" class="form-control">
                                    <option value="">administrador</option>
                                    <c:forEach var="f" items="${requestScope.listaAdmPlataforma}">
                                        <option value="${f.admId}">${f.admNombre}</option>
                                    </c:forEach>
                                </select>  <br/>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <!-- Begin # Login Form -->

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%
                }
                if (noj == 5) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"> <h3>Nuevo Rol Servidor</h3> </div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Rolserv.htm"/>">volver</a> 

                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                rol servidor
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaRol}">
                                            <tr>
                                                <td> ╝ ${f.rolNomRolServ}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="rolserv.htm" method="Post">                            
                                <br/>
                                <input name="nrol" type="text"  class="form-control" placeholder="Nombre Rol Servidor" required autofocus ><br/><br/>

                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <!-- Begin # Login Form -->

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%
                }
                if (noj == 6) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"> <h3>Nuevo Sistema Operativo</h3></div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Sisopera.htm"/>">volver</a>                
                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                sistema operativo
                                            </th>
                                            <th>                                        
                                                distribucion
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaSis}">
                                            <tr>
                                                <td> ╝ ${f.sisNombre}</td>
                                                <td> ╝ ${f.sisDistribucion}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="sisopera.htm" method="Post">                            
                                <br/>
                                <input name="sisdis" type="text"  class="form-control" placeholder="Sistema Distribucion" required autofocus ><br/><br/>
                                <input   name="nsis" type="text" id="inputEmail" class="form-control" placeholder="Nombre Sistema" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <!-- Begin # Login Form -->

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%
                }
                if (noj == 7) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading">  <h3>Nuevo Estado</h3> </div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Sisopera.htm"/>">volver</a>                
                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                estados
                                            </th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaEstado}">
                                            <tr>
                                                <td> ╝ ${f.estEstado}</td>

                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="estado.htm" method="Post">                            
                                <br/>
                                <input name="nest" type="text"  class="form-control" placeholder="Estado" required autofocus ><br/><br/>

                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <!-- Begin # Login Form -->

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%
                }
                if (noj == 8) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"> <h3>Nuevo Salon o DataCenter</h3></div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Sisopera.htm"/>">volver</a>                
                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                salon
                                            </th>
                                            <th>                                        
                                                central
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaSalon}">
                                            <tr>
                                                <td> ╝ ${f.salNombre}</td>
                                                <td> ╝ ${f.salCentral.cenNombre}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="salon.htm" method="Post">                            
                                <br/>
                                <select name="scen" class="form-control">
                                    <option value="">central</option>
                                    <c:forEach var="f" items="${requestScope.listaCentral}">
                                        <option value="${f.cenIdCentral}">${f.cenNombre}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <input name="nsal" type="text"  class="form-control" placeholder="Nombre Salon" required autofocus ><br/><br/>

                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <!-- Begin # Login Form -->

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%
                }
                if (noj == 9) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading">  <h3>Nuevo modelo</h3> </div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/modelo.htm"/>">volver</a>                
                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                modelo
                                            </th>
                                            <th>                                        
                                                marca
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaModelo}">
                                            <tr>
                                                <td> ╝ ${f.modNomModelo}</td>
                                                <td> ╝ ${f.marIdMarca.marNomMarca}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="modelo.htm" method="Post">                            
                                <br/>
                                <select name="nmar" class="form-control">
                                    <option value="">marca</option>
                                    <c:forEach var="f" items="${requestScope.listaMarca}">
                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                    </c:forEach>
                                </select><br/>
                                <input name="nmod" type="text"  class="form-control" placeholder="Nombre modelo" required autofocus ><br/><br/>

                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <!-- Begin # Login Form -->

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%
                }
                if (noj == 10) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h3>Nuevo Cliente</h3></div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Cliente.htm"/>">volver</a>                
                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                cliente
                                            </th>
                                            <th>                                        
                                                contacto cliente
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaCliente}">
                                            <tr>
                                                <td> ╝ ${f.cliNombre}</td>
                                                <td> ╝ ${f.cliContacto}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="cliente.htm" method="Post">                            
                                <br/>
                                <input name="ncli" type="text"  class="form-control" placeholder="Nombre Cliente" required autofocus ><br/><br/>
                                <input name="ccli" type="text"  class="form-control" placeholder="Contacto Cliente" required autofocus ><br/><br/>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <!-- Begin # Login Form -->

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%
                }
                if (noj == 11) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h3>Nuevo administrador plataforma</h3></div> 

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/Cliente.htm"/>">volver</a>                
                </div>
                <center>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="card-body">
                                <table class="table table-bordered" id="dataTable" cellspacing="0"> 
                                    <thead>
                                        <tr>
                                            <th>                                        
                                                nombre
                                            </th>
                                            <th>                                        
                                                telefono
                                            </th>
                                            <th>                                        
                                                area
                                            </th>
                                            <th>                                        
                                                correo
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="f" items="${requestScope.listaAdmi}">
                                            <tr>
                                                <td> ╝ ${f.admNombre}</td>
                                                <td> ╝ ${f.admTelefono}</td>
                                                <td> ╝ ${f.admArea}</td>
                                                <td> ╝ ${f.admCorreo}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-5">                           
                            <form  action="administradorpla.htm" method="Post">                            
                                <br/>
                                <input name="nombre" type="text"  class="form-control" placeholder="Nombre administrador" required autofocus ><br/><br/>
                                <input name="telefono" type="text"  class="form-control" placeholder="telefono administrador" required autofocus ><br/><br/>
                                <input name="area" type="text"  class="form-control" placeholder="area administrador" required autofocus ><br/><br/>
                                <input name="correo" type="text"  class="form-control" placeholder="correo administrador" required autofocus ><br/><br/>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </form>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <!-- Begin # Login Form -->

                    <!-- End # DIV Form -->                   
                </center>
            </div>
            <%}
            %>

        </div>       
        <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>
