package br.com.fiap.corebank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String agency;

    @NotBlank(message = "{cardholderName.not.blank}")
    private String cardholderName;

    @NotBlank(message = "{holderCpf.not.blank}")
    private String holderCpf;

    @PastOrPresent(message = "{openingDate.pastorpresent}")
    private LocalDate openingDate;

    @PositiveOrZero(message = "{openingBalance.positiveorzero}")
    private BigDecimal openingBalance;

    @Enumerated(EnumType.STRING)
    private AccountStatusType status;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}