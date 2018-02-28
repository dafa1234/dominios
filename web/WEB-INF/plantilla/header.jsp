<%-- 
    Document   : header
    Created on : 28/09/2017, 02:59:30 PM
    Author     : diegfraa
--%>

<%
    Integer id = (Integer) request.getSession().getAttribute("ID");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-info fixed-top" id="mainNav">


    <a class="navbar-brand" href="https://etb.com/"><img src="sps/fonts/ETB_BLUE_NEG1.png" alt=""/></a>

    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav bg-info" id="exampleAccordion">
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Inicio">      
                <%
                    if (id == 1) {   %>
                <a class="nav-link" href="<c:url value="/fono.htm"/>">
                    <%} else {%>
                    <a class="nav-link" href="<c:url value="/buscar.htm"/>">
                        <%}%>
                        <i class="fa fa-fw fa-dashboard"></i>
                        <span class="nav-link-text">Inicio</span>
                    </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="nuevos objetos">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponent" data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-area-chart"></i>
                    <span class="nav-link-text">nuevos objetos</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseComponent">          
                    <li><a href="<c:url value="/ncentral.htm"/>">Agregar Central</a></li>
                    <li><a href="<c:url value="/ngrupo.htm"/>">Agregar Grupo</a></li>
                    <li><a href="<c:url value="/nmarca.htm"/>">Agregar Marca</a></li>        
                    <li><a href="<c:url value="/nplataforma.htm"/>">Agregar Plataforma</a></li>                     
                    <li><a href="<c:url value="/nrolserv.htm"/>">Agregar Rol Servidor</a></li>
                    <li><a href="<c:url value="/nsisopera.htm"/>">Agregar Sistema Operativo</a></li>
                    <li><a href="<c:url value="/nestado.htm"/>">Agregar Estado</a></li>
                    <li><a href="<c:url value="/nsalon.htm"/>">Agregar Salon</a></li>
                    <li><a href="<c:url value="/nmodelo.htm"/>">Agregar Modelo</a></li>
                    <li><a href="<c:url value="/ncliente.htm"/>">Agregar Cliemte</a></li>
                    <li><a href="<c:url value="/nadminiplataforma.htm"/>">Agregar administrador plataforma</a></li>
                </ul>
            </li>
            <%
                // <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                //<a class="nav-link" href="#">
                //  <i class="fa fa-fw fa-table"></i>
                //<span class="nav-link-text">Tables</span>
                //</a>
                // </li>
            %>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Actividades Operativas">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-wrench"></i>
                    <span class="nav-link-text">Actividades Operativas</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseComponents">

                    <li><a href="<c:url value="/servers.htm"/>">Inventario</a></li>
                    <li><a href="<c:url value="/actividades.htm"/>">Actividades</a></li>

                    <li><a href="<c:url value="/casosproveedor.htm"/>">Casos Proveedor</a></li>                     
                    <li><a href="<c:url value="/usuarioservidor.htm"/>">Usuarios</a></li>

                    <%
                        //<li><a href="<c:url value="/pruebas.htm"/>">pruebas</a></li> 
                        //<li><a href="<c:url value="/prueb.htm"/>">Casfd</a></li>
                        if (id == 1) {   %>
                    <li><a href="<c:url value="/modificarusuario.htm"/>">Crear Usuario</a></li>
                        <%}%>
                </ul>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title=" Gestion">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-file"></i>
                    <span class="nav-link-text">Gestion</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseExamplePages">

                    <li><a href="<c:url value="/cronograma.htm"/>">Cronograma MTO</a></li> 
                    <li><a href="<c:url value="/contratos.htm"/>">Contratos Soporte</a></li>

                </ul>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="usuarios">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-sitemap"></i>
                    <span class="nav-link-text">usuario</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseMulti">
                    <li>
                        <p>nombre usuario: ${name}</p>
                    </li>
                    <li>
                        <p>apellido usuario: ${apell}</p>
                    </li>

                    <li>
                        <p>correo db: ${correo}</p>
                    </li>

                    <li>
                        <p>usuario registrado: ${usuario}</p>
                    </li>
                    <li>
                        <p>usuario db etb: ${Correo_recibido}</p>
                    </li>
                    <li>
                        <p>numero: ${ID}</p>
                    </li>
                    <li>
                        <p>fecha: ${fecha}</p>
                    </li>
                </ul>
            </li>        
        </ul>
        <ul class="navbar-nav sidenav-toggler">
            <li class="nav-item">
                <a class="nav-link text-center bg-info" id="sidenavToggler">
                    <i class="fa fa-fw fa-angle-left"></i>
                </a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-fw fa-envelope"></i>
                    <span class="d-lg-none">Messages
                        <span class="badge badge-pill badge-primary">12 New</span>
                    </span>
                    <span class="indicator text-primary d-none d-lg-block">
                        <i class="fa fa-fw fa-circle"></i>
                    </span>
                </a>
                <div class="dropdown-menu" aria-labelledby="messagesDropdown">
                    <h6 class="dropdown-header">New Messages:</h6>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        <strong>David Miller</strong>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        <strong>Jane Smith</strong>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        <strong>John Doe</strong>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item small" href="#">View all messages</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-fw fa-bell"></i>
                    <span class="d-lg-none">Alerts
                        <span class="badge badge-pill badge-warning">6 New</span>
                    </span>
                    <span class="indicator text-warning d-none d-lg-block">
                        <i class="fa fa-fw fa-circle"></i>
                    </span>
                </a>
                <div class="dropdown-menu" aria-labelledby="alertsDropdown">
                    <h6 class="dropdown-header">New Alerts:</h6>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        <span class="text-success">
                            <strong>
                                <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
                        </span>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        <span class="text-danger">
                            <strong>
                                <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
                        </span>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        <span class="text-success">
                            <strong>
                                <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
                        </span>
                        <span class="small float-right text-muted">11:21 AM</span>
                        <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item small" href="#">View all alerts</a>
                </div>
            </li>

            <li class="nav-item">
                <a  href="<c:url value="/cerrar.htm"/>" class="nav-link"  data-target="#exampleModal">
                    <i class="fa fa-fw fa-sign-out"></i>cerrar secion</a>

            </li>
        </ul>


    </div>
