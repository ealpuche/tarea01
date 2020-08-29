package com.mitocode.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venta")
@Data
@NoArgsConstructor
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idVenta;
	@PastOrPresent(message = "{validacion.fecha.futura}")
	@Column(name = "fecha",  nullable = false)
	private LocalDateTime fecha;
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false, foreignKey = @ForeignKey(name = "fk_venta_persona"))
	private Persona persona;
	@Positive(message = "{importe.positivo}")
	@Column(name = "importe", nullable = false)
	private Double importe;
	@OneToMany(mappedBy = "venta", cascade = {CascadeType.ALL}, orphanRemoval = true)
	private List<DetalleVenta> detalleVenta;
}
