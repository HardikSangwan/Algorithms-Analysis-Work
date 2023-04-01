public class Food implements Comparable{
    private double servings;
    private double fat;
    private double carbs;
    private double protein;
    private double tastiness;

    public Food(double servings, double fat, double carbs, double protein, double tastiness) {
        this.servings = servings;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
        this.tastiness = tastiness;
    }

    public Food(double fat, double carbs, double protein) {
        this(1, fat, carbs, protein, 5.5);
    }

    public double getTastiness() {
        return tastiness;
    }

    public double caloriesPerServing() {
        double calories = fat * 9 + carbs * 4 + protein * 4;
        return calories / servings;
    }

    public String toString() {
        return ("Servings: " + servings + "Fat: " + fat + "Carbs: " + carbs + "Protein: " + protein + "Tastiness: " + tastiness);
    }

    public int compareTo(Object other) {
        if (other instanceof Food) {
            Food a = (Food) other;
            return (int) tastiness - (int) a.getTastiness();
        }
        return 0;
    }

    public void preserve(int days) {
        double decay = 0.05 * days;
        tastiness -= tastiness * decay;
    }

    public void preserve(int days, Additive additive) {
        double decay = additive.getDailyReduction() * days;
        tastiness -= tastiness * decay;
    }

    private class Additive {
        double decay;
        public double getDailyReduction() {
            return decay;
        }

        public Additive() {
            decay = 1.0;
        }
    }

    public static void main(String[] args) {
        Food a = new Food(1, 2, 3, 4, 5);
        Food b = new Food(1, 2, 3, 4, 6);
        System.out.println(a.compareTo(b));
    }
}