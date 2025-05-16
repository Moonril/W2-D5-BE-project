package project;

import java.util.InputMismatchException;
import java.util.Scanner;

// menu con scanner per accedere alle funzioni
public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Archivio archivio = new Archivio();

            int scelta = -1;
            while (scelta != 0){

                try {


                    System.out.println("Menu Libreria:");
                    System.out.println("1 - Aggiungi un libro");
                    System.out.println("2 - Aggiungi una rivista");
                    System.out.println("3 - Rimuovi un elemento");
                    System.out.println("4 - Aggiorna un elemento tramite codice ISBN");
                    System.out.println("5 - Cerca per codice ISBN");
                    System.out.println("6 - Cerca per autore");
                    System.out.println("7 - Cerca per anno di pubblicazione");
                    System.out.println("8 - Visiona statistiche Libreria");
                    System.out.println("0 - Esci");

                    scelta = Integer.parseInt(scanner.nextLine());

                } catch (NumberFormatException e) {
                    System.out.println("Inserisci un numero valido.");
                }

                    switch (scelta){
                        case 1->{
                            try {


                                System.out.println("codice ISBN: ");

                                String isbn = scanner.nextLine();
                                System.out.println("Titolo: ");
                                String titolo = scanner.nextLine();

                                System.out.println("Anno di pubblicazione: ");
                                int anno = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Numero di pagine: ");
                                int pagine = scanner.nextInt();
                                scanner.nextLine();
                                // libri
                                System.out.println("Inserisci l'autore: ");
                                String autore = scanner.nextLine();

                                System.out.println("Genere: ");
                                String genere = scanner.nextLine();

                                Libri libro = new Libri(isbn, titolo, anno, pagine, autore, genere);
                                archivio.aggiungiElemento(libro);
                                System.out.println(titolo + " aggiunto!");
                            }  catch (DuplicatoException e) {
                                    System.out.println("Errore: " + e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("Errore: Inserisci un numero");
                            }
                        }
                        case 2 ->{

                            try{

                                System.out.println("codice ISBN: ");
                                String isbnr = scanner.nextLine();

                                System.out.println("Titolo: ");
                                String titolor = scanner.nextLine();

                                System.out.println("Anno di pubblicazione: ");
                                int annor = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Numero di pagine: ");
                                int paginer = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Periodicità della rivista (SETTIMANALE, MENSILE, SEMESTRALE): ");
                                String input = scanner.nextLine().toUpperCase();
                                Periodicita periodicita = Periodicita.valueOf(input);

                                Riviste rivista = new Riviste(isbnr, titolor, annor, paginer, periodicita);
                                archivio.aggiungiElemento(rivista);
                                System.out.println(titolor + " aggiunto!");
                            } catch (IllegalArgumentException e) {
                                    System.out.println("Errore: periodicità non valida o input numerico errato.");
                            } catch (DuplicatoException e) {
                                    System.out.println("Errore: " + e.getMessage());
                            }

                        }
                        case 3 -> {
                            System.out.println("Inserisci il codice ISBN dell'elemento che vuoi eliminare: ");

                            String isbn = scanner.nextLine();
                            archivio.rimuoviElemento(isbn);
                            System.out.println("Elemento rimosso");
                        }
                        case 4 -> {
                            try {
                                System.out.println("Inserisci il codice ISBN dell'elemento che vuoi aggiornare: ");
                                String isbn = scanner.nextLine();
                                System.out.println("Modifica il titolo: ");
                                String titolo =scanner.nextLine();
                                System.out.println("Modifica l'anno: ");
                                int anno = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Modifica il numero di pagine: ");
                                int pagine = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("è un libro(1) o una rivista(2)?");
                                int tipo = scanner.nextInt();
                                scanner.nextLine();

                                ElementiCatalogo nuovoElemento;
                                if(tipo == 1){
                                    System.out.println("Modifica l'autore: ");
                                    String autore = scanner.nextLine();
                                    System.out.println("Modifica il genere: ");
                                    String genere = scanner.nextLine();
                                    nuovoElemento = new Libri(isbn, titolo, anno, pagine, autore, genere);
                                    archivio.aggiornaElemento(isbn, nuovoElemento);
                                    System.out.println(titolo + " aggiunto!");
                                } else if (tipo == 2){
                                    System.out.println("Periodicità della rivista (SETTIMANALE, MENSILE, SEMESTRALE): ");
                                    String input = scanner.nextLine().toUpperCase();
                                    Periodicita periodicita = Periodicita.valueOf(input);
                                    nuovoElemento = new Riviste(isbn, titolo, anno, pagine, periodicita);
                                    archivio.aggiornaElemento(isbn, nuovoElemento);
                                    System.out.println(titolo + " aggiunto!");
                                }
                            } catch (InputMismatchException e){
                                System.out.println("inserire solo numeri, 1 per libri, 2 per riviste");
                            } catch (ElementoNonTrovatoException e) {
                                System.out.println("Elemento non trovato");
                            }
                        }
                        case 5->{
                            try {

                                System.out.println("Ricerca per codice ISBN: ");
                                String isbn = scanner.nextLine();
                                System.out.println(archivio.cercaPerIsbn(isbn));
                            } catch (ElementoNonTrovatoException e) {
                                System.out.println("Errore: " + e.getMessage());
                            }

                        }
                        case 6->{
                            try {

                                System.out.println("Ricerca per autore: ");
                                String autore = scanner.nextLine();
                                System.out.println(archivio.cercaPerAutore(autore));
                            } catch (ElementoNonTrovatoException e){
                                System.out.println("Errore: " + e.getMessage());
                            }
                        }
                        case 7->{
                            try {
                                System.out.println("Ricerca per anno: ");
                                int anno = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println(archivio.cercaPerAnno(anno));
                            } catch (ElementoNonTrovatoException e){
                                System.out.println("Errore: " + e.getMessage());
                            }
                        }
                        case 8-> archivio.stampaStatistiche();
                        case 0-> System.out.println("Alla prossima!");
                        default-> System.out.println("Scelta non valida");

                    }

        }
    }
}