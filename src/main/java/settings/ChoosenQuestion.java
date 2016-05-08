package settings;

import javax.persistence.*;

import java.util.List;

import static java.util.Collections.max;

/**
 * Created by ja on 08.05.16.
 */
@Entity
public class ChoosenQuestion extends Question{
    private int gainedPoints;
    @OneToMany(mappedBy = "choosenQuestion", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ChoosenAnswer> choosenAnswerList;
    @ManyToOne
    private ChoosenQuiz choosenQuiz;



    ChoosenQuestion(){}

    public ChoosenQuestion(Question question){
        super(question);
    }

    public int getGainedPoints() {
        return gainedPoints;
    }

    public void setGainedPoints(int gainedPoints) {
        this.gainedPoints = gainedPoints;
    }

    public ChoosenQuiz getChoosenQuiz() {
        return choosenQuiz;
    }

    public void setChoosenQuiz(ChoosenQuiz choosenQuiz) {
        this.choosenQuiz = choosenQuiz;
    }

    public List<ChoosenAnswer> getChoosenAnswerList() {
        return this.choosenAnswerList;
    }

    public void setChoosenAnswerList(List<ChoosenAnswer> choosenAnswerList) {
        this.choosenAnswerList = choosenAnswerList;
    }

    /**
     * Method for counting points one got for a question
     * For single question answer if its param isPorper is established to true and answer is matched as choosen
     * For multiply question answer ads each answer points if its param isPorper is established to true and answer is matched as choosen
     */
    public void countingGainedPointsInQuestion() {
        int gainedPoints = 0;
        boolean proper = true;

        if (this.getIsMultiply()) {

            for (ChoosenAnswer answer : this.getChoosenAnswerList()) {
                if (answer.getIsProper() == proper && answer.getChoosen() == proper)
                    gainedPoints += answer.getAnswerPoints();
            }
            this.setGainedPoints(gainedPoints);

        } else {
            ChoosenAnswer answer = max(this.getChoosenAnswerList());
            if (answer.getIsProper() == proper && answer.getChoosen() == proper)
                gainedPoints = answer.getAnswerPoints();
            this.setGainedPoints(gainedPoints);
        }
    }


}
