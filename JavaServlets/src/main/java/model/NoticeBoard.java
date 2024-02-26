
package model;
import java.io.File;
import static java.io.File.separator;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Jagoda Wiecek
 */

/**
* Class Noticeboard contains objects of class Notice and operate on them
 */
public class NoticeBoard {
    List<Notice> noticeBoard = new ArrayList<Notice>();
    
    /**
     * adding three parameters as one object to list
     * @param title string as title
     * @param author string as author
     * @param text string as text
     */
public void addNotice(String title, String author,String text) 
{
    Notice obj = new Notice(title,author,text);
    noticeBoard.add(obj);
}
/**
 * Method which uses varargs to add more notices in one method
 * @param notices more objects added to class
 */
public void addNotice(Notice...notices)
{
    for(Notice element:notices)
    {
        noticeBoard.add(element);
    }
}
/*
    method to get list size
*/
public int getSize()
{
    return noticeBoard.size();
}
/**
 * method to get a certain object under index number i
 * @param i index of needed object in list
 * @return a onject in list
 */
public Notice getObject(int i)
{
    return noticeBoard.get(i);
}
/**
 * method to get variable author from certain object under intex number i
 * @param i index of needed object in list
 * @return param String author from object Notice
 */
public String getObjectAuthor(int i) 
{
    return getObject(i).getAuthor();
}
/**
 * method to get variable @param title from certain object under intex number i
 * @param i index of needed object in list
 * @return String title from object Notice 
 */
public String getObjectTitle(int i)
{
    return getObject(i).getTitle();
}
/** 
 * method to get variable @param text from certain object under intex number i
 * @param i index of needed object in list
 * @return String text from object Notice
 */
public String getObjectText(int i)
{
    return getObject(i).getText();
}
/**
 * Method to read data from files and save them to variables @param noticeboard
 * @param titles list of strings, it contains titles of notices to correctly find files
 * @param noticeboard variable where all parameters are placed in method
 * @throws FileNotFoundException to catch if file exist
 */
public void uploadNotices(List<String> titles, NoticeBoard noticeboard) throws FileNotFoundException
    {
        for(int i =0;i<titles.size();i++)
        {
            Scanner input = new Scanner(new File("/C:/Users/jwiec/Desktop/ProgramyJava/JavaServlets/Ogloszenia"+separator+titles.get(i)+".txt"));
            //System.out.println(titles.get(i)+".txt");
            String author = new String(input.nextLine());
            String title = new String(input.nextLine());
            String text = new String(input.nextLine());
            noticeboard.addNotice(title, author, text);
        }
        
    }
/**
 * to give whole data from list in class
 * @return list
 */
public List<Notice> getDatas()
{
    return noticeBoard;
}

}
