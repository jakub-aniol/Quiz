package settings;

import javax.persistence.*;

/**
 * Object for storying information about single Answer
 * Created by Jakub
 * Since 2016-04-30.
 *
 */
@Entity
@Table(name = "Odpowiedzi")
public class Answer implements Comparable<Answer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = "Odpowiedź")
    private String answerName;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "Ilosc_punktow")
    private int answerPoints;
    @Column(name = "Czy_prawdziwa")
    private boolean isProper;
    @ManyToOne//(targetEntity = Question.class)
    //@JoinColumn(name="ToQuestion")
    private Question question;

    public Answer(){}

    public Answer(Answer answer){
        this.answerName=answer.answerName;
        this.category=answer.category;
        this.answerPoints=answer.answerPoints;
        this.isProper=answer.isProper;
        this.question=answer.question;
    }

    /**
     * Basic Constructor, Answer must have:
     * @param answerName text for answer
     * @param category - category of topis of quiz/questions/answers from {@link settings.Category}
     * @param answerPoints - howm many points one can get for good answering
     * @param isProper - if an answer is proper regarding to the question
     *
     */
    private Answer(String answerName, Category category, int answerPoints, boolean isProper) {
        this.answerName = answerName;
        this.category = category;
        this.answerPoints = answerPoints;
        this.isProper = isProper;
    }

    public static Answer createAnswer(String answerName, Category category, int answerPoints, boolean isProper) {
        return new Answer(answerName, category, answerPoints, isProper);
    }

    public int getAnswerPoints() {
        return this.answerPoints;
    }

    public boolean getIsProper() {
        return isProper;
    }

    private int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAnswerPoints(int answerPoints) {
        this.answerPoints = answerPoints;
    }

    public void setProper(boolean proper) {
        isProper = proper;
    }



    @Override
    public int compareTo(Answer o) {
        return this.answerPoints - o.answerPoints;
    }

    @Override
    public String toString() {
        String strReturn ="";
        strReturn += this.answerName;
       // strReturn += "  " +this.answerPoints+ "   "+this.isChoosen;
        strReturn +="\n";

        return strReturn;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this.getClass()!=obj.getClass()) return false;
        if(this == obj)
            return true;
        Answer answer = (Answer)obj;
        return this.category.equals(answer.category)
                && this.answerName.equals(answer.answerName);
    }
    @Override
    public int hashCode(){
        return this.category.hashCode()*this.answerName.hashCode()*this.getID();
    }



}
