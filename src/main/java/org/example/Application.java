package org.example;

import org.example.classDao.PrestitoDao;
import org.example.classDao.PubblicazioneDao;
import org.example.classDao.UserDao;
import org.example.entities.*;
import org.example.enumeratori.Generi;
import org.example.enumeratori.Periodicita;
import org.example.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.ArrayList;
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
        List<Libro> foundByAuthor = pd.cercaLibroByAutore("aldo baglio");
        foundByAuthor.forEach(System.out::println);
        //Cerco una pubblicazione con il titolo e parziale
        System.out.println("----------------------Pubblicazione tramite titolo---------------------");
        List<Pubblicazione> foundByTitle = pd.cercaPubblicazioneByPartialTitle("le grandi battaglie di roma");
        foundByTitle.forEach(System.out::println);
        System.out.println("----------------------Pubblicazione tramite titolo parziale---------------------");
        List<Pubblicazione> foundByPartialTitle = pd.cercaPubblicazioneByPartialTitle("sono il conte");
        foundByPartialTitle.forEach(System.out::println);
        // inserisco dei prestiti per gli utenti
        User aldo = ud.findUserByID(1);
        User giovanni = ud.findUserByID(2);
        User giacomo = ud.findUserByID(3);
        // creo liste di pubblicazioni
        /*Pubblicazione foundLA = pd.cercaPubblicazioneByIsbn(4);
        Pubblicazione foundLB = pd.cercaPubblicazioneByIsbn(5);
        Pubblicazione foundLC = pd.cercaPubblicazioneByIsbn(6);
        Pubblicazione foundLD = pd.cercaPubblicazioneByIsbn(7);
        Pubblicazione foundRA = pd.cercaPubblicazioneByIsbn(9);
        Pubblicazione foundRB = pd.cercaPubblicazioneByIsbn(10);
        List<Pubblicazione> lpa = new ArrayList<>();
        lpa.add(foundLA);
        lpa.add(foundLB);
        lpa.add(foundLC);
        lpa.add(foundRA);
        List<Pubblicazione> lpb = new ArrayList<>();
        lpb.add(foundLB);
        lpb.add(foundRA);
        lpb.add(foundRB);
        List<Pubblicazione> lpc = new ArrayList<>();
        lpc.add(foundLD);
        List<Pubblicazione> lpd = new ArrayList<>();
        lpd.add(foundLC);
        lpd.add(foundRB);*/
        // creo i prestiti
        PrestitoDao prd = new PrestitoDao(em);
        /*Prestito pA = new Prestito(aldo, lpa, LocalDate.of(2023, 9, 19));
        Prestito pB = new Prestito(giovanni, lpb, LocalDate.of(2023, 7, 17));
        Prestito pC = new Prestito(giacomo, lpc, LocalDate.of(2023, 7, 2));
        Prestito pD = new Prestito(giacomo, lpd, LocalDate.of(2023, 10, 2));
        prd.saveNewPrestito(pA);
        prd.saveNewPrestito(pB);
        prd.saveNewPrestito(pC);
        prd.saveNewPrestito(pD);*/

        List<Pubblicazione> foundByTessera = prd.findPubblicazioniByUser(3);
        System.out.println("----------------------Pubblicazioni tramite Numero Tessera Utente---------------------");
        foundByTessera.forEach(System.out::println);

        // set di avvenuta restituzione di un prestito
        Prestito foundPresA = prd.cercaPrestitoById(3);
        //prd.setDataRestituzione(foundPresA, LocalDate.of(2023, 8, 21));



        em.close();
        efm.close();

    }
}

