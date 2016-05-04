package manualQuizBuilding;

import entityFactory.DAO;
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

    public Quiz creatingQuiz() {

        Quiz quiz = new Quiz(QuizFileReader.readFileForQuestion("src/main/quiz1test"));


        logger.info("Koniec tworzenia Quizu z pliku: "+quiz.getQuizName());
        DAO.addingDbQuiz(quiz);
        return quiz;
    }

    public Quiz creatingQuiz(List<Question> questionsList) {
        DataGeter dataGeter = new DataGeter(System.in, System.out);
        Quiz quiz = new Quiz(questionsList);

        for(Question q : questionsList){
            q.setQuiz(quiz);
        }

        String quizName = decideQuizName(dataGeter);


        logger.info("Koniec tworzenia Quizu z konsoli: "+quiz.getQuizName());
        DAO.addingDbQuiz(quiz);
        return quiz;
    }

    private String decideQuizName(DataGeter  dateGeter) {
        String quizName = dateGeter.askForString("Wpisz nazwę quizu");
        return quizName;
    }




}
