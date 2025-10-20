package com.example.investimentos.service;

import com.example.investimentos.dto.ClienteDTO;
import com.example.investimentos.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {
    ClienteDTO criar(ClienteDTO dto);
    ClienteDTO buscarPorId(Long id);
    Page<ClienteDTO> listar(Pageable pageable);
    ClienteDTO atualizar(Long id, ClienteDTO dto);
    void deletar(Long id);

    void register(Cliente user);
}
