import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 15:29 2020/12/26
 * @Author: Ljx
 * @Decription:
 */
public class Test20 {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try(InputStream is = new FileInputStream("src/main/resources/db.properties")){
            properties.load(is);
            Set<String> strings = properties.stringPropertyNames();
            for (String string : strings) {
                String value = properties.getProperty(string);
                System.out.println(string+":"+value);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
