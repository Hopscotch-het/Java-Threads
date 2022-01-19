class Table extends Thread{
    synchronized public void printTable(int n){
        System.out.println("Table of "+n);
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
        }
    }
}
public class synchronizedMethod {
    public static void main(String[] args){
        Table t =new Table();
        Thread t1=new Thread(){
            public void run(){
                t.printTable(5);
            }
        };
        Thread t2 =new Thread(){
            public void run(){
                t.printTable(100);
            }
        };

        t1.start();
        t2.start();
    }
}
