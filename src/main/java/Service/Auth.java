package Service;

import Model.User;
import Utils.ReadInput;
import Utils.UserUtils;

import java.util.ArrayList;

import static Utils.Utils.print;

public class Auth {
    private UserUtils userUtils;
    private ArrayList<User> users = new ArrayList<>();

    public void initUsers(UserUtils userUtils) {
        this.userUtils = userUtils;
        users = userUtils.getUsers();
    }

    public void authMenu() {
        while (true) {
            print("1.Login");
            print("2.Register");
            print("3.Exit");
            print("Enter your choice: ");
            int choice = ReadInput.getScanner().nextInt();
            if (choice == 1) {
                print("Enter your name: ");
                String name = ReadInput.getScanner().next();
                print("Enter password: ");
                String password = ReadInput.getScanner().next();
                boolean isUserExist = users.stream().anyMatch(user ->
                        (user.getName().equals(name)) && (user.getPassword().equals(password)));
                if (isUserExist) {
                    User loggedInUser = users.stream().filter(user ->
                                    (user.getName().equals(name)) && (user.getPassword().equals(password)))
                            .findFirst()
                            .get();
                    userUtils.setLoggedInUser(loggedInUser);
                    break;
                } else {
                    print("Invalid user");
                }
            } else if (choice == 2) {
                print("Enter your name: ");
                String name = ReadInput.getScanner().next();
                print("Enter password: ");
                String password = ReadInput.getScanner().next();
                boolean isUserExist = users.stream().anyMatch(user ->
                        (user.getName().equals(name)) && (user.getPassword().equals(password)));
                if (isUserExist) {
                    print(("User Exist"));
                } else {
                    User user = new User();
                    user.setId(users.size() + 1);
                    user.setName(name);
                    user.setPassword(password);
                    users.add(user);
                    userUtils.setUsers(users);
                    print("Register successfully");
                }
            } else if (choice == 3) {
                System.exit(0);
            } else {
                print("Invalid choice");
            }
        }
    }

}
