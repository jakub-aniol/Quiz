package manualQuizBuilding;

import entityFactory.DAO;
import org.apache.log4j.Logger;
import settings.Answer;
import settings.Category;
import settings.ChoosenAnswer;

/**
 * Created by jakub on 18.04.16.
 */
class AnswerCreator {
    private static final Logger logger = Logger.getLogger(AnswerCreator.class);
    private final DataGeter dataGeter = new DataGeter(System.in);

    public Answer creatingAnswer(Category category) {
        AnswerBuilder answerBuilder = new AnswerBuilder(new Answer());

        Answer answer = answerBuilder.addName(dataGeter.askForString("Podaj treść odpowiedzi")).addCategory(category)
                .addPoints(dataGeter.askForInteger("Podaj liczbę punktów za odpowiedź"))
                .addIsProper(dataGeter.askForBoolean("Czy odpowiedź jest prawdziwa? Jeśli tak wpisz T, w przeciwnym razie będzie fałszywa"))
                .done();

        // DAO.addingDbAnswer(answer);
        logger.info("Dodana odpowiedź: " + answer.getAnswerName());

        return answer;
    }

    public ChoosenAnswer creatingChoosenAnswer(Answer answer) {
        ChoosenAnswer choosenAnswer = new ChoosenAnswer(answer);
        ChoosenAnswerBuilder choosenAnswerBuilder = new ChoosenAnswerBuilder();
        choosenAnswer = choosenAnswerBuilder.addChoosenAnswer(choosenAnswer.getChoosen()).done();

        DAO.addingDbAnswer(choosenAnswer);

        return choosenAnswer;
    }
}