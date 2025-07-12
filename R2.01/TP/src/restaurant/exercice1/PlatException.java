package restaurant.exercice1;

/**
 * Exception levée lors de la création d'un plat ne correspondant pas aux contraintes imposées par le client
 */
public class PlatException extends Exception {

    public PlatException(String message) {
        super(message);
    }
}
