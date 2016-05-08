package practice.presentingQuiz;

import manualQuizBuilding.DataGeter;
import org.apache.log4j.Logger;
import practice.practiceQuiz.QuestionAnswerer;
import settings.ChoosenQuestion;
import settings.ChoosenQuiz;
import settings.Question;
import settings.Quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Object for presenting Quiz
 * Created by Jakub
 * Since 2016-04-30.
 */
public class QuizPresenter {
    private static final Logger logger = Logger.getLogger(QuizPresenter.class);
    private final DataGeter dataGeter = new DataGeter(System.in);
    /**
     * Metchod for presenting Quiz
     * @param quiz {@link settings.ChoosenQuiz}
     */
    public void showQuiz(Quiz quiz) {
        List<Question> quizQuestionList;
        quizQuestionList = quiz.getQuestionList();
        int i = 0;
        System.out.println(quiz.getQuizName());
        for (Question que : quizQuestionList) {
            i++;
            System.out.println("" + i + ". " + QuestionPresenter.showQuestion(que));
        }
    }
    /**
     * Metchod for presenting Quiz to practice it after showing a question there is a time to chose and mark an answer
     * @param choosenQuiz {@link settings.ChoosenQuiz}
     */
    public void showQuizToPractice(ChoosenQuiz choosenQuiz) {
        System.out.println("bombastki "+choosenQuiz.getChoosenQusetionsList().size());
        System.out.println("bombastki "+choosenQuiz.getChoosenQusetionsList());
        QuestionAnswerer questionAnswerer = new QuestionAnswerer();
      //  ArrayList<ChoosenQuestion> quizChoosenQuestionList = new ArrayList<>(choosenQuiz.getChoosenQusetionsList());
        ArrayList<Integer> quizChoosenAnswerList;
     //   //quizChoosenQuestionList = choosenQuiz.getChoosenQusetionsList();
        int i = 0;
        System.out.println(choosenQuiz.getQuizName());
        for (ChoosenQuestion que : choosenQuiz.getChoosenQusetionsList()) {
            logger.info("Pytanie: "+que.getQuestionName());
            i++;
            System.out.println("" + i + ". " + QuestionPresenter.showChoosenQuestion(que));
            if (!que.getIsMultiply()) {
                int n = questionAnswerer.choseSingleAnswer(dataGeter);
                questionAnswerer.markChoosenAnswer(que, n);
            } if(que.getIsMultiply()){
                quizChoosenAnswerList=questionAnswerer.choseMultiplyAnswer(dataGeter);
                questionAnswerer.markChoosenAnswer(que,quizChoosenAnswerList);
                System.out.println("roor    ");
            }
        }
    }
    /**
     * Metchod for presenting Quiz to with the result and maximum points possible to gain
     * @param choosenQuiz {@link settings.ChoosenQuiz}
     */
    public void showQuizWithResults(ChoosenQuiz choosenQuiz) {

        List<ChoosenQuestion> quizChoosenQuestionList;
        quizChoosenQuestionList = choosenQuiz.getChoosenQusetionsList();

        int points = 0;
        int i = 0;
        System.out.println(choosenQuiz.getQuizName());
        for (ChoosenQuestion que : quizChoosenQuestionList) {
            i++;
            System.out.println("" + i + ". " + QuestionPresenter.showChoosenQuestion(que));
        }
        points += choosenQuiz.countingGainedPointsInQuiz(choosenQuiz);
        System.out.println("Maksymlana ilosć punktów z quizu "+ choosenQuiz.getMaxPointsQuiz());
        System.out.println("Zgromadzileś punktów: " + points);
    }
}
