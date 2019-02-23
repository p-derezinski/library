package pl.sda.library.command;

import pl.sda.library.model.*;

import java.io.PrintStream;
import java.util.Scanner;

public class CreateMultimediaCommand implements Command {

    public static final String AUDIO_BOOK = "AudioBook";
    private final Library<Multimedium> library;
    private final PrintStream printStream;

    public CreateMultimediaCommand(Library<Multimedium> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Typ: ");
        String type = scanner.nextLine();
        if (type.equals(AUDIO_BOOK)) {             // albo: "type.equals(AudioBook.class.getSimpleName())"
            printStream.println("Tytuł: ");
            String title = scanner.nextLine();
            printStream.println("Imię autora: ");
            String authorFirstName = scanner.nextLine();
            printStream.println("Nazwisko autora: ");
            String authorLastName = scanner.nextLine();
            printStream.println("Format: ");
            String format = scanner.nextLine();
            printStream.println("Czas trwania: ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            AudioBook audioBook = new AudioBookBuilder()
                    .title(title)
                    .authorFirstName(authorFirstName)
                    .authorLastName(authorLastName)
                    .format(Format.valueOf(format))
                    .duration(duration)
                    .build();
            library.addMedium(audioBook);
        }
    }
}
