package org.example.entities;

import org.example.enumeratori.Periodicita;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rivista")
public class Rivista extends Pubblicazione{

    private Periodicita periodicita;

    public Rivista() {
    }

    public Rivista(String titolo, Integer annoDiPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" + super.toString() +
                "periodicita=" + periodicita +
                '}';
    }
}
