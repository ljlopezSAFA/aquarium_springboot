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
@Table(name = "pez",catalog = "postgres", schema = "aquarium")
public class Pez {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_comun")
    private String nombreComun;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "especie")
    @Enumerated(EnumType.ORDINAL)
    private Especie especie;

    @Column(name = "ficha")
    private String ficha;





}
