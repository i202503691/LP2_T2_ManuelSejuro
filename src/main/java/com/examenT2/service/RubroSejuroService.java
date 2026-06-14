package com.examenT2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.model.RubroSejuro;
import com.examenT2.repository.RubroSejuroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RubroSejuroService {

	private final RubroSejuroRepository rubroSejuroRepository;

	public List<RubroSejuro> getAll() {
		return rubroSejuroRepository.findAll();
	}
}
