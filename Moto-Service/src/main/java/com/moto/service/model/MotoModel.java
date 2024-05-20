package com.moto.service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_moto")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class MotoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String marca;
    private int usuarioId;
}
