package pl.sda.library.command;

import pl.sda.library.model.Multimedium;

import java.io.PrintStream;
import java.util.Scanner;

public interface CreateMultimediaStrategy {

    Multimedium createMedium(Scanner scanner, PrintStream printStream);

    boolean isTypeCorrect(String type);

}
