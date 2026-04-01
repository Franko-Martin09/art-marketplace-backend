/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artmarketplace.artmarketplace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController//por que estamos haaciendo una api rest*
@RequestMapping("/apiprueba")
public class HolaController {
    
    @GetMapping("/hola")//se llama a este metodo mediante el 
    public String saludar(){
        return "Art Makertplace funcionando";
    }
}
