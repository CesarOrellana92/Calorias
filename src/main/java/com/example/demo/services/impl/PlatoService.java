package com.example.demo.services.impl;

import com.example.demo.DTO.IngredienteRespDTO;
import com.example.demo.DTO.PlatoCaloriasTotalDTO;
import com.example.demo.DTO.PlatosDTO;

import java.util.List;

public interface PlatoService {

    public PlatoCaloriasTotalDTO getCaloriaTotal(PlatosDTO platosDTO);

    public List<IngredienteRespDTO> getIngredientes(PlatosDTO platosDTO);

    public IngredienteRespDTO getMayorIngrediente(PlatosDTO platosDTO);
}
