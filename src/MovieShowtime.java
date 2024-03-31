import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class MovieShowtime {

    private Movie movie;
    private LocalTime startTime;
    private LocalTime endTime;
    private int hallNumber;
    private LocalDate scheduledDate;

    public String getMovie() {
        return movie.getName();
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

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = LocalDate.parse(scheduledDate);
    }

    public void Display(){
        System.out.println("Movie "+movie.getName()+" From "+startTime+" to "+endTime
        +" on "+scheduledDate+ " Hall: "+ hallNumber);
        System.out.println();
    }
}
