package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Gasto;
import service.GastoService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*
 * Servlet encargado de mostrar los gastos registrados.
 * Atiende solicitudes GET.
 */
@WebServlet("/listar-gastos")
public class ListarGastosServlet extends HttpServlet {

    /*
     * Servicio que contiene los gastos registrados.
     */
    private final GastoService gastoService =
            new GastoService();

    /*
     * Método GET.
     * Se ejecuta cuando el usuario consulta la lista.
     */
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Configurar respuesta HTML
        response.setContentType("text/html;charset=UTF-8");

        // Obtener todos los gastos
        List<Gasto> gastos =
                gastoService.obtenerGastos();

        PrintWriter out =
                response.getWriter();

        out.println("<html>");

out.println("<head>");

out.println("<title>Lista de Gastos</title>");

out.println(
        "<link rel='stylesheet' href='css/style.css'>"
);

out.println("</head>");

out.println("<body>");

out.println(
        "<div class='header'>" +
        "<h1>Finanzas Web</h1>" +
        "</div>"
);

out.println("<div class='container'>");

out.println("<h2>Gastos Registrados</h2>");

        out.println("<table>");

        out.println(
                "<tr>" +
                "<th>ID</th>" +
                "<th>Descripción</th>" +
                "<th>Categoría</th>" +
                "<th>Monto</th>" +
                "</tr>"
        );

        for (Gasto gasto : gastos) {

    // Formatear el monto con separador de miles
    String montoFormateado =
            String.format("$%,.0f", gasto.getMonto());

    out.println(
            "<tr>" +
            "<td>" + gasto.getId() + "</td>" +
            "<td>" + gasto.getDescripcion() + "</td>" +
            "<td>" + gasto.getCategoria() + "</td>" +
            "<td>" + montoFormateado + " COP</td>" +
            "</tr>"
    );
}

        out.println("</table>");

        out.println("<br>");

        out.println(
                "<a href='registrar-gasto.html'>Registrar nuevo gasto</a>"
        );

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}