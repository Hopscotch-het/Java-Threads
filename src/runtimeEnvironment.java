public class runtimeEnvironment {
    public static void main(String[] args)throws Exception{
        Runtime r = Runtime.getRuntime();
        System.out.println("Number of available processors: "+r.availableProcessors());
        System.out.println("Max Memory: "+r.maxMemory());
        System.out.println("Free Memory: "+r.freeMemory());
        for(int i=0;i<1000;i++){
         new runtimeEnvironment();
        }
        System.out.println("Free Memory after 1000 instance: "+r.freeMemory());
        System.gc();
        System.out.println("After gc(), Free Memory: "+r.freeMemory());
    }
}
