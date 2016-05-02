package manualQuizBuilding;

import entityFactory.DAO;
import org.apache.log4j.Logger;
import settings.Answer;
import settings.Category;
import settings.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by jakub on 18.04.16.
 */

public class QuestionCreator {

    final static Logger logger = Logger.getLogger(QuestionCreator.class.getName());

    public Question creatigQuestion() {
        DataGeter dataGeter = new DataGeter(System.in, System.out);
        List<Answer> answerList = new ArrayList<>();
        String questionName = decideQuestionName(dataGeter);
        int ansNumber = decideAnswersNumber(dataGeter);
        boolean multiply = setMultipilty(ansNumber);
        Category category = asignToCategory(dataGeter);

        asignAnswers(answerList, ansNumber, category);
        Question question = new Question(questionName, category, multiply, ansNumber, answerList);
        DAO.addingDbQuestion(question);
        logger.info("Dodane pytanie: " + question.getQuestionName());

        return question;
    }

    private void asignAnswers(List<Answer> answerList, int ansNumber, Category category) {
        AnswerCreator answerCreator = new AnswerCreator();
        System.out.println("Przypisuj odpowiedzi");
        for (int i = 0; i < ansNumber; i++) {
            answerList.add(answerCreator.creatingAnswer(category));
        }
    }

    public Category asignToCategory(DataGeter dataGeter) {
        Category category;
        category = dataGeter.askForCategory("Wybierz Kategorię z podanej listy");
        System.out.println(Arrays.toString(Category.values()));
        /*while (!category.equals(Category.valueOf(category.toString())));
        category= dataGeter.askForCategory("podałeś złą kategorię spubuj pobownie");
            for (Category a : Category.values()){
                if (category.equals(a))
            break;
        }*/
        return category;
    }

    public boolean setMultipilty(int ansNumber) {
        boolean wielokrotnie = true;
        if (ansNumber > 1)
            return wielokrotnie;
        return !wielokrotnie;
    }

    public static int decideAnswersNumber(DataGeter dataGeter) {
        int ansNumber = 0;
        try {
            ansNumber = dataGeter.askForInteger("Podaj ilość odpowiedzi pomiędzy 1 a 4");
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        while (ansNumber < 1 || ansNumber > 4)
            try {
                ansNumber = dataGeter.askForInteger("");
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        return ansNumber;
    }

    public static String decideQuestionName(DataGeter dataGeter) {
        String strName;
        strName = dataGeter.askForString("Podaj nazwę pytania");
        return strName;
    }
}
