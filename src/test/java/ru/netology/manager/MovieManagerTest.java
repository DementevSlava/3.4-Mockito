package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager movieManager = new MovieManager();
    private Movie movieToAdd = new Movie(20, "Форсаж 20", "Боевик");
    private Movie movie8 = new Movie(8, "Форсаж 8", "Боевик");
    private Movie movie9 = new Movie(9, "Форсаж 9", "Боевик");
    private Movie movie10 = new Movie(10, "Форсаж 10", "Боевик");
    private Movie movie11 = new Movie(11, "Форсаж 11", "Боевик");
    private Movie movie12 = new Movie(12, "Форсаж 12", "Боевик");
    private Movie movie13 = new Movie(13, "Форсаж 13", "Боевик");

    @Test
    public void showSmall() {
        movieManager.add(movieToAdd);
        Movie[] actual = movieManager.showMovie(10);
        Movie[] expected = {
                new Movie(20, "Форсаж 20", "Боевик"),
                new Movie(7, "Форсаж 7", "Боевик"),
                new Movie(6, "Форсаж 6", "Боевик"),
                new Movie(5, "Форсаж 5", "Боевик"),
                new Movie(4, "Форсаж 4", "Боевик"),
                new Movie(3, "Форсаж 3", "Боевик"),
                new Movie(2, "Форсаж 2", "Боевик"),
                new Movie(1, "Форсаж 1", "Боевик")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showDefault() {
        movieManager.add(movie8);
        movieManager.add(movie9);
        movieManager.add(movie10);
        movieManager.add(movie11);
        movieManager.add(movie12);
        movieManager.add(movie13);
        movieManager.add(movieToAdd);
        Movie[] actual = movieManager.showMovie(10);
        Movie[] expected = {
                new Movie(20, "Форсаж 20", "Боевик"),
                new Movie(13, "Форсаж 13", "Боевик"),
                new Movie(12, "Форсаж 12", "Боевик"),
                new Movie(11, "Форсаж 11", "Боевик"),
                new Movie(10, "Форсаж 10", "Боевик"),
                new Movie(9, "Форсаж 9", "Боевик"),
                new Movie(8, "Форсаж 8", "Боевик"),
                new Movie(7, "Форсаж 7", "Боевик"),
                new Movie(6, "Форсаж 6", "Боевик"),
                new Movie(5, "Форсаж 5", "Боевик"),


        };


        assertArrayEquals(expected, actual);
    }

    @Test
    public void showSetMovie() {
        movieManager.add(movieToAdd);
        Movie[] actual = movieManager.showMovie(5);
        Movie[] expected = {
                new Movie(20, "Форсаж 20", "Боевик"),
                new Movie(7, "Форсаж 7", "Боевик"),
                new Movie(6, "Форсаж 6", "Боевик"),
                new Movie(5, "Форсаж 5", "Боевик"),
                new Movie(4, "Форсаж 4", "Боевик")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setOverDefaultMovie() {
        movieManager.add(movie8);
        movieManager.add(movie9);
        movieManager.add(movie10);
        movieManager.add(movie11);
        movieManager.add(movie12);
        movieManager.add(movie13);
        movieManager.add(movieToAdd);
        Movie[] actual = movieManager.showMovie(12);
        Movie[] expected = {
                new Movie(20, "Форсаж 20", "Боевик"),
                new Movie(13, "Форсаж 13", "Боевик"),
                new Movie(12, "Форсаж 12", "Боевик"),
                new Movie(11, "Форсаж 11", "Боевик"),
                new Movie(10, "Форсаж 10", "Боевик"),
                new Movie(9, "Форсаж 9", "Боевик"),
                new Movie(8, "Форсаж 8", "Боевик"),
                new Movie(7, "Форсаж 7", "Боевик"),
                new Movie(6, "Форсаж 6", "Боевик"),
                new Movie(5, "Форсаж 5", "Боевик")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setNegative() {
        movieManager.add(movie8);
        movieManager.add(movie9);
        movieManager.add(movie10);
        movieManager.add(movie11);
        movieManager.add(movie12);
        movieManager.add(movie13);
        movieManager.add(movieToAdd);
        Movie[] actual = movieManager.showMovie(-5);
        Movie[] expected = {
                new Movie(20, "Форсаж 20", "Боевик"),
                new Movie(13, "Форсаж 13", "Боевик"),
                new Movie(12, "Форсаж 12", "Боевик"),
                new Movie(11, "Форсаж 11", "Боевик"),
                new Movie(10, "Форсаж 10", "Боевик"),
                new Movie(9, "Форсаж 9", "Боевик"),
                new Movie(8, "Форсаж 8", "Боевик"),
                new Movie(7, "Форсаж 7", "Боевик"),
                new Movie(6, "Форсаж 6", "Боевик"),
                new Movie(5, "Форсаж 5", "Боевик"),
        };
        assertArrayEquals(expected, actual);
    }
}
