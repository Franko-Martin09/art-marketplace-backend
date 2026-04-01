/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.artmarketplace.artmarketplace.repository;
import com.artmarketplace.artmarketplace.model.Dibujo;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author ASUS
 */
public interface DibujoRepository extends JpaRepository<Dibujo, Long> {
    
}
