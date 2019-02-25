package pl.sda.library.command;

import pl.sda.library.model.Library;
import pl.sda.library.model.Multimedium;
import pl.sda.library.model.MultimediumState;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class BorrowMultimediaCommand implements Command {

    private final Library<Multimedium> library;
    private final PrintStream printStream;

    public BorrowMultimediaCommand(Library<Multimedium> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Tytuł: ");
        String title = scanner.nextLine();
        printStream.println("Imię osoby wypożyczającej: ");
        String firstName = scanner.nextLine();
        printStream.println("Nazwisko osoby wypożyczającej: ");
        String lastName = scanner.nextLine();
        Optional<Multimedium> medium = library.getMedia().stream()
                .filter(m -> Objects.equals(m.getTitle(), title))
                .findFirst();
        Optional<MultimediumState> state = medium.map(m -> m.getState().borrowMedium(firstName, lastName));
        medium.ifPresent(m -> m.setState(state.get()));
        if (!medium.isPresent()) {
            printStream.println("Książka nie istnieje");
        }
    }
}
