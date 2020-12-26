import com.ljx.exercise.pojo.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * <p>
 *      序列化集合练习
 *          打印流 printer
 *              字节打印流 PrintStream
 *              字符打印流 PrintWriter
 * </p>
 *
 * @Since: Created  in 10:44 2020/12/26
 * @Author: Ljx
 * @Decription:
 */
public class Test18 {


    public static void main(String[] args) {
        User user = new User("张三","1234556","13896788888");
        User user1 = new User("张三","1234556","13896788888");
        User user2 = new User("张三","1234556","13896788888");
        User user3 = new User("张三","1234556","13896788888");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        //序列化集合
        //serial(list);
        //反序列化集合
        reverseSerial();
    }

    /**
     * 序列化方法
     * @param list
     */
    public static void serial(List<User> list){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userList.txt"));){
            //将对象持久化到磁盘，序列化
                oos.writeObject(list);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void reverseSerial(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userList.txt"));
            PrintStream ps = new PrintStream(System.out);//字节打印流
            PrintWriter pw = new PrintWriter(System.out)){//字符打印流
             List<User> list = (List<User>) ois.readObject();
             ps.println(list);
            for (User user : list) {
                ps.println(user);
            }
            pw.print("反序列化完毕，我是字符打印流输出的结束语句!!!!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
