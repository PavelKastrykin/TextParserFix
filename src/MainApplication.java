import com.pavel.textparser.task.TaskNumberOne;
import com.pavel.textparser.entity.DividedText;
import com.pavel.textparser.logics.TextManager;

import java.io.IOException;import java.lang.String;
import java.util.ArrayList;


public class MainApplication {

    public static void main(String[] args) throws IOException{

        TextManager textManager = new TextManager();
        String text = textManager.readFile("d:/1.txt");
        DividedText dividedText = new DividedText(text);

        TaskNumberOne taskNumberOne = new TaskNumberOne(dividedText);
        ArrayList<String> allWords = taskNumberOne.allWordsInTextCreator(taskNumberOne.getDividedText());

        for (String word : allWords){
            System.out.println(word + " ");
        }
    }
}
