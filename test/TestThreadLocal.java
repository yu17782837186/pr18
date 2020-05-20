package cn.com.thread;

public class TestThreadLocal {
    //private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    //更改初始值
//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
//        @Override
//        protected Integer initialValue() {
//            return 200;
//        }
//    };
    //private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->150);
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };
    public static void main(String[] args) {
        //ThreadLocal:每个线程自身的存储本地，局部区域
        //get/set/initialValue
        //获取值
//        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
//        //设置值
//        threadLocal.set(0);
//        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
//        new Thread(new MyRun()).start();
//        new Thread(new MyRun()).start();
//        for (int i = 0; i < 5; i++) {
//            new Thread(new MyRun()).start();
//        }
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }
    public static class MyRun implements Runnable {
        public MyRun() {
            threadLocal.set(15);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }

        @Override
        public void run() {
//            Integer left = threadLocal.get();
//            System.out.println(Thread.currentThread().getName()+"得到了-->"+left);
//            threadLocal.set(left-1);
//            System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());
//            threadLocal.set((int) (Math.random()*99));
//            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }
    }
}
