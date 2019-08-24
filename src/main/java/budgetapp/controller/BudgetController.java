package budgetapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetController {
    @RequestMapping(path = "/addBudget", method = RequestMethod.GET)
    public ResponseEntity<String> addBudget() {
        return new ResponseEntity<String>("response", HttpStatus.OK);
    }
}
