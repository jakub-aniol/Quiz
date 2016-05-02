import entityFactory.DAO;
import manualQuizBuilding.QuestionCreator;
import manualQuizBuilding.QuizCreator;
import org.apache.log4j.*;
import practice.presentingQuiz.*;
import settings.Question;
import settings.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jakub on 18.04.16.
 */
public class Start {
    final static Logger logger = Logger.getLogger(Start.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizCreator quizCreator = new QuizCreator();
        QuizPresenter quizPresenter = new QuizPresenter();
        Quiz quiz = quizCreator.makeQuiz();
        int i;

        System.out.println("Wybierz opcję");
        System.out.println("Wczytaj ankietę z pliku, wpisz 1");
        System.out.println("Wpisz ankietę w kreatorze, wpisz 2");
        i = scanner.nextInt();
        System.out.println("Wybrales: "+i);
        if(i==1){

            logger.info("Otworzono z pliku: "+quiz.getQuizName());
            quizPresenter.showQuizToPractice(quiz);
            logger.info("Zamknieto z pliku: "+quiz.getQuizName());
            QuizPresenter.showQuizWithResults(quiz);
        }

        else {

            DAO.openFactory();

            List<Question> questionsList = new ArrayList<>();
            QuestionCreator questionCreator = new QuestionCreator();
            Question question = questionCreator.creatigQuestion();

            questionsList.add(question);


            logger.info("Otworzono z konsoli: "+quiz.getQuizName());
            quizPresenter.showQuizToPractice(quiz);
            logger.info("Zamknięto z konsoli: "+quiz.getQuizName());
            QuizPresenter.showQuizWithResults(quiz);

            DAO.closeFactory();
        }








    }
}
