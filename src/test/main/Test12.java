import java.io.*;

/**
 * <p>
 *      测试性能
 *          使用缓冲输入流和普通流传输文件
 *          传输一个100M的文件
 * </p>
 *
 * @Since: Created  in 15:25 2020/12/25
 * @Author: Ljx
 * @Decription:
 */
public class Test12 {

    /**
     * 普通方式
     */
    public static void normalIo(){
        long startTime1 = System.currentTimeMillis();
        try(FileInputStream is = new FileInputStream("C:\\Users\\amain\\Downloads\\VSCodeUserSetup-x64-1.49.1.exe");
            FileOutputStream out = new FileOutputStream("vs2.exe");){
            int len = 0;
            byte [] bytes = new byte[1024];
            while((len = is.read(bytes)) != -1){
                out.write(bytes,0,len);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用普通方法传输文件耗时："+(endTime1-startTime1)+"毫秒");
    }

    public static void main(String[] args) {
        normalIo();
    }


}

