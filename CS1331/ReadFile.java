import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "goodbye.txt";
        Scanner scan = new Scanner(new File(path));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println(line);
        }
    }
}
