package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "numero_di_tessera")
    private long numeroDiTessera;
    private String nome;
    private String cognome;
    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestito;
    public User() {
    }

    public User(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }
}
