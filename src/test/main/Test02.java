import com.ljx.exercise.helper.Conv;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 23:09 2020/12/21
 * @Author: Ljx
 * @Decription:
 */
public class Test02 {
    public static void main(String[] args) {
//        int [] arr = {1,2,3,4,5,6};
//        int [] newArr = new int[3];
//        System.arraycopy(arr,1,newArr,0,3);
//        for (int i : newArr) {
//            System.out.println(i);
//        }
        String str = "121234.adsada.jpg";
        String substring = str.substring(str.lastIndexOf("."));
        System.out.println(substring);
        String s = Conv.toDate(new Date(), "yyyy-MM-dd hh:mm:ss");
        System.out.println(s);
    }
}
