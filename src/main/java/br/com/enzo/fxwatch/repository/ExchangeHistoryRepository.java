package br.com.enzo.fxwatch.repository;

import br.com.enzo.fxwatch.entity.ExchangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeHistoryRepository
        extends JpaRepository<ExchangeHistory, Long> {

}