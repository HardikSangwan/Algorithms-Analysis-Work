public class Car implements Comparable<Car> {

    private int horsePower;
    private int yearBought;
    private String name;

    public Car(int horsePower, int yearBought, String name) {
        this.horsePower = horsePower;
        this.yearBought = yearBought;
        this.name = name;
    }

    public int compareTo(Car otherCar) {
        return otherCar.horsePower - this.horsePower;
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof Car)) {
            return false;
        }
        Car otherCar = (Car) otherObject;
        return (otherCar.horsePower == this.horsePower) && (otherCar.yearBought == this.yearBought) && (otherCar.name.equals(this.name));
    }

    public static void main(String[] args) {
        Car cCar = new Car(10, 1342, "Toyota");
        Car bCar = new Car(10, 1342, "Toyota");

        System.out.println(cCar == bCar);
        System.out.println(cCar.equals(bCar));
    }
}