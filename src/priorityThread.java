public class priorityThread extends Thread {
    public void run(){
        System.out.println("Thread is running...");
    }
    public static void main(String[] args){
        priorityThread t1 =new priorityThread();
        priorityThread t2 =new priorityThread();

        //getting the priority of the threads
        System.out.println("Priority of thread t1 is: "+t1.getPriority());
        System.out.println("Priority of thread t2 is: "+t2.getPriority());
        System.out.println("Priority of thread main thread  is: "+Thread.currentThread().getPriority());

        //setting the priority of the thread
        t1.setPriority(10);
        t2.setPriority(1);
        Thread.currentThread().setPriority(7);

        System.out.println("Priority of thread t1 is: "+t1.getPriority());
        System.out.println("Priority of thread t2 is: "+t2.getPriority());
        System.out.println("Priority of thread main thread  is: "+Thread.currentThread().getPriority());

        try {
            t1.setPriority(20);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}