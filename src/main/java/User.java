import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<BookingHistory> bookingHistorys;

    public User() {
    }

    public ArrayList<BookingHistory> getBookingHistorys() {
        return bookingHistorys;
    }

    public void setBookingHistorys(ArrayList<BookingHistory> bookingHistorys) {
        this.bookingHistorys = bookingHistorys;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
