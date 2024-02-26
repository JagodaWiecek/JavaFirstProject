
package model;

/**
 * @author Jagoda Więcek
 */
/**
 * Class to make my own exceptions
 */
public class MyException extends Exception{
    public MyException()
    {
        super("there is a problem with file");
    }
    public MyException(String messege)
    {
        super(messege);
    }
    
}
