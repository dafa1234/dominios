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
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
            </div>


            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Detalle Servidor</h2></div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3">

                            <label class="control-label">SERIAL :</label>
                            <p class="form-control">${requestScope.servidor.serSerial}</p>
                            </br>
                            <label class="control-label">HONTNAME :</label>
                            <p class="form-control">${requestScope.servidor.serHostname}</p>
                            </br>
                            <label class="control-label">MARCA :</label>
                            <p class="form-control">${requestScope.servidor.marIdMarca.marNomMarca}</p>
                            </br>
                            <label class="control-label">MODELO :</label>
                            <p class="form-control">${requestScope.servidor.modIdModelo.modNomModelo}</p>
                            </br>
                            <label class="control-label">SISTEMA OPERATIVO :</label>
                            <p class="form-control">${requestScope.servidor.sisIdSisOperativo.sisNombre}</p>
                            </br>

                            <label class="control-label">CONEXION :</label>
                            <p class="form-control">${requestScope.servidor.serConexion}</p>
                            </br>
                        </div>
                        <div class="col-md-3">
                            <label class="control-label">ESTADO :</label>
                            <p class="form-control">${requestScope.servidor.estIdEstado.estEstado}</p>
                            </br>
                            <label class="control-label">CENTRAL :</label>
                            <p class="form-control">${requestScope.servidor.cenIdCentral.cenNombre}</p>
                            </br>
                            <label class="control-label">SALON :</label>
                            <p class="form-control">${requestScope.servidor.salIdSalon.salNombre}</p>
                            </br>
                            <label class="control-label">RACK :</label>
                            <p class="form-control">${requestScope.servidor.serRack}</p>
                            </br>
                            <label class="control-label">UNIDAD :</label>
                            <p class="form-control">${requestScope.servidor.serUnidad}</p>
                            </br>

                            <label class="control-label">GRUPO :</label>
                            <p class="form-control">${requestScope.servidor.gruIdGrupo.gruNomGrupo}</p>
                            </br>

                        </div>
                        <div class="col-md-3">
                            <label class="control-label">CLIENTE :</label>
                            <p class="form-control">${requestScope.servidor.cliIdCliente.cliNombre}</p>
                            </br>
                            <label class="control-label">PROYECTO :</label>
                            <p class="form-control">${requestScope.servidor.serProyecto}</p>
                            </br>
                            <label class="control-label">ROL SERVIDOR :</label>
                            <p class="form-control">${requestScope.servidor.rolIdRolServ.rolNomRolServ}</p>
                            </br>
                            <label class="control-label">PLATAFORMA :</label>
                            <p class="form-control">${requestScope.servidor.plaIdPlataforma.plaNomPlataforma}</p>
                            </br>           
                            <label class="control-label">TAREA INGRESO :</label>
                            <p class="form-control">${requestScope.servidor.serTIngreso}</p>
                            </br>
                            <label class="control-label">No PROCESOS FISICOS :</label>
                            <p class="form-control">${requestScope.servidor.serNoProcFisico}</p>
                            </br>
                        </div>
                        <div class="col-md-3">
                            <label class="control-label">TAREA AD COMPARTIDA :</label>
                            <p class="form-control">${requestScope.servidor.serTareaAdCompartida}</p>
                            </br>
                            <label class="control-label">ADMINISTRACION COMPARTIDA :</label>
                            <p class="form-control">${requestScope.servidor.serAdCompartida}</p>
                            </br>
                            <label class="control-label">ADMINISTRADO :</label>
                            <p class="form-control">${requestScope.servidor.serAdministrado}</p>
                            </br>
                            <label class="control-label">CORES :</label>
                            <p class="form-control">${requestScope.servidor.serCores}</p>
                            </br>
                            <label class="control-label">MEM :</label>
                            <p class="form-control">${requestScope.servidor.servMem}</p>
                            </br>
                            <label class="control-label">DISCOC :</label>
                            <p class="form-control">${requestScope.servidor.servDiscoC}</p>
                            </br>

                        </div>
                    </div>
                </div>

                <form id="forminicio" action="modificarservidor.htm" method="Post">
                    <input  name="tdserv" type="hidden" value="${requestScope.idser}">
                    <div>
                        <button  type="submit" class="button45 button46" title="Presione para ingresar">modificar</button>
                    </div>
                </form>

                <div class="btn-group">
                    <ul class="nav nav-pills" >

                        <li role="presentation" >  
                        <li role="presentation" >
                        </li>
                        <li role="presentation" >       
                        <li role="presentation" >      
                    </ul>   
                </div>
                <div style="overflow:auto;">
                    <div style="float:right;">
                        <button class="btn btn-primary" type="button" id="prevBtn" onclick="nextPrev(-1)">Anterior</button>
                        <button class="btn btn-primary" type="button" id="nextBtn" onclick="nextPrev(1)">Siguiente</button>
                    </div>
                </div>
                <div class="tab">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i>descripccion id</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTabl" width="100%" cellspacing="0">            
                                    <thead>
                                        <tr>

                                            <th>ID</th>
                                            <th>IP</th>
                                            <th>TIPO</th>
                                            <th>VLAN</th>
                                            <th>SWITCH</th>
                                            <th>PUERTO</th>
                                            <th>modificar</th>

                                        </tr>
                                    </thead>

                                    <tbody>        
                                        <c:forEach var="f" items="${requestScope.servidor.etbInvDireccionamientoCollection}">
                                            <tr>
                                                <td>${f.dirId}</td>
                                                <td>${f.dirIp}</td>
                                                <td>${f.dirTipo.tipTipoIp}</td>
                                                <td>${f.dirVlan}</td>
                                                <td>${f.dirSwitch}</td>
                                                <td>${f.dirPuerto}</td>
                                                <td>
                                                    <form id="forminicio" action="direccionamientomod.htm" method="Post">
                                                        <input  name="serv" type="hidden" value="${f.dirId}">

                                                        <div>
                                                            <button  type="submit" class="button45 button46" title="Presione para ingresar">modificar</button>
                                                        </div>
                                                    </form></td>
                                            </tr>
                                        </c:forEach>               
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>

                        <form id="forminicio" action="direccionamiento.htm" method="Post">
                            <input  name="serv" type="hidden" value="${requestScope.idser}">
                            <input  name="servname" type="hidden" value="${requestScope.hostname}">
                            <div>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR IP</button>
                            </div>
                        </form>

                    </div></div>
                <div class="tab">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i>rutas</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable1" width="100%" cellspacing="0">            
                                    <thead>
                                        <tr>

                                            <th>Id</th>
                                            <th>Serial</th>
                                            <th>Ruta</th>
                                            <th>Fecha</th>
                                            <th>Serial</th>
                                            <th>modificar</th>


                                        </tr>
                                    </thead>

                                    <tbody>        
                                        <c:forEach var="f" items="${requestScope.rutaservidorcoll}">
                                            <tr>
                                                <td>${f.rutId}</td>
                                                <td>${f.rutSerial}</td>                                           
                                                <td>${f.rutRuta}</td>
                                                <td>${f.rutFecha}</td>
                                                <td>${f.rutSerial1.serHostname}</td>
                                                <td>
                                                    <form id="forminicio" action="rutamod.htm" method="Post">
                                                        <input  name="serv" type="hidden" value="${f.rutId}">

                                                        <div>
                                                            <button  type="submit" class="button45 button46" title="Presione para ingresar">modificar</button>
                                                        </div>
                                                    </form></td>

                                            </tr>
                                        </c:forEach>               
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                        <form id="forminicio" action="rutas.htm" method="Post">
                            <input  name="serv" type="hidden" value="${requestScope.idser}">
                            <input  name="servname" type="hidden" value="${requestScope.hostname}">
                            <div>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR RUTA</button>
                            </div>
                        </form>
                    </div></div>

                <div class="tab">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Data Table aseguramiento</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable0" width="100%" cellspacing="0">

                                    <thead>
                                        <TR>
                                            <th>ID</th>
                                            <th>FECHA</th>
                                            <th>TAREA</th>
                                            <th>SERVIDOR</th>
                                            <th>SERIAL</th>
                                            <th>EJECUTA</th>
                                            <th>SIS OPERATIVO</th>  
                                            <th>modificar</th>
                                        </tr>
                                    </thead>

                                    <tbody>        
                                        <c:forEach var="f" items="${requestScope.aseguramientocoll}">
                                            <tr>
                                                <td>${f.aseId}</td>
                                                <td>${f.aseFecha}</td>
                                                <td>${f.aseTarea}</td>
                                                <td>${f.aseServidor.serHostname}</td>
                                                <td>${f.aseServidor.serSerial}</td>
                                                <td>${f.aseEjecuta}</td>
                                                <td>${f.aseServidor.sisIdSisOperativo.sisNombre}</td>
                                                <td>
                                                    <form id="forminicio" action="asergmod.htm" method="Post">
                                                        <input  name="serv" type="hidden" value="${f.aseId}">

                                                        <div>
                                                            <button  type="submit" class="button45 button46" title="Presione para ingresar">modificar</button>
                                                        </div>
                                                    </form></td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                        <form id="forminicio" action="asegseerv.htm" method="Post">
                            <input  name="serv" type="hidden" value="${requestScope.idser}">
                            <div>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR aseguramiento</button>
                            </div>
                        </form>
                    </div></div>
                <div class="tab">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Data Table casos proveedor</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable3" width="100%" cellspacing="0">             
                                    <thead>
                                        <TR>      
                                            <th>ID</th>
                                            <th>PROVEEDOR</th>
                                            <th>FECHA APERTURA</th>
                                            <th>FECHA CIERRE</th>
                                            <th>NUMERO</th>
                                            <th>IM</th>
                                            <th>ESTADO</th> 
                                            <th>modificar</th>
                                        </tr>
                                    </thead>              

                                    <tbody>        
                                        <c:forEach var="f" items="${requestScope.casosprovservidorcoll}">
                                            <tr>
                                                <td>${f.caspId}</td>
                                                <td>${f.caspProv.marNomMarca}</td>
                                                <td>${f.caspFechaApe}</td>
                                                <td>${f.caspFechaCie}</td>
                                                <td>${f.caspNumero}</td>
                                                <td>${f.caspIm}</td>
                                                <td>${f.caspEstado.estcEstado}</td>
                                                <td>
                                                    <form id="forminicio" action="casosmod.htm" method="Post">
                                                        <input  name="caspId" type="hidden" value="${f.caspId}">

                                                        <div>
                                                            <button  type="submit" class="button45 button46" title="Presione para ingresar">modificar</button>
                                                        </div>
                                                    </form></td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                        <form id="forminicio" action="newcasosserv.htm" method="Post">
                            <input  name="casosserv" type="hidden" value="${requestScope.idser}">
                            <div>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR casos proveedor</button>
                            </div>
                        </form>
                    </div></div>
                <div class="tab">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Actividades abiertas</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable2" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>              
                                            <th>ID</th>
                                            <th>HOST</th>
                                            <th>TIPO</th>
                                            <th>TAREA</th>
                                            <th>FECHA_INICIO</th>
                                            <th>FECHA_FIN</th>
                                            <th>DESCRIPCION</th>              
                                            <th>servidor</th>              
                                        </tr>
                                    </thead>

                                    <tbody>        
                                        <c:forEach var="f" items="${requestScope.actividadservidorcoll}">
                                            <tr>
                                                <td>${f.actId}</td>
                                                <td>${f.actEjecuta}</td>
                                                <td>${f.actTipo.tipaNombre}</td>
                                                <td>${f.actTarea}</td>
                                                <td>${f.actFechaIni}</td>
                                                <td>${f.actFechaFin}</td>
                                                <td>${f.actDescripcion}</td>
                                                <td>${f.actServ}</td>

                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div></div>
                <div class="tab">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Data Table usuario</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable5" width="100%" cellspacing="0">            
                                    <thead>
                                        <tr>
                                            <th>usuario id</th>
                                            <th>usuario login</th>
                                            <th>usuario nombre</th>
                                            <th>usuario estado</th>                        
                                            <th>usuario hostname</th>
                                            <th>usuario serial</th>
                                            <th>usuario admin</th>
                                            <th>modificar</th>
                                            <th>detalle</th>
                                        </tr>
                                    </thead>

                                    <tbody>        

                                        <c:forEach var="f" items="${requestScope.usuarioservidorcoll}">
                                            <tr>

                                                <td>${f.ususId}</td>
                                                <td>${f.ususLogin}</td>
                                                <td>${f.ususNombre}</td>
                                                <td>${f.ususEstado.estuEstado}</td>
                                                <td>${f.idSerServidor.serHostname}</td>
                                                <td>${f.ususServ}</td>
                                                <td>${f.ususAdm}</td>
                                                <td> 
                                                    <form id="forminicio" action="usuarios.htm" method="Post">
                                                        <input  name="id" type="hidden" value="${f.ususId}">
                                                        <div>
                                                            <button  type="submit" class="button45 button46" title="Presione para ingresar">modificar</button>
                                                        </div>
                                                    </form>                                   
                                                </td>
                                                <td>
                                                    <form id="forminicio" action="detalle.htm" method="Post">
                                                        <input  name="id" type="hidden" value="${f.ususId}">
                                                        <input  name="usu" type="hidden" value="${f.ususLogin}">
                                                        <div>
                                                            <button  type="submit" class="button45 button46" title="Presione para ingresar">detalle</button>
                                                        </div>
                                                    </form>                                          
                                                </td>
                                            </tr>
                                        </c:forEach>  

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div> </div> 

                <div style="text-align:center;margin-top:40px;">
                    <span class="step"></span>
                    <span class="step"></span>
                    <span class="step"></span>     
                    <span class="step"></span>
                    <span class="step"></span> 
                </div>
            </div>

            <script src="<c:url value="/sps/js/personas.js"/>" ></script>


        </div>       
        <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>
