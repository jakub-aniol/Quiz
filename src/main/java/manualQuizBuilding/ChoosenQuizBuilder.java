package manualQuizBuilding;

import settings.ChoosenQuiz;

/**
 * Created by ja on 08.05.16.
 */
public class ChoosenQuizBuilder extends QuizBuilder{
    private ChoosenQuiz choosenQuiz;

    ChoosenQuizBuilder(ChoosenQuiz choosenQuiz){
        super(choosenQuiz);
        this.choosenQuiz = choosenQuiz;
    }

    ChoosenQuizBuilder addChoosenQuizUserName(String userName) {
        this.choosenQuiz.setUserName(userName);
        return this;
    }

    ChoosenQuizBuilder addChoosenQuizUserLastName(String userLastName){
        this.choosenQuiz.setUserLastName(userLastName);
        return this;
    }

    ChoosenQuiz done(){
        return this.choosenQuiz;
    }
}
