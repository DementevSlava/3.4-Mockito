package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository afishaRepository = new AfishaRepository();
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
        afishaRepository.save(movie1);
        afishaRepository.save(movie2);
        afishaRepository.save(movie3);
        afishaRepository.save(movie4);
        afishaRepository.save(movie5);
        afishaRepository.save(movie6);
        afishaRepository.save(movie7);
    }

    @Test
    void save() {
        afishaRepository.save(movieToAdd);
        Movie[] actual = afishaRepository.findAll();
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
        Movie[] actual = afishaRepository.findAll();
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
        afishaRepository.removeById(3);
        Movie[] actual = afishaRepository.findAll();
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
    void removeByNonId() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> afishaRepository.removeById(30));
    }

    @Test
    void findById() {
        afishaRepository.save(movieToAdd);
        Movie actual = afishaRepository.findById(6);
        Movie expected = new Movie(6, "Форсаж 6", "Боевик");
        assertEquals(expected, actual);
    }

    @Test
    void findByNonId() {
        afishaRepository.save(movieToAdd);
        Movie actual = afishaRepository.findById(100);
        assertNull(actual);
    }

    @Test
    void removeAll() {
        afishaRepository.removeAll();
        Movie[] actual = afishaRepository.findAll();
        Movie[] expected = {};
        assertArrayEquals(expected, actual);
    }
}