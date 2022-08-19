import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookMyShow {
    public static void main(String[] args) {
        System.out.println("WELCOME TO BOOKMYSHOW ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.println("enter ur choice: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            while (true) {
                ArrayList<User> users = new ArrayList<>();
                User demoUser = new User("demo");
                demoUser.setBookingHistorys(new ArrayList<>());
                users.add(demoUser);

                ArrayList<Movie> movieArrayList = new ArrayList<>();
                movieArrayList.add(new Movie(1, "RRR", 50, 180));
                movieArrayList.add(new Movie(2, "SUZHAL", 30, 170));
                movieArrayList.add(new Movie(3, "ROCKETRY", 40, 190));
                movieArrayList.add(new Movie(4, "GULU GULU", 80, 150));
                movieArrayList.add(new Movie(5, "PAPER ROCKET", 90, 200));
                movieArrayList.add(new Movie(6, "VIRUMAN", 12, 250));

//            boolean isExits = false;
//            for (int i = 0; i < users.size(); i++) {
//                User user = users.get(i);
//                if (user.getName().equals(name)) {
//                    isExits = true;
//                    break;
//                }
//            }


                boolean isUserExist = users.stream().anyMatch(user -> user.getName().equals(name));
                if (isUserExist) {
                    User loggedInUser = users.stream().filter(u -> u.getName().equals(name)).findFirst().get();

                    if (loggedInUser.getBookingHistorys().size() > 0) {
                        System.out.println(loggedInUser.getBookingHistorys().get(0).getMovieName());
                    } else {
                        System.out.println("error");
                    }

                    System.out.println("1. Movies");
                    System.out.println("2. Booking History");
                    int userChoice = scanner.nextInt();

                    if (userChoice == 1) {
                        System.out.println("LIST OF MOVIES");
                        movieArrayList.forEach(movie -> {
                            System.out.println(movie.getId() + "." + movie.getName());
                        });
                        System.out.println("Enter your choice: ");
                        int movieChoice = scanner.nextInt();
                        Movie selectedMovie = movieArrayList.get(movieChoice - 1);
                        System.out.println("Enter tickets: ");

                        int noOfTickets = scanner.nextInt();
                        int amount = selectedMovie.getTicketPrice() * noOfTickets;
                        int bal = selectedMovie.getNoOfAvailableTickets() - noOfTickets;
                        System.out.println("Payment amount is: " + amount);
                        System.out.println("Balance tickets are: " + bal);

                        ArrayList<BookingHistory> bookingHistories = loggedInUser.getBookingHistorys();
                        if (bookingHistories == null)
                            bookingHistories = new ArrayList<>();
                        bookingHistories.add(new BookingHistory(bookingHistories.size() + 1, selectedMovie.getName(), noOfTickets, amount, new Date()));
                        loggedInUser.setBookingHistorys(bookingHistories);

                        System.out.println("........THANK YOU FOR YOUR BOOKING.........");

                        System.out.println("Do you wanna book an another ticket?");
                        System.out.println("1. YES");
                        System.out.println("2. NO");
                        int continueChoice = scanner.nextInt();
                        if (continueChoice == 2) {
                            System.exit(0);
                        }
                    } else if (userChoice == 2) {

                        if (loggedInUser.getBookingHistorys() != null && loggedInUser.getBookingHistorys().size() > 0) {
                            loggedInUser.getBookingHistorys().forEach(bookingHistory -> {
                                System.out.println("Id: " + bookingHistory.getId());
                                System.out.println(bookingHistory.getMovieName());
                                System.out.println(bookingHistory.getNoOfTickets());
                                System.out.println(bookingHistory.getTotalAmount());
                                System.out.println(bookingHistory.getDate());
                            });
                        } else {
                            System.out.println("No booking made so far");
                        }
                    } else {
                        System.out.println("Invalid user");
                    }
                }
            }
        } else {
            System.exit(0);
        }
    }
}
