package settings;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jakub on 25.04.16.
 */
public class QuestionTest {

    private Question question1;
    private Question question2;
    private final List<Answer> answerList1 = new ArrayList<>();
    public List<Answer> getAnswerList1() {
        return answerList1;
    }

   /* @BeforeTest
    public void setUp() {
        Answer answer1 = AnswerTest.getAnswer1e();
        Answer answer2 = AnswerTest.getAnswer2e();

        answer1.setChoosen(true);
        answer2.setChoosen(true);

        answerList1.add(answer1);
        answerList1.add(answer2);

        question1 = new Question("Wielokrotne", Category.GIT, true, 2, answerList1);
        question2 = new Question("Jednokrotne", Category.GIT, false, 2, answerList1);
    }
*/
    @Test
    public void testIfPoinsAreCountedProperlyForMultiply() {
        //given
        int expected = 2;
        //when
        question1.countingMaxPoints();
        //then
        assertThat(question1.getMaxPoints()).isEqualTo(expected);
    }

    @Test
    public void testIfPoinsAreCountedProperlyForNotMultiply() {
        //given
        int expected = 0;
        //when
        question2.countingMaxPoints();
        //then
        assertThat(question2.getMaxPoints()).isEqualTo(expected);
    }

    /*@Test
    public void testsProperCountingGainedPointsForMultiplyAnswerQuestion() {
        //given
        int maxExpected = 2;
        //when
        int result;
        question1.countingGainedPoints();
        result = question1.getGainedPoints();
        //then
        assertThat(maxExpected).isEqualTo(result);
    }

    @Test
    public void testsProperCountingGainedPointsForSinglyAnswerQuestion() {
        //given
        int maxExpected = 0;
        //when
        int result;
        question2.countingGainedPoints();
        result = question2.getGainedPoints();
        //then
        assertThat(maxExpected).isEqualTo(result);
    }*/
}
