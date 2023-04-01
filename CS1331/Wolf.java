public class Wolf extends Canine {

    public void wag() {
        super.wag();
        super.wag();
        super.wag();
    }
    
    /* unleash is final - can't override
    public void unleash() {
        System.out.println("BITE!");
    }
     */
}