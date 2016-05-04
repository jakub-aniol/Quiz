package manualQuziBuilding;

/**
 * Created by jakub on 02.05.16.
 */
public class AnswerCreatorTest {

    /*@Test
    public void testIfProperNameOfAnswerIsReturned() {

        AnswerCreator answerCreator = new AnswerCreator();
        DataGeter mockDataGeter = mock(DataGeter.class);
        String answerName = "Odpowiedź";
        stub(mockDataGeter.askForString("Podaj treść odpowiedź")).toReturn(answerName);

        String expectedName = "Odpowiedź";
        String result = answerCreator.decideAnswerName(mockDataGeter);

        assertThat(expectedName).isEqualTo(result);
    }*/

    /*@Test
    public void testIfAnswerIsCorrect() {

        AnswerCreator answerCreator = new AnswerCreator();
        DataGeter mockDataGeter = mock(DataGeter.class);
        String isCorrect = "t";
        stub(mockDataGeter.askForString("czy odpowiedź jest prawdziwa? Jeśli tak wpisz T, w przeciwnym razie będzie fałszywa")).toReturn(isCorrect);

        boolean expected = true;
        boolean result = answerCreator.isAnswerCorrect(mockDataGeter);

        assertThat(expected).isEqualTo(result);


    }

    @Test
    public void testIfAnswerIsNotCorrect() {
        AnswerCreator answerCreator = new AnswerCreator();
        DataGeter mockDataGeter = mock(DataGeter.class);
        String isCorrect = "jakis string";
        stub(mockDataGeter.askForString("czy odpowiedź jest prawdziwa? Jeśli tak wpisz T, w przeciwnym razie będzie fałszywa")).toReturn(isCorrect);

        boolean expected = false;
        boolean result = answerCreator.isAnswerCorrect(mockDataGeter);

        assertThat(expected).isEqualTo(result);

    }*/

    /*@Test
    public void testIfPointsOfAnswerIsReturned() throws Exception {
        AnswerCreator answerCreator = new AnswerCreator();
        DataGeter mockDataGeter = mock(DataGeter.class);
        int points = 1;
        stub(mockDataGeter.askForInteger("Podaj liczbe punktow za odpowiedź")).toReturn(points);

        int expected =1;
        int result = answerCreator.decideMaxPoints(mockDataGeter);

        assertThat(expected).isEqualTo(result);

    }*/

}
