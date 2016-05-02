package manualQuizBuilding;

/**
 * Created by ja on 18.04.16.
 */
public class WrongAmountOfAnswersException extends Throwable {

    public WrongAmountOfAnswersException(){}

    public WrongAmountOfAnswersException(String name) {
        super(name);
    }
}
