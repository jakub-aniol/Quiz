package practice.presentingQuiz;

import org.testng.annotations.Test;
import settings.Answer;
import settings.Category;
import settings.Question;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ja on 01.05.16.
 */
public class QuestionPresenterTest {

    @Test
    public void testIfProperStringisReturned(){
        QuestionPresenter questionPresenter = new QuestionPresenter();

        Answer answer = Answer.createAnswer("Pytanie", Category.GIT, 2, true);
        Question mockQuestion = mock(Question.class);
        when(mockQuestion.getQuestionName()).thenReturn("Pytanie");
        List <Answer> lista = new ArrayList<>();
        lista.add(answer);
        when(mockQuestion.getAnswerList()).thenReturn(lista);
        String expected = "Pytanie\n1. Pytanie  2   false\n";

        //when
        String result = QuestionPresenter.showQuestion(mockQuestion);
        System.out.println(result);
        //then
        assertThat(result).isEqualTo(expected);

    }


}
