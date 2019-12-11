package br.com.costaduarteempilhadeiras.cadastromaquina.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ReportAsSingleViolation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.costaduarteempilhadeiras.cadastromaquina.model.Veiculo;
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

	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/veiculo/inserir");
		mv.addObject("veiculos", new Veiculo());
		return mv;
	}

	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Veiculo veiculos, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (veiculos.getDataManutencao() == null) {
			result.rejectValue("dataManutencao", "veiculo.DataExpericacaoInvalida",
					"A data de manutenção não pode ser posterior a data atual!");
		} else {
			if (veiculos.getDataManutencao().after(new Date())) {
				result.rejectValue("dataManutencao", "veiculo.DataExpericacaoInvalida",
						"A data de manutenção não pode ser posterior a data atual!");
			}
		}
		
		if (veiculos.getEmpresa() == null || veiculos.getEmpresa().length() < 3) {
			result.rejectValue("Empresa", "veiculo.EmpresaInvalida", "Favor preencher corretamente o nome da empresa!");
		}

		if (result.hasErrors()) {
			mv.setViewName("veiculo/inserir");
			mv.addObject(veiculos);
		} else {
			mv.setViewName("redirect:/veiculo/listar");
			repositorioVeiculo.save(veiculos);
		}
		return mv;
	}

	@PostMapping("/alterar")
	public ModelAndView alterar(@Valid Veiculo veiculos, BindingResult result) {
		ModelAndView mv = new ModelAndView();

		if (veiculos.getDataManutencao() == null) {
			result.rejectValue("dataManutencao", "veiculo.DataExpericacaoInvalida",
					"A data de manutenção não pode ser posterior a data atual!");
		} else {
			if (veiculos.getDataManutencao().after(new Date())) {
				result.rejectValue("dataManutencao", "veiculo.DataExpericacaoInvalida",
						"A data de manutenção não pode ser posterior a data atual!");
			}
		}

		if (result.hasErrors()) {
			mv.setViewName("veiculo/alterar");
			mv.addObject(veiculos);
		} else {
			mv.setViewName("redirect:/veiculo/listar");
			repositorioVeiculo.save(veiculos);
		}
		return mv;
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		repositorioVeiculo.deleteById(id);
		return "redirect:/veiculo/listar";
	}
}
