package es.fpdual;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Main class
 * 
 * @author Deg42
 */
public class App {

    /**
     * Main method
     * 
     * @param args arguments of app
     */
    public static void main(String[] args) {
        App app = new App();
        Properties prop = app.loadPropertiesFile("config.properties");
        prop.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();

        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath);
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.print("Unable to load properties file : " + filePath);
        }
        return prop;
    }
}
