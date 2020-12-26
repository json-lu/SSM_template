import com.ljx.exercise.helper.Conv;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 15:49 2020/12/26
 * @Author: Ljx
 * @Decription:
 */
public class Test21 {
    final static  Timer timer = new Timer();

    public static void main(String[] args) {
        System.out.println(Conv.toDate(new Date(System.currentTimeMillis())));
        scheduleDisk();

    }

    /**
     * 三个参数
     *  第一个是被执行的定时任务内容
     *  第二个是定时任务开始执行的时间
     *  第三个是定时任务重复执行的间隔时间
     */
    public static void scheduleDisk(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("我是定时任务，在一秒后执行"+ Conv.toDate(new Date(System.currentTimeMillis())));
            }
        },1000,2000);
    }
}
