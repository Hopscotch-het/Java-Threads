import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{

    private String message;
    public WorkerThread(String message){
            this.message=message;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+" started = "+message);
        processmessage();
        System.out.println(Thread.currentThread().getName()+" ended");
    }
    public void processmessage(){
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

public class threadPool {
    public static void main(String[] args){
        ExecutorService executor =Executors.newFixedThreadPool(5);
        for(int i=1;i<=10;i++){
            Runnable worker = new WorkerThread(""+i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated());
        System.out.println("Finished all threads");
    }
}
