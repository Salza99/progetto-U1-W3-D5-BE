package org.example;

import org.example.classDao.PubblicazioneDao;
import org.example.classDao.UserDao;
import org.example.entities.Libro;
import org.example.entities.Pubblicazione;
import org.example.entities.Rivista;
import org.example.entities.User;
import org.example.enumeratori.Generi;
import org.example.enumeratori.Periodicita;
import org.example.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory efm = JpaUtil.getEntityManagerFactory();
        EntityManager em = efm.createEntityManager();
        UserDao ud = new UserDao(em);
        //aggiungo utenti a database
        /*User ua = new User("Aldo", "Baglio", LocalDate.of(1958, 9, 28));
        User ub = new User("Giovanni", "Storti", LocalDate.of(1957,2,20));
        User uc = new User("Giacomo", "Poretti", LocalDate.of(1956, 4,26));
        ud.saveNewUser(ua);
        ud.saveNewUser(ub);
        ud.saveNewUser(uc);*/
        //aggiungo elementi al catalogo
        PubblicazioneDao pd = new PubblicazioneDao(em);
        /*Pubblicazione la = new Libro("Le grandi battaglie di Roma", 1997, 500, "Piero Angela", Generi.STORIA);
        Pubblicazione lb = new Libro("Sussidiario Italiano", 1957, 1346, "Accademia della Crusca", Generi.LETTERATURA);
        Pubblicazione lc = new Libro("Sono il Conte Draculaaaa", 2001, 245,"Aldo Baglio", Generi.HORROR);
        Pubblicazione ld = new Libro("Il trono di Spade", 1996, 840, "George Raymond Richard Martin", Generi.FANTASY);
        Pubblicazione le = new Libro("Elon Musk", 2023, 780, "Elon Musk", Generi.BIOGRAFIA);
        Pubblicazione ra = new Rivista("Focus", 1992, 76, Periodicita.SETTIMANALE);
        Pubblicazione rb = new Rivista("Donna Moderna", 1988, 47, Periodicita.MENSILE);
        Pubblicazione rc = new Rivista("Stato e Mercato", 1976, 62, Periodicita.SEMESTRALE);
        pd.saveNewPubblicazione(la);
        pd.saveNewPubblicazione(lb);
        pd.saveNewPubblicazione(lc);
        pd.saveNewPubblicazione(ld);
        pd.saveNewPubblicazione(le);
        pd.saveNewPubblicazione(ra);
        pd.saveNewPubblicazione(rb);
        pd.saveNewPubblicazione(rc);*/

        // rimuovo una pubblicazione
        //pd.removePubblicazioneById(11);

        //cerco un libro e una rivista con un anno
        List<Pubblicazione> foundRY = pd.cercaPubblicazioneByYear(1992);
        List<Pubblicazione> foundLY = pd.cercaPubblicazioneByYear(1997);
        System.out.println("----------------------Rivista tramite anno---------------------");
        foundRY.forEach(System.out::println);
        System.out.println("----------------------Libro tramite anno---------------------");
        foundLY.forEach(System.out::println);

        //Cerco un libro dall'autore
        System.out.println("----------------------Libro tramite autore---------------------");
        List<Libro> foundByAuthor = pd.cercaPubblicazioneByAutore("aldo baglio");
        foundByAuthor.forEach(System.out::println);
    }
}

