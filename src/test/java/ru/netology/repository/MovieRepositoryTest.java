package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private MovieRepository movieRepository = new MovieRepository();
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
    void save() {
        movieRepository.save(movieToAdd);
        Movie[] actual = movieRepository.findAll();
        Movie[] expected = {
                new Movie(1, "Форсаж 1", "Боевик"),
                new Movie(2, "Форсаж 2", "Боевик"),
                new Movie(3, "Форсаж 3", "Боевик"),
                new Movie(4, "Форсаж 4", "Боевик"),
                new Movie(5, "Форсаж 5", "Боевик"),
                new Movie(6, "Форсаж 6", "Боевик"),
                new Movie(7, "Форсаж 7", "Боевик"),
                new Movie(20, "Форсаж 20", "Боевик")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        Movie[] actual = movieRepository.findAll();
        Movie[] expected = {
                new Movie(1, "Форсаж 1", "Боевик"),
                new Movie(2, "Форсаж 2", "Боевик"),
                new Movie(3, "Форсаж 3", "Боевик"),
                new Movie(4, "Форсаж 4", "Боевик"),
                new Movie(5, "Форсаж 5", "Боевик"),
                new Movie(6, "Форсаж 6", "Боевик"),
                new Movie(7, "Форсаж 7", "Боевик")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        movieRepository.removeById(3);
        Movie[] actual = movieRepository.findAll();
        Movie[] expected = {
                new Movie(1, "Форсаж 1", "Боевик"),
                new Movie(2, "Форсаж 2", "Боевик"),
                new Movie(4, "Форсаж 4", "Боевик"),
                new Movie(5, "Форсаж 5", "Боевик"),
                new Movie(6, "Форсаж 6", "Боевик"),
                new Movie(7, "Форсаж 7", "Боевик")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        movieRepository.save(movieToAdd);
        Movie actual = movieRepository.findById(6);
        Movie expected = new Movie(6, "Форсаж 6", "Боевик");
        assertEquals(expected, actual);
    }

    @Test
    void findByNonId() {
        movieRepository.save(movieToAdd);
        Movie actual = movieRepository.findById(100);
        assertEquals(null, actual);
    }

    @Test
    void removeAll() {
        movieRepository.removeAll();
        Movie[] actual = movieRepository.findAll();
        Movie[] expected = {};
        assertArrayEquals(expected, actual);
    }
}