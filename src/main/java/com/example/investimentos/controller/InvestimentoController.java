package com.example.investimentos.controller;

import com.example.investimentos.model.InvestimentoRequest;
import com.example.investimentos.model.InvestimentoResult;
import com.example.investimentos.service.InvestimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    private final InvestimentoService service;

    public InvestimentoController(InvestimentoService service) {
        this.service = service;
    }

    @Operation(summary = "Avalia investimento conforme perfil", description = "Recebe valor, anos e perfil e retorna montante estimado")
    @ApiResponse(responseCode = "200", description = "Resultado da avaliação", content = @Content(schema = @Schema(implementation = InvestimentoResult.class)))
    @PostMapping("/avaliar")
    public ResponseEntity<InvestimentoResult> avaliar(@RequestBody InvestimentoRequest request) {
        return ResponseEntity.ok(service.avaliar(request));
    }
}
