public class CinemaHall {
    private int hallNumber;
    private char [][] seats = new char[10][10];

    public CinemaHall(){}
    public CinemaHall(CinemaHall c){
        //this();
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

    private char[][] getSeats(){
        return this.seats;
    }
    public void reserveSeat(int row, int column){
        this.seats[row][column]='X';
    }

    public void displaySeats(){
        for(char[] column: this.seats){
            for(char s: column){
                System.out.println(s);
            }
            System.out.println();
        }
    }

}
