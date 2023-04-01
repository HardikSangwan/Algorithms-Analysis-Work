public class CommandLineArgsTest {

    public static void main(String[] args) {
        
        /*
        String[] team = {"Cavs", "Warriors"};
        Die.main(team);
         */
        int sum = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
        System.out.println(sum);
    }
}