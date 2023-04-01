public class Canine {

    protected double size;
    public Canine() { }
    public Canine(double size) {
        this.size = size;
    }
    public void wag() {
        System.out.println("wag");
    }
    
    public final void unleash() {  //cannot be overriden!
        System.out.println("lick nearest person regardless of whether s/he likes it or not");
    }
}