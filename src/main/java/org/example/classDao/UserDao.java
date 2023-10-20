package org.example.classDao;

import org.example.entities.Pubblicazione;
import org.example.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class UserDao {
    private final EntityManager em;

    public UserDao(EntityManager em) {this.em = em;}

    public void saveNewUser(User u) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(u);
        transaction.commit();
        System.out.println("Utente aggiunto a database");
    }
    public User findUserByID(long id) {
        return em.find(User.class, id);
    }
}
