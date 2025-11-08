/**
 * Clase Motocicleta que extiende Vehiculo e incluye el atributo cilindrada.
 */
public class Motocicleta extends Vehiculo {
    private int cilindrada;

    /**
     * Constructor parametrizado.
     *
     * @param placa      placa de la motocicleta
     * @param marca      marca de la motocicleta
     * @param modelo     modelo de la motocicleta
     * @param precioDia  precio por día (debe ser > 0)
     * @param cilindrada cilindrada en cc (debe ser > 0)
     * @throws IllegalArgumentException si cilindrada <= 0 o precio inválido
     */
    public Motocicleta(String placa, String marca, String modelo, double precioDia, int cilindrada) {
        super(placa, marca, modelo, precioDia);
       this.cilindrada=cilindrada;
       }
    /**
     * @return cilindrada en cc
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * @param cilindrada establece la cilindrada (debe ser > 0)
     * @throws IllegalArgumentException si cilindrada <= 0
     */
    public void setCilindrada(int cilindrada) {
        if (cilindrada <= 0) {
            throw new IllegalArgumentException("La cilindrada debe ser mayor que 0.");
        }
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Motocicleta | " + super.toString() + String.format(" | Cilindrada: %dcc", cilindrada);
    }
    }

