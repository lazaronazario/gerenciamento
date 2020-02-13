package br.com.costaduarteempilhadeiras.cadastromaquina.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD
import javax.validation.constraints.NotNull;
=======
>>>>>>> parent of 3643867... validações na view

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_veiculo")
	private Long IdVeiculo;

	@Column(name = "empresa", length = 30, nullable = false)
	private String empresa;

	@Column(name = "modelo", length = 30, nullable = false)
	private String modelo;

	@Column(name = "ano", length = 4, nullable = false)
	private int ano;

	@Column(name = "dataManutencao", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataManutencao;

	@Column(name = "peca", length = 50, nullable = false)
	private String peca;

	@Column(name = "descricaoManutencao", length = 180, nullable = false)
	private String descricaoManutencao;

	public Long getIdVeiculo() {
		return IdVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		IdVeiculo = idVeiculo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getPeca() {
		return peca;
	}

	public void setPeca(String peca) {
		this.peca = peca;
	}

	public String getDescricaoManutencao() {
		return descricaoManutencao;
	}

	public void setDescricaoManutencao(String descricaoManutencao) {
		this.descricaoManutencao = descricaoManutencao;
	}

	@Override
	public String toString() {
		return "Veiculo [IdVeiculo=" + IdVeiculo + ", empresa=" + empresa + ", modelo=" + modelo + ", ano=" + ano
				+ ", dataManutencao=" + dataManutencao + ", peca=" + peca + ", descricaoManutencao="
				+ descricaoManutencao + "]";
	}

}
