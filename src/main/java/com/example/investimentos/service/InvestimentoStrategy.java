package com.example.investimentos.service;

import com.example.investimentos.model.InvestimentoRequest;
import com.example.investimentos.model.InvestimentoResult;

public interface InvestimentoStrategy {
    InvestimentoResult calcular(InvestimentoRequest request);
    String getType(); // e.g., CONSERVADOR, ARROJADO
}
