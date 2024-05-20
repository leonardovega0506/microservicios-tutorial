package com.carro.service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_carro")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String marca;
    private String model;
    private int usuarioId;
}
