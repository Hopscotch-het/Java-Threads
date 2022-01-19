public class simpleThread extends Thread implements Runnable {
    public void run() {
        System.out.println("hello world");
    }
    public static void main(String args[]) {
        //using extends Thread
        simpleThread t1 = new simpleThread();
        System.out.println("After initializing thread t1: " + t1.getState());
        t1.start();
        System.out.println("After starting thread t1: " + t1.getState());

        //using implements Runnable
        simpleThread obj =new simpleThread();
        Thread t2=new Thread(obj);
        System.out.println("After initializing thread t2: " + t2.getState());
        t2.start();
        System.out.println("After starting thread t2: " + t2.getState());

        //using Thread(String name)
        Thread t3 =new Thread("thread3");
        t3.start();
        System.out.println("After starting thread t3: " + t3.getState());
        System.out.println("name of  t3: " + t3.getName());

        //using Thread(Runnable r,String name)
        Runnable r1 = new simpleThread();
        Thread t4 =new Thread(r1,"new thread");
        t4.start();
        System.out.println("After starting thread t4: " + t4.getState());
        System.out.println("name of  t4: " + t4.getName());
    }
}

