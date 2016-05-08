package manualQuizBuilding;

import settings.Category;
import settings.Question;

import java.util.List;

/**
 * Created by jakub on 04.05.16.
 */
class QuestionBuilder {

    private Question question = new Question();

    QuestionBuilder(){}

    QuestionBuilder(Question q) {
        this.question = q;
    }

    QuestionBuilder addQuestionName(String name) {
        question.setQuestionName(name);
        return this;
    }

    QuestionBuilder addAnswersToQuestion(List <settings.Answer>answersList) {
        question.setAnswerList(answersList);
        return this;
    }

    QuestionBuilder addIsMultiply(boolean isMultiply){
        question.setIsMultiply(isMultiply);
        return this;
    }

    QuestionBuilder addMaxPoints(int maxPoints){
        question.setMaxPoints(maxPoints);
        return this;
    }

    QuestionBuilder addNumberOfAnswers(int numberOfAnswers){
        question.setNumberOfAnswers(numberOfAnswers);
        return this;
    }

    QuestionBuilder addCategory(Category category){
        this.question.setCategory(category);
        return this;
    }

    Question done() {
        return question;
    }
}
