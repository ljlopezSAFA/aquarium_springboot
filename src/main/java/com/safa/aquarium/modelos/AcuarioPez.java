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
@Table(name = "acuario_pez", schema = "aquarium")
public class AcuarioPez {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "cantidad_macho")
    private Integer cantidadMacho;

    @Column(name = "cantidad__hembra")
    private Integer cantidadHembra;

    @ManyToOne
    @JoinColumn(name = "id_pez")
    private Pez pez;

    @ManyToOne
    @JoinColumn(name = "id_acuario")
    private Acuario acuario;




}
