package settings;

import javax.persistence.*;
import java.util.List;

import static java.util.Collections.max;

/**
 * Created by jakub on 18.04.16.
 */
@Entity(name = "Pytania")
public class Question {
    @Id
    @GeneratedValue
    private int Id;
    public int maxPoints;
    private String questionName;
    private Category category;
    private int eIDPytanie;
    private int numberOfAnswers;
    private boolean isMultiply;
    private int gainedPoints;
    @OneToMany
    private List<Answer> answerList;
    @ManyToOne
    @JoinColumn(name="Quiz_ID")
    private Quiz quiz;

    public Question(){}

    public Question(String questionName, Category category, boolean isMultiply, int numberOfAnswers, List<Answer> answer) {
        this.questionName = questionName;
        this.category = category;
        this.isMultiply = isMultiply;
        this.numberOfAnswers = numberOfAnswers;
        this.answerList = answer;
    }

    public boolean isMultiply() {
        return isMultiply;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getGainedPoints() {
        return gainedPoints;
    }

    public void setGainedPoints(int gainedPoints) {
        this.gainedPoints = gainedPoints;
    }

    public String getQuestionName() {
        return this.questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int geteIDPytanie() {
        return eIDPytanie;
    }

    public void seteIDPytanie(int eIDPytanie) {
        this.eIDPytanie = eIDPytanie;
    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }

    public void setMultiply(boolean multiply) {
        isMultiply = multiply;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    /**
     * Created by jakub on 18.04.16.
     * For multiply question answer ads each answer points if those are established proper
     * For single question answer choose the answer with max points between others answers in question
     * and if it is established proper
     */
    public void countingMaxPoints() {
        int maxPoints = 0;
        boolean proper = true;

        if (this.isMultiply() == true) {

            for (Answer answer : this.answerList) {
                if (answer.getIsProper() == proper)
                    maxPoints += answer.getAnswerPoints();
            }
            this.maxPoints = maxPoints;
        } else {
            Answer answer = max(this.answerList);
            if (answer.getIsProper() == proper)
                this.maxPoints = answer.getAnswerPoints();
        }
    }

    public void countingGainedPoints() {
        int gainedPoints = 0;
        boolean proper = true;

        if (this.isMultiply() == true) {

            for (Answer answer : this.answerList) {
                if (answer.getIsProper() == proper && answer.getChoosen() ==proper)
                    gainedPoints += answer.getAnswerPoints();
            }
            this.setGainedPoints(gainedPoints);

        } else {
            Answer answer = max(this.answerList);
            if (answer.getIsProper() == proper && answer.getChoosen()==proper)
                gainedPoints = answer.getAnswerPoints();
            this.setGainedPoints(gainedPoints);
        }
    }


    @Override
    public String toString() {
        String strReturn = "\n";
        strReturn += this.questionName + " " + this.maxPoints;
        strReturn += "\n";
        strReturn += this.answerList;
        return strReturn;
    }


}
