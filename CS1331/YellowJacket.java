public class YellowJacket {

    private String name;
    private int id;
    private double gpa;
    private static int population = 0;
    public static final double MAX_GPA = 4.0; //static constant
    
    public YellowJacket(String name) {
        this.name = name;
        gpa = MAX_GPA;
        population = population + 1;
        id = population;
    }

    public YellowJacket(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
        population = population + 1;
        id = population;
        
    }

    public String getName() {
        return name;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa) {
        if ((gpa >= 0) && (gpa <= MAX_GPA)) {
            this.gpa = gpa;
        }
    }
    
    public int getId() {
        return id;
    }


}