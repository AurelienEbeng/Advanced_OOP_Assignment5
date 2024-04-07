import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Ticket {
    private String clientName;
    private  String contact;
    private MovieShowtime showtime;
    private int totalPrice;
    private LinkedList<Seat> seats = new LinkedList<>();

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }



    public void setShowtime(MovieShowtime showtime) {
        this.showtime = showtime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }


    public void reserveSeat(int row, int column){
        Seat s = new Seat();
        s.setColumnNumber(column);
        s.setRowNumber(row);
        seats.add(s);
        this.showtime.reserveSeat(row,column);
    }

    public void calculateTotalPrice(){
        this.totalPrice+=this.showtime.getMovie().getPrice();
    }
    public void Display(){
        System.out.println("Client Name: "+ this.clientName);
        System.out.println("Contact: "+this.contact);
        this.showtime.Display();
        System.out.println("Total price: "+this.totalPrice);
    }
}
