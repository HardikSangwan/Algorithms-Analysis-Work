/**
*Define a, Unknown Pokemon Exception
*@author Hardik Sangwan
*@version 13.31
*/

public class UnknownPokemonException extends Exception {

    /**
    *Creates an exception
    */
    public UnknownPokemonException() {
        this(" ");
    }

    /**
    *Creates an exception
    *@param message Message to be shown
    */
    public UnknownPokemonException(String message) {
        super(message);
    }
}