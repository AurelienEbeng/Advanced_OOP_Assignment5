import java.sql.SQLOutput;

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

        CinemaHall c1 = new CinemaHall();
        c1.setHallNumber(1);

        CinemaHall c2 = new CinemaHall();
        c2.setHallNumber(2);

        MovieShowtime m1 = new MovieShowtime();
        m1.setMovie(SpiderMan);
        m1.setScheduledDate("2024-03-31");
        m1.setStartTime("19:30");
        m1.setHallNumber(c1.getHallNumber());
        AvailableShowtimes.addShowtime(m1);

        MovieShowtime m2 = new MovieShowtime();
        m2.setMovie(Avengers);
        m2.setScheduledDate("2024-03-31");
        m2.setStartTime("19:30");
        m2.setHallNumber(c2.getHallNumber());
        AvailableShowtimes.addShowtime(m2);

        AvailableShowtimes.Display();

        CinemaHall cine1 = new CinemaHall();
        cine1.setHallNumber(1);
        CinemaHall cine2 = new CinemaHall();
        cine2.setHallNumber(2);
        CinemaHall cine3 = new CinemaHall();
        cine3.setHallNumber(3);

        HashMapCinemaHall.halls.put(cine1.getHallNumber(),cine1);
        HashMapCinemaHall.halls.put(cine2.getHallNumber(),cine2);
        HashMapCinemaHall.halls.put(cine3.getHallNumber(),cine3);

        for(CinemaHall cine: HashMapCinemaHall.halls.values()){
            System.out.println(cine.getHallNumber());
        }

        CinemaHall cine1Clone = cine1.clone();
        System.out.println(cine1Clone.getHallNumber());
    }
























}