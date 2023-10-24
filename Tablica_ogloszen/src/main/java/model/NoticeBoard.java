
package model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jagoda Więcek
 * 
 */
public class NoticeBoard {
    List<Notice> noticeBoard = new ArrayList<Notice>();
    
void addNotice(Notice obj) ///adding new,already created, object to list
{
    noticeBoard.add(obj);
}
void addNotice(String title, String author,String text) ///adding three parameters as one object, to list
{
    Notice obj = new Notice(title,author,text);
    noticeBoard.add(obj);
}
void addNotice(String title,String text)///adding two parameters as object to list, where parameter "author" is anonym
{
    Notice obj = new Notice(title,text);
    noticeBoard.add(obj);
}
public int getSize()
{
    return noticeBoard.size();
}
public Notice getObject(int i)
{
    return noticeBoard.get(i);
}
public String getObjectAuthor(int i)
{
    return getObject(i).getAuthor();
}
public String getObjectTitle(int i)
{
    return getObject(i).getTitle();
}
public String getObjectText(int i)
{
    return getObject(i).getText();
}
}
