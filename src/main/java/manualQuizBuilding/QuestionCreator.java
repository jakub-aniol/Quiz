package manualQuizBuilding;

import entityFactory.DAO;
import org.apache.log4j.Logger;
import settings.Answer;
import settings.Question;

import java.util.List;

/**
 * Created by jakub on 18.04.16.
 */

class QuestionCreator {

    private final static Logger logger = Logger.getLogger(QuestionCreator.class.getName());

    public Question creatigQuestion() {
        DataGeter dataGeter = new DataGeter(System.in);
        QuestionBuilder questionBuilder = new QuestionBuilder(new Question());
        Question question = null;

        question = questionBuilder.addQuestionName(dataGeter.askForString("Podaj nazwe pytania"))
                .addIsMultiply(dataGeter.askForBoolean("wpisz " + 'T' + " jeśli pytanie ma być wielokrotnej odpowiedzi"))
                .addCategory(dataGeter.askForCategory("Wybierz Kategorię z podanej listy"))
                .addNumberOfAnswers(dataGeter.askForInteger("Podaj ilość odpowiedzi pomiędzy 1 a 4"))
                .addAnswersToQuestion(asignAnswers(question))
                .done();

        question.countingMaxPoints();

        DAO.addingDbQuestion(question);
        logger.info("Dodane pytanie: " + question.getQuestionName());

        return question;
    }

    private List<Answer> asignAnswers(Question question) {
        AnswerCreator answerCreator = new AnswerCreator();
        Answer answer;
        System.out.println("Przypisuj odpowiedzi");
        for (int i = 0; i < question.getNumberOfAnswers(); i++) {
            answer = answerCreator.creatingAnswer(question.getCategory());
            answer.setQuestion(question);
            question.getAnswerList().add(answer);

        }
        return question.getAnswerList();
    }
}
