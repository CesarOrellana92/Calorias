package com.example.demo.services.impl;

import com.example.demo.DTO.IngredienteDTO;
import com.example.demo.DTO.IngredienteRespDTO;

import java.util.List;

public interface IngredienteService {


    public Double getCaloriaTotal(List<IngredienteDTO> listIngredientes);
    public List<IngredienteRespDTO> getIngredienteCaloria(List<IngredienteDTO> listIngredientes);
    public IngredienteRespDTO getIngredienteMayorCaloria(List<IngredienteDTO> listIngredientes);
}
