package domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "client")//чтобы не было циклических вызовов друг друга
@Table(name = "client_data")
public class ClientDataEntity {

    @Id
    @Column(name = "client_id")
    private  Long clientId;
    @Column(name = "pass_serial")
    private  String passportSerial;
    @Column(name = "pass_number")
    private String passportNumber;

    @OneToOne
    //@JoinColumn(name = "client_id")
    @PrimaryKeyJoinColumn
    private ClientEntity client;


}
