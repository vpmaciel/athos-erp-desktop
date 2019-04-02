package erp.curriculo.experienciaprofissional;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class ExperienciaProfissional implements Serializable {
	@Id
	private Long id;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = true)
	private Funcionario funcionario;
	@Column(length = 50)
	private String empresa;
	@Column(length = 50)
	private String cargo;
	@Column(length = 10)
	private String dataAdmissao;
	@Column(length = 10)
	private String dataSaida;
	@Column(length = 50)
	private String nivelHierarquico;
	@Column(length = 500)
	private String funcoes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getNivelHierarquico() {
		return nivelHierarquico;
	}
	public void setNivelHierarquico(String nivelHierarquico) {
		this.nivelHierarquico = nivelHierarquico;
	}
	public String getFuncoes() {
		return funcoes;
	}
	public void setFuncoes(String funcoes) {
		this.funcoes = funcoes;
	}
}