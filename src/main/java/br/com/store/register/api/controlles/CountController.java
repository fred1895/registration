package br.com.store.register.api.controlles;

import br.com.store.register.domain.entities.Count;
import br.com.store.register.domain.request.CountRequest;
import br.com.store.register.infra.usecases.CovertValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counts")
public class CountController {

    @Autowired
    private CovertValue covertValue;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Count save(@RequestBody CountRequest countRequest) {
        return covertValue.addTaxes(countRequest);
    }

}
