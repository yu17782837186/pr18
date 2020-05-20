package cn.com.thread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {
        //任务调度 Timer 和 TimerTask类
        Timer timer = new Timer();
        //执行安排
        //timer.schedule(new MyTask(),1000);//执行任务一次
        //timer.schedule(new MyTask(),1000,200);//执行多次
        Calendar calendar = new GregorianCalendar(2019,9,9,3,58);
        timer.schedule(new MyTask(),calendar.getTime(),1000);//指定时间
    }
}
class MyTask extends TimerTask {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("hello world");
        }
        System.out.println("---end---");
    }
}