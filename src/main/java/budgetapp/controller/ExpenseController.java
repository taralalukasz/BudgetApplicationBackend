package budgetapp.controller;

import budgetapp.model.Expense;
import budgetapp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping(path = "/add")
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.save(expense);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public List<Expense> getAllExpenses () {
        List<Expense> allExpenses = expenseService.findAll();
        return allExpenses;
    }

    @GetMapping(path = "/{expenseId}")
    @ResponseBody
    public Expense findExpenseById (@PathVariable("expenseId") long expenseId) {
        Expense expense = expenseService.findById(expenseId);
        return expense;
    }

    @DeleteMapping(path = "/{expenseId}")
    public void removeExpense (@PathVariable("expenseId") long expenseId) {
        expenseService.deleteById(expenseId);
    }

    @DeleteMapping
    public void removeExpense (@RequestBody Expense expense) {
        expenseService.delete(expense);
    }
}
