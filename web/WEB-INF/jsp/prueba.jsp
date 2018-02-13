<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/plantilla/head.jsp" %>
    <body>
        <%@include file="/WEB-INF/plantilla/header.jsp" %>
        <br/><br/>        

        <div class="container">


            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Información de la solicitud</h2></div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-6">

                            <label class="control-label">Dependencia</label>
                            <select class="form-control" name="dependencia">
                                <option>Vicepresidencia
                                    Comercial y
                                    Movilidad
                                </option>
                                <option>Vicepresidencia
                                    de Empresas y
                                    Gobierno
                                </option>
                                <option>Vicepresidencia
                                    Experiencia al
                                    Cliente (e)
                                </option>
                                <option>Vicepresidencia
                                    Infraestructura (e)
                                </option>
                                <option>Vicepresidencia de
                                    Capital Humano y
                                    Cadena de
                                    Abastecimiento
                                </option>
                                <option>Vicepresidencia de
                                    Capital Humano y
                                    Cadena de
                                    Abastecimiento
                                </option>
                                <option>Vicepresidencia
                                    Informática 
                                </option>
                            </select>
                            <label class="control-label">Área</label>
                            <input type="text" class="form-control" placeholder="Area que Solicita" name="Area" pattern="[a-zA-Z\s]+"  title="No se permite otro caracter distinto a texto" required >
                            <label class="control-label">Salón</label>
                            <!--input type="text" class="form-control" placeholder="Salon" name="Salon"  title="Ajústese al formato solicitado" required/-->
                            <select class="form-control" name="Salon">
                                <option value="Central">Central</option>
                            </select>
                            <label class="control-label">Soporte</label>
                            <input type="text" class="form-control" placeholder="Soporte Service Manager" name="Soporte" title="Ajústese al formato solicitado" required/>
                            <label class="control-label">Fecha y hora inicio</label>
                            <input type="text" name="Fecha_Inicio" id="Fecha_Inicio" class="form-control" required=""/>
                            <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
                                <input type="text" class="form-control" value="08:00" name="Hora_Inicio" required="">
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-time alert-info"></span>
                                </span>
                            </div>
                            <label class="control-label">Fecha y hora fin</label>
                            <input type="text" name="Fecha_Fin" id="Fecha_Fin" class="form-control" required=""/>
                            <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
                                <input type="text" class="form-control" value="17:00" name="Hora_Fin" required=""/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-time alert-info"></span>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label class="control-label">Observación</label>
                            <input type="text" class="form-control"  placeholder="Observacion Corta" name="Observacion"/>
                            <label class="control-label">Nombre actividad</label>
                            <input type="text" class="form-control" placeholder="Nombre de la Actividad " name="Nombre_Actividad"/>
                            <label class="control-label">Descripción solicitud</label>
                            <textarea class="form-control" name="Solicitud">Cordial Saludo:
