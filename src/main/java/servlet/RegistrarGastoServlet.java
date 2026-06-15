package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import service.GastoService;

import java.io.IOException;

/*
 * Servlet encargado de registrar gastos.
 * Atiende solicitudes HTTP enviadas desde
 * el formulario HTML.
 */
@WebServlet("/registrar-gasto")
public class RegistrarGastoServlet extends HttpServlet {

    /*
     * Servicio que contiene la lógica de negocio.
     */
    private final GastoService gastoService =
            new GastoService();

    /*
     * Método POST.
     * Se ejecuta cuando el usuario envía el formulario.
     */
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener descripción enviada desde HTML
        String descripcion =
                request.getParameter("descripcion");

        // Obtener categoría enviada desde HTML
        String categoria =
                request.getParameter("categoria");

        // Obtener monto enviado desde HTML
        double monto =
                Double.parseDouble(
                        request.getParameter("monto"));

        // Registrar gasto usando la lógica de negocio
        gastoService.registrarGasto(
                descripcion,
                categoria,
                monto);

        // Redirigir al listado de gastos
        response.sendRedirect(
                "listar-gastos");
    }
}