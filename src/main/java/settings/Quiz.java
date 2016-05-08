package settings;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Object for storying information about the whole Quiz
 * Created by Jakub
 * Since 2016-04-30.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Quiz {
    @Id
    @GeneratedValue
    private int Id;
    private String quizName;
    private String quizDescription;
    private String answerAfterPassing;
    private int maxPointsQuiz;
    private int pointsToPass;
    private int numberOfQuestions;
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Question> qusetionsList;


    public Quiz() {
    }

    public Quiz(Quiz quiz) {
        this.quizName=quiz.quizName;
        this.quizDescription=quiz.quizDescription;
        this.answerAfterPassing=quiz.answerAfterPassing;
        this.maxPointsQuiz=quiz.maxPointsQuiz;
        this.pointsToPass=quiz.pointsToPass;
        this.numberOfQuestions=quiz.numberOfQuestions;
        this.qusetionsList=new ArrayList<>(quiz.qusetionsList);
    }

    /**
     * Constructor, Question must have:
     * Now you can provide only Lit of question to create Quiz it is only one implementation of a constructor
     * Additionally quiz couts maxPopintsQuiz by itself using method countMaxPointForQuiz()
     *
     * @param questionsList - List with objects Question {@link settings.Question}
     */
    public Quiz(List<Question> questionsList) {
        this.setQusetionsList(questionsList);
        countMaxPointForQuiz();
    }

    public int getMaxPointsQuiz() {
        return maxPointsQuiz;
    }

    public void setMaxPointsQuiz(int maxPointsQuiz) {
        this.maxPointsQuiz = maxPointsQuiz;
    }

    public String getQuizName() {
        return this.quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public List<Question> getQuestionList() {
        return this.getQusetionsList();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getQuizDescription() {
        return quizDescription;
    }

    public void setQuizDescription(String quizDescription) {
        this.quizDescription = quizDescription;
    }

    public String getAnswerAfterPassing() {
        return answerAfterPassing;
    }

    public void setAnswerAfterPassing(String answerAfterPassing) {
        this.answerAfterPassing = answerAfterPassing;
    }

    public int getPointsToPass() {
        return pointsToPass;
    }

    public void setPointsToPass(int pointsToPass) {
        this.pointsToPass = pointsToPass;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    List<Question> getQusetionsList() {
        return qusetionsList;
    }

    public void setQusetionsList(List<Question> qusetionsList) {
        this.qusetionsList = qusetionsList;
    }

    /**
     * Method for counting points one can get for a quiz
     * It uses a method countingMaxPoints() in a loop to count maxPoints by adding points from one question to another {@link settings.Question}
     */

    public void countMaxPointForQuiz() {
        int maxPoint = 0;
        for (Question que : this.getQuestionList()) {
            que.countingMaxPoints();
            maxPoint += que.getMaxPoints();
        }
        this.setMaxPointsQuiz(maxPoint);
    }



    public String toString() {
        String strReturn = "";
        strReturn += this.getQuizName();
        strReturn += "\n";
        strReturn += this.getQusetionsList();
        return strReturn;
    }
}
