import entityFactory.DAO;
import manualQuizBuilding.QuizCreator;
import org.apache.log4j.Logger;
import practice.presentingQuiz.QuizPresenter;
import settings.Quiz;

import java.util.List;
import java.util.Scanner;

/**
 * Created by jakub on 18.04.16.
 */
public class Start {
    private final static Logger logger = Logger.getLogger(Start.class);
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuizCreator quizCreator = new QuizCreator();
    private static final QuizPresenter quizPresenter = new QuizPresenter();

    public static void main(String[] args) {

        int i;
        System.out.println("Wybierz opcję");
        System.out.println("Wczytaj ankietę z pliku, wpisz 1");
        System.out.println("Wczytaj ankietę z bazy, wpisz 2");
        System.out.println("Wpisz ankietę w kreatorze, wpisz 3");
        i = scanner.nextInt();
        System.out.println("Wybrales: " + i);

        if (i == 1) {

            Quiz quiz = quizCreator.creatingQuiz(i);
            logger.info("Otworzono z pliku: " + quiz.getQuizName());
            quizPresenter.showQuizToPractice(quiz);
            logger.info("Zamknieto z pliku: " + quiz.getQuizName());
            quizPresenter.showQuizWithResults(quiz);

        } else if (i == 2) {

            DAO.openFactory();

            List<Quiz> quizesList = DAO.getQuiz();
            for (Quiz q : quizesList) {
                quizPresenter.showQuizToPractice(q);
                quizPresenter.showQuizWithResults(q);
            }

            DAO.closeFactory();

        } else {

            DAO.openFactory();

            Quiz quizDb = quizCreator.creatingQuiz();

            logger.info("Otworzono z konsoli: " + quizDb.getQuizName());
            quizPresenter.showQuizToPractice(quizDb);
            logger.info("Zamknięto z konsoli: " + quizDb.getQuizName());
            quizPresenter.showQuizWithResults(quizDb);

            DAO.closeFactory();
        }
    }
}
