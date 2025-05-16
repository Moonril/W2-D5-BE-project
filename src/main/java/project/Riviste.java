package project;

import java.time.LocalDate;
import java.time.Year;

public class Riviste extends ElementiCatalogo {
    //variabili
    private Periodicita periodicita;

    //costruttore

    public Riviste(Long ISBN, String titolo, Year anno, int numeroPagine, Periodicita periodicita) {
        super(ISBN, titolo, anno, numeroPagine);
        this.periodicita = periodicita;
    }


    //tostring

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                '}';
    }


    // get set

    public Periodicita getPeriodicita() {
        return periodicita;
    }
}
