<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Ferresas Web</title>
</head>

<body>

    <h1>FERRESAS</h1>

    <h2>Sistema de gestión</h2>

    <p>Aplicación web funcionando correctamente.</p>

    <br>

    <a href="<%= request.getContextPath() %>/ClientesServlet?accion=listar">
        Gestionar Clientes
    </a>

    <br><br>

    <a href="<%= request.getContextPath() %>/ProductosServlet?accion=listar">
        Gestionar Productos
    </a>

</body>

</html>
