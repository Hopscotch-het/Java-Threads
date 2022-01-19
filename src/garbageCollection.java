public class garbageCollection {
    public void finalize(){
        System.out.println("object is garbage collected");
    }
    public static void main(String[] args){
        garbageCollection g1 =new garbageCollection();
        garbageCollection g2 =new garbageCollection();

        g1=null;
        g2=null;

        System.gc();
    }
}
