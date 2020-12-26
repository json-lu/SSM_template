import java.io.*;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 17:26 2020/12/25
 * @Author: Ljx
 * @Decription:
 */
public class Test16 {

    public static void main(String[] args) {
        String str = "aa啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊比啵啵啵啵啵啵啵啵啵啵啵啵啵啵啵啵啵啵噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢噢哦哦哦哦急急急急急急急急急急急急急急急急急急啊大大大大大大大大大大大大大大大大大大";
            try(/*OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("aaa.txt"),"UTF-8");*/
            InputStreamReader isr = new InputStreamReader(new FileInputStream("aaa.txt"),"UTF-8")){
            //osw.write(str);
            int len = 0;
            while((len = isr.read()) != -1){
                System.out.println(len);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
