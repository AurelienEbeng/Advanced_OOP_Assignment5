public class Main {
    public static void main(String[] args) {
        Movie SpiderMan= new Movie();
        SpiderMan.setName("SpiderMan");
        SpiderMan.setDescription("SpiderMan");
        SpiderMan.setDuration(120);

        Movie Avengers = new Movie();
        Avengers.setName("Avengers");
        Avengers.setDuration(150);

        AvailableMovies.add(Avengers);
        AvailableMovies.add(SpiderMan);

        AvailableMovies.Display();

        MovieShowtime m1 = new MovieShowtime();
        m1.setMovie(SpiderMan);
        m1.setScheduledDate("2024-03-31");
        m1.setStartTime("19:30");
        m1.setHallNumber(1);
        AvailableShowtimes.addShowtime(m1);

        MovieShowtime m2 = new MovieShowtime();
        m2.setMovie(Avengers);
        m2.setScheduledDate("2024-03-31");
        m2.setStartTime("19:30");
        m2.setHallNumber(2);
        AvailableShowtimes.addShowtime(m2);

        AvailableShowtimes.Display();

    }
}