package com.moto.service.controller;

import com.moto.service.model.MotoModel;
import com.moto.service.service.IMotoService;
import com.moto.service.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {
    @Autowired
    private IMotoService sMoto;

    @GetMapping
    public ResponseEntity<List<MotoModel>> listarMotos(){
        List<MotoModel> motos = sMoto.getAll();
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(motos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoModel> obtenerMoto(@PathVariable("id") int id){
        MotoModel moto = sMoto.getMotoById(id);
        if(moto==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<MotoModel>> listarCarroByUsuarioId(@PathVariable(value = "id") int id){
        List<MotoModel> motos = sMoto.MotoByUsuarioByID(id);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }


    @PostMapping
    public ResponseEntity<MotoModel> guardarCarro(@RequestBody MotoModel moto){
        MotoModel nuevaMoto = sMoto.save(moto);
        return ResponseEntity.ok(nuevaMoto);
    }
}
