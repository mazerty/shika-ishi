package fr.mazerty.shika.ishi.cdi;

/**
 * Interface du Producer CDI spécifique à chaque application
 */
public interface SpecificProducer {

    /**
     * @return nom de l'application (utilisé dans UserServiceImpl)
     */
    String getApplicationName();

}
