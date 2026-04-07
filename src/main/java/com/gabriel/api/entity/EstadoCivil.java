package com.gabriel.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estados_civis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;
}