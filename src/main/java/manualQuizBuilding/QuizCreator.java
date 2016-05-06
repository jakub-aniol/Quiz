package manualQuizBuilding;

import entityFactory.DAO;
import fileQuizBuilding.QuizFileReader;
import org.apache.log4j.Logger;
import settings.Question;
import settings.Quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 19.04.16.
 */
public class QuizCreator {
    private static final Logger logger = Logger.getLogger(QuizCreator.class.getName());
    private final DataGeter dataGeter = new DataGeter(System.in);
    private final QuizBuilder quizBuilder = new QuizBuilder(new Quiz());
    private final List<Question> questionsList = new ArrayList<>();

    public Quiz creatingQuiz() {

        Quiz quiz = quizBuilder.addQuizName(dataGeter.askForString("Podaj nazwę Quizu"))
                .addQuizDescription(dataGeter.askForString("Podaj opis Quizu"))
                .addQuizAnswer(dataGeter.askForString("Podaj odpowiedź po Quizie"))
                .addPoinsToPass(dataGeter.askForInteger("Podaj liczbę punktów do zdania"))
                .addNumberOfQuestions(dataGeter.askForInteger("Podaj ilosc pytan w Quizie"))
                .done();

        quiz = quizBuilder.addQuestionsToList(assingQuestions(quiz)).done();
        quiz.countMaxPointForQuiz();

        logger.info("Koniec tworzenia Quizu z konsoli: " + quiz.getQuizName());
        DAO.addingDbQuiz(quiz);
        return quiz;
    }

    List<Question> assingQuestions(Quiz quiz) {
        QuestionCreator questionCreator = new QuestionCreator();
        Question question;
        System.out.println("Przypisuj pytania");
        System.out.println("ilosc pytan: "+quiz.getNumberOfQuestions());

        for (int i = 0; i < quiz.getNumberOfQuestions(); i++) {
            question = questionCreator.creatigQuestion();
            question.setQuiz(quiz);
            questionsList.add(question);
        }

        return questionsList;
    }

    public Quiz creatingQuiz(int i) {

        Quiz quiz = new Quiz(QuizFileReader.readFileForQuestion("src/main/quiz1test"));

        logger.info("Koniec tworzenia Quizu z pliku: " + quiz.getQuizName());
        DAO.addingDbQuiz(quiz);
        return quiz;
    }
}
