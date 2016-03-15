package fr.mazerty.shika.ishi.cdi;

/**
 * Interface du Producer CDI spécifique à chaque application
 */
public interface SpecificProducer {

    /**
     * @return la String nommant l'application (utilisée dans UserServiceImpl)
     */
    String getApplication();

}
