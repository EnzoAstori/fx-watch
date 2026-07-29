package br.com.enzo.fxwatch.entity;

import br.com.enzo.fxwatch.enums.CurrencyCode;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "currency_alert")

public class CurrencyAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CurrencyCode currencyCode;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(nullable = false,precision = 19, scale = 4)
    private BigDecimal lowestPrice;

    @Column(nullable = false,precision = 19, scale = 4)
    private BigDecimal highestPrice;

    @Column(nullable = false,precision = 19, scale = 4)
    private BigDecimal lastPrice;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime lastCheck;

    private LocalDateTime lastNotification;

    @OneToMany(mappedBy = "currencyAlert", fetch = FetchType.LAZY)
    private List<ExchangeHistory> history;
}
