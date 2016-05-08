package manualQuizBuilding;

import settings.ChoosenQuestion;

/**
 * Created by ja on 08.05.16.
 */
public class ChoosenQuestionBuilder extends QuestionBuilder{
    private ChoosenQuestion choosenQuestion;

    ChoosenQuestionBuilder(ChoosenQuestion choosenQuestion){
        super(choosenQuestion);
        this.choosenQuestion=choosenQuestion;
    }


    ChoosenQuestionBuilder addGainedPoints(int gaindedPoints){
        this.choosenQuestion.setGainedPoints(gaindedPoints);
        return this;
    }

    ChoosenQuestion done(){
        return this.choosenQuestion;
    }

}
