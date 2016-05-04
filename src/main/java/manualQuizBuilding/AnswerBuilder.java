package manualQuizBuilding;

import settings.Answer;
import settings.Category;

/**
 * Created by jakub on 04.05.16.
 */
class AnswerBuilder {

    private Answer answer = new Answer();

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

    Answer done(){
        return this.answer;
    }

}
