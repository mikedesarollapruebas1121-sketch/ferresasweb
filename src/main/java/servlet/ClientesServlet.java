
        package servlet;

import controller.ClientesController;
import model.Clientes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ClientesServlet")
public class ClientesServlet extends HttpServlet {

    private ClientesController controller = new ClientesController();

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

            Clientes cliente = new Clientes();

            cliente.setNombre(request.getParameter("nombre"));
            cliente.setDocumento(request.getParameter("documento"));
            cliente.setTelefono(request.getParameter("telefono"));
            cliente.setDireccion(request.getParameter("direccion"));
            cliente.setCorreo(request.getParameter("correo"));

            controller.agregar(cliente);

        } else if ("editar".equals(accion)) {

            Clientes cliente = new Clientes();

            cliente.setId_cliente(
                    Integer.parseInt(request.getParameter("id_cliente"))
            );

            cliente.setNombre(request.getParameter("nombre"));
            cliente.setDocumento(request.getParameter("documento"));
            cliente.setTelefono(request.getParameter("telefono"));
            cliente.setDireccion(request.getParameter("direccion"));
            cliente.setCorreo(request.getParameter("correo"));

            controller.editar(cliente);
        }

        response.sendRedirect(
                request.getContextPath() + "/ClientesServlet?accion=listar"
        );
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Clientes> listaClientes = controller.mostrar();

        request.setAttribute("listaClientes", listaClientes);

        request.getRequestDispatcher("/clientes/listar.jsp")
                .forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        controller.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/ClientesServlet?accion=listar"
        );
    }

    private void editarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ArrayList<Clientes> listaClientes = controller.mostrar();

        Clientes clienteEncontrado = null;

        for (Clientes cliente : listaClientes) {

            if (cliente.getId_cliente() == id) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {

            request.setAttribute("cliente", clienteEncontrado);

            request.getRequestDispatcher("/clientes/formulario.jsp")
                    .forward(request, response);

        } else {

            response.sendRedirect(
                    request.getContextPath() + "/ClientesServlet?accion=listar"
            );
        }
    }
}
