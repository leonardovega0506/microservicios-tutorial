package com.usuario.service.feignClient;

import com.usuario.service.model.entidades.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "Carro-Service", url = "http://localhost:8002")
public interface CarroFeignClient {

    @PostMapping("/carro")
    Carro save(@RequestBody Carro carro);
}