package practice.practiceQuiz;

import manualQuizBuilding.DataGeter;
import org.apache.log4j.Logger;
import settings.ChoosenAnswer;
import settings.ChoosenQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Object alowing to anser the Question
 * Created by Jakub
 * Since 2016-04-30.
 */
public class QuestionAnswerer {
    private static final Logger logger = Logger.getLogger(QuestionAnswerer.class);
    private final int MIN_ANSWER = 1;
    private final int MAX_ANSWER = 4;

    /**
     * Method allowing to choose in singel answer questions answer by putting number by typing a keyboard
     * @param dataGeter {@link manualQuizBuilding.DataGeter}
     * @return - int which is a number of answer one chose
     */

    public int choseSingleAnswer(DataGeter dataGeter) {
        int chosenNumber;
        System.out.println("Twoja odpowiedź: ");
        chosenNumber = dataGeter.askForInteger("Podaj liczbe w przedziale " + MIN_ANSWER + " do " + MAX_ANSWER);

        while (chosenNumber < MIN_ANSWER || chosenNumber > MAX_ANSWER) {
            chosenNumber = dataGeter.askForInteger("To nie jest liczba z przedziału: " + chosenNumber);
        }

        logger.info("Odpowiedz " + chosenNumber);
        return chosenNumber;
    }

    /**
     * Method allowing to choose answer in mulitiply answer questions by putting number by typing a keyboard
     * @param dataGeter {@link manualQuizBuilding.DataGeter}
     * @return - ArrayList which is a number of answers one chose
     */

    public ArrayList<Integer> choseMultiplyAnswer(DataGeter dataGeter) {
        ArrayList<Integer> listOdp = new ArrayList<>();
        TreeSet<Integer> treeSetOdp = new TreeSet<>();
        int chosenNumber = dataGeter.askForInteger("Podaj liczbe w przedziale " + MIN_ANSWER + " do " + MAX_ANSWER);

        while (chosenNumber != 0){
            if (chosenNumber > 0) {
                treeSetOdp.add(chosenNumber);
            }
            System.out.println("Podaj liczbe w przedziale " + MIN_ANSWER + " do " + MAX_ANSWER);
            chosenNumber = dataGeter.askForInteger("Jeśli chcesz wskazać kolejną pozycję wpisza numer odpowiedzi, nie powtarzaj odpowiedzi\nAby zakończyć kliknij '0'/zero");
            //System.out.println("Aby zakończyć kliknij '0'/zero");
        }
        listOdp.addAll(treeSetOdp);
        logger.info("Odpowiedz " + treeSetOdp);
        return listOdp;
    }

    /**
     * Method which mark choosen answer in mulitiply answer questions by matching the answer true
     * @param choosenQuestion {@link settings.Question}
     * @param choosenAnswersList - List with choosen numbers of answers
     */
    public void markChoosenAnswer(ChoosenQuestion choosenQuestion, List<Integer> choosenAnswersList) {
        List<ChoosenAnswer> answerList = choosenQuestion.getChoosenAnswerList();

        boolean checked = true;
        int i = 1;
        for (ChoosenAnswer ans : answerList) {
            for (Integer odp : choosenAnswersList) {
                if (i == odp) {
                    System.out.println("odpowiedz: " + i);
                    ans.setChoosen(checked);
                }
            }
            i++;
        }
    }

    /**
     * Method which mark choosen answer in single answer questions by matching the answer true
     * @param choosenQuestion {@link settings.ChoosenQuestion}
     * @param  n - int choosen number of Answer
     */
    public void markChoosenAnswer(ChoosenQuestion choosenQuestion, int n) {
        List<ChoosenAnswer> answerList = choosenQuestion.getChoosenAnswerList();
        boolean checkd = true;
        int i = 1;
        for (ChoosenAnswer ans : answerList) {
            if (i == n) {
                System.out.println("odpowiedz: " + i);
                ans.setChoosen(checkd);
            }
            i++;
        }
    }
}
