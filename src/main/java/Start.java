import entityFactory.DAO;
import manualQuizBuilding.DataGeter;
import manualQuizBuilding.QuizCreator;
import org.apache.log4j.Logger;
import practice.presentingQuiz.QuizPresenter;
import settings.ChoosenQuiz;
import settings.Quiz;

import java.util.List;

/**
 * Created by jakub on 18.04.16.
 */
public class Start {
    private final static Logger logger = Logger.getLogger(Start.class);
    private static final DataGeter dataGeter = new DataGeter(System.in);
    private static final QuizCreator quizCreator = new QuizCreator();
    private static final QuizPresenter quizPresenter = new QuizPresenter();


    public static void main(String[] args) {

        int opcja;
        System.out.println("Wczytaj ankietę z pliku, wpisz 1");
        System.out.println("Wczytaj ankietę z bazy, wpisz 2");
        System.out.println("Wpisz ankietę w kreatorze, wpisz 3");
        opcja = dataGeter.askForInteger("Wybierz opcję");
        System.out.println("Wybrales: " + opcja);

        if (opcja == 1) {

            Quiz quiz = quizCreator.creatingQuiz(opcja);
            ChoosenQuiz choosenQuiz = new ChoosenQuiz(quiz);
            logger.info("Otworzono z pliku: " + choosenQuiz.getQuizName());
            quizPresenter.showQuizToPractice(choosenQuiz);
            logger.info("Zamknieto z pliku: " + quiz.getQuizName());
            quizPresenter.showQuizWithResults(choosenQuiz);

        } else if (opcja == 2) {

            DAO.openFactory();

            List<Quiz> quizesList = DAO.getQuiz();
            for (Quiz q : quizesList) {
                ChoosenQuiz choosenQuiz = new ChoosenQuiz(q);
                quizPresenter.showQuizToPractice(choosenQuiz);
                quizPresenter.showQuizWithResults(choosenQuiz);
            }

            DAO.closeFactory();

        } else {

            DAO.openFactory();

            Quiz quiz = quizCreator.creatingQuiz();

            System.out.println("###################### " + quiz);

            ChoosenQuiz choosenQuiz = quizCreator.creatingChoosenQuiz(quiz);

            System.out.println("###################### " + choosenQuiz);

            logger.info("Otworzono z konsoli: " + choosenQuiz.getQuizName());
            quizPresenter.showQuizToPractice(choosenQuiz);
            logger.info("Zamknięto z konsoli: " + choosenQuiz.getQuizName());
            quizPresenter.showQuizWithResults(choosenQuiz);

            DAO.closeFactory();
        }
    }
}

