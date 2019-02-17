package pl.sda.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.sda.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.CharBuffer;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FilterMultimediaCommandTest {

    private InputStream inputStream;

    @Before
    public void setUp() {
        inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Movie\n".getBytes()));
    }

    @After
    public void tearDown() {
        System.setIn(inputStream);
    }

    @Test
    public void shouldDisplayMoviesWhenFilterByMovie() {

        // given
        PaperBook book = new PaperBookBuilder()
                .authorFirstName("aaa")
                .authorLastName("sss")
                .title("qqq")
                .cover(Cover.HARD)
                .pageCount(100)
                .build();
        Movie movie_1 = new MovieBuilder()
                .title("bbb")
                .directorFirstName("rrr")
                .directorLastName("ppp")
                .duration(200)
                .build();
        Movie movie_2 = new MovieBuilder()
                .title("Argo")
                .directorFirstName("Ben")
                .directorLastName("Affleck")
                .duration(155)
                .build();
        Library<Multimedium> library = new Library<>();
        library.addMedium(book);
        library.addMedium(movie_1);
        library.addMedium(movie_2);
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new FilterMultimediaCommand(library, printStreamMock);
        //System.setIn();
        // when
        command.execute();
        // then
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println(movie_1);
        verify(printStreamMock, times(1)).println(movie_2);
        verify(printStreamMock, never()).println(book);
    }

}