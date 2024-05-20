package com.usuario.service.controller;

import com.usuario.service.model.UsuarioModel;
import com.usuario.service.model.entidades.Carro;
import com.usuario.service.model.entidades.Moto;
import com.usuario.service.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService sUsuario;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarUsuarios(){
        List<UsuarioModel> usuarios = sUsuario.getAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuario(@PathVariable("id") int id){
        UsuarioModel usuario = sUsuario.getUsuarioById(id);
        if(usuario==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/carros/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarros(@PathVariable("usuarioId") int usuarioId){
        UsuarioModel usuario = sUsuario.getUsuarioById(usuarioId);
        if(usuario==null){
            return ResponseEntity.notFound().build();
        }
        List<Carro> carros = sUsuario.getCarros(usuarioId);
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/motos/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") int usuarioId){
        UsuarioModel usuario = sUsuario.getUsuarioById(usuarioId);
        if(usuario==null){
            return ResponseEntity.notFound().build();
        }
        List<Moto> motos = sUsuario.getMotos(usuarioId);
        return ResponseEntity.ok(motos);
    }



    @PostMapping
    public ResponseEntity<UsuarioModel> guardarUsuario(@RequestBody UsuarioModel usuario){
        UsuarioModel nuevoUsuario = sUsuario.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @PostMapping("/carro/{usuarioId}")
    public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") int usuarioId, @RequestBody Carro carro){
        Carro nuevoCarro = sUsuario.saveCarro(usuarioId,carro);
        return ResponseEntity.ok(nuevoCarro);
    }

    @PostMapping("/moto/{usuarioId}")
    public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") int usuarioId, @RequestBody Moto moto){
        Moto nuevaMoto = sUsuario.saveMoto(usuarioId,moto);
        return ResponseEntity.ok(nuevaMoto);
    }
}
