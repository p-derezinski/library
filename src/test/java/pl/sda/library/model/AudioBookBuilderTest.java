package pl.sda.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AudioBookBuilderTest {

    @Test
    public void shouldBuildAudioBookWhenAudioBookDetailsAreDefined() {
        // given
        String authorFirstName = "William";
        String authorLastName = "Shakespeare";
        String title = "Romeo and Juliet";
        Format format = Format.MP3;
        int duration = 1000;
        // when
        AudioBook book = new AudioBookBuilder()
                .authorFirstName(authorFirstName)
                .authorLastName(authorLastName)
                .title(title)
                .format(format)
                .duration(duration)
                .build();
        // then
        assertNotNull(book);
        assertNotNull(book.getAuthor());
        assertEquals(authorFirstName, book.getAuthor().getFirstName());
        assertEquals(authorLastName, book.getAuthor().getLastName());
        assertEquals(title, book.getTitle());
        assertEquals(format, book.getFormat());
        assertEquals(duration, book.getDuration());
    }

}