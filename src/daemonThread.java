public class daemonThread extends Thread{
    public void run(){
        if(Thread.currentThread().isDaemon())
            System.out.println(Thread.currentThread().getName()+" is Daemon thread");
        else
            System.out.println(Thread.currentThread().getName()+" is user thread");
    }
    public static void  main(String[] args){
        daemonThread t1 =new daemonThread();
        daemonThread t2 =new daemonThread();

        t1.setDaemon(true);

        t1.start();
        t2.start();
        try {
            t2.setDaemon(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
