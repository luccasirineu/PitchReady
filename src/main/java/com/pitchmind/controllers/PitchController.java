package com.pitchmind.controllers;

import com.pitchmind.dtos.PitchRequest;
import com.pitchmind.dtos.PitchResponse;
import com.pitchmind.services.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PitchController {

    @Autowired
    private PitchService pitchService;

    @PostMapping(value = "/pitch",  produces = "application/json")
    public ResponseEntity<PitchResponse> generatePitch(@RequestBody PitchRequest request) {
        String pitch = pitchService.generatePitch(request.getDescription());
        PitchResponse response = new PitchResponse(pitch);

        System.out.println("DESCRICAO: " + request.getDescription() );
        System.out.println("RESPOSTA: " + response.getResponse());

        pitchService.savePitch(response, request.getDescription());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
