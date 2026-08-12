<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Productos" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
</head>

<body>

<h1>Productos</h1>

<a href="<%= request.getContextPath() %>/productos/formulario.jsp">
    Agregar Producto
</a>

<br><br>

<table border="1" cellpadding="8">

    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Descripción</th>
        <th>Precio</th>
        <th>Stock</th>
        <th>ID Categoría</th>
        <th>Acciones</th>
    </tr>

<%
    ArrayList<Productos> listaProductos =
            (ArrayList<Productos>) request.getAttribute("listaProductos");

    if (listaProductos != null && !listaProductos.isEmpty()) {

        for (Productos producto : listaProductos) {
%>

    <tr>

        <td>
            <%= producto.getId_producto() %>
        </td>

        <td>
            <%= producto.getNombre() %>
        </td>

        <td>
            <%= producto.getDescripcion() %>
        </td>

        <td>
            <%= producto.getPrecio() %>
        </td>

        <td>
            <%= producto.getStock() %>
        </td>

        <td>
            <%= producto.getId_categorias() %>
        </td>

        <td>

            <a href="<%= request.getContextPath() %>/ProductosServlet?accion=editar&id=<%= producto.getId_producto() %>">
                Editar
            </a>

            |

            <a href="<%= request.getContextPath() %>/ProductosServlet?accion=eliminar&id=<%= producto.getId_producto() %>"
               onclick="return confirm('¿Desea eliminar este producto?');">
                Eliminar
            </a>

        </td>

    </tr>

<%
        }

    } else {
%>

    <tr>
        <td colspan="7">
            No hay productos registrados.
        </td>
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

