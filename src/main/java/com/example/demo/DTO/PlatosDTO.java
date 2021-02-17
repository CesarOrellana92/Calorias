package com.example.demo.DTO;

import java.util.ArrayList;

public class PlatosDTO {

    private String nombre;
    private ArrayList<IngredienteDTO> ingredientes;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }



}
