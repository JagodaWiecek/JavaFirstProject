
package model;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author Jagoda Więcek
 */
public class Functions {
    
    public void uploadData(List<String> titles,Scanner input)
    {
        while(input.hasNextLine())
        {
            titles.add(input.nextLine());
        }
    }
    public void uploadNotices(List<String> titles, NoticeBoard noticeboard) throws FileNotFoundException
    {
        for(int i =0;i<titles.size();i++)
        {
            Scanner input = new Scanner(new File("Ogloszenia\\"+titles.get(i)));
            String author = new String(input.nextLine());
            String title = new String(input.nextLine());
            String text = new String(input.nextLine());
            noticeboard.addNotice(title, author, text);
        }
    }
}
