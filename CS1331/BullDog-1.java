
public class BullDog t implements Comparable<BullDog> {
    
    
    private double weight;
    private String name;
    private double gpa;
    private boolean stung;
    
    private static int population = 0; //(not an inst. var) start with 0 but increment in constructor
    
    public static final double MAX_GPA = 4.0;
    
    
    public BullDog(String name, double weight) {
        this.name = name;
        this.weight =  weight;
        gpa = MAX_GPA;
        stung = false;
        
        //population = population + 1;
        population++;  //also allowed is population--
        //population += 1 ; also allowed are population -=, *=, /=
    }
    
    public static int getPopulation() {
        return population;
    }
    
    
    public boolean isStung() {  //accessor for boolean: isPropertyName
        return stung;
    }
    
    public String getName() {
        return name;
    }
    public void vanish() {
        if (!stung) {
            weight = 0;
            stung = true;
            population--;
        }
    }
    
    public void cheer() {
        System.out.println("bark");
    }
    
    
    public String toString() {
        return name + ", weight=" + weight + ", stung=" + stung;
        
        
    }  public void celebrate() {
        System.out.println(name + " runs across the screen");
    }
    
    public void whine() {
        System.out.println("bite the crowd");
    }
    
    public void flip() {
        
    }
    public void run(int speed) {
        
        
    }
    
    public int compareTo(BullDog bd) {
        
        if (stung && bd.stung)
            return 0;
        else {
            if (stung)
                return -1;
            else if (bd.stung)
                return 1;
            else {
                
                
                if (weight < bd.weight)
                    return -1;
                else if (weight == bd.weight)
                    return 0;
                else
                    return 1;
                
            }
        }
        
    }
}