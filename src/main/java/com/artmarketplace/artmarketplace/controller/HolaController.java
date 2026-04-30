/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artmarketplace.artmarketplace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.artmarketplace.artmarketplace.model.Dibujo;
import com.artmarketplace.artmarketplace.service.DibujoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
/**
 *
 * @author ASUS
 */
@RestController//por que estamos haaciendo una api rest*
@RequestMapping("/apiprueba")
public class HolaController {
    private final DibujoService dibujoService;
    
    public HolaController(DibujoService dibujoService) {
    this.dibujoService = dibujoService;
}
    @GetMapping("/hola")//se llama a este metodo mediante el 
    public String saludar(){
        return "Art Makertplace funcionando";
    }
    
    @PostMapping("/dibujos")
    public Dibujo guardarDibujo(@RequestBody Dibujo dibujo){
        return dibujoService.guardarDibujo(dibujo);
    }
    
    @GetMapping("/dibujos")
    public List<Dibujo> listarDibujos(){
        return dibujoService.listarDibujos();
    }
    @GetMapping("/dibujos/{id}")
    public ResponseEntity<Dibujo> obtenerDibujoPorId(@PathVariable Long id){
       Dibujo dibujo = dibujoService.obtenerPorId(id);
    if(dibujo != null){
        return ResponseEntity.ok(dibujo);
    }
    return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/dibujos/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if(dibujoService.eliminarDibujo(id)){
            return ResponseEntity.noContent().build();
        }return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/dibujos/{id}")
    public ResponseEntity<Dibujo> actualizarDibujo(@PathVariable Long id,@RequestBody Dibujo dibujoNuevo){
        Dibujo actualizado = dibujoService.actualizarDibujo(id, dibujoNuevo);
        if(actualizado != null){
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
        

