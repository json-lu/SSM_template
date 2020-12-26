import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 16:25 2020/12/25
 * @Author: Ljx
 * @Decription:
 */
public class Test15 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\amain\\Downloads\\测试.xls"));
            BufferedWriter bf = new BufferedWriter(new FileWriter("测试2.xls"));){
            String line = null;
            while((line = br.readLine()) != null){
                bf.write(line);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start)+"毫秒!");
    }
}
