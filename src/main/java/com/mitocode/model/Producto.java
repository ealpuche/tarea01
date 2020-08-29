package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	@Size(min = 3, message = "{nombre.producto.size}")
	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;
	@Size(min = 3, message = "{marca.size}")
	@Column(name = "marca", nullable = false, length = 70)
	private String marca;
}
