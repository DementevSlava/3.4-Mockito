package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTestWithMockito {
    @Mock
    private AfishaRepository afishaRepository;
    @InjectMocks
    private AfishaManager afishaManager;
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
        afishaManager.add(movie1);
        afishaManager.add(movie2);
        afishaManager.add(movie3);
        afishaManager.add(movie4);
        afishaManager.add(movie5);
        afishaManager.add(movie6);
        afishaManager.add(movie7);
    }

    @Test
    public void flipList() {
        Movie[] returned = new Movie[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        doReturn(returned).when(afishaRepository).findAll();

        Movie[] actual = afishaManager.flipList();
        Movie[] expected = {movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        int idToRemove = 2;
        Movie[] returned = new Movie[]{movie1, movie3, movie4, movie5, movie6, movie7};
        doReturn(returned).when(afishaRepository).findAll();

        afishaManager.removeById(idToRemove);
        Movie[] actual = afishaManager.flipList();
        Movie[] expected = new Movie[]{movie7, movie6, movie5, movie4, movie3, movie1};


        assertArrayEquals(expected, actual);

        verify(afishaRepository).removeById(idToRemove);
    }

}