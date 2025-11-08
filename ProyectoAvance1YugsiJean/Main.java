import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal que simula interaccion por consola para el alquiler de vehiculos.
 * Crea 3 vehiculos (2 coches, 1 moto) y permite al usuario seleccionar por placa y dias.
 */
public class Main {
    public static void main(String[] args) {
        // Crear vehiculos de ejemplo
        Vehiculo v1 = new Coche("ABC-123", "Toyota", "Corolla", 30.0f, 4);
        Vehiculo v2 = new Coche("YUG-101", "Mazda", "MX-5 Miata", 45.0f, 2);
        Vehiculo v3 = new Motocicleta("MOTO-01", "Yamaha", "R16", 15.0f, 155);

        Vehiculo[] catalogo = {v1, v2, v3};

        System.out.println("=== Catalogo de vehiculos ===");
        for (Vehiculo v : catalogo) {
            System.out.println(v);
        }
        System.out.println("=============================");
        System.out.printf("Vehiculos creados: %d%n%n", Vehiculo.getContadorVehiculos());

        Scanner sc = new Scanner(System.in);

        try {
            // Bucle para pedir placa valida
            Vehiculo seleccionado = null;
            while (seleccionado == null) {
                System.out.print("Ingrese la placa del vehiculo a alquilar: ");
                String placaBuscada = sc.nextLine().trim();
                try {
                    seleccionado = buscarPorPlaca(catalogo, placaBuscada);
                    if (seleccionado == null) {
                        throw new DatosInvalidosException("No se encontro un vehiculo con esa placa.");
                    }
                } catch (DatosInvalidosException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Por favor, intente nuevamente.\n");
                }
            }

            // Bucle para pedir numero de dias valido
            int dias = 0;
            boolean valido = false;
            while (!valido) {
                System.out.print("Ingrese numero de dias de alquiler: ");
                try {
                    dias = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    if (dias <= 0) {
                        throw new IllegalArgumentException("El numero de dias debe ser mayor que 0.");
                    }
                    valido = true;
                } catch (InputMismatchException ime) {
                    System.err.println(" Error: debe ingresar un numero entero.");
                    sc.nextLine(); // limpiar entrada invalida
                } catch (IllegalArgumentException iae) {
                    System.err.println(iae.getMessage());
                }
            }

            // Mostrar resumen del alquiler
            double total = seleccionado.getPrecioDia() * dias;
            System.out.println("\n Vehiculo seleccionado:");
            System.out.println(seleccionado);
            System.out.printf("Dias: %d | Total a pagar: %.2f%n", dias, total);

        } catch (Exception e) {
            System.err.println("Ocurrio un error inesperado: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("\nPrograma finalizado.");
        }
    }

    /**
     * Busca un vehiculo en el arreglo por su placa (comparacion case-insensitive).
     *
     * @param catalogo arreglo de vehiculos
     * @param placa    placa a buscar
     * @return Vehiculo si lo encuentra, o null si no
     */
    private static Vehiculo buscarPorPlaca(Vehiculo[] catalogo, String placa) {
        if (placa == null || placa.isEmpty()) {
            return null;
        }
        for (Vehiculo v : catalogo) {
            if (v.getPlaca() != null && v.getPlaca().equalsIgnoreCase(placa.trim())) {
                return v;
            }
        }
        return null;
    }
}
