package manualQuizBuilding;

import settings.Question;
import settings.Quiz;

import java.util.List;

/**
 * Created by jakub on 05.05.16.
 */
class QuizBuilder {

    private final Quiz quiz;

    QuizBuilder(Quiz quiz){
        this.quiz = quiz;
    }


    QuizBuilder addQuizName(String quizName){
        this.quiz.setQuizName(quizName);
        return this;
    }

    QuizBuilder addQuizDescription(String quizDescription){
        this.quiz.setQuizDescription(quizDescription);
        return this;
    }

    QuizBuilder addQuizAnswer(String quizAnswer){
        this.quiz.setAnswerAfterPassing(quizAnswer);
        return this;
    }

    QuizBuilder addMaxPointsQuiz(int maxPointQuiz){
        this.quiz.setMaxPointsQuiz(maxPointQuiz);
        return this;
    }

    QuizBuilder addPoinsToPass(int pointsToPass){
        this.quiz.setPointsToPass(pointsToPass);
        return this;
    }

    QuizBuilder addNumberOfQuestions(int numberOfQuestions){
        this.quiz.setNumberOfQuestions(numberOfQuestions);
        return this;
    }

    QuizBuilder addQuestionsToList(List <Question> questilnsList){
        this.quiz.setQusetionsList(questilnsList);
        return this;
    }

    Quiz done(){
        return this.quiz;
    }
}
