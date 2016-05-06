package practice.practiceQuiz;


import manualQuizBuilding.DataGeter;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

/**
 * Created by ja on 01.05.16.
 */
public class QuestionAnswererTest {

    private static final int MIN_ANSWER = 1;
    private static final int MAX_ANSWER = 4;

    @Test
    public void testWhatSingleAnswerIsChoosen() {

        QuestionAnswerer questionAnswerer = new QuestionAnswerer();
        DataGeter mockDataGeter = mock(DataGeter.class);
        int answer = 1;
        stub(mockDataGeter.askForInteger("Podaj liczbe w przedziale " + MIN_ANSWER + " do " + MAX_ANSWER)).toReturn(answer);

        int expected = 1;

        int result = questionAnswerer.choseSingleAnswer(mockDataGeter);


        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void testWhatMultipluAnswersAreChoosen(){
        //given
        QuestionAnswerer questionAnswerer = new QuestionAnswerer();
        DataGeter mockDataGeter = mock(DataGeter.class);
        ArrayList<Integer> result;
        int answer = 1;
        stub(mockDataGeter.askForInteger("Podaj liczbe w przedziale " + MIN_ANSWER + " do " + MAX_ANSWER)).toReturn(answer);
        //when

        result = (questionAnswerer.choseMultiplyAnswer(mockDataGeter));

        int expected =1;
        ArrayList<Integer>expectedList = new ArrayList<>();
        expectedList.add(expected);
        //then
        assertThat(expectedList).isEqualTo(result);



    }


    }
