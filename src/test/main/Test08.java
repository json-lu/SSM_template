import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * <p>
 *      字符流
 *          Reader ---字符输入流
 *          Writer ---字符输出流
 * </p>
 *
 * @Since: Created  in 13:08 2020/12/23
 * @Author: Ljx
 * @Decription:
 */
public class Test08 {
    public static void main(String[] args) {
        /**
         * 实现了Closeable接口才可以使用try...with...resources
         *      try(声明流;声明流;....){
         *             使用流
         *      }catch(Exception e){
         *      }
         */
        try (Reader reader = new FileReader("src/abc.txt");//字符输入流读取硬盘文件到内存中
             Writer writer = new FileWriter("src/abd.txt")) {//字符输出流从内存中写入数据到硬盘
            int len = 0;
            char[] chars = new char[1024];
            while ((len = reader.read(chars)) != -1) {
                writer.write(chars);
                System.out.println(chars);
            }
        } catch (Exception e) {

        }
    }
}
