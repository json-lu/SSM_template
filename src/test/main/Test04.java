import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 18:17 2020/12/22
 * @Author: Ljx
 * @Decription:
 */
public class Test04 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        InputStream is = null;
        OutputStream out = null;
        try {
            is = Test04.class.getResourceAsStream("mybatis-config.xml");
            File file = new File("src/main/resources", "mybatis-config2.xml");
            out = new FileOutputStream(file);
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                out.write(bytes,0,len);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (is != null) {
                try {
                    is.close();

                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        }
        long end = System.currentTimeMillis();

        System.out.println("执行时间:"+(end-start));
    }
}
