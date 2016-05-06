package manualQuziBuilding;

//import static org.mockito.Mockito.when;

/**
 * Created by ja on 01.05.16.
 */
class QuestionCreatorTest {

   /* @Test
    public void testIfProperCategoryofQuestionIsReturned() {

        QuestionCreator questionCreator = new QuestionCreator();
        Category category = Category.GIT;
        DataGeter mockDataGeter = mock(DataGeter.class);
        stub(mockDataGeter.askForCategory("Wybierz Kategorię z podanej listy")).toReturn(category);
        Category expected = Category.GIT;
        assertThat(expected).isEqualTo(questionCreator.asignToCategory(mockDataGeter));
    }

    @Test
    public void testIfProperNameOfQuestionIsReturned() {

        QuestionCreator questionCreator = new QuestionCreator();
        String str = "Pytanie";
        DataGeter mockDataGeter = mock(DataGeter.class);
        stub(mockDataGeter.askForString("Podaj nazwę pytania")).toReturn(str);
        String expected = "Pytanie";
        assertThat(expected).isEqualTo(QuestionCreator.decideQuestionName(mockDataGeter));
    }

    @Test
    public void testIfProperNumberOfQuestionIsReturned() throws Exception {
        QuestionCreator questionCreator = new QuestionCreator();
        Integer numberOfAnswers = 3;
        DataGeter mockDataGeter = mock(DataGeter.class);
        stub(mockDataGeter.askForInteger("Podaj ilość odpowiedzi pomiędzy 1 a 4")).toReturn(numberOfAnswers);
        Integer expected = 3;
        assertThat(expected).isEqualTo(QuestionCreator.decideAnswersNumber(mockDataGeter));
    }


    @Test
    public void testIfQuestionIsSetToMultiply(){
        QuestionCreator questionCreator = new QuestionCreator();
        int numberOfAnswers = 3;
        boolean expected = true;
        boolean result = questionCreator.setMultipilty(numberOfAnswers);
        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void testIfQuestionIsNotSetToMultiply(){
        QuestionCreator questionCreator = new QuestionCreator();
        int numberOfAnswers = 1;
        boolean expected = false;
        boolean result = questionCreator.setMultipilty(numberOfAnswers);
        assertThat(expected).isEqualTo(result);
    }*/

}
