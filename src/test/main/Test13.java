import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * <p>
 *        测试性能
 *          使用缓冲输入流和普通流传输文件
 *          传输一个100M的文件
 * </p>
 *
 * @Since: Created  in 16:03 2020/12/25
 * @Author: Ljx
 * @Decription:
 */
public class Test13 {

    /**
     * 缓冲方式
     */
    public static void bufferedIo(){
        long startTime2 = System.currentTimeMillis();
        try(BufferedInputStream bif = new BufferedInputStream(new FileInputStream("C:\\Users\\amain\\Downloads\\VSCodeUserSetup-x64-1.49.1.exe"));
            BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream("vs.exe"));){
            int len = 0;
            byte [] bytes = new byte[5*1024];
            while ((len = bif.read(bytes)) != -1){
                bof.write(bytes,0,len);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("使用缓冲方式传输文件耗时："+(endTime2-startTime2)+"毫秒");
    }

    public static void main(String[] args) {
        bufferedIo();
    }

}