</nav>


<script src="<c:url value="/sps/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/sps/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="/sps/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
<script src="<c:url value="/sps/vendor/chart.js/Chart.min.js"/>"></script>
<script src="<c:url value="/sps/vendor/datatables/jquery.dataTables.js"/>"></script>
<script src="<c:url value="/sps/js/sb-admin.min.js"/>"></script>
<script src="<c:url value="/sps/vendor/datatables/dataTables.bootstrap4.js"/>"></script>
<script src="<c:url value="/sps/js/sb-admin-datatables.min.js"/>"></script>
<script src="<c:url value="/sps/js/sb-admin-charts.min.js"/>"></script>
<script src="<c:url value="/sps/js/legacy.js"/>"></script>
<script src="<c:url value="/sps/js/picker.js"/>"></script>
<script src="<c:url value="/sps/js/picker.date.js"/>"></script>




<script>
    $(document).ready(function () {
        $('#Fecha_Inicio').pickadate({
            format: 'yyyy-mm-dd',
            formatSubmit: 'yyyy-mm-dd',
            hiddenName: true
        });
    });
</script>
<script>
    $(document).ready(function () {
        $('#Fecha_Fin').pickadate({
            format: 'yyyy-mm-dd',
            formatSubmit: 'yyyy-mm-dd',
            hiddenName: true
        });
    });
</script>
<script>
    $(document).ready(function () {
        $('#Fecha_Prox').pickadate({
            format: 'yyyy-mm-dd',
            formatSubmit: 'yyyy-mm-dd',
            hiddenName: true
        });
    });
</script>
