package budgetapp.controller;

import budgetapp.model.Budget;
import budgetapp.service.BudgetService;
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

    @PostMapping(path = "/add")
    public ResponseEntity addBudget(@RequestBody Budget budget) {
        Budget savedBudget = budgetService.save(budget);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public List<Budget> getAllBudgets () {
        List<Budget> allBudgets = budgetService.findAll();
        return allBudgets;
    }

    @GetMapping(path = "/{budgetId}")
    @ResponseBody
    public Budget findBudgetById (@PathVariable("budgetId") long budgetId) {
        Budget budget = budgetService.findById(budgetId);
        return budget;
    }

    @DeleteMapping(path = "/{budgetId}")
    public void removeBudget (@PathVariable("budgetId") long budgetId) {
        budgetService.deleteById(budgetId);
    }

    @DeleteMapping
    public void removeBudget (@RequestBody Budget budget) {
        budgetService.delete(budget);
    }
}
