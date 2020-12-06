package br.com.store.register.infra.usecases.taxes;

import java.math.BigDecimal;

public class OverThreeDays implements TaxRule{
    @Override
    public BigDecimal fixedValue(BigDecimal originalValue, Integer daysLate) {
        BigDecimal multiply = originalValue.multiply(new BigDecimal(0.03));
        BigDecimal fixedValue = originalValue.add(multiply);
        for (int i = 0; i < daysLate; i++) {
            BigDecimal forDay = fixedValue.multiply(new BigDecimal(0.003));
            fixedValue = fixedValue.add(forDay);
        }
        return fixedValue;
    }
}
