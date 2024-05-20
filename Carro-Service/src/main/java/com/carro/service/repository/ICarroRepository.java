package com.carro.service.repository;

import com.carro.service.model.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarroRepository extends JpaRepository<CarroModel,Integer> {
    List<CarroModel> findByUsuarioId(int usuarioId);
}
