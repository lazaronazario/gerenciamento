package br.com.costaduarteempilhadeiras.cadastromaquina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.costaduarteempilhadeiras.cadastromaquina.model.Funcionario;

public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long> {
	
	

}
