
public class YellowJacketCC {
    
    
    private double weight;
    private String name;
    private int id;
    private int energy;
    private double gpa;
    private boolean graduated;
    private String major;
    private String color;
    private double speed;
    
    
    private static final String COLOR = "black and yellow";
    private static final int LEGS = 6;
    private static final double DEFAULT_WEIGHT = 89;
    private static final double DEFAULT_GPA = 4.0;
    private static final int DEFAULT_ENERGY = 100;
    private static final int DEFAULT_SPEED = 7;
    

    private static final String DEFAULT_COLOR = "yellow and black";


    
    private static final String DEFAULT_NAME = "buzz";
    private static final String DEFAULT_MAJOR = "UNDECLARED";
    private static final boolean DEFAULT_GRADUATED = false;
    
    
    private static int population = 0;
    
    
    public static final double STING_CONSTANT = 0.99;
    
    
    public YellowJacketCC() { //yj1
        this(DEFAULT_NAME);
        
        System.out.println("yj1 done");
    }
    
    public YellowJacketCC(double weight)  { //yj2
        this(DEFAULT_NAME, weight);
        System.out.println("yj2 done");
    }
    
    public YellowJacketCC(String name) { //yj3
        this(name, DEFAULT_WEIGHT);
        System.out.println("yj3 done");
    }
    
    public YellowJacketCC(String name, double weight) { //yj4
        this(name, weight, DEFAULT_GPA);
        System.out.println("yj4 done");
    }
    
    public YellowJacketCC(String name, double weight, double gpa) { //yj4.5
        this(name, weight, gpa, DEFAULT_GRADUATED, DEFAULT_MAJOR, DEFAULT_ENERGY);
        System.out.println("yj4.5 done");
    }
    
    public YellowJacketCC(String name, double weight, double gpa, boolean graduated, String major, int energy) { //yj5
        this.name = name;
        this.weight = weight;
        this.gpa = gpa;
        population++;
        id = population;
        this.graduated = graduated;
        this.major = major;
        this.energy = energy;
        color = DEFAULT_COLOR;
        speed = DEFAULT_SPEED;

        System.out.println("yj5 done");
    }
    
    public void fly() {
        System.out.println("Weee");
    }
    
    
    
    public void sting(BullDog uga) {
        uga.vanish();
        
        weight = weight * STING_CONSTANT;
        System.out.println(uga + "disappears");
        
    }
    
    public void study() {
    }
    
    public static int getPopulation() {
        return population;
    }
    
    public void dance() {
        System.out.println("Weee");

    }
    public void flip() {
        System.out.println("Weee");

    }
    public int getEnergy() {
        return energy;
    }

    public double getWeight() {
        return weight;
    }

    
    public void run(int speed) {
        System.out.println("Zoom " + speed);

    }

    public String toString() {
        return id + " " + name + " " + weight;
        
    }
   
    
    public static void main(String[] args) {
        
        YellowJacketCC buzz1 = new YellowJacketCC();
        System.out.println(buzz1.getPopulation());//obj. reference is allowed but not elegant
       
        YellowJacketCC buzz2 = new YellowJacketCC(98);
        System.out.println(YellowJacketCC.getPopulation());
        
        
    
        
    }
    
}

