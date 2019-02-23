package pl.sda.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.sda.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CreateMultimediaCommandTest {

    public static final String AUDIO_BOOK_W_PUSTYNI_I_W_PUSZCZY_HENRYK_SIENKIEWICZ_MP_3_175 = "AudioBook\nW pustyni i w puszczy\nHenryk\nSienkiewicz\nMP3\n175\n";
    private InputStream inputStream;

    @Before
    public void setUp() {
        inputStream = System.in;
        System.setIn(new ByteArrayInputStream(AUDIO_BOOK_W_PUSTYNI_I_W_PUSZCZY_HENRYK_SIENKIEWICZ_MP_3_175.getBytes()));
    }

    @After
    public void tearDown() {
        System.setIn(inputStream);
    }

    @Test
    public void shouldCreateAudioBookWhenAudioBookTypeWasTyped() {

        // given
        Library<Multimedium> library = new Library<>();
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new CreateMultimediaCommand(library, printStreamMock);
        //System.setIn();
        // when
        command.execute();
        // then
        AudioBook audioBook = new AudioBookBuilder()
                .title("W pustyni i w puszczy")
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .format(Format.MP3)
                .duration(175)
                .build();
        Library<Multimedium> expectedLibrary = new Library<>();
        expectedLibrary.addMedium(audioBook);
        assertEquals(expectedLibrary, library);
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię autora: ");
        verify(printStreamMock, times(1)).println("Nazwisko autora: ");
        verify(printStreamMock, times(1)).println("Format: ");
        verify(printStreamMock, times(1)).println("Czas trwania: ");
    }

}