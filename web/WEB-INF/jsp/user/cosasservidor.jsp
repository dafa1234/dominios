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
                <center>
                    <!-- Begin # DIV Form -->
                    <div id="div-forms" >

                        <!-- Begin # Login Form -->
                        <form id="forminicio" action="aseg.htm"  method="Post">
                            <table>
                                <tr>
                                    <td>
                                        <input   name="servidor" type="hidden" id="inputEmail" class="form-control" value="${requestScope.serv}" placeholder="TAREA" required ><p class="form-control" >${requestScope.serv}</p><br/><br/>
                                    </td>

                                    <td>  <input   name="tarea" type="text" id="inputEmail" class="form-control" placeholder="TAREA" required ><br/><br/></td>
                                </tr><tr>
                                    <td>  <input  name="eje" type="text" id="inputPassword" class="form-control" placeholder="EJECUTA" required><br/><br/></td>

                                    <td>  <input  name="fini" type="text"   id="Fecha_Inicio" class="form-control" placeholder="fecha inicio" required></br><br/></td>
                                </tr><tr>

                                    <td>    <input   name="plantilla" type="file"  size=60 class="form-control" required ><br/><br/></td>
                                    <td>    <input   name="plantillan" type="text" placeholder="escriba la ubicacion del archivo"  class="form-control" required ><br/><br/></td>
                                     
                                </tr>
                            </table>

                            <div>
                                <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                            </div>

                        </form>


                        <!-- End # DIV Form -->

                    </div>
                </center>
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
                        <table>
                            <tr>
                                <td>
                                    <input   name="idasegu" type="hidden" id="inputEmail" class="form-control" value="${requestScope.aseg.aseId}" placeholder="TAREA" required ><p class="form-control" >${requestScope.aseg.aseServidor.serSerial}</p><br/><br/>
                                </td>

                                <td> <p class="form-control" >${requestScope.aseg.aseTarea}</p><br/><br/></td>
                            </tr><tr>
                                <td>  <p class="form-control" >${requestScope.aseg.aseEjecuta}</p><br/><br/></td>

                                <td>  <input  name="fini" type="text"   id="Fecha_Inicio" class="form-control" value="${requestScope.aseg.aseFecha}" placeholder="fecha inicio" required></br><br/></td>
                            </tr><tr>
                                <td>    <input   name="tareacambio" type="text" id="inputEmail" class="form-control" placeholder="tarea cambio" required ><br/><br/></td>
                                <td>    <input   name="plantilla" type="file" id="inputEmail" class="form-control" placeholder="PLANTILLA" required ><p class="form-control" >${requestScope.aseg.asePlantilla}</p><br/><br/></td>
                            </tr>
                        </table>

                        <div>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
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
                                    <input   name="rutaIdser" type="hidden" id="inputEmail"   required value="${requestScope.rutas.rutSerial1.serServer}" >
                                    <p class="form-control" >${requestScope.rutas.rutSerial1.serSerial}</p><br/>
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
                <div class=" panel-heading"><h2>casos proveedor</div>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/caprov.htm"/>">volver</a> 
            </div> 
            <center>
                <!-- Begin # DIV Form -->
                <div id="div-forms" >
                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="caprov.htm" method="Post">                                                                   
                        <select name="proveedor" class="form-control" required>
                            <option value="">proveedor</option>
                            <c:forEach var="f" items="${requestScope.ListaMarca}">
                                <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                            </c:forEach>
                        </select><br/><br/>


                        <input   name="servidor" type="hidden" id="inputEmail"   required value="${requestScope.casosserv}" >
                        <p class="form-control" >${requestScope.casosserv}</p><br/>
                        <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha apertura" required><br/><br/>

                        <input  name="fcie" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha cierre" required><br/><br/>

                        <select name="estini" class="form-control" required>
                            <option value="">estado inicial</option>
                            <c:forEach var="f" items="${requestScope.listaEstado}">
                                <option value="${f.estcId}">${f.estcEstado}</option>
                            </c:forEach>
                        </select><br/><br/>
                        <input   name="numcas" type="text" id="inputEmail" class="form-control" placeholder="numero caso"  required><br/><br/>

                        <input   name="im" type="text" id="inputEmail" class="form-control" placeholder="im" required ><br/><br/>

                        <div>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                        </div>                    
                    </form>
                    <!-- End # DIV Form -->
                </div>
            </center>
            </div>

            <%
                }
                if (m == 8) {
            %>
          <div class="panel panel-primary">
                <div class=" panel-heading"><h2>actividades</div>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/caprov.htm"/>">volverm</a> 
            </div> 
            <center>
                <!-- Begin # DIV Form -->
                <div id="div-forms" >
                    <!-- Begin # Login Form -->
                    <form id="forminicio" action="modificarcasos.htm" method="Post">                                                                   
                        <select name="proveedor" class="form-control" required>
                            <option value="${requestScope.cas.caspProv.marIdMarca}">${requestScope.cas.caspProv.marNomMarca}</option>
                            <c:forEach var="f" items="${requestScope.ListaMarca}">
                                <option value="${f.marIdMarca}">${f.marNomMarca}</option>
                            </c:forEach>
                        </select><br/><br/>


                        <input   name="idcasos" type="hidden" id="inputEmail"   required value="${requestScope.cas.caspId}" >
                        <p class="form-control" >${requestScope.cas.caspServ1.serSerial}</p><br/>
                        <input  name="fini" type="text" id="Fecha_Inicio" value="${requestScope.cas.caspFechaApe}" class="form-control" placeholder="fecha apertura" required><br/><br/>

                        <input  name="fcie" type="text" id="Fecha_Fin" value="${requestScope.cas.caspFechaCie}" class="form-control" placeholder="fecha cierre" required><br/><br/>

                        <select name="estini" class="form-control" required>
                            <option value="${requestScope.cas.caspEstado.estcId}">${requestScope.cas.caspEstado.estcEstado}</option>
                            <c:forEach var="f" items="${requestScope.listaEstado}">
                                <option value="${f.estcId}">${f.estcEstado}</option>
                            </c:forEach>
                        </select><br/><br/>
                        <input   name="numcas" type="text" id="inputEmail" value="${requestScope.cas.caspNumero}" class="form-control" placeholder="numero caso"  required><br/><br/>

                        <input   name="im" type="text" id="inputEmail" value="${requestScope.cas.caspIm}" class="form-control" placeholder="im" required ><br/><br/>
                        <input   name="tareacambio" type="text" id="inputEmail"  class="form-control" placeholder="tarea caMBIO" required ><br/><br/>

                        <div>
                            <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                        </div>                    
                    </form>
                    <!-- End # DIV Form -->
                </div>
            </center>
          </div>
            <%
                }
                if (m == 9) {
            %>
          <div class="panel panel-primary">
                <div class=" panel-heading"><h2>actividades</div>
            <center>
                <!-- Begin # Login Form -->
                <form action="act.htm" method="Post">

                    <table>
                        <tr>

                            <td>                              
                                <select name="tipo" class="form-control" required>
                                    <option value="">tipo</option>
                                    <c:forEach var="f" items="${requestScope.Listatipoactiv}">
                                        <option value="${f.tipaId}">${f.tipaNombre}</option>
                                    </c:forEach>
                                </select><br/><br/>
                            </td>
                            <td>   
                                <input   name="serv" type="hidden" id="inputEmail"   required value="${requestScope.serv.serServer}" >
                                <p class="form-control" >${requestScope.serv.serHostname}</p><br/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input  name="eje" type="text" id="inputPassword" class="form-control" placeholder="ejecuta" required><br/><br/>
                            </td>

                            <td>    
                                <input  name="fini" type="text" id="Fecha_Inicio" class="form-control" placeholder="fecha inicio" required><br/><br/>
                            </td>
                        </tr>
                        <tr>
                            <td>       
                                <input   name="tarea" type="text" id="inputEmail" class="form-control" placeholder="tarea" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                            </td>

                            <td>     <textarea  name="desc" type="text" id="inputPassword" class="form-control" placeholder="descripcion" required></textarea><br/><br/></td>
                        </tr>
                        <tr>
                            <td>     <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" placeholder="fecha fin" required><br/><br/></td>

                            <td>      <input   name="sol" type="text" id="inputEmail" class="form-control" placeholder="solicita" required autofocus class="nav nav-pills nav-stacked"><br/><br/></td>
                        </tr>                             
                    </table>


                    <div>
                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                    </div>


                </form>
            </center>
          </div>
            <%
                }
                if (m == 10) {
            %>
           <div class="panel panel-primary">
                <div class=" panel-heading"><h2>actividades</div>
            <center>
                modoificar actividad
                <!-- Begin # Login Form -->
                <form action="modact.htm" method="Post">

                    <table>
                        <tr>

                            <td>                              
                                <select name="tipo" class="form-control" required>
                                    <option value="${requestScope.acti.actTipo.tipaId}">${requestScope.acti.actTipo.tipaNombre}</option>
                                    <c:forEach var="f" items="${requestScope.Listatipoactiv}">
                                        <option value="${f.tipaId}">${f.tipaNombre}</option>
                                    </c:forEach>
                                </select><br/><br/>
                            </td>
                            <td>   
                                <input   name="serv" type="hidden" id="inputEmail"   required value="${requestScope.acti.actId}" >
                                <p class="form-control" >${requestScope.acti.actServ1.serHostname}</p><br/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input  name="eje" type="text" id="inputPassword" value="${requestScope.acti.actEjecuta}" class="form-control" placeholder="ejecuta" required><br/><br/>
                            </td>

                            <td>    
                                <input  name="fini" type="text" id="Fecha_Inicio" value="${requestScope.acti.actFechaIni}" class="form-control" placeholder="fecha inicio" required><br/><br/>
                            </td>
                        </tr>
                        <tr>
                            <td>       
                                <input   name="tarea" type="text" id="inputEmail" value="${requestScope.acti.actTarea}" class="form-control" placeholder="tarea" required autofocus class="nav nav-pills nav-stacked"><br/><br/>
                            </td>

                            <td>     <textarea  name="desc" type="text" id="inputPassword" value="${requestScope.acti.actDescripcion}" class="form-control" placeholder="descripcion" required>${requestScope.acti.actDescripcion}</textarea><br/><br/></td>
                        </tr>
                        <tr>
                            <td>     <input  name="ffin" type="text" id="Fecha_Fin" class="form-control" value="${requestScope.acti.actFechaFin}" placeholder="fecha fin" required><br/><br/></td>

                            <td>      <input   name="sol" type="text" id="inputEmail" class="form-control" value="${requestScope.acti.actSolicita}" placeholder="solicita" required autofocus class="nav nav-pills nav-stacked"><br/><br/></td>
                            <td>      <input   name="tareacambio" type="text" id="inputEmail" class="form-control"  placeholder="tarea cambio" required autofocus class="nav nav-pills nav-stacked"><br/><br/></td>

                        </tr>                             
                    </table>


                    <div>
                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">INGRESAR</button>
                    </div>


                </form>
            </center>
           </div>
            <%
                }
                if (m == 11) {
            %>          
<div class="panel panel-primary">
                <div class=" panel-heading"><h2>actividades</div>
            <h2>Agregar nuevo usuario servidor</h2>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/usuarioservidor.htm"/>">volver</a>
            </div>
            <form id="forminicio" action="modiusuario.htm" method="Post">
                <table class="table table-bordered" id="ataTable" width="100%" cellspacing="0">            
                    <tr>                           
                        <th>login</th>
                        <th>nombre</th>
                        <th>tarea</th>
                        <th>aministrado</th> 
                        <th>servidor</th>                 
                    </tr>
                    <tr>
                        <td> <input  name="login" type="text"  id="inputPassword" class="form-control" placeholder="login" required>  </td>
                        <td> <input  name="nombre" type="text"  id="inputPassword" class="form-control" placeholder="nombre usuario" required>  </td>
                        <td> <input  name="tarea" type="text"  id="inputPassword" class="form-control" placeholder="tarea" required>  </td>   
                        <td> <select name="administrado" class="form-control" required>
                                <option value="">Administracion </option>
                                <option value="1">SI</option> 
                                <option value="0">NO</option>                                                  
                            </select>  </td> 
                        <td>   <input  name="servid" type="hidden" value="${requestScope.actServ.serServer}"  id="inputPassword" class="form-control" placeholder="tarea" required>

                            <p class="form-control" > ${requestScope.actServ.serSerial}</p>
                        </td>                            
                    </tr>
                </table>                     
                <div>
                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">ingresar</button>
                </div>                    
            </form>   
</div>
            <%
                }
                if (m == 12) {
            %>          
<div class="panel panel-primary">
                <div class=" panel-heading"><h2>modificar nuevo usuario servidor</h2></div>
            <div class="box-bottom">
                <a  role="button" href="<c:url value="/modiusuario.htm"/>">volver</a>
            </div>
            <form id="forminicio" action="modiusuario.htm" method="Post">
                <table class="table table-bordered" id="ataTable" width="100%" cellspacing="0">            
                    <tr>                           
                        <th>login</th>
                        <th>nombre</th>
                        <th>estado</th>
                        <th>aministrado</th> 
                        <th>servidor</th>  
                        <th>tarea cambio</th>
                    </tr>
                    <tr>
                        <td> <input  name="login" type="text" value="${requestScope.usuer.ususLogin}" id="inputPassword" class="form-control" placeholder="login" required>  </td>
                        <td> <input  name="nombre" type="text" value="${requestScope.usuer.ususNombre}" id="inputPassword" class="form-control" placeholder="nombre usuario" required>  </td>
                        <td> 
                          <select name="estado" class="form-control" required>
                                    <option value="${requestScope.usuer.ususEstado.ususEstado}">${requestScope.usuer.ususEstado.estuEstado}</option>
                                    <c:forEach var="f" items="${requestScope.Listausuest}">
                                        <option value="${f.ususEstado}">${f.estuEstado}</option>
                                    </c:forEach>
                                </select><br/><br/>
                        </td>   
                        <td> <select name="administrado" class="form-control" required>
                                <option value="${requestScope.usuer.ususAdm}">${requestScope.usuer.ususAdm} </option>
                                <option value="1">SI</option> 
                                <option value="0">NO</option>                                                  
                            </select>  </td> 
                        <td>   <input  name="servid" type="hidden" value="${requestScope.usuer.ususId}"  id="inputPassword" class="form-control" placeholder="tarea" required>

                            <p class="form-control" > ${requestScope.usuer.idSerServidor.serSerial}</p>
                        </td>   
                         <td> <input  name="tareacambio" type="text" id="inputPassword" class="form-control" placeholder="tarea cambio" required>  </td>
                    </tr>
                </table>                     
                <div>
                    <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" style="color: red">ingresar</button>
                </div>                    
            </form>   
</div>
            <%
                }
            %>  

        </div>
        <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>