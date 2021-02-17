package com.example.demo.services;

import com.example.demo.DTO.IngredienteRespDTO;
import com.example.demo.DTO.PlatoCaloriasTotalDTO;
import com.example.demo.DTO.PlatosDTO;
import com.example.demo.services.impl.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    IngredienteServiceImpl ingredienteService;

    @Override
    public PlatoCaloriasTotalDTO getCaloriaTotal(PlatosDTO platosDTO) {
        PlatoCaloriasTotalDTO platoCaloriasTotalDTO = new PlatoCaloriasTotalDTO();
        platoCaloriasTotalDTO.setNombre(platosDTO.getNombre());
        platoCaloriasTotalDTO.setCaloriaTotal(ingredienteService.getCaloriaTotal(platosDTO.getIngredientes()));
        return platoCaloriasTotalDTO;
    }

    @Override
    public List<IngredienteRespDTO> getIngredientes(PlatosDTO platosDTO) {

        return ingredienteService.getIngredienteCaloria(platosDTO.getIngredientes());
    }

    @Override
    public IngredienteRespDTO getMayorIngrediente(PlatosDTO platosDTO) {
        return ingredienteService.getIngredienteMayorCaloria(platosDTO.getIngredientes());
    }
}
