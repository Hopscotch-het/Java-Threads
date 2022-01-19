class Sender{
    public void senderMsg(String msg){
        System.out.println("\nSending message: "+msg);
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n"+msg+" sent.");
    }
}
class SenderWThread extends Thread{
    private String msg;
    Sender sd;
    SenderWThread(String msg,Sender sd){
        this.msg=msg;
        this.sd=sd;
    }
    public void run(){
        synchronized (sd) {
            sd.senderMsg(msg);
        }
    }
}

public class synchronizedBlock {
    public static void main(String[] args){
        Sender s=new Sender();
        SenderWThread s1 =new SenderWThread("abc",s);
        SenderWThread s2 =new SenderWThread("xyz",s);

        s1.start();
        s2.start();
//
//        try{
//            s1.join();
//            s2.join();
//        }catch (Exception e){
//            System.out.println(e);
//        }


    }
}
