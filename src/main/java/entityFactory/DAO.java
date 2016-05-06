package entityFactory;

import settings.Answer;
import settings.Question;
import settings.Quiz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by jakub on 27.04.16.
 */
public class DAO {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void openFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void closeFactory() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void addingDbAnswer(Answer answer) {
        entityManager.getTransaction().begin();
        entityManager.persist(answer);
        entityManager.getTransaction().commit();

    }

    public static void addingDbQuestion(Question question) {
        entityManager.getTransaction().begin();
        entityManager.persist(question);
        entityManager.getTransaction().commit();

        //entityManager.refresh(question);

    }

    public static void addingDbQuiz(Quiz quiz) {
        entityManager.getTransaction().begin();
        entityManager.persist(quiz);
        entityManager.getTransaction().commit();
        //  entityManager.refresh(quiz);

    }

    public static Question getQuestion(int i) {
        Question question;
        entityManager.getTransaction().begin();
        question = entityManager.find(Question.class, i);
        entityManager.getTransaction().commit();

        return question;
    }

    public static Question getSingleQuestion() {
        TypedQuery<Question> query = entityManager.createQuery("select e from Pytania e where e.maxPoints = 10", Question.class);
        Question question = query.getSingleResult();
        return question;
    }

    public static List<Question> getQuestionsList() {
        TypedQuery<Question> typedQuery = entityManager.createQuery("select e from Pytania e", Question.class);
        List<Question> questionList = typedQuery.getResultList();
        return questionList;
    }


    public static List<Quiz> getQuiz() {
        TypedQuery<Quiz> typedQuery = entityManager.createQuery("select e from Quiz e", Quiz.class);
        List<Quiz> quizList = typedQuery.getResultList();
        return quizList;
    }


}
