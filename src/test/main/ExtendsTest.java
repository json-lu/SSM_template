import com.ljx.exercise.enums.ExceptionEnum;
import com.ljx.exercise.pojo.User;
import com.sun.org.apache.bcel.internal.ExceptionConst;

/**
 * <p>
 *      继承
 * </p>
 *
 * @Since: Created  in 17:45 2020/12/24
 * @Author: Ljx
 * @Decription:
 */
public class ExtendsTest extends Animals{
    public ExtendsTest() {
       super();
    }
    public ExtendsTest(String name,Integer age){
        super(name,age);
    }
    public void setAge(Integer age) throws NullPointerException{
        super.setAge(age);
        throw new NullPointerException("我是子类，我不要看到父类的错误!!!");
    }
    public void eat(String food){
        super.eat(food);
        System.out.println("玩毛线球!!!");
    }
    protected Integer getAge(){
        return super.getAge();
    }


    public static void main(String[] args) {
        ExtendsTest extendsTest = new ExtendsTest("11",2);;
        try{
            Animals cat = null;
            extendsTest.setAge(22);
            System.out.println(cat.getAge());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(extendsTest.getAge());
        extendsTest.eat("finish");
    }
}
class Animals{
    //属性
    public String name;
    //私有属性
    private Integer age;

    //构造方法
    public Animals() {
        System.out.println("我是基类!父类！超类!");
    }
    //有参数构造方法
    public Animals(String name,Integer age){
        System.out.println(name+":"+age);
    }

    //公共方法
    public  void setAge(Integer age) throws RuntimeException{
         this.age = age;
         throw new RuntimeException("假装报个错!!!!");
    }
    Integer getAge(){
        return age;
    }
    //普通方法
    public void eat(String food){
        System.out.println("吃"+food);
    }
}