package budgetapp.controller;

import budgetapp.model.Budget;
import budgetapp.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BudgetController {
    @Autowired
    private BudgetRepository budgetRepository;

    @RequestMapping(path = "/addBudget", method = RequestMethod.GET)
    public ResponseEntity<String> addBudget() {
        List<Budget> all = budgetRepository.findAll();
        return new ResponseEntity<String>(all.toString(), HttpStatus.OK);
    }
}
