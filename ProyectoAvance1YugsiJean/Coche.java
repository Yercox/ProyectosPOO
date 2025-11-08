/**
 * Clase Coche que extiende Vehiculo e incluye el atributo numPuertas.
 */
public class Coche extends Vehiculo {
    private int numPuertas;

    /**
     * Constructor por defecto.
     */
    public Coche() {
        super();
    }

    /**
     * Constructor parametrizado.
     *
     * @param placa      placa del coche
     * @param marca      marca del coche
     * @param modelo     modelo del coche
     * @param precioDia  precio por día (debe ser > 0)
     * @param numPuertas número de puertas (debe ser > 0)
     * @throws IllegalArgumentException si numPuertas <= 0 o precio invalido
     */
    public Coche(String placa, String marca, String modelo, double precioDia, int numPuertas) {
        super(placa, marca, modelo, precioDia);
        this.numPuertas = numPuertas;
    }

    /**
     * @return numero de puertas del coche
     */
    public int getNumPuertas() {
        return numPuertas;
    }

    /**
     * @param numPuertas establece el numero de puertas (debe ser > 0)
     * @throws IllegalArgumentException si numPuertas <= 0
     */
    public void setNumPuertas(int numPuertas) {
        if (numPuertas <= 0) {
            throw new IllegalArgumentException("Numero de puertas debe ser mayor que 0.");
        }
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return "Coche | " + super.toString() + String.format(" | Puertas: %d", numPuertas);
    }
}
