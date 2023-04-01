public class YellowJacket extends Mascot implements Comparable<YellowJacket> {

    private String name;
    private int id;
    private double gpa;
    private double weight;
    private static int population = 0;
    public static final double MAX_GPA = 4.0; //static constant
    public static final double STING_CONSTANT = 0.97;
    public static final double DEFAULT_WEIGHT = 89;
    public static final String DEFAULT_NAME = "buzz";


    public YellowJacket(String name) {
        this(name, MAX_GPA);
    }
    
    public YellowJacket (double weight) {
        this (DEFAULT_NAME, MAX_GPA);
        this.weight = weight;
        /*
         we will overwrite the weight done in the above this call
         showing the value of calling this() 1st before anything
         else in the constructor
         */
    }

    public YellowJacket(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
        population = population + 1;
        id = population;
        weight = DEFAULT_WEIGHT;

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
    
    
    public static int getPopulation() {
        return population;
    }
    
    public int getId() {
        return id;
    }

    public void sting(BullDog uga) {
        uga.vanish();
        
        weight = weight * STING_CONSTANT;
        System.out.println(uga + " poof disappears");  //BullDog toString() called
        
    }
    
    public void celebrate() {
        System.out.println(name + " flies across the screen");
    }
    
    public void whine() {
        System.out.println("sting the crowd");
    }
    
    public void flip() {
    
    }
    public void run(int speed) {
        if (speed < MAX_SPEED) {
            System.out.println("run");
        }
        else {
            System.out.println("run run run");

        }
    }
    
    public String toString() {
        return name + " " + weight + " " + gpa;
        
    }
    
    public int compareTo(YellowJacket yj) {
        
        if (weight < yj.weight)
            return -1;
        else if (weight == yj.weight)
            return 0;
        else
            return 1;
        
        
       /*Not going to work given ceil rules on negative:
        return ((int)(Math.ceil(weight - yj.weight)));
        */
    }

    public static void main(String[] args) {
        
        System.out.println(YellowJacket.getPopulation());
        
        YellowJacket buzz1 = new YellowJacket("Buzz", 3.8);
        System.out.println(buzz1.getPopulation());//obj. reference is allowed but not elegant
        buzz1.clap();
        /*
        
        YellowJacket buzz2 = new YellowJacket("Carla");
        System.out.println(YellowJacket.getPopulation());
        
        
        BullDog bd1 = new BullDog("uga", 42);
        bd1.cheer();
        
        BullDog bd2 = new BullDog("agu", 24);
        System.out.println(BullDog.getPopulation());
        System.out.println(bd2);
        
        buzz1.sting(bd1);
        System.out.println("Bulldog population: " + BullDog.getPopulation());

        buzz1.sting(bd1);
        buzz1.sting(bd1);
        buzz1.sting(bd1);
        buzz1.sting(bd1);
        System.out.println("Bulldog population: " + BullDog.getPopulation());

        buzz1.sting(bd2);
        System.out.println("Bulldog population: " + BullDog.getPopulation());
        
        */
        
    }
    
    
}