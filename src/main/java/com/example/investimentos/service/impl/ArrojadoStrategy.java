package com.example.investimentos.service.impl;

import com.example.investimentos.model.InvestimentoRequest;
import com.example.investimentos.model.InvestimentoResult;
import com.example.investimentos.service.InvestimentoStrategy;
import org.springframework.stereotype.Component;

@Component("ARROJADO")
public class ArrojadoStrategy implements InvestimentoStrategy {

    @Override
    public InvestimentoResult calcular(InvestimentoRequest request) {
        // regra simples: maior retorno com risco
        double montante = request.getValor() * Math.pow(1 + 0.06, request.getAnos());
        return new InvestimentoResult(montante, "ARROJADO");
    }

    @Override
    public String getType() {
        return "ARROJADO";
    }
}
