package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_venta")
@Data
@NoArgsConstructor
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_detalle"))
	private Venta venta;
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_producto_detalle"))
	private Producto producto;
	@Positive(message = "{cantidad.positiva}")
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

}
