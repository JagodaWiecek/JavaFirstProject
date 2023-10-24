
package model;

/**
 *
 * @author Jagoda Więcek
 * Class with variables 
 * title as the title of notice,
 * text as informations contained in notice
 * and author as information who is the notice from
 */
public class Notice {
    
    String title;
    String text;
    String author;
    
    String getTitle()
    {
        return this.title;
    }
    String getText()
    {
        return this.text;
    }
    String getAuthor()
    {
        return this.author;
    }
    void setTitle(String title)
    {
        this.title = title;
    }
    void setText(String text)
    {
        this.text = text;
    }
    void setAuthor(String author)
    {
        this.author = author;
    }
    Notice(String title, String author,String text) ///constuctor with three parameters
    {
        setTitle(title);
        setAuthor(author);
        setText(text);
    }
    Notice(String title,String text) ///constuctor with two parameters
    {
        setTitle(title);
        setText(text);
        setAuthor("anonym"); ///if there is no name of author, variable is automatically as anonym
    }
}
