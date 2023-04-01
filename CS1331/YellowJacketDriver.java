public class YellowJacketDriver {


    public static void main(String[] args) {
        
        YellowJacket yj1 = new YellowJacket("Carla");
        System.out.println(yj1.getName() + " " + yj1.getId());
        yj1.setGpa(9.9);  //setter should ignore out of bounds input
        System.out.println(yj1.getGpa());

    
        YellowJacket yj2 = new YellowJacket("Carl");
        System.out.println(yj2.getName() + " " + yj2.getId());
        yj2.setGpa(3.9); //this input is valid
        System.out.println(yj2.getGpa());
        
    }
}