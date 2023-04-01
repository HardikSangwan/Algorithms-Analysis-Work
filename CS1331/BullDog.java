
public class BullDog  {
    
    
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
    }
    
}