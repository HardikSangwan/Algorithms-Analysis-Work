public class ExceptionsIntro {
    
    
    
    public static void main(String[] args) {
        
        try {
            int x = 9/0;
            System.out.println("x value is: " + x);
        }
        catch (ArithmeticException ae) {
            System.out.println("bad division");
        }
        
        
        int[] scores = null;
        int y = scores[0];
        System.out.println("stored 1st score");
    
    System.out.println("end");
    
}
}