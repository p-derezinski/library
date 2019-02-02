package pl.sda.library;

import pl.sda.library.model.Book;
import pl.sda.library.model.BookBilder;
import pl.sda.library.model.Library;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        library.addBook(new BookBilder()
                .authorFirstName("Carl")
                .authorLastName("Lewis")
                .title("Lew, Czarownica i Stara Szafa")
                .build());
        library.addBook(new BookBilder()
                .authorFirstName("Adam")
                .authorLastName("Mickiewicz")
                .title("Pan Tadeusz")
                .build());
        library.addBook(new BookBilder()
                .authorFirstName("Fiodor")
                .authorLastName("Dostojewski")
                .title("Zbrodnia i kara")
                .build());
        library.addBook(new BookBilder()
                .authorFirstName("Paweł")
                .authorLastName("Dereziński")
                .title("Jak się przebranżowić z uczelni na programowanie")
                .build());
        library.addBook(new BookBilder()
                .authorFirstName("Gabriel")
                .authorLastName("Garcia Marquez")
                .title("Sto lat samotności")
                .build());
        library.addBook(new BookBilder()
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .title("Krzyżacy")
                .build());
        library.addBook(new BookBilder()
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .title("W pustyni i w puszczy")
                .build());
        library.addBook(new BookBilder()
                .authorFirstName("Bolesław")
                .authorLastName("Prus")
                .title("Lalka")
                .build());
        library.addBook(new BookBilder()
                .authorFirstName("William")
                .authorLastName("Shakespeare")
                .title("Hamlet")
                .build());
        library.addBook(new BookBilder()
                .authorFirstName("Roger")
                .authorLastName("Cadenhead")
                .title("Java in 21 days")
                .build());

        for (Book book : library.getBooks()) {
            System.out.println(book);
        }

    }

}
