/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artmarketplace.artmarketplace.service;

import com.artmarketplace.artmarketplace.exception.RecursoNoEncontradoException;
import com.artmarketplace.artmarketplace.model.Dibujo;
import com.artmarketplace.artmarketplace.repository.DibujoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author ASUS
 */
@Service
public class DibujoService {
    
   private final DibujoRepository dibujoRepository;
    public DibujoService(DibujoRepository dibujoRepository) {
        this.dibujoRepository = dibujoRepository; // inicializa el campo
    }
    //metodos:
    public Dibujo obtenerPorId(Long id) {
     return dibujoRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Dibujo no encontrado con id "+id));
    }
   
    public List<Dibujo> listarDibujos(){
      return dibujoRepository.findAll();
    }
    public Dibujo guardarDibujo(Dibujo dibujo) {
    return dibujoRepository.save(dibujo);
    }
    public void eliminarDibujo(Long id) {
    if(!dibujoRepository.existsById(id)){
        throw new RecursoNoEncontradoException("Dibujo no encontrado con id: " + id);
    }
    dibujoRepository.deleteById(id);
    }
    
    public Dibujo actualizarDibujo(Long id, Dibujo dibujoNuevo) {
    if(!dibujoRepository.existsById(id)){
        throw new RecursoNoEncontradoException("Dibujo no encontrado con id: " + id);
    }
    dibujoNuevo.setId(id);
    return dibujoRepository.save(dibujoNuevo);
    }
}
