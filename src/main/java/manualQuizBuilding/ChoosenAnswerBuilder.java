package manualQuizBuilding;

import settings.ChoosenAnswer;

/**
 * Created by ja on 08.05.16.
 */
public class ChoosenAnswerBuilder extends AnswerBuilder {
    private ChoosenAnswer choosenAnswer;

    ChoosenAnswerBuilder(){}

    ChoosenAnswerBuilder(ChoosenAnswer choosenAnswer){
        super(choosenAnswer);
    }

    ChoosenAnswerBuilder addChoosenAnswer(boolean choosen){
        this.choosenAnswer.setChoosen(choosen);
        return this;
    }

    ChoosenAnswer done(){
        return this.choosenAnswer;
    }
}
