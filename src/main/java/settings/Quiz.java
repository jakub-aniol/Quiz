package settings;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by jakub on 18.04.16.
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
    @OneToMany
    private List<Question> qusetionsList;

    public Quiz(){}

    public Quiz(List<Question> questionsList) {
        this.setQusetionsList(questionsList);
        countMaxPointForQuiz();
    }


    public int getMaxPointsQuiz() {
        return maxPointsQuiz;
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

    public void setMaxPointsQuiz(int maxPointsQuiz) {
        this.maxPointsQuiz = maxPointsQuiz;
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

    public void countMaxPointForQuiz(){
        int maxPoint = 0;
        for(Question que : this.getQuestionList()){
            que.countingMaxPoints();
            maxPoint+=que.getMaxPoints();
        }
        this.setMaxPointForQuiz(maxPoint);
    }

    public int countingGainedPoints(Quiz quiz) {
        boolean choosen = true;
        int getherPoints = 0;

        for(Question ques : quiz.getQuestionList())
            for (Answer ans : ques.getAnswerList()) {
                if (ans.getChoosen() == choosen) {
                    if (ans.getIsProper() == ans.getIsProper()) {
                        getherPoints+= ans.getAnswerPoints();
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
