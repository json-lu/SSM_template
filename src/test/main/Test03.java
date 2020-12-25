/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 23:15 2020/12/21
 * @Author: Ljx
 * @Decription:
 */
public class Test03 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        long startOne = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            a = i*8;
            b = i/2;
            System.out.println(a);
            System.out.println(b);
        }
        long endOne = System.currentTimeMillis();
        long startTwo = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            a = i<<3;//表示乘法 i*8 2的三次方
            b = i>>1;//表示除法 i/2 2的一次方
            System.out.println(a);
            System.out.println(b);
        }
        long endTwo = System.currentTimeMillis();

        System.out.println(endOne-startOne);
        System.out.println(endTwo-startTwo);
    }
}
