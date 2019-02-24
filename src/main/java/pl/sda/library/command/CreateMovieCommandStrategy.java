package pl.sda.library.command;

import pl.sda.library.model.MovieBuilder;
import pl.sda.library.model.Multimedium;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class CreateMovieCommandStrategy implements CreateMultimediaStrategy {

    public static final String MOVIE = "Movie";

    @Override
    public Multimedium createMedium(Scanner scanner, PrintStream printStream) {
        printStream.println("Tytuł: ");
        String title = scanner.nextLine();
        printStream.println("Imię reżysera: ");
        String directorFirstName = scanner.nextLine();
        printStream.println("Nazwisko reżysera: ");
        String directorLastName = scanner.nextLine();
        printStream.println("Czas trwania: ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        return new MovieBuilder()
                .title(title)
                .directorFirstName(directorFirstName)
                .directorLastName(directorLastName)
                .duration(duration)
                .build();
    }

    @Override
    public boolean isTypeCorrect(String type) {
        return Objects.equals(type, MOVIE);
    }
}
