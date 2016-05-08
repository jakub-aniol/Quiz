package settings;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;

/**
 * Object for storying information about single Question
 * Created by Jakub
 * Since 2016-04-30.
 */
@Entity(name = "Pytania")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Question {
    @Id
    @GeneratedValue
    private int Id;
    private String questionName;
    private Category category;
    private int numberOfAnswers;
    private boolean isMultiply;
    public int maxPoints;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Answer> answerList;
    @ManyToOne
    //@JoinColumn(name="Quiz_ID")
    private Quiz quiz;

    public Question() {
    }

    public Question(Question question){
        this.Id=question.Id;
        this.questionName = question.questionName;
        this.category = question.category;
        this.numberOfAnswers=question.numberOfAnswers;
        this.isMultiply=question.isMultiply;
        this.maxPoints=question.maxPoints;
        this.answerList=new ArrayList<>(answerList);
      //  this.quiz=question.quiz;
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

    public boolean getIsMultiply() {
        return isMultiply;
    }

    public void setIsMultiply(boolean multiply) {
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

        if (this.getIsMultiply()) {

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



   public String showQuestion(){
        String str = "";
        str+=this.questionName;
       /* str+='\n';
        str+=this.answerList;*/
        return str;
    }

    @Override
    public String toString() {
        String strReturn = "\n";
        strReturn += this.questionName;
        strReturn += "\n";
        strReturn += this.answerList;
        return strReturn;
    }


}
