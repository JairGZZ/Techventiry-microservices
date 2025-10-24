//package com.jairdev.Users_MicroService.controller;
//
//import com.jairdev.Users_MicroService.dto.LoginRequest;
//import com.jairdev.Users_MicroService.dto.RegisterRequest;
//import com.jairdev.Users_MicroService.entities.Usuario;
//import com.jairdev.Users_MicroService.service.AutenticacionService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//@RequiredArgsConstructor
//public class AutenticacionController {
//    private final AutenticacionService autenticacionService;
//
//    @PostMapping("/register")
//    public ResponseEntity<Usuario> register(@RequestBody @Valid RegisterRequest request) {
//        return ResponseEntity.ok(autenticacionService.register(request));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
//        return ResponseEntity.ok(autenticacionService.login(request));
//    }
//}