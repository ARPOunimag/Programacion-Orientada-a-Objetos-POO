package umag.datos;

public class Habitacion {
    private int codigo;
    private int numPersonas;
    private int estrato;
    private boolean aire;
    private float costo;

    public Habitacion(int codigo, int numPersonas, int estrato, boolean aire) {
        this.codigo = codigo;
        this.numPersonas = numPersonas;
        this.estrato = estrato;
        this.aire = aire;
        this.costo = calcularCosto();
    }

    private float calcularCosto() {
        float base = 0;
        if (numPersonas == 1) {
            base = 70000;
        } else if (numPersonas == 2) {
            base = 100000;
        } else if (numPersonas == 3) {
            base = 130000;
        }
        if (aire) {
            base = base + 20000;
        }
        if (estrato == 5 || estrato == 6) {
            base = base + 30000;
        }
        return base;
    }

    // los getters y setterss
    public int getCodigo() {
        return codigo;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public int getEstrato() {
        return estrato;
    }

    public boolean getAire() {
        return aire;
    }

    public float getCosto() {
        return costo;
    }

    @Override
   
    public String toString() {
        String aireTexto;
        if (aire == true) {
            aireTexto = "Si";
        } else {
            aireTexto = "No";
        }

        return "Habitacion [codigo=" + codigo +
               ", personas=" + numPersonas +
               ", estrato=" + estrato +
               ", aire=" + aireTexto +
               ", costo=" + costo + "]";
    }
    
}

