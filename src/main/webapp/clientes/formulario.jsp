<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Clientes" %>

<%
    Clientes cliente = (Clientes) request.getAttribute("cliente");

    boolean editar = cliente != null;
%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>
        <%= editar ? "Editar Cliente" : "Agregar Cliente" %>
    </title>
</head>

<body>

<h1>
    <%= editar ? "Editar Cliente" : "Agregar Cliente" %>
</h1>

<form action="<%= request.getContextPath() %>/ClientesServlet"
      method="post">

    <input type="hidden"
           name="accion"
           value="<%= editar ? "editar" : "agregar" %>">

    <% if (editar) { %>

        <input type="hidden"
               name="id_cliente"
               value="<%= cliente.getId_cliente() %>">

    <% } %>


    <label>Nombre:</label><br>

    <input type="text"
           name="nombre"
           value="<%= editar ? cliente.getNombre() : "" %>"
           required>

    <br><br>


    <label>Documento:</label><br>

    <input type="text"
           name="documento"
           value="<%= editar ? cliente.getDocumento() : "" %>"
           required>

    <br><br>


    <label>Teléfono:</label><br>

    <input type="text"
           name="telefono"
           value="<%= editar ? cliente.getTelefono() : "" %>"
           required>

    <br><br>


    <label>Dirección:</label><br>

    <input type="text"
           name="direccion"
           value="<%= editar ? cliente.getDireccion() : "" %>"
           required>

    <br><br>


    <label>Correo:</label><br>

    <input type="email"
           name="correo"
           value="<%= editar ? cliente.getCorreo() : "" %>"
           required>

    <br><br>


    <button type="submit">
        <%= editar ? "Guardar Cambios" : "Guardar Cliente" %>
    </button>

</form>

<br>

<a href="<%= request.getContextPath() %>/ClientesServlet?accion=listar">
    Volver a Clientes
</a>

</body>

</html>