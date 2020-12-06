package br.com.store.register.infra.dao;

import br.com.store.register.domain.entities.Count;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountDAO extends JpaRepository<Count, Long> {

}
