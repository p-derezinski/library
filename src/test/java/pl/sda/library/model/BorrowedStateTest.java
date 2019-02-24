package pl.sda.library.model;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BorrowedStateTest {

    @Test
    public void shouldNotBorrowBookWhenIsBorrowed() {
        // given
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowedState state = new BorrowedState(printStreamMock);
        String firstName1 = "Dante";
        String lastName1 = "Iksiński";
        state.setFirstName(firstName1);
        state.setLastName(lastName1);
        String firstName2 = "Urszula";
        String lastName2 = "Kolewa-Zalewa";
        // when
        MultimediumState multimediumState = state.borrowMedium(firstName2, lastName2);
        // then
        assertTrue(multimediumState instanceof BorrowedState);
        assertEquals(firstName1, ((BorrowedState) multimediumState).getFirstName());
        assertEquals(lastName1, ((BorrowedState) multimediumState).getLastName());
        verify(printStreamMock, only())
                .println("Książka już jest wypożyczona");
    }

    @Test
    public void shouldReturnBookWhenIsBorrowed() {
        // given
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowedState state = new BorrowedState(printStreamMock);
        // when
        MultimediumState multimediumState = state.returnMedium();
        // then
        assertTrue(multimediumState instanceof ReturnedState);
        verify(printStreamMock, never()).println(anyString());
    }

}