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
@Table(name="persona")
@Data
@NoArgsConstructor
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	@Size(min = 3, message = "{nombres.size}")
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;
	@Size(min = 3, message = "{apellidos.size}")
	@Column(name = "apellidos", nullable = false, length = 50)
	private String apellidos;

}
