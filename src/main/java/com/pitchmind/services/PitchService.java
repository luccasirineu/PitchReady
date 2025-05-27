package com.pitchmind.services;

import com.pitchmind.dtos.PitchRequest;
import com.pitchmind.dtos.PitchResponse;
import com.pitchmind.models.Pitch;
import com.pitchmind.repositories.PitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PitchService {

    @Value("${gemini.api.key}")
    private String API_KEY;

    @Autowired
    private PitchRepository repository;

    private static final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=";

    public String generatePitch(String description) {

        RestTemplate restTemplate = new RestTemplate();

        String prompt = "Gere um pitch de 1 minuto para o seguinte projeto: " + description;

        // Define o corpo da requisição conforme o formato esperado pela API do Gemini
        Map<String, Object> body = Map.of(
                "contents", List.of( // A chave "contents" recebe uma lista
                        Map.of("parts", List.of( // Cada item da lista é um mapa com a chave "parts"
                                Map.of("text", prompt) // Cada parte tem o texto (o prompt a ser enviado à IA)
                        ))
                )
        );

        // Configura os headers da requisição HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Combina o corpo e os headers na entidade HTTP que será enviada
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);


        ResponseEntity<Map> response = restTemplate.exchange(
                GEMINI_URL + API_KEY,
                HttpMethod.POST,
                entity,
                Map.class
        );

        // A resposta contém uma lista de "candidates", cada um com uma "content"
        List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.getBody().get("candidates");

        // Pega o conteúdo (mensagem) do primeiro candidato
        Map<String, Object> message = (Map<String, Object>) candidates.get(0).get("content");

        // Dentro da mensagem, pega a lista de partes (cada parte pode ser um trecho de texto)
        List<Map<String, String>> parts = (List<Map<String, String>>) message.get("parts");

        // Pega o pitch gerado
        String pitch = parts.get(0).get("text");



        // Retorna o pitch como String
        return pitch;
    }

    public Pitch savePitch(PitchResponse response, String description){

        LocalDateTime localDateTime = LocalDateTime.now();
        Pitch pitch = new Pitch(description,response, localDateTime );

        return repository.save(pitch);

    }

}
