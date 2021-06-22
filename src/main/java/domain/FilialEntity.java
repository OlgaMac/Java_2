package domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@ToString(exclude = "managers")
@Entity
@Table(name = "filial")
@NoArgsConstructor

public class FilialEntity {
    @Id
    @Column(name = "filial_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "bank_code")
    private String bankCode;
    private String adress;
    @ManyToMany(mappedBy = "filials")
    private Collection<ManagerEntity> managers;
}
