package pl.sda.library.command;

import pl.sda.library.model.Library;
import pl.sda.library.model.Multimedium;

import java.io.PrintStream;

public class DisplayMultimediaCommand implements Command {

    private final Library<Multimedium> library;
    private final PrintStream printStream;

    public DisplayMultimediaCommand(Library<Multimedium> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        library.getMedia().forEach(printStream::println);
    }
}
