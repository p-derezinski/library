package pl.sda.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.sda.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BorrowMultimediaCommandTest {

    private InputStream inputStream;

    @Before
    public void setUp() {
        inputStream = System.in;
    }

    @After
    public void tearDown() {
        System.setIn(inputStream);
    }

    @Test
    public void shouldBorrowMovieWhenMovieIsReturned() {
        // given
        Library<Multimedium> libraryMock = mock(Library.class);
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowMultimediaCommand command = new BorrowMultimediaCommand(libraryMock, printStreamMock);
        Movie movie = new MovieBuilder().title("Testowy tytuł").build();
        movie.setState(new ReturnedState());
        when(libraryMock.getMedia()).thenReturn(Arrays.asList(movie));
        System.setIn(new ByteArrayInputStream("Testowy tytuł\nJohnny\nEnglish\n".getBytes()));
        //Mockito.doNothing().when(printStreamMock).println();
        // when
        command.execute();
        // then
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Nazwisko osoby wypożyczającej: ");
        MultimediumState state = movie.getState();
        assertTrue(state instanceof BorrowedState);
        assertEquals("Johnny", ((BorrowedState) state).getFirstName());
        assertEquals("English", ((BorrowedState) state).getLastName());
    }

    @Test
    public void shouldNotBorrowMovieWhenMovieIsBorrowed() {
        // given
        Library<Multimedium> libraryMock = mock(Library.class);
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowMultimediaCommand command = new BorrowMultimediaCommand(libraryMock, printStreamMock);
        Movie movie = new MovieBuilder().title("Testowy tytuł").build();
        movie.setState(new BorrowedState(printStreamMock));
        when(libraryMock.getMedia()).thenReturn(Arrays.asList(movie));
        System.setIn(new ByteArrayInputStream("Testowy tytuł\nJohnny\nEnglish\n".getBytes()));
        //Mockito.doNothing().when(printStreamMock).println();
        // when
        command.execute();
        // then
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Nazwisko osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Książka już jest wypożyczona");
        MultimediumState state = movie.getState();
        assertTrue(state instanceof BorrowedState);
        assertNull(((BorrowedState) state).getFirstName());
        assertNull(((BorrowedState) state).getLastName());
    }

    @Test
    public void shouldNotBorrowMovieWhenMovieIsNotExisting() {
        // given
        Library<Multimedium> libraryMock = mock(Library.class);
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowMultimediaCommand command = new BorrowMultimediaCommand(libraryMock, printStreamMock);
        when(libraryMock.getMedia()).thenReturn(Collections.emptyList());
        System.setIn(new ByteArrayInputStream("Testowy tytuł\nJohnny\nEnglish\n".getBytes()));
        // when
        command.execute();
        // then
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Nazwisko osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Książka nie istnieje");
    }

}