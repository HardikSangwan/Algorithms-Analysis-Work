import java.util.ArrayList;

public class ArrayListIntro {

    public static void main(String[] args) {
        
        
        ArrayList<MP3> lib = new ArrayList<MP3>();
        lib.add(new MP3("Believe", "Justin Bieber", 0.99, 4));
        lib.add(new MP3("One Time", "Justin Bieber", 0, 10));
        lib.add(new MP3("All Around the World", "Justin Bieber", 0.99, 4));
        //lib.add(new YellowJacket("justin"));  //will be caught at compile time
        for (MP3 song : lib) {
            System.out.println(song.play());
        }
   
    }
}