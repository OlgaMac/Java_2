package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private Long clientId;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;
    private Long client_id;
    private Long account_number;
    private Long amount;
    private Long maxAmount;
    private Long totalAmount;
}

