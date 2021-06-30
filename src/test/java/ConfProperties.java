import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfProperties {
    protected static Properties PROPERTIES;

    static {
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream("src/test/resources/conf.properties"), StandardCharsets.UTF_8)) {
            PROPERTIES = new Properties();
            PROPERTIES.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
