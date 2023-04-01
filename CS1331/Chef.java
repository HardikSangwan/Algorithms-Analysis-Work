/**
*
*Represents a Chef
*
*@author Hardik Sangwan
*@version 6.9
*
*/

public class Chef {

    private String name;
    private double noodlePackages;
    private double vegPackages;
    private double porkPackages;
    private double bowls;
    private static double totalBowls;

    /**
    *Creates a Chef with a given name and noodle packs
    *and default values for other variables
    *
    *@param name Chef's Name
    *@param noodlePackages Number of noodle packages
    */

    public Chef(String name, double noodlePackages) {
        this(name, noodlePackages, 0, 0);
    }

    /**
    *Creates a Chef with a given name, noodle packs and vegetable packs
    *and default values for other variables
    *
    *@param name Chef's Name
    *@param noodlePackages Number of noodle packages
    *@param vegPackages Number of vegetable packages
    */

    public Chef(String name, double noodlePackages, double vegPackages) {
        this(name, noodlePackages, vegPackages, 0);
    }

    /**
    *Creates a Chef with a given name, noodle, vegetable, and pork packs
    *
    *@param name Chef's Name
    *@param noodlePackages Number of noodle packages
    *@param vegPackages Number of vegetable packages
    *@param porkPackages Number of pork packages
    */

    public Chef(String name, double noodlePackages,
        double vegPackages, double porkPackages) {
        this.name = name;
        this.noodlePackages = noodlePackages;
        this.vegPackages = vegPackages;
        this.porkPackages = porkPackages;
    }

    /**
    *Makes a ramen bowl with noodles
    *@param noodlePackage number of noodle packs
    */

    public void cook(double noodlePackage) {
        this.cook(noodlePackage, 0, 0);
    }

    /**
    *Makes a ramen bowl with noodles and vegetables
    *@param noodlePackage number of noodle packs
    *@param vegPackage number of vegetable packs
    */

    public void cook(double noodlePackage, double vegPackage) {
        this.cook(noodlePackage, vegPackage, 0);
    }

    /**
    *Makes a ramen bowl with noodles, vegetables and pork
    *@param noodlePackage number of noodle packs
    *@param vegPackage number of vegetable packs
    *@param porkPackage number of pork packs
    */

    public void cook(double noodlePackage, double vegPackage,
        double porkPackage) {
        if (this.noodlePackages >= noodlePackage
            && this.vegPackages >= vegPackage
            && this.porkPackages >= porkPackage) {
            this.noodlePackages = this.noodlePackages - noodlePackage;
            this.vegPackages = this.vegPackages - vegPackage;
            this.porkPackages = this.porkPackages - porkPackage;
            this.bowls = this.bowls + 1;
            totalBowls = totalBowls + 1;
        }
    }

    /**
    *Restocks the chef's food supplies
    *@param noodlePackage number of noodle packs
    *@param vegPackage number of vegetable packs
    *@param porkPackage number of pork packs
    */

    public void restock(double noodlePackage,
        double vegPackage, double porkPackage) {
        this.noodlePackages = this.noodlePackages + noodlePackage;
        this.vegPackages = this.vegPackages + vegPackage;
        this.porkPackages = this.porkPackages + porkPackage;
    }

    /**
    *Returns the total number of ramen bowls made by all chefs
    *@return totalBowls Total Number of bowls
    */

    public static double getTotalBowls() {
        return totalBowls;
    }

    @Override
    public String toString() {
        return String.format("Chef %s has cooked %.0f bowls of ramen, and has"
            + " %.1f packs of noodles, %.1f vegetables, and %.1f packs of pork"
            + " leftover", this.name, this.bowls, this.noodlePackages,
            this.vegPackages, this.porkPackages);
    }
}
