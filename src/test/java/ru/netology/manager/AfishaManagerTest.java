package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTest {
    private AfishaRepository afishaRepository = new AfishaRepository();
    private AfishaManager afishaManager = new AfishaManager(afishaRepository);
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
    public void ShowSmall() {
        afishaRepository.save(movieToAdd);
        Movie[] actual = afishaManager.showMovie();
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
        afishaManager.add(movie8);
        afishaManager.add(movie9);
        afishaManager.add(movie10);
        afishaManager.add(movie11);
        afishaManager.add(movie12);
        afishaManager.add(movie13);
        afishaManager.add(movieToAdd);
        Movie[] actual = afishaManager.showMovie();
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
        afishaManager.add(movieToAdd);
        Movie[] actual = afishaManager.showMovie(5);
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
        afishaManager.add(movie8);
        afishaManager.add(movie9);
        afishaManager.add(movie10);
        afishaManager.add(movie11);
        afishaManager.add(movie12);
        afishaManager.add(movie13);
        afishaManager.add(movieToAdd);
        Movie[] actual = afishaManager.showMovie(12);
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
        afishaManager.removeById(3);
        Movie[] actual = afishaManager.showMovie();
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
