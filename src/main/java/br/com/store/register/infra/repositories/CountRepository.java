package br.com.store.register.infra.repositories;

import br.com.store.register.domain.entities.Count;
import br.com.store.register.domain.response.CountResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountRepository {

    void save(Count count);

    List<CountResponse> listCounts();
}
