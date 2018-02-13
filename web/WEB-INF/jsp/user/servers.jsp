<%-- 
    Document   : nar
    Created on : 23/10/2017, 02:27:48 PM
    Author     : diegfraa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/plantilla/head.jsp" %>
    <%
        Integer m = (Integer) request.getAttribute("m");
    %>
    <body>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
        <div class="content-wrapper">
            </br></br></br>

            <%
                if (m == 1) {
            %>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/servers.htm"/>">volver z</a> 

            </div>
            <center>
                <!-- Begin # Login Form -->

                <!-- End # DIV Form -->
            </center>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Agregar Inventario</h2></div>
                <div class="panel-body">
                    <form  action="creat.htm" method="Post">   
                        <div class="row">
                            <div class="col-md-3">


                                <label class="control-label">SERIAL</label>
                                <input   name="serial" type="text" id="inputEmail" class="form-control" placeholder="Serial" required ><br/>
                                <label class="control-label">MARCA</label>
                                <select name="marca" class="form-control" required>
                                    <option value="">Marca</option>
                                    <c:forEach var="f" items="${requestScope.listaFonos}">
                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">ESTADO</label>
                                <select name="estado" class="form-control" required>
                                    <option value="">Estado</option>
                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                        <option value="${f.estIdEstado}">${f.estEstado}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">SISTEMA OPREATIVO</label>
                                <select name="sisoperativo" class="form-control" required>
                                    <option value="">Sistema Operativo</option>
                                    <c:forEach var="f" items="${requestScope.listaSis}">
                                        <option value="${f.sisIdSisOperativo}">${f.sisNombre}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">HOSTNAME</label>
                                <input   name="hostname" type="text" id="inputEmail" class="form-control" placeholder="Hostname" required><br/>
                                <label class="control-label">MODELO</label>
                                <select name="modelo" class="form-control" required>
                                    <option value="">Modelo</option>
                                    <c:forEach var="f" items="${requestScope.listaModelo}">
                                        <option value="${f.modIdModelo}">${f.modNomModelo}</option>
                                    </c:forEach>
                                </select><br/>
                            </div>
                            <div class="col-md-3">
                                <label class="control-label">GRUPO</label>
                                <select name="grupo" class="form-control" required>
                                    <option value="">Grupo</option>
                                    <c:forEach var="f" items="${requestScope.listaGrupo}">
                                        <option value="${f.gruIdGrupo}">${f.gruNomGrupo}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">PROCESADORES</label>
                                <input  name="prosesos" type="text" id="inputPassword" class="form-control" placeholder="Numero de Prosesos Fisicos" required><br/>

                                <label class="control-label">CORES</label>
                                <input   name="cores" type="text" id="inputEmail" class="form-control" placeholder="Cores" required ><br/>
                                <label class="control-label">CONEXION</label>
                                <input  name="conexion" type="text" id="inputPassword" class="form-control" placeholder="Conexion" required><br/>
                                <label class="control-label">CENTRAL</label>
                                <select name="central" class="form-control" required>
                                    <option value="">Central</option>
                                    <c:forEach var="f" items="${requestScope.listaCentral}">
                                        <option value="${f.cenIdCentral}">${f.cenNombre}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">SALON</label>
                                <select name="dc" class="form-control" required>
                                    <option value="">Data Center o Salon</option>
                                    <c:forEach var="f" items="${requestScope.listaSalon}">
                                        <option value="${f.salIdSalon}">${f.salNombre}</option>
                                    </c:forEach>
                                </select><br/>
                            </div><div class="col-md-3">
                                <label class="control-label">RACK</label>
                                <input   name="rack" type="text" id="inputEmail" class="form-control" placeholder="Rack" required ><br/>
                                <label class="control-label">UNIDAD</label>
                                <input  name="unidad" type="text" id="inputPassword" class="form-control" placeholder="Unidad" required><br/>
                                <label class="control-label">PLATAFORMA</label>
                                <select name="plataforma" class="form-control" required>
                                    <option value="">Plataforma</option>
                                    <c:forEach var="f" items="${requestScope.listaPlat}">
                                        <option value="${f.plaIdPlataforma}">${f.plaNomPlataforma}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">PROYECTO</label>
                                <input  name="proyecto" type="text" id="inputPassword" class="form-control" placeholder="Proyecto" required><br/>


                                <label class="control-label">CLIENTE</label>
                                <select name="cliente" class="form-control" required>
                                    <option value="">Cliente</option>
                                    <c:forEach var="f" items="${requestScope.listaCliente}">
                                        <option value="${f.cliIdCliente}">${f.cliNombre}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">ADMINISTRADOR PLATAFORMA</label>
                                <select name="adplataforma" class="form-control" required>
                                    <option value="1">Plataforma Administrada</option>
                                    <option value="1">SI</option> 
                                    <option value="0">NO</option>                                                  
                                </select><br/>
                            </div><div class="col-md-3">
                                <label class="control-label">ROL</label>
                                <select name="rol" class="form-control" required>
                                    <option value="">Rol</option>
                                    <c:forEach var="f" items="${requestScope.listaRol}">
                                        <option value="${f.rolIdRolServ}">${f.rolNomRolServ}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">ADMINISTRACION COMPARTIDA</label>
                                <select name="SER_AD_COMPARTIDA" class="form-control" required>
                                    <option value="1">Administracion Compartida</option>
                                    <option value="1">SI</option> 
                                    <option value="0">NO</option>                                                  
                                </select><br/>
                                <label class="control-label">TAREA</label>

                                <input   name="tarea" type="text" id="inputEmail" class="form-control" placeholder="Tarea Ingreso" required ><br/>
                                <label class="control-label">MEM</label>
                                <input  name="servMem" type="text" id="inputPassword" class="form-control" placeholder="Mem" required><br/>
                                <label class="control-label">DISCO C</label>
                                <input   name="servDiscoC" type="text" id="inputEmail" class="form-control" placeholder="Disco C" required ><br/>
                                <label class="control-label">TAREA ADMINISTRACION COMPARTIDA</label>
                                <input   name="addominios" type="text" id="inputEmail" class="form-control" placeholder="TAREA ADMINISTRACION COMPARTIDA" required ><br/>               
                            </div>
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
                </div>

            </div>

            <%
                }
                if (m == 8) {
            %>
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
                    <input  name="tdserv" type="hidden" value="${requestScope.servidor.serServer}">
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
                            <input  name="serv" type="hidden" value="${requestScope.servidor.serServer}">
                            <input  name="servname" type="hidden" value="${requestScope.servidor.serHostname}">
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
                                        <c:forEach var="f" items="${requestScope.servidor.etbInvRutaCollection}">
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
                            <input  name="serv" type="hidden" value="${requestScope.servidor.serServer}">
                            <input  name="servname" type="hidden" value="${requestScope.servidor.serHostname}">
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
                                        <c:forEach var="f" items="${requestScope.servidor.etbInvAseguramientoCollection}">
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
                            <input  name="serv" type="hidden" value="${requestScope.servidor.serServer}">
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
                                        <c:forEach var="f" items="${requestScope.servidor.etbInvCasosProvCollection}">
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
                            <input  name="casosserv" type="hidden" value="${requestScope.servidor.serServer}">
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
                                            <th>modificar</th>
                                        </tr>
                                    </thead>

                                    <tbody>        
                                        <c:forEach var="f" items="${requestScope.servidor.etbInvActividadCollection}">
                                            <tr>
                                                <td>${f.actId}</td>
                                                <td>${f.actEjecuta}</td>
                                                <td>${f.actTipo.tipaNombre}</td>
                                                <td>${f.actTarea}</td>
                                                <td>${f.actFechaIni}</td>
                                                <td>${f.actFechaFin}</td>
                                                <td>${f.actDescripcion}</td>
                                                <td>${f.actServ}</td>
 <td>
                                                    <form id="forminicio" action="modactivser.htm" method="Post">
                                                        <input  name="idact" type="hidden" value="${f.actId}">

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
                         <form id="forminicio" action="newactivser.htm" method="Post">
                            <input  name="servd" type="hidden" value="${requestScope.servidor.serServer}">
                            <div>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR actividades</button>
                            </div>
                        </form>
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

                                        <c:forEach var="f" items="${requestScope.servidor.etbInvUsuServCollection}">
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
                         <form id="forminicio" action="modususer.htm" method="Post">
                            <input  name="servd" type="hidden" value="${requestScope.servidor.serServer}">
                            <div>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR usuario servidor</button>
                            </div>
                        </form>
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


            <%
                }
                if (m == 0) {
            %>

            <div class="panel panel-primary">

                <div class=" panel-heading"><h2>Inventario</h2></div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-3"></div>
                                <div class="col-md-3">
                                    <div class="box-bottom">
                                        <a  role="button" href="<c:url value="/aserver.htm"/>">agregar</a> 
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="flex-caption">
                                        <div class="box-bottom">
                                            <a  role="button" data-toggle="modal" data-target="#login-modal">REPORTE</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3"></div>
                            </div>
                            <div class="card-header">
                                <i class="fa fa-table"></i> Data Table servidores</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">            
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>TblServSerial</th>
                                                <th>TblServHostName</th>

                                                <th>TblClienteNombre</th>

                                                <th>TblEstadoEstado</th>
                                                <th>modificar</th>

                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>ID</th>
                                                <th>TblServSerial</th>
                                                <th>TblServHostName</th>

                                                <th>TblClienteNombre</th>

                                                <th>TblEstadoEstado</th>
                                                <th>modificar</th>

                                            </tr>
                                        </tfoot>
                                        <tbody>        
                                            <c:forEach var="f" items="${requestScope.listaServer}">
                                                <tr>
                                                    <td>${f.serServer}</td>
                                                    <td>
                                                        <form id="forminicio" action="TdServ.htm" method="Post">
                                                            <input  name="tdserv" type="hidden" value="${f.serServer}">
                                                            <div>
                                                                <button  type="submit" class="button45 button46" title="Presione para ingresar">${f.serSerial}</button>
                                                            </div>
                                                        </form></td>
                                                    <td>
                                                        <form id="forminicio" action="TdServ.htm" method="Post">
                                                            <input  name="tdserv" type="hidden" value="${f.serServer}">
                                                            <div>
                                                                <button  type="submit" class="button45 button46" title="Presione para ingresar">${f.serHostname}</button>
                                                            </div>
                                                        </form></td>

                                                    <td>${f.cliIdCliente.cliNombre}</td>

                                                    <td>${f.estIdEstado.estEstado}</td>  
                                                    <td>
                                                        <form id="forminicio" action="modificarservidor.htm" method="Post">
                                                            <input  name="tdserv" type="hidden" value="${f.serServer}">
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
                        </div>
                    </div>

                </div>
            </div>
            <!-- fin de tabla-->                   
            <!-- Begin # DIV Form -->
            <%
                }
                if (m == 3) {
            %>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
            </div>
            <table>
                <tr>
                    <td><input type="button" id="btnExport" value="Descargar a Excel "/></td>
                </tr>
            </table>
            <div id="serv" class="card mb-3">
                <div class="card-header">
                    <h3><i class="fa fa-table"></i>${titulo}</h3> </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered"  width="100%" cellspacing="0">            
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>TblServSerial</th>
                                    <th>TblServHostName</th>
                                    <th>TblMarcaMarca</th>
                                    <th>TblModeloModelo</th>
                                    <th>TblClienteNombre</th>
                                    <th>TblSoNombre</th>
                                    <th>TblGrupoNombre</th>
                                    <th>TblEstadoEstado</th>
                                    <td>estIdEstadoestEstado</td>  

                                </tr>
                            </thead>

                            <tbody>        
                                <c:forEach var="f" items="${requestScope.listreporte}">
                                    <tr>
                                        <td>${f.serServer}</td>
                                        <td>${f.serSerial}</td>
                                        <td>${f.serHostname}</td>
                                        <td>${f.marIdMarca.marNomMarca}</td>
                                        <td>${f.modIdModelo.modNomModelo}</td>
                                        <td>${f.cliIdCliente.cliNombre}</td>
                                        <td>${f.sisIdSisOperativo.sisNombre}</td>
                                        <td>${f.gruIdGrupo.gruNomGrupo}</td>
                                        <td>${f.estIdEstado.estEstado}</td>  
                                        <td>${f.serFIngreso}</td>  
                                    </tr>
                                </c:forEach>     
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <script>
                                $("#btnExport").click(function (e) {
                                    window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#serv').html() + name));
                                    e.preventDefault();
                                });
            </script>
            <!-- fin de tabla-->                   
            <!-- Begin # DIV Form -->
            <%}
            %>
            <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                    <div class="modal-content" style="background: #20a4cb">
                        <div class="modal-header" align="center">
                            <span>REPORTE</span>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                            </button>
                        </div>
                        <!-- Begin # DIV Form -->
                        <div id="div-forms" >
                            <!-- Begin # Login Form -->
                            <form id="forminicio" action="serversreport.htm" method="Post">
                                <div class="modal-body" style="background: #20a4cb"> 
                                    <div id="div-login-msg">
                                        <div  id="icon-login-msg" class="glyphicon glyphicon-user"></div>
                                    </div>
                                    <input id="login_username" class="form-control" type="text" name="F_Inicio" placeholder="Fecha Inicio" required="" autocomplete="off">
                                    <div id="div-login-msg">
                                        <div id="icon-login-msg" class="glyphicon glyphicon-minus-sign"></div>
                                    </div>
                                    <input id="login_password" class="form-control" type="text"  name="F_Fin" placeholder="Fecha Fin" required="">
                                    <input type="hidden"  name="F" value="1">
                                </div>
                                <div class="modal-footer" style="background:#ff5c39">
                                    <div>
                                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: #ffffff">INGRESAR</button>
                                    </div>
                                </div>
                            </form>
                            <!-- End # DIV Form -->
                        </div>
                    </div>
                </div>
            </div>
        </div>       
        <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>
