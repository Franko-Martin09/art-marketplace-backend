/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artmarketplace.artmarketplace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.artmarketplace.artmarketplace.model.Dibujo;
import com.artmarketplace.artmarketplace.repository.DibujoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author ASUS
 */
@RestController//por que estamos haaciendo una api rest*
@RequestMapping("/apiprueba")
public class HolaController {
    private final DibujoRepository dibujoRepository;
    
    public HolaController(DibujoRepository dibujoRepository) {
    this.dibujoRepository = dibujoRepository;
}
    @GetMapping("/hola")//se llama a este metodo mediante el 
    public String saludar(){
        return "Art Makertplace funcionando";
    }
    
    @PostMapping("/dibujos")
    public Dibujo guardarDibujo(@RequestBody Dibujo dibujo){
        return dibujoRepository.save(dibujo);
    }
    
    @GetMapping("/dibujos")
    public List<Dibujo> listarDibujos(){
        return dibujoRepository.findAll();
    }
    @GetMapping("/dibujos/{id}")
    public Dibujo obtenerDibujoPorId(@PathVariable Long id){
    return dibujoRepository.findById(id).orElse(null);
    }
}