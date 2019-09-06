package budgetapp.repository;

import budgetapp.model.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findAll();

    Expense findById(long id);

    Expense save(Expense budget);

    void delete(Expense budget);

    void deleteById(long id);
}