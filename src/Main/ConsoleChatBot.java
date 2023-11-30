package Main;

import dao.VueloDAO;
import java.util.List;
import java.util.Scanner;
import model.Vuelo;
import dao.AerolineaDAO;
import dao.ReservaDAO;
import model.Aerolinea;
import model.Reserva;

public class ConsoleChatBot {

    private final VueloDAO vueloDAO;
    private final Scanner scanner;

    public ConsoleChatBot() {
        vueloDAO = new VueloDAO();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Selecciona una aerolínea:");
        System.out.println("1. Wingo");
        System.out.println("2. Avianca");
        // ... otras aerolíneas
        System.out.print("Ingresa el número de tu elección: ");
        int aerolineaOpcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        String nombreAerolinea = "";
        switch (aerolineaOpcion) {
            case 1:
                nombreAerolinea = "Wingo";
                break;
            case 2:
                nombreAerolinea = "Avianca";
                break;
            // ... otras opciones
            default:
                System.out.println("Opción no válida.");
                return;
        }

        mostrarOpcionesDeAerolinea(nombreAerolinea);
    }

    private void mostrarOpcionesDeAerolinea(String nombreAerolinea) {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Hacer reserva");
            System.out.println("2. Consultar reserva");
            System.out.println("3. Actualizar reserva");
            System.out.println("4. Eliminar reserva");
            System.out.println("5. Volver al menú anterior");
            System.out.print("Ingresa el número de tu elección: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    hacerReserva(nombreAerolinea);
                    break;
                case 2:
                    consultarReserva(nombreAerolinea);
                    break;
                case 3:
                    // Implementa la lógica para actualizar reserva aquí
                    break;
                case 4:
                    // Implementa la lógica para eliminar reserva aquí
                    break;
                case 5:
                    return; // Volver al menú anterior
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void hacerReserva(String nombreAerolinea) {
        // Implementa la lógica para hacer una reserva aquí
    }

    private void consultarReserva(String nombreAerolinea) {
        // Implementa la lógica para consultar una reserva aquí
    }

    // ... otros métodos para actualizar y eliminar reservas

    public static void main(String[] args) {
        new ConsoleChatBotOld().iniciar();
    }
}