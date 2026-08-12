<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Clientes" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
</head>

<body>

<h1>Clientes</h1>

<a href="<%= request.getContextPath() %>/clientes/formulario.jsp">
    Agregar Cliente
</a>

<br><br>

<table border="1" cellpadding="8">

    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Documento</th>
        <th>Teléfono</th>
        <th>Dirección</th>
        <th>Correo</th>
        <th>Acciones</th>
    </tr>

<%
    ArrayList<Clientes> listaClientes =
            (ArrayList<Clientes>) request.getAttribute("listaClientes");

    if (listaClientes != null && !listaClientes.isEmpty()) {

        for (Clientes cliente : listaClientes) {
%>

    <tr>
        <td><%= cliente.getId_cliente() %></td>
        <td><%= cliente.getNombre() %></td>
        <td><%= cliente.getDocumento() %></td>
        <td><%= cliente.getTelefono() %></td>
        <td><%= cliente.getDireccion() %></td>
        <td><%= cliente.getCorreo() %></td>

        <td>
            <a href="<%= request.getContextPath() %>/ClientesServlet?accion=editar&id=<%= cliente.getId_cliente() %>">
                Editar
            </a>
            |
            <a href="<%= request.getContextPath() %>/ClientesServlet?accion=eliminar&id=<%= cliente.getId_cliente() %>"
               onclick="return confirm('¿Desea eliminar este cliente?');">
                Eliminar
            </a>
        </td>
    </tr>

<%
        }

    } else {
%>

    <tr>
        <td colspan="7">No hay clientes registrados.</td>
    </tr>

<%
    }
%>

</table>

<br>

<a href="<%= request.getContextPath() %>/">
    Volver al inicio
</a>

</body>
</html>