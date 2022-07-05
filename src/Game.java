import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    static int life = 0;
    static int k = 0;


    public static int countMovies(String moviePath) throws Exception {
        File file = new File(moviePath);
        Scanner scanner = new Scanner(file);

        int movieCount = 0;

        while(scanner.hasNextLine()) {
            scanner.nextLine();
            movieCount++;
        }

        return movieCount;
    }

    public static String[] movieList(int movieCount, String moviePath) throws Exception{
        String[] movies = new String[movieCount];
        int j = 0;

        File file = new File(moviePath);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            movies[j] = line;
            j++;}

        return movies;
    }

    public static String randomMovie(String[] movies) {
        int randomNumber = (int) (Math.random() * movies.length);
        String randomMovie = movies[randomNumber];
        return randomMovie;
    }

    public static String movieUnderscored(String randomMovie) {
        String underscore = randomMovie.replaceAll("[a-zA-Z]", "_");
        return underscore;
    }

    public static String usersGuess(String randomMovie, String movieUnderscored) {

        System.out.println("You are guessing: " + movieUnderscored);
        System.out.println("You have guessed (" + life + ") wrong letters:  ");
        System.out.print("Guess a letter: ");
        char[] movieUnderscoredCharArray = movieUnderscored.toCharArray();
        char[] wrongLetters = new char[10];

        while (life != 10) {
            //accepts input
            Scanner scanner = new Scanner(System.in);
            String guessedString = scanner.nextLine();
            String lowerGuessedString = guessedString.toLowerCase();
            char guessedChar = lowerGuessedString.charAt(0);


            //compares the index of users input with index in randomMovie
            int positionGuess = randomMovie.indexOf(guessedChar);
            int newPositionGuess = randomMovie.lastIndexOf(guessedChar);
            int newPositionGuess2 = randomMovie.indexOf(guessedChar, (positionGuess + 1));
            int newPositionGuess3 = randomMovie.indexOf(guessedChar, (newPositionGuess2 + 1));
            int newPositionGuess4 = randomMovie.indexOf(guessedChar, (newPositionGuess3 + 1));

            int lettersCount = randomMovie.length();


            if (positionGuess == -1 && guessedChar >= 'a' && guessedChar <= 'z') {
                life++;
                char wrongGuess = guessedChar;
                wrongLetters[k] = wrongGuess;
                k++;
            } else if(positionGuess == -1 && !(guessedChar >= 'a' && guessedChar <= 'z')){
                System.out.println("Oops, that's a wrong input...guess again");
            }


            System.out.println("\nYou have guessed (" + life + ") wrong letter(s):  " + String.valueOf(wrongLetters));


            for (int i = 0; i <= lettersCount; i++) {
                if (i == positionGuess || i == newPositionGuess || i == newPositionGuess2 || i == newPositionGuess3 || i == newPositionGuess4) {
                    movieUnderscoredCharArray[i] = guessedChar;
                }
            }
            String guessedMovie = String.valueOf(movieUnderscoredCharArray);
            System.out.println("You are guessing: " + guessedMovie);
            System.out.print("Guess a letter: ");


            if (guessedMovie.equals(randomMovie)) {
                System.out.println("\n          ");
                break;
            }//go back to this code
        }
        String guessedMovie = String.valueOf(movieUnderscoredCharArray);
        return guessedMovie;
    }

    public static String winOrLoose(int life, String randomMovie, String guessedMovie) {

        String hasWon = "";
            if ((life != 10) && (guessedMovie.equals(randomMovie))) {
                hasWon = "You win!\n" + "You have guessed '" + randomMovie + "' correctly.";
            } else {
                hasWon = "\nGame over!" + "\nYou did not guess '" + randomMovie + "' correctly.";
            }
        return hasWon;
    }

    public static int getLife() {
        return life;
    }
}