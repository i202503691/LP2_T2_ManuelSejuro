package com.examenT2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.dto.ResultadoResponse;
import com.examenT2.model.OrdenCompraSejuro;
import com.examenT2.repository.OrdenCompraSejuroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraSejuroService {

	private final OrdenCompraSejuroRepository ordenCompraSejuroRepository;

	public List<OrdenCompraSejuro> getAll() {
		return ordenCompraSejuroRepository.findAllByOrderByNroOrdenDesc();
	}

	public ResultadoResponse create(OrdenCompraSejuro orden) {
		try {
			var registro = ordenCompraSejuroRepository.save(orden);
			var mensaje = String.format("Orden de compra Nro. %s registrada.", registro.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}

	public OrdenCompraSejuro getOne(Integer nroOrden) {
		return ordenCompraSejuroRepository.findById(nroOrden).orElseThrow();
	}

	public ResultadoResponse update(OrdenCompraSejuro orden) {
		try {
			var registro = ordenCompraSejuroRepository.save(orden);
			var mensaje = String.format("Orden de compra Nro. %s actualizada.", registro.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
}
