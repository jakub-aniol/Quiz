package manualQuizBuilding;

import entityFactory.DAO;
import org.apache.log4j.Logger;
import settings.Answer;
import settings.ChoosenQuestion;
import settings.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 18.04.16.
 */

class QuestionCreator {

    private final static Logger logger = Logger.getLogger(QuestionCreator.class.getName());
    private final DataGeter dataGeter = new DataGeter(System.in);


    public Question creatigQuestion() {
        QuestionBuilder questionBuilder = new QuestionBuilder(new Question());
        Question question;

        question = questionBuilder.addQuestionName(dataGeter.askForString("Podaj nazwe pytania"))
                .addIsMultiply(dataGeter.askForBoolean("wpisz " + 'T' + " jeśli pytanie ma być wielokrotnej odpowiedzi"))
                .addCategory(dataGeter.askForCategory("Wybierz Kategorię z podanej listy"))
                .addNumberOfAnswers(dataGeter.askForInteger("Podaj ilość odpowiedzi pomiędzy 1 a 4"))
                .done();

        question = questionBuilder.addAnswersToQuestion(asignAnswers(question)).done();
        question.countingMaxPoints();
        DAO.addingDbQuestion(question);

        logger.info("Dodane pytanie: " + question.getQuestionName());

        return question;
    }


    public ChoosenQuestion creatingChoosenQuestion(Question question){
        ChoosenQuestion choosenQuestion = new ChoosenQuestion(question);
        ChoosenQuestionBuilder choosenQuestionBuilder = new ChoosenQuestionBuilder(choosenQuestion);

        choosenQuestion = choosenQuestionBuilder.addGainedPoints(choosenQuestion.getGainedPoints()).done();

        DAO.addingDbQuestion(choosenQuestion);

        return choosenQuestion;
    }
    private List<Answer> asignAnswers(Question question) {
        AnswerCreator answerCreator = new AnswerCreator();
        List<Answer> answersList = new ArrayList<>();
        Answer answer;
        System.out.println("Przypisuj odpowiedzi");
        for (int i = 1; i <= question.getNumberOfAnswers(); i++) {
            answer = answerCreator.creatingAnswer(question.getCategory());
            answer.setQuestion(question);

            answersList.add(answer);

        }
        return answersList;
    }
}
