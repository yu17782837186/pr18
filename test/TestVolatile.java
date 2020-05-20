package cn.com.thread;

public class TestVolatile {
    //private volatile static int num = 0;
    private volatile static int num  = 0;
    public static void main(String[] args) {
        //volatile用于保证多线程数据的同步，也就是可见性，轻量级的synchronized
        //也可避免指令重排
//        new Thread(()->{
//            while(num == 0) {//此处不要编写代码
//                //没有时间同步修改的num
//            }
//        }).start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        num = 1;
        new Thread(()->{
            while(num == 0) {

            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
    }
}
