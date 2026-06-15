package service;

import model.Gasto;

import java.util.ArrayList;
import java.util.List;

/*
 * Servicio encargado de gestionar los gastos.
 * Aquí se almacena la información y se ejecutan
 * las operaciones de negocio.
 */
public class GastoService {

    /*
     * Lista en memoria donde se almacenan los gastos.
     * Para esta evidencia no utilizaremos base de datos.
     */
    private static final List<Gasto> gastos = new ArrayList<>();

    /*
     * Variable para generar identificadores automáticos.
     */
    private static int contadorId = 1;

    /*
     * Registra un nuevo gasto en la lista.
     */
    public void registrarGasto(
            String descripcion,
            String categoria,
            double monto) {

        Gasto gasto = new Gasto(
                contadorId++,
                descripcion,
                categoria,
                monto
        );

        gastos.add(gasto);
    }

    /*
     * Retorna todos los gastos registrados.
     */
    public List<Gasto> obtenerGastos() {
        return gastos;
    }

    /*
     * Retorna la cantidad de gastos registrados.
     */
    public int totalGastos() {
        return gastos.size();
    }
}