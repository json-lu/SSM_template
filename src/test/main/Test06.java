import com.ljx.exercise.pojo.User;

import java.io.*;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 9:38 2020/12/23
 * @Author: Ljx
 * @Decription:
 */
public class Test06 {

    public static void main(String[] args) {

        try(Reader rd = new StringReader("你好，字符输入流!!!++((!(#&!@^&@$)_$)!@&$)+-*//*");){
            int len = 0;
            char [] chars = new char[1024];
            while((len = rd.read(chars))!=-1){
                System.out.println(chars);
            }

        }catch (Exception e){

        }
    }
}
