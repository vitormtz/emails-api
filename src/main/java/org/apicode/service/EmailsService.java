/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.service;

import org.apicode.model.Email;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/emails")
public class EmailsService {

    private RestTemplate restTemplate = new RestTemplate();

    public EmailsService() {
    }

    public EmailsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<String> enviarEmail(@RequestBody Email emailRequest) {

        String url = "http://localhost:8080/emails";

        if (restTemplate.postForObject(url, emailRequest, Email.class) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        }
    }
}
