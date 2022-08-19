package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingHistory {

    private Date date;
    private int id;
    private String movieName;
    private int noOfTickets;
    private int price;

}
