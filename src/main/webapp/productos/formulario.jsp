<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Productos" %>

<%
    Productos producto = (Productos) request.getAttribute("producto");

    boolean editar = producto != null;
%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">

    <title>
        <%= editar ? "Editar Producto" : "Agregar Producto" %>
    </title>
</head>

<body>

<h1>
    <%= editar ? "Editar Producto" : "Agregar Producto" %>
</h1>

<form action="<%= request.getContextPath() %>/ProductosServlet"
      method="post">

    <input type="hidden"
           name="accion"
           value="<%= editar ? "editar" : "agregar" %>">

    <% if (editar) { %>

        <input type="hidden"
               name="id_producto"
               value="<%= producto.getId_producto() %>">

    <% } %>


    <label>Nombre:</label><br>

    <input type="text"
           name="nombre"
           value="<%= editar ? producto.getNombre() : "" %>"
           required>

    <br><br>


    <label>Descripción:</label><br>

    <input type="text"
           name="descripcion"
           value="<%= editar ? producto.getDescripcion() : "" %>"
           required>

    <br><br>


    <label>Precio:</label><br>

    <input type="number"
           name="precio"
           step="0.01"
           min="0"
           value="<%= editar ? producto.getPrecio() : "" %>"
           required>

    <br><br>


    <label>Stock:</label><br>

    <input type="number"
           name="stock"
           min="0"
           value="<%= editar ? producto.getStock() : "" %>"
           required>

    <br><br>


    <label>ID Categoría:</label><br>

    <input type="number"
           name="id_categorias"
           min="1"
           value="<%= editar ? producto.getId_categorias() : "" %>"
           required>

    <br><br>


    <button type="submit">
        <%= editar ? "Guardar Cambios" : "Guardar Producto" %>
    </button>

</form>

<br>

<a href="<%= request.getContextPath() %>/ProductosServlet?accion=listar">
    Volver a Productos
</a>

</body>

</html>

