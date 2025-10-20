package com.example.investimentos.integration;

import com.example.investimentos.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void registerLoginAccessProtected() {
        String base = "http://localhost:" + port;

        // 1. Registrar usuário
        Cliente user = new Cliente();
        user.setUsername("integuser");
        user.setPassword("password123");
        user.setNome("Integration User");
        user.setEmail("integ@test.com");

        ResponseEntity<Void> registerResponse = restTemplate.postForEntity(
                base + "/auth/register", user, Void.class);
        assertEquals(HttpStatus.OK, registerResponse.getStatusCode());

        // 2. Fazer login
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String loginBody = "{\"username\":\"integuser\",\"password\":\"password123\"}";

        HttpEntity<String> loginEntity = new HttpEntity<>(loginBody, headers);
        ResponseEntity<String> loginResponse = restTemplate.postForEntity(
                base + "/auth/login", loginEntity, String.class);

        assertEquals(HttpStatus.OK, loginResponse.getStatusCode());

        // Extrair token corretamente - remove aspas se existirem
        String token = loginResponse.getBody();
        assertNotNull(token);
        token = token.replace("\"", "").trim();
        assertTrue(token.length() > 10);

        // 3. Acessar endpoint protegido
        HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.setBearerAuth(token); // Usa setBearerAuth que formata corretamente

        HttpEntity<Void> protectedRequest = new HttpEntity<>(authHeaders);
        ResponseEntity<String> protectedResponse = restTemplate.exchange(
                base + "/clientes", HttpMethod.GET, protectedRequest, String.class);

        assertEquals(HttpStatus.OK, protectedResponse.getStatusCode());
    }
}