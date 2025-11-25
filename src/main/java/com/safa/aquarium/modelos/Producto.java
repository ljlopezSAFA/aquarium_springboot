package com.safa.aquarium.modelos;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto", catalog = "postgres", schema = "aquarium")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "url_imagen")
    private String urlImagen;

    @ManyToOne
    @JoinColumn(name="id_marca")
    private Marca marca;


}
