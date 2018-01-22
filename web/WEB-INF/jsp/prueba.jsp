<%-- 
    Document   : prueba
    Created on : 9/01/2018, 03:59:22 PM
    Author     : diegfraa
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="modelo.Consultas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>        
        <script src="sps/jsTable/jquery-1.12.4.js" type="text/javascript"></script>
        <script src="sps/vendor/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="dvData">
            <%
                String[] nombreColumnas = new String[26];
                nombreColumnas[0] = "ser_server";
                nombreColumnas[1] = "SER_SERIAL";
                nombreColumnas[2] = "SER_HOSTNAME";
                nombreColumnas[3] = "MAR_ID_MARCA";
                nombreColumnas[4] = "MOD_ID_MODELO";
                nombreColumnas[5] = "SIS_ID_SIS_OPERATIVO";
                nombreColumnas[6] = "SER_CONEXION";
                nombreColumnas[7] = "EST_ID_ESTADO";
                nombreColumnas[8] = "CEN_ID_CENTRAL";
                nombreColumnas[9] = "SAL_ID_SALON";
                nombreColumnas[10] = "SER_RACK";
                nombreColumnas[11] = "SER_UNIDAD";
                nombreColumnas[12] = "GRU_ID_GRUPO";
                nombreColumnas[13] = "CLI_ID_CLIENTE";
                nombreColumnas[14] = "SER_PROYECTO";
                nombreColumnas[15] = "ROL_ID_ROL_SERV";
                nombreColumnas[16] = "PLA_ID_PLATAFORMA";
                nombreColumnas[17] = "SER_F_INGRESO";
                nombreColumnas[18] = "SER_T_INGRESO";
                nombreColumnas[19] = "SER_NO_PROC_FISICO";
                nombreColumnas[20] = "SER_FOR_AD_COMPARTIDA";
                nombreColumnas[21] = "SER_AD_COMPARTIDA";
                nombreColumnas[22] = "SER_ADMINISTRADO";
                nombreColumnas[23] = "SER_CORES";
                nombreColumnas[24] = "SERV_MEM";
                nombreColumnas[25] = "SERV_DISCO_C";
            %>

            <table>
                <tr>
                    <td><input type="button" id="btnExport" value="Descargar a Excel "/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <%
                        for (int i = 0; i < nombreColumnas.length; i++) {
                    %>                   
                    <td><%=nombreColumnas[i]%></td>
                    <%}%>
                </tr>
                <%
                    String FechaI = "2014-03-18";
                    String FechaF = "2017-12-20";
                    String query = "CALL cone('" + FechaI + "','" + FechaF + "')";
                    ResultSet result = Consultas.Resultados(query);

                    while (result.next()) {
                %>
                <tr>
                    <td><%=result.getInt("ser_server")%></td>
                    <td><%=result.getString("SER_SERIAL")%></td>
                    <td><%=result.getString("SER_HOSTNAME")%></td>
                    <td><%=result.getString("MAR_NOM_MARCA")%></td>
                    <td><%=result.getString("MOD_NOM_MODELO")%></td>
                    <td><%=result.getString("SIS_NOMBRE")%></td>
                    <td><%=result.getString("SER_CONEXION")%></td>
                    <td><%=result.getString("EST_ESTADO")%></td>
                    <td><%=result.getString("CEN_NOMBRE")%></td>
                    <td><%=result.getString("SAL_NOMBRE")%></td>
                    <td><%=result.getString("SER_UNIDAD")%></td>
                    <td><%=result.getString("GRU_NOM_GRUPO")%></td>
                    <td><%=result.getString("CLI_NOMBRE")%></td>
                    <td><%=result.getString("SER_PROYECTO")%></td>
                    <td><%=result.getString("ROL_NOM_ROL_SERV")%></td>
                    <td><%=result.getString("PLA_NOM_PLATAFORMA")%></td>
                    <td><%=result.getString("SER_F_INGRESO")%></td>
                    <td><%=result.getString("SER_T_INGRESO")%></td>
                    <td><%=result.getInt("SER_NO_PROC_FISICO")%></td>
                    <td><%=result.getString("SER_FOR_AD_COMPARTIDA")%></td>
                    <td><%=result.getString("SER_AD_COMPARTIDA")%></td>
                    <td><%=result.getString("SER_ADMINISTRADO")%></td>
                    <td><%=result.getString("SER_CORES")%></td>
                    <td><%=result.getInt("SERV_MEM")%></td>
                    <td><%=result.getInt("SERV_DISCO_C")%></td>
                </tr>
                <%                }
                %>            
            </table>
        </div>
        <br/>
        <script>
            $("#btnExport").click(function (e) {
                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData').html() + name));
                e.preventDefault();
            });
        </script>
    </body>
</html>
