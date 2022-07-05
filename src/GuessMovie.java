import java.io.File;
import java.util.Scanner;

public class GuessMovie {

    public static void main (String[] args) throws Exception {
        int life = Game.getLife();
        //System.out.println(life);

        int moviesCount = Game.countMovies("src\\movies.txt");
        //System.out.println(moviesCount);

        String[] movieList = Game.movieList(moviesCount, "src\\movies.txt");
       // System.out.println(movieList[3]);

        String randomMovie = Game.randomMovie(movieList);
        //System.out.println(randomMovie);


        String movieUnderscored = Game.movieUnderscored(randomMovie);
        System.out.println(movieUnderscored);


        String usersGuess = Game.usersGuess(randomMovie, movieUnderscored);
        System.out.println(usersGuess);

        String hasWon = Game.winOrLoose(life, randomMovie, usersGuess);
        System.out.println(hasWon);}
    }






