/**
 * Excepción personalizada usada para indicar que hay datos inválidos
 * en operaciones de más alto nivel (por ejemplo, búsqueda fallida).
 */
public class DatosInvalidosException extends Exception {
    /**
     * Construye una nueva excepcion con el mensaje indicado.
     *
     * @param mensaje Mensaje que describe la razón de la excepcion.
     */
    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}
