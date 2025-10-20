package com.example.investimentos.controller;

import com.example.investimentos.dto.AuthRequest;
import com.example.investimentos.dto.AuthResponse;
import com.example.investimentos.model.Cliente;
import com.example.investimentos.security.JwtUtil;
import com.example.investimentos.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final ClienteService service;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;

    public AuthController(ClienteService service, JwtUtil jwtUtil, AuthenticationManager authManager) {
        this.service = service;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Cliente user) {
        try {
            service.register(user);
            return ResponseEntity.ok().body("Usuário registrado com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }
}