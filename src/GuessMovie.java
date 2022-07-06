import java.io.File;
import java.util.Scanner;

public class GuessMovie {

    public static void main (String[] args) throws Exception {
        Game game = new Game();

        int life = game.getLife();
        //System.out.println(life);

        int moviesCount = game.countMovies("src\\movies.txt");
        //System.out.println(moviesCount);

        String[] movieList = game.movieList(moviesCount, "src\\movies.txt");
       // System.out.println(movieList[3]);

        String randomMovie = game.randomMovie(movieList);
        //System.out.println(randomMovie);


        String movieUnderscored = game.movieUnderscored(randomMovie);
        //System.out.println(movieUnderscored);


        String usersGuess = game.usersGuess(randomMovie, movieUnderscored);
        System.out.println(usersGuess);

        String hasWon = game.winOrLoose(life, randomMovie, usersGuess);
        System.out.println(hasWon);}
    }






