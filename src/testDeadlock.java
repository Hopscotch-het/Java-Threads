public class testDeadlock extends  Thread{
    public static void main(String[] args){
        String s1 ="abc";
        String s2 ="xyz";

        Thread t1 =new Thread(){
            public void run(){
                synchronized (s1){
                    System.out.println("Thread 1 :locked resource 1");
                    try{
                        Thread.sleep(100);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    synchronized (s2){
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };

        Thread t2 =new Thread(){
            public void run(){
                synchronized (s1){
                    System.out.println("Thread 2 :locked resource 1");
                    try{
                        Thread.sleep(100);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    synchronized (s2){
                        System.out.println("Thread 2: locked resource 2");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
