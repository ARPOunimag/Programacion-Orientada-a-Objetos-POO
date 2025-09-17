package texting;

import java.util.Scanner;
import umag.datos.Habitacion;
import umag.datos.SistemaHotel;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaHotel sistema = new SistemaHotel(10);

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Ingresar nueva habitacion");
            System.out.println("2. Consultar costo por codigo");
            System.out.println("3. Listar todas las habitaciones");
            System.out.println("4. Listar por numero de personas");
            System.out.println("5. porcentaje de habitaciones estrato 6");
            System.out.println("6. Promedio de costos (habitaciones con aire)");
            System.out.println("7. Habitacion menos costosa");
            System.out.println("8. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("Codigo: ");
                int codigo = sc.nextInt();
                System.out.print("Numero de personas (1-3): ");
                int personas = sc.nextInt();
                while (personas > 3 || personas < 1){
                    System.out.println("No es un numero valido de personas");
                    System.out.println("Ingrese un numero de personas (1-3) ");
                    personas = sc.nextInt();
                }
                System.out.print("Estrato (1-6): ");
                int estrato = sc.nextInt();
                while (estrato > 6 || estrato < 1){
                    System.out.println("No es un numero valido de estrato");
                    System.out.println("Ingrese un estrato (1-6) ");
                    estrato = sc.nextInt();
                }
                System.out.print("Tiene aire? 1=SI, 0=NO: ");
                int aireNum = sc.nextInt();
                boolean aire = aireNum == 1;

                Habitacion h = new Habitacion(codigo, personas, estrato, aire);
                sistema.agregarHabitacion(h);

            } else if (opcion == 2) {
                System.out.print("Codigo a buscar: ");
                int codigo = sc.nextInt();
                Habitacion h = sistema.buscarPorCodigo(codigo);
                if (h != null) {
                    System.out.println("Costo = " + h.getCosto());
                } else {
                    System.out.println("No existe habitación con ese codigo.");
                }

            } else if (opcion == 3) {
                sistema.listarHabitaciones();

            } else if (opcion == 4) {
                System.out.print("Numero de personas: ");
                int p = sc.nextInt();
                sistema.listarPorPersonas(p);

            } else if (opcion == 5) {
                System.out.println("porcentaje Estrato 6 = " + sistema.porcentajeEstrato6());

            } else if (opcion == 6) {
                System.out.println("Promedio con aire = " + sistema.promedioConAire());

            } else if (opcion == 7) {
                Habitacion h = sistema.menosCostosa();
                if (h != null) {
                    System.out.println("Menos costosa: " + h);
                } else {
                    System.out.println("No hay habitaciones registradas");
                }
            } else {
                System.out.println("\n Por favor, ingrese una opcion valida (1-8)");
            }

        } while (opcion != 8);
        System.out.println("MUCHAS GRACIAS. Saliendo");
    }
}
