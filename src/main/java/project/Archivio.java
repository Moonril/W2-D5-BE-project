package project;


import java.util.*;
import java.util.stream.Collectors;


// 1-2aggiunta elemento
// 5ricerca per ISBN
// 3rimozione per ISBN
// 7ricerca per anno
// 6ricerca per autore
// 4aggiornamento per ISBN
// 8statistiche
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
                .orElseThrow(() -> new ElementoNonTrovatoException("Elemento non trovato"));
    }

    public List<ElementiCatalogo> cercaPerAnno(int anno) {
        return catalogo.stream()
                .filter(elemento -> elemento.getAnno() == anno)
                .collect(Collectors.toList());
    }

    public List<Libri> cercaPerAutore(String autore){
        return catalogo.stream()
                .filter(e->e instanceof Libri)
                .map(e->(Libri) e)
                .filter(libro->libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
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
