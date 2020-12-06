package br.com.store.register.api.controlles;

import br.com.store.register.domain.request.CountRequest;
import br.com.store.register.infra.usecases.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counts")
public class CountController {

    @Autowired
    private CountService countService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CountRequest countRequest) {
        countService.saveCount(countRequest);
    }
      /*
    private BigDecimal getFixedValue(CountRequest countRequest) {
        Integer daysLate = getDaysLate(countRequest);

        if (daysLate <= 3) {
            TaxRule taxRule = new UntilThreeDays();
            return taxRule.fixedValue(countRequest);
        } else if (daysLate > 5) {
            TaxRule taxRule = new OverFiveDays();
            return taxRule.fixedValue(countRequest);
        } else {
            TaxRule taxRule = new OverThreeDays();
            return taxRule.fixedValue(countRequest);
        }
    }
*/


}
