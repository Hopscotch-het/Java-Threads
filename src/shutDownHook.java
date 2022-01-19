class myThread extends Thread{
    public void run(){
        System.out.println("Shut down hook task completed");
    }
}
public class shutDownHook{
    public static void main(String[] args){
        Runtime r =Runtime.getRuntime();
        myThread t=new myThread();
        r.addShutdownHook(t);

        System.out.println("now main sleeping ... press ctrl+c to exit ");
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println(e);
        }
        r.removeShutdownHook(t);
        System.out.println("hello");
    }
}
