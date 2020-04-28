package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieRepository movieRepository = new MovieRepository();
    private MovieManager movieManager = new MovieManager(movieRepository);
    private Movie movieToAdd = new Movie(20, "Форсаж 20", "Боевик");
    private Movie movie1 = new Movie(1, "Форсаж 1", "Боевик");
    private Movie movie2 = new Movie(2, "Форсаж 2", "Боевик");
    private Movie movie3 = new Movie(3, "Форсаж 3", "Боевик");
    private Movie movie4 = new Movie(4, "Форсаж 4", "Боевик");
    private Movie movie5 = new Movie(5, "Форсаж 5", "Боевик");
    private Movie movie6 = new Movie(6, "Форсаж 6", "Боевик");
    private Movie movie7 = new Movie(7, "Форсаж 7", "Боевик");
    private Movie movie8 = new Movie(8, "Форсаж 8", "Боевик");
    private Movie movie9 = new Movie(9, "Форсаж 9", "Боевик");
    private Movie movie10 = new Movie(10, "Форсаж 10", "Боевик");
    private Movie movie11 = new Movie(11, "Форсаж 11", "Боевик");
    private Movie movie12 = new Movie(12, "Форсаж 12", "Боевик");
    private Movie movie13 = new Movie(13, "Форсаж 13", "Боевик");


    @BeforeEach
    public void setUp(){
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
        movieRepository.save(movie5);
        movieRepository.save(movie6);
        movieRepository.save(movie7);
    }

    @Test
    public void ShowSmall() {
        movieRepository.save(movieToAdd);
        Movie[] actual = movieManager.showMovie();
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
        Movie[] actual = movieManager.showMovie();
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
    public void removeById (){
        movieManager.removeById(3);
        Movie[] actual = movieManager.showMovie();
        Movie[] expected = {
                new Movie(7, "Форсаж 7", "Боевик"),
                new Movie(6, "Форсаж 6", "Боевик"),
                new Movie(5, "Форсаж 5", "Боевик"),
                new Movie(4, "Форсаж 4", "Боевик"),
                new Movie(2, "Форсаж 2", "Боевик"),
                new Movie(1, "Форсаж 1", "Боевик")
        };
        assertArrayEquals(expected, actual);
    }
}
