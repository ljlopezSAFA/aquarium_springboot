package com.safa.aquarium.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"plantas", "usuario", "peces"})
@EqualsAndHashCode(exclude = {"plantas", "usuario", "peces"})
@Entity
@Table(name = "acuario", catalog = "postgres", schema = "aquarium")
public class Acuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "foto")
    private String foto;

    @Column(name = "capacidad")
    private Double capacidad;

    @Column(name = "medidas")
    private String medidas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "planta_acuario", catalog = "postgres", schema = "aquarium",
            joinColumns = {@JoinColumn(name = "id_acuario", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_planta", nullable = false)})
    private Set<Planta> plantas;


    @OneToMany(mappedBy = "acuario")
    private Set<AcuarioPez> peces;


}
