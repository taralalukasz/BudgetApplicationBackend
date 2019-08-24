package budgetapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BUDGET")
public class Budget {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name="amount")
    private double amount;

    @Column(name="name")
    private String name;
}
