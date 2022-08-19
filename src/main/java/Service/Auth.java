package Service;

import Utils.ReadInput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

import static Utils.Utils.print;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Auth {
public void authmenu(){
    print("1. Login");
    print("2. Register");
    print("3. Exit");
    print("Enter your choice: ");
    int choice= ReadInput.getScanner().nextInt();
    if(choice==1){



    } else if (choice==2) {
        print("Enter your name: ");
        String username=ReadInput.getScanner().nextLine();
        print("Enter password: ");
        String password=ReadInput.getScanner().nextLine();


    }
    else{
        System.exit(0);
    }


}
}

