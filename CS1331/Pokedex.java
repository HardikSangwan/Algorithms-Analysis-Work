import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
*Define a Pikachu object
*@author Hardik Sangwan
*@version 13.31
*/

public class Pokedex {
    private List<Pokemon> captured;

    /**
    *Create an empty Pokedex
    */
    public Pokedex() {
        captured = new ArrayList<Pokemon>();
    }

    /**
    *Create pokedex from text file
    *@param journal file to parse data from
    */
    public Pokedex(String journal) throws UnknownPokemonException,
    FileNotFoundException {
        File file = new File(journal);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] out = line.split(",");
                int level = Integer.parseInt(out[1]);
                int maxHealth = Integer.parseInt(out[2]);
                int speed = Integer.parseInt(out[3]);
                if (out[0].equals("Pikachu")) {
                    captured.add(new Pikachu(level, maxHealth, speed));
                } else if (out[0].equals("Ditto")) {
                    captured.add(new Ditto(level, maxHealth, speed));
                } else if (out[0].equals("Magikarp")) {
                    Magikarp magikarp = new Magikarp(level, maxHealth, speed);
                    if (out.length == 5) {
                        magikarp.setLuck(Double.parseDouble(out[4]));
                    }
                    captured.add(magikarp);
                } else {
                    throw new UnknownPokemonException("Unknown Pokemon");
                }
            }
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        }
    }

    /**
    *Adds p to captured
    *@param p Pokemon object to be added to pokedex
    */
    public void addPokemon(Pokemon p) {
        captured.add(p);
    }

    /**
    *Sorts captured by ordering of Pokemon
    */
    public void sort() {
        Collections.sort(captured);
    }

    /**
    *Creates a file from captured pokemon
    *@param recipient name of file
    */

    public void generateLetter(String recipient) throws FileNotFoundException {
        try {
            PrintWriter writer = new PrintWriter(recipient + ".txt");
            writer.println(this.toString());
            writer.close();
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found.");
        }
    }

    @Override
    public String toString() {
        String all = "";
        for (Pokemon p : captured) {
            all = all + p.toString() + "\n";
        }
        return all;
    }
}