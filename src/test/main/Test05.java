import java.io.*;

/**
 * <p>
 *      字节流
 *          InputStream 字节输入流 ----读取文件到内存中
 *          OutputStream 字节输出流 ----写入文件到内存中
 *          BufferedInputStream 字节缓冲输入流
 *          BufferedOutputStream 字节缓冲输出流
 * </p>
 *
 * @Since: Created  in 18:17 2020/12/22
 * @Author: Ljx
 * @Decription:
 */
public class Test05 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        InputStream is = null;
        OutputStream out = null;
        BufferedInputStream bois = null;
        BufferedOutputStream bout = null;
        try {
            is = Test05.class.getResourceAsStream("mybatis-config.xml");
            File file = new File("src/main/resources", "mybatis-config3.xml");
            bois = new BufferedInputStream(is);
            out = new FileOutputStream(file);
            bout = new BufferedOutputStream(out);
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = bois.read(bytes)) != -1) {
                bout.write(bytes,0,len);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

            if (bout != null) {
                try {
                    bout.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (bois != null) {
                try {
                    bois.close();
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
