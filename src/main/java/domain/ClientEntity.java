package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;


@Data
@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor // всегда пустой конструктор или без параметров
public class ClientEntity {
    @Id //первичный ключ
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  clientId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToOne(mappedBy = "client")
    //@JoinColumn(name = "client_id")
    private  ClientDataEntity clientData;

    @OneToMany(mappedBy = "client")
    private Collection<AccountEntity> accounts;

    public ClientEntity(Long clientId, String lastName, String firstName, String middleName, LocalDate birthday) {
        this.clientId = clientId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthday = birthday;
    }
}
