import com.pavel.textparser.task.TaskNumberOne;
import com.pavel.textparser.entity.DividedText;
import com.pavel.textparser.logics.TextManager;
import com.pavel.textparser.task.TaskNumberTwo;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;import java.lang.String;


public class MainApplication {

    public static Logger logger = Logger.getLogger(MainApplication.class);

    public static void main(String[] args){


        TextManager textManager = new TextManager();
        String text = "";
        try {
            text = textManager.readFile("d:/1.txt");
        }
        catch (FileNotFoundException e){
            logger.error("File was not found!", e);
        }
        catch (IOException e){
            logger.error("Problem reading file!", e);
        }

        DividedText dividedText = new DividedText(text);

        TaskNumberOne taskNumberOne = new TaskNumberOne(dividedText);
        taskNumberOne.execute();

        TaskNumberTwo taskNumberTwo = new TaskNumberTwo(dividedText, TaskNumberTwo.Position.LAST);
        taskNumberTwo.execute();

        System.out.println(dividedText.merge());
    }
}
