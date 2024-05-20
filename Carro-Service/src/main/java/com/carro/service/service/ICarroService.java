package com.carro.service.service;

import com.carro.service.model.CarroModel;

import java.util.List;

public interface ICarroService {

    List<CarroModel> getAll();
    CarroModel getUsuarioById(int id);
    CarroModel save(CarroModel usuario);
    List<CarroModel> CarroByUsuarioByID(int usuarioId);
}
