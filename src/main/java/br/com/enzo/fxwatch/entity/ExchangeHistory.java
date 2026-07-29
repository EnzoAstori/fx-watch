package br.com.enzo.fxwatch.entity;

import br.com.enzo.fxwatch.enums.CurrencyCode;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "exchange_history")

public class ExchangeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,precision = 19, scale = 4)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime collectedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CurrencyCode currencyCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_alert_id", nullable = false)
    private CurrencyAlert currencyAlert;
}
