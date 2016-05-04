package entityFactory;

import settings.Answer;
import settings.Question;
import settings.Quiz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by jakub on 27.04.16.
 */
public class DAO {
    static EntityManagerFactory entityManagerFactory;
    public static EntityManager entityManager;

    public static void openFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void closeFactory(){
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

}
