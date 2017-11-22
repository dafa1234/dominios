package modelo;

public class ServicioException extends Exception {

    public ServicioException(String message) {
        super(message);
    }

    public ServicioException(String message, Throwable cause) {
        super(message, cause);
    }

    ServicioException(String generalError, String message, RuntimeException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
