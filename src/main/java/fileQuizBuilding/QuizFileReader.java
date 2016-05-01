package fileQuizBuilding;

import settings.Answer;
import settings.Category;
import settings.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 18.04.16.
 */

public class QuizFileReader {
    public static List<Question> readFileforQuestion() {
        String line;
        String questionName = null;
        String answerName = null;
        Category enCategory = null;
        int pointsbyAnser;
        int maxPointsByQuestion;
        int numberOFAnswers;
        boolean isAnswerCorrect;
        boolean isQuestionMultiply;
        List<Answer> answerList = new ArrayList<Answer>();
        Question question = null;
        Answer answer;
        List<Question> questionList = new ArrayList<Question>();
        File file = new File("src/main/quiz1test");

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            while ((line = in.readLine()) != null) {

                if (line.startsWith("?")) {

                    numberOFAnswers = getNumberOFAnswers(line);
                    enCategory = Category.valueOf(line.substring(line.indexOf('%') + 1, line.indexOf('#') - 1));
                    isQuestionMultiply = new Boolean(line.substring(line.indexOf('*') + 1));
                    questionName = line.substring(1, line.indexOf('%'));

                    answerList = new ArrayList<Answer>();

                    question = new Question(questionName, enCategory, isQuestionMultiply, numberOFAnswers, answerList);
                    questionList.add(question);

                }

                else if (line.startsWith("!")) {

                    answerName = line.substring(line.indexOf("!") + 1, line.indexOf("%") - 1);
                    enCategory = Category.valueOf(line.substring(line.indexOf('%') + 1, line.indexOf('^') - 1));
                    pointsbyAnser = Integer.parseInt(line.substring(line.indexOf("^") + 1, line.indexOf("*") - 1));
                    isAnswerCorrect = new Boolean(line.substring(line.indexOf('*') + 1));

                    answer = new Answer(answerName, enCategory, pointsbyAnser, isAnswerCorrect);
                    answerList.add(answer);

                    question.countingMaxPoints();

                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    private static int getNumberOFAnswers(String line) {
        int numberOFAnswers;
        numberOFAnswers = Integer.parseInt(line.substring(line.indexOf('#') + 1, line.indexOf('*') - 1));
        return numberOFAnswers;
    }
}
