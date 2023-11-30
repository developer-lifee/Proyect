
package Main;

import dao.VueloDAO;
import java.util.List;
import java.util.Scanner;
import model.Vuelo;

public class ConsoleChatBotOld {

    private final VueloDAO vueloDAO;
    private final Scanner scanner;

    public ConsoleChatBotOld() {
        vueloDAO = new VueloDAO();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("Bienvenido al sistema de gestión de vuelos. ¿Qué deseas hacer?");
            System.out.println("1. Ver todos los vuelos");
            System.out.println("2. Buscar un vuelo por ID");
            System.out.println("3. Actualizar un vuelo");
            System.out.println("4. Eliminar un vuelo");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    mostrarVuelos();
                    break;
                case 2:
                    buscarVueloPorID();
                    break;
                case 3:
                    actualizarVuelo();
                    break;
                case 4:
                    eliminarVuelo();
                    break;
                case 5:
                    ejecutando = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        }
    }

    private void mostrarVuelos() {
        List<Vuelo> vuelos = vueloDAO.obtenerVuelos();
        for (Vuelo vuelo : vuelos) {
            System.out.println(vuelo); // Asegúrate de tener un método toString adecuado en Vuelo
        }
    }

    private void buscarVueloPorID() {
        System.out.print("Ingresa el ID del vuelo: ");
        int id = scanner.nextInt();
        Vuelo vuelo = vueloDAO.obtenerVueloPorID(id);
        if (vuelo != null) {
            System.out.println(vuelo);
        } else {
            System.out.println("No se encontró el vuelo con ID: " + id);
        }
    }

    private void actualizarVuelo() {
        // Aquí implementarías la lógica para obtener los datos del vuelo y llamar al método actualizarVuelo
    }

    private void eliminarVuelo() {
        System.out.print("Ingresa el ID del vuelo a eliminar: ");
        int id = scanner.nextInt();
        vueloDAO.eliminarVuelo(id);
        System.out.println("Vuelo eliminado correctamente.");
    }

    public static void main(String[] args) {
        new ConsoleChatBot().iniciar();
    }
}
