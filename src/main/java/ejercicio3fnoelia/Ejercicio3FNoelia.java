/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicio3fnoelia;

import javax.swing.JOptionPane;

/**
 *
 * @author noelia
 */
public class Ejercicio3FNoelia {

    public static void main(String[] args) {

        //editar el programa 2.0 a modular
        //crear metodos para, mostrarMenuInicial, leerCodigos, filtrarCodigos,
        //leerMateriaPrima, filtrarMateriaPrima, leerManoObra, filtrarManoObra
        //calcularCosteProduct, calcularPVU, calcularUnidadesBeneficio
        final double BENEFICIO_M1_M2_P1 = 0.5;
        final double BENEFICIO_T1_T2 = 0.65;

        final int BENEFICIO_VENTAS = 2500;

        final double MATERIA_INFERIOR = 0.1;
        final double MATERIA_SUPERIOR = 1;

        final double MANOBRA_INFERIOR = 0.5;
        final double MANOBRA_SUPERIOR = 0.9;

        String codigoOpcion = pedirOpcion();

        if (codigoOpcion.equalsIgnoreCase("1")) {

            String codigoProducto = pedirCodigo();

            double precioMateriaDouble = leerMateriaPrima(MATERIA_SUPERIOR, MATERIA_INFERIOR);

            double precioManoObraDouble = leerManoObra(MANOBRA_SUPERIOR, MANOBRA_INFERIOR);

            double costeProduccion = costeProduccion(precioManoObraDouble,
                    precioMateriaDouble);
            double ventaUnitaria = ventaUnitaria(costeProduccion,
                    codigoProducto, BENEFICIO_M1_M2_P1,
                    BENEFICIO_T1_T2);
            double ventasNecesarias = ventasNecesarias(
                    BENEFICIO_VENTAS, ventaUnitaria, costeProduccion);
            JOptionPane.showMessageDialog(null,
                    """
                                                     Para %s
                                ------------------------------------------------
                                Coste de producción unitario: %.2f €
                                Precio de venta unitario: %.2f €
                                Ventas necesarias para producir beneficio: %.0f
                                """.formatted(codigoProducto, costeProduccion,
                            ventaUnitaria, ventasNecesarias));

        }

    }

    public static String menuInicial() {

        String codigoOpcion = JOptionPane.showInputDialog("""
                                     ELIJA UNA OPCION
                           ---------------------------------------------------------
                           - Pulse 1 para ver los productos
                           - Escriba "salir" para cerrar el programa
                           """);

        return codigoOpcion;
    }

    public static boolean esCodigoOpcionValido(String codigoOpcion) {

        return (codigoOpcion.equalsIgnoreCase("salir")
                || codigoOpcion.equalsIgnoreCase("1"));

    }

    public static String pedirOpcion() {
        String codigoOpcion = "";
        do {
            codigoOpcion = menuInicial();

        } while (!esCodigoOpcionValido(codigoOpcion));
        return codigoOpcion;
    }

    public static String menuCodigo() {

        String codigoProducto = JOptionPane.showInputDialog("""
                                                 PRODUCTOS
                                    -------------------------------------
                                    M1 - Mantecados de limón
                                    P1 - Polvorones
                                    T1 - Turrón de chocolate
                                    T2 - Turrón clásico
                                    M2 - Mazapanes
                                    Escriba "salir" para volver al menú principal
                                    
                                    Introduzca un código: 
                                    """);
        return codigoProducto;
    }

    public static boolean esCodigoProductoValido(String codigoProducto) {

        return (codigoProducto.equalsIgnoreCase("M1")
                || codigoProducto.equalsIgnoreCase("T1")
                || codigoProducto.equalsIgnoreCase("P1")
                || codigoProducto.equalsIgnoreCase("T2")
                || codigoProducto.equalsIgnoreCase("M2"))
                || codigoProducto.equalsIgnoreCase("salir");
    }

    public static String pedirCodigo() {

        String codigoProducto = "";
        do {
            if (!codigoProducto.equalsIgnoreCase("salir")) {
                codigoProducto = menuCodigo();
                
            }else {
                    codigoProducto = "salir";
                }
        } while (!esCodigoProductoValido(codigoProducto));
        return codigoProducto;

    }

    public static double leerMateriaPrima(double max, double min) {

        double precioMateriaDouble = 0;
        boolean repetir = true;

        do {
            repetir = true;
            try {
                String precioMateria = JOptionPane.showInputDialog(
                        "Introduzca el precio de la materia prima entre 0.1 y 1");
                precioMateriaDouble = Double.parseDouble(precioMateria);
                repetir = false;
            } catch (NumberFormatException ex) {
                JOptionPane.showInputDialog("Precio erróneo");

            }

        } while (repetir || precioMateriaDouble < min || precioMateriaDouble > max);

        return precioMateriaDouble;

    }

    public static double leerManoObra(double max, double min) {

        double precioManoObraDouble = 0;

        do {
            String precioManoObra = JOptionPane.showInputDialog(
                    "Introduzca el precio de la mano de obra entre 0.5 y 0.9");
            precioManoObraDouble = Double.parseDouble(precioManoObra);
        } while (precioManoObraDouble < min || precioManoObraDouble > max);

        return precioManoObraDouble;
    }

    public static double costeProduccion(double manoObra, double materiaPrima) {

        return manoObra + materiaPrima;
    }

    public static double ventaUnitaria(double costeProduccion,
            String codigoProducto, double beneficio_m1_m2_p1, double beneficio_t1_t2) {
        double ventaUnitaria = 0;
        if (codigoProducto.equalsIgnoreCase("M1")
                || codigoProducto.equalsIgnoreCase("M2")
                || codigoProducto.equalsIgnoreCase("P1")) {
            ventaUnitaria = costeProduccion
                    + (beneficio_m1_m2_p1 * costeProduccion);
        } else {
            ventaUnitaria = costeProduccion
                    + (beneficio_t1_t2 * costeProduccion);
        }
        return ventaUnitaria;
    }

    public static double ventasNecesarias(int beneficioVentas, double ventaUnitaria, double costeProduccion) {

        return Math.ceil(beneficioVentas / (ventaUnitaria - costeProduccion));

    }

    //    do {
//            String precioMateria = JOptionPane.showInputDialog(
//                    "Introduzca el precio de la materia prima entre 0.1 y 1");
//            precioMateriaDouble = Double.parseDouble(precioMateria);
//        } while (precioMateriaDouble < min || precioMateriaDouble > max);
}
