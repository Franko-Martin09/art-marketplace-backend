/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artmarketplace.artmarketplace.dto;
/**
 *
 * @author ASUS
 */
public class DibujoDTO {
    private String titulo;
    private double precio;
    
    public String getTitulo(){
        return titulo;
    }    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
}
