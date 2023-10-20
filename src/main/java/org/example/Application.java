package org.example;

import org.example.classDao.UserDao;
import org.example.entities.User;
import org.example.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
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


    }
}

