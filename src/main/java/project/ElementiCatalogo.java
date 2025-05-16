package project;

import java.time.LocalDate;
import java.time.Year;

public abstract class ElementiCatalogo {
    private Long ISBN;
    private String titolo;
    private Year anno;
    private int numeroPagine;

    public ElementiCatalogo(Long ISBN, String titolo, Year anno, int numeroPagine) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.anno = anno;
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "ElementiCatalogo{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", anno=" + anno +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public Long getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public Year getAnno() {
        return anno;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }
}
