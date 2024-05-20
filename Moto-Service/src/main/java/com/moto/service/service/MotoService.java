package com.moto.service.service;

import com.moto.service.model.MotoModel;
import com.moto.service.repository.IMotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService implements IMotoService{

    @Autowired
    private IMotoRepository iMoto;

    @Override
    public List<MotoModel> getAll() {
        return iMoto.findAll();
    }

    @Override
    public MotoModel getMotoById(int id) {
        return iMoto.findById(id).orElseThrow();
    }

    @Override
    public MotoModel save(MotoModel usuario) {
        return iMoto.save(usuario);
    }

    @Override
    public List<MotoModel> MotoByUsuarioByID(int usuarioId) {
        return iMoto.findByUsuarioId(usuarioId);
    }
}
