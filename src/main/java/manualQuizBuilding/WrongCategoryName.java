package manualQuizBuilding;

/**
 * Created by jakub on 05.05.16.
 */
public class WrongCategoryName extends Exception{
    public WrongCategoryName(){}

    public WrongCategoryName(String name){
        super(name);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
