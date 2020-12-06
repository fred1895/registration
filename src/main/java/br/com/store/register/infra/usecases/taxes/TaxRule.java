package br.com.store.register.infra.usecases.taxes;

import java.math.BigDecimal;

public interface TaxRule {

    BigDecimal fixedValue(BigDecimal originalValue, Integer daysLate);
}
