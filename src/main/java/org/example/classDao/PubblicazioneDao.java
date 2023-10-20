package org.example.classDao;

import org.example.entities.Libro;
import org.example.entities.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public void removePubblicazioneById(long id) {
        Pubblicazione found = em.find(Pubblicazione.class, id);
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Pubblicazione eliminita");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public Pubblicazione cercaPubblicazioneByIsbn(long isbn){

          return em.find(Pubblicazione.class,isbn);

    }
    public List<Pubblicazione> cercaPubblicazioneByYear(int anno){
        TypedQuery<Pubblicazione> searchByYear = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.annoDiPubblicazione = :anno", Pubblicazione.class);
        searchByYear.setParameter("anno", anno);
        return searchByYear.getResultList();
    }
    public List<Libro> cercaLibroByAutore(String autore){
        TypedQuery<Libro> searchByAutore = em.createQuery("SELECT l FROM Libro l WHERE LOWER(l.autore) = LOWER(:autore)", Libro.class);
        searchByAutore.setParameter("autore", autore);
        return searchByAutore.getResultList();
    }
    public List<Pubblicazione> cercaPubblicazioneByPartialTitle(String search){
        TypedQuery<Pubblicazione> searchByPartialTitle = em.createQuery("SELECT p FROM Pubblicazione p WHERE LOWER(p.titolo) LIKE LOWER(:search)", Pubblicazione.class);
        searchByPartialTitle.setParameter("search","%" + search + "%");
        return searchByPartialTitle.getResultList();
    }
}
