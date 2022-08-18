public class Movie {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie(int id) {
        this.id = id;
    }

    private int id;
    private String name;
    private int noOfAvailableTickets;
    private int ticketPrice;

    public Movie(int id, String name, int noOfAvailableTickets, int ticketPrice) {
        this.id = id;
        this.name = name;
        this.noOfAvailableTickets = noOfAvailableTickets;
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfAvailableTickets() {
        return noOfAvailableTickets;
    }

    public void setNoOfAvailableTickets(int noOfAvailableTickets) {
        this.noOfAvailableTickets = noOfAvailableTickets;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Movie() {

    }
}
