package com.example.investimentos.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestimentoRequest {
    private double valor;
    private int anos;
    private String perfil; // CONSERVADOR or ARROJADO
}
