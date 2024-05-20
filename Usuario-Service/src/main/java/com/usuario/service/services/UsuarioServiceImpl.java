package com.usuario.service.services;

import com.usuario.service.feignClient.CarroFeignClient;
import com.usuario.service.feignClient.MotoFeignClient;
import com.usuario.service.model.UsuarioModel;
import com.usuario.service.model.entidades.Carro;
import com.usuario.service.model.entidades.Moto;
import com.usuario.service.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IUsuarioRepository iUsuario;

    @Autowired
    private CarroFeignClient carroFC;

    @Autowired
    private MotoFeignClient motoFC;

    public List<Carro> getCarros(int usuarioId) {
        List<Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/usuario/" + usuarioId, List.class);
        return carros;
    }

    public List<Moto> getMotos(int usuarioId) {
        List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
        return motos;
    }

    public Carro saveCarro(int usuarioId, Carro carro) {
        carro.setUsuarioId(usuarioId);
        Carro nuevoCarro = carroFC.save(carro);
        return nuevoCarro;
    }

    public Moto saveMoto(int usuarioId, Moto moto) {
        moto.setUsuarioId(usuarioId);
        Moto nuevaMoto = motoFC.save(moto);
        return nuevaMoto;
    }

    public List<UsuarioModel> getAll() {
        return iUsuario.findAll();
    }

    public UsuarioModel getUsuarioById(int id) {
        return iUsuario.findById(id).orElseThrow();
    }

    public UsuarioModel save(UsuarioModel usuario) {
        UsuarioModel nuevoUsuario = iUsuario.save(usuario);
        return nuevoUsuario;
    }
}
