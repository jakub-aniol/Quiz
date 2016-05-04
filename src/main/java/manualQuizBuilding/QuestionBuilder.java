package manualQuizBuilding;

import settings.Question;

import java.util.List;

/**
 * Created by jakub on 04.05.16.
 */
class QuestionBuilder {

    private Question question = new Question();

    QuestionBuilder(Question q) {
        this.question = q;
    }

    // addQuestionName
    // list of answers
    // points (counted from answers)
    //is multiply
    //category

    QuestionBuilder addQuestionName(String name) {
        question.setQuestionName(name);
        return this;
    }

    QuestionBuilder addAnswerToQuestion(List answersList) {
        question.setAnswerList(answersList);
        return this;
    }

    QuestionBuilder addIsMultiply(boolean isMultiply){
        question.setMultiply(isMultiply);
        return this;
    }

    QuestionBuilder addMaxPoints(int maxPoints){
        question.setMaxPoints(maxPoints);
        return this;
    }

    QuestionBuilder addNumberOfAbswers(int numberOfAnswers){
        question.setNumberOfAnswers(numberOfAnswers);
        return this;
    }

    Question done() {
        return question;
    }
}
