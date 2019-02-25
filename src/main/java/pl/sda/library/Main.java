package pl.sda.library;

import pl.sda.library.command.*;
import pl.sda.library.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Library<Multimedium> library = createLibrary();
        Library<Multimedium> library = new Library<>();
        Scanner scanner = new Scanner(System.in);
        Map<String, Command> commands = new HashMap<>();
        commands.put("exit", () -> System.exit(0));
        commands.put("display", new DisplayMultimediaCommand(library, System.out));
        commands.put("filter", new FilterMultimediaCommand(library, System.out));
        commands.put("create", new CreateMultimediaCommand(library, System.out));
        commands.put("borrow", new BorrowMultimediaCommand(library, System.out));
        while (true) {
            System.out.println("Podaj komendę: ");
            String commandName = scanner.nextLine();
            Command command = commands.get(commandName);
            Optional.ofNullable(command).ifPresent(Command::execute);
        }

    }

    private static Library<Multimedium> createLibrary() {
        Library<Multimedium> library = new Library<>();

        library.addMedium(new PaperBookBuilder()
                .authorFirstName("C. S.")
                .authorLastName("Lewis")
                .title("Lew, Czarownica i Stara Szafa")
                .cover(Cover.HARD)
                .build());
        library.addMedium(new PaperBookBuilder()
                .authorFirstName("Adam")
                .authorLastName("Mickiewicz")
                .title("Pan Tadeusz")
                .build());
        library.addMedium(new PaperBookBuilder()
                .authorFirstName("Fiodor")
                .authorLastName("Dostojewski")
                .title("Zbrodnia i kara")
                .cover(Cover.HARD)
                .build());
        library.addMedium(new PaperBookBuilder()
                .authorFirstName("Maja")
                .authorLastName("Lunde")
                .title("Historia pszczół")
                .cover(Cover.HARD)
                .build());
        library.addMedium(new PaperBookBuilder()
                .authorFirstName("Gabriel")
                .authorLastName("Garcia Marquez")
                .title("Sto lat samotności")
                .cover(Cover.HARD)
                .build());
        library.addMedium(new PaperBookBuilder()
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .title("Krzyżacy")
                .cover(Cover.HARD)
                .build());
        library.addMedium(new PaperBookBuilder()
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .title("W pustyni i w puszczy")
                .cover(Cover.HARD)
                .build());
        library.addMedium(new PaperBookBuilder()
                .authorFirstName("Bolesław")
                .authorLastName("Prus")
                .title("Lalka")
                .cover(Cover.HARD)
                .build());
        library.addMedium(new PaperBookBuilder()
                .authorFirstName("William")
                .authorLastName("Shakespeare")
                .title("Hamlet")
                .build());
        library.addMedium(new PaperBookBuilder()
                .authorFirstName("Franz")
                .authorLastName("Kafka")
                .title("Proces")
                .cover(Cover.HARD)
                .build());

        library.addMedium(new AudioBookBuilder()
                .authorFirstName("C. S.")
                .authorLastName("Lewis")
                .title("Listy starego diabła do młodego")
                .build());
        library.addMedium(new AudioBookBuilder()
                .authorFirstName("Adam")
                .authorLastName("Mickiewicz")
                .title("Dziady")
                .build());
        library.addMedium(new AudioBookBuilder()
                .authorFirstName("Fiodor")
                .authorLastName("Dostojewski")
                .title("Zbrodnia i kara")
                .format(Format.FLAC)
                .build());

        library.addMedium(new MagazineBuilder()
                .title("Newsweek")
                .number(14)
                .pageCount(64)
                .build());

        library.addMedium(new MovieBuilder()
                .title("Beetlejuice")
                .directorFirstName("Tim")
                .directorLastName("Burton")
                .duration(120)
                .build());
        library.addMedium(new MovieBuilder()
                .title("Pianista")
                .directorFirstName("Roman")
                .directorLastName("Polański")
                .duration(152)
                .build());
        return library;
    }

}
