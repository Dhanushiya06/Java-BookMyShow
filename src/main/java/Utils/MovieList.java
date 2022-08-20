package Utils;

import Model.Movie;

import java.util.ArrayList;

public class MovieList {
    private ArrayList<Movie> movie = new ArrayList<>();

    public ArrayList<Movie> getMovie() {
        return movie;
    }

    public void loadMovies() {
        movie.add(new Movie(1, "VIRUMAN", 20, 200));
        movie.add(new Movie(2, "SITA RAMAM", 30, 190));
        movie.add(new Movie(3, "SUZHAL", 45, 120));
        movie.add(new Movie(4, "ROCKETRY", 10, 140));
        movie.add(new Movie(5, "GULU GULU", 35, 100));
    }
}
