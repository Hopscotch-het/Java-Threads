public class nameThread extends Thread {
    nameThread(String str){
        super(str);
    }
    public void run(){
        System.out.println("Thread "+Thread.currentThread().getName()+" is running....");
    }
    public static void main(String[] args){
        nameThread t1 = new nameThread("hello -1");
        nameThread t2 =new nameThread("hello -2");
        t1.start();
        t2.start();
        System.out.println("name of thread one is "+t1.getName());
        System.out.println("name of thread two is "+t2.getName());

        t1.setName("abc");
        System.out.println("After changing the name of thread1 from hello -1 to abc :"+t1.getName());
    }
}
