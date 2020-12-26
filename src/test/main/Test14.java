import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 16:15 2020/12/25
 * @Author: Ljx
 * @Decription:
 */
public class Test14 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try( Reader reader = new FileReader("C:\\Users\\amain\\Downloads\\测试.xls");
             Writer writer = new FileWriter("测试.xls")){
            int len = 0;
            while ((len = reader.read()) != -1){
                writer.write(len);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start)+"毫秒!");
    }
}
