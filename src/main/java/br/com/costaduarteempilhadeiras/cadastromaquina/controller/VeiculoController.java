package br.com.costaduarteempilhadeiras.cadastromaquina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.costaduarteempilhadeiras.cadastromaquina.repositories.RepositorioVeiculo;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private RepositorioVeiculo repositorioVeiculo;

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/veiculo/listar");
		mv.addObject("veiculos", repositorioVeiculo.findAll());
		return mv;
	}
}
