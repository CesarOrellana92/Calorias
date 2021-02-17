package com.example.demo.DAO;

import com.example.demo.DTO.IngredienteDTO;
import com.example.demo.model.Ingrediente;

import java.util.ArrayList;
import java.util.List;

public interface IngredientesDAO {

    public List<Ingrediente> loadJson();

}
