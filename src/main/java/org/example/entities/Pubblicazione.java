package org.example.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pubblicazione {
    @Id
    @GeneratedValue
    private long isbn;
    private String titolo;
    @Column(name = "anno_di_pubblicazione")
    private Integer annoDiPubblicazione;
    @Column(name = "numero_pagine")
    private Integer numeroPagine;

    public Pubblicazione() {
    }

    public Pubblicazione(String titolo, Integer annoDiPubblicazione, Integer numeroPagine) {
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }
}
