package settings;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jakub on 21.04.16.
 */

public class QuizTest {

    private final Answer answer1e = Answer.createAnswer("Pytanie1", Category.SQL, 2, true);
    private final Answer answer2e = Answer.createAnswer("Pytanie2", Category.SQL, 3, true);
    private final Answer answer3e = Answer.createAnswer("Pytanie3", Category.SQL, 4, true);

    private final List<Answer> listAnswersT = new ArrayList<>();
    private final List<Answer> listAnswersF = new ArrayList<>();

    private final Question quest1 = new Question("Wielokrotne", Category.GIT, true, 2, listAnswersT);
    private final Question quest2 = new Question("Wielokrotne", Category.GIT, true, 2, listAnswersF);
    private final Question quest3 = new Question("Jednokrotne", Category.GIT, false, 2, listAnswersT);
    private final Question quest4 = new Question("Jednokrotne", Category.GIT, false, 2, listAnswersF);

    private final List<Question> listQuestions = new ArrayList<>();

    {
        listAnswersT.add(answer1e);
        listAnswersT.add(answer2e);
    }

    {
        listAnswersF.add(answer2e);
        listAnswersF.add(answer3e);
    }

    {
        listQuestions.add(quest1);
        listQuestions.add(quest2);
        listQuestions.add(quest3);
        listQuestions.add(quest4);
    }

   /* @BeforeTest
    public void setup() {
        answer1e.setChoosen(true);
        answer2e.setChoosen(true);
        answer3e.setChoosen(true);
    }*/

    @Test
    public void testIfCountingMaxPointForQuizIsProper() {
        //given
        Quiz quiz = new Quiz(listQuestions);
        int expected = 19;
        //when
        int result;
        quiz.countMaxPointForQuiz();
        result = quiz.getMaxPointsQuiz();
        //then
        assertThat(expected).isEqualTo(result);
    }

   /* @Test
    public void testIfGetherdPointForQuizIsProper() {
        //given
        Quiz quiz = new Quiz(listQuestions);
        int expected = 19;
        //when
        int result;
        quiz.countingGainedPoints(quiz);
        result = quiz.getMaxPointsQuiz();
        //then
        assertThat(expected).isEqualTo(result);
    }*/
}
