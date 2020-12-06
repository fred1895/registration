package br.com.store.register.infra.usecases.taxes;

import br.com.store.register.domain.request.CountRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class UntilThreeDays implements TaxRule{
    @Override
    public BigDecimal fixedValue(CountRequest countRequest) {
        int daysLate = countRequest.getPayday().compareTo(countRequest.getDueDate());
        BigDecimal multiply = countRequest.getOriginalValue().multiply(new BigDecimal(0.02));
        BigDecimal fixedValue = countRequest.getOriginalValue().add(multiply);
        for (int i = 0; i < daysLate; i++) {
            BigDecimal forDay = fixedValue.multiply(new BigDecimal(0.001));
            fixedValue = fixedValue.add(forDay);
        }
        fixedValue = fixedValue.setScale(2, RoundingMode.HALF_EVEN);
        return fixedValue;
    }
}
