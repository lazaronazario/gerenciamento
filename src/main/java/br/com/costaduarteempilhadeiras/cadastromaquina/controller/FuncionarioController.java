package br.com.costaduarteempilhadeiras.cadastromaquina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.costaduarteempilhadeiras.cadastromaquina.model.Funcionario;
import br.com.costaduarteempilhadeiras.cadastromaquina.model.Veiculo;
import br.com.costaduarteempilhadeiras.cadastromaquina.repositories.RepositorioFuncionario;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private RepositorioFuncionario repositorioFuncionario ;

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/funcionario/listar");
		mv.addObject("funcionarios", repositorioFuncionario.findAll());
		return mv;
	}
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/funcionario/inserir");
		mv.addObject("funcionarios", new Funcionario());
		return mv;
	}
	
	@PostMapping("/inserir")
	public String inserir(Funcionario funcionario) {
		repositorioFuncionario.save(funcionario);
		return "redirect:/funcionario/listar";
	}	
}
