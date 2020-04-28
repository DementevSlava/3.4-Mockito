package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieManagerTestWithMockito {
    @Mock
    private MovieRepository movieRepository = new MovieRepository();
    @InjectMocks
    private MovieManager movieManager = new MovieManager(movieRepository);
    private Movie movie1 = new Movie(1, "Форсаж 1", "Боевик");
    private Movie movie2 = new Movie(2, "Форсаж 2", "Боевик");
    private Movie movie3 = new Movie(3, "Форсаж 3", "Боевик");
    private Movie movie4 = new Movie(4, "Форсаж 4", "Боевик");
    private Movie movie5 = new Movie(5, "Форсаж 5", "Боевик");
    private Movie movie6 = new Movie(6, "Форсаж 6", "Боевик");
    private Movie movie7 = new Movie(7, "Форсаж 7", "Боевик");
    private Movie movieToAdd = new Movie(20, "Форсаж 20", "Боевик");

    @BeforeEach
    public void setUp() {
        movieManager.add(movie1);
        movieManager.add(movie2);
        movieManager.add(movie3);
        movieManager.add(movie4);
        movieManager.add(movie5);
        movieManager.add(movie6);
        movieManager.add(movie7);
    }

    @Test
    public void flipList() {
        Movie[] returned = new Movie[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        doReturn(returned).when(movieRepository).findAll();

        Movie[] actual = movieManager.flipList();
        Movie[] expected = {movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        int idToRemove = 1;
        Movie[] returned = new Movie[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        doReturn(returned).when(movieRepository).findAll();

        movieManager.removeById(idToRemove);
        Movie[] actual = movieManager.flipList();
        Movie[] expected = new Movie[]{movie7, movie6, movie5, movie4, movie3, movie2, movie1};


        assertArrayEquals(expected, actual);
    }
}