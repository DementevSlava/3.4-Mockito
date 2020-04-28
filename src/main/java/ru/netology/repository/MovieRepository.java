package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {

    private Movie[] movies = {
            new Movie(1, "Форсаж 1", "Боевик"),
            new Movie(2, "Форсаж 2", "Боевик"),
            new Movie(3, "Форсаж 3", "Боевик"),
            new Movie(4, "Форсаж 4", "Боевик"),
            new Movie(5, "Форсаж 5", "Боевик"),
            new Movie(6, "Форсаж 6", "Боевик"),
            new Movie(7, "Форсаж 7", "Боевик")
    };

    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public Movie findById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeAll() {
        movies = new Movie[0];
    }
}
