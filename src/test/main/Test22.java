/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 16:02 2020/12/26
 * @Author: Ljx
 * @Decription:
 */
public class Test22 {

    public static void main(String[] args) {

        System.out.println("当前正在调用的线程是："+Thread.currentThread().getName());

    }

}

class Behavior extends Thread{

    @Override
    public void run() {
        System.out.println(this.getName());
    }

}

class People extends Thread{

    @Override
    public void run() {
        System.out.println(this.getName());
    }
}