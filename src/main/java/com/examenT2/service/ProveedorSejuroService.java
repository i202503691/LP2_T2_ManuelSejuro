package com.examenT2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.model.ProveedorSejuro;
import com.examenT2.repository.ProveedorSejuroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorSejuroService {

	private final ProveedorSejuroRepository proveedorSejuroRepository;

	public List<ProveedorSejuro> getAll() {
		return proveedorSejuroRepository.findAll();
	}
}
