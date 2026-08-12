package servlet;

import controller.ProductosController;
import model.Productos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ProductosServlet")
public class ProductosServlet extends HttpServlet {

    private ProductosController controller = new ProductosController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "listar":
                listar(request, response);
                break;

            case "eliminar":
                eliminar(request, response);
                break;

            case "editar":
                editarFormulario(request, response);
                break;

            default:
                listar(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("agregar".equals(accion)) {

            Productos producto = new Productos(
                    0,
                    request.getParameter("nombre"),
                    request.getParameter("descripcion"),
                    Double.parseDouble(request.getParameter("precio")),
                    Integer.parseInt(request.getParameter("stock")),
                    Integer.parseInt(request.getParameter("id_categorias"))
            );

            controller.agregar(producto);

        } else if ("editar".equals(accion)) {

            Productos producto = new Productos(
                    Integer.parseInt(request.getParameter("id_producto")),
                    request.getParameter("nombre"),
                    request.getParameter("descripcion"),
                    Double.parseDouble(request.getParameter("precio")),
                    Integer.parseInt(request.getParameter("stock")),
                    Integer.parseInt(request.getParameter("id_categorias"))
            );

            controller.editar(producto);
        }

        response.sendRedirect(
                request.getContextPath() + "/ProductosServlet?accion=listar"
        );
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Productos> listaProductos = controller.mostrar();

        request.setAttribute("listaProductos", listaProductos);

        request.getRequestDispatcher("/productos/listar.jsp")
                .forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        controller.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/ProductosServlet?accion=listar"
        );
    }

    private void editarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ArrayList<Productos> listaProductos = controller.mostrar();

        Productos productoEncontrado = null;

        for (Productos producto : listaProductos) {

            if (producto.getId_producto() == id) {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado != null) {

            request.setAttribute("producto", productoEncontrado);

            request.getRequestDispatcher("/productos/formulario.jsp")
                    .forward(request, response);

        } else {

            response.sendRedirect(
                    request.getContextPath() + "/ProductosServlet?accion=listar"
            );
        }
    }
}
