public class joinThread extends Thread {
    public void run(){
        System.out.println("The current thread name is : "+Thread.currentThread().getName());
        for (int i=0;i<2;i++){
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
    public static void  main(String args[]){
        joinThread t1 = new joinThread();
        joinThread t2 = new joinThread();
        joinThread t3 = new joinThread();

        t1.start();
        try{
            System.out.println("The current thread name is : "+Thread.currentThread().getName());
            t1.join();
        }catch (Exception e){
            System.out.println(e);
        }

        t2.start();
        t3.start();
        try{
            System.out.println("The current thread name is : "+Thread.currentThread().getName());
            t2.join(500);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
