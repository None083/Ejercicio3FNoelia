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
        System.out.println("Hello World!");

        //editar el programa 2.0 a modular
        //crear metodos para, mostrarMenuInicial, leerCodigos, filtrarCodigos,
        //leerMateriaPrima, filtrarMateriaPrima, leerManoObra, filtrarManoObra
        //calcularCosteProduct, calcularPVU, calcularUnidadesBeneficio
        
        
        final double BENEFICIO_M1_M2_P1 = 0.5;
        final double BENEFICIO_T1_T2 = 0.65;

        final double BENEFICIO_VENTAS = 2500;

        final double MATERIA_INFERIOR = 0.1;
        final double MATERIA_SUPERIOR = 1;

        final double MANOBRA_INFERIOR = 0.5;
        final double MANOBRA_SUPERIOR = 0.9;
        
        String codigoOpcion = "";

        while (!codigoOpcion.equalsIgnoreCase("salir")) {
            codigoOpcion = JOptionPane.showInputDialog("""
                                     ELIJA UNA OPCION
                           ---------------------------------------------------------
                           - Pulse 1 para ver los productos
                           - Escriba "salir" para cerrar el programa
                           """);
            if (codigoOpcion.equalsIgnoreCase("1")) {
                String codigoProducto = "";
                while (!codigoProducto.equalsIgnoreCase("salir")) {
                    codigoProducto = JOptionPane.showInputDialog("""
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
                    if (codigoProducto.equalsIgnoreCase("M1")
                            || codigoProducto.equalsIgnoreCase("T1")
                            || codigoProducto.equalsIgnoreCase("P1")
                            || codigoProducto.equalsIgnoreCase("T2")
                            || codigoProducto.equalsIgnoreCase("M2")) {
                        double precioMateriaDouble = 0;
                        while (precioMateriaDouble < MATERIA_INFERIOR
                                || precioMateriaDouble > MATERIA_SUPERIOR) {
                            String precioMateria = JOptionPane.showInputDialog(
                                    "Introduzca el precio de la materia prima entre 0.1 y 1");
                            precioMateriaDouble = Double.parseDouble(precioMateria);
                        }
                        double precioManoObraDouble = 0;
                        while (precioManoObraDouble < MANOBRA_INFERIOR
                                || precioManoObraDouble > MANOBRA_SUPERIOR) {
                            String precioManoObra = JOptionPane.showInputDialog(
                                    "Introduzca el precio de la mano de obra entre 0.5 y 0.9");
                            precioManoObraDouble = Double.parseDouble(precioManoObra);
                        }
                        if (codigoProducto.equalsIgnoreCase("M1")
                                || codigoProducto.equalsIgnoreCase("M2")
                                || codigoProducto.equalsIgnoreCase("P1")) {
                            double costeProduccion = precioMateriaDouble + precioManoObraDouble;
                            double ventaUnitaria = costeProduccion
                                    + (BENEFICIO_M1_M2_P1 * costeProduccion);
                            double ventasNecesarias = BENEFICIO_VENTAS
                                    / (ventaUnitaria - costeProduccion);
                            ventasNecesarias = Math.ceil(ventasNecesarias);
                            JOptionPane.showMessageDialog(null,
                                    """
                                                     Para %s
                                ------------------------------------------------
                                Coste de producción unitario: %.2f €
                                Precio de venta unitario: %.2f €
                                Ventas necesarias para producir beneficio: %.0f
                                """.formatted(codigoProducto, costeProduccion,
                                            ventaUnitaria, ventasNecesarias));
                        } else {
                            double costeProduccion = precioMateriaDouble + precioManoObraDouble;
                            double ventaUnitaria = costeProduccion
                                    + (BENEFICIO_T1_T2 * costeProduccion);
                            double ventasNecesarias = BENEFICIO_VENTAS
                                    / (ventaUnitaria - costeProduccion);
                            ventasNecesarias = Math.ceil(ventasNecesarias);
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
                    } else if (!codigoProducto.equalsIgnoreCase("salir")) {
                        JOptionPane.showMessageDialog(null, "Código no válido");
                    }
                }
            } else if (!codigoOpcion.equalsIgnoreCase("salir")) {
                JOptionPane.showMessageDialog(null, "Código no válido");
            }
        }

    }
}
