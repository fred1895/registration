package br.com.store.register.infra.repositories;

import br.com.store.register.domain.entities.Count;
import br.com.store.register.domain.response.CountResponse;
import br.com.store.register.infra.converter.ResponseConverter;
import br.com.store.register.infra.dao.CountDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CountRepositoryJPA implements CountRepository {
    @Autowired
    private CountDAO dao;

    @Autowired
    private ResponseConverter responseConverter;

    @Override
    public void save(Count count) {
        dao.save(count);
    }

    @Override
    public List<CountResponse> listCounts() {
        List<Count> counts = dao.findAll();
        return responseConverter.convertListToDto(counts);
    }
}
