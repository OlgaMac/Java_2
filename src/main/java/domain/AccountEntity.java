package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
@NoArgsConstructor // всегда пустой конструктор или без параметров

public class AccountEntity {

    @Id //первичный ключ
    @Column(name = "account_number")
    private String accountNumber;
    @Column(columnDefinition = "NUMERIC(19,0)")
    private double amount;
    //@Column(name = "client_id")
    //private Long clientId;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}

