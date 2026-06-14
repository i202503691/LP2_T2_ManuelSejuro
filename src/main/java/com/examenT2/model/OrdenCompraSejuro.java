package com.examenT2.model;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_orden_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class OrdenCompraSejuro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_orden")
	private Integer nroOrden;

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private ProveedorSejuro proveedor;

	@Column(name = "monto")
	private Double monto;

	@Column(name = "direccion_entrega")
	private String direccionEntrega;

	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;

	@Column(name = "estado")
	private String estado;

	public String getEstadoDescripcion() {
		if (estado == null) return "Pendiente";
		return switch (estado) {
			case "P" -> "Pendiente";
			case "C" -> "Completado";
			case "A" -> "Anulado";
			default -> "Desconocido";
		};
	}
}
