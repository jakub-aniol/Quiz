package settings;

import javax.persistence.*;
import java.util.List;

import static java.util.Collections.max;

/**
 * Object for storying information about single Question
 * Created by Jakub
 * Since 2016-04-30.
 */
@Entity(name = "Pytania")
public class Question {
    @Id
    @GeneratedValue
    private int Id;
    private String questionName;
    private Category category;
    private int numberOfAnswers;
    private boolean isMultiply;
    public int maxPoints;
    private int gainedPoints;
    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;
    @ManyToOne
    //@JoinColumn(name="Quiz_ID")
    private Quiz quiz;

    public Question() {
    }

    /**
     * Basic Constructor, Question must have:
     *
     * @param questionName    text for question
     * @param category        - category of topis of quiz/questions/answers from {@link settings.Category}
     * @param isMultiply      - true or false provides information wheather there is only single answer or mulitiply answers are posiible
     * @param numberOfAnswers - numbers of answers refered to this question
     * @param answersList     - List with objetcs Answer {@link settings.Answer}
     */
    public Question(String questionName, Category category, boolean isMultiply, int numberOfAnswers, List<Answer> answersList) {
        this.questionName = questionName;
        this.category = category;
        this.isMultiply = isMultiply;
        this.numberOfAnswers = numberOfAnswers;
        this.answerList = answersList;
    }

    public boolean isMultiply() {
        return isMultiply;
    }

    public void setMultiply(boolean multiply) {
        isMultiply = multiply;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
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

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
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
     * Method for counting max points one can get for a question
     * For multiply question answer ads each answer points if its param isPorper is established to true
     * For single question answer choose the answer with max points between others answers in question
     */
    public void countingMaxPoints() {
        int maxPoints = 0;
        boolean proper = true;

        if (this.isMultiply()) {

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

    /**
     * Method for counting points one got for a question
     * For single question answer if its param isPorper is established to true and answer is matched as choosen
     * For multiply question answer ads each answer points if its param isPorper is established to true and answer is matched as choosen
     */

    public void countingGainedPoints() {
        int gainedPoints = 0;
        boolean proper = true;

        if (this.isMultiply) {

            for (Answer answer : this.answerList) {
                if (answer.getIsProper() == proper && answer.getChoosen() == proper)
                    gainedPoints += answer.getAnswerPoints();
            }
            this.setGainedPoints(gainedPoints);

        } else {
            Answer answer = max(this.answerList);
            if (answer.getIsProper() == proper && answer.getChoosen() == proper)
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
