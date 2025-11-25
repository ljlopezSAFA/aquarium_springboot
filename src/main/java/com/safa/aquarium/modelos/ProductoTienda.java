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
@Table(name = "producto_tienda", catalog = "postgres", schema = "aquarium")
public class ProductoTienda {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;


    @ManyToOne
    @JoinColumn(name = "id_tienda")
    private Tienda tienda;



}
