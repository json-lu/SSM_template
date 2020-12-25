import net.bytebuddy.agent.builder.LambdaFactory;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 9:49 2020/12/25
 * @Author: Ljx
 * @Decription:
 */
public class ExtendsTest2 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        System.out.println(a.show(a));//A and A
        System.out.println(a.show(b));//
        System.out.println(a.show(c));
        System.out.println(b.show(c));

    }

}
class A{
    public String show(C obj){
        return "A and C";
    }
    public String show(A obj) {//B是a的子类，所以B可以转成A
        return "A and A";
    }

}
class B extends A{
    @Override
    public String show(C obj) {
        return super.show(obj);
    }

    @Override
    public String show(A obj) {
        return super.show(obj);
    }

    public String show(B obj){
        System.out.println("我被执行了码");
        return "B and B";
    }
}
class C extends B{
    @Override
    public String show(C obj) {
        return super.show(obj);
    }

    @Override
    public String show(B obj) {
        return super.show(obj);
    }

    public String show(A obj){
        return "A and B";
    }

}
