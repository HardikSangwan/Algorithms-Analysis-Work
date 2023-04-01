/*
 *Defining a Course object with ability to retrieve and set values.
 * @author Hardik Sangwan
 */
public class Course {
    //variables - Course Name, Location and Credit hours
    private String name;
    private String location;
    private int hours;

    //constructor for all three instance variables
    public Course(String name, String location, int hours) {
        this.name = name;
        this.location = location;
        this.hours = hours;
    }

    //setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }

    //getter methods
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public int getHours() {
        return hours;
    }

    //toString method
    public String toString() {
        return name + " at " + location + ", " + hours + " hours.\n";
    }
}
