package com.safa.aquarium.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table( schema = "aquarium", name = "pedido")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"lineas"})
@ToString(exclude = {"lineas"})
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="codigo")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido")
    private Set<LineaPedido> lineas;





}
