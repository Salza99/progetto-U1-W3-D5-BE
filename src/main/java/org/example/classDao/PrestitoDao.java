package org.example.classDao;

import org.example.entities.Prestito;
import org.example.entities.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.List;

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
    public Prestito cercaPrestitoById(long id){

        return em.find(Prestito.class,id);

    }
    public List<Pubblicazione> findPubblicazioniByUser(long nTesseraUtente){
        TypedQuery<Pubblicazione> findPubblicazioneByUserQuery = em.createQuery("SELECT pub FROM Prestito p JOIN p.elementoPrestato pub JOIN p.utente u WHERE u.numeroDiTessera = :numeroTessera", Pubblicazione.class);
        findPubblicazioneByUserQuery.setParameter("numeroTessera",nTesseraUtente);
        return findPubblicazioneByUserQuery.getResultList();

    }
    public void setDataRestituzione(Prestito p, LocalDate d){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        p.setDataRestituzioneEffettiva(d);
        transaction.commit();
    }
}
