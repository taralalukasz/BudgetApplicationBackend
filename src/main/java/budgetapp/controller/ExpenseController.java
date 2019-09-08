package budgetapp.controller;

import budgetapp.model.Expense;
import budgetapp.service.ExpenseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/add")
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) throws JsonProcessingException {
        Expense savedExpense = expenseService.save(expense);
        String expenseAsJson = objectMapper.writeValueAsString(savedExpense);
        return new ResponseEntity(expenseAsJson, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<String> getAllExpenses () throws JsonProcessingException {
        List<Expense> allExpenses = expenseService.findAll();
        String allExpensesAsJson = objectMapper.writeValueAsString(allExpenses);
        return new ResponseEntity<>(allExpensesAsJson, HttpStatus.OK);
    }

    @GetMapping(path = "/{expenseId}")
    @ResponseBody
    public ResponseEntity<String> findExpenseById (@PathVariable("expenseId") long expenseId) throws JsonProcessingException {
        Expense expense = expenseService.findById(expenseId);
        String expenseAsJson = objectMapper.writeValueAsString(expense);
        return new ResponseEntity<>(expenseAsJson, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{expenseId}")
    public ResponseEntity removeExpense (@PathVariable("expenseId") long expenseId) {
        expenseService.deleteById(expenseId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity removeExpense (@RequestBody Expense expense) {
        expenseService.delete(expense);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
