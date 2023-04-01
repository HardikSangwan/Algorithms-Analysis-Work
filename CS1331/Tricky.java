public class Tricky {
    public static void doit(int x, double y){
        System.out.println("doIt(int x, double y)");
    }
    public static void doit(double x, int y){
        System.out.println("doIt(double x, int y)");
    }
    public static void main(String[] args) {
        doIt(1,1);
    }
}
