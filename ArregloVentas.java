import java.util.Scanner;

public class ArregloVentas {
    private static double[][] ventas = new double[3][12];
    private static final String[] DEPARTAMENTOS = {"Ropa", "Deportes", "Juguetería"};
    private static final String[] MESES = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    // Método para insertar
    public static void insertarVenta(int depto, int mes, double monto) {
        if (validarIndices(depto, mes)) {
            ventas[depto][mes] = monto;
            System.out.println("\n✅ Venta de $" + monto + " registrada en " + DEPARTAMENTOS[depto] + " (" + MESES[mes] + ").");
        }
    }

    // Método para buscar
    public static void buscarVenta(int depto, int mes) {
        if (validarIndices(depto, mes)) {
            double monto = ventas[depto][mes];
            System.out.println("\n🔍 Venta encontrada: $" + monto + " en " + DEPARTAMENTOS[depto] + " (" + MESES[mes] + ").");
        }
    }

    // Método para eliminar
    public static void eliminarVenta(int depto, int mes) {
        if (validarIndices(depto, mes)) {
            ventas[depto][mes] = 0.0;
            System.out.println("\n🗑️ Venta eliminada ($0.0) para " + DEPARTAMENTOS[depto] + " en " + MESES[mes] + ".");
        }
    }

    private static boolean validarIndices(int depto, int mes) {
        if (depto < 0 || depto >= 3 || mes < 0 || mes >= 12) {
            System.out.println("\n⚠️ Error: Opciones fuera de rango (Depto: 0-2, Mes: 0-11).");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion, depto, mes;

        do {
            System.out.println("\n=== GESTIÓN DE VENTAS MENSUALES ===");
            System.out.println("1. Insertar / Actualizar Venta");
            System.out.println("2. Buscar Venta");
            System.out.println("3. Eliminar Venta");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 3) {
                System.out.println("\nSelecciona Departamento (0: Ropa, 1: Deportes, 2: Juguetería): ");
                depto = sc.nextInt();
                System.out.println("Selecciona Mes (0: Enero, 1: Febrero, ... 11: Diciembre): ");
                mes = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa el monto de la venta: $");
                        double monto = sc.nextDouble();
                        insertarVenta(depto, mes, monto);
                        break;
                    case 2:
                        buscarVenta(depto, mes);
                        break;
                    case 3:
                        eliminarVenta(depto, mes);
                        break;
                }
            } else if (opcion != 4) {
                System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        System.out.println("Programa finalizado.");
        sc.close();
    }
}