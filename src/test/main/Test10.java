/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 10:51 2020/12/25
 * @Author: Ljx
 * @Decription:
 */
class  Matcher{
    public void matcherSpeak(){//=========================父类matcherSpeak()方法
        System.out.println("吃烤山药？");
    }
}

class HappyMother extends Matcher {
    HappyMother () {
        System.out.println("吃烤山药之前...");
        eat();
        System.out.println("吃烤山药之后(熊孩子懵逼中)....");
    }
    public void eat() {
        System.out.println("7岁半就喜欢吃烤山药");
    }
    public void matcherSpeak(){//=========================子类matcherSpeak()方法
        System.out.println("开心的妈妈说：吃，吃大块的，一蛇皮袋够吗");
    }

    public void fatherSpeak(){//=========================子类独有的fatherSpeak()方法
        System.out.println("开心的妈妈说：吃，吃大块的，一麻袋够吗");
    }
}
class SadMother extends HappyMother{
    private String Weight = "110斤";
    public SadMother(String Weight) {
        this.Weight = Weight;
        System.out.println("熊孩子的体重：" + this.Weight);
    }

    public void eat() { // 子类覆盖父类方法
        System.out.println("熊孩子吃烤山药之前的体重是：" + this.Weight);
    }
    public void sadMotherSpeak(){
        System.out.println("不开心的妈妈说：不能吃!");
    }
}
public class Test10 {
    public static void main(String[] args) {
        Matcher m=new SadMother("250斤");
        m.matcherSpeak();
        HappyMother m2 = new SadMother("250斤");
        SadMother sadMother = (SadMother)m2;
        sadMother.sadMotherSpeak();  //编译失败，无法解析fatherSpeak方法
        System.out.println(sadMother instanceof Matcher);
        System.out.println(m instanceof Matcher);
    }
}
