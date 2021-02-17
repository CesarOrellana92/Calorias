package com.example.demo.controllers;


import com.example.demo.DTO.ComidaResponseDTO;
import com.example.demo.DTO.IngredienteRespDTO;
import com.example.demo.DTO.PlatoCaloriasTotalDTO;
import com.example.demo.DTO.PlatosDTO;
import com.example.demo.services.PlatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
public class ComidaController {

    @Autowired
    PlatoServiceImpl platoService;

    @PostMapping("/caloriasTotal")
    public PlatoCaloriasTotalDTO getCaloria (@RequestBody PlatosDTO platosDTO) {
        return platoService.getCaloriaTotal(platosDTO);
    }




    @PostMapping("/ingredientes")
    public List<IngredienteRespDTO> getIngredientes (@RequestBody PlatosDTO platosDTO) {
        return platoService.getIngredientes(platosDTO);
    }

    @PostMapping("/ingredienteMayorCaloria")
    public IngredienteRespDTO getIngredienteMayor (@RequestBody PlatosDTO platosDTO) {
        return platoService.getMayorIngrediente(platosDTO);
    }


    


}
