
package model;
import java.util.Scanner;
import java.util.List;
import java.io.PrintWriter;
/**
 *
 * @author Jagoda Wiecek
 * In this file are definitions of functions needed in program.
 */
public class Functions {

    /**
     *upload titles from file to list line by line
     * @param titles to save titles from file
     * @param input scanner to read from outside
     */
    public void uploadData(List<String> titles,Scanner input)
    {
        while(input.hasNextLine())
        {
            titles.add(input.nextLine());
        }
    }
    /**
     * method to save titles from list to file
     * @param titles list where are titles of notices
     * @param save output of data
     */
    public void saveTitles(List<String> titles,PrintWriter save) 
    {

        for(String element : titles)
        {
            save.println(element);
        }
        save.close();
    }
    /**
     * check if there are titles in list with the same name as title from stream
     * @param title as string which will be checked
     * @param titles list of strings
     * @return false if one string from list will be equal to title
     */
    public Boolean checkTitles(String title,List<String> titles) 
    {

        for(String element:titles)
        {
            if(element.equals(title))
                return false;
        }
        return true;
    }
    /**
     * checks if in the string are only white signs, if yes, changes author = "anonym" 
     * Method also remove special signs in string and check if there is any normal word, if yes, return string without special signs
     * @param author string to check if it is alright
     * @return String or the same at the begining or "anonym"
     */
    public String checkWhiteSigns(String author)
    {
       try{ 
        if(author.replaceAll("[^a-zA-Z ]", "").trim().isBlank()) 
        {
            throw new Exception("WrongParameter");
        }}
       catch(Exception e)
       {
           return "anonym";
       }
       return author.trim().replaceAll("[^a-zA-Z ]", "");
    }
    
    /**
     * function for save data to file as notice
     * @param title as title of notice
     * @param author as author of notice
     * @param text informations which notice contains
     * @param newNotice new file, where params are saved
     */
    public void newNoticeMake(String title, String author,String text,PrintWriter newNotice) 
{
    newNotice.println(author); 
    newNotice.println(title);
    newNotice.println(text);
    newNotice.close();
}

}
