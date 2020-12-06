package br.com.store.register.infra.usecases;

import br.com.store.register.domain.entities.Count;
import br.com.store.register.domain.request.CountRequest;
import br.com.store.register.infra.converter.ResponseConverter;
import br.com.store.register.infra.repositories.CountRepository;
import br.com.store.register.infra.usecases.taxes.OverFiveDays;
import br.com.store.register.infra.usecases.taxes.OverThreeDays;
import br.com.store.register.infra.usecases.taxes.TaxRule;
import br.com.store.register.infra.usecases.taxes.UntilThreeDays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CovertValue {

    @Autowired
    private ResponseConverter responseConverter;

    @Autowired
    private CountRepository countRepository;

    public Count addTaxes(CountRequest countRequest) {
        Count count = responseConverter.convertToEntity(countRequest);

        LocalDate dueDate = countRequest.getDueDate();
        LocalDate payday = countRequest.getPayday();
        Integer daysLate = getLateDays(dueDate, payday);
        BigDecimal fixedValue = getFixedValue(countRequest.getOriginalValue(), daysLate);

        count.setFixedValue(fixedValue);
        count.setDaysLate(daysLate);

        countRepository.save(count);
        return count;

    }

    private Integer getLateDays(LocalDate dueDate, LocalDate payday) {
        return payday.compareTo(dueDate);
    }

    private BigDecimal getFixedValue(BigDecimal originalValue, Integer lateDays) {
        if (lateDays <= 3) {
            TaxRule taxRule = new UntilThreeDays();
            return taxRule.fixedValue(originalValue, lateDays);
        } else if (lateDays > 5) {
            TaxRule taxRule = new OverFiveDays();
            return taxRule.fixedValue(originalValue, lateDays);
        } else {
            TaxRule taxRule = new OverThreeDays();
            return taxRule.fixedValue(originalValue, lateDays);
        }
    }
}
