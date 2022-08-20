import Model.User;
import Service.Auth;
import Service.MainMenu;
import Utils.MovieList;
import Utils.UserUtils;

public class BookMyShow {
    public static void main(String[] args) {

        UserUtils userUtils = new UserUtils();
        MovieList movieList = new MovieList();
        movieList.loadMovies();
        Auth auth = new Auth();
        auth.initUsers(userUtils);
        auth.authMenu();
        User loggedInUser = userUtils.getLoggedInUser();
        MainMenu mainMenu = new MainMenu(movieList, loggedInUser, auth);
        mainMenu.mainMenu();

    }
}