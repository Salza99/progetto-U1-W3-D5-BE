package org.example.entities;

import org.example.enumeratori.Periodicita;

import javax.persistence.Entity;

@Entity
public class Rivista extends Pubblicazione{

    private Periodicita periodicita;

    public Rivista() {
    }

    public Rivista(String titolo, Integer annoDiPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}
