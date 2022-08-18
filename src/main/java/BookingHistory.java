import java.util.Date;

public class BookingHistory {

    private int id;
    private String movieName;
    private int noOfTickets;
    private int totalAmount;
    private Date date;

    public BookingHistory() {
    }

    public BookingHistory(int id, String movieName, int noOfTickets, int totalAmount, Date date) {
        this.id = id;
        this.movieName = movieName;
        this.noOfTickets = noOfTickets;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
