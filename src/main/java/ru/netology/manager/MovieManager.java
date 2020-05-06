package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = {
            new Movie(1, "Форсаж 1", "Боевик"),
            new Movie(2, "Форсаж 2", "Боевик"),
            new Movie(3, "Форсаж 3", "Боевик"),
            new Movie(4, "Форсаж 4", "Боевик"),
            new Movie(5, "Форсаж 5", "Боевик"),
            new Movie(6, "Форсаж 6", "Боевик"),
            new Movie(7, "Форсаж 7", "Боевик")
    };

    public void add(Movie item) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

    public Movie[] flipList() {
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] showMovie(int howManyFilmToShow) {
        Movie[] result = flipList();
        int movieLenght = movies.length;
        int maxLenght = 10;
        if (howManyFilmToShow > maxLenght || howManyFilmToShow <= 0) {
            howManyFilmToShow = maxLenght;
        }
        if (movieLenght < maxLenght) {
            maxLenght = movieLenght;
        }
        if (howManyFilmToShow <= maxLenght) {
            movieLenght = howManyFilmToShow;
        }
        Movie[] tmp = new Movie[movieLenght];
        System.arraycopy(result, 0, tmp, 0, tmp.length);
        return tmp;
    }
}