Atentamente:</textarea>
                            <label class="control-label">Dependencia autorizadora</label>
                            <textarea  class="form-control" placeholder="Dependencias Autorizadas " name="Centrales_Autorizadas" required=""></textarea>
                            <label>Centrales</label>

                        </div>
                    </div>

                </div>
            </div>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>servidor</h2></div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-4">
                            <label class="control-label">ID :</label>
                            <p class="form-control">${requestScope.idser}</p>

                            <label class="control-label">SERIAL :</label>
                            <p class="form-control">${requestScope.serial}</p>
                            
                            <label class="control-label">HONTNAME :</label>
                            <p class="form-control">${requestScope.hostname}</p>
                            
                            <label class="control-label">MARCA :</label>
                            <p class="form-control">${requestScope.marca}</p>
                            
                            <label class="control-label">MODELO :</label>
                            <p class="form-control">${requestScope.modelo}</p>
                            
                            <label class="control-label">SISTEMA OPERATIVO :</label>
                            <p class="form-control">${requestScope.sisoperativo}</p>
                            
                            <label class="control-label">CONEXION :</label>
                            <p class="form-control">${requestScope.conexion}</p>
                            
                            <label class="control-label">ESTADO :</label>
                            <p class="form-control">${requestScope.estado}</p>
                            
                            <label class="control-label">CENTRAL :</label>
                            <p class="form-control">${requestScope.central}</p>

                        </div>
                        <div class="col-md-4">
                            
                            
                            <label class="control-label">SALON :</label>

                            <p class="form-control">${requestScope.salon}</p>
                            
                            <label class="control-label">RACK :</label>
                            <p class="form-control">${requestScope.rack}</p>
                            
                            <label class="control-label">UNIDAD :</label>
                            <p class="form-control">${requestScope.unidad}</p>
                            
                            <label class="control-label">GRUPO :</label>

                            <p class="form-control">${requestScope.grupo}</p>
                            
                            <label class="control-label">CLIENTE :</label>
                            <p class="form-control">${requestScope.cliente}</p>
                            
                            <label class="control-label">PROYECTO :</label>
                            <p class="form-control">${requestScope.proyecto}</p>
                            
                            <label class="control-label">ROL SERVIDOR :</label>
                             <p class="form-control">${requestScope.rolserv}</p>
                            
                            <label class="control-label">PLATAFORMA :</label>
                            <p class="form-control">${requestScope.plataforma}</p>
                            
                            <label class="control-label">FECHA INGRESO :</label>
                            <p class="form-control">${requestScope.fingreso}</p>
                            
                        </div>
                        <div class="col-md-4">
                           
                            <label class="control-label">TAREA INGRESO :</label>

                            <p class="form-control">${requestScope.tingreso}</p>
                            
                            <label class="control-label">No PROCESOS FISICOS :</label>
                            <p class="form-control">${requestScope.npfisicos}</p>
                            
                            <label class="control-label">FORMATO AD COMPARTIDA :</label>
                            <p class="form-control">${requestScope.foradcompartida}</p>
                            
                            <label class="control-label">ADMINISTRACION COMPARTIDA :</label>

                            <p class="form-control">${requestScope.adcompartida}</p>
                            
                            <label class="control-label">ADMINISTRADO :</label>
                            <p class="form-control">${requestScope.administrada}</p>
                            
                            <label class="control-label">CORES :</label>
                            <p class="form-control">${requestScope.cores}</p>
                            
                            <label class="control-label">MEM :</label>

                            <p class="form-control">${requestScope.mem}</p>
                            
                            <label class="control-label">DISCOC :</label>
                            <p class="form-control">${requestScope.diecoC}</p>
                            

                        </div>
                    </div>
                </div>

            </div>
            <div class="panel panel-primary">
                <div class=" panel-heading"><h2>Agregar Inventario</h2></div>
                <div class="panel-body">
                    <form  action="creat.htm" method="Post">   
                        <div class="row">
                            <div class="col-md-4">


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
                                <label class="control-label">GRUPO</label>
                                <select name="grupo" class="form-control" required>
                                    <option value="">Grupo</option>
                                    <c:forEach var="f" items="${requestScope.listaGrupo}">
                                        <option value="${f.gruIdGrupo}">${f.gruNomGrupo}</option>
                                    </c:forEach>
                                </select><br/>
                                <label class="control-label">PROCESADORES</label>
                                <input  name="prosesos" type="text" id="inputPassword" class="form-control" placeholder="Numero de Prosesos Fisicos" required><br/>
                            </div>
                            <div class="col-md-4">
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
                            </div><div class="col-md-4">
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
                                <label class="control-label">FORAFS</label>
                                <select name="addominios" class="form-control" required>
                                    <option value="1">Formato Administracion Compartida</option>
                                    <option value="1">SI</option> 
                                    <option value="0">NO</option>                                                  
                                </select><br/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4"></div>
                            <div class="col-md-4">
                                <div><center>
                                        <button id="btniniciar" type="submit"  data-toggle="tooltip" data-placement="top" title="Presione para ingresar" class="box-bottom_blue" >INGRESAR</button>
                                    </center>
                                </div>
                            </div>
                            <div class="col-md-4"></div>
                        </div>

                    </form>
                </div>

            </div>
            <div class=" panel-primary">
                <div class="panel panel-heading"><h2>Información de las personas</h2></div>
                <div class="panel-body">
                    <div class="col-md-12">
                        <h3>Seleccione el número de personas a registrar.</h3>
                        <div class="input-group" >
                            <select class="form-control" id="cantidad"  name="cantidad" required="">
                                <option value="" selected>Seleccione la cantidad</option>
                                <%                                        for (int i = 1; i < 71; i++) {
                                %>
                                <option value="<%=i%>"><%=i%></option>
                                <%
                                    }
                                %>
                            </select>                                
                        </div>
                    </div>
                    <div id="presentarPersonas"></div>
                    <div class="col-md-12">
                        <br>                                
                        <button type="submit" class="btn btn-success btn-lg col-md-12" >Registrar Solicitud</button>
                    </div>

                </div>

            </div>        
        </div>







        <%@include file="/WEB-INF/plantilla/foter.jsp" %>
    </body>
</html>
