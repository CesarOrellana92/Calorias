package com.example.demo.DTO;

import java.util.ArrayList;

public class ComidaResponseDTO {

    private String nombre;
    private Double caloriasTotales;
    private ArrayList<IngredienteDTO> ingredientes;
    //private IngredienteDTO ingredienteMasCaloria;


    public Double getCaloriasTotales() {
        return caloriasTotales;
    }

    public void setCaloriasTotales(Double caloriasTotales) {
        this.caloriasTotales = caloriasTotales;
    }

    public ArrayList<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /*public IngredienteDTO getIngredienteMasCaloria() {
        return ingredienteMasCaloria;
    }

    public void setIngredienteMasCaloria(IngredienteDTO ingredienteMasCaloria) {
        this.ingredienteMasCaloria = ingredienteMasCaloria;
    }*/
}
