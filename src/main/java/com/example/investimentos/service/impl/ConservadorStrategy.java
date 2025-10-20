package com.example.investimentos.service.impl;

import com.example.investimentos.model.InvestimentoRequest;
import com.example.investimentos.model.InvestimentoResult;
import com.example.investimentos.service.InvestimentoStrategy;
import org.springframework.stereotype.Component;

@Component("CONSERVADOR")
public class ConservadorStrategy implements InvestimentoStrategy {

    @Override
    public InvestimentoResult calcular(InvestimentoRequest request) {
        // regra simples: retorno fixo baixo
        double montante = request.getValor() * (1 + 0.02 * request.getAnos());
        return new InvestimentoResult(montante, "CONSERVADOR");
    }

    @Override
    public String getType() {
        return "CONSERVADOR";
    }
}
