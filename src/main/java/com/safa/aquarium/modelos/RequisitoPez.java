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
@Table(name = "requisito_pez", schema = "aquarium")
public class RequisitoPez {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "importancia")
    @Enumerated(EnumType.ORDINAL)
    private Importancia importancia;

    @JoinColumn(name = "id_requisito")
    @ManyToOne
    private Requisito requisito;


    @JoinColumn(name = "id_pez")
    @ManyToOne
    private Pez pez;

}
