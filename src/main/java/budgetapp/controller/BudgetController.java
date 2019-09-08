package budgetapp.controller;

import budgetapp.model.Budget;
import budgetapp.service.BudgetService;
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
@RequestMapping(path = "/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/add")
    public ResponseEntity addBudget(@RequestBody Budget budget) {
        Budget savedBudget = budgetService.save(budget);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<String> getAllBudgets () throws JsonProcessingException {
        List<Budget> allBudgets = budgetService.findAll();
        String allBudgetsAsJson = objectMapper.writeValueAsString(allBudgets);
        return new ResponseEntity<>(allBudgetsAsJson, HttpStatus.OK);
    }

    @GetMapping(path = "/{budgetId}")
    @ResponseBody
    public ResponseEntity<String> findBudgetById (@PathVariable("budgetId") long budgetId) throws JsonProcessingException {
        Budget budget = budgetService.findById(budgetId);
        String budgetAsJson = objectMapper.writeValueAsString(budget);
        return new ResponseEntity<>(budgetAsJson, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{budgetId}")
    public ResponseEntity removeBudget (@PathVariable("budgetId") long budgetId) {
        budgetService.deleteById(budgetId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity removeBudget (@RequestBody Budget budget) {
        budgetService.delete(budget);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
