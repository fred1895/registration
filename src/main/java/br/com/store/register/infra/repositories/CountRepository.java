package br.com.store.register.infra.repositories;

import br.com.store.register.domain.entities.Count;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountRepository extends JpaRepository<Count, Long> {

}
