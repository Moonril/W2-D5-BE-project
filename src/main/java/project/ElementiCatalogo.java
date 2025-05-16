package project;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

public abstract class ElementiCatalogo {
    private Long ISBN;
    private String titolo;
    private int anno;
    private int numeroPagine;

    public ElementiCatalogo(Long ISBN, String titolo, int anno, int numeroPagine) {
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

    public int getAnno() {
        return anno;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    //equals


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ElementiCatalogo that = (ElementiCatalogo) o;
        return Objects.equals(ISBN, that.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ISBN);
    }
}
