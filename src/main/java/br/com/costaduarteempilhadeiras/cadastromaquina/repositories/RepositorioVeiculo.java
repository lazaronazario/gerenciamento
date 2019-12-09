package br.com.costaduarteempilhadeiras.cadastromaquina.repositories;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.costaduarteempilhadeiras.cadastromaquina.model.Veiculo;

public interface RepositorioVeiculo extends JpaRepository<Veiculo, Long>{

}
