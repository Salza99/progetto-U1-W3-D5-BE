package org.example.classDao;

import org.example.entities.Prestito;
import org.example.entities.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitoDao {
    private final EntityManager em;

    public PrestitoDao(EntityManager em) {this.em = em;}

    public void saveNewPrestito(Prestito p) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("Prestito aggiunto a database");
    }
}
