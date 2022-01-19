class Thread1 extends Thread {
    public void run(){
        System.out.println("Thread1 is runnning ....");
    }
}
class Thread2 extends Thread {
    public void run(){
        System.out.println("Thread2 is runnning ....");
    }
}
public class multiTasking extends Thread {
    public static void main(String[] args){
        Thread1 t1 =new Thread1();
        Thread2 t2 =new Thread2();
        Thread t3 =new Thread(){
            public void run(){
                System.out.println("Thread3 is running ...");
            }
        };

        Runnable r1 =new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread4 is running ...");
            }
        };

        Thread t4 =new Thread(r1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

