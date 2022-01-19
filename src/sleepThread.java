public class sleepThread extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        sleepThread t1 =new sleepThread();
        sleepThread t2 =new sleepThread();

        t1.start();
        t2.start();


        for(int i=0;i<10;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }

        //If we give negative time for sleep than it gives exception
        try{
            Thread.sleep(-100);
        }catch (Exception e){
            System.out.println(e);
        }

        //if we start any thread twice it throws exception
        try {
            t1.start();
        }catch(Exception e){
            System.out.println(e);
        }


        //problem you use run directly
        System.out.println("problems of directly using run()");
        sleepThread t3 = new sleepThread();
        sleepThread t4 = new sleepThread();

        t3.run();
        t4.run();
    }
}
