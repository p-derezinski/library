package pl.sda.library;

import pl.sda.library.model.*;

public class Main {

    public static void main(String[] args) {

        Library<Book> library = new Library<>();
        //Library<AudioBook> library_2 = new Library<>();

        library.addBook(new PaperBookBuilder()
                .authorFirstName("C. S.")
                .authorLastName("Lewis")
                .title("Lew, Czarownica i Stara Szafa")
                .cover(Cover.HARD)
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Adam")
                .authorLastName("Mickiewicz")
                .title("Pan Tadeusz")
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Fiodor")
                .authorLastName("Dostojewski")
                .title("Zbrodnia i kara")
                .cover(Cover.HARD)
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Maja")
                .authorLastName("Lunde")
                .title("Historia pszczół")
                .cover(Cover.HARD)
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Gabriel")
                .authorLastName("Garcia Marquez")
                .title("Sto lat samotności")
                .cover(Cover.HARD)
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .title("Krzyżacy")
                .cover(Cover.HARD)
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .title("W pustyni i w puszczy")
                .cover(Cover.HARD)
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Bolesław")
                .authorLastName("Prus")
                .title("Lalka")
                .cover(Cover.HARD)
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("William")
                .authorLastName("Shakespeare")
                .title("Hamlet")
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Franz")
                .authorLastName("Kafka")
                .title("Proces")
                .cover(Cover.HARD)
                .build());

        library.addBook(new AudioBookBuilder()
                .authorFirstName("C. S.")
                .authorLastName("Lewis")
                .title("Listy starego diabła do młodego")
                .build());
        library.addBook(new AudioBookBuilder()
                .authorFirstName("Adam")
                .authorLastName("Mickiewicz")
                .title("Dziady")
                .build());
        library.addBook(new AudioBookBuilder()
                .authorFirstName("Fiodor")
                .authorLastName("Dostojewski")
                .title("Zbrodnia i kara")
                .format(Format.FLAC)
                .build());

        for (Book book : library.getBooks()) {
            System.out.println(book);
        }


    }

}
