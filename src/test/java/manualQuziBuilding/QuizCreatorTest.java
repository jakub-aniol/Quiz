package manualQuziBuilding;

import manualQuizBuilding.QuizCreator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import settings.Answer;
import settings.Category;
import settings.Question;
import settings.Quiz;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ja on 01.05.16.
 */
public class QuizCreatorTest {

    @BeforeTest
    public void setUp() {

    }

    @Test
    public void testIfQuizHasProperName() {

        //given
        QuizCreator quizCreator = new QuizCreator();
        String expected = "Moj pierwszy Quiz";

        //when
        Quiz result = quizCreator.makeQuiz();

        //then
        assertThat(result.getQuizName()).isEqualTo(expected);
    }

    @Test
    public void testIfQuizIsMade() {

        //given
        QuizCreator quizCreator = new QuizCreator();
        Quiz expected = new Quiz();

        //when
        Quiz result = quizCreator.makeQuiz();

        //then
        assertThat(result).hasSameClassAs(expected);
    }

    @Test
    public void testIfQuizIsMadeWithQuestionList() {
        //given
        QuizCreator quizCreator = new QuizCreator();

        Answer answer = Answer.createAnswer("Odpowiedź", Category.GIT, 2, true);
        List<Answer> answersList = new ArrayList<>();
        answersList.add(answer);
        Question question = new Question("Pytanie", Category.GIT, false, 1, answersList);
        question.setMaxPoints(2);
        List<Question> questionList = new ArrayList<>();
        questionList.add(question);
        Quiz expected = new Quiz(questionList);
        expected.setQuizName("Moj pierwszy Quiz");
        //when
        Quiz result = quizCreator.makeQuiz(questionList);

        //then
        assertThat(result).isEqualsToByComparingFields(expected);
    }

}
