import com.ljx.exercise.pojo.User;

import java.io.*;

/**
 * <p>
 *     被序列化的对象必须实现Serializable接口,否则将无法序列化
 *
 *      序列化 ObjectOutputStream
 *          将内存中的对象持久化到磁盘存储
 *      反序列化 ObjectInputStream
 *          将磁盘中的持久化对象读取到内存中
 * </p>
 *
 * @Since: Created  in 17:48 2020/12/25
 * @Author: Ljx
 * @Decription:
 */
public class Test17 {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("序列化");
        user.setPassword("12315");
        user.setMobile("1232334243242");
        //序列化
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.txt"));){
            out.writeObject(user);
        }catch (Exception e){
            System.out.println(e);
        }
        //反序列化
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.txt"));){
            Object object = ois.readObject();
            System.out.println(object);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
