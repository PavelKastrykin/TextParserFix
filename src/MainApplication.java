import com.pavel.textparser.task.TaskNumberOne;
import com.pavel.textparser.entity.DividedText;
import com.pavel.textparser.logics.TextManager;
import com.pavel.textparser.task.TaskNumberTwo;

import java.io.IOException;import java.lang.String;


public class MainApplication {

    public static void main(String[] args) throws IOException{

        TextManager textManager = new TextManager();
        String text = textManager.readFile("d:/1.txt");
        DividedText dividedText = new DividedText(text);

        TaskNumberOne taskNumberOne = new TaskNumberOne(dividedText);
        taskNumberOne.execute();

        TaskNumberTwo taskNumberTwo = new TaskNumberTwo(dividedText, TaskNumberTwo.Position.LAST);
        taskNumberTwo.execute();

        System.out.println(dividedText.merge());
    }
}
