import java.io.*;
import java.util.*;
public class ExceptionsFileProp {
    
    public static void bar() throws FileNotFoundException {
        
        Scanner fileScan = new Scanner(new File("doesntExist.txt"));
        
    }
    public static void foo() {
        bar();
        
        
    }
    
    public static void main(String [] args) {
        
        foo();
        
    }
}
