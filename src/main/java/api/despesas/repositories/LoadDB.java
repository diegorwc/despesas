package api.despesas.repositories;

import api.despesas.models.Despesa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Configuration
public class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initDatabase (DespesaRepository despesaRepository) {
        return args -> {
//            log.info("Add registro" + despesaRepository.save(new Despesa("Aluguel", new BigDecimal(1000), LocalDate.of(2023, 01, 31))));
//            log.info("Add registro" + despesaRepository.save(new Despesa("Internet", new BigDecimal(99.90), LocalDate.of(2023, 01, 31))));
        };
    }
}
