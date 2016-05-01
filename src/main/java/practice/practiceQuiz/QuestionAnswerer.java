package practice.practiceQuiz;

;
import org.apache.log4j.*;
import settings.Answer;
import settings.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by jakub on 20.04.16.
 * Is responsible for marking, indicated by User, Answer as chosen.
 */
public class QuestionAnswerer {
    static Logger logger = Logger.getLogger(QuestionAnswerer.class);

    final int MIN_ANSWER = 1;
    final int MAX_ANSWER = 4;
    Scanner scanner = new Scanner(System.in);


    public int choseSingleAnswer() {
        int chosenNumber = 0;

        System.out.println("Twoja odpowiedź: ");
        do {
            System.out.println("Podaj liczbe w przedziale " + MIN_ANSWER + " do " + MAX_ANSWER);
            try {
                chosenNumber = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba całkowita: " + chosenNumber);
                scanner.nextLine();
            }
        } while (chosenNumber < MIN_ANSWER || chosenNumber > MAX_ANSWER);
        logger.info("Odpowiedz " + chosenNumber);
        return chosenNumber;
    }

    public ArrayList<Integer> choseMultiplyAnswer() {
        int chosenNumber = 0;
        ArrayList<Integer> listOdp = new ArrayList<>();
        TreeSet<Integer> treeSetOdp = new TreeSet<>();

        System.out.println("Podaj liczbe w przedziale " + MIN_ANSWER + " do " + MAX_ANSWER);
        do {
            System.out.println("Jeśli chcesz wskazać kolejną pozycję wpisza numer odpowiedzi, nie powtarzaj odpowiedzi");
            try {
                chosenNumber = scanner.nextInt();
                if (chosenNumber > 0)
                    treeSetOdp.add(chosenNumber);
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba całkowita: " + chosenNumber);
                scanner.nextLine();
            }
            System.out.println("Aby zakończyć kliknij '0'/zero");

        } while (chosenNumber != 0);

        listOdp.addAll(treeSetOdp);
        logger.info("Odpowiedz " + treeSetOdp);
        return listOdp;
    }

    public void markChoosenAnswer(Question question, List<Integer> listaOdp) {
        List<Answer> answerList = question.getAnswerList();

        boolean checkd = true;
        int i = 1;
        for (Answer ans : answerList) {
            for (Integer odp : listaOdp) {
                if (i == odp) {
                    System.out.println("odpowiedz: " + i);
                    ans.setChoosen(checkd);
                }
            }
            i++;
        }
    }

    public void markChoosenAnswer(Question question, int n) {
        List<Answer> answerList = question.getAnswerList();
        boolean checkd = true;
        int i = 1;
        for (Answer ans : answerList) {
            if (i == n) {
                System.out.println("odpowiedz: " + i);
                ans.setChoosen(checkd);
            }
            i++;
        }
    }


}
