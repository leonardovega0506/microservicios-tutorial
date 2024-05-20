package com.usuario.service.model.entidades;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Carro {

    private String marca;
    private String model;
    private int usuarioId;
}


