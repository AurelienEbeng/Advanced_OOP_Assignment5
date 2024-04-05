public class CinemaHall {
    private int hallNumber;
    private char [][] seats = new char[10][10];

    public CinemaHall(){}
    public CinemaHall(CinemaHall c){
        this.hallNumber = c.getHallNumber();
        this.seats= c.getSeats();
    }
    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public CinemaHall clone(){
        return new CinemaHall(this);
    }

    public char[][] getSeats() {
        return seats;
    }


}
