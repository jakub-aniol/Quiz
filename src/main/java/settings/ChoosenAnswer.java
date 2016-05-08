package settings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by ja on 08.05.16.
 */
@Entity
public class ChoosenAnswer extends Answer {
    @Column(name = "Czy_wybrana")
    private boolean isChoosen;
    @ManyToOne
    private ChoosenQuestion choosenQuestion;

    public ChoosenAnswer(Answer answer){
        super(answer);
    }

    public void setChoosen(boolean choosen) {
        isChoosen = choosen;
    }

    public boolean getChoosen() {
        return this.isChoosen;
    }

    public ChoosenQuestion getChoosenQuestion() {
        return choosenQuestion;
    }

    public void setChoosenQuestion(ChoosenQuestion choosenQuestion) {
        this.choosenQuestion = choosenQuestion;
    }


}
