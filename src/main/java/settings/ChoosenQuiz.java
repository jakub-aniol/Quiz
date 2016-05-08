package settings;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ja on 08.05.16.
 */
@Entity
public class ChoosenQuiz extends Quiz{
    String userName;
    String UserLastName;
    @OneToMany(mappedBy = "choosenQuiz", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ChoosenQuestion> choosenQusetionsList;

    public ChoosenQuiz() {
    }

    public ChoosenQuiz(Quiz quiz) {
        super(quiz);
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {

        UserLastName = userLastName;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ChoosenQuestion> getChoosenQusetionsList() {
        return choosenQusetionsList;
    }

    public void setChoosenQusetionsList(List<ChoosenQuestion> choosenQusetionsList) {
        this.choosenQusetionsList = choosenQusetionsList;
    }


    /**
     * Method for counting points one got for a quiz
     * if Answer param isPorper is established to true and answer is matched as choosen it added points one geins while doing quiz.
     *
     * @param choosenQuiz {@link settings.ChoosenQuiz}
     * @return int
     */
    public int countingGainedPointsInQuiz(ChoosenQuiz choosenQuiz) {
        boolean choosen = true;
        int getherPoints = 0;

        for (ChoosenQuestion ques : choosenQuiz.getChoosenQusetionsList())
            for (ChoosenAnswer ans : ques.getChoosenAnswerList()){
                if (ans.getChoosen() == choosen) {
                    if (ans.getIsProper() == ans.getIsProper()) {
                        getherPoints += ans.getAnswerPoints();
                    }
                }
            }
        return getherPoints;
    }


}
