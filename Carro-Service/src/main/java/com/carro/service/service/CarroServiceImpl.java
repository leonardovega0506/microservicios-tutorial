package com.carro.service.service;

import com.carro.service.model.CarroModel;
import com.carro.service.repository.ICarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements ICarroService{

    @Autowired
    private ICarroRepository iCarro;

    public List<CarroModel> getAll(){
        return iCarro.findAll();
    }

    public CarroModel getUsuarioById(int id){
        return iCarro.findById(id).orElseThrow();
    }

    public CarroModel save(CarroModel usuario){
        CarroModel nuevoUsuario = iCarro.save(usuario);
        return nuevoUsuario;
    }

    public List<CarroModel> CarroByUsuarioByID(int usuarioId){
        return iCarro.findByUsuarioId(usuarioId);
    }
}
