package manualQuizBuilding;

import fileQuizBuilding.QuizFileReader;
import org.apache.log4j.Logger;
import settings.Question;
import settings.Quiz;

import java.util.List;

/**
 * Created by jakub on 19.04.16.
 */
public class QuizCreator {
    static Logger logger = Logger.getLogger(QuizCreator.class.getName());

    public Quiz makeQuiz() {
        Quiz quiz = new Quiz(QuizFileReader.readFileforQuestion("src/main/quiz1test"));
        quiz.setQuizName(decideQuizName());
        logger.info("Koniec tworzenia Quizu z pliku: "+quiz.getQuizName());
        return quiz;
    }

    public Quiz makeQuiz(List<Question> questionsList) {
        Quiz quiz = new Quiz(questionsList);
        quiz.setQuizName(decideQuizName());
        logger.info("Koniec tworzenia Quizu z konsoli: "+quiz.getQuizName());
        return quiz;
    }

    private String decideQuizName() {
        String quizName = "Moj pierwszy Quiz";
        return quizName;
    }


}
