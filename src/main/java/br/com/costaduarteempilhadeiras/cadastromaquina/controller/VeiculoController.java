package br.com.costaduarteempilhadeiras.cadastromaquina.controller;

<<<<<<< HEAD
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
=======
import javax.validation.ReportAsSingleViolation;

>>>>>>> parent of 3643867... validações na view
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		mv.addObject("veiculo", new Veiculo());
		return mv;
	}
	
	@PostMapping("/inserir")
<<<<<<< HEAD
	public ModelAndView inserir(@Valid Veiculo veiculo, BindingResult result) {
		ModelAndView mv = new ModelAndView();

		if (veiculo.getDataManutencao() == null) {
			result.rejectValue("dataManutencao", "veiculo.DataExpericacaoInvalida",
					"A data de manutenção não pode ser posterior a data atual!");
		} else {
			if (veiculo.getDataManutencao().after(new Date())) {
				result.rejectValue("dataManutencao", "veiculo.DataExpericacaoInvalida",
						"A data de manutenção não pode ser posterior a data atual!");
			}
		}
		
//		if (veiculos.getEmpresa() == null || veiculos.getEmpresa().length() < 3) {
//			result.rejectValue("Empresa", "veiculo.EmpresaInvalida", "Favor preencher corretamente o nome da empresa!");
//		}

		if (result.hasErrors()) {
			mv.setViewName("veiculo/inserir");	
			mv.addObject(veiculo);		
		} else {
			mv.setViewName("redirect:/veiculo/listar");
			repositorioVeiculo.save(veiculo);
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
=======
	public String inserir(Veiculo veiculo) {
		repositorioVeiculo.save(veiculo);
>>>>>>> parent of 3643867... validações na view
		return "redirect:/veiculo/listar";
	}
}
