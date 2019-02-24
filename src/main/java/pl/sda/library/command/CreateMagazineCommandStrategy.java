package pl.sda.library.command;

import pl.sda.library.model.MagazineBuilder;
import pl.sda.library.model.Multimedium;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

class CreateMagazineCommandStrategy implements CreateMultimediaStrategy {

    private static final String MAGAZINE = "Magazine";

    @Override
    public Multimedium createMedium(Scanner scanner, PrintStream printStream) {
        printStream.println("Tytuł: ");
        String title = scanner.nextLine();
        printStream.println("Numer: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        printStream.println("Liczba stron: ");
        int pageCount = scanner.nextInt();
        scanner.nextLine();
        return new MagazineBuilder()
                .title(title)
                .number(number)
                .pageCount(pageCount)
                .build();
    }

    @Override
    public boolean isTypeCorrect(String type) {
        return Objects.equals(type, MAGAZINE);
    }
}
