package br.com.store.register.infra.converter;

import br.com.store.register.domain.converter.Converter;
import br.com.store.register.domain.entities.Count;
import br.com.store.register.domain.response.CountResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseConverter implements Converter<Count, CountResponse> {
    @Override
    public CountResponse convertToDto(Count count) {
        CountResponse countResponse = new CountResponse();
        countResponse.setId(count.getId());
        countResponse.setDaysLate(count.getDaysLate());
        countResponse.setFixedValue(count.getFixedValue());
        countResponse.setName(count.getName());
        countResponse.setOriginalValue(count.getOriginalValue());
        countResponse.setPayday(count.getPayday());

        return countResponse;
    }

    @Override
    public List<CountResponse> convertListToDto(List<Count> count) {
        List<CountResponse> countRespons = new ArrayList<>();
        for (Count c: count) {
            CountResponse countResponse = convertToDto(c);
            countRespons.add(countResponse);
        }
        return countRespons;
    }

    @Override
    public Count convertToEntity(CountResponse countResponse) {
        return null;
    }
}
