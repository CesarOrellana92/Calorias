package com.example.demo.services;

import com.example.demo.DAO.imp.IngredientesDAOImpl;
import com.example.demo.DTO.IngredienteDTO;
import com.example.demo.DTO.IngredienteRespDTO;
import com.example.demo.model.Ingrediente;
import com.example.demo.services.impl.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteServiceImpl implements IngredienteService {

    @Autowired
    private IngredientesDAOImpl ingredientesDAO;




    public Double getCaloriaTotal(List<IngredienteDTO> listIngredientes){
        Double caloriaTotal = 0.0;
        for (IngredienteDTO ingredienteDTO: listIngredientes) {
            caloriaTotal = getCaloria(ingredienteDTO);
        }
        return  caloriaTotal;
    }

    private Double getCaloria(IngredienteDTO ingredienteDTO){

        Double resp = null;
        for (Ingrediente ingrediente:ingredientesDAO.loadJson()){
            if ( ingrediente.getName().equals(ingredienteDTO.getNombre()) ){
                resp = (ingredienteDTO.getPeso() * ingrediente.getCalories())/100;
            }
        }
        return resp;
    }


    @Override
    public List<IngredienteRespDTO> getIngredienteCaloria(List<IngredienteDTO> listIngredientes){
        List<IngredienteRespDTO> listIngredienteRespDTOS = new ArrayList<>();
        for (IngredienteDTO ingredienteDTO: listIngredientes) {
            IngredienteRespDTO in = new IngredienteRespDTO();
            in.setName(ingredienteDTO.getNombre());
            in.setCalories(this.getCaloria(ingredienteDTO));
            listIngredienteRespDTOS.add(in);
        }
        return  listIngredienteRespDTOS;
    }


    @Override
    public IngredienteRespDTO getIngredienteMayorCaloria(List<IngredienteDTO> listIngredientes) {
        IngredienteRespDTO ingredienteRespDTO = new IngredienteRespDTO();
        Double mayCaloria = 0.0;
        for (IngredienteDTO ingrediente: listIngredientes) {
            if (mayCaloria < this.getCaloria(ingrediente)){
                mayCaloria = this.getCaloria(ingrediente);
                ingredienteRespDTO.setName(ingrediente.getNombre());
                ingredienteRespDTO.setCalories(mayCaloria);
            }
        }
        return ingredienteRespDTO;
    }
}
