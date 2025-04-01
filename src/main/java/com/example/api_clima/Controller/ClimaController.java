package com.example.api_clima.Controller;

import com.example.api_clima.Dto.CidadeResultDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*")
@RestController
@RequestMapping("/clima")
public class ClimaController {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @GetMapping("{cidade}")
    public ResponseEntity<?> consultacidade(@PathVariable("cidade") String cidade) {
        if (cidade == null || cidade.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("O nome da cidade não pode estar vazio.");
        }

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&lang=pt", cidade, apiKey);
            ResponseEntity<CidadeResultDto> resp = restTemplate.getForEntity(url, CidadeResultDto.class);
            return ResponseEntity.ok(resp.getBody());

        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(404).body("Cidade não encontrada.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao consultar a API: " + e.getMessage());
        }
    }
}
