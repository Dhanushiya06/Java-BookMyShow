package Utils;

import Model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class UserUtils {
    private User loggedInUser;
    private ArrayList<User> users = new ArrayList<>();
}
