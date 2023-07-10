package com.example.datn.service;

import org.springframework.stereotype.Service;

@Service
public interface SendMailService {

    void sendSimpleEmail( String toEmail, String subject, String body);

}
