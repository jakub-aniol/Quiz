package practice.presentingQuiz;

import manualQuizBuilding.DataGeter;
import org.apache.log4j.*;
import practice.practiceQuiz.QuestionAnswerer;
import settings.Question;
import settings.Quiz;

import java.util.List;

/**
 * Object for presenting Quiz
 * Created by Jakub
 * Since 2016-04-30.
 */
public class QuizPresenter {
    static Logger logger = Logger.getLogger(QuizPresenter.class);
    DataGeter dataGeter = new DataGeter(System.in, System.out);
    /**
     * Metchod for presenting Quiz
     * @param quiz {@link settings.Quiz}
     */
    public void showQuiz(Quiz quiz) {
        List<Question> quizQuestionList;
        quizQuestionList = quiz.getQuestionList();
        int i = 0;
        for (Question que : quizQuestionList) {
            i++;
            System.out.println("" + i + ". " + QuestionPresenter.showQuestion(que));
        }
    }
    /**
     * Metchod for presenting Quiz to practice it after showing a question there is a time to chose and mark an answer
     * @param quiz {@link settings.Quiz}
     */
    public void showQuizToPractice(Quiz quiz) {
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
                int n = questionAnswerer.choseSingleAnswer(dataGeter);
                questionAnswerer.markChoosenAnswer(que, n);
            } if(que.isMultiply() == true ){
                quizAnswerList=questionAnswerer.choseMultiplyAnswer(dataGeter);
                questionAnswerer.markChoosenAnswer(que,quizAnswerList);
            }
        }
    }
    /**
     * Metchod for presenting Quiz to with the result and maximum points possible to gain
     * @param quiz {@link settings.Quiz}
     */
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
