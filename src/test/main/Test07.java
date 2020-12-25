import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 11:09 2020/12/23
 * @Author: Ljx
 * @Decription:
 */
public class Test07 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("src/abc.txt",false);
            FileInputStream fis = new FileInputStream("src/abc.txt")){
                fos.write("aa".getBytes());
                fos.write("\r\n".getBytes());
                fos.write("你+_-&*^@&^#!%!@$好中文".getBytes("UTF-8"));
                int read = 0;
                byte [] bytes = new byte[1024];
                while ((read = fis.read(bytes))!=-1){
                    System.out.println(new String(bytes,"UTF-8"));
                }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
