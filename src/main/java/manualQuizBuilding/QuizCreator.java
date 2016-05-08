package manualQuizBuilding;

import entityFactory.DAO;
import fileQuizBuilding.QuizFileReader;
import org.apache.log4j.Logger;
import settings.ChoosenQuiz;
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


    public Quiz creatingQuiz() {
        QuizBuilder quizBuilder = new QuizBuilder(new Quiz());

        Quiz quiz = quizBuilder.addQuizName(dataGeter.askForString("Podaj nazwę Quizu"))
                .addQuizDescription(dataGeter.askForString("Podaj opis Quizu"))
                .addQuizAnswer(dataGeter.askForString("Podaj odpowiedź po Quizie"))
                .addPoinsToPass(dataGeter.askForInteger("Podaj liczbę punktów do zdania"))
                .addNumberOfQuestions(dataGeter.askForInteger("Podaj ilosc pytan w Quizie"))
                .done();

        DAO.addingDbQuiz(quiz);

        Quiz quiz2 = quizBuilder.addQuestionsToList(assingQuestions(quiz)).done();
        quiz2.countMaxPointForQuiz();

        DAO.addingDbQuiz(quiz2);

        logger.info("Koniec tworzenia Quizu z konsoli: " + quiz.getQuizName());
        return quiz2;
    }

    public ChoosenQuiz creatingChoosenQuiz(Quiz quiz){

        ChoosenQuiz choosenQuiz;

        ChoosenQuizBuilder choosenQuizBuilder = new ChoosenQuizBuilder(new ChoosenQuiz(quiz));
        choosenQuiz = choosenQuizBuilder.addChoosenQuizUserName(dataGeter.askForString("Podaj swoje imię"))
                .addChoosenQuizUserLastName(dataGeter.askForString("Podaj swoje nazwisko")).done();

        DAO.addingDbQuiz(choosenQuiz);
        return choosenQuiz;
    }

    List<Question> assingQuestions(Quiz quiz) {
        List<Question> questionsList = new ArrayList<>();
        QuestionCreator questionCreator = new QuestionCreator();
        QuestionCreator questionCreator2 = new QuestionCreator();
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
      //  DAO.addingDbQuiz(quiz);
        return quiz;
    }
}
