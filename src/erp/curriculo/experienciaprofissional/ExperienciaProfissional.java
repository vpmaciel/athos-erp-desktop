package erp.curriculo.experienciaprofissional;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class ExperienciaProfissional implements Serializable {
	@Column(length = 50)
	private String cargo;
	@Column(length = 10)
	private String dataAdmissao;
	@Column(length = 10)
	private String dataSaida;
	@Column(length = 50)
	private String empresa;
	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	@Column(length = 500)
	private String funcoes;
	@Id
	private Long id;
	@Column(length = 50)
	private String nivelHierarquico;

	public String getCargo() {
		return cargo;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public String getEmpresa() {
		return empresa;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public String getFuncoes() {
		return funcoes;
	}

	public Long getId() {
		return id;
	}

	public String getNivelHierarquico() {
		return nivelHierarquico;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setFuncoes(String funcoes) {
		this.funcoes = funcoes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNivelHierarquico(String nivelHierarquico) {
		this.nivelHierarquico = nivelHierarquico;
	}
}