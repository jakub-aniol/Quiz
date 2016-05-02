package settings;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jakub on 21.04.16.
 */
public class AnswerTest {
    static public Answer answer1e = Answer.createAnswer("Pytanie1", Category.SQL, 2, true);
    static public Answer answer2e = Answer.createAnswer("Pytanie1", Category.SQL, 3, false);
    private Answer answer3e;
    private Answer answer4e;
    private Answer answer1n;
    private Answer answer2n;
    private Answer answer3n;
    private Answer answer4n;
    private Answer answer5n;
    private Answer answer6n;
    private Answer answer7n;
    private Answer answer8n;
    private Answer answer9n;
    private Answer answer10n;
    private Answer answer11n;
    private Answer answer12n;
    private Answer answer13n;
    private Answer answer14n;
    private Answer answer15n;
    private Answer answer16n;

    public static Answer getAnswer1e() {
        return answer1e;
    }

    public static Answer getAnswer2e() {
        return answer2e;
    }

    @BeforeTest
    public void setUp() {
        Category sql = Category.SQL;
        Category javaCore = Category.JavaCore;
        String answerName1 = "Pytanie1";
        String answerName2 = "Pytanie2";
        int answerPoints1 = 2;
        int answerPoints2 = 3;
        boolean isProper1 = true;
        boolean isProper2 = false;


        answer1e = Answer.createAnswer(answerName1, sql, answerPoints1, isProper1);
        answer2e = Answer.createAnswer(answerName1, sql, answerPoints2, isProper2);
        answer3e = Answer.createAnswer(answerName1, sql, answerPoints1, isProper1);
        answer4e = Answer.createAnswer(answerName1, sql, answerPoints2, isProper2);

        answer1n = Answer.createAnswer(answerName2, sql, answerPoints1, isProper1);
        answer2n = Answer.createAnswer(answerName2, sql, answerPoints1, isProper2);
        answer3n = Answer.createAnswer(answerName2, sql, answerPoints2, isProper1);
        answer4n = Answer.createAnswer(answerName2, sql, answerPoints2, isProper2);
        answer5n = Answer.createAnswer(answerName2, javaCore, answerPoints1, isProper1);
        answer6n = Answer.createAnswer(answerName2, javaCore, answerPoints1, isProper2);
        answer7n = Answer.createAnswer(answerName2, javaCore, answerPoints2, isProper1);
        answer8n = Answer.createAnswer(answerName2, javaCore, answerPoints2, isProper2);
        answer9n = Answer.createAnswer(answerName1, sql, answerPoints1, isProper1);
        answer10n = Answer.createAnswer(answerName1, sql, answerPoints1, isProper2);
        answer11n = Answer.createAnswer(answerName1, sql, answerPoints2, isProper1);
        answer12n = Answer.createAnswer(answerName1, sql, answerPoints2, isProper2);
        answer13n = Answer.createAnswer(answerName1, javaCore, answerPoints1, isProper1);
        answer14n = Answer.createAnswer(answerName1, javaCore, answerPoints1, isProper2);
        answer15n = Answer.createAnswer(answerName1, javaCore, answerPoints2, isProper1);
        answer16n = Answer.createAnswer(answerName1, javaCore, answerPoints2, isProper2);
    }

    @DataProvider
    public Object[][] isAnswerEqual() {

        return new Answer[][]{{answer1e}, {answer2e}, {answer3e}, {answer4e}};
    }

    @Test(dataProvider = "isAnswerEqual")
    public void testsIfAnswersAreEqual(Answer answer) {
        //given
        Category sql = Category.SQL;
        String answerName1 = "Pytanie1";
        int answerPoints1 = 2;
        boolean isProper1 = true;

        Answer answer4 = Answer.createAnswer(answerName1, sql, answerPoints1, isProper1);

        //when
        boolean result = answer4.equals(answer);
        //then

        assertThat(result).isTrue();
    }

    @DataProvider
    public Object[][] isAnswerNotEqual() {

        return new Answer[][]{{answer1n}, {answer2n}, {answer3n}, {answer4n},
                {answer5n}, {answer6n}, {answer7n}, {answer8n},
                {answer9n}, {answer10n}, {answer11n}, {answer12n},
                {answer13n}, {answer14n}, {answer15n}, {answer16n}};
    }


    @Test(dataProvider = "isAnswerNotEqual")
    public void testsIsAnswersAreNotEqual(Answer answer) {
        //given
        Category slq = Category.SQL;
        String answerName1 = "Pytanie4";
        int answerPoints1 = 2;
        boolean isProper1 = true;
        Answer answer4 = Answer.createAnswer(answerName1, slq, answerPoints1, isProper1);

        //when
        boolean result = answer4.equals(answer);

        //then
        assertThat(result).isFalse();

    }






}
