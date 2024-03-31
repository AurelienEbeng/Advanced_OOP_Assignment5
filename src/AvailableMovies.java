import java.util.LinkedList;

public class AvailableMovies {
    private AvailableMovies(){}
    private static LinkedList<Movie> availableMovies = new LinkedList<Movie>();

    public static void Display(){
        System.out.println("Available Movies:");
        for(Movie m: availableMovies){
            System.out.println("\t- "+m.getName());
        }
    }

    public static void add(Movie m){
        availableMovies.add(m);
    }
    public static void remove(Movie m){
        availableMovies.remove(m);
    }
}

