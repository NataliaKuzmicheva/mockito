import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoviePosterTest {
    @Test

    public void findAll() {
        MoviePoster moviePoster = new MoviePoster();
        String movie1 = "Bloodshot";
        String movie2 = "Onward";
        String movie3 = "Belgrade Hotel";

        moviePoster.add(movie1);
        moviePoster.add(movie2);
        moviePoster.add(movie3);
        String[] actual = moviePoster.findAll();
        String[] expected = {movie1, movie2, movie3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void findLastUnderLimit() { //вывод списка фильмов меньше лимита
        MoviePoster moviePoster = new MoviePoster();
        String movie1 = "Bloodshot";
        String movie2 = "Onward";
        String movie3 = "Belgrade Hotel";

        moviePoster.add(movie1);
        moviePoster.add(movie2);
        moviePoster.add(movie3);
        String[] actual = moviePoster.findLast();
        String[] expected = {movie3, movie2, movie1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void findLastOverLimitMoreDefault() { //вывод списка фильмов с кол-вом фильмов больше по умолчанию
        MoviePoster moviePoster = new MoviePoster();
        String movie1 = "Bloodshot";
        String movie2 = "Onward";
        String movie3 = "Belgrade Hotel";
        String movie4 = "The Gentlemen";
        String movie5 = "The Invisible Man";
        String movie6 = "Trolls World Tour,";
        String movie7 = "The Number One";

        moviePoster.add(movie1);
        moviePoster.add(movie2);
        moviePoster.add(movie3);
        moviePoster.add(movie4);
        moviePoster.add(movie5);
        moviePoster.add(movie6);
        moviePoster.add(movie7);
        String[] actual = moviePoster.findLast();
        String[] expected = {movie7, movie6, movie5, movie4, movie3};

        Assertions.assertArrayEquals(expected, actual);

    }

    public void findLastOverLimitWithNewLimit() { //вывод списка фильмов с увеличением лимита отображаемых фильмов
        MoviePoster moviePoster = new MoviePoster(7);
        String movie1 = "Bloodshot";
        String movie2 = "Onward";
        String movie3 = "Belgrade Hotel";
        String movie4 = "The Gentlemen";
        String movie5 = "The Invisible Man";
        String movie6 = "Trolls World Tour,";
        String movie7 = "The Number One";

        moviePoster.add(movie1);
        moviePoster.add(movie2);
        moviePoster.add(movie3);
        moviePoster.add(movie4);
        moviePoster.add(movie5);
        moviePoster.add(movie6);
        moviePoster.add(movie7);
        String[] actual = moviePoster.findLast();
        String[] expected = {movie7, movie6, movie5, movie4, movie3, movie2, movie1};

        Assertions.assertArrayEquals(expected, actual);
    }
}