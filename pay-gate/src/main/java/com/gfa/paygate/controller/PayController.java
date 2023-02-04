package com.gfa.paygate.controller;

import com.gfa.paygate.entity.DTO.CardDataDTO;
import com.gfa.paygate.service.PayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RequiredArgsConstructor
@RestController
public class PayController {
    private final PayService payService;
    @PostMapping("/pay-gate")
    public ResponseEntity<Object> payment(@RequestBody @Valid CardDataDTO cardData){
        Map<String, String> responseMap = new HashMap<>();
        String response = payService.payment(cardData);
        responseMap.put("status", response);
        if (response.equals("payment rejected")) return new ResponseEntity<>(responseMap, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, String>> invalidArgumentHandler(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Map<String, String>> illegalStateHandler(Exception ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", ex.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
