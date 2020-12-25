/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 14:21 2020/12/25
 * @Author: Ljx
 * @Decription:
 */
public class Test11 {

    public static void main(String[] args) {
        Person student = new Student();
        Person man = new Man();
        PersonTools.print(student);
        PersonTools.print(man);
    }
}
class Person{
    public void eat(){
        System.out.println("吃");
    }
    public void run(){
        System.out.println("运动");
    }
}
class Student extends Person{
    @Override
    public void eat() {
        System.out.println("吃食堂！");
    }

    @Override
    public void run() {
        System.out.println("跑步");
    }
}
class Man extends Person{
    @Override
    public void eat() {
        System.out.println("外卖！");
    }

    @Override
    public void run() {
        System.out.println("搬砖");
    }
}
class PersonTools{
    public static void print(Person p){
        p.eat();
        p.run();
    }
}
