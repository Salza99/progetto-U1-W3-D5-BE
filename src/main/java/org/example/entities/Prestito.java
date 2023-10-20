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

    public List<Pubblicazione> getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(List<Pubblicazione> elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevistaPrestito() {
        return dataRestituzionePrevistaPrestito;
    }



    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevistaPrestito=" + dataRestituzionePrevistaPrestito +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
