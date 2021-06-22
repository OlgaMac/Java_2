package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "operations")
@NoArgsConstructor
@Data

public class OperationEntity {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer operationId;
    @Column(name = "account_from")
    private String fromAccount;
    @Column(name = "account_to")
    private String toAccount;
    @Column(columnDefinition = "NUMERIC(19,0)")
    private Double amount;

}
