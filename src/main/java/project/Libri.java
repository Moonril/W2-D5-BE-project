package project;

import java.time.LocalDate;
import java.time.Year;

public class Libri extends ElementiCatalogo{
    // variabili
    private String autore;
    private String genere;

    //costruttore
    public Libri(String ISBN, String titolo, int anno, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, anno, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    //tostring

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }


    //get set

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }



}
