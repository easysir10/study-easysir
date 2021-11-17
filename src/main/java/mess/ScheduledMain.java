package mess;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledMain {

    public static void main(String[] args) {
        // 示例代码：
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };
        System.out.println("当前时间: " + new Date() + "n" +
                "线程名称: " + Thread.currentThread().getName());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        long delay  = 1000L;
        long period = 1000L;
        executor.scheduleAtFixedRate(repeatedTask, delay, period, TimeUnit.MILLISECONDS);
        try {
            Thread.sleep(delay + period * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

}
