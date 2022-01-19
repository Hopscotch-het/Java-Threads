public class multiTasking2 {
    int counter=1;
    static int NUM;
    public void displayOdd(){
        synchronized (this){
            while(counter<NUM){
                while(counter%2==0) {
                    try {
                        wait();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
                System.out.println(counter);
                counter=counter+1;
                notify();
            }
        }
    }
    public void displayEven(){
        synchronized (this){
            while(counter<NUM){
                while(counter%2==1){
                    try{
                        wait();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
                System.out.println(counter);
                counter=counter+1;
                notify();
            }
        }
    }
    public static void main(String[] args){
        NUM=20;
        multiTasking2 mt =new multiTasking2();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                mt.displayOdd();
            }
        };
        Runnable r2 =new Runnable() {
            @Override
            public void run() {
                mt.displayEven();
            }
        };

        Thread t1 =new Thread(r1);
        Thread t2 =new Thread(r2);

        t1.start();
        t2.start();
    }
}
