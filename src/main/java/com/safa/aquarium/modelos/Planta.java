package com.safa.aquarium.modelos;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "planta", schema = "aquarium")
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ficha")
    private String ficha;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoPlanta tipoPlanta;






}
