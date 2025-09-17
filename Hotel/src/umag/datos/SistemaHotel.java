package umag.datos;

public class SistemaHotel {
    private Habitacion[] habitaciones;
    private int n; // cantidad actual

    public SistemaHotel(int capacidad) {
        habitaciones = new Habitacion[capacidad];
        n = 0;
    }

    public void agregarHabitacion(Habitacion h) {
        if (n < habitaciones.length) {
            habitaciones[n] = h;
            n++;
        } else {
            System.out.println("No hay espacio para mas habitaciones");
        }
    }

    public Habitacion buscarPorCodigo(int codigo) {
        for (int i = 0; i < n; i++) {
            if (habitaciones[i].getCodigo() == codigo) {
                return habitaciones[i];
            }
        }
        return null;
    }

    public void listarHabitaciones() {
        for (int i = 0; i < n; i++) {
            System.out.println(habitaciones[i]);
        }
    }

    public void listarPorPersonas(int personas) {
        for (int i = 0; i < n; i++) {
            if (habitaciones[i].getNumPersonas() == personas) {
                System.out.println(habitaciones[i]);
            }
        }
    }

    public float porcentajeEstrato6() {
        int cont = 0;
        for (int i = 0; i < n; i++) {
            if (habitaciones[i].getEstrato() == 6) {
                cont++;
            }
        }
        if (n > 0) {
            return (cont * 100f) / n;
        } else {
            return 0;
        }
    }

    public float promedioConAire() {
        float suma = 0;
        int cont = 0;
        for (int i = 0; i < n; i++) {
            if (habitaciones[i].getAire()) {
                suma = suma + habitaciones[i].getCosto();
                cont++;
            }
        }
        if (cont > 0) {
            return suma / cont;
        } else {
            return 0;
        }
    }

    public Habitacion menosCostosa() {
        if (n == 0) {
            return null;
        }
        Habitacion menor = habitaciones[0];
        for (int i = 1; i < n; i++) {
            if (habitaciones[i].getCosto() < menor.getCosto()) {
                menor = habitaciones[i];
            }
        }
        return menor;
    }
}
