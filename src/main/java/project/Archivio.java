package project;


import java.util.*;
import java.util.stream.Collectors;


// aggiunta elemento
// ricerca per ISBN
// rimozione per ISBN
// ricerca per anno
// ricerca per autore
// aggiornamento per ISBN
// statistiche
public class Archivio {

    //contenitore
    private Set<ElementiCatalogo> catalogo = new HashSet<>();


    //metodi

    public void aggiungiElemento(ElementiCatalogo elemento) throws DuplicatoException {
        if (catalogo.contains(elemento)) {
            throw new DuplicatoException("Elemento già presente.");
        }
        catalogo.add(elemento);
    }

    public void rimuoviElemento(String isbn){
        catalogo.removeIf(elemento -> elemento.getISBN().equals(isbn));
    }

    public ElementiCatalogo cercaPerIsbn (String isbn) throws ElementoNonTrovatoException{
        return catalogo.stream()
                .filter(elemento -> elemento.getISBN().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new ElementoNonTrovatoException("Elemento non trovato con codice: " + isbn));
    }

    public List<ElementiCatalogo> cercaPerAnno(int anno) throws ElementoNonTrovatoException {
        List<ElementiCatalogo> risultati = catalogo.stream()
                .filter(elemento -> elemento.getAnno() == anno)
                .collect(Collectors.toList());

        if (risultati.isEmpty()) {
            throw new ElementoNonTrovatoException("Nessun elemento trovato per l'anno " + anno);
        }

        return risultati;
    }

    public List<Libri> cercaPerAutore(String autore) throws ElementoNonTrovatoException{
        List<Libri> risultati = catalogo.stream()
                .filter(e -> e instanceof Libri)
                .map(e -> (Libri) e)
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());

        if (risultati.isEmpty()) {
            throw new ElementoNonTrovatoException("Nessun libro trovato per l'autore: " + autore);
        }

        return risultati;
    }

    public void aggiornaElemento(String isbn, ElementiCatalogo nuovoElemento) throws ElementoNonTrovatoException {
        ElementiCatalogo daAggiornare = cercaPerIsbn(isbn);
        catalogo.remove(daAggiornare);
        catalogo.add(nuovoElemento);
    }

    public void stampaStatistiche(){
        Long numeroLibri = catalogo.stream().filter(e->e instanceof Libri).count();
        Long numeroRiviste = catalogo.stream().filter(e->e instanceof Riviste).count();

        Optional<ElementiCatalogo> maxPagine = catalogo.stream()
                .max(Comparator.comparingInt(ElementiCatalogo::getNumeroPagine));

        double mediaPagine = catalogo.stream()
                .mapToInt(ElementiCatalogo::getNumeroPagine)
                .average()
                .orElse(0);

        System.out.println("Totale libri: " + numeroLibri);
        System.out.println("Totale riviste: " + numeroRiviste);
        System.out.println("Elemento con più pagine: " + maxPagine.map(ElementiCatalogo::getTitolo).orElse("Nessuno"));
        System.out.println("Media pagine: " + mediaPagine);
    }

}
