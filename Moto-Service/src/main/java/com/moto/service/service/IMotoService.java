package com.moto.service.service;

import com.moto.service.model.MotoModel;

import java.util.List;

public interface IMotoService {
    List<MotoModel> getAll();
    MotoModel getMotoById(int id);
    MotoModel save(MotoModel usuario);
    List<MotoModel> MotoByUsuarioByID(int usuarioId);
}
