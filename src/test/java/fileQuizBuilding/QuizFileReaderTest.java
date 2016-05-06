package fileQuizBuilding;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import settings.Answer;
import settings.Category;
import settings.Question;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ja on 01.05.16.
 */
public class QuizFileReaderTest {

    private final SoftAssert softAssert = new SoftAssert();

    @Test
    public void testiIfListOfQuestionsIsReturned() {
        List<Question> t = new ArrayList<>();
        assertThat(QuizFileReader.readFileForQuestion("src/test/quiz1test")).hasSameClassAs(t);

    }

    @Test
    public void testIfListOfQuestionContainsProperQuestionsValue() {
        //given
        List<Question> list;
        list = QuizFileReader.readFileForQuestion("src/test/quiz1test");

        //when
        String resultName = list.get(0).getQuestionName();
        Category resultCategory = list.get(0).getCategory();
        int resultInt = list.get(0).getNumberOfAnswers();
        boolean resultIsMultiply = list.get(0).isMultiply();

        String resultName2 = list.get(1).getQuestionName();
        Category resultCategory2 = list.get(1).getCategory();
        int resultInt2 = list.get(1).getNumberOfAnswers();
        boolean resultIsMultiply2 = list.get(1).isMultiply();

        softAssert.assertEquals(resultName, "Pytanie1");
        softAssert.assertEquals(resultCategory, Category.JavaCore);
        softAssert.assertEquals(resultInt, 4);
        softAssert.assertEquals(resultIsMultiply, true);

        softAssert.assertEquals(resultName2, "Pytanie2");
        softAssert.assertEquals(resultCategory2, Category.SQL);
        softAssert.assertEquals(resultInt2, 4);
        softAssert.assertEquals(resultIsMultiply2, false);

        softAssert.assertAll();

    }

    @Test
    public void testIfListOfQuestionContainsProperAnswersValue() {
        //given
        List<Question> list;
        list = QuizFileReader.readFileForQuestion("src/test/quiz1test");

        Answer[][] answersList = new Answer[2][4];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(1).getAnswerList().size(); j++) {
                String name = list.get(i).getAnswerList().get(j).getAnswerName();
                Category nameCategory = list.get(i).getAnswerList().get(j).getCategory();
                int points = list.get(i).getAnswerList().get(j).getAnswerPoints();
                boolean isProper = list.get(i).getAnswerList().get(j).getIsProper();

                answersList[i][j] = Answer.createAnswer(name, nameCategory, points, isProper);
            }
        }
        //when
        softAssert.assertEquals(answersList[0][0].getAnswerName(), "Odpowiedź zła pierwsza");
        softAssert.assertEquals(answersList[0][0].getCategory(), Category.JavaCore);
        softAssert.assertEquals(answersList[0][0].getAnswerPoints(), 1);
        softAssert.assertEquals(answersList[0][0].getIsProper(), false);

        softAssert.assertEquals(answersList[0][1].getAnswerName(), "Odpowiedź zła pierwsza");
        softAssert.assertEquals(answersList[0][1].getCategory(), Category.JavaCore);
        softAssert.assertEquals(answersList[0][1].getAnswerPoints(), 11);
        softAssert.assertEquals(answersList[0][1].getIsProper(), false);

        softAssert.assertEquals(answersList[0][2].getAnswerName(), "Odpowiedź pierwsza dobra");
        softAssert.assertEquals(answersList[0][2].getCategory(), Category.JavaCore);
        softAssert.assertEquals(answersList[0][2].getAnswerPoints(), 2);
        softAssert.assertEquals(answersList[0][2].getIsProper(), true);

        softAssert.assertEquals(answersList[0][3].getAnswerName(), "Odpowiedź pierwsza dobra");
        softAssert.assertEquals(answersList[0][3].getCategory(), Category.JavaCore);
        softAssert.assertEquals(answersList[0][3].getAnswerPoints(), 2);
        softAssert.assertEquals(answersList[0][3].getIsProper(), true);

        softAssert.assertEquals(answersList[1][0].getAnswerName(), "Odpowiedź zła druga");
        softAssert.assertEquals(answersList[1][0].getCategory(), Category.SQL);
        softAssert.assertEquals(answersList[1][0].getAnswerPoints(), -1);
        softAssert.assertEquals(answersList[1][0].getIsProper(), false);

        softAssert.assertEquals(answersList[1][1].getAnswerName(), "Odpowiedź zła druga");
        softAssert.assertEquals(answersList[1][1].getCategory(), Category.SQL);
        softAssert.assertEquals(answersList[1][1].getAnswerPoints(), 0);
        softAssert.assertEquals(answersList[1][1].getIsProper(), false);

        softAssert.assertEquals(answersList[1][2].getAnswerName(), "Odpowiedź druga dobra");
        softAssert.assertEquals(answersList[1][2].getCategory(), Category.SQL);
        softAssert.assertEquals(answersList[1][2].getAnswerPoints(), 22);
        softAssert.assertEquals(answersList[1][2].getIsProper(), true);

        softAssert.assertEquals(answersList[1][3].getAnswerName(), "Odpowiedź druga dobra");
        softAssert.assertEquals(answersList[1][3].getCategory(), Category.SQL);
        softAssert.assertEquals(answersList[1][3].getAnswerPoints(), 3);
        softAssert.assertEquals(answersList[1][3].getIsProper(), false);

        softAssert.assertAll();

    }

}

