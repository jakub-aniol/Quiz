package settings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Object for storying information about the whole Quiz
 * Created by Jakub
 * Since 2016-04-30.
 */
@Entity
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
    @OneToMany(mappedBy = "quiz")
    private List<Question> qusetionsList;

    public Quiz() {
    }
    /**
     * Constructor, Question must have:
     * Now you can provide only Lit of question to create Quiz it is only one implementation of a constructor
     * Additionally quiz couts maxPopintsQuiz by itslef using method countMaxPointForQuiz()
     * @param questionsList - List with objetcs Question {@link settings.Question}
     *
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

    public void setMaxPointForQuiz(int maxPointForQuiz) {
        this.setMaxPointsQuiz(maxPointForQuiz);
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

    public List<Question> getQusetionsList() {
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
        this.setMaxPointForQuiz(maxPoint);
    }

    /**
     * Method for counting points one got for a quiz
     * if Answer param isPorper is established to true and answer is matched as choosen it added points one geins while doing quiz.
     *
     * @param quiz {@link settings.Quiz}
     * @return int
     */
    public int countingGainedPoints(Quiz quiz) {
        boolean choosen = true;
        int getherPoints = 0;

        for (Question ques : quiz.getQuestionList())
            for (Answer ans : ques.getAnswerList()) {
                if (ans.getChoosen() == choosen) {
                    if (ans.getIsProper() == ans.getIsProper()) {
                        getherPoints += ans.getAnswerPoints();
                    }
                }
            }
        return getherPoints;
    }


    public String toString() {
        String strReturn = "";
        strReturn += this.getQuizName();
        strReturn += "\n";
        strReturn += this.getQusetionsList();
        return strReturn;
    }
}
