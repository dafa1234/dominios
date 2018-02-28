<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/plantilla/head.jsp" %>
    <body>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
        <div class="content-wrapper">
            </br></br>



            <%
                Integer m = (Integer) request.getAttribute("m");

                if (m == 0) {
            %> 
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>agregar aseguramiento</h2></div>
                <div class="flex-caption">
                    <div class="box-bottom">

                        <a  role="button" href="<c:url value="/aseguramiento.htm"/>">volver</a> 
                    </div>       

                    <!-- Begin # DIV Form -->
                    <div id="div-forms" >

                        <!-- Begin # Login Form -->
                        <form id="forminicio" action="aseg.htm"  method="Post">
                            <div class="row">
                                <div class="col-md-6">



                                    <label class="control-label">SERVIDOR</label>
                                    <input   name="servidor" type="hidden" id="inputEmail" class="form-control" value="${requestScope.serv.serServer}" placeholder="TAREA" required >
                                    <p class="form-control" >${requestScope.serv.serHostname}</p><br/><br/>
                                    <label class="control-label">TAREA</label>
                                    <input   name="tarea" type="text" id="inputEmail" class="form-control" placeholder="TAREA" required ><br/><br/>
                                    <label class="control-label">EJECUTA</label>
                                    <input  name="eje" type="text" id="inputPassword" class="form-control" placeholder="EJECUTA" required><br/><br/>
                                </div><div class="col-md-6">
                                    <label class="control-label">FECHA INICIO</label>       
                                    <input  name="fini" type="text"   id="Fecha_Inicio" class="form-control" placeholder="fecha inicio" required></br><br/>
                                    <label class="control-label">PLANTILLA</label>
                                    <input   name="plantilla" type="file"  size=60 class="form-control" required ><br/><br/>
                                    <label class="control-label">PLANTILLA</label>
                                    <input   name="plantillan" type="text" placeholder="escriba la ubicacion del archivo"  class="form-control" required ><br/><br/>
                                </div></div>
                            <center>
                                <div>
                                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="btn btn-success btn-lg "  >INGRESAR</button>
                                </div>
                            </center>
                        </form>
                        <!-- End # DIV Form -->
                    </div>

                </div>
            </div>
            <%}
                if (m == 6) {
            %> 
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar aseguramiento </h2></div>
                <div class="box-bottom">

                    <a  role="button" href="<c:url value="/aseguramiento.htm"/>">volver</a> 
                </div>       
                <center>
                    <!-- Begin # DIV Form -->
                    <div id="div-forms" >

                        <!-- Begin # Login Form -->
                        <form id="forminicio" action="asegmod.htm" method="Post">
                            <div class="row">
                                <div class="col-md-6">

                                    <label class="control-label">SERVIDOR</label>
                                    <input   name="idasegu" type="hidden" id="inputEmail" class="form-control" value="${requestScope.aseg.aseId}" placeholder="TAREA" required >
                                    <p class="form-control" >${requestScope.aseg.aseServidor.serHostname}</p><br/><br/>
                                    <label class="control-label">Tarea</label>
                                    <p class="form-control" >${requestScope.aseg.aseTarea}</p><br/><br/>
                                    <label class="control-label">Ejecuta</label>
                                    <p class="form-control" >${requestScope.aseg.aseEjecuta}</p><br/><br/>
                                </div>
                                <div class="col-md-6">
                                    <label class="control-label">Fecha Inicio</label>
                                    <input  name="fini" type="text"   id="Fecha_Inicio" class="form-control" value="${requestScope.aseg.aseFecha}" placeholder="fecha inicio" required></br><br/>
                                    <label class="control-label">Tarea Cambio</label>
                                    <input   name="tareacambio" type="text" id="inputEmail" class="form-control" placeholder="tarea cambio" required ><br/><br/>
                                    <label class="control-label">Plantilla</label>
                                    <input   name="plantilla" type="file" id="inputEmail" class="form-control" placeholder="PLANTILLA" required >
                                    <label class="control-label">Plantilla</label>
                                    <p class="form-control" >${requestScope.aseg.asePlantilla}</p><br/><br/>
                                </div>
                            </div>
                            <div>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="btn btn-success btn-lg ">INGRESAR</button>
                            </div>

                        </form>


                        <!-- End # DIV Form -->

                    </div>
                </center>
            </div>
            <%
                }
                if (m == 1) {
            %>

            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Agregar IP</h2></div>
                <div class="panel-body">
                    <form  action="direccionamientoagregar.htm" method="Post">                            
                        <div id="div-login-msg"> 
                            <div class="row">
                                <div class="col-md-6">



                                    <label class="control-label">SERVIDOR</label>
                                    <input   name="idSer1" type="hidden" id="inputEmail"   required value="${requestScope.servip}" ><p class="form-control" >${requestScope.servipname}</p><br/>
                                    <label class="control-label">IP</label>
                                    <input   name="dirIp" type="text" id="inputEmail" class="form-control" placeholder="dirIp" required ><br/>

                                    <label class="control-label">VLAN</label>
                                    <input   name="dirVlan" type="text" id="inputEmail" class="form-control" placeholder="dirVlan" required ><br/>


                                </div>
                                <div class="col-md-6">
                                    <label class="control-label">PUERTO</label>
                                    <input   name="dirPuerto" type="text" id="inputEmail" class="form-control" placeholder="dirPuerto" required ><br/>

                                    <label class="control-label">SWITCH</label>
                                    <input   name="dirSwitch" type="text" id="inputEmail" class="form-control" placeholder="dirSwitch" required ><br/>  

                                    <label class="control-label">TIPO ID</label>
                                    <select name="dirTipo1" class="form-control" required>
                                        <option value="">tipo ip</option>
                                        <c:forEach var="f" items="${requestScope.Listatipoip}">
                                            <option value="${f.tipIdIp}">${f.tipTipoIp}</option>
                                        </c:forEach>
                                    </select><br/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <center>
                                        <div>
                                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="btn btn-success btn-lg "  >INGRESAR</button>
                                        </div>
                                    </center>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div>

            <%
                }
                if (m == 3) {
            %>

            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar IP</h2></div>
                <div class="panel-body">
                    <form  action="direccionamientomodificar.htm" method="Post">                            
                        <div id="div-login-msg"> 
                            <div class="row">
                                <div class="col-md-6">

                                    <label class="control-label">tarea cambio</label>
                                    <input   name="tareacambio" type="text" class="form-control" required >

                                    <label class="control-label">SERVIDOR</label>
                                    <input   name="iddirIp" type="hidden" id="inputEmail"   required value="${requestScope.servip.dirId}" >
                                    <input   name="idSer1" type="hidden" id="inputEmail"   required value="${requestScope.servip.idSer.serServer}" ><p class="form-control" >${requestScope.servip.idSer.serHostname}</p><br/>
                                    <label class="control-label">IP</label>
                                    <input   name="dirIp" type="text" id="inputEmail" class="form-control" value="${requestScope.servip.dirIp}" placeholder="dirIp" required ><br/>

                                    <label class="control-label">VLAN</label>
                                    <input   name="dirVlan" type="text" id="inputEmail" class="form-control" value="${requestScope.servip.dirVlan}" placeholder="dirVlan" required ><br/>


                                </div>
                                <div class="col-md-6">
                                    <label class="control-label">PUERTO</label>
                                    <input   name="dirPuerto" type="text" id="inputEmail" class="form-control" value="${requestScope.servip.dirPuerto}" placeholder="dirPuerto" required ><br/>

                                    <label class="control-label">SWITCH</label>
                                    <input   name="dirSwitch" type="text" id="inputEmail" class="form-control" value="${requestScope.servip.dirSwitch}" placeholder="dirSwitch" required ><br/>  

                                    <label class="control-label">TIPO ID</label>
                                    <select name="dirTipo1" class="form-control" required>
                                        <option value="${requestScope.servip.dirTipo.tipIdIp}">${requestScope.servip.dirTipo.tipTipoIp}</option>
                                        <c:forEach var="f" items="${requestScope.Listatipoip}">
                                            <option value="${f.tipIdIp}">${f.tipTipoIp}</option>
                                        </c:forEach>
                                    </select><br/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <center>
                                        <div>
                                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="btn btn-success btn-lg "  >modificar</button>
                                        </div>
                                    </center>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <%
                }
                if (m == 4) {
            %>

            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Agregar ruta</h2></div>
                <div class="panel-body">
                    <form  action="rutaagregar.htm" method="Post">                            
                        <div id="div-login-msg"> 
                            <div class="row">
                                <div class="col-md-12">



                                    <label class="control-label">SERVIDOR</label>
                                    <input   name="idSer1" type="hidden" id="inputEmail" value="${requestScope.servip}" ><p class="form-control" >${requestScope.servipname}</p><br/>          
                                    <label class="control-label">RUTA</label>                                  
                                    <textarea  name="rutaser" type="text" id="inputPassword" class="form-control" placeholder="escriba la ruta" required></textarea>



                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <center>
                                        <div>
                                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="btn btn-success btn-lg "  >INGRESAR</button>
                                        </div>
                                    </center>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
            <%
                }
                if (m == 5) {
            %>

            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar rutas</h2></div>
                <div class="panel-body">
                    <form  action="rutadificar.htm" method="Post">                            
                        <div id="div-login-msg"> 
                            <div class="row">
                                <div class="col-md-6">
                                    <label class="control-label">SERVIDOR</label>
                                    <input   name="rutasId" type="hidden" id="inputEmail"   required value="${requestScope.rutas.rutId}" >
                                    <input   name="rutaIdser" type="hidden" id="inputEmail"   required value="${requestScope.rutas.rutSerial.serServer}" >
                                    <p class="form-control" >${requestScope.rutas.rutSerial.serSerial}</p><br/>
                                    <label class="control-label">fecha</label>
                                    <input   name="rutaF" type="hidden" id="inputEmail" class="form-control" value="${requestScope.rutas.rutFecha}" placeholder="dirVlan" required >
                                    <p class="form-control" >${requestScope.rutas.rutFecha}</p><br/>
                                </div>
                                <div class="col-md-6">
                                    <label class="control-label">tarea cambio</label>
                                    <input   name="tareacambio" type="text" class="form-control" required >
                                    <label class="control-label">ruta</label>
                                    <textarea  name="rutaser" type="text" id="inputPassword" class="form-control" value="${requestScope.rutas.rutRuta}" placeholder="escriba la ruta" required>${requestScope.rutas.rutRuta}</textarea>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <center>
                                        <div>
                                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="btn btn-success btn-lg "  >modificar</button>
                                        </div>
                                    </center>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
            <%
                }
                if (m == 2) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Editar Servidor</div>
                 <div class="box-bottom">
                    <a  role="button" href="<c:url value="/servers.htm"/>">volver</a> 
                </div> 
                <form id="forminicio" action="modificarserv.htm" method="Post">
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fa fa-table"></i> Editar Servidor</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered"  width="100%" cellspacing="0">            

                                    <tr>
                                        <th class="control-label">ID :</th>
                                        <td><input  name="idservidor" type="hidden" value=" ${requestScope.servidor.serServer}">
                                            ${requestScope.servidor.serServer}
                                        </td>
                                        <th class="control-label">SERIAL :</th>
                                        <td>
                                            ${requestScope.servidor.serSerial}
                                        </td>
                                        <th class="control-label">HONTNAME :</th>
                                        <td><input  name="hostnameservidor" type="text" class="form-control" value="${requestScope.servidor.serHostname}">                                       
                                        </td>

                                    <tr/>
                                    <tr> 
                                        <th class="control-label">MARCA :</th>
                                        <td>

                                            ${requestScope.servidor.marIdMarca.marNomMarca}                                       
                                        </td>
                                        <th class="control-label">MODELO :</th>
                                        <td>

                                            ${requestScope.servidor.modIdModelo.modNomModelo}
                                        </td>
                                        <th class="control-label">SISTEMA OPERATIVO :</th>
                                        <td>
                                            <select name="sisopreaservidor" class="form-control" required>
                                                <option value="${requestScope.servidor.sisIdSisOperativo.sisIdSisOperativo}">${requestScope.servidor.sisIdSisOperativo.sisNombre}</option>
                                                <c:forEach var="f" items="${requestScope.listaSis}">
                                                    <option value="${f.sisIdSisOperativo}">${f.sisNombre}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <th class="control-label">CONEXION :</th>
                                        <td><input  name="conexionservidor" type="text" class="form-control" value="${requestScope.servidor.serConexion}">
                                        </td>
                                        <th class="control-label">ESTADO :</th>
                                        <td>
                                            <select name="estadoservidor" class="form-control" required>
                                                <option value="${requestScope.servidor.estIdEstado.estIdEstado}">${requestScope.servidor.estIdEstado.estEstado}</option>
                                                <c:forEach var="f" items="${requestScope.listaEstado}">
                                                    <option value="${f.estIdEstado}">${f.estEstado}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <th class="control-label">CENTRAL :</th>
                                        <td>
                                            <select name="centralservidor" class="form-control" required>
                                                <option value="${requestScope.servidor.cenIdCentral.cenIdCentral}">${requestScope.servidor.cenIdCentral.cenNombre}</option>
                                                <c:forEach var="f" items="${requestScope.listaCentral}">
                                                    <option value="${f.cenIdCentral}">${f.cenNombre}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    <tr/>
                                    <tr>
                                        <th class="control-label">SALON :</th>
                                        <td>
                                            <select name="salonservidor" class="form-control" required>
                                                <option value="${requestScope.servidor.salIdSalon.salIdSalon}">${requestScope.servidor.salIdSalon.salNombre}</option>
                                                <c:forEach var="f" items="${requestScope.listaSalon}">
                                                    <option value="${f.salIdSalon}">${f.salNombre}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <th class="control-label">RACK :</th>
                                        <td><input  name="rackservidor" type="text" class="form-control" value="${requestScope.servidor.serRack}">
                                        </td>
                                        <th class="control-label">UNIDAD :</th>
                                        <td><input  name="unidadservidor" type="text" class="form-control" value="${requestScope.servidor.serUnidad}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="control-label">GRUPO  :</th>
                                        <td>
                                            <select name="gruposervidor" class="form-control" required>
                                                <option value="${requestScope.servidor.gruIdGrupo.gruIdGrupo}">${requestScope.servidor.gruIdGrupo.gruNomGrupo}</option>
                                                <c:forEach var="f" items="${requestScope.listaGrupo}">
                                                    <option value="${f.gruIdGrupo}">${f.gruNomGrupo}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <th class="control-label">CLIENTE :</th>
                                        <td>
                                            <select name="clienteservidor" class="form-control" required>
                                                <option value="${requestScope.servidor.cliIdCliente.cliIdCliente}">${requestScope.servidor.cliIdCliente.cliNombre}</option>
                                                <c:forEach var="f" items="${requestScope.listaCliente}">
                                                    <option value="${f.cliIdCliente}">${f.cliNombre}</option>
                                                </c:forEach>
                                            </select>
                                        </td >
                                        <th class="control-label">PROYECTO :</th>
                                        <td><input  name="proyectoservidor" type="text" class="form-control" value="${requestScope.servidor.serProyecto}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="control-label">ROL SERVIDOR :</th>
                                        <td>
                                            <select name="rolservidor" class="form-control" required>
                                                <option value="${requestScope.servidor.rolIdRolServ.rolIdRolServ}">${requestScope.servidor.rolIdRolServ.rolNomRolServ}</option>
                                                <c:forEach var="f" items="${requestScope.listaRol}">
                                                    <option value="${f.rolIdRolServ}">${f.rolNomRolServ}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <th class="control-label">PLATAFORMA :</th>
                                        <td>
                                            <select name="plataformaservidor" class="form-control" required>
                                                <option value="${requestScope.servidor.plaIdPlataforma.plaIdPlataforma}">${requestScope.servidor.plaIdPlataforma.plaNomPlataforma}</option>
                                                <c:forEach var="f" items="${requestScope.listaPlat}">
                                                    <option value="${f.plaIdPlataforma}">${f.plaNomPlataforma}</option>
                                                </c:forEach>
                                            </select>
                                        </td>

                                    </tr>
                                    <tr>
                                        <th class="control-label">TAREA INGRESO :</th>
                                        <td>

                                            ${requestScope.servidor.serTIngreso}
                                        </td>
                                        <th class="control-label">No PROCESOS FISICOS :</th>
                                        <td><input  name="Nprocesosservidor" type="text" class="form-control" value="${requestScope.servidor.serNoProcFisico}">
                                        </td>
                                        <th class="control-label">TAREA AD COMPARTIDA :</th>
                                        <td>
                                            ${requestScope.servidor.serTareaAdCompartida}
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="control-label">ADMINISTRACION COMPARTIDA :</th>
                                        <td>
                                            <select name="adcompservidor" class="form-control" required>
                                                <option value="1"> ${requestScope.servidor.serAdCompartida}</option>
                                                <option value="1">SI</option> 
                                                <option value="0">NO</option>                                                  
                                            </select>
                                        </td>
                                        <th class="control-label">ADMINISTRADO :</th>
                                        <td>
                                            <select name="admiservidor" class="form-control" required>
                                                <option value="1"> ${requestScope.servidor.serAdministrado}</option>
                                                <option value="1">SI</option> 
                                                <option value="0">NO</option>                                                  
                                            </select>
                                        </td>
                                        <th class="control-label">CORES :</th>
                                        <td><input  name="coresservidor" type="text" class="form-control" value="${requestScope.servidor.serCores}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="control-label">MEM :</th>
                                        <td><input  name="memservidor" type="text" class="form-control" value="${requestScope.servidor.servMem}">
                                        </td>
                                        <th class="control-label">DISCOC :</th>
                                        <td><input  name="discocservidor" type="text" class="form-control" value="${requestScope.servidor.servDiscoC}">
                                        </td>
                                        <th class="control-label">tarea cambio</th>
                                        <td><input  name="tareacambio" type="text" class="form-control"  required="">
                                        </td>
                                    </tr>

                                </table>
                                <div class="row">
                                    <div class="col-md-4"></div>
                                    <div class="col-md-4">
                                        <div><center>
                                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="btn btn-success btn-lg ">editar</button>
                                            </center>
                                        </div>
                                    </div>
                                    <div class="col-md-4"></div>
                                </div>
                            </div>
                        </div>

                    </div>

                </form>
            </div>
            <%
                }
                if (m == 7) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Agregar casos proveedor</h2></div>
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/caprov.htm"/>">volver</a> 
                </div> 

                <!-- Begin # DIV Form -->
                <div id="div-forms" >
                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="caprovs.htm" method="Post">
                        <div class="row">
                            <div class="col-md-6">

                                <label class="control-label">proveedor</label>
                                <select name="proveedor" class="form-control" required>
                                    <option value="">proveedor</option>
                                    <c:forEach var="f" items="${requestScope.ListaMarca}">
                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                    </c:forEach>
                                </select><br/><br/>

                                <label class="control-label">Servidor</label>
                                <input   name="servidor" type="hidden" id="inputEmail"   required value="${requestScope.casosserv.serServer}" >
                                <p class="form-control" >${requestScope.casosserv.serHostname}</p><br/>
                                <label class="control-label">Fecha inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha apertura" required><br/><br/>
                            </div> <div class="col-md-6">
                                <label class="control-label">Fecha Cierre</label>
                                <input  name="fcie" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha cierre" required><br/><br/>
                                <label class="control-label">Estado</label>
                                <select name="estini" class="form-control" required>
                                    <option value="">estado inicial</option>
                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                        <option value="${f.estcId}">${f.estcEstado}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">Numero</label>
                                <input   name="numcas" type="text" id="inputEmail" class="form-control" placeholder="numero caso"  required><br/><br/>
                                <label class="control-label">IM</label>
                                <input   name="im" type="text" id="inputEmail" class="form-control" placeholder="im" required ><br/><br/>
                            </div></div>
                        <div><center>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </center>
                        </div>                   
                    </form>
                    <!-- End # DIV Form -->
                </div>

            </div>

            <%
                }
                if (m == 8) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar casos proveedor</div>
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/caprov.htm"/>">volverm</a> 
                </div> 

                <!-- Begin # DIV Form -->
                <div id="div-forms" >
                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="modificarcasos.htm" method="Post">            
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-5">
                                <label class="control-label">proveedor</label>
                                <select name="proveedor" class="form-control" required>
                                    <option value="${requestScope.cas.caspProv.marIdMarca}">${requestScope.cas.caspProv.marNomMarca}</option>
                                    <c:forEach var="f" items="${requestScope.ListaMarca}">
                                        <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">Servidor</label>                                                     
                                <input   name="idcasos" type="hidden"   value="${requestScope.cas.caspId}" >
                                <p class="form-control" >${requestScope.cas.caspServ.serSerial}</p>
                                <label class="control-label">Fecha Inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" value="${requestScope.cas.caspFechaApe}" class="form-control" placeholder="fecha apertura" required><br/>
                                <label class="control-label">Fecha Cierre</label>
                                <input  name="fcie" type="text" id="Fecha_Fin" value="${requestScope.cas.caspFechaCie}" class="form-control" placeholder="fecha cierre" required><br/>
                            </div> 
                            <div class="col-md-5">
                                <label class="control-label">Estado</label>
                                <select name="estini" class="form-control" required>
                                    <option value="${requestScope.cas.caspEstado.estcId}">${requestScope.cas.caspEstado.estcEstado}</option>
                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                        <option value="${f.estcId}">${f.estcEstado}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">Numero</label>
                                <input   name="numcas" type="text" id="inputEmail" value="${requestScope.cas.caspNumero}" class="form-control" placeholder="numero caso"  required><br/>
                                <label class="control-label">IM</label>
                                <input   name="im" type="text" id="inputEmail" value="${requestScope.cas.caspIm}" class="form-control" placeholder="im" required ><br/>
                                <label class="control-label">Tarea Cambio</label>
                                <input   name="tareacambio" type="text" id="inputEmail"  class="form-control" placeholder="tarea caMBIO" required ><br/>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                        <div>
                            <center>
                                <button id="btniniciar" type="submit" data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg">INGRESAR</button>
                            </center>
                        </div>                   
                    </form>
                    <!-- End # DIV Form -->
                </div>

            </div>
            <%
                }
                if (m == 9) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>agregar actividades</h2></div>
                <center>
                    <!-- Begin # Login Form -->
                    <form action="acts.htm" method="Post">
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-5">
                                <label class="control-label">TIPO</label>
                                <select name="tipo" class="form-control" required>
                                    <option value="">tipo</option>
                                    <c:forEach var="f" items="${requestScope.Listatipoactiv}">
                                        <option value="${f.tipaId}">${f.tipaNombre}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">SERVIDOR</label>
                                <input   name="serv" type="hidden" id="inputEmail"   required value="${requestScope.serv.serServer}" >
                                <p class="form-control" >${requestScope.serv.serHostname}</p><br/>
                                <label class="control-label">EJECUTA</label>
                                <input  name="eje" type="text" id="inputPassword" class="form-control" placeholder="ejecuta" required><br/><br/>
                                <label class="control-label">SECHA INICIO</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicio" required><br/><br/>
                            </div>
                            <div class="col-md-5">
                                <label class="control-label">TAREA</label>
                                <input   name="tarea" type="text" id="inputEmail" class="form-control" placeholder="tarea" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                                <label class="control-label">DESCCRIPCION</label>
                                <textarea  name="desc" type="text" id="inputPassword" class="form-control" placeholder="descripcion" required></textarea><br/><br/></td>
                                <label class="control-label">FECHA FIN</label>   
                                <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha fin" required><br/><br/></td>
                                <label class="control-label">SOLICITA</label>                    
                                <input   name="sol" type="text" id="inputEmail" class="form-control" placeholder="solicita" required autofocus class="nav nav-pills nav-stacked"><br/><br/></td>
                            </div>
                        </div>


                        <div><center>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                        class="btn btn-success btn-lg "  >INGRESAR</button>
                            </center>
                        </div> 

                    </form>
                </center>
            </div>
            <%
                }
                if (m == 10) {
            %>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Modificar actividades</h2></div>


                <!-- Begin # Login Form -->
                <form action="modact.htm" method="Post">
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <label class="control-label">TIPO</label>
                            <select name="tipo" class="form-control" required>
                                <option value="${requestScope.acti.actTipo.tipaId}">${requestScope.acti.actTipo.tipaNombre}</option>
                                <c:forEach var="f" items="${requestScope.Listatipoactiv}">
                                    <option value="${f.tipaId}">${f.tipaNombre}</option>
                                </c:forEach>
                            </select><br/><br/>
                            <label class="control-label">servidor</label>
                            <input   name="serv" type="hidden" id="inputEmail"   required value="${requestScope.acti.actId}" >
                            <p class="form-control" >${requestScope.acti.actServ.serHostname}</p><br/>
                            <label class="control-label">ejecuta</label>
                            <input  name="eje" type="text" id="inputPassword" value="${requestScope.acti.actEjecuta}" class="form-control" placeholder="ejecuta" required><br/><br/>
                            <label class="control-label">Fecha incio</label>
                            <input  name="fini" type="text" id="Fecha_Inicio" value="${requestScope.acti.actFechaIni}" class="form-control" placeholder="fecha inicio" required><br/><br/>
                            <label class="control-label">tarea</label>
                            <input   name="tarea" type="text" id="inputEmail" value="${requestScope.acti.actTarea}" class="form-control" placeholder="tarea" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                        </div>
                        <div class="col-md-5">
                            <label class="control-label">descripcion</label>
                            <textarea  name="desc" type="text" id="inputPassword" value="${requestScope.acti.actDescripcion}" class="form-control" placeholder="descripcion" required>${requestScope.acti.actDescripcion}</textarea><br/><br/>
                            <label class="control-label">fecha fin</label>
                            <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" value="${requestScope.acti.actFechaFin}" placeholder="fecha fin" required><br/><br/>
                            <label class="control-label">solicita</label>
                            <input   name="sol" type="text" id="inputEmail" class="form-control" value="${requestScope.acti.actSolicita}" placeholder="solicita" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                            <label class="control-label">tarea de cambio</label>
                            <input   name="tareacambio" type="text" id="inputEmail" class="form-control"  placeholder="tarea cambio" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                        </div>
                        <div class="col-md-1">
                        </div>
                    </div>
                    <div>
                        <center>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                    class="btn btn-success btn-lg "  >INGRESAR</button>
                        </center>
                    </div> 
                </form>             
            </div>
            <%
                }
                if (m == 11) {
            %>          
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Agregar nuevo usuario servidor</h2></div>

                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/usuarioservidor.htm"/>">volver</a>
                </div>
                <form id="forminicio" action="usuarioa.htm" method="Post">
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <label class="control-label">login</label> 
                            <input  name="login" type="text"  id="inputPassword" class="form-control" placeholder="login" required> 
                            <label class="control-label">nombre</label>  
                            <input  name="nombre" type="text"  id="inputPassword" class="form-control" placeholder="nombre usuario" required>  
                            <label class="control-label">tarea</label>  
                            <input  name="tarea" type="text"  id="inputPassword" class="form-control" placeholder="tarea" required>  
                        </div>
                        <div class="col-md-5">
                            <label class="control-label">aministrado</label> 
                            <select name="administrado" class="form-control" required>
                                <option value="">Administracion </option>
                                <option value="1">SI</option> 
                                <option value="0">NO</option>                                                  
                            </select> 
                            <label class="control-label">servidor</label>  
                            <input  name="servid" type="hidden" value="${requestScope.actServ.serServer}"  id="inputPassword" class="form-control" placeholder="tarea" required>
                            <p class="form-control" > ${requestScope.actServ.serSerial}</p>
                        </div>
                    </div>
                        <br/>
                    <div>
                        <center>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                    class="btn btn-success btn-lg "  >INGRESAR</button>
                        </center>
                    </div>                   
                </form>   
            </div>
            <%
                }
                if (m == 12) {
            %>          
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar usuario servidor</h2></div>
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/modiusuario.htm"/>">volver</a>
                </div>
                <form id="forminicio" action="modiusuario.htm" method="Post">
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <label class="control-label">login</label>
                            <input  name="login" type="text" value="${requestScope.usuer.ususLogin}" id="inputPassword" class="form-control" placeholder="login" required> 
                            <label class="control-label">nombre</label>
                            <input  name="nombre" type="text" value="${requestScope.usuer.ususNombre}" id="inputPassword" class="form-control" placeholder="nombre usuario" required> 
                            <label class="control-label">estado</label>
                            <select name="estado" class="form-control" required>
                                <option value="${requestScope.usuer.ususEstado.ususEstado}">${requestScope.usuer.ususEstado.estuEstado}</option>
                                <c:forEach var="f" items="${requestScope.Listausuest}">
                                    <option value="${f.ususEstado}">${f.estuEstado}</option>
                                </c:forEach>
                            </select><br/><br/>
                        </div>
                        <div class="col-md-5">
                            <label class="control-label">aministrado</label>
                            <select name="administrado" class="form-control" required>
                                <option value="${requestScope.usuer.ususAdm}">${requestScope.usuer.ususAdm} </option>
                                <option value="1">SI</option> 
                                <option value="0">NO</option>                                                  
                            </select> 
                            <label class="control-label">servidor</label>
                            <input  name="servid" type="hidden" value="${requestScope.usuer.ususId}"  id="inputPassword" class="form-control" placeholder="tarea" required>
                            <p class="form-control" > ${requestScope.usuer.idSerServidor.serSerial}</p>
                            <label class="control-label">tarea cambio</label>
                            <input  name="tareacambio" type="text" id="inputPassword" class="form-control" placeholder="tarea cambio" required>
                        </div>
                    </div>




                    <div><center>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" 
                                    class="btn btn-success btn-lg "  >INGRESAR</button>
                        </center>
                    </div>                   
                </form>   
            </div>
            <%
                }
                if (m == 13) {
            %>  
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar cronograma</h2></div>
                <!-- Begin # DIV Form -->
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/cronograma.htm"/>">volver</a> 
                </div>     

                <!-- Begin # DIV Form -->
                <div id="div-forms" >

                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="modcrono1.htm" method="Post">

                        <div class="row">
                            <div class="col-md-4">
                                <label class="control-label">tarea cambio</label> 
                                <input   name="tareacambio" type="text" id="inputEmail" class="form-control" placeholder="tarea cambio"  required><br/><br/>
                            </div>
                            <div class="col-md-4"></div>
                            <div class="col-md-4"></div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">

                                <input  name="idcro" type="hidden"  value="${requestScope.crono.croId}" class="form-control" placeholder="fecha fin" required>
                                <label class="control-label">proyecto</label>
                                <select name="proyecto" class="form-control" v>
                                    <option value="${requestScope.crono.croProyecto.proId}">${requestScope.crono.croProyecto.proTitulo}</option>
                                    <c:forEach var="f" items="${requestScope.ListaProyecto}">
                                        <option value="${f.proId}">${f.proTitulo}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">servidor</label>
                                <input  name="servidor" type="hidden" value="${requestScope.crono.croSerial.serServer}" >
                                <p class="form-control" >${requestScope.crono.croSerial.serHostname}</p><br/><br/>

                                <label class="control-label">fecha inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" value="${requestScope.crono.croFechaIni}" class="form-control" placeholder="fecha inicial" required><br/><br/>
                            </div> 
                            <div class="col-md-4">
                                <label class="control-label">fecha proxima</label>
                                <input  name="fprox" type="text" id="Fecha_Prox" value="${requestScope.crono.croFechaProx}" class="form-control" placeholder="fecha proxima" required><br/><br/>
                                <label class="control-label">fecha fin</label>
                                <input  name="ffin" type="text" id="Fecha_Fin" value="${requestScope.crono.croFechaFin}" class="form-control" placeholder="fecha fin" required><br/><br/>
                                <label class="control-label">estado</label>
                                <select name="estini" class="form-control" required>
                                    <option value="${requestScope.crono.croEstado.estmId}">${requestScope.crono.croEstado.estmEstado}</option>
                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                        <option value="${f.estmId}">${f.estmEstado}</option>
                                    </c:forEach>
                                </select><br/><br/>
                            </div> 
                            <div class="col-md-4">
                                <label class="control-label">ejecuta</label>
                                <input   name="ejecuta" type="text" id="inputEmail" value="${requestScope.crono.croEjecuta}" class="form-control" placeholder="ejecuta"  required><br/><br/>
                                <label class="control-label">cambio</label>
                                <textarea   name="cambio" type="text" id="inputEmail" value="${requestScope.crono.croCambioFin}"  class="form-control" placeholder="cambio"  required>${requestScope.crono.croCambioFin}</textarea><br/><br/>
                                <label class="control-label">abservacion</label>
                                <textarea   name="observacion" type="text" id="inputEmail" value="${requestScope.crono.croObservacion}"  class="form-control" placeholder="observacion"  required>${requestScope.crono.croObservacion}</textarea><br/><br/>
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
                if (m == 14) {
            %>  
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>crear cronograma</h2></div>
                <!-- Begin # DIV Form -->
                <div class="box-bottom">
                    <a  role="button" href="<c:url value="/cronograma.htm"/>">volver</a> 
                </div>     

                <!-- Begin # DIV Form -->
                <div id="div-forms" >

                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="crono1.htm" method="Post">
                        <div class="row">
                            <div class="col-md-4">

                                <label class="control-label">proyecto</label>
                                <select name="proyecto" class="form-control" v>
                                    <option value="">proyecto</option>
                                    <c:forEach var="f" items="${requestScope.ListaProyecto}">
                                        <option value="${f.proId}">${f.proTitulo}</option>
                                    </c:forEach>
                                </select><br/><br/>
                                <label class="control-label">servidor</label>
                                <input  name="servidor" type="hidden" value="${requestScope.croServ.serServer}" >
                                <p class="form-control" > ${requestScope.croServ.serHostname}</p><br/><br/>

                                <label class="control-label">fecha inicio</label>
                                <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicial" ><br/><br/>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label">fecha proxima</label>
                                <input  name="fprox" type="text" id="Fecha_Prox" class="form-control" placeholder="fecha proxima" ><br/><br/>
                                <label class="control-label">fecha fin</label>
                                <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha fin" ><br/><br/>
                                <label class="control-label">estado</label>
                                <select name="estini" class="form-control" required>
                                    <option value="">estado inicial</option>
                                    <c:forEach var="f" items="${requestScope.listaEstado}">
                                        <option value="${f.estmId}">${f.estmEstado}</option>
                                    </c:forEach>

                                </select><br/><br/>
                            </div> 
                            <div class="col-md-4">
                                <label class="control-label">ejecuta</label>
                                <input   name="ejecuta" type="text" id="inputEmail" class="form-control" placeholder="ejecuta"  required><br/><br/>
                                <label class="control-label">cambio</label>
                                <textarea   name="cambio" type="text" id="inputEmail" class="form-control" placeholder="cambio"  required></textarea><br/><br/>
                                <label class="control-label">observacion</label>
                                <textarea   name="observacion" type="text" id="inputEmail" class="form-control" placeholder="observacion"  ></textarea><br/><br/>
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
            %>
        </div>
        <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>