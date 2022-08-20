package Service;

import Model.BookingHistory;
import Model.Movie;
import Model.User;
import Utils.MovieList;
import Utils.ReadInput;

import java.util.ArrayList;
import java.util.Date;

import static Utils.Utils.print;

public class MainMenu implements MainMenuInterface {

    private MovieList movieList;
    private User loggedInUser;
    private Auth auth;

    public MainMenu(MovieList movieList, User loggedInUser, Auth auth) {
        this.movieList = movieList;
        this.loggedInUser = loggedInUser;
        this.auth = auth;
    }

    public void mainMenu() {
        print("1.Movies");
        print("2.Booking History");
        print("3.Logout");
        print("Enter your choice: ");
        int choice = ReadInput.getScanner().nextInt();
        switch (choice) {
            case 1 -> printMovie();
            case 2 -> printHistory();
            case 3 -> auth.authMenu();
            default -> print("Invalid choice");
        }

    }

    @Override
    public void printMovie() {
        movieList.getMovie().forEach(movie ->
                print(movie.getId() + "-" + movie.getMovieName() + " - Tickets:" + movie.getAvailableTickets() + " - Rs." + movie.getPrice()));
        print("99.Back");
        print("Enter your choice: ");
        int choice = ReadInput.getScanner().nextInt();
        if (choice == 99) {
            mainMenu();
        }
        boolean isMovieExist = movieList.getMovie().stream().anyMatch(movie -> movie.getId() == choice);
        if (isMovieExist) {
            Movie selectedMovie = movieList.getMovie().get(choice - 1);

            print("Enter your tickets: ");
            int totalTickets = ReadInput.getScanner().nextInt();

            print("Your total cost is Rs: " + selectedMovie.getPrice() * totalTickets);

            int availableTickets = selectedMovie.getAvailableTickets() - totalTickets;
            selectedMovie.setAvailableTickets(availableTickets);

            print("1.Yes");
            print("2.No");
            print("Enter your choice: ");

            int confirmChoice = ReadInput.getScanner().nextInt();
            if (confirmChoice == 1) {
                print("your booking is confirmed!");
                ArrayList<BookingHistory> bookingHistories = loggedInUser.getBookingHistories();
                BookingHistory bookingHistory = new BookingHistory(new Date(), selectedMovie, totalTickets);
                bookingHistories.add(bookingHistory);
                loggedInUser.setBookingHistories(bookingHistories);
                mainMenu();
            } else {
                mainMenu();
            }
        } else {
            System.out.println("Invalid Choice");
            mainMenu();
        }
    }

    @Override
    public void printHistory() {
        if (loggedInUser.getBookingHistories().size() > 0) {
            loggedInUser.getBookingHistories().forEach(bookingHistory -> {
                System.out.println("---------");
                System.out.println("Movie: " + bookingHistory.getMovie());
                System.out.println("No of tickets: " + bookingHistory.getNoOfTickets());
                System.out.println("Date: " + bookingHistory.getDate());
            });
        } else {
            print("No Booking");
        }
        mainMenu();

    }

}
