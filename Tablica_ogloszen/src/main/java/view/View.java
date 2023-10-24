
package view;
import java.util.ArrayList;
import java.util.List;

import model.NoticeBoard;
/**
 *
 * @author Jagoda Więcek
 */
public class View {
    
    void startInformations()
    {
        System.out.println("Hello \n ");
    }
    public void wrongParameters()
    {
        System.out.println("Wrong number of parameters. Only one needed. \ndisplay or add");
    }
    public void displayNoticebroard(NoticeBoard noticeboard)
    {
        for(int i =0;i<noticeboard.getSize();i++)
        {
           // System.out.println(noticeboard);
        }
    }
}
