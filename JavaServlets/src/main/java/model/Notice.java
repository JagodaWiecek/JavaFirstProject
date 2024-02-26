
package model;

/**
 *
 * @author Jagoda Wiecek
 * Class with variables 
 * title as the title of notice,
 * text as informations contained in notice
 * and author as information who is the notice from
 */
public class Notice {
    
    String title;
    String text;
    String author;
    /**
     * Getter of @param title
     * @return String title
     */
    public String getTitle()
    {
        return this.title;
    }
    /**
     * Getter of @param text
     * @return String text
     */
    public String getText()
    {
        return this.text;
    }
    /**
     * Getter of @param author
     * @return 
     */
    public String getAuthor()
    {
        return this.author;
    }
    /**
     * Setter of @param title
     * @param title it set as param of class
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    /**
     * Setter of @param text
     * @param text it set as param of class
     */
    public void setText(String text)
    {
        this.text = text;
    }
    /**
     * Setter of @param author
     * @param author it set as param of class
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }
    /**
     * Constructor with three parameters
     * @param title is to set a param of class title
     * @param author is to set a param of class author
     * @param text is to set a param of class text
     */
    public Notice( String title,String author,String text)
    {
        setAuthor(author);
        setTitle(title);
        setText(text);
    }
}
