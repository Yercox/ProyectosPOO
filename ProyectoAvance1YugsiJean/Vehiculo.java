/**
 * Clase padre Vehiculo que representa atributos y comportamiento básico
 * de un vehículo para el sistema de alquiler.
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private double precioDia;

    private static int contadorVehiculos = 0;

    /**
     * Constructor por defecto.
     */
    public Vehiculo() {
        contadorVehiculos++;
    }

    /**
     * Constructor parametrizado.
     *
     * @param placa     Placa del vehículo.
     * @param marca     Marca del vehículo.
     * @param modelo    Modelo del vehículo.
     * @param precioDia Precio por día (debe ser > 0).
     * @throws IllegalArgumentException si precioDia <= 0.
     */
    public Vehiculo(String placa, String marca, String modelo, double precioDia) {
       
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precioDia = precioDia;
        contadorVehiculos++;
    }

    /** getters y setters con validaciones donde aplica */

    /**
     * @return placa del vehículo
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa la nueva placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca la nueva marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo el nuevo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return precio por día
     */
    public double getPrecioDia() {
        return precioDia;
    }

    /**
     * Establece el precio por día. Lanza IllegalArgumentException si el precio es <= 0.
     *
     * @param precioDia nuevo precio por día
     * @throws IllegalArgumentException si precioDia <= 0
     */
    public void setPrecioDia(double precioDia) {
        if (precioDia <= 0) {
            throw new IllegalArgumentException("El precio por día debe ser mayor que 0.");
        }
        this.precioDia = precioDia;
    }

    /**
     * Obtiene la cantidad de vehículos instanciados.
     *
     * @return número total de vehículos creados
     */
    public static int getContadorVehiculos() {
        return contadorVehiculos;
    }

    @Override
    public String toString() {
        return String.format("Placa: %s | Marca: %s | Modelo: %s | Precio/día: %.2f",
                placa, marca, modelo, precioDia);
    }
}
