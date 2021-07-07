package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
@NoArgsConstructor // всегда пустой конструктор или без параметров
@AllArgsConstructor



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

