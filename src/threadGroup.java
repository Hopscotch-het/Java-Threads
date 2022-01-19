public class threadGroup implements Runnable {
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args){
        threadGroup runnable =new threadGroup();
        ThreadGroup tg1 =new ThreadGroup("abc");

        Thread t1 =new Thread(tg1,runnable,"a");
        Thread t2 =new Thread(tg1,runnable,"b");
        Thread t3 =new Thread(tg1,runnable,"c");
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Thread Group name: "+tg1.getName());
        System.out.println("count of active thread in tg1: "+tg1.activeCount());

        tg1.list();

        //using enumerate()
        Thread[] arr = new Thread[tg1.activeCount()];
        int cnt = tg1.enumerate(arr);
        for(int i=0;i<cnt;i++){
            System.out.println("Thread "+arr[i].getName()+" is found.");
        }
        
        //getting the max priority using getMaxPriority()
        int p = tg1.getMaxPriority();
        System.out.println("Max priority of tg1 is : "+p);

        //creating group 2
        ThreadGroup tg2=new ThreadGroup(tg1,"xyz");
        Thread t4 =new Thread(tg2,runnable,"x");

        //creating the group 3
        ThreadGroup tg3=new ThreadGroup(tg1,"mnp");
        Thread t5 =new Thread(tg3,runnable,"m");

        //using method activeGroupCount()
        System.out.println("count of active group: "+tg1.activeGroupCount());


        //using destroy() method
        tg3.destroy();
        System.out.println("After destroying tg3,count of active group: "+tg1.activeGroupCount());

        //checking is tg3 destroyed
        System.out.println("Is tg3 destroyed : "+tg3.isDestroyed());

        //getting the parent of the group
        System.out.println("Thread Group "+tg2.getName()+" parent is : "+tg2.getParent().getName());
        System.out.println("Thread Group "+tg3.getName()+" parent is : "+tg3.getParent().getName());

        //Checking for daemon group
        if(tg1.isDaemon())
            System.out.println("tg1 is daemon");
        else
            System.out.println("tg1 is not daemon");

    }
}
