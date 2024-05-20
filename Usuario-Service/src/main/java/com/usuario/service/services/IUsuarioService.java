package com.usuario.service.services;

import com.usuario.service.model.UsuarioModel;
import com.usuario.service.model.entidades.Carro;
import com.usuario.service.model.entidades.Moto;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioModel> getAll();
    UsuarioModel getUsuarioById(int id);
    List<Carro> getCarros(int usuarioId);
    List<Moto> getMotos(int usuarioId);
    UsuarioModel save(UsuarioModel usuario);
    Carro saveCarro(int usuarioId, Carro carro);
    Moto saveMoto(int usuarioId, Moto moto);
}
