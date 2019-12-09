package br.com.costaduarteempilhadeiras.cadastromaquina.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class FuncionarioController {
	
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/funcionario/listar");
		mv.addObject("Mensagem","mensagem");
		return mv;
}
}
