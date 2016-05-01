package practice.presentingQuiz;

import settings.Answer;
import settings.Question;

import java.util.List;

/**
 * Created by jakub on 20.04.16.
 */
public class QuestionPresenter {

    public static String showQuestion(Question question){
        List<Answer> answerList;
        answerList = question.getAnswerList();
        int i = 0;
        String strReturn = ""+question.getQuestionName() +'\n';
        for(Answer ans : answerList){
            i++;
            strReturn += i + ". " +ans;
        }
        return strReturn;
    }
}
