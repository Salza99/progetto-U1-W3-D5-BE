package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User utente;
    @ManyToMany
    @JoinTable(name = "prestito_pubblicazione",
    joinColumns = @JoinColumn(name = "prestito_id"),
    inverseJoinColumns = @JoinColumn(name = "pubblicazione_isbn"))
    private List<Pubblicazione> elementoPrestato;
    @Column(name = "data_inizio")
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevistaPrestito;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {
    }

    public Prestito(User utente, List<Pubblicazione> elementoPrestato, LocalDate dataInizioPrestito) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevistaPrestito = dataInizioPrestito.plusDays(30);

    }
}
