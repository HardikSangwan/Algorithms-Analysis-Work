/**
*
*Represents a bowl of ramen
*
*@author Hardik Sangwan
*@version 6.9
*
*/

public class RamenBowl {
    private double noodlePacks;
    private double vegPacks;
    private double porkPacks;

    /**
    *Creates a Ramen Bowl with all required parameters
    *@param noodlePacks number of noodle packs
    *@param vegPacks number of vegetable packs
    *@param porkPacks number of pork packs
    *
    */

    public RamenBowl(double noodlePacks, double vegPacks, double porkPacks) {
        this.noodlePacks = noodlePacks;
        this.vegPacks = vegPacks;
        this.porkPacks = porkPacks;
    }

    /**
    *Creates a Ramen Bowl with default values
    */

    public RamenBowl() {

    }


    @Override
    public String toString() {
        String displayvar = "Bowl containing \n";
        if (this.noodlePacks == 0 && this.vegPacks == 0
            && this.porkPacks == 0) {
            displayvar = "An empty Bowl.";
        }
        if (this.noodlePacks != 0) {
            displayvar = displayvar + this.noodlePacks
                + " packages of noodles. \n";
        }
        if (this.vegPacks != 0) {
            displayvar = displayvar + this.vegPacks
                + " packages of vegetables. \n";
        }
        if (this.noodlePacks != 0) {
            displayvar = displayvar + this.porkPacks
                + " packages of pork. \n";
        }
        return displayvar;
    }
}
