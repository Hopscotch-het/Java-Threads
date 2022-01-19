class Table1{
    synchronized static void print(int n){
        System.out.println("Table1 of "+n);
        for(int i=1;i<5;i++){
            System.out.println(n*i);
            try {
                Thread.sleep(100);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
class ThreadA extends Thread{
    public void run(){
        Table1.print(2);
    }
}

class ThreadB extends Thread{
    public void run(){
        Table1.print(3);
    }
}

public class staticSynchronization {
    public static  void main(String[] args){
        ThreadA t1=new ThreadA();
        ThreadB t2 =new ThreadB();
        Thread t3 =new Thread(){
            public void run(){
                Table1.print(5);
            }
        };
        Thread t4 =new Thread(){
            public void run(){
                Table1.print(7);
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
