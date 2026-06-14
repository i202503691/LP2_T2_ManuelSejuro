package com.examenT2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.model.OrdenCompraSejuro;
import com.examenT2.service.OrdenCompraSejuroService;
import com.examenT2.service.ProveedorSejuroService;
import com.examenT2.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("orden")
public class OrdenCompraSejuroController {

	private final OrdenCompraSejuroService ordenCompraSejuroService;
	private final ProveedorSejuroService proveedorSejuroService;

	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstOrdenes", ordenCompraSejuroService.getAll());
		return "Producto/listadoSejuro";
	}

	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("proveedores", proveedorSejuroService.getAll());
		model.addAttribute("orden", new OrdenCompraSejuro());
		return "Producto/nuevoSejuro";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompraSejuro orden, Model model, RedirectAttributes flash) {

		var response = ordenCompraSejuroService.create(orden);

		if (!response.success()) {
			model.addAttribute("proveedores", proveedorSejuroService.getAll());
			model.addAttribute("orden", orden);
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			return "Producto/nuevoSejuro";
		}

		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast", toast);
		return "redirect:/orden/listado";
	}

	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("proveedores", proveedorSejuroService.getAll());
		model.addAttribute("orden", ordenCompraSejuroService.getOne(id));
		return "Producto/edicionSejuro";
	}

	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompraSejuro orden, Model model, RedirectAttributes flash) {

		var response = ordenCompraSejuroService.update(orden);

		if (!response.success()) {
			model.addAttribute("proveedores", proveedorSejuroService.getAll());
			model.addAttribute("orden", orden);
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			return "Producto/edicionSejuro";
		}

		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast", toast);
		return "redirect:/orden/listado";
	}
}
