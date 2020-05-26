package com.uca.capas.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	LibroService libroService;
	
	@GetMapping("/index")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/categoriaFormulario")
	public ModelAndView categoriaFormulario() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("formCategoria");
		return mav;
	}
	
	@PostMapping("/ingresarCategoria")
	public ModelAndView ingresar(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) { 
			try {
				mav.setViewName("formCategoria");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {	
			try {
				categoriaService.insertar(categoria);
				
				mav.addObject("exito", "Categoria guardada con éxito");
				mav.setViewName("index");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return mav;
	
	}
}
