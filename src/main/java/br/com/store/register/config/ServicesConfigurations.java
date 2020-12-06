package br.com.store.register.config;

import br.com.store.register.infra.repositories.CountRepository;
import br.com.store.register.infra.repositories.CountRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfigurations {

    @Bean
    public CountRepository countRepository() {
        return new CountRepositoryJPA();
    }
}
