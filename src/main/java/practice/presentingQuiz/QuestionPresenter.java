package practice.presentingQuiz;

import settings.Answer;
import settings.ChoosenAnswer;
import settings.ChoosenQuestion;
import settings.Question;

import java.util.List;

/**
 * Object for presenting Question
 * Created by Jakub
 * Since 2016-04-30.
 */
public class QuestionPresenter {

    /**
     * Metchod for presenting Question its used when the quiz is presenting
     * @param question {@link settings.Question}
     * @return - returns string which represents Question in astablished form
     */
    public static String showQuestion(Question question) {
        List<Answer> answerList;
        answerList = question.getAnswerList();
        int i = 0;
        String strReturn = "" + question.getQuestionName() + '\n';
        for (Answer ans : answerList) {
            i++;
            strReturn += i + ". " + ans;
        }
        return strReturn;
    }

    public static String showChoosenQuestion(ChoosenQuestion choosenQuestion) {
        List<ChoosenAnswer> choosenAnswerList;
        choosenAnswerList = choosenQuestion.getChoosenAnswerList();
        int i = 0;
        String strReturn = "" + choosenQuestion.getQuestionName() + '\n';
        for (ChoosenAnswer ans : choosenAnswerList) {
            i++;
            strReturn += i + ". " + ans;
        }
        return strReturn;
    }

}
