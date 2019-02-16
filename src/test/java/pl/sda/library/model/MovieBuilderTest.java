package pl.sda.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieBuilderTest {

    @Test
    public void shouldBuildMovieWhenAllDataIsDefined() {

        // given
        String title = "Gone With The Wind";
        String directorFirstName = "Victor";
        String directorLastName = "Fleming";
        int duration = 1000;
        // when
        Movie movie = new MovieBuilder()
                .title(title)
                .directorFirstName(directorFirstName)
                .directorLastName(directorLastName)
                .duration(duration)
                .build();
        // then
        assertNotNull(movie);
        assertEquals(title, movie.getTitle());
        assertNotNull(movie.getDirector());
        assertEquals(directorFirstName, movie.getDirector().getFirstName());
        assertEquals(directorLastName, movie.getDirector().getLastName());
        assertEquals(duration, movie.getDuration());

    }

}