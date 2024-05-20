package com.carro.service.controller;

import com.carro.service.model.CarroModel;
import com.carro.service.service.ICarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private ICarroService sCarro;

    @GetMapping
    public ResponseEntity<List<CarroModel>> listarCarros(){
        List<CarroModel> carros = sCarro.getAll();
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroModel> obtenerCarro(@PathVariable("id") int id){
        CarroModel carro = sCarro.getUsuarioById(id);
        if(carro==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<CarroModel>> listarCarroByUsuarioId(@PathVariable(value = "id") int id){
        List<CarroModel> carros = sCarro.CarroByUsuarioByID(id);
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }


    @PostMapping
    public ResponseEntity<CarroModel> guardarCarro(@RequestBody CarroModel carro){
        CarroModel nuevoCarro = sCarro.save(carro);
        return ResponseEntity.ok(nuevoCarro);
    }
}
