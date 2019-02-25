package pl.sda.library.model;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReturnedStateTest {

    @Test
    public void shouldBorrowBookWhenIsReturned() {
        // given
        PrintStream printStreamMock = mock(PrintStream.class);
        MultimediumState state = new ReturnedState(printStreamMock);
        String firstName = "Olgierd";
        String lastName = "Małolepszy";
        // when
        MultimediumState multimediumState = state.borrowMedium(firstName, lastName);
        // then
        assertTrue(multimediumState instanceof BorrowedState);
        assertEquals(firstName, ((BorrowedState) multimediumState).getFirstName());
        assertEquals(lastName, ((BorrowedState) multimediumState).getLastName());
        verify(printStreamMock, never()).println(anyString());
    }

    @Test
    public void shouldNtReturnBookWhenIsReturned() {
        // given
        PrintStream printStreamMock = mock(PrintStream.class);
        MultimediumState state = new ReturnedState(printStreamMock);
        // when
        MultimediumState multimediumState = state.returnMedium();
        // then
        assertTrue(multimediumState instanceof ReturnedState);
        verify(printStreamMock, only())
                .println("Nie można zwrócić książki ponownie");
    }

}