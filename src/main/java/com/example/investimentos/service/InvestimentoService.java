package com.example.investimentos.service;

import com.example.investimentos.model.InvestimentoRequest;
import com.example.investimentos.model.InvestimentoResult;

public interface InvestimentoService {
    InvestimentoResult avaliar(InvestimentoRequest request);
}
