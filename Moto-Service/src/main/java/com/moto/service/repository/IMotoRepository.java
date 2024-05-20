package com.moto.service.repository;

import com.moto.service.model.MotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMotoRepository extends JpaRepository<MotoModel,Integer> {
    List<MotoModel> findByUsuarioId(int usuarioId);
}
