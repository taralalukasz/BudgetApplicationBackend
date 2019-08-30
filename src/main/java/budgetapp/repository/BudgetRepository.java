package budgetapp.repository;

import budgetapp.model.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {
    List<Budget> findAll();

    Budget findById(long id);

    Budget save(Budget budget);

    void delete(Budget budget);

    void deleteById(long id);
}
