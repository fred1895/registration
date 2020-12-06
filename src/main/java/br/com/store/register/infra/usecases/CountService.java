package br.com.store.register.infra.usecases;

import br.com.store.register.domain.entities.Count;
import br.com.store.register.domain.request.CountRequest;
import br.com.store.register.infra.converter.RequestConverter;
import br.com.store.register.infra.repositories.CountRepository;
import br.com.store.register.infra.usecases.taxes.OverFiveDays;
import br.com.store.register.infra.usecases.taxes.OverThreeDays;
import br.com.store.register.infra.usecases.taxes.TaxRule;
import br.com.store.register.infra.usecases.taxes.UntilThreeDays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CountService {

    private final CountRepository countRepository;

    private final RequestConverter requestConverter;

    @Autowired
    public CountService(CountRepository countRepository, RequestConverter requestConverter) {
        this.countRepository = countRepository;
        this.requestConverter = requestConverter;
    }

    public void saveCount(CountRequest countRequest) {
        Count count = requestConverter.convertToEntity(countRequest);
        count.setDaysLate(getDaysLate(countRequest));
        BigDecimal fixedValue = getFixedValue(countRequest);
        count.setFixedValue(fixedValue);
        countRepository.save(count);
    }

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

    private Integer getDaysLate(CountRequest countRequest) {
        return countRequest.getPayday().compareTo(countRequest.getDueDate());
    }

}
