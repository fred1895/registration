package br.com.store.register.infra.converter;

import br.com.store.register.domain.converter.Converter;
import br.com.store.register.domain.entities.Count;
import br.com.store.register.domain.request.CountRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseConverter implements Converter<Count, CountRequest> {
    @Override
    public CountRequest convertToDto(Count count) {
        return null;
    }

    @Override
    public List<CountRequest> convertListToDto(List<Count> t) {
        return null;
    }

    @Override
    public Count convertToEntity(CountRequest countRequest) {
        Count count = new Count();
        count.setName(countRequest.getName());
        count.setOriginalValue(countRequest.getOriginalValue());
        count.setDueDate(countRequest.getDueDate());
        count.setPayday(countRequest.getPayday());

        return count;
    }
}
