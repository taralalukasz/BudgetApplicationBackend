package budgetapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date creationDate;
}
