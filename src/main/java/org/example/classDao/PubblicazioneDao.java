package org.example.classDao;

import org.example.entities.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PubblicazioneDao {
    private final EntityManager em;

    public PubblicazioneDao(EntityManager em) {this.em = em;}

    public void saveNewPubblicazione(Pubblicazione p) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("Pubblicazione aggiunto a database");
    }
}
