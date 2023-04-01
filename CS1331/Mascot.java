public abstract class Mascot {

//interface methods are called abstract methods
//they are public methods - regardless of if we add public or not

    public final double MAX_SPEED = 10;
    
    public abstract void celebrate();
    public abstract void whine();
    public abstract void flip();
    public abstract void run(int speed);
    public abstract String getName();
    
    public void clap() {
        System.out.println("clap clap clap");
    }
    
    

}