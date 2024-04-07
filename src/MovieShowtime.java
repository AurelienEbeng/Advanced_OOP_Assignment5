import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class MovieShowtime {

    private Movie movie;
    private LocalTime startTime;
    private LocalTime endTime;
    private CinemaHall cinemaHall;
    private LocalDate scheduledDate;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime);
        setEndTime();
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    private void setEndTime() {
        this.endTime = this.startTime.plusMinutes(movie.getDuration());
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = LocalDate.parse(scheduledDate);
    }

    public void setCinemaHall(CinemaHall c){
        this.cinemaHall = c;
    }
    public int getHallNumber(){
        return this.cinemaHall.getHallNumber();
    }

    public void reserveSeat(int row, int column){
        this.cinemaHall.reserveSeat(row,column);
    }
    public void Display(){
        System.out.println("Movie "+movie.getName()+" From "+startTime+" to "+endTime
        +" on "+scheduledDate+ " Hall: "+ cinemaHall.getHallNumber());
        System.out.println();
    }
}
