
package projectTests;
import org.junit.jupiter.api.Test;
import model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Jagoda Więcek
 */
public class tests {
    
    Notice notice = new Notice("temat","author","text");
    NoticeBoard noticeboard = new NoticeBoard();
    Functions function = new Functions();
    
    @Test
    /**
     * @Test to check if created object Noticeboard is null
     */
    public void isItNull()
    {
       
        assertNotNull(noticeboard,"is null");
    }
    
    @Test
    /**
     * @Test to check if vars are added properly to list noticeboard
     */
    public void testAddToNoticeboardTitle()
    {
        noticeboard.addNotice("tytul", "autor", "tekst");
        assertEquals("tytul",noticeboard.getObjectTitle(0),"Variable values ​​are not the same!");
        assertEquals("autor",noticeboard.getObjectAuthor(0),"Variable values ​​are not the same!");
        assertEquals("tekst",noticeboard.getObjectText(0),"Variable values ​​are not the same!");
    }
    @Test
    /**
     * @Test to check if varargs are added properly and method .getSize() return right number
     */
    public void testAddMethodWithVarargs()
    {
        noticeboard.addNotice(notice, notice,notice);
        assertEquals(3,noticeboard.getSize(),"Wrong adding method");
    }
    
    //Testy parametryczne
    /**
     * @ParameterizedTest which check if method "checkWhiteSigns" works properly.
     * It should remove all white signs and special signs and check if there are any words. If no, return "anonym"
     * @param author is string, it can't be empty or contains white and special signs, if it is, it is changed to "anonym"
     */
    @ParameterizedTest
    @ValueSource(strings ={"","    ","++_-@"}) 
    public void testAutor_is_anonym(String author)
    {
        assertEquals("anonym",function.checkWhiteSigns(author),"Variable values ​​are not the same!");
    }
    /**
     * @ParameterizedTest to check if function checkWhiteSigns remove special signs properly from strings
     * @param author it is string to check
     */
    @ParameterizedTest
    @ValueSource(strings ={"Anna","Anna##%$","#@@#$&@#%&*","Klara@@ Tracz:..!"})
    public void testProperAuthor(String author)
    {
        Pattern pattern = Pattern.compile("[^a-zA-Z ]");
        Matcher matcher = pattern.matcher(function.checkWhiteSigns(author));
        assertEquals(false,matcher.find(),"There are special signs in string");
    }
    /**
     * @ParameterizedTest to check if the list contains words from input stream, if yes, return false
     * @param title parameter to check
     */
    @ParameterizedTest
    @ValueSource(strings = {"data","krab","java"})
    public void testRepeatedTitlesTrue(String title)
    {
        List<String> titles = new ArrayList();
        titles.add("JAVA");
        titles.add("tytul");
        titles.add("ameba");
        assertEquals(true, function.checkTitles(title, titles), "There are the same titles");
    }
    
    
}
