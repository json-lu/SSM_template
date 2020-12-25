import com.ljx.exercise.pojo.User;
import org.junit.Assert;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 10:20 2020/12/24
 * @Author: Ljx
 * @Decription:
 */
public class test09 {
    public static void main(String[] args) {

        System.out.println(getNumber(2));
        System.out.println(1^3);
        try{
            ThrowAble(1);
            return ;

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            Assert.fail("你错误了!");
        }
        Assert.assertNull(null);


    }
    public  static void ThrowAble(int a) throws NullPointerException,ArithmeticException    {
        if (a == 1){
            throw new NullPointerException("手动抛出空指针异常~!");
        }
        if (a == 1){
            throw new ArithmeticException("手动抛出算术异常~!");
        }
    }

    public static int getNumber(int i){
        try{
            i= i<<2;
            throw  new ArithmeticException("算错了，重新来!!!!");
        }catch (Exception e){
            System.out.println(e.getMessage());
            i = i<<3;
            return i;
        }finally {
            System.out.println(i);
            i = i>>2;
            System.out.println(i);
            System.out.println("执行了码");
        }

    }
}
