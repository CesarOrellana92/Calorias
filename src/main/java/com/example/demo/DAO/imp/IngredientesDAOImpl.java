package com.example.demo.DAO.imp;

import com.example.demo.DAO.IngredientesDAO;
import com.example.demo.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@Repository
public class IngredientesDAOImpl implements IngredientesDAO {



    @Override
    public  List<Ingrediente> loadJson() {

        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:static/food.json");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeReference = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;

        try{
            ingredientes = objectMapper.readValue(file,typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }

        return ingredientes;


    }
}
