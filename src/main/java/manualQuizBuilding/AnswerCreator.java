package manualQuizBuilding;

import entityFactory.DAO;
import org.apache.log4j.*;


import settings.Answer;
import settings.Category;


import java.util.Scanner;


/**
 * Created by jakub on 18.04.16.
 */
public class AnswerCreator {
    private static Scanner scanner = new Scanner(System.in);
    static Logger logger = Logger.getLogger(AnswerCreator.class);


    public static Answer creatingAnswer(Category category) {
        String answerName = decideAnswerName(scanner);
        int points = decideMaxPoints(scanner);
        boolean isTrue = isAnswerCorrect(scanner);

        Answer answer = new Answer(answerName, category, points, isTrue);
        DAO.addingDbAnswer(answer);
        logger.info("Dodana odpowiedź: " + answer.getAnswerName());

        return answer;
    }

    private static int decideMaxPoints(Scanner scanner) {
        System.out.println("Podaj liczbe punktow za odpowiedź");
        int points;
        try {
            points = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Nie podaleś właściwej wartosci punktow, wstawiono 0");
            points = 0;
        }
        return points;
    }

    private static String decideAnswerName(Scanner scanner) {
        System.out.println("Podaj treść odpowiedź");
        String answerName;
        answerName = scanner.nextLine();
        return answerName;
    }

    //można ustawić tak że jak za odpowiedx beda punkty to z automatu ustawi na prawdziwa jak jak bedzie mniej lub rowne zero to na fałszywą
    private static boolean isAnswerCorrect(Scanner scanner) {
        System.out.println("czy odpowiedź jest prawdziwa? Jeśli tak wpisz T, w przeciwnym razie będzie fałszywa");
        String rightAnswer;
        boolean isTrue = true;
        rightAnswer = scanner.nextLine();
        if (rightAnswer.equals("t") || rightAnswer.equals("T")) {
            return isTrue;
        } else
            return !isTrue;
    }

}
