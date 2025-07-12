package tp5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestLogging {
    //Récupération du logger
    private static Logger LOGGER = Logger.getLogger(TestLogging.class.getPackageName());

//    // Configuration du logger
//    static {
//        LOGGER.setLevel(Level.WARNING);
//    }
//
//    // Configuration du logger
//    static {
//        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n");
//        LOGGER.setLevel(Level.WARNING);
//    }

    // Récupérarion du gestionnaire de logs.
    private static final LogManager logManager = LogManager.getLogManager();
    // Configuration du logger
    // EditConfiguration > Modify options > add VM options :
    // -Djava.util.logging.config.file=conf/debug-logging.properties
    static{
        try {
            logManager.readConfiguration( new FileInputStream("conf/debug-logging.properties") );
        } catch (IOException exception) {
            LOGGER.log( Level.SEVERE, "Cannot read configuration file", exception);
        }
    }

    public static void main(String[] args) {
        // TODO: utiliser le logger
        LOGGER.log(Level.INFO, "Mon premier log !" );

        int dividende = (int)(Math.random() * 10);
        int diviseur = (int)(Math.random() * 3);

        LOGGER.log(Level.WARNING, "Attention à une division par 0 peut se produire.");

        try{
            LOGGER.log(Level.INFO, "dividende = " + dividende + " diviseur = " + diviseur + " et quotient = " + (dividende/diviseur));
        }catch(ArithmeticException e){
            LOGGER.log(Level.SEVERE, "Le message d'exception : java.lang.ArithmeticException: divide by zero");
        }
    }
}
