package com.example.investimentos.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestimentoResult {
    private double montante;
    private String perfilUsado;
}
