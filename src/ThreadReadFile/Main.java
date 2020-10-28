package ThreadReadFile;

public class Main {
    public static void main(String[] args) {
        readAndWrite raw = new readAndWrite();
        //测试多线程执行的效率与线程的个数量的关系
        long lon = System.currentTimeMillis();
        //开启多个线程来执行读取文件的操作
        Thread threadA = new Thread(raw,"线程A");
        threadA.start();
        Thread threadB = new Thread(raw,"线程B");
        threadB.start();
        Thread threadC = new Thread(raw,"线程C");
        threadC.start();
        Thread threadD = new Thread(raw,"线程D");
        threadD.start();
        try{
            threadA.join();//加入到主线程 使主线程等待 便于测试多线程的效率
            threadB.join();
            threadC.join();
            threadD.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        long lon1 = System.currentTimeMillis();
        System.out.println("耗时间为： " + (lon1-lon) + "毫秒");
    }
}
