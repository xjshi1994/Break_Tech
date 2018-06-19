import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/Resources/user.properties"));
            properties.load(reader);
            String name = properties.getProperty("name");
            String birthYear = properties.getProperty("birthYear");
            String gender = properties.getProperty("gender");
            System.out.printf("%s is a %s borned in the %s", name, gender, birthYear);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
