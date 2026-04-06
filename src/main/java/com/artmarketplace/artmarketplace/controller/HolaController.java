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
    public ResponseEntity<Dibujo> obtenerDibujoPorId(@PathVariable Long id){
       if (dibujoRepository.existsById(id)) {
           Dibujo dibujo = dibujoRepository.findById(id).orElse(null);
           return ResponseEntity.ok(dibujo);//200 + el objeto
      } else {
        // 3. No existe → error
        return ResponseEntity.notFound().build(); // 404
    }
    
    }
    @DeleteMapping("/dibujos/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if(dibujoRepository.existsById(id)){//Verific si existe. 
            dibujoRepository.deleteById(id);//SI EXISTE->lo borra
            return ResponseEntity.noContent().build();//204
        }else {
            //No existe ->error
            return ResponseEntity.notFound().build(); //404
        }
    }
    @PutMapping("/dibujos/{id}")
    public ResponseEntity<Dibujo> actualizarDibujo(@PathVariable Long id,@RequestBody Dibujo dibujoNuevo){
        if(dibujoRepository.existsById(id)){//Verifica si existe. 
            dibujoNuevo.setId(id); // el que hay que pisar.
            Dibujo actualizado = dibujoRepository.save(dibujoNuevo);//save lo actualiza si el id ya existe
            return ResponseEntity.ok(actualizado);//204 + el dibujo actualizado
        }else {
            return ResponseEntity.notFound().build(); //404
        }
    }
        
    
}