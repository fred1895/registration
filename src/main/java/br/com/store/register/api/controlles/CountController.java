package br.com.store.register.api.controlles;

import br.com.store.register.domain.request.CountRequest;
import br.com.store.register.domain.response.CountResponse;
import br.com.store.register.infra.usecases.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CountResponse> getCounts() {
        return countService.getCounts();
    }

}
