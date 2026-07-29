package br.com.enzo.fxwatch.repository;

import br.com.enzo.fxwatch.entity.CurrencyAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyAlertRepository
        extends JpaRepository<CurrencyAlert, Long> {

}