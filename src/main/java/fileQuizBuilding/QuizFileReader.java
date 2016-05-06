package fileQuizBuilding;

import settings.Answer;
import settings.Category;
import settings.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Object alowing to create an answer from a given properly prepared file
 * Created by Jakub
 * Since 2016-04-30.
 */

public class QuizFileReader {

    public static List<Question> readFileForQuestion(String fileName) {
        String line;
        String questionName;
        String answerName;
        Category enCategory;
        int pointsByAnwser;
        int numberOFAnswers;
        boolean isAnswerCorrect;
        boolean isQuestionMultiply;
        List<Answer> answerList = new ArrayList<>();
        Question question = null;
        Answer answer;
        List<Question> questionList = new ArrayList<>();
        File file = new File(fileName);

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            while ((line = in.readLine()) != null) {
                if (line.startsWith("?")) {
                    numberOFAnswers = getNumberOFAnswers(line);
                    enCategory = Category.valueOf(line.substring(line.indexOf('%') + 1, line.indexOf('#') - 1));
                    isQuestionMultiply = Boolean.valueOf(line.substring(line.indexOf('*') + 1));
                    questionName = line.substring(1, line.indexOf('%'));

                    answerList = new ArrayList<>();

                    question = new Question(questionName, enCategory, isQuestionMultiply, numberOFAnswers, answerList);
                    questionList.add(question);

                } else if (line.startsWith("!")) {
                    answerName = line.substring(line.indexOf("!") + 1, line.indexOf("%") - 1);
                    enCategory = Category.valueOf(line.substring(line.indexOf('%') + 1, line.indexOf('^') - 1));
                    pointsByAnwser = Integer.parseInt(line.substring(line.indexOf("^") + 1, line.indexOf("*") - 1));
                    isAnswerCorrect = Boolean.valueOf(line.substring(line.indexOf('*') + 1));

                    answer = Answer.createAnswer(answerName, enCategory, pointsByAnwser, isAnswerCorrect);
                    answerList.add(answer);

                    question.countingMaxPoints();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException a){
            a.printStackTrace();
        }
    return questionList;
    }

    private static int getNumberOFAnswers(String line) {
        int numberOFAnswers;
        numberOFAnswers = Integer.parseInt(line.substring(line.indexOf('#') + 1, line.indexOf('*') - 1));
        return numberOFAnswers;
    }
}
