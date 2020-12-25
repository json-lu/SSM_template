import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 13:15 2020/10/16
 * @Author: Ljx
 * @Decription:
 */
public class TestDemo {



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<10000000;i++){
            list.add(1);
        }
        long startOne = System.currentTimeMillis();
        int len = list.size();
        for (int i = 0;i<len;i++){
            System.out.println(list.get(i));
        }
        long endOne = System.currentTimeMillis();
        System.out.println(endOne-startOne);

        long startTwo = System.currentTimeMillis();
        for (int i = 0,length=list.size();i<length;i++){
            System.out.println(list.get(i));
        }//数据量大时计算更快
        long endTwo = System.currentTimeMillis();
        System.out.println(endTwo-startTwo);

        long startThree = System.currentTimeMillis();
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        long endThree = System.currentTimeMillis();

        System.out.println(endThree-startThree);

    }
}
