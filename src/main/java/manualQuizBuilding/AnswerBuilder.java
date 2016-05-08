package manualQuizBuilding;

import settings.Answer;
import settings.Category;
import settings.Question;

/**
 * Created by jakub on 04.05.16.
 */
class AnswerBuilder {

    private Answer answer = new Answer();

    AnswerBuilder(){}

    AnswerBuilder(Answer answer){
        this.answer = answer;
    }

    AnswerBuilder addName(String string){
        answer.setAnswerName(string);
        return this;
    }

    AnswerBuilder addPoints(int points){
        answer.setAnswerPoints(points);
        return this;
    }

    AnswerBuilder addCategory(Category category){
        answer.setCategory(category);
        return this;
    }

    AnswerBuilder addIsProper(boolean isProper){
        answer.setProper(isProper);
        return this;
    }

    AnswerBuilder addQuestion(Question question){
        answer.setQuestion(question);
        return this;
    }

    Answer done(){
        return this.answer;
    }

}
