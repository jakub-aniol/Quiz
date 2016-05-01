package practice.presentingQuiz;

import org.apache.log4j.*;
import practice.practiceQuiz.QuestionAnswerer;
import settings.Question;
import settings.Quiz;

import java.util.List;

/**
 * Created by jakub on 20.04.16.
 */
public class QuizPresenter {
    static Logger logger = Logger.getLogger(QuizPresenter.class);

    public static void showQuiz(Quiz quiz) {
        List<Question> quizQuestionList;
        quizQuestionList = quiz.getQuestionList();
        int i = 0;
        for (Question que : quizQuestionList) {
            i++;
            System.out.println("" + i + ". " + QuestionPresenter.showQuestion(que));
        }
    }

    public static void showQuizToPractice(Quiz quiz) {
        QuestionAnswerer questionAnswerer = new QuestionAnswerer();
        List<Question> quizQuestionList;
        List<Integer> quizAnswerList;
        quizQuestionList = quiz.getQuestionList();
        int i = 0;
        for (Question que : quizQuestionList) {
            logger.info("Pytanie: "+que.getQuestionName());
            i++;
            System.out.println("" + i + ". " + QuestionPresenter.showQuestion(que));
            if (que.isMultiply() == false) {
                int n = questionAnswerer.choseSingleAnswer();
                questionAnswerer.markChoosenAnswer(que, n);
            } if(que.isMultiply() == true ){
                quizAnswerList=questionAnswerer.choseMultiplyAnswer();
                questionAnswerer.markChoosenAnswer(que,quizAnswerList);
            }
        }
    }

    public static void showQuizWithResults(Quiz quiz) {

        List<Question> quizQuestionList;
        quizQuestionList = quiz.getQuestionList();

        int points = 0;
        int i = 0;
        for (Question que : quizQuestionList) {
            i++;
            System.out.println("" + i + ". " + QuestionPresenter.showQuestion(que));
        }
        points += quiz.countingGainedPoints(quiz);
        System.out.println("Maksymlana ilosć punktów z quizu "+ quiz.getMaxPointsQuiz());
        System.out.println("Zgromadzileś punktów: " + points);
    }
}
