public class RaceBoat extends Boat implements Comparable<RaceBoat> {
    private int maxSpeed;
    private int length;
    private int seats;
    public void go() {
        System.out.println("GO FAST!");
    }
    public int compareTo(RaceBoat r) {
        return maxSpeed - r.maxSpeed;
    }
}
