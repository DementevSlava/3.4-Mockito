package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

@NoArgsConstructor
@AllArgsConstructor
public class MovieManager {
    private MovieRepository movieRepository = new MovieRepository();
    private int itemsToReturn = 10;

    public MovieManager(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void add(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie[] flipList() {
        Movie[] movies = movieRepository.findAll();
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] showMovie(int howManyFilmToShow) {
        Movie[] movies = movieRepository.findAll();
        Movie[] result = flipList();
        int movieLenght = movies.length;
        int maxLenght = 10;
        if (movieLenght < maxLenght) {
            maxLenght = movieLenght;
        }
        if (howManyFilmToShow > maxLenght) {
            movieLenght = maxLenght;
        }
        if (howManyFilmToShow <= maxLenght) {
            movieLenght = howManyFilmToShow;
        }
            Movie[] tmp = new Movie[movieLenght];
            System.arraycopy(result, 0, tmp, 0, tmp.length);
            return tmp;

    }

    public Movie[] showMovie() {
        Movie[] movies = movieRepository.findAll();
        Movie[] result = flipList();
        int movieLenght = movies.length;
        int maxLenght = 10;
        if (movieLenght < maxLenght) {
            maxLenght = movieLenght;
        }
        Movie[] tmp = new Movie[maxLenght];
        System.arraycopy(result, 0, tmp, 0, tmp.length);
        return tmp;
    }

    public void removeById (int id){
        movieRepository.removeById(id);
    }
}