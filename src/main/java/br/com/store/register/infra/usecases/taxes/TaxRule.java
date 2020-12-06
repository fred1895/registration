package br.com.store.register.infra.usecases.taxes;

import br.com.store.register.domain.request.CountRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface TaxRule {

    BigDecimal fixedValue(CountRequest countRequest);
}
