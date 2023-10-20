package org.example.classDao;

import javax.persistence.EntityManager;

public class PubblicazioneDao {
    private final EntityManager em;

    public PubblicazioneDao(EntityManager em) {this.em = em;}

}
