package budgetapp.service;

import budgetapp.model.Expense;
import budgetapp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense findById(long id) {
        return expenseRepository.findById(id);
    }

    public Expense save(Expense budget) {
        return expenseRepository.save(budget);
    }

    public void delete(Expense budget) {
        expenseRepository.delete(budget);
    }

    public void deleteById(long id) {
        expenseRepository.deleteById(id);
    }
}
