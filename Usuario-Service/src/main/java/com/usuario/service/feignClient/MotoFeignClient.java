package com.usuario.service.feignClient;

import com.usuario.service.model.entidades.Carro;
import com.usuario.service.model.entidades.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "moto-service")
public interface MotoFeignClient {

    @PostMapping("/moto")
    Moto save(@RequestBody Moto carro);
}