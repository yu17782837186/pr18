package cn.com.thread;

public class TestSingleExample {
    private static volatile TestSingleExample instance;
    private TestSingleExample() {

    }
    public static TestSingleExample getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (TestSingleExample.class) {
            if (instance == null) {
                instance = new TestSingleExample();
            }
            return instance;
        }
    }
//    //2 提供私有的静态属性
//    private static volatile TestSingleExample instance; //没有new对象 懒汉式
//    //没有volatile其它线程可能会访问一个没有初始化的对象
//    //1 构造器私有化
//    private TestSingleExample() {
//
//    }
//    //3 提供公共的静态方法  获取属性
//    public static TestSingleExample getInstance(long time) {
//        //再次检测
//        if (instance != null) {//避免不必要的同步,已经存在对象
//            try {
//                Thread.sleep(time);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return instance;
//        }
//        synchronized (TestSingleExample.class) {
//            if (instance == null) {
//                instance = new TestSingleExample();  //发生指令重排 可能返回一个空的对象
//                //new一个对象会做的三件事情
//                //1 开辟空间 2 初始化对象信息 3 返回对象的地址给引用
//            }
//            return instance;
//        }
//    }
//    public static TestSingleExample getInstance2(long time) {
//        if (instance == null) {
//            try {
//                Thread.sleep(time);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            instance = new TestSingleExample();  //发生指令重排 可能返回一个空的对象
//            //new一个对象会做的三件事情
//            //1 开辟空间 2 初始化对象信息 3 返回对象的地址给引用
//        }
//        return instance;
//    }
    public static void main(String[] args) {
        //测试懒汉式单例模式加入并发控制  保证在多线程环境下对外只存在一个对象
        //1 构造器私有化  避免外部new构造器
        //2 提供私有的静态属性  存储对象的地址
        //3 提供公共的静态方法  获取属性
//        Thread t = new Thread(()->{
//            System.out.println(TestSingleExample.getInstance(500));
//        });
//        t.start();
//        System.out.println(TestSingleExample.getInstance(1000));
        Thread t = new Thread(()->{
            System.out.println(TestSingleExample.getInstance());
        });
        t.start();
        System.out.println(TestSingleExample.getInstance());
    }
}
