package com.example.investimentos.service.impl;

import com.example.investimentos.model.InvestimentoRequest;
import com.example.investimentos.model.InvestimentoResult;
import com.example.investimentos.service.InvestimentoService;
import com.example.investimentos.service.InvestimentoStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InvestimentoServiceImpl implements InvestimentoService {

    private final Map<String, InvestimentoStrategy> strategies;

    public InvestimentoServiceImpl(Map<String, InvestimentoStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public InvestimentoResult avaliar(InvestimentoRequest request) {
        var strat = strategies.getOrDefault(request.getPerfil(), strategies.get("CONSERVADOR"));
        return strat.calcular(request);
    }
}
