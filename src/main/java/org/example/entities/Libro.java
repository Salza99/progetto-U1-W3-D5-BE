package org.example.entities;

import org.example.enumeratori.Generi;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro extends Pubblicazione {

    private String autore;
    private Generi genere;

    public Libro() {
    }

    public Libro(String titolo, Integer annoDiPubblicazione, Integer numeroPagine, String autore, Generi genere) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}
