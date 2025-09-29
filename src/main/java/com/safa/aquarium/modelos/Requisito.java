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
@Table(name = "requisito",catalog = "postgres", schema = "aquarium")
public class Requisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_requisito")
    private TipoRequisito requisito;


}
