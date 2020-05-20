package cn.com.thread;

public class TestHappenBefore {
    //变量1
    private static int a = 0;
    //变量2
    private static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        //指令重排：代码的执行顺序与预期的不一致
        //目的是为了提高性能
        //线程1 更改数据
//        for (int i = 0;i < 100;i++) {
//            a = 0;
//            flag = false;
//            Thread t1 = new Thread(() -> {
//                a = 1;
//                flag = true;
//            });
//            //线程2 读取数据
//            Thread t2 = new Thread(() -> {
//                if (flag) {
//                    a *= 1;
//                }
//                //指令重排
//                if (a == 0) {
//                    System.out.println("happen before a -->" + a);
//                }
//            });
//            t1.start();
//            t2.start();
//            t1.join();
//            t2.join();
        for (int i = 0;i < 100;i++) {
            a = 0;
            flag = false;
            Thread t1 = new Thread(() -> {
                a = 1;
                flag = true;
            });
            Thread t2 = new Thread(() -> {
                if (flag) {
                    a *= 1;
                }
                if (a == 0) {
                    System.out.println("happen before a -->" + a);
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }
    }
}
