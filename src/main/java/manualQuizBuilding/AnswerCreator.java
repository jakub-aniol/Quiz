package manualQuizBuilding;

import entityFactory.DAO;
import org.apache.log4j.Logger;
import settings.Answer;
import settings.Category;

/**
 * Created by jakub on 18.04.16.
 */
public class AnswerCreator {
    static Logger logger = Logger.getLogger(AnswerCreator.class);


    public Answer creatingAnswer(Category category) {
        DataGeter dataGeter = new DataGeter(System.in, System.out);
        AnswerBuilder answerBuilder = new AnswerBuilder(new Answer());

        Answer answer = answerBuilder.addName(dataGeter.askForString("Podaj treść odpowiedzi")).addCategory(category).addPoints(dataGeter.askForInteger("Podaj liczbę punktów za odpowiedź"))
                .addIsProper(dataGeter.askForBoolean("Czy odpowiedź jest prawdziwa? Jeśli tak wpisz T, w przeciwnym razie będzie fałszywa")).done();


        /*String answerName = decideAnswerName(dataGeter);
        int points = decideMaxPoints(dataGeter);
        boolean isTrue = isAnswerCorrect(dataGeter);

        Answer answer = new Answer(answerName, category, points, isTrue);*/
        DAO.addingDbAnswer(answer);
        logger.info("Dodana odpowiedź: " + answer.getAnswerName());

        return answer;
    }

/*    public int decideMaxPoints(DataGeter dataGeter) {
        int points;
        try {
            points = dataGeter.askForInteger("Podaj liczbe punktow za odpowiedź");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nie podaleś właściwej wartosci punktow, wstawiono 0");
            points = 0;
        }
        return points;
    }

    public String decideAnswerName(DataGeter dataGeter) {
        String answerName = dataGeter.askForString("Podaj treść odpowiedź");
        return answerName;
    }//można ustawić tak że jak za odpowiedx beda punkty to z automatu ustawi na prawdziwa jak jak bedzie mniej lub rowne zero to na fałszywą

    public boolean isAnswerCorrect(DataGeter dataGeter) {
        String rightAnswer = dataGeter.askForString("Czy odpowiedź jest prawdziwa? Jeśli tak wpisz T, w przeciwnym razie będzie fałszywa");
        boolean isTrue = true;
        if (rightAnswer.equals("t") || rightAnswer.equals("T"))
            return isTrue;
        return !isTrue;
    }*/
}